package com.example.tinyurltraining.service;

import com.example.tinyurltraining.entity.URLEntity;
import com.example.tinyurltraining.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService implements IURLService{

    final static private int BASE36_NUMBER = 36;
    private static long counter = 1;

    @Autowired
    private URLRepository urlRepository;

    public URLEntity getURLByKey(String key){
        return urlRepository.findURLEntityByKey(key);
    }

    public URLEntity creatURLMapping(String longURL){
        URLEntity urlEntity = new URLEntity(longURL, Long.toString(counter++, BASE36_NUMBER));
        return urlRepository.save(urlEntity);
    }
}
