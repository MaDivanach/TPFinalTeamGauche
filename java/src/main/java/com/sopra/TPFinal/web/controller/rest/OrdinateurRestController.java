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
import com.sopra.TPFinal.model.Materiel;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.MaterielRepository;

@RequestMapping("/ordinateur")
@RestController

EN PROGRESSION

//public class OrdinateurRestController {
//	
//	@Autowired
//	private OrdinateurRepository oridnateurRepository;
//	
//	@JsonView(JsonViews.Common.class)
//	@GetMapping(path = { "/", "" })
//	public ResponseEntity<List<Ordinateur>> findAll(){
//		return new ResponseEntity<>(ordinateurRepository.findAll(), HttpStatus.OK);
//	}
//	
//	@PostMapping(path= {"/ordinateur"})
//	