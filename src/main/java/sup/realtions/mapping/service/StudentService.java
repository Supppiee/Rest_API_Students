package sup.realtions.mapping.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sup.realtions.mapping.dto.Laptop;
import sup.realtions.mapping.dto.Student;
import sup.realtions.mapping.repository.LaptopRepository;
import sup.realtions.mapping.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private LaptopRepository lapRepo;
	
	public ResponseEntity<Object> fetchAll() {
		List<Student> student = repository.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("Message", student);
		return new ResponseEntity<Object>(map, HttpStatus.FOUND);
	}

	public ResponseEntity<Object> send(Student student) {
		repository.save(student);
		Map<String, Object> map = new HashMap<>();
		map.put("message","saved");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}

	public ResponseEntity<Object> getById(int id) {
		if(repository.existsById(id)) {
			Laptop laptop = repository.getById(id).getLaptop();
			Map<String, Object> map =new HashMap<>();
			map.put("Laptop", laptop);
			return new ResponseEntity<Object>(map,HttpStatus.FOUND);
		}else {
			Map<String, Object> map =new HashMap<>();
			map.put("Message", "not found");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Object> getByLaptopId(int id) {
		Optional<Laptop> optional = lapRepo.findById(id);
		Map<String, Object> map = new HashMap<>();
		if(optional.isEmpty()) {
			map.put("Message","No such laptop ID");
			return new ResponseEntity<Object>(map,HttpStatus.NOT_FOUND);
		}else {
			Laptop laptop = optional.get();
			String student = laptop.getStudent().getName();
			map.put("Owner",student);
			return new ResponseEntity<Object>(map, HttpStatus.FOUND);
		}
	}	
}

