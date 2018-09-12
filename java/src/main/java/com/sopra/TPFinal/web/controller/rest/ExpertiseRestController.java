package com.sopra.TPFinal.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.Expertise;
import com.sopra.TPFinal.model.ExpertisePK;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.ExpertiseRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/expertise")
public class ExpertiseRestController {

	@Autowired
	private ExpertiseRepository expertiseRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Expertise>> findAll() {
		return new ResponseEntity<>(expertiseRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createExpertise(@Valid @RequestBody Expertise expertise, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			expertiseRepository.save(expertise);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/expertise/{id}").buildAndExpand(expertise.getExpertisePK()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Expertise> findById(@PathVariable(name = "id") ExpertisePK key) {
		Optional<Expertise> opt = expertiseRepository.findById(key);
		ResponseEntity<Expertise> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Expertise> update(@Valid @RequestBody Expertise expertise, BindingResult br) {
		if (br.hasErrors() || expertise.getExpertisePK() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Expertise> opt = expertiseRepository.findById(expertise.getExpertisePK());
		if (opt.isPresent()) {
			Expertise expertiseEnBase = opt.get();
			expertiseEnBase.setExpertisePK(expertise.getExpertisePK());
			return new ResponseEntity<Expertise>(expertiseEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") ExpertisePK key) {
		Optional<Expertise> opt = expertiseRepository.findById(key);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			expertiseRepository.deleteById(key);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}