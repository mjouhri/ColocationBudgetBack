package com.colocationbudget.colocationbudget.service;

import com.colocationbudget.colocationbudget.dto.UserColocationDto;
import com.colocationbudget.colocationbudget.repository.UserColocationsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserColocationsService {

    private UserColocationsRepository userColocationsRepository;

    public UserColocationsService(UserColocationsRepository userColocationsRepository) {
        this.userColocationsRepository = userColocationsRepository;
    }

    public UserColocationDto getByIdUser(Long idUser) {
        return userColocationsRepository.getById(idUser) != null ? userColocationsRepository.getById(idUser).toDto() : null;
    }

    public Integer getNbColocationsByIdUser(Long idUser) {
        return userColocationsRepository.getById(idUser) != null ? userColocationsRepository.getById(idUser).getColocations().size() : 0;

    }

}
