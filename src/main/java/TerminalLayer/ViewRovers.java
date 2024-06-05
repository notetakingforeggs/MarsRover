package TerminalLayer;

import Models.Plateau;
import Models.Rover;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class ViewRovers {
    void viewRover(Plateau plateau){
       ObjectMapper objectMapper = new ObjectMapper();
       objectMapper.enable(SerializationFeature.INDENT_OUTPUT);


        try {
            String json = objectMapper.writeValueAsString(plateau.rovers);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    };
}
