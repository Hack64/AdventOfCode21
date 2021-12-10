package Day2;

import Utils.InputReader;

import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> values = InputReader.getInput(2);
        int hor=0;
        int dep=0;
        for (String s:values){
            String[] sep = s.split(" ");
            switch(sep[0]){
                case "forward":
                    hor+=Integer.parseInt(sep[1]);
                    break;
                case "down":
                    dep+=Integer.parseInt(sep[1]);
                    break;
                case "up":
                    dep-=Integer.parseInt(sep[1]);
            }
        }
        System.out.println("Horizontal: " + hor);
        System.out.println("Depth: " + dep);
        System.out.println("Res: " + dep*hor);
    }
}
