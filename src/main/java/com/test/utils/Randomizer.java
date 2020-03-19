package com.test.utils;

import java.util.Random;

public class Randomizer {

    public static int [] getRandomArray(int n){
        int arr [] = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n) + 1;
        }
        return arr;
    }
}