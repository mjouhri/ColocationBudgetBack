package com.colocationbudget.colocationbudget.service;

import com.colocationbudget.colocationbudget.dto.UserColocationDto;
import com.colocationbudget.colocationbudget.model.Colocation;
import com.colocationbudget.colocationbudget.model.User;
import com.colocationbudget.colocationbudget.model.UserColocation;
import com.colocationbudget.colocationbudget.repository.ColocationRepository;
import com.colocationbudget.colocationbudget.repository.UserColocationsRepository;
import com.colocationbudget.colocationbudget.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserColocationsService {

    private UserColocationsRepository userColocationsRepository;
    private ColocationRepository colocationRepository;
    private UserRepository userRepository;

    public UserColocationsService(UserColocationsRepository userColocationsRepository, ColocationRepository colocationRepository, UserRepository userRepository) {
        this.userColocationsRepository = userColocationsRepository;
        this.colocationRepository = colocationRepository;
        this.userRepository = userRepository;
    }

    public UserColocationDto getByIdUser(Long idUser) {
        return userColocationsRepository.getByUserId(idUser) != null ? userColocationsRepository.getByUserId(idUser).toDto() : null;
    }

    public Integer getNbColocationsByIdUser(Long idUser) {
        return userColocationsRepository.getByUserId(idUser) != null ? userColocationsRepository.getByUserId(idUser).getColocations().size() : 0;
    }
    public void newColocation(String name, Long idUser){

        UserColocation userColocation = this.userColocationsRepository.getByUserId(idUser);

        if(idUser != null && userColocation != null){
            User user = this.userRepository.getById(idUser);
            Colocation colocation = new Colocation();
            colocation.setOwner(user);
            colocation.setName(name);

            colocation = this.colocationRepository.getById(this.colocationRepository.create(colocation));
            userColocation.getColocations().add(colocation);

            this.userColocationsRepository.update(userColocation);


        }


    }

}
