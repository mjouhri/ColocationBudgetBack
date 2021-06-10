package com.colocationbudget.colocationbudget.controller;

import com.colocationbudget.colocationbudget.dto.ColocationDto;
import com.colocationbudget.colocationbudget.dto.UserColocationDto;
import com.colocationbudget.colocationbudget.service.UserColocationsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

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

    @CrossOrigin
    @PostMapping(value = "/newColocation/{idUser}")
    public void newColocation(HttpServletRequest request, @PathVariable Long idUser, @PathParam("name") String name) {
        userColocationsService.newColocation(name, idUser);
    }

}
