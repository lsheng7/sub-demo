package com.example.subdemo.optimized;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoopOptimized {


    public static void main(String[] args) {
        OceanusList<String> oceanusList = new OceanusList<>();
        oceanusList.add("1");
        oceanusList.add("1");
        oceanusList.add("1");
        oceanusList.add("1");
        for (int i = 0; i < oceanusList.size(); i++) {
            System.out.println(oceanusList.get(i));
        }
        System.out.println("========================");
        final int size = oceanusList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(oceanusList.get(i));
        }
    }

}

class OceanusList<E> extends ArrayList<E> {

    @Override
    public int size() {
        System.out.println("loop");
        return super.size();
    }
}