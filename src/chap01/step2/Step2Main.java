package chap01.step2;

import common.Apple;
import common.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step2Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        List<Apple> apples1 = filterApples(inventory, new AppleGreenColorPredicate());
        for (Apple apple : apples1) {
            System.out.println(apple.getColor());
        }
        List<Apple> apples2 = filterApples(inventory, new AppleHeavyWeightPredicate());
        for (Apple apple : apples2) {
            System.out.println(apple.getWeight());
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
