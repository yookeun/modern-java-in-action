package chap05;

import chap04.Dish;

import java.util.*;
import java.util.stream.Collectors;


public class QuestionMain {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        // 1. 2011년에 일어난 모든 트랜젝션을 찾아서 값을 오름차순으로 정렬하시오.
        List<Transaction> result = transactions.stream()
                .filter(tr -> tr.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(result);

        // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> result2 = transactions.stream()
                .map(tr -> tr.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result2);

        Set<String> result3 = transactions.stream()
                .map(tr -> tr.getTrader().getCity())
                .collect(Collectors.toSet());
        System.out.println(result3);

        // 3. 캠브릿지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

        // 4. 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오
        List<String> sort1 = transactions.stream()
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sort1);

        String sort2 = transactions.stream()
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(sort2);

        String sort3 = transactions.stream()
                .map(tr -> tr.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(sort3);

        // 5. 밀라노에 거래자가 있는가?
        boolean milanBased = transactions.stream().anyMatch(tr -> tr.getTrader().getCity().equals("Milan"));
        System.out.println(milanBased);

        // 6. 캠브릿지에 거주하는 거래자의 모든 트랜젝션 값을 출력하시오
        transactions.stream().filter(tr -> tr.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 7. 전체 트랜젝션 값중에 최댓값은 얼마인가?
        Optional<Integer> max = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(max.get());

        // 8. 전체 트랜젝션 값중에 최솟값은 얼마인가?
        Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(min.get());

        // 9. 최솟값의 거래내역을 가져와라.
        Optional<Transaction> reduce = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(reduce.get());

    }
}
