import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pablo on 30.09.2016.
 */


public class test1 {
    public static void main(String[] args) {


        String [] a = {"cat", "dog", "cow", "horse"};

        List animals = Arrays.asList(a);

        animals.forEach((animal) -> System.out.println(animal + "; " ));


    }
}
