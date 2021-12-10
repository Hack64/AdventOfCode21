package Day1;

import Utils.InputReader;

import java.util.List;

public class First {

    public static void main(String[] args) {
        List<String> values = InputReader.getInput(1);
        int prev=Integer.parseInt(values.get(0));
        int curr=0;
        int increases=0;
        for(int i=1; i<values.size(); i++){
            curr = Integer.parseInt(values.get(i));
            if (prev<curr)
                increases++;
            prev=curr;
        }
        System.out.println(increases);
    }
}

