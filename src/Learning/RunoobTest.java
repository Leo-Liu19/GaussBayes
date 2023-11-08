package Learning;

import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.Collections;
public class RunoobTest {
    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        myArray.add(4);
        myArray.add(8);
        myArray.add(3);
        for(int i : myArray) {
            System.out.println(i);
        }
        Collections.sort(myArray);
        for(int i : myArray) {
            System.out.println(i);
        }
    }
}
