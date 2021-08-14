package escolaJavaliCansado.org.escolaJavaliCansado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import escolaJavaliCansado.org.escolaJavaliCansado.model.Publicar;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.PublicarRepository;
import escolaJavaliCansado.org.escolaJavaliCansado.service.PublicarService;

@RestController
@RequestMapping("/publicar")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PublicarController {
	@Autowired PublicarRepository publicarRepository;
	
	@Autowired PublicarService publicarService;
	
	@GetMapping
	public ResponseEntity<List<Publicar>> getAll(){
		return new ResponseEntity <List<Publicar>> (publicarService.buscarTodos(),HttpStatus.OK);
	}
	
	@GetMapping("/nomeDoAluno/{nomeAluno}")
	public ResponseEntity<List<Publicar>> getAllName(@PathVariable String nomeAluno) {
		return new ResponseEntity<List<Publicar>> (publicarService.buscarPoNomeAluno(nomeAluno), HttpStatus.OK);
	}
	
	@GetMapping("/situacaoDoAluno/{situacao}")
	public ResponseEntity<List<Publicar>> getAllSituation(@PathVariable String situacao) {
		return new ResponseEntity<List<Publicar>> (publicarService.buscarPorSituacaoAluno(situacao), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Publicar> post(@RequestBody Publicar publicar) {
		return ResponseEntity.status(HttpStatus.CREATED).body(publicarRepository.save(publicar));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable Long id) {
		publicarRepository.deleteById(id);
	}
}
