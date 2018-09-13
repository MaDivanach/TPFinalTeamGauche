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
import com.sopra.TPFinal.model.Formation;
import com.sopra.TPFinal.model.Session;
import com.sopra.TPFinal.model.SessionPK;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.SessionRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/session")
public class SessionRestController {

	@Autowired
	private SessionRepository sessionRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Session>> findAll() {
		return new ResponseEntity<>(sessionRepository.findAll(), HttpStatus.OK);
	}

//	@JsonView(JsonViews.SessionInFormation.class)
//	@GetMapping(path = { "/sessioninformation" })
//	public ResponseEntity<Optional<Session>> SessionInFormation(Long id) {
//		return new ResponseEntity<>(sessionRepository.SessionInFormation(id), HttpStatus.OK);
//	}
//	

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createSession(@Valid @RequestBody Session session, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			sessionRepository.save(session);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/session/{id}").buildAndExpand(session.getKey()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Session> findById(@PathVariable(name = "id") SessionPK key) {
		Optional<Session> opt = sessionRepository.findById(key);
		ResponseEntity<Session> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Session> update(@Valid @RequestBody Session session, BindingResult br) {
		if (br.hasErrors() || session.getKey() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Session> opt = sessionRepository.findById(session.getKey());
		if (opt.isPresent()) {
			Session sessionEnBase = opt.get();
			sessionEnBase.setKey(session.getKey());
			sessionEnBase.setDateDebut(session.getDateDebut());
			sessionEnBase.setDateFin(session.getDateFin());
			sessionRepository.save(sessionEnBase);
			return new ResponseEntity<Session>(sessionEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") SessionPK key) {
		Optional<Session> opt = sessionRepository.findById(key);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			sessionRepository.deleteById(key);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}