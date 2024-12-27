package sup.realtions.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sup.realtions.mapping.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);
	
}
