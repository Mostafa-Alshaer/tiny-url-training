package com.example.tinyurltraining.service;

import com.example.tinyurltraining.entity.URLEntity;
import com.example.tinyurltraining.exception.NotFoundException;
import com.example.tinyurltraining.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class URLService{

    final static private int BASE36 = 36;

    @Autowired
    private URLRepository urlRepository;

    @Autowired
    private SequencerService sequencerService;

    @Cacheable( value="url", key="#key")
    public String getLongURLByKey(String key){
        URLEntity urlEntity = urlRepository.findURLEntityByKey(key);

        if(urlEntity == null){
            throw new NotFoundException("The provided key doesn't exist!");
        }

        return urlEntity.getLongURL();
    }

    public URLEntity creatURLMapping(String longURL){
        Long nextNumber = sequencerService.getNextNumber();
        String nextNumberBase36 = Long.toString(nextNumber, BASE36);
        URLEntity urlEntity = new URLEntity(longURL, nextNumberBase36);
        return urlRepository.save(urlEntity);
    }
}
