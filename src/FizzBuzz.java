import java.util.*;
import java.util.stream.Collectors;

public class FizzBuzz {
    private static List<Rule> rules = List.of(
            new AddWordRule(3, "Fizz"),
            new AddWordRule(13, "Fezz"),
            new AddWordRule(5, "Buzz"),
            new AddWordRule(7, "Bang"),
            new AddWordRule(11, "Bong"),
            new RemoveWordsRule(11,  List.of("Fizz", "Buzz", "Bang")),
            new ReverseWordsRule(17)
    );

    public static void main(String[] args) {
        int limit = promptUserForLimit();

        for(int i = 1; i <= limit; i++) {
            List<String> words = new ArrayList<>();

            for(Rule rule: rules) {
                words = rule.execute(i, words);
            }

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

    private interface Rule {
        int divisor = 1;
        List<String> execute (int iterator, List<String> words);
    }

    private static class AddWordRule implements Rule {
        public int divisor;
        private String word;

        AddWordRule(int divisor, String word) {
            this.divisor = divisor;
            this.word = word;
        }

        public List<String> execute(int iterator, List<String> words){
            if(iterator % divisor == 0) words.add(word);
            return words;
        }
    }

    private static class RemoveWordsRule implements Rule {
        public int divisor;
        private List<String> wordsToRemove;

        RemoveWordsRule(int divisor, List<String> wordsToRemove) {
            this.divisor = divisor;
            this.wordsToRemove = wordsToRemove;
        }

        public List<String> execute(int iterator, List<String> words){
            if(iterator % divisor == 0)
                return words.stream()
                        .filter((word)-> !wordsToRemove.contains(word))
                        .collect(Collectors.toList());
            else return words;
        }
    }

    private static class ReverseWordsRule implements Rule {
        public int divisor;

        ReverseWordsRule(int divisor) {
            this.divisor = divisor;
        }


        public List<String> execute(int iterator, List<String> words) {
            if(iterator % divisor == 0) Collections.reverse(words);
            return words;
        }

    }
}
