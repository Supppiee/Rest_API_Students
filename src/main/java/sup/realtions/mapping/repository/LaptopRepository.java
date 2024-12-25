package sup.realtions.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sup.realtions.mapping.dto.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
