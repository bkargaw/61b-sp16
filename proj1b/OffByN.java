/**
 * Created by brukargaw on 5/10/17.
 */
public class OffByN implements CharacterComparator {
    private int offset;
    public  OffByN(int N){
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x - y) == offset);
    }

    public static  CharacterComparator getEqualChars(int n){
        return new OffByN(n);
    }
}
