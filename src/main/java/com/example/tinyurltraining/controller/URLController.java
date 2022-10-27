package com.example.tinyurltraining.controller;

import com.example.tinyurltraining.dto.UrlDto;
import com.example.tinyurltraining.service.URLService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class URLController {

    @Autowired
    private URLService urlService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    public ResponseEntity addURLMapping(@RequestBody UrlDto urlDto){
        UrlDto createdUrlDto = modelMapper.map(urlService.creatURLMapping(urlDto.getLongURL()), UrlDto.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdUrlDto);
    }

    @GetMapping("/{key}")
    public ResponseEntity redirect(@PathVariable String key){
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create(urlService.getURLByKey(key).getLongURL())).build();
    }
}
