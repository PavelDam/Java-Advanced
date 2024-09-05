package _Exams.Exam_19February2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        ArrayDeque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowels.push(e.charAt(0)));

        ArrayDeque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonants.offer(e.charAt(0)));

        while (!consonants.isEmpty()) {
            char vowel = vowels.poll();
            char consonant = consonants.pop();

            for (int i = 0; i < words.length; i++) {

                String word = words[i];
                String foundWord = foundWords[i];
                int indexVowel = word.indexOf(vowel);
                int indexConsonant = word.indexOf(consonant);

                if (indexVowel >= 0) {
                    char[] charArray = foundWord.toCharArray();
                    charArray[indexVowel] = vowel;
                    foundWord = String.valueOf(charArray);
                }
                if (indexConsonant >= 0) {
                    char[] charArray = foundWord.toCharArray();
                    charArray[indexConsonant] = consonant;
                    foundWord = String.valueOf(charArray);
                }
                foundWords[i] = foundWord;
            }
            vowels.offer(vowel);
        }

        List<String> output = Arrays.stream(foundWords).filter(w -> !w.contains("*")).collect(Collectors.toList());

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);
    }
}
