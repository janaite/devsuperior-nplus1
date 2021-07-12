package dev.janaite.nplus1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.nplus1.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
