package com.javaweb.converter;

import com.javaweb.model.AuthorDTO;
import com.javaweb.repository.AuthorRepository;
import com.javaweb.repository.entity.AuthorEntity;
import com.javaweb.repository.entity.BookEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AuthorRepository authorRepository;
    public AuthorDTO toAuthor(AuthorEntity authorEntity) {
        AuthorDTO authorDTO = modelMapper.map(authorEntity, AuthorDTO.class);
        authorDTO.setId(authorEntity.getId());
        authorDTO.setBirthyear(authorEntity.getBirthyear());
        authorDTO.setAuthorname(authorEntity.getAuthorname());
        return authorDTO;
    }
    public AuthorEntity toAuthorinsert(AuthorDTO authorDTO) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setAuthorname(authorDTO.getAuthorname());
        authorEntity.setBirthyear(authorDTO.getBirthyear());
        return authorEntity;
    }
    public AuthorEntity toAuthorupdate(AuthorDTO authorDTO) {
        AuthorEntity authorEntity = authorRepository.findById(authorDTO.getId()).get();
        authorEntity.setAuthorname(authorDTO.getAuthorname());
        authorEntity.setBirthyear(authorDTO.getBirthyear());
        return authorEntity;
    }
}
