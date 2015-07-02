package com.sandlex.run2gather.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sandlex.run2gather.runkeeper.model.types.*;

import java.lang.reflect.Type;

/**
 * author: Alexey Peskov
 */
public class EnumAdapter implements JsonDeserializer<Enum> {

    @Override
    public Enum deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (type.equals(Gender.class)) {
            return Gender.fromValue(jsonElement.getAsString());
        } else if (type.equals(ActivityType.class)) {
            return ActivityType.fromValue(jsonElement.getAsString());
        } else if (type.equals(AthleteType.class)) {
            return AthleteType.fromValue(jsonElement.getAsString());
        } else if (type.equals(PathType.class)) {
            return PathType.fromValue(jsonElement.getAsString());
        } else if (type.equals(ShareType.class)) {
            return ShareType.fromValue(jsonElement.getAsString());
        }

        throw new IllegalArgumentException("Undefined enumeration type: " + type);
    }
}
