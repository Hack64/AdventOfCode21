package Utils;

public class BinaryUtils {
    public static String invert(String binary){
        StringBuilder inverted = new StringBuilder();
        for (Character c:binary.toCharArray()){
            if (c=='0')
                inverted.append("1");
            else
                inverted.append("0");
        }
        return inverted.toString();
    }

    public static int convertToDecimal(String binary){
        return Integer.parseInt(binary,2);
    }
}
