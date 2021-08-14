package escolaJavaliCansado.org.escolaJavaliCansado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import escolaJavaliCansado.org.escolaJavaliCansado.model.VideoAula;
import escolaJavaliCansado.org.escolaJavaliCansado.repository.VideoAulaRepository;
import escolaJavaliCansado.org.escolaJavaliCansado.service.VideoAulaService;

@RestController
@RequestMapping("/videoAula")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VideoAulaController {
	@Autowired VideoAulaRepository videoRepository;
	@Autowired VideoAulaService videoService;
	
	@GetMapping
	public ResponseEntity<List<VideoAula>> getAll() {
		return new ResponseEntity<List<VideoAula>> (videoService.buscarTodos(), HttpStatus.OK);
	}
	
	@GetMapping("/tituloVideo/{titulo}")
	public ResponseEntity<List<VideoAula>> getByTitle(@PathVariable String titulo) {
		return new ResponseEntity<List<VideoAula>> (videoService.buscarPorTitulo(titulo), HttpStatus.OK);
	}
	
	@GetMapping("/materia/{materia}")
	public ResponseEntity<List<VideoAula>> getByMateria(@PathVariable String materia) {
		return new ResponseEntity<List<VideoAula>> (videoService.buscarPorMateria(materia), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<VideoAula> post(@RequestBody VideoAula publicarVideo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(videoRepository.save(publicarVideo));
	}

}
