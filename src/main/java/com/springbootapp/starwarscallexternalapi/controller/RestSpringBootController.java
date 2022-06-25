package com.springbootapp.starwarscallexternalapi.controller;

import com.springbootapp.starwarscallexternalapi.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
@Log4j2
@RequiredArgsConstructor
public class RestSpringBootController {

    @Autowired
    PersonService service;

    @GetMapping
    private ResponseEntity<?> listAll() {
        return ResponseEntity.ok(service.findPerson());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getPersonId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findPersonById(id));
    }

}
