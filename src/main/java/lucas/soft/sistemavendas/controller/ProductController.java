package lucas.soft.sistemavendas.controller;

import lucas.soft.sistemavendas.model.Product;
import lucas.soft.sistemavendas.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> product = productService.findAllProducts();

        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        var product = productService.findById(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product productToCreate) {
        var productCreated = productService.create(productToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(productCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") Long id) {
        var productDeleted = productService.findById(id);
        productService.delete(productDeleted.getId());
        return ResponseEntity.ok(productDeleted);
    }
}
