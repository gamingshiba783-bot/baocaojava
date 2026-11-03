package com.javaweb.service.impl;

import com.javaweb.repository.AuthorRepository;
import com.javaweb.repository.entity.AuthorEntity;
import com.javaweb.service.AuthorSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AuthorSeviceImpl implements AuthorSevice {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Map<Long, String> getauthors() {
        Map<Long,String> authors = new HashMap<Long, String>();
        List<AuthorEntity> authorEntities = authorRepository.findAll();
        for(AuthorEntity authorEntity : authorEntities) {
            authors.put(authorEntity.getId(),authorEntity.getAuthorname());
        }
        return authors;
    }
}
