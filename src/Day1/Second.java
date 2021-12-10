package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Second {

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        String file = "./input";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.ready()){
                values.add(Integer.parseInt(reader.readLine()));
            }
            System.out.println("Array loaded!");
            int prev=Integer.MAX_VALUE;
            int curr=0;
            int increases=0;
            for(int i=2; i<values.size(); i++){
                curr = values.get(i)+values.get(i-1)+values.get(i-2);
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
