package com.springbootapp.starwarscallexternalapi.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Results {
    public List<Person> results;
}
