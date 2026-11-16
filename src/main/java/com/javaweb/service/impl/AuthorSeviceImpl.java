package com.javaweb.service.impl;

import com.javaweb.builder.AuthorSearchBuilder;
import com.javaweb.converter.AuthorConverter;
import com.javaweb.converter.AuthorSearchConverter;
import com.javaweb.model.AuthorDTO;
import com.javaweb.model.BookDTO;
import com.javaweb.repository.AuthorRepository;
import com.javaweb.repository.entity.AuthorEntity;
import com.javaweb.repository.entity.BookEntity;
import com.javaweb.service.AuthorSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AuthorSeviceImpl implements AuthorSevice {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorConverter authorConverter;
    @Override
    public Map<Long, String> getauthors() {
        Map<Long,String> authors = new HashMap<>();
        List<AuthorEntity> authorEntities = authorRepository.findAll();
        for(AuthorEntity authorEntity : authorEntities) {
            authors.put(authorEntity.getId(),authorEntity.getAuthorname());
        }
        return authors;
    }

    @Override
    public List<AuthorDTO> findAll(Map<String, Object> params) {
        AuthorSearchBuilder authorSearchBuilder = new AuthorSearchConverter().toAuthorSearchBuilder(params);
        List<AuthorEntity> authorEntities = authorRepository.findAll(authorSearchBuilder);
        List<AuthorDTO> result = new ArrayList<>();
        for(AuthorEntity authorEntity : authorEntities) {
            AuthorDTO authorDTO = authorConverter.toAuthor(authorEntity);
            result.add(authorDTO);
        }
        return result;
    }

    @Override
    public void insertAuthor(AuthorDTO authorDTO) {
        AuthorEntity authorEntity = authorConverter.toAuthorinsert(authorDTO);
        authorRepository.save(authorEntity);
    }

    @Override
    public void updateAuthor(Long id,AuthorDTO authorDTO) {
        AuthorEntity authorEntity = authorConverter.toAuthorupdate(authorDTO);
        authorRepository.save(authorEntity);
    }

    @Override
    @Transactional
    public void deleteAuthor(Long id) {
        AuthorEntity author = authorRepository.findById(id).get();
        for (BookEntity b : new ArrayList<>(author.getBooks())) {
            b.getAuthors().remove(author);
        }
        authorRepository.delete(author);
    }

    @Override
    public AuthorDTO findById(Long id) {
        return authorConverter.toAuthor(authorRepository.findById(id).get());
    }
}
