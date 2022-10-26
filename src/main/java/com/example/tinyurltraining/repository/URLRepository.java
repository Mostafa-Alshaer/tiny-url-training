package com.example.tinyurltraining.repository;

import com.example.tinyurltraining.entity.URLEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface URLRepository extends MongoRepository<URLEntity, String>{
}
