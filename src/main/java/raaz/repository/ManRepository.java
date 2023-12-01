package raaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import raaz.beans.Manufacturer;


@Repository
public interface ManRepository extends JpaRepository<Manufacturer, Long>{
	/**
	 * Built in methods
	 * save()
	 * findAll()
	 * count()
	 * delete()
	 * findById()
	 */
}
