package com.rush.jsonpractice;

import lombok.Getter;
import lombok.Setter;

public class ColorMix {

    @Getter @Setter
    private int colorId;

//    @Getter @Setter
//    private String color;

    public ColorMix(int colorId) {
        this.colorId = colorId;
//        this.color = color;
    }

    public ColorMix() {
    }
}
