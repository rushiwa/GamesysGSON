package com.rush.jsonpractice;

import com.google.gson.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public class Deserializer implements JsonSerializer<Optional<T>>, JsonDeserializer<Optional<T>> {


    @Override
    public Optional<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        final T value = context.deserialize(json, ((ParameterizedType) typeOfT).getActualTypeArguments()[0]);
        return Optional.fromNullable(value);

//        JsonObject jsonObject = json.getAsJsonObject();
//        int age = jsonObject.get("age").getAsInt();
//        String type = jsonObject.get("type").getAsString();
//        Boolean fly = jsonObject.get("fly").getAsBoolean();
//        Optional<ColorMix> colorMix = jsonObject.getAsJsonObject("colorMix");
//        return new animal() ;






//        int colorId = jsonObject.get("colorId").getAsInt();

        //        String color = jsonObject.get("color").getAsString();

//        json = jsonObject.getAsJsonObject("colorMix");
//        if(colorMix.isPresent()){
//            colorId = colorMix.get().getColorId();
//        }
//        else {
//            colorId = 0;
//        }
    }

    @Override
    public JsonElement serialize(Optional<T> src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
