package com.test;

import com.test.repositories.CatRepository;
import com.test.services.CatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskApplicationTests {

    @Autowired
    private CatRepository catRepository;

    @Autowired
    private CatService catService;

    @Test
    public void testConcurrenceVotingForCat() {
        List<Thread> threads = new ArrayList<>();
        int threadsNum = 4;
        int updatesCount = 10;
        for (int i = 0; i < threadsNum; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < updatesCount; j++) {
                    catService.voteForCat(1L);
                }
            });
            threads.add(thread);
        }
        threads.forEach(Thread::start);
        threads.forEach(x -> {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        assertEquals(threadsNum * updatesCount, catRepository.findById(1L).get().getRate().intValue());
    }
}