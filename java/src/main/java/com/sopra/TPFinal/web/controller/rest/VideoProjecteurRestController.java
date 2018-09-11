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
import com.sopra.TPFinal.model.VideoProjecteur;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.VideoProjecteurRepository;

@RequestMapping("/videoProjecteur")
@Controller
public class VideoProjecteurRestController {
	
	
	@Autowired
	private VideoProjecteurRepository videoProjecteurRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<VideoProjecteur>> findAll(){
		return new ResponseEntity<>(videoProjecteurRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path= {"/videoProjecteur"})
	public ResponseEntity<Void> videoProjecteur(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult br, UriComponentsBuilder uCB){
		
		ResponseEntity<Void> response = null;
		
		if(br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			videoProjecteurRepository.save(videoProjecteur);
			HttpHeaders header = new HttpHeaders();
			
			header.setLocation(uCB.path("rest/videoProjecteur/{id}").buildAndExpand(videoProjecteur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<VideoProjecteur> update(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult br) {
		if (br.hasErrors() || videoProjecteur.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<VideoProjecteur> opt = videoProjecteurRepository.findById(videoProjecteur.getId());
		if (opt.isPresent()) {
			VideoProjecteur VideoProjecteurEnBase = opt.get();
			VideoProjecteurEnBase.setCoutUtilisation(videoProjecteur.getCoutUtilisation());
			return new ResponseEntity<VideoProjecteur>(VideoProjecteurEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<VideoProjecteur> opt = videoProjecteurRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			videoProjecteurRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
}
