package com.example.springmongodb.services;

import com.example.springmongodb.document.TestDocument;
import com.example.springmongodb.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public void createAndAddService(){
        Collection<TestDocument> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            list.add(new TestDocument("Text " + i));
        }
        testRepository.saveAll(list);
    }

    public Collection<TestDocument> getAll(){
        return testRepository.findAll();
    }

}
