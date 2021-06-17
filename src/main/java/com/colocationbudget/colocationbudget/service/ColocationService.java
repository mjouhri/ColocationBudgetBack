package com.colocationbudget.colocationbudget.service;

import com.colocationbudget.colocationbudget.dto.ColocationDto;
import com.colocationbudget.colocationbudget.dto.TypeDto;
import com.colocationbudget.colocationbudget.model.Colocation;
import com.colocationbudget.colocationbudget.model.Spend;
import com.colocationbudget.colocationbudget.model.Type;
import com.colocationbudget.colocationbudget.model.User;
import com.colocationbudget.colocationbudget.repository.ColocationRepository;
import com.colocationbudget.colocationbudget.repository.SpendRepository;
import com.colocationbudget.colocationbudget.repository.TypeRespository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ColocationService {

    private ColocationRepository colocationRepository;
    private SpendRepository spendRepository;
    private TypeRespository typeRespository;

    public ColocationService(ColocationRepository colocationRepository, SpendRepository spendRepository, TypeRespository typeRespository) {
        this.colocationRepository = colocationRepository;
        this.spendRepository = spendRepository;
        this.typeRespository = typeRespository;
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

    public void addSpendToColocation(Long idColocation, Spend spend){
        Colocation colocation = colocationRepository.getById(idColocation);
        Long idSpend = spendRepository.create(spend);
        spend = spendRepository.getById(idSpend);

        colocation.getSpends().add(spend);

        colocationRepository.update(colocation);
    }

    public List<TypeDto> getListSpendType() {
            return typeRespository.getAll().parallelStream()
                    .map(Type::toDto)
                    .collect(Collectors.toList());
    }

    public List<User> getUsersofColocation(Long idColocation) {
        List<User> users = colocationRepository.getUsersofColocation(idColocation);
        users.add(colocationRepository.getOwerColocation(idColocation));
        return users;
    }

}
