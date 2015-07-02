package com.sandlex.run2gather.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sandlex.run2gather.runkeeper.Requestor;
import com.sandlex.run2gather.runkeeper.model.types.*;

import java.text.DateFormat;

/**
 * author: Alexey Peskov
 */
public class GsonBuiderWrapper {

    //TODO make it springy

    private static GsonBuiderWrapper instance;
    private GsonBuilder builder;

    public static GsonBuiderWrapper getInstance() {
        if (instance == null) {
            instance = new GsonBuiderWrapper();
        }

        return instance;
    }


    private GsonBuiderWrapper() {
        builder = new GsonBuilder();
        builder.setDateFormat(Requestor.DATE_FORMAT);
        builder.registerTypeAdapter(ShareType.class, new EnumAdapter());
        builder.registerTypeAdapter(PathType.class, new EnumAdapter());
        builder.registerTypeAdapter(AthleteType.class, new EnumAdapter());
        builder.registerTypeAdapter(Gender.class, new EnumAdapter());
        builder.registerTypeAdapter(ActivityType.class, new EnumAdapter());
    }

    public Gson createGson() {
        return builder.create();
    }

}
