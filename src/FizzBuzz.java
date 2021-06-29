import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {

    public static void main(String[] args) {

        for(int i = 1; i <= 300; i++) {
            List<String> words = new LinkedList<>();

            if(i % 3 == 0) words.add("Fizz");

            if(i % 13 == 0) words.add("Fezz");

            if(i % 5 == 0) words.add("Buzz");

            if(i % 7 == 0) words.add("Bang");

            if(i % 11 == 0) {
                words.add("Bong");
                words = words.stream()
                             .filter((word)-> word != "Fizz" && word != "Buzz" && word != "Bang")
                             .collect(Collectors.toList());
            }


            if(words.isEmpty()) {
                System.out.print(i);
            } else {
                for(String word: words) System.out.print(word);
            }
            System.out.println();
        }



    }

}
