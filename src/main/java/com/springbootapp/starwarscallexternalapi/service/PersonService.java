package com.springbootapp.starwarscallexternalapi.service;

import com.springbootapp.starwarscallexternalapi.response.Person;
import com.springbootapp.starwarscallexternalapi.response.Results;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class PersonService {

    public Results findPerson() {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("https://swapi.dev/api/people").build();
        ResponseEntity<Results> exchange = restTemplate.getForEntity("/", Results.class);
        return exchange.getBody();
    }

    public List<Person> findPersonById(Long id) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<Person> exchange = restTemplate.getForEntity("https://swapi.dev/api/people/" + id, Person.class);
        Person person2 = exchange.getBody();
        List<Person> sugestion = new ArrayList<>();
        this.findPerson().getResults().forEach(person -> {
            if (person.getHomeWorldUrl().trim().equals(Objects.requireNonNull(exchange.getBody()).getHomeWorldUrl().trim())) {
                sugestion.add(person);
            }
        });
        sugestion.add(person2);
        int numberOfElements = 3;
        return this.getRandomElement(sugestion, numberOfElements);
    }

    private List<Person> getRandomElement(List<Person> list, int totalItems) {
        Random random = new Random();
        List<Person> sugestion = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = random.nextInt(list.size());
            sugestion.add(list.get(randomIndex));
        }
        return sugestion;
    }
}