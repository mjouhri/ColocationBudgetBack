package com.colocationbudget.colocationbudget.controller;

import com.colocationbudget.colocationbudget.dto.UserColocationDto;
import com.colocationbudget.colocationbudget.service.UserColocationsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Validated
@RequestMapping(value = "/api/user/colocations")
public class UserColocationsController {
    private UserColocationsService userColocationsService;

    public UserColocationsController(UserColocationsService userColocationsService) {
        this.userColocationsService = userColocationsService;
    }

    @CrossOrigin
    @GetMapping(value = "/{idUser}")
    public UserColocationDto getByIdUser(HttpServletRequest request, @PathVariable Long idUser) {
        return userColocationsService.getByIdUser(idUser);
    }

    @CrossOrigin
    @GetMapping(value = "/nb/{idUser}")
    public Integer getNbColocationsByIdUser(HttpServletRequest request, @PathVariable Long idUser) {
        return userColocationsService.getNbColocationsByIdUser(idUser);
    }

}
