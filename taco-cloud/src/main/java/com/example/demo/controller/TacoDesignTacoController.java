package com.example.demo.controller;

import java.util.Optional;  
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.hateoas.server.EntityLinks; 
import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping; 
 import org.springframework.web.bind.annotation.PathVariable;  
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;  
 import org.springframework.web.bind.annotation.RequestMapping; 
 import org.springframework.web.bind.annotation.ResponseStatus; 
 import org.springframework.web.bind.annotation.RestController; 
 import com.example.demo.model.Taco;  

import Taco.data.TacoRepository; 

@RestController  
@RequestMapping(path = "/design", produces = "application/json")  @CrossOrigin(origins = "*")  
public class TacoDesignTacoController {  
 private TacoRepository tacoRepo;  
 @Autowired  
 EntityLinks entityLinks;  
 public TacoDesignTacoController(TacoRepository tacoRepo) {   this.tacoRepo = tacoRepo;  
 }  
 @GetMapping("/recent")  
 public Iterable<Taco> recentTacos() {  
 return tacoRepo.findAll();  
 } 
