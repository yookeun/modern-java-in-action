package chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chap04Main {
    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = Dish.menu
                .stream()  //스트림을 얻는다.
                .filter(dish -> dish.getCalories() > 300) //고칼로리를 필터링 한다.
                .map(Dish::getName) //요리명을 추출한다.
                .limit(3) //선착순 3개만
                .collect(Collectors.toList()); //결과를 다른 리스트로 저장한다.

        System.out.println(threeHighCaloricDishNames);

        List<String> title = Arrays.asList("java8", "in", "action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
//        s.forEach(System.out::println);


        //외부반복을 통해 가져오는 전통적인 방법
        List<String> names = new ArrayList<>();
        Iterator<Dish> iterator = Dish.menu.iterator();
        while(iterator.hasNext()) {
            Dish dish = iterator.next();
            names.add(dish.getName());
        }
        System.out.println(names);

        //스트림의 내부반복을 통해 가져오는 방법
        List<String> names2 = Dish.menu.stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(names2);
    }
}
