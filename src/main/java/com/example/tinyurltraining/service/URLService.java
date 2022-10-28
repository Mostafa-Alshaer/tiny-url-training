package com.example.tinyurltraining.service;

import com.example.tinyurltraining.entity.URLEntity;
import com.example.tinyurltraining.exception.NotFoundException;
import com.example.tinyurltraining.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService{

    final static private int BASE36_NUMBER = 36;
    private static long counter = 1;

    @Autowired
    private URLRepository urlRepository;

    public String getLongURLByKey(String key){
        URLEntity urlEntity = urlRepository.findURLEntityByKey(key);

        if(urlEntity == null){
            throw new NotFoundException("The provided key doesn't exist!");
        }

        return urlEntity.getLongURL();
    }

    public URLEntity creatURLMapping(String longURL){
        URLEntity urlEntity = new URLEntity(longURL, Long.toString(counter++, BASE36_NUMBER));
        return urlRepository.save(urlEntity);
    }
}
