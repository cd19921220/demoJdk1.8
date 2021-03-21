package com.dong.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {


    @FunctionalInterface
    public interface AppleFilter {
        boolean filter(Apple apple);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    public static class GreenAnd160WeightFilt implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 160);
        }
    }

    public static class YellowAnd150WeightFilt implements AppleFilter {
        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("yellow") && apple.getWeight() >= 150);
        }
    }

    public static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));

//        List<Apple> greenApples = findGreenApple(list);
//        assert greenApple.size() == 2;

//        List<Apple> greenApples = findApple(list, "green");
//          System.out.println("greenApple = " + greenApples);

//        List<Apple> result = findApple(list, new GreenAnd160WeightFilt());
//
//        System.out.println("result = " + result);
//
//        List<Apple> yellowResult =  findApple(list, new AppleFilter() {
//            @Override
//            public boolean filter(Apple apple) {
//                return "yellow".equals(apple.getColor());
//            }
//        });
//
//        System.out.println("yellowResult = " + yellowResult);

//
//        List<Apple> lambdaResult = findApple(list, (Apple apple) -> {
//            return  apple.getColor().equals("green");
//        });
//
//        List<Apple> lambdaResult0 = findApple(list, apple -> apple.getColor().equals("green"));
//        System.out.println("lambdaResult = " + lambdaResult);

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });
//        thread.start();

//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
