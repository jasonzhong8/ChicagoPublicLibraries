package com.jasonzhong.chicagopubliclibraries.util;

import com.jasonzhong.chicagopubliclibraries.model.Library;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junzhong on 2017-08-20.
 */

public class JsonParser {

    public static List<Library> parseLibrary(String jsonResult) throws JSONException {
        List<Library> libraryList = new ArrayList<>();
        JSONArray jsonarray = new JSONArray(jsonResult);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            Library library = new Library();
            library.setTeacher_in_the_library(jsonobject.optString("teacher_in_the_library"));
            library.setZip(jsonobject.optString("zip"));
            library.setHours_of_operation(jsonobject.optString("hours_of_operation"));
            library.setAddress(jsonobject.optString("address"));
            library.setCity(jsonobject.optString("city"));
            library.setPhone(jsonobject.optString("phone"));
            library.setState(jsonobject.optString("state"));
            library.setCybernavigator(jsonobject.optString("cybernavigator"));
            library.setName_(jsonobject.optString("name_"));

            JSONObject jsonoWebsiteObject = jsonobject.optJSONObject("website");
            library.setWebsite(jsonoWebsiteObject.optString("url"));

            JSONObject jsonoLocationObject = jsonobject.optJSONObject("location");
            library.setLatitude(jsonoLocationObject.optString("latitude"));
            library.setLongitude(jsonoLocationObject.optString("longitude"));
            library.setNeeds_recoding(jsonoLocationObject.optBoolean("needs_recoding"));

            libraryList.add(library);
        }
        return libraryList;
    }
}
