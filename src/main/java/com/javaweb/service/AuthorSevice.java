package com.javaweb.service;

import com.javaweb.model.AuthorDTO;
import com.javaweb.model.BookDTO;
import com.javaweb.repository.entity.AuthorEntity;

import java.util.List;
import java.util.Map;

public interface AuthorSevice {
    Map<Long,String> getauthors();
    List<AuthorDTO> findAll(Map<String,Object> params);
    void insertAuthor(AuthorDTO authorDTO);
    void updateAuthor(Long id,AuthorDTO authorDTO);
    void deleteAuthor(Long id);
    AuthorDTO findById(Long id);
}
