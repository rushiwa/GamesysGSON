package com.rush.jsonpractice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Optional;

public class Service {

    ColorMix colorMix = new ColorMix(5);

    public void gsonTest() {
        Animal animal = new Animal("Bird",2, true, Optional.ofNullable(colorMix));
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Animal.class, new Deserializer());
//        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println(gsonBuilder.create().toJson(animal));
    }

    public void jacksonTest() throws JsonProcessingException {
        Animal animal = new Animal("Bird", 2, true);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(animal);
        System.out.println(json);
    }

    public static void main(String[] args) throws JsonProcessingException {
        Service service = new Service();
        service.gsonTest();
        service.jacksonTest();
    }

}
