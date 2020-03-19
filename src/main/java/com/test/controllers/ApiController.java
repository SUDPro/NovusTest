package com.test.controllers;

import com.test.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApiController {

    @Autowired
    CatService catService;

    @GetMapping("/api/getCats")
    public ResponseEntity getCats() {
        return ResponseEntity.ok(catService.getRandomCats());
    }

    @PostMapping("/api/voteCat")
    public ResponseEntity voteForCat(@RequestParam("id") Long id) {
        try {
            catService.voteForCat(id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}