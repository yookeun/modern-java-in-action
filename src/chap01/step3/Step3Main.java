package chap01.step3;

import common.Apple;
import common.Color;
import chap01.step2.ApplePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Step3Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)
        );

        //익명 클래스로 처리
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals(Color.RED);
            }
        });
        for (Apple redApple : redApples) {
            System.out.println(redApple.getColor());
        }

        List<Apple> weightApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        for (Apple weightApple : weightApples) {
            System.out.println(weightApple.getWeight());
        }

        //최종 람다로 표시
        List<Apple> greenApples = filterApples(inventory, (Apple a) -> a.getColor().equals(Color.GREEN));
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple.getColor());
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
