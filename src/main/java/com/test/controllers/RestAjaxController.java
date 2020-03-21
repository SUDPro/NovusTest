package com.test.controllers;

import com.test.models.Cat;
import com.test.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestAjaxController {

    private CatService catService;
    private ResponseEntity responseEntityOk = ResponseEntity.ok().build();
    private ResponseEntity responseEntityBadRequest = ResponseEntity.badRequest().build();

    @Autowired
    public RestAjaxController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/api/getCats")
    public List<Cat> getCats() {
        return catService.getRandomCats();
    }

    @PostMapping("/api/voteCat")
    public ResponseEntity voteForCat(@RequestParam("id") Long id) {
        try {
            catService.voteForCat(id);
        } catch (IllegalArgumentException e) {
            return responseEntityBadRequest;
        }
        return responseEntityOk;
    }
}