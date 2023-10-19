package com.webhostapp.natanaellucasmuller.site.controller;

import com.webhostapp.natanaellucasmuller.site.model.ProductModel;
import com.webhostapp.natanaellucasmuller.site.repository.ProductRepository;
import com.webhostapp.natanaellucasmuller.site.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/list")
    public List<ProductModel> list(){
        return repository.findAll();
    }
    
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ProductModel product){
        repository.save(product);
        return ResponseEntity.status(201).body("Produto Salvo com sucesso!");
    }
    @GetMapping("/list/{id}")
    public Optional<ProductModel> findOne(@PathVariable UUID id){
        return repository.findById(id);
    }
    @PutMapping("/alter/{id}")
    public ResponseEntity alter(@RequestBody ProductModel product,
                                @RequestParam UUID id){
        var products = this.repository.findById(id).orElse(null);
        if (products == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Solicitação mal feita, verifique os dados e tente novamente!");
        }

        Utils.copyNonNullProperties(product, products);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.repository.save(products));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@RequestParam UUID id){
        var product = repository.findById(id).orElse(null);
        if (product == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Produto inexistente, verifique e tente novamente!");
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body("Produto deletado com sucesso!");
    }
}
