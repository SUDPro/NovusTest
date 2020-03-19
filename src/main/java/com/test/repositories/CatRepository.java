package com.test.repositories;

import com.test.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {

    @Query(value = "SELECT * from cat ORDER BY rate DESC LIMIT 10", nativeQuery = true)
    List<Cat> getTop10ByRate();

    @Query(value = "SELECT * FROM cat ORDER BY RANDOM() LIMIT ?1", nativeQuery = true)
    List<Cat> getRandomCats(Integer limit);
}