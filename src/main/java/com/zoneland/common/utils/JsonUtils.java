package com.zoneland.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//Nullable需要引入spring-web包

public class JsonUtils {
    public static final ObjectMapper mapper = new ObjectMapper();
    //需要引入spring-boot-starter-logging包
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    /**
     * 对象转换为json字符串
     * @param obj
     * @return
     */
    @Nullable
    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
                @Override
                public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                    jsonGenerator.writeString("");
                }
            });
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    /**
     * json字符串转换为对象
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    @Nullable
    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    /**
     * json字符串转换为对象 集合
     * @param json
     * @param eClass
     * @param <E>
     * @return
     */
    @Nullable
    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Nullable
    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static void main(String[] args) {

        String json="{\"namge\":\"zhuxinjun\",\"age\":\"21\"}";
        Map<String, String> map = toMap(json, String.class, String.class);
        System.out.println("map:"+map);
        String j="[{\"namge\":\"zhuxinjun\",\"age\":\"21\"},{\"namge\":\"yangyang\",\"age\":\"32\"}]";
        List<Map<String, String>> maps = nativeRead(j, new TypeReference<List<Map<String, String>>>() {
        });
        for(Map<String,String> map1:maps){
            System.out.println("map1"+map1);
        }
    }
}