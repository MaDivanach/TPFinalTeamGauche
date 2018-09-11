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
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.User;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.UserRepository;

public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path= {"/user"})
	public ResponseEntity<Void> user(@Valid @RequestBody User user, BindingResult br, UriComponentsBuilder uCB){
		
		ResponseEntity<Void> response = null;
		
		if(br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			userRepository.save(user);
			HttpHeaders header = new HttpHeaders();
			
			header.setLocation(uCB.path("rest/salle/{id}").buildAndExpand(user.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<User> update(@Valid @RequestBody User user, BindingResult br) {
		if (br.hasErrors() || user.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> opt = userRepository.findById(user.getId());
		if (opt.isPresent()) {
			User UserEnBase = opt.get();
			UserEnBase.setUsername(user.getUsername());
			UserEnBase.setPrenom(user.getPrenom());
			UserEnBase.setNom(user.getNom());
			UserEnBase.setPassword(user.getPassword());
			UserEnBase.setTel(user.getTel());
			return new ResponseEntity<User>(UserEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
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
