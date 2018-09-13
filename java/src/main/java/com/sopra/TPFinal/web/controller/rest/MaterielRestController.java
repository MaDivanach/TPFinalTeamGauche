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
import com.sopra.TPFinal.model.Materiel;
import com.sopra.TPFinal.model.Ordinateur;
import com.sopra.TPFinal.model.Salle;
import com.sopra.TPFinal.model.VideoProjecteur;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.MaterielRepository;
import com.sopra.TPFinal.repositories.OrdinateurRepository;
import com.sopra.TPFinal.repositories.SalleRepository;
import com.sopra.TPFinal.repositories.VideoProjecteurRepository;

@CrossOrigin(origins = { "*" })
@RequestMapping("/rest/materiel")
@RestController
public class MaterielRestController {
	
	@Autowired
	private MaterielRepository materielRepository;
	
	@Autowired
	private OrdinateurRepository ordinateurRepository;
	
	@Autowired
	private SalleRepository salleRepository;
	
	@Autowired
	private VideoProjecteurRepository videoProjecteurRepository;
	
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
            header.setLocation(uCB.path("/rest/materiel/ordinateur/{id}").buildAndExpand(ordinateur.getId()).toUri());
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
            header.setLocation(uCB.path("/rest/materiel/salle/{id}").buildAndExpand(salle.getId()).toUri());
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
            header.setLocation(uCB.path("/rest/materiel/videoProjecteur/{id}").buildAndExpand(videoProjecteur.getId()).toUri());
            response = new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return response;
    }
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/ordinateur/", "/ordinateur" })
	public ResponseEntity<Ordinateur> update(@Valid @RequestBody Ordinateur ordinateur, BindingResult br) {
		if (br.hasErrors() || ordinateur.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Ordinateur> opt = ordinateurRepository.findById(ordinateur.getId());
		if (opt.isPresent()) {
			Ordinateur OrdinateurEnBase = opt.get();
			OrdinateurEnBase.setId(ordinateur.getId());
			OrdinateurEnBase.setCoutUtilisation(ordinateur.getCoutUtilisation());
			OrdinateurEnBase.setProcesseur(ordinateur.getProcesseur());
			OrdinateurEnBase.setRam(ordinateur.getRam());
			OrdinateurEnBase.setDd(ordinateur.getDd());
			OrdinateurEnBase.setDateAchat(ordinateur.getDateAchat());
			return new ResponseEntity<Ordinateur>(OrdinateurEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/salle/", "/salle" })
	public ResponseEntity<Salle> update(@Valid @RequestBody Salle salle, BindingResult br) {
		if (br.hasErrors() || salle.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Salle> opt = salleRepository.findById(salle.getId());
		if (opt.isPresent()) {
			Salle SalleEnBase = opt.get();
			SalleEnBase.setId(salle.getId());
			SalleEnBase.setCoutUtilisation(salle.getCoutUtilisation());
			return new ResponseEntity<Salle>(SalleEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/videoprojecteur/", "/videoprojecteur" })
	public ResponseEntity<VideoProjecteur> update(@Valid @RequestBody VideoProjecteur videoProjecteur, BindingResult br) {
		if (br.hasErrors() || videoProjecteur.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<VideoProjecteur> opt = videoProjecteurRepository.findById(videoProjecteur.getId());
		if (opt.isPresent()) {
			VideoProjecteur VideoProjecteurEnBase = opt.get();
			VideoProjecteurEnBase.setId(videoProjecteur.getId());
			VideoProjecteurEnBase.setCoutUtilisation(videoProjecteur.getCoutUtilisation());
			return new ResponseEntity<VideoProjecteur>(VideoProjecteurEnBase, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
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
