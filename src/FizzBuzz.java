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
            basicRules.add(new BasicRule(11, "Bong"));

            List<String> words = new ArrayList<>();

            for(BasicRule rule: basicRules) {
                addWordIfDivisible(i, rule.divisor, rule.word, words);
            }

            //We'll forego creating arrays of the following rules
            words = removeWordsIfDivisible(i, 11, List.of("Fizz", "Buzz", "Bang"), words);

            reverseIfDivisible(i, 17, words);


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

    public static List<String> removeWordsIfDivisible(int iterator, int divisor, List<String> wordsToRemove, List<String> words) {
        if(iterator % divisor == 0)
            return words.stream()
                         .filter((word)-> !wordsToRemove.contains(word))
                         .collect(Collectors.toList());
        else return words;
    }

    public static void reverseIfDivisible(int iterator, int divisor, List<String> words) {
        if(iterator % divisor == 0) Collections.reverse(words);
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
