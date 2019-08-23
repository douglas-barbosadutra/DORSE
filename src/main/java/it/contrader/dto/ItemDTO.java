package it.contrader.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ItemDTO {

    private String link;
    
    private String state;
    
    private boolean editable;
    
    private String type;
    
    private String name;
    
    private String label;
    
    private List<String> tags;
    
    private List<String> groupNames;
}
