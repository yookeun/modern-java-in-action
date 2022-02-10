package chap06;

import chap04.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;


public class Chap06Main4 {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partitionedMenu = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        List<Dish> vegetarianDishes = Dish.menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarianDishes);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegerMenuByType = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(vegerMenuByType);

        Map<Boolean, Dish> mostCaloriVg = Dish.menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println(mostCaloriVg);
    }
}
