package chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chap05Main2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");
        List<String> collect = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);


        String[] arrayOfWords = {"Hello", "World"};
        Stream<String> stringStream = Arrays.stream(arrayOfWords);
        System.out.println(stringStream);


        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> squars = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squars);




    }
}
