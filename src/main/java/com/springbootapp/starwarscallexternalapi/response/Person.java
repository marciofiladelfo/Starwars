package com.springbootapp.starwarscallexternalapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Person {

    @ApiModelProperty(value = "Nome do personagem")
    public String name;

    @JsonProperty("birth_year")
    public String birthYear;

    @JsonProperty("films")
    public List<String> filmsUrls;

    public String gender;

    @JsonProperty("hair_color")
    public String hairColor;

    public String height;

    @JsonProperty("homeworld")
    public String homeWorldUrl;

    public String mass;

    @JsonProperty("skin_color")
    public String skinColor;

    public String created;
    public String edited;
    public String url;

    @JsonProperty("species")
    public List<String> speciesUrls;

    @JsonProperty("starships")
    public List<String> starshipsUrls;

    @JsonProperty("vehicles")
    public List<String> vehiclesUrls;
}
