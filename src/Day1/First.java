package Day1;

import java.io.*;
import java.util.ArrayList;

public class First {

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        String file = "./src/Day1/input";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.ready()){
                values.add(Integer.parseInt(reader.readLine()));
            }
            System.out.println("Array loaded!");
            int prev=values.get(0);
            int curr=0;
            int increases=0;
            for(int i=1; i<values.size(); i++){
                curr = values.get(i);
                if (prev<curr)
                    increases++;
                prev=curr;
            }
            System.out.println(increases);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
