package com.test.services;

import com.test.models.Cat;
import com.test.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> getTop10ByRate() {
        return catRepository.getTop10ByRate();
    }

    public List<Cat> getRandomCats() {
        return catRepository.getRandomCats(20);
    }

    public void voteForCat(Long id) {
        Cat cat = catRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        cat.setRate(cat.getRate() + 1);
        catRepository.save(cat);
    }
}