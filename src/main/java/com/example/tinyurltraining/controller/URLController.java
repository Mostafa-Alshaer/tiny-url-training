package com.example.tinyurltraining.controller;

import com.example.tinyurltraining.dto.UrlDto;
import com.example.tinyurltraining.entity.URLEntity;
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
    public ResponseEntity<UrlDto> addURLMapping(@RequestBody UrlDto urlDto){
        URLEntity urlEntity = urlService.creatURLMapping(urlDto.getLongURL());
        UrlDto createdUrlDto = modelMapper.map(urlEntity, UrlDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUrlDto);
    }

    @GetMapping("/{key}")
    public ResponseEntity redirect(@PathVariable String key){
        String longURL = urlService.getLongURLByKey(key);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create(longURL)).build();
    }
}
