package dev.janaite.nplus1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.janaite.nplus1.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT obj FROM Product obj JOIN FETCH obj.categories")
	List<Product> findProductCategories();
}
