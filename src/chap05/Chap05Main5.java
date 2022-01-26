package chap05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chap05Main5 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        String home =  "aaa";
        //Stream<String> homeValues = home == null ? Stream.empty() : Stream.of(home);
        Stream<String> homeValues = Stream.ofNullable(home);
        System.out.println(homeValues.collect(Collectors.toList()));

        int[] numbers = {2,3,5,7,11,13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
        readWord();
        System.out.println("=========================");

        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        fb();

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        fb2();
    }

    private static void readWord() {
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("C:\\workspace\\modern-java-in-action\\src\\chap05\\test.txt"),
                Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(uniqueWords);
    }

    private static void fb() {
        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                //.forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    private static void fb2() {
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
    }
}
