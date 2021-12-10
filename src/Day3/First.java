package Day3;

import Utils.BinaryUtils;
import Utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<String> values = InputReader.getInput(3);
        int strLen = values.get(0).length();
        String gamma="";
        for (int i=0; i<strLen; i++){
            List<Character> chars = new ArrayList<>();
            int zeros=0, ones=0;
            for (String s:values){
                chars.add(s.charAt(i));
            }
            for (Character c:chars){
                if (c=='0')
                    zeros+=1;
                else
                    ones+=1;
            }
            if (zeros>ones)
                gamma=gamma+"0";
            else
                gamma=gamma+"1";
        }
        System.out.println(gamma + " | " + BinaryUtils.convertToDecimal(gamma));
        System.out.println(BinaryUtils.invert(gamma) + " | " + BinaryUtils.convertToDecimal(BinaryUtils.invert(gamma)));
        System.out.println("Power consumption: " + BinaryUtils.convertToDecimal(gamma)*BinaryUtils.convertToDecimal(BinaryUtils.invert(gamma)));
    }
}
