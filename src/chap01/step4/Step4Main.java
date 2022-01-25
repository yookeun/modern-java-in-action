package chap01.step4;

import common.Apple;

import common.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step4Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        List<Integer> integers = Arrays.asList(
                10,
                20,
                30,
                40,
                50
        );

        List<Apple> redApples = filter(inventory, (Apple a) -> a.getColor().equals(Color.RED));
        for (Apple redApple : redApples) {
            System.out.println(redApple.getColor());
        }
        List<Integer> mids = filter(integers, (Integer i) -> i > 30);
        for (Integer mid : mids) {
            System.out.println(mid);
        }

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }
}
