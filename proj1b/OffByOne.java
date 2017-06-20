/**
 * Created by brukargaw on 5/10/17.
 */
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x-y) == 1);
    }

    public static CharacterComparator getEqualChars(){
        return new OffByOne();
    }

}
