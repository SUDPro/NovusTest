package com.test.controllers;

import com.test.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {

    private CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/top")
    public String getCatRatePage(ModelMap modelMap) {
        modelMap.addAttribute("cats", catService.getTop10ByRate());
        return "top";
    }

    @GetMapping("/vote")
    public String getCatVotePage() {
        return "vote";
    }

    @GetMapping("/")
    public String getStartPage() {
        return "start";
    }
}