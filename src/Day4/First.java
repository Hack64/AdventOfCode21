package Day4;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class First {
    public static void main(String[] args) {
        ArrayList<Integer> nums;
        ArrayList<Integer[][]> boards;
        try{
            Scanner sc = new Scanner(new File("./src/Day4/input"));
            nums = (ArrayList<Integer>) loadNumbers(sc);
            boards = (ArrayList<Integer[][]>) loadBoards(sc);
            checkWinner(boards, nums);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static int checkWinner(ArrayList<Integer[][]> boards, ArrayList<Integer> numbers){
        int extracted=5;
        while (extracted<100){
            List<Integer> winningNums = numbers.subList(0, extracted);
            for (Integer[][] board:boards){
                for (int i=0; i<5; i++) {
                    List<Integer> col = new ArrayList<>();
                    List<Integer> row = new ArrayList<>();
                    for (int j = 0; j < 5; j++) {
                        col.add(board[i][j]);
                        row.add(board[j][i]);
                    }
                    if (winningNums.containsAll(col)){
                        System.out.println("Extracted: " + winningNums);
                        List<Integer> coll = Arrays.stream(board).flatMap(Arrays::stream).collect(Collectors.toList());
                        coll.removeAll(winningNums);
                        int score = 0;
                        for (Integer integer:coll){
                            score+=integer;
                        }
                        score = score*winningNums.get(extracted-1);
                        System.out.println(score);
                        return 0;
                    }
                    if (winningNums.containsAll(row)){
                        System.out.println("Extracted: " + winningNums);
                        List<Integer> coll = Arrays.stream(board).flatMap(Arrays::stream).collect(Collectors.toList());
                        coll.removeAll(winningNums);
                        int score = 0;
                        for (Integer integer:coll){
                            score+=integer;
                        }
                        score = score*winningNums.get(extracted-1);
                        System.out.println(score);
                        return 0;
                    }
                }
            }
            extracted++;
        }
        return 0;
    }

    private static List<Integer> loadNumbers(Scanner sc){
        ArrayList<Integer> nums = new ArrayList<>();
        for (String l:sc.nextLine().split(",")){
            nums.add(Integer.parseInt(l));
        }
        return nums;
    }

    private static List<Integer[][]> loadBoards(Scanner sc){
        ArrayList<Integer[][]> boards = new ArrayList<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            Integer[][] board = null;
            if (!line.isEmpty()){
                board = new Integer[5][5];
                for (int i=0; i<5; i++){
                    String[] vals = line.trim().replaceAll(" +", " ").split(" ");
                    for (int j=0; j<5; j++){
                        board[i][j]=Integer.parseInt(vals[j]);
                    }
                    if (sc.hasNext())
                        line=sc.nextLine();
                }
            }
            if (board!=null)
                boards.add(board);
        }
        return boards;
    }
}
