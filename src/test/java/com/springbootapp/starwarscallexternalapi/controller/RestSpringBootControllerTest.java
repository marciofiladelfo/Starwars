package com.springbootapp.starwarscallexternalapi.controller;

import com.springbootapp.starwarscallexternalapi.service.PersonService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

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
        RestAssuredMockMvc
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("/persons")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    void testGetPersonId() {
        RestAssuredMockMvc
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("/persons/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}