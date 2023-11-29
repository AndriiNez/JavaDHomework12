package com.example.JavaDHomework12.generetId;

import org.springframework.stereotype.Service;

@Service
public class GeneretId {
    public long generet(Long size){
        return ++size;
    }
}

