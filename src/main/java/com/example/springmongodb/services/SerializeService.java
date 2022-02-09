package com.example.springmongodb.services;

import com.example.springmongodb.dto.PrintModelWebDTO;
import com.example.springmongodb.repository.TestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Setter
@Getter
public class SerializeService {

    private final TestRepository testRepository;

    private final MongoTemplate mongoTemplate;

    private final ObjectMapper objectMapper;


    public void addNewModel(byte[] bytes) {
        try {
            PrintModelWebDTO printModelWebDTO = objectMapper.readValue(bytes, PrintModelWebDTO.class);
            mongoTemplate.save(printModelWebDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
