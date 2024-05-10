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

import eus.birt.dam.domain.Diska;
import eus.birt.dam.repository.DiskaRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/diskak")
public class DiskaController {

	@Autowired
	DiskaRepository diskaRepository;
	
	@GetMapping({"/",""})
	public List <Diska> index() {
	return diskaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Diska show(@PathVariable("id") Integer id) {
		return diskaRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Diska create(@RequestBody Diska diska) {
		return diskaRepository.save(diska);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Diska update(@RequestBody Diska diska, @PathVariable("id") Integer id) {
		Diska tempDiska = diskaRepository.findById(id).orElse(null);
		
		tempDiska.setIzena(diska.getIzena());
		tempDiska.setData(diska.getData());
		tempDiska.setArtista(diska.getArtista());
		tempDiska.setDisketxea(diska.getDisketxea());
		//Al ser un id diferente, el método save hace en realidad un update
		return diskaRepository.save(tempDiska);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		diskaRepository.deleteById(id);
	}
	
}
