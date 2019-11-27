package com.football.cal.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public String url;
    public String flag;
    public List<String> geo;

    private Data() { }

    public static Data parse(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response);

            String url  = jsonObj.getString("url");
            String flag = jsonObj.getString("flag");
            List<String> geo = new ArrayList<>();

            JSONArray geoList = jsonObj.getJSONArray("geo");

            int length = geoList.length();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    geo.add(geoList.getString(i));
                }
            }

            Data data = new Data();
            data.url = url;
            data.flag = flag;
            data.geo = geo;

            return data;

        } catch (Exception e) { }

        return null;
    }
}
