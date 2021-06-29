import java.util.*;
import java.util.stream.Collectors;

public class FizzBuzz {
    private static List<BasicRule> basicRules = List.of(
            new BasicRule(3, "Fizz"),
            new BasicRule(13, "Fezz"),
            new BasicRule(5, "Buzz"),
            new BasicRule(7, "Bang"),
            new BasicRule(11, "Bong")
    );

    public static void main(String[] args) {
        int limit = promptUserForLimit();

        for(int i = 1; i <= limit; i++) {

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

    private static int promptUserForLimit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Up to what number should we FizzBuzz?");

        int max = scanner.nextInt();
        return max;
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
