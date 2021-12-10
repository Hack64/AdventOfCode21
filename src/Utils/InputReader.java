package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    public static <T> List<T> getInput(int day){
        ArrayList<T> values = new ArrayList<>();
        String file = "./src/Day"+day+"/input";
        try {
            BufferedReader buf = new BufferedReader(new FileReader(file));
            while (buf.ready()){
                values.add((T) buf.readLine());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Array loaded!");
        return values;
    }
}
