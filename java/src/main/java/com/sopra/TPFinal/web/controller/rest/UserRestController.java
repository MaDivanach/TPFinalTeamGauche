package com.sopra.TPFinal.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.Admin;
import com.sopra.TPFinal.model.Formateur;
import com.sopra.TPFinal.model.Gestionnaire;
import com.sopra.TPFinal.model.Stagiaire;
import com.sopra.TPFinal.model.Technicien;
import com.sopra.TPFinal.model.User;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<User>> findAll(){
		ResponseEntity<List<User>> response = null;
		response= new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
		return response;
	}
	
	   @GetMapping(value = "/{id}")
	    public ResponseEntity<User> findById(@PathVariable(name = "id") Integer id) {
	        ResponseEntity<User> response = null;
	        Optional<User> opt = userRepository.findById(id);
	        if (opt.isPresent()) {
	            response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
	        } else {
	            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        return response;
	    }
	   
	   @PostMapping(path = {"/technicien/", "/technicien"})
	    public ResponseEntity<Void> createTechnicien(@Valid @RequestBody Technicien technicien, BindingResult br, UriComponentsBuilder uCB) {
	        ResponseEntity<Void> response = null;
	        if(br.hasErrors()) {
	            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        } else {
	            userRepository.save(technicien);
	            HttpHeaders header = new HttpHeaders();
	            header.setLocation(uCB.path("/rest/user/technicien/{id}").buildAndExpand(technicien.getId()).toUri());
	            response = new ResponseEntity<Void>(HttpStatus.CREATED);
	        }
	        return response;
	    }
	   
	   @PostMapping(path = {"/gestionnaire/", "/gestionnaire"})
	    public ResponseEntity<Void> createGestionnaire(@Valid @RequestBody Gestionnaire gestionnaire, BindingResult br, UriComponentsBuilder uCB) {
	        ResponseEntity<Void> response = null;
	        if(br.hasErrors()) {
	            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        } else {
	            userRepository.save(gestionnaire);
	            HttpHeaders header = new HttpHeaders();
	            header.setLocation(uCB.path("/rest/user/technicien/{id}").buildAndExpand(gestionnaire.getId()).toUri());
	            response = new ResponseEntity<Void>(HttpStatus.CREATED);
	        }
	        return response;
	    }
	   
	   @PostMapping(path = {"/admin/", "/admin"})
	    public ResponseEntity<Void> createAdmin(@Valid @RequestBody Admin admin, BindingResult br, UriComponentsBuilder uCB) {
	        ResponseEntity<Void> response = null;
	        if(br.hasErrors()) {
	            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        } else {
	            userRepository.save(admin);
	            HttpHeaders header = new HttpHeaders();
	            header.setLocation(uCB.path("/rest/user/admin/{id}").buildAndExpand(admin.getId()).toUri());
	            response = new ResponseEntity<Void>(HttpStatus.CREATED);
	        }
	        return response;
	    }
	   
	   @PostMapping(path = {"/stagiaire/", "/stagiaire"})
	    public ResponseEntity<Void> createStagiaire(@Valid @RequestBody Stagiaire stagiaire, BindingResult br, UriComponentsBuilder uCB) {
	        ResponseEntity<Void> response = null;
	        if(br.hasErrors()) {
	            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        } else {
	            userRepository.save(stagiaire);
	            HttpHeaders header = new HttpHeaders();
	            header.setLocation(uCB.path("/rest/user/stagiaire/{id}").buildAndExpand(stagiaire.getId()).toUri());
	            response = new ResponseEntity<Void>(HttpStatus.CREATED);
	        }
	        return response;
	    }
	   
	   @PostMapping(path = {"/formateur/", "/formateur"})
	    public ResponseEntity<Void> createFormateur(@Valid @RequestBody Formateur formateur, BindingResult br, UriComponentsBuilder uCB) {
	        ResponseEntity<Void> response = null;
	        if(br.hasErrors()) {
	            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        } else {
	            userRepository.save(formateur);
	            HttpHeaders header = new HttpHeaders();
	            header.setLocation(uCB.path("/rest/user/formateur/{id}").buildAndExpand(formateur.getId()).toUri());
	            response = new ResponseEntity<Void>(HttpStatus.CREATED);
	        }
	        return response;
	    }

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<User> opt = userRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			userRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}
