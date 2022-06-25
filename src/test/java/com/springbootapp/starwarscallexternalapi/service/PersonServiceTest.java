package com.springbootapp.starwarscallexternalapi.service;

import com.springbootapp.starwarscallexternalapi.response.Person;
import com.springbootapp.starwarscallexternalapi.response.Results;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.List;

class PersonServiceTest {
    @InjectMocks
    PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindPerson() {
        Results result = personService.findPerson();
        Assertions.assertNotNull(result);
    }

    @Test
    void testFindPersonById() {
        List<Person> result = personService.findPersonById(1L);
        Assertions.assertNotNull(result);
    }
}