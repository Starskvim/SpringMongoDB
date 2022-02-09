package com.example.springmongodb.repository;


import com.example.springmongodb.document.TestDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository <TestDocument, Long > {



}
