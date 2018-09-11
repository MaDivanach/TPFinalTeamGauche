package com.sopra.TPFinal.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.Ordinateur;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.OrdinateurRepository;

@RequestMapping("/ordinateur")
@RestController
public class OrdinateurRestController {
	
	@Autowired
	private OrdinateurRepository ordinateurRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Ordinateur>> findAll(){
		return new ResponseEntity<>(ordinateurRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path= {"/ordinateur"})
	public ResponseEntity<Void> ordinateur(@Valid @RequestBody Ordinateur ordinateur, BindingResult br, UriComponentsBuilder uCB){
		
		ResponseEntity<Void> response = null;
		
		if(br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ordinateurRepository.save(ordinateur);
			HttpHeaders header = new HttpHeaders();
			
			header.setLocation(uCB.path("rest/ordinateur/{id}").buildAndExpand(ordinateur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Ordinateur> update(@Valid @RequestBody Ordinateur ordinateur, BindingResult br) {
		if (br.hasErrors() || ordinateur.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Ordinateur> opt = ordinateurRepository.findById(ordinateur.getId());
		if (opt.isPresent()) {
			Ordinateur OrdinateurEnBase = opt.get();
			OrdinateurEnBase.setCoutUtilisation(ordinateur.getCoutUtilisation());
			return new ResponseEntity<Ordinateur>(OrdinateurEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
}