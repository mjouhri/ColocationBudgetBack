package com.colocationbudget.colocationbudget.service;

import com.colocationbudget.colocationbudget.dto.ColocationDto;
import com.colocationbudget.colocationbudget.model.Colocation;
import com.colocationbudget.colocationbudget.model.User;
import com.colocationbudget.colocationbudget.repository.ColocationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ColocationService {

    private ColocationRepository colocationRepository;

    public ColocationService(ColocationRepository colocationRepository) {
        this.colocationRepository = colocationRepository;
    }

    public ColocationDto getById(Long idColocation) {
        return colocationRepository.getById(idColocation) != null ? colocationRepository.getById(idColocation).toDto() : null;
    }

    public void create(Colocation colocation) {
        colocationRepository.create(colocation);
    }

    public void update(Colocation colocation) {
        colocationRepository.update(colocation);
    }

    public void addUser(Colocation colocation, User user){
        colocation.getUsers().add(user);
        colocationRepository.update(colocation);
    }

    public void deleteUser(Colocation colocation, User user){
        colocation.getUsers().remove(user);
        colocationRepository.update(colocation);
    }

    public void changeOwner(Colocation colocation, User user){
        colocation.setOwner(user);
        colocationRepository.update(colocation);
    }

}
