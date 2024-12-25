package sup.realtions.mapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sup.realtions.mapping.dto.Books;
import sup.realtions.mapping.dto.Student;
import sup.realtions.mapping.repository.StudentRepository;
import sup.realtions.mapping.service.StudentService;

@RestController
public class Controller {
	
	@Autowired
	private StudentService service;

	
	@GetMapping("/student")
	public ResponseEntity<Object> fetchAll(){
		return service.fetchAll();
	}
	
	@PostMapping("/student")
	public ResponseEntity<Object> send(@RequestBody Student student){
		return service.send(student);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Object> getLaptopByStudentID(@PathVariable int id){
		return service.getById(id);
	}
	
	@GetMapping("/student/laptop/{id}")
	public ResponseEntity<Object> getStudentByLaptopID(@PathVariable int id){
		return service.getByLaptopId(id);
	}
	

}
