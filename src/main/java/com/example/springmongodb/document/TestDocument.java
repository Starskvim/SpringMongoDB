package com.example.springmongodb.document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class TestDocument {

    @Id
    private ObjectId id;

    private String text;

    public TestDocument(String text){
        this.text = text;
    }


}
