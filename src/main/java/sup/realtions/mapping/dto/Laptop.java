package sup.realtions.mapping.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Laptop {
	@Id
	private Integer laptop_id;
	private String brand;
	
	@OneToOne(mappedBy = "laptop")
	@JsonBackReference
	private Student student;

	public Integer getLaptop_id() {
		return laptop_id;
	}

	public void setLaptop_id(Integer laptop_id) {
		this.laptop_id = laptop_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
		
}
