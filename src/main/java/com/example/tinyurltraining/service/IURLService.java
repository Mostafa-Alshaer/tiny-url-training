package com.example.tinyurltraining.service;

import com.example.tinyurltraining.entity.URLEntity;

public interface IURLService {
    URLEntity getURLByKey(String key);
    URLEntity creatURLMapping(String longURL);
}
