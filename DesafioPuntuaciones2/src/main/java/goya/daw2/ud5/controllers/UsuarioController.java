package goya.daw2.ud5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import goya.daw2.ud5.model.Usuario;
import goya.daw2.ud5.model.Puntuacion;
import goya.daw2.ud5.repositories.RepositorioPuntuacion;
import goya.daw2.ud5.repositories.RepositorioUsuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {
	@Autowired
	RepositorioUsuario repositorioUsuario;
	@Autowired
	RepositorioPuntuacion repositorioPuntuacion;
	/*@GetMapping("/creaUsuario")
	String Crea() {
		Usuario david = new Usuario("David Barroso");
		
		Puntuacion puntuacion = new Puntuacion(25);
		javi.anadirEmails(email1);
		javi.anadirEmails(email2);
		//javi.setNombre();
		//repositorioEmail.save(email1);
		//repositorioEmail.save(email2);
		 
		repositorioUsuario.save(david);
		return "prueba";
	}*/
	@GetMapping("/")
	String inicio() {
		//return "redirect:/creaUsuario";
		return "creaUsuario";
	}
	@GetMapping("/creaUsuario")
	String inicio2() {
		return "creaUsuario";
	}
	/*@GetMapping("/juego")
	String juego2(HttpServletRequest request, Model modelo) {
		HttpSession misession = request.getSession();
		Usuario usuario = (Usuario)misession.getAttribute("usuario");
		modelo.addAttribute("usuario",usuario);
		return "juego";
	}*/
	@PostMapping("/juego")
	  public String creaUsuario(@Valid Usuario usuario, Model modelo,HttpServletRequest request) {
		HttpSession misession = request.getSession(true);
		//repositorioUsuario.save(usuario);
		List<Usuario> usuarios = repositorioUsuario.findByNombre(usuario.getNombre());
			if(usuarios.isEmpty()) {
				repositorioUsuario.save(usuario);
				System.out.println("Añadido nuevo usuario");
			}else {
				usuario = usuarios.get(0);	
				System.out.println("Usuario ya existente"+ usuario.toString());
			
			}
			misession.setAttribute("usuario",usuario);
	    //return "redirect:/juego";
	    return "juego";
	  }
	
	@PostMapping("/tablaResultados")
	  public String juego(@Valid Puntuacion puntuacion, Model modelo,HttpServletRequest request) {
		HttpSession misession = request.getSession();
		Usuario usuario = (Usuario)misession.getAttribute("usuario");
		//Usuario usuario2 = usuario.devuelveUsuario(repositorioUsuario,usuario.getNombre());
		
		//System.out.println("IMPORTANTE"+usuario2.toString());
		System.out.println("IMPORTANTE"+usuario.toString());
		  //modelo.addAttribute("usuario", usuario);
		usuario.anadirPuntuacion(puntuacion);
		misession.setAttribute("usuario", usuario);
		repositorioUsuario.save(usuario);
		List<Usuario> usuarios = repositorioUsuario.buscaTodosUsuarios();
		List<Puntuacion> puntuaciones =repositorioPuntuacion.buscaTodasPuntuaciones();
		modelo.addAttribute("puntuaciones",puntuaciones);
		modelo.addAttribute("usuarios",usuarios);
		
		modelo.addAttribute("usuario",usuario);
	    //return "redirect:/tablaResultados";
	    return "tablaResultados";
	  }
	/*@GetMapping("/tablaResultados")
	String tablaResultados(HttpServletRequest request, Model modelo) {
		HttpSession misession = request.getSession();
		Usuario usuario = (Usuario)misession.getAttribute("usuario");
		//List<Usuario> usuarios = repositorioUsuario.findByNombre(usuario.getNombre());
		List<Usuario> usuarios = repositorioUsuario.buscaTodosUsuarios();
		modelo.addAttribute("usuarios",usuarios);
		
		modelo.addAttribute("usuario",usuario);
		return "tablaResultados";
	}*/
	/*@PostMapping("/tablaResultados")
	String tablaResultadosP(HttpServletRequest request, Model modelo) {
		HttpSession misession = request.getSession();
		Usuario usuario = (Usuario)misession.getAttribute("usuario");
		//List<Usuario> usuarios = repositorioUsuario.findByNombre(usuario.getNombre());
		List<Usuario> usuarios = repositorioUsuario.buscaTodosUsuarios();
		modelo.addAttribute("usuarios",usuarios);
		
		modelo.addAttribute("usuario",usuario);
		return "tablaResultados";
	}*/
	public void Borra(String nombre) {
		List<Usuario> usuarios = repositorioUsuario.findByNombre(nombre);
		if(usuarios != null) repositorioUsuario.delete(usuarios.get(0));
		
	}
	
	String Lista(Model modelo) {
		List<Usuario> usuarios = (List<Usuario>)repositorioUsuario.findAll();
		modelo.addAttribute("usuarios",usuarios);
		
		return "lista";
	}
}
