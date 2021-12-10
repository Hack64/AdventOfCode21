package Day3;

import Utils.BinaryUtils;
import Utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class Second {
    public static void main(String[] args) {
        List<String> values = InputReader.getInput(3);
        int oxy=BinaryUtils.convertToDecimal(getOxy(values));
        int co2=BinaryUtils.convertToDecimal(getCO2(values));
        System.out.println("Life support rating: " + oxy*co2);

    }

    private static int common(int idx, List<String> values, boolean most){
        int zeros=0, ones=0;
        List<Character> chars = new ArrayList<>();
        for (String s:values){
            chars.add(s.charAt(idx));
        }
        for (Character c:chars){
            if (c=='0')
                zeros+=1;
            else
                ones+=1;
        }
        if (most){
            if (zeros>ones)
                return 0;
            else
                return 1;
        } else {
            if (zeros>ones)
                return 1;
            else
                return 0;
        }
    }

    private static String getOxy(List<String> values){
        List<String> sub = values;
        int commonVal;
        for (int i=0; i<values.get(0).length(); i++){
            if (sub.size()==1){
                break;
            }
            commonVal=common(i, sub, true);
            List<String> sub2 = new ArrayList<>();
            for (String s:sub){
                if (Character.getNumericValue(s.charAt(i))==commonVal){
                    sub2.add(s);
                }
            }
            sub=sub2;
            if (sub.size()==1){
                System.out.println("Found oxygen generator rating value: " + sub.get(0) + " / " + BinaryUtils.convertToDecimal(sub.get(0)));
            }
        }
        return sub.get(0);
    }

    private static String getCO2(List<String> values){
        List<String> sub = values;
        int commonVal;
        for (int i=0; i<values.get(0).length(); i++){
            if (sub.size()==1){
                break;
            }
            commonVal=common(i, sub,false);
            List<String> sub2 = new ArrayList<>();
            for (String s:sub){
                if (Character.getNumericValue(s.charAt(i))==commonVal){
                    sub2.add(s);
                }
            }
            sub=sub2;
            if (sub.size()==1){
                System.out.println("Found CO2 scrubber value: " + sub.get(0) + " / " + BinaryUtils.convertToDecimal(sub.get(0)));
            }
        }
        return sub.get(0);
    }
}
