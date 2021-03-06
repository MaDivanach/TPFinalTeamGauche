package com.sopra.TPFinal.web.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.sopra.TPFinal.model.Admin;
import com.sopra.TPFinal.model.Formateur;
import com.sopra.TPFinal.model.Gestionnaire;
import com.sopra.TPFinal.model.Stagiaire;
import com.sopra.TPFinal.model.Technicien;
import com.sopra.TPFinal.model.User;
import com.sopra.TPFinal.model.view.JsonViews;
import com.sopra.TPFinal.repositories.FormateurRepository;
import com.sopra.TPFinal.repositories.GestionnaireRepository;
import com.sopra.TPFinal.repositories.StagiaireRepository;
import com.sopra.TPFinal.repositories.TechnicienRepository;
import com.sopra.TPFinal.repositories.UserRepository;
import com.sopra.TPFinal.services.CustomUserDetailService;
import com.sopra.TPFinal.services.CustomUserDetails;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/user")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GestionnaireRepository gestionnaireRepository;
	@Autowired
	private TechnicienRepository technicienRepository;
	@Autowired
	private FormateurRepository formateurRepository;
	@Autowired
	private StagiaireRepository stagiaireRepository;
	@Autowired
	private CustomUserDetailService cuds;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<User>> findAll() {
		ResponseEntity<List<User>> response = null;
		response = new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/gestionnaire/", "/gestionnaire" })
	public ResponseEntity<List<Gestionnaire>> findAllG() {
		ResponseEntity<List<Gestionnaire>> response = null;
		response = new ResponseEntity<>(gestionnaireRepository.findAll(), HttpStatus.OK);
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/technicien/", "/technicien" })
	public ResponseEntity<List<Technicien>> findAllT() {
		ResponseEntity<List<Technicien>> response = null;
		response = new ResponseEntity<>(technicienRepository.findAll(), HttpStatus.OK);
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/formateur/", "/formateur" })
	public ResponseEntity<List<Formateur>> findAllF() {
		ResponseEntity<List<Formateur>> response = null;
		response = new ResponseEntity<>(formateurRepository.findAll(), HttpStatus.OK);
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/stagiaire/", "/stagiaire" })
	public ResponseEntity<List<Stagiaire>> findAllS() {
		ResponseEntity<List<Stagiaire>> response = null;
		response = new ResponseEntity<>(stagiaireRepository.findAll(), HttpStatus.OK);
		return response;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable(name = "id") Integer id) {
		ResponseEntity<User> response = null;
		Optional<User> opt = userRepository.findById(id);
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PutMapping(path = { "/", "" })
	public ResponseEntity<User> update(@Valid @RequestBody User user, BindingResult br) {
		ResponseEntity<User> response = null;
		if (br.hasErrors() || user.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> opt = userRepository.findById(user.getId());
		if (opt.isPresent()) {
			User userEnBase = opt.get();
			// userEnBase.setEnable(user.isEnable());
			userEnBase.setId(user.getId());
			userEnBase.setUsername(user.getUsername());
			userEnBase.setPassword(user.getPassword());
			userEnBase.setRole(user.getRole());
			userEnBase.setNom(user.getNom());
			userEnBase.setPrenom(user.getPrenom());
			userEnBase.setTelephone(user.getTelephone());
			userEnBase.setAdresse(user.getAdresse());
			switch (userEnBase.getClass().getName()) {
			case "gestionnaire":
				((Gestionnaire) userEnBase).setFormations(((Gestionnaire) user).getFormations());
				userRepository.save(userEnBase);
				response = new ResponseEntity<User>(userEnBase, HttpStatus.OK);
				break;
			case "formateur":
				((Formateur) userEnBase).setExpertises(((Formateur) user).getExpertises());
				((Formateur) userEnBase).setSessions(((Formateur) user).getSessions());
				userRepository.save(userEnBase);
				response = new ResponseEntity<User>(userEnBase, HttpStatus.OK);
				break;
			case "stagiaire":
				((Stagiaire) userEnBase).setOrdinateur(((Stagiaire) user).getOrdinateur());
				userRepository.save(userEnBase);
				response = new ResponseEntity<User>(userEnBase, HttpStatus.OK);
				break;
			case "technicien":
				userRepository.save(userEnBase);
				response = new ResponseEntity<User>(userEnBase, HttpStatus.OK);
				break;
			default:
				response = new ResponseEntity<User>(userEnBase, HttpStatus.OK);
				break;
			}
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping(path = { "/technicien/", "/technicien" })
	public ResponseEntity<Void> createTechnicien(@Valid @RequestBody Technicien technicien, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
//			technicien.setPassword(getPasswordEncoder().encode(technicien.getPassword()));
			userRepository.save(technicien);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/user/technicien/{id}").buildAndExpand(technicien.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/gestionnaire/", "/gestionnaire" })
	public ResponseEntity<Void> createGestionnaire(@Valid @RequestBody Gestionnaire gestionnaire, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			gestionnaire.setPassword(gestionnaire.getPassword());
			getPasswordEncoder().encode(gestionnaire.getPassword());
			userRepository.save(gestionnaire);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/user/technicien/{id}").buildAndExpand(gestionnaire.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/admin/", "/admin" })
	public ResponseEntity<Void> createAdmin(@Valid @RequestBody Admin admin, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			admin.setPassword(admin.getPassword());
			getPasswordEncoder().encode(admin.getPassword());
			userRepository.save(admin);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/user/admin/{id}").buildAndExpand(admin.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/stagiaire/", "/stagiaire" })
	public ResponseEntity<Void> createStagiaire(@Valid @RequestBody Stagiaire stagiaire, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			stagiaire.setPassword(stagiaire.getPassword());
			getPasswordEncoder().encode(stagiaire.getPassword());
			userRepository.save(stagiaire);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/user/stagiaire/{id}").buildAndExpand(stagiaire.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/formateur/", "/formateur" })
	public ResponseEntity<Void> createFormateur(@Valid @RequestBody Formateur formateur, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			formateur.setPassword(formateur.getPassword());
			getPasswordEncoder().encode(formateur.getPassword());
			userRepository.save(formateur);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(uCB.path("/rest/user/formateur/{id}").buildAndExpand(formateur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<User> opt = userRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			userRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@GetMapping(value = "/userload/{username}")
	public ResponseEntity<UserDetails> loadByUsername (@PathVariable(name="username") String username){
		ResponseEntity<UserDetails> response = null;
		if (cuds.loadUserByUsername(username)!=null) {
			response = new ResponseEntity<>(cuds.loadUserByUsername(username),HttpStatus.ACCEPTED);			
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@Bean
	   public PasswordEncoder getPasswordEncoder() {
	       return new BCryptPasswordEncoder();
	   }

}
