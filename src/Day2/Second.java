package Day2;

import Utils.InputReader;

import java.util.List;

public class Second {
    public static void main(String[] args) {
        List<String> values = InputReader.getInput(2);
        int hor=0;
        int aim=0;
        int dep=0;
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
    }
}
