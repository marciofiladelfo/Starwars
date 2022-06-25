package com.springbootapp.starwarscallexternalapi.controller;

import com.springbootapp.starwarscallexternalapi.service.PersonService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.HttpStatus;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.when;

@WebMvcTest
class RestSpringBootControllerTest {

    @Autowired
    private RestSpringBootController restSpringBootController;

    @MockBean
    private PersonService service;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(restSpringBootController);
    }

    @Test
    void testListAll() {
//        when(service.findPerson());
        given()
            .accept(ContentType.ANY)
            .when()
            .get("/persons")
            .then()
            .statusCode(HttpStatus.OK.value());
}

    @Test
    void testGetPersonId() {
//        when(service.findPersonById(1L));
        given()
            .accept(ContentType.ANY)
            .when()
            .get("/persons/{id}", 1L)
            .then()
            .statusCode(HttpStatus.OK.value());
    }
}