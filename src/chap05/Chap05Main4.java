package chap05;

import chap04.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chap05Main4 {
    public static void main(String[] args) {

        // 메뉴의 칼로리 합계
        int calories = Dish.menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println(calories);

        int calories2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(calories2);

        IntStream intStream = Dish.menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        System.out.println(stream);

        OptionalInt maxCalories = Dish.menu.stream().mapToInt(Dish::getCalories).max();
        System.out.println(maxCalories.orElse(1));  //값이 없을때 기본값


        // 숫자 범위
        IntStream evenNumbers = IntStream.rangeClosed(1, 100) // 1 ~ 100까지의 범위를 나타낸다.
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());
    }
}
