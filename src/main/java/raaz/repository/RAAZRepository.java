package raaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import raaz.beans.Product;

public interface RAAZRepository extends JpaRepository<Product, Long> {

}
