package com.admin.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import java.util.Map;

public class JsonUtil {

    public static JSON xml2json(String xml) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        JSON json = xmlSerializer.read(xml);
        // xmlSerializer.read(String arg0);
        // xmlSerializer.readFromFile(File arg0);
        // xmlSerializer.readFromFile(String path);
        // xmlSerializer.readFromStream(InputStream arg0);
        return json;
    }

    public static String json2xml(String json) {
        JSONObject jobj = JSONObject.fromObject(json);
        // JSON jsonObject = JSONSerializer.toJSON(json);
        String xml = new XMLSerializer().write(jobj);
        return xml;
    }

    public static Map<String, String> json2map(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> jsonMap = mapper.readValue(json.toString(), new TypeReference<Map<String, Object>>() {
        });
        return jsonMap;
    }

    public static String jsonFormatter(String uglyJSONString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }

    public static String jsonFormatter(JSONObject result) {
        String uglyJSONString = result.toString();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }

    public static String jsonFormatter(Object obj) {
        String json = toJSON(obj);
        return jsonFormatter(json);
    }

    public static String toJSON(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }

}
