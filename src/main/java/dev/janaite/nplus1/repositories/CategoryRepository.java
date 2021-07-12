package dev.janaite.nplus1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.janaite.nplus1.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
