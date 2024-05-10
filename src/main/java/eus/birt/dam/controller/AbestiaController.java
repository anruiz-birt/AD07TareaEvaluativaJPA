package eus.birt.dam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Abestia;
import eus.birt.dam.repository.AbestiaRepository;
import eus.birt.dam.repository.DiskaRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/abestiak")
public class AbestiaController {

	@Autowired
	AbestiaRepository abestiaRepository;
	
	@Autowired
	DiskaRepository diskaRepository;
		
	@GetMapping({"/",""})
	public List <Abestia> index() {
		return abestiaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Abestia show(@PathVariable("id") Integer id) {
		return abestiaRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Abestia create(@RequestBody Abestia abestia) {
		return abestiaRepository.save(abestia);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Abestia update(@RequestBody Abestia abestia, @PathVariable("id") Integer id) {
		Abestia tempAbestia = abestiaRepository.findById(id).orElse(null);
		
		tempAbestia.setOrdena(abestia.getOrdena());
		tempAbestia.setIzenburua(abestia.getIzenburua());
		tempAbestia.setIraupena(abestia.getIraupena());		
		tempAbestia.setDiska(abestia.getDiska());
		
		return abestiaRepository.save(tempAbestia);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		abestiaRepository.deleteById(id);
	}
	
}