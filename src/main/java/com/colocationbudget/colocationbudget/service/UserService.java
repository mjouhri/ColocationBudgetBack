package com.colocationbudget.colocationbudget.service;

import com.colocationbudget.colocationbudget.dto.UserDto;
import com.colocationbudget.colocationbudget.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getById(Long idUser) {
        return userRepository.getById(idUser).toDto();
    }

    public UserDto getByMail(String mail) {
        return userRepository.getByMail(mail) != null ? userRepository.getByMail(mail).toDto() : null;
    }

    public void create(UserDto userDto) {
        userRepository.create(userDto.toEntity());
    }

    public void update(UserDto userDto) {
        userRepository.update(userDto.toEntity());
    }

    public void delete(Long id) {
        userRepository.delete(userRepository.getById(id));
    }
}
