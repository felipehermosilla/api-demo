package py.com.api.demo.framework.utils;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import py.com.api.demo.exceptions.ApplicationException;

/**
 * Helper class for Json to Java conversion
 *
 * @author felipehermosilla
 */
public class JSONUtils {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JSONUtils() {
    }

    /**
     * Serialice a objcet to JSON.
     */
    public static String toJSON(Object pojo) {
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(pojo);
        } catch (JsonProcessingException e) {
            throw new ApplicationException(e.toString());
        }
        return json;
    }

    public static <T> T fromJSON(String json, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    public static <T> T fromMap(Object map, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(map, clazz);
    }

    public static boolean isJSONValid(String jsonInString) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}


