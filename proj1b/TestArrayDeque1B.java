/**
 * Created by brukargaw on 5/10/17.
 * tess the ArrayDeque class
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class TestArrayDeque1B {
    @Test
    public void testStudentArrayDeque(){
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        ArrayList<String> fs = new ArrayList<>();

        while (true){
            double rand = StdRandom.uniform();
            if (sad.isEmpty()){
                 if (rand <0.5){
                     Integer val = StdRandom.uniform(10);
                     sad.addFirst(val);
                     ads.addFirst(val);
                     fs.add("addFirst("+val+")");

                 }else{
                     Integer val = StdRandom.uniform(10);
                     sad.addLast(val);
                     ads.addLast(val);
                     fs.add("addLast("+val+")");
                 }

            }else{
                if (rand <0.25){
                    Integer val = StdRandom.uniform(10);
                    sad.addFirst(val);
                    ads.addFirst(val);
                    fs.add("addFirst("+val+")");
                }else if( rand < .5){
                    Integer val = StdRandom.uniform(10);
                    sad.addLast(val);
                    ads.addLast(val);
                    fs.add("addLast("+val+")");
                }else if(rand < .75){
                    sad.removeFirst();
                    ads.removeFirst();
                    fs.add("removeFirst()");
                }else{
                    sad.removeLast();
                    ads.removeLast();
                    fs.add("removeLast()");
                }
            }

            for (int i = 0; i < sad.size(); i++) assertEquals(printFail(fs),sad.get(i), ads.get(i));

        }
    }

    public String printFail(ArrayList<String> array){
        String oprations = "";
        for(String s: array){
            oprations += s + "\n";
        }
        return oprations;
    }
}
