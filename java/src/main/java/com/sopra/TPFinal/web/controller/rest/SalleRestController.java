package com.sopra.TPFinal.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.Materiel;
import com.sopra.TPFinal.model.Salle;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.SalleRepository;

@RequestMapping("/salle")
@Controller
public class SalleRestController {
	
	@Autowired
	private SalleRepository salleRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Salle>> findAll(){
		return new ResponseEntity<>(salleRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path= {"/salle"})
	public ResponseEntity<Void> salle(@Valid @RequestBody Salle salle, BindingResult br, UriComponentsBuilder uCB){
		
		ResponseEntity<Void> response = null;
		
		if(br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			salleRepository.save(salle);
			HttpHeaders header = new HttpHeaders();
			
			header.setLocation(uCB.path("rest/salle/{id}").buildAndExpand(salle.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Salle> update(@Valid @RequestBody Salle salle, BindingResult br) {
		if (br.hasErrors() || salle.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Salle> opt = salleRepository.findById(salle.getId());
		if (opt.isPresent()) {
			Salle SalleEnBase = opt.get();
			SalleEnBase.setCapacite(salle.getCapacite());
			return new ResponseEntity<Salle>(SalleEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Salle> opt = salleRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			salleRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
}
