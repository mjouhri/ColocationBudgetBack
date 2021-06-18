package com.colocationbudget.colocationbudget.controller;

import com.colocationbudget.colocationbudget.dto.UserDto;
import com.colocationbudget.colocationbudget.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@Validated
@RequestMapping(value = "/api/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public UserDto getById(HttpServletRequest request, @PathVariable Long id) {
        return userService.getById(id);
    }

    @CrossOrigin
    @GetMapping(value = "")
    public UserDto getByMail(HttpServletRequest request, @PathParam("mail") String mail) {
        return userService.getByMail(mail);
    }

    @CrossOrigin
    @PostMapping(value = "")
    public void create(HttpServletRequest request, @RequestBody UserDto userDto) {
        userService.create(userDto);
    }

    @CrossOrigin
    @PutMapping(value = "")
    public void update(HttpServletRequest request, @RequestBody UserDto userDto) {
        userService.update(userDto);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(HttpServletRequest request, @PathVariable Long id) {
        userService.delete(id);
    }
    
}
