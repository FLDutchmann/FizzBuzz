import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {
    public static void main(String[] args) {
        for(int i = 1; i <= 300; i++) {
            List<BasicRule> basicRules = new ArrayList<>();
            basicRules.add(new BasicRule(3, "Fizz"));
            basicRules.add(new BasicRule(13, "Fezz"));
            basicRules.add(new BasicRule(5, "Buzz"));
            basicRules.add(new BasicRule(7, "Bang"));

            List<String> words = new ArrayList<>();

            for(BasicRule rule: basicRules) {
                addWordIfDivisible(i, rule.divisor, rule.word, words);
            }

            if(i % 11 == 0) {
                words.add("Bong");
                words = words.stream()
                             .filter((word)-> !word.equals("Fizz") && !word.equals("Buzz") && !word.equals("Bang"))
                             .collect(Collectors.toList());
            }

            if(i % 17 == 0) Collections.reverse(words);


            if(words.isEmpty()) {
                System.out.print(i);
            } else {
                for(String word: words) System.out.print(word);
            }
            System.out.println();
        }
    }

    public static void addWordIfDivisible(int iterator, int divisor, String word, List<String> words){
        if(iterator % divisor == 0) words.add(word);
    }

    private static class BasicRule {
        public int divisor;
        public String word;

        BasicRule(int divisor, String word) {
            this.divisor = divisor;
            this.word = word;
        }
    }
}
