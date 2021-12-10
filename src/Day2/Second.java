package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Second {
    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<>();
        String file = "./src/Day2/input";
        int hor=0;
        int aim=0;
        int dep=0;
        try{
            BufferedReader buff = new BufferedReader(new FileReader(file));
            while(buff.ready()){
                values.add(buff.readLine());
            }
            System.out.println("Array loaded!");
            for (String s:values){
                String[] sep = s.split(" ");
                switch(sep[0]){
                    case "forward":
                        hor+=Integer.parseInt(sep[1]);
                        dep+=aim*Integer.parseInt(sep[1]);
                        break;
                    case "down":
                        aim+=Integer.parseInt(sep[1]);
                        break;
                    case "up":
                        aim-=Integer.parseInt(sep[1]);
                }
            }
            System.out.println("Horizontal: " + hor);
            System.out.println("Depth: " + dep);
            System.out.println("Res: " + dep*hor);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
