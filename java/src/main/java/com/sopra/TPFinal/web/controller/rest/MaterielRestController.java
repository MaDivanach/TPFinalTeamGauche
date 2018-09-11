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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPFinal.model.Materiel;
import com.sopra.TPFinal.model.Ordinateur;
import com.sopra.TPFinal.model.Salle;
import com.sopra.TPFinal.model.VideoProjecteur;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.MaterielRepository;
import com.sopra.TPFinal.repositories.OrdinateurRepository;
import com.sopra.TPFinal.repositories.SalleRepository;
import com.sopra.TPFinal.repositories.VideoProjecteurRepository;

@RequestMapping("/rest/materiel")
@RestController
public class MaterielRestController {
	
	@Autowired
	private MaterielRepository materielRepository;
	
	@Autowired
	private VideoProjecteur videoProjecteur;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Materiel>> findAll(){
		return new ResponseEntity<>(materielRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path = {"/ordinateur/", "/ordinateur"})
    public ResponseEntity<Void> createStagiaire(@Valid @RequestBody Ordinateur ordinateur, BindingResult br, UriComponentsBuilder uCB) {
        ResponseEntity<Void> response = null;
        if(br.hasErrors()) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            materielRepository.save(ordinateur);
            HttpHeaders header = new HttpHeaders();
            header.setLocation(uCB.path("/rest/user/ordinateur/{id}").buildAndExpand(ordinateur.getId()).toUri());
            response = new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return response;
    }
	
	@PostMapping(path = {"/salle/", "/salle"})
    public ResponseEntity<Void> createStagiaire(@Valid @RequestBody Salle salle, BindingResult br, UriComponentsBuilder uCB) {
        ResponseEntity<Void> response = null;
        if(br.hasErrors()) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            materielRepository.save(salle);
            HttpHeaders header = new HttpHeaders();
            header.setLocation(uCB.path("/rest/user/salle/{id}").buildAndExpand(salle.getId()).toUri());
            response = new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return response;
    }
	
	@PostMapping(path = {"/videoProjecteur/", "/videoProjecteur"})
    public ResponseEntity<Void> createStagiaire(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult br, UriComponentsBuilder uCB) {
        ResponseEntity<Void> response = null;
        if(br.hasErrors()) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            materielRepository.save(videoProjecteur);
            HttpHeaders header = new HttpHeaders();
            header.setLocation(uCB.path("/rest/user/ordinateur/{id}").buildAndExpand(videoProjecteur.getId()).toUri());
            response = new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return response;
    }
	
//	@JsonView(JsonViews.Common.class)
//	@PutMapping(path = { "/", "" })
//	public ResponseEntity<Materiel> update(@Valid @RequestBody Materiel materiel, BindingResult br) {
//		if (br.hasErrors() || materiel.getId() == null) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		Optional<Materiel> opt = materielRepository.findById(materiel.getId());
//		if (opt.isPresent()) {
//			Materiel MaterielEnBase = opt.get();
//			MaterielEnBase.setCoutUtilisation(materiel.getCoutUtilisation());
//			return new ResponseEntity<Materiel>(MaterielEnBase, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
		Optional<Materiel> opt = materielRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			materielRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
}
