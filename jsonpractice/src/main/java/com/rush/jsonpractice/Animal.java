package com.rush.jsonpractice;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@ToString
@EqualsAndHashCode
public class Animal {

    @Getter
    private String type;
    @Getter
    private int age;
    @Getter
    private boolean fly;
    @Getter
    private Optional<ColorMix> colorMix;

    public Animal(String type, int age, boolean fly) {
        this.type = type;
        this.age = age;
        this.fly = fly;
    }

    public Animal(String type, int age, boolean fly, Optional<ColorMix> colorMix) {
        this.type = type;
        this.age = age;
        this.fly = fly;
        this.colorMix = colorMix;
    }

    public Animal() {
    }
}
