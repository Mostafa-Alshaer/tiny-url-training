package com.example.tinyurltraining.service;

import com.example.tinyurltraining.entity.URLEntity;
import com.example.tinyurltraining.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class URLService {

    @Autowired
    URLRepository urlRepository;

    public List<URLEntity> getAll(){
        urlRepository.save(new URLEntity("hello url"));
        return urlRepository.findAll();
    }
}
