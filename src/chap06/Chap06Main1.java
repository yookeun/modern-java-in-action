package chap06;

import chap04.Dish;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

public class Chap06Main1 {
    public static void main(String[] args) {
        Comparator<Dish> dishCaloriesComprator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = Dish.menu.stream().collect(Collectors.maxBy(dishCaloriesComprator));
        System.out.println(mostCaloriesDish.get());

        double avgCalories = Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        IntSummaryStatistics intSummaryStatistics = Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);

        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu);



        Optional<Dish> mostCaloriesDish2
                = Dish.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1: d2));
        System.out.println(mostCaloriesDish2.get());


        // 합계를 구하는 5가지 방식
        int totalCalories = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        int totalCalories2 = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i+j));
        System.out.println(totalCalories2);

        int totalCalories3 = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories3);

        int totalCalories4 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println(totalCalories4);

        int totalCalories5 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories5);



    }
}
