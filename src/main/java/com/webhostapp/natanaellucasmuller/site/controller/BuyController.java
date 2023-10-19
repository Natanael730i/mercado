package com.webhostapp.natanaellucasmuller.site.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webhostapp.natanaellucasmuller.site.repository.BuyRepository;
import com.webhostapp.natanaellucasmuller.site.model.BuyModel;


@RestController
@RequestMapping("/buy")
public class BuyController {

    @Autowired
    BuyRepository repository;

    @GetMapping("/list")
    public List<BuyModel> list(){
        return repository.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody BuyModel buy){
        repository.save(buy);
        return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("Conpra salva com sucesso!");
    }
}
