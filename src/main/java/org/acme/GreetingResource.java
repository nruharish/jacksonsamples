package org.acme;

import javax.validation.constraints.Max;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Value;

import java.lang.reflect.Array;
import java.util.*;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Person hello() {
        //ObjectMapper mapper = new ObjectMapper();
       // mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
      Map<String, Object> map = new HashMap<>();
        int array []={ };
        map.put("string", "value");
        map.put("int", 1);
        map.put("list", new ArrayList<>());
        //map.put("arr",new Arrays );
        map.put("arr", array);
        map.put("emptystring", "");
        map.put("null1", null);
        map.put("string2", "");
        //map.put(null, null);
        Person p = new Person("Harish", "Sitaram", "", null, new ArrayList<>());

        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);
       // mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        //mapper.configOverride(String.class).setInclude(Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_EMPTY));
        //below stripps of strings with null
        //mapper.configOverride(String.class).setInclude(Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_EMPTY));
        //below stripps of strings with null
      /*  mapper.configOverride(List.class).setInclude(Value.construct(JsonInclude.Include.NON_NULL, ));
        mapper.configOverride(ArrayList.class).setInclude(Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.NON_EMPTY));
        */
        mapper.configOverride(Collection.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));
        mapper.configOverride(List.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));
        mapper.configOverride(Map.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));
        mapper.configOverride(ArrayList.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.NON_EMPTY, null));
        mapper.configOverride(String.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, null));

        //below setter did not work - only for serilize we should use ?
               // .setSetterInfo(JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY));
        //mapper.

        try {
            System.out.println(mapper.writeValueAsString(p));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        //Person p = new Person("Harish", "Sitaram", "", new ArrayList<>());
        return p;
    }
}