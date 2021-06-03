package com.colocationbudget.colocationbudget.controller;

import com.colocationbudget.colocationbudget.dto.ColocationDto;
import com.colocationbudget.colocationbudget.service.ColocationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Validated
@RequestMapping(value = "/api/colocation")
public class ColocationController {
    private static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";

    private ColocationService colocationService;

    public ColocationController(ColocationService colocationService) {
        this.colocationService = colocationService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ColocationDto getById(HttpServletRequest request, @PathVariable Long id
//                                 @RequestParam(value = "date", required = false, defaultValue = "")
//                                     @DateTimeFormat(pattern = LOCAL_DATE_FORMAT) String date
    ) {
        return colocationService.getById(id);
    }

    @CrossOrigin
    @PostMapping(value = "")
    public void create(HttpServletRequest request, @RequestBody ColocationDto colocationDto) {
        colocationService.create(colocationDto.toEntity());
    }

    @CrossOrigin
    @PutMapping(value = "")
    public void update(HttpServletRequest request, @RequestBody ColocationDto colocationDto) {
        colocationService.update(colocationDto.toEntity());
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public void delete(HttpServletRequest request, @PathVariable Long id) {
        //colocationService.delete(id);
    }
}
