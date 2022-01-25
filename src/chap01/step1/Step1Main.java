package chap01.step1;

import common.Apple;
import common.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step1Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED),
                new Apple(160, Color.RED)
        );
        List<Apple> apples = filterGreenApples(inventory);
        for (Apple apple : apples) {
            System.out.println(apple.getColor());
        }

        List<Apple> apples2 = filterApplesByWeight(inventory, 150);
        for (Apple apple : apples2) {
            System.out.println(apple.getColor() + ", " + apple.getWeight());
        }
    }


    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>(); //사과 누적 리스트
        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) { //녹색 사과만 선택
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>(); //사과 누적 리스트
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) { //녹색 사과만 선택
                result.add(apple);
            }
        }
        return result;
    }
}
