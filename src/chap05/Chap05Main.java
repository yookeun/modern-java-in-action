package chap05;

import chap04.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Chap05Main {
    public static void main(String[] args) {
        List<Dish> vegertarianDishes = new ArrayList<>();
        for (Dish d : Dish.menu) {
            if (d.isVegetarian()) {
                vegertarianDishes.add(d);
            }
        }
        System.out.println(vegertarianDishes);
        List<Dish> vegertarinsDishes2 = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println(vegertarinsDishes2);

//        Dish.menu.stream()
//                .filter(Dish::isVegetarian)
//                .map(Dish::getName)
//                .forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(filteredMenu);

        List<Dish> slicedMenu = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(slicedMenu);

        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(slicedMenu2);

        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 100)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(dishes);

        List<Dish> dishes2 = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 100)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(dishes2);

        List<Dish> meats = specialMenu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(meats);

        List<String> dishNames = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLenghs = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLenghs);

        List<Integer> dishNamesLengths = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNamesLengths);
    }
}
