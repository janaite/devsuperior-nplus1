package dev.janaite.nplus1.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.janaite.nplus1.dto.ProductDTO;
import dev.janaite.nplus1.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;

	@GetMapping()
	public ResponseEntity<Page<ProductDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		Page<ProductDTO> list = service.find(pageRequest);
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/alt")
	public ResponseEntity<List<ProductDTO>> findAll2() {
		List<ProductDTO> list = service.find2();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/altpaged")
	public ResponseEntity<Page<ProductDTO>> findAll3(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {

		PageRequest pageRequest = PageRequest.of(page, size);
		Page<ProductDTO> list = service.find3(pageRequest);

		return ResponseEntity.ok(list);
	}
}
