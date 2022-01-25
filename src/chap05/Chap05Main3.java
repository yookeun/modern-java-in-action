package chap05;

import chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Chap05Main3 {
    public static void main(String[] args) {
        if (Dish.menu.stream().anyMatch(dish -> dish.getCalories() > 300)) {
            System.out.println("YES");
        }
        if (Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("YES");
        }
        if (Dish.menu.stream().noneMatch(dish -> dish.getCalories() < 100)) {
            System.out.println("YES");
        }

        Optional<Dish> any = Dish.menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(any.isPresent());

        Dish.menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(dish -> System.out.println(dish.getName()));


        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> first = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(first.get());
    }
}
