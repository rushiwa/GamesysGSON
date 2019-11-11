package com.rush.jsonpractice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;


public class ServiceTest {

    ObjectMapper objectMapper = new ObjectMapper();
    Animal animal = new Animal("Bird", 2, true);
    Gson gson = new GsonBuilder().serializeNulls().create();


    @Before
    public void setUp() throws Exception {
        GsonTester.initFields(this, gson);
        JacksonTester.initFields(this, objectMapper);
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Test
    public void shouldReturnGsonFile(){
        assertThat(gson.toJson(animal)).isEqualTo("animal.json");
    }

    @Test
    public void shouldReturnJacksonFile() throws JsonProcessingException {
        System.out.println(objectMapper.writeValueAsString(animal));
        assertThat(objectMapper.writeValueAsString(animal)).isEqualTo("{\"type\":\"Bird\",\"age\":2,\"fly\":true}");
    }

}
