package chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredicateMain {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList(
                "A",
                "B",
                "C",
                "D",
                ""
        );
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);
        for (String s : nonEmpty) {
            System.out.println(s);
        }

    }

    public static <T> List<T> filter(List<T> list, Predicate p) {
        List<T> results = new ArrayList<>();
        for (T t: list) {
            if(p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }
}

