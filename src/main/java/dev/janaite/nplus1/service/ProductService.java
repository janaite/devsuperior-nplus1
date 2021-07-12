package dev.janaite.nplus1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.janaite.nplus1.dto.ProductDTO;
import dev.janaite.nplus1.entities.Product;
import dev.janaite.nplus1.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public Page<ProductDTO> find(PageRequest pageRequest) {
		Page<Product> list = repository.findAll(pageRequest);
		return list.map(x -> new ProductDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> find2() {
		List<Product> list = repository.findProductCategories();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Page<ProductDTO> find3(PageRequest pageRequest) {
		Page<Product> page = repository.findAll(pageRequest);
		// put entities into cache
		repository.findProductCategoriesLimited(page.stream().collect(Collectors.toList()));
		
		return page.map(x -> new ProductDTO(x));
	}

}
