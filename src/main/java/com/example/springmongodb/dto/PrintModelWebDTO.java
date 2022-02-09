package com.example.springmongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrintModelWebDTO {
    private String modelName;
    private String modelPath;
    private Double modelSize;
    private String modelCategory;
    private Collection<String> modelTagsNames;
    private Collection<PrintModelOTHWebDTO> modelOTHList = new ArrayList<>();

    @Override
    public String toString() {
        return "PrintModelWebDTO{" +
                "modelName='" + modelName + '\'' +
                ", modelPath='" + modelPath + '\'' +
                ", modelSize=" + modelSize +
                ", modelCategory='" + modelCategory + '\'' +
                ", modelTagsNames=" + modelTagsNames +
                ", modelOTHList=" + modelOTHList +
                '}';
    }
}
