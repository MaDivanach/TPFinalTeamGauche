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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.Formation;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.FormationRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/formation")
public class FormationRestController {

	@Autowired
	private FormationRepository formationRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Formation>> findAll() {
		return new ResponseEntity<>(formationRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/findCustomByIdWithAll" })
	public ResponseEntity<Optional<Formation>> findCustomByIdWithAll(Long id) {
		return new ResponseEntity<>(formationRepository.findCustomByIdWithAll(id), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createFormation(@Valid @RequestBody Formation formation, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			formationRepository.save(formation);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/formation/{id}").buildAndExpand(formation.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Formation> findById(@PathVariable(name = "id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		ResponseEntity<Formation> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Formation> update(@Valid @RequestBody Formation formation, BindingResult br) {
		if (br.hasErrors() || formation.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Formation> opt = formationRepository.findById(formation.getId());
		if (opt.isPresent()) {
			// update possible
			Formation formationEnBase = opt.get();
			formationEnBase.setNom(formation.getNom());
			formationEnBase.setDateDebut(formation.getDateDebut());
			formationEnBase.setDateFin(formation.getDateFin());
			formationEnBase.setGestionnaire(formation.getGestionnaire());
			formationEnBase.setVideoProjecteur(formation.getVideoProjecteur());
			formationEnBase.setSalle(formation.getSalle());
			formationEnBase.setStagiaires(formation.getStagiaires());
			formationEnBase.setSessions(formation.getSessions());
			formationRepository.save(formationEnBase);
			return new ResponseEntity<Formation>(formationEnBase, HttpStatus.OK);
		} else {
			// pas de formation
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			formationRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
