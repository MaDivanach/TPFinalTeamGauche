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
import com.sopra.TPFinal.model.Matiere;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.MatiereRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/matiere")
public class MatiereRestController {

	@Autowired
	private MatiereRepository matiereRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Matiere>> findAll() {
		return new ResponseEntity<>(matiereRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createMatiere(@Valid @RequestBody Matiere matiere, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			matiereRepository.save(matiere);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/matiere/{id}").buildAndExpand(matiere.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Matiere> findById(@PathVariable(name = "id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		ResponseEntity<Matiere> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Matiere> update(@Valid @RequestBody Matiere matiere, BindingResult br) {
		if (br.hasErrors() || matiere.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Matiere> opt = matiereRepository.findById(matiere.getId());
		if (opt.isPresent()) {
			Matiere matiereEnBase = opt.get();
			matiereEnBase.setTitre(matiere.getTitre());
			matiereEnBase.setObjectif(matiere.getObjectif());
			matiereEnBase.setNiveau(matiere.getNiveau());
			matiereEnBase.setFormateurs(matiere.getFormateurs());
			matiereRepository.save(matiereEnBase);
			return new ResponseEntity<Matiere>(matiereEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			matiereRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}