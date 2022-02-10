package chap06;

import chap04.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Chap06Main3 {

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }

    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu
                .stream()
                .collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu
                .stream()
                .collect(
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if(dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                );
        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, List<Dish>> filterCal = Dish.menu
                .stream()
                .filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));
        System.out.println(filterCal);

        Map<Dish.Type, List<Dish>> filterCal2 = Dish.menu
                .stream()
                .collect(groupingBy(
                        Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
        System.out.println(filterCal2);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishByTypeCalLevel =
                Dish.menu
                        .stream()
                        .collect(
                                groupingBy(Dish::getType,
                                        groupingBy(dish -> {
                                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                            else return CaloricLevel.FAT;
                                        }))
                        );
        System.out.println(dishByTypeCalLevel);

        Map<Dish.Type, Long> typesCount = Dish.menu
                .stream()
                .collect(groupingBy(Dish::getType, counting()));
        System.out.println(typesCount);


        Map<Dish.Type, Optional<Dish>> mostCaloricByType = Dish.menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
        System.out.println(mostCaloricByType);

    }
}
