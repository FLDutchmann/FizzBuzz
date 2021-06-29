import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {

        for(int i = 1; i <= 100; i++) {
            List<String> words = new LinkedList<>();

            if(i % 3 == 0) words.add("Fizz");
            if(i % 5 == 0) words.add("Buzz");

            if(words.isEmpty()) {
                System.out.print(i);
            } else {
                for(String word: words) System.out.print(word);
            }
            System.out.println();
        }



    }

}
