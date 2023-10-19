package com.webhostapp.natanaellucasmuller.site.controller;

import com.webhostapp.natanaellucasmuller.site.model.UserModel;
import com.webhostapp.natanaellucasmuller.site.repository.UserRepository;
import com.webhostapp.natanaellucasmuller.site.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repository;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserModel user){
        repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuário Criado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@RequestParam UUID id){
        var user = repository.findById(id).orElse(null);
        if (user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuário inexistente, verifique e tente novamente!");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Usuário Deletado com sucesso!");
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity alter(@RequestBody UserModel userModel,
                                @RequestParam UUID id){

        var user = repository.findById(id).orElse(null);
        if (user == null){
            return ResponseEntity
                    .badRequest()
                    .body("Usuário inexistente, verifique e tente novamente!");
        }
        Utils.copyNonNullProperties(userModel, user);
        repository.save(user);
        return ResponseEntity.ok("Usuário alterado com sucesso!");
    }

    @GetMapping("/list")
    public List<UserModel> list(){
        return repository.findAll();
    }

}
