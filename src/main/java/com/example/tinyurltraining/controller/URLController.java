package com.example.tinyurltraining.controller;

import com.example.tinyurltraining.entity.URLEntity;
import com.example.tinyurltraining.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/urls")
public class URLController {

    @Autowired
    private URLService urlService;

    // redirect api: no problem here, but we need to try to get from cache before trying to hit mongodb

    // generate short url, the problem in getting small unique id as we are using mongodb -> the solution to create separate scalable sequencer service

    @GetMapping()
    public List<URLEntity> getAll(){
        return urlService.getAll();
    }
}
