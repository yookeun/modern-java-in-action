package chap05;

import chap04.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReducingMain {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);

        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);
        int sum2 = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum2);
        int sum3 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum3);

        Optional<Integer> sum4 = numbers.stream().reduce((a,b) -> a + b);
        System.out.println(sum4);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        Optional<Integer> max2 = numbers.stream().reduce((a, b) -> a > b ? a: b);
        System.out.println(max2.get());

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> min2 = numbers.stream().reduce((a, b) -> a < b ? a: b);
        System.out.println(min2.get());
        System.out.println(min.get());

        int count = Dish.menu.stream().map( d -> 1).reduce(0, (a, b) -> a + b);
        System.out.println(count);
    }
}
