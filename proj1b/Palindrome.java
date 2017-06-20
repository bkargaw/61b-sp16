/**
 * Created by brukargaw on 5/10/17.
 */
import java.util.Deque;
import java.util.LinkedList;

public class Palindrome {

    public static Deque<Character> wordToDeque(String word){
        Deque<Character> list = new LinkedList<>();

        for( Character c : word.toCharArray()){
            list.add(c);

        }
        return list;
    }

    private static class comparator implements CharacterComparator{
        @Override
        public boolean equalChars(char x , char y){
            return x == y;
        }
    }

    public static CharacterComparator getEqualChars(){
        return new comparator();
    }

    public static boolean isPalindrome(String word, int n){
       return isPalindromeHelper(Palindrome.wordToDeque(word), n);
    }



    public static boolean isPalindromeHelper(Deque word, int n){
        if (word.size() <= 1) return true;
        Character first = (Character) word.removeFirst();
        Character last = (Character) word.removeLast();
        CharacterComparator comp = OffByN.getEqualChars(n);
        if (!comp.equalChars(first, last))return false;
        return isPalindromeHelper(word , n);
    }

}
