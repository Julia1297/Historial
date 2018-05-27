package com.registromedico.springboot.app.controllers;

import com.registromedico.springboot.app.GeneratePdfReport;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import java.io.ByteArrayInputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.crypto.codec.Base64;

import com.registromedico.springboot.app.entities.Foto;
import com.registromedico.springboot.app.entities.FotoRegistro;
import com.registromedico.springboot.app.entities.Observacion;
import com.registromedico.springboot.app.entities.RegistroMedico;
import com.registromedico.springboot.app.services.CategoriaService;
import com.registromedico.springboot.app.services.FotoRegistroService;
import com.registromedico.springboot.app.services.ObservacionService;
import com.registromedico.springboot.app.services.RegistroMedicoService;
import com.registromedico.springboot.app.services.UserService;


@Controller
public class RegistroMedicoController {
	private RegistroMedicoService registroMedicoService;
    private FotoRegistroService fotoRegistroService;
    private ObservacionService observacionService;
    private CategoriaService categoriaService;
    private UserService userService;
    private RegistroMedico reg;
    
    
    
    
    @Autowired
    public void setObservacionService(ObservacionService observacionService){ this.observacionService = observacionService; }
    @Autowired
    public void setFotoRegistroService(FotoRegistroService fotoRegistroService){ this.fotoRegistroService = fotoRegistroService; }
    @Autowired
    public void setRegistroMedicoService(RegistroMedicoService registroMedicoService){ this.registroMedicoService = registroMedicoService; }
    @Autowired
    public void setCategoriaService(CategoriaService categoriaService){ this.categoriaService = categoriaService; }
    @Autowired
    public void setUserService(UserService userService){ this.userService = userService; }

    
    

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	@RequestMapping(value = "/miHistorial", method = RequestMethod.GET)
	public String historial(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((User)auth.getPrincipal()).getUsername();
        com.registromedico.springboot.app.entities.User user = userService.findByUsername(username);
        model.addAttribute("user",user);
		return "miHistorial";
	}
	
	
	
	
	@RequestMapping(value = "/miHistorial/nuevoRegistro", method = RequestMethod.GET)
    String nuevoRegistro(Model model){
		model.addAttribute("categorias",categoriaService.listAllCategories());
        return "nuevoRegistro";
    }
	@RequestMapping(value = "/miHistorial/registro", method = RequestMethod.POST)
	String saveRegistro( RegistroMedico registroMedico, @RequestParam("file") MultipartFile[] files) throws IOException {        
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username =((User)auth.getPrincipal()).getUsername();
		com.registromedico.springboot.app.entities.User user = userService.findByUsername(username);
		registroMedico.setUser(user);
		registroMedicoService.saveRegistroMedico(registroMedico);
		byte[] f;
        for(int i=0; i<files.length; i++){
            if(!files[i].isEmpty()){
                f = files[i].getBytes();
                FotoRegistro fotoRegistro = new FotoRegistro();
                fotoRegistro.setRegistroMedico(registroMedico);
                fotoRegistro.setFoto(f);
                fotoRegistroService.saveFotoRegistro(fotoRegistro);
            }
        }
		return "redirect:/miHistorial";
	}
	
	
	
	
	@GetMapping(value = "/miHistorial/mostrarRegistro/{id}")
    String mostrarRegistro(@PathVariable Integer id, Model model) throws UnsupportedEncodingException {
		RegistroMedico registroMedico = registroMedicoService.getRegistroMedico(id);
        List<Foto> fotos = new ArrayList<Foto>();
        List<FotoRegistro> fotoRegistros = (List<FotoRegistro>)registroMedico.getFotoRegistroList();
        byte[] bytes;
        String foto;
        for(int i=0; i<fotoRegistros.size(); i++){
            bytes = Base64.encode(fotoRegistros.get(i).getFoto());
            foto = new String(bytes,"UTF-8");
            fotos.add(new Foto(fotoRegistros.get(i).getId(),foto));
        }

        model.addAttribute("registroMedico",registroMedico);
        model.addAttribute("fotos",fotos);
		return "mostrarRegistro";
    }
	@RequestMapping("/miHistorial/editarRegistro/{id}")
	String editarRegistro(@PathVariable  Integer id, Model model) throws UnsupportedEncodingException {
		RegistroMedico registroMedico = registroMedicoService.getRegistroMedico(id);
        List<Foto> fotos = new ArrayList<Foto>();
        List<FotoRegistro> fotoRegistros = (List<FotoRegistro>)registroMedico.getFotoRegistroList();
        byte[] bytes;
        String foto;
        for(int i=0; i<fotoRegistros.size(); i++){
            bytes = Base64.encode(fotoRegistros.get(i).getFoto());
            foto = new String(bytes,"UTF-8");
            fotos.add(new Foto(fotoRegistros.get(i).getId(),foto));
        }

        model.addAttribute("registro", registroMedico);
        model.addAttribute("fotos",fotos);
        model.addAttribute("categorias",categoriaService.listAllCategories());
        reg = registroMedico;
		return "editarRegistro";
	}
	@RequestMapping("/miHistorial/eliminarRegistro/{id}")
    String eliminarRegistro(@PathVariable Integer id){
		registroMedicoService.deleteRegistroMedico(id);
        return "redirect:/miHistorial";
    }
	
	
	
	
	@RequestMapping("/miHistorial/eliminarFoto/{id}")
    String eliminarFoto(@PathVariable Integer id){
        fotoRegistroService.deleteFotoRegistro(id);
        return "redirect:/miHistorial/editarRegistro/" + reg.getId();
    }
    @RequestMapping(value = "/miHistorial/agregarObservacion",method = RequestMethod.POST)
    String agregarObservacion(Observacion observacion){
        observacion.setRegistroMedico(reg);
        java.util.Date d = new java.util.Date();
        java.sql.Date d2 = new java.sql.Date(d.getTime());
        observacion.setFecha(d2);
        observacionService.saveObservacion(observacion);
        return "redirect:/miHistorial/editarRegistro/" + reg.getId();
    }
    @RequestMapping("/miHistorial/eliminarObservacion/{id}")
    String eliminarObservacion(@PathVariable Integer id){
        observacionService.deleteObservacion(id);
        return "redirect:/miHistorial/editarRegistro/" + reg.getId();
    }
	
    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,  produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> historialReport() throws IOException {

        List<RegistroMedico> registroMedicos = (List<RegistroMedico>) registroMedicoService.listAllRegistroMedico();

        ByteArrayInputStream bis = GeneratePdfReport.historialReport(registroMedicos);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=historialReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
    @RequestMapping(value = "/registroMedico/pdfreport/{id}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> registroReport(@PathVariable  Integer id) throws IOException {
		RegistroMedico registroMedico = registroMedicoService.getRegistroMedico(id);
        ByteArrayInputStream bis = GeneratePdfReport.registroReport(registroMedico);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=registroReport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
