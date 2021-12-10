package Day1;

import Utils.InputReader;

import java.util.List;

public class Second {

    public static void main(String[] args) {
        List<String> values = InputReader.getInput(1);
        int prev=Integer.MAX_VALUE;
        int curr=0;
        int increases=0;
        for(int i=2; i<values.size(); i++){
            curr = Integer.parseInt(values.get(i))+Integer.parseInt(values.get(i-1))+Integer.parseInt(values.get(i-2));
            if (prev<curr)
                increases++;
            prev=curr;
        }
        System.out.println(increases);
    }
}
