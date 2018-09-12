package com.sopra.TPFinal.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.Salle;
import com.sopra.TPFinal.model.User;
import com.sopra.TPFinal.model.UserRole;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.UserRoleRepositoy;

@CrossOrigin(origins = { "*" })
@RestController
public class UserRoleRestController {
	
	@Autowired
	private UserRoleRepositoy userRoleRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<UserRole>> findAll(){
		return new ResponseEntity<>(userRoleRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path= {"/"})
	public ResponseEntity<Void> userRole(@Valid @RequestBody UserRole userRole, BindingResult br, UriComponentsBuilder uCB){
		
		ResponseEntity<Void> response = null;
		
		if(br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			userRoleRepository.save(userRole);
			HttpHeaders header = new HttpHeaders();
			
			header.setLocation(uCB.path("rest/userRole/{id}").buildAndExpand(userRole.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<UserRole> update(@Valid @RequestBody UserRole userRole, BindingResult br) {
		if (br.hasErrors() || userRole.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<UserRole> opt = userRoleRepository.findById(userRole.getId());
		if (opt.isPresent()) {
			UserRole UserRoleEnBase = opt.get();
			UserRoleEnBase.setRole(userRole.getRole());
			UserRoleEnBase.setUser(userRole.getUser());
			return new ResponseEntity<UserRole>(UserRoleEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<UserRole> opt = userRoleRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			userRoleRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}
