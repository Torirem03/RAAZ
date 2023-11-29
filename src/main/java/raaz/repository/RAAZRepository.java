package raaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raaz.beans.Product;

@Repository
public interface RAAZRepository extends JpaRepository<Product, Long> {
	/**
	 * Built in methods
	 * save()
	 * findAll()
	 * count()
	 * delete()
	 * findById()
	 */
}
