package com.springbootapp.starwarscallexternalapi.controller;

import com.springbootapp.starwarscallexternalapi.service.PersonService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
@RequiredArgsConstructor
public class RestSpringBootController {

    @Autowired
    PersonService service;

    @ApiOperation(value = "Retorna a lista dos personagens")
    @GetMapping("/")
    private ResponseEntity<?> listAll() {
        return new ResponseEntity<>(service.findPerson(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna o personagem pelo id + 3 personagens do mesmo planeta")
    @GetMapping("/{id}")
    private ResponseEntity<?> getPersonId(@PathVariable Long id) {
        return new ResponseEntity<>(service.findPersonById(id), HttpStatus.OK);
    }

}
