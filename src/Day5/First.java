package Day5;

import Utils.Pair;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        List<Pair> points = loadPoints();
        Integer[][] matrix = createMatrix();
        printMatrix(matrix);
        updateMatrix(matrix, points);
        System.out.println("----------------------------");
        printMatrix(matrix);
        System.out.println(getInterjections(matrix));

    }

    private static List<Pair> loadPoints(){
        List<Pair> coords = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("./src/Day5/input"));
            while (sc.hasNext()){
                String line = sc.nextLine();
                String[] content = line.split(" -> ");
                for (String s:content){
                    String[] points=s.split(",");
                    coords.add(new Pair(Integer.parseInt(points[0]), Integer.parseInt(points[1])));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return coords;
    }

    private static Integer[][] createMatrix(){
        Integer[][] map = new Integer[1000][1000];
        for (int i=0; i<1000; i++){
            for (int j=0; j<1000; j++){
                map[i][j]=0;
            }
        }
        return map;
    }

    private static void printMatrix(Integer[][] matrix){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix.length-1; j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println(matrix[i][9]);
        }
    }

    private static void updateMatrix(Integer[][] matrix, List<Pair> coords){
        List<Pair> clean = new ArrayList<>();
        for (int i=0; i<coords.size(); i+=2) {
            if (coords.get(i).getX() == coords.get(i + 1).getX() || coords.get(i).getY() == coords.get(i + 1).getY()) {
                clean.add(coords.get(i));
                clean.add(coords.get(i + 1));
            }
        }
        coords.retainAll(clean);

        for (int i=0; i<coords.size(); i+=2) {
            Pair p1 = coords.get(i);
            Pair p2 = coords.get(i+1);

            if (p1.getX() > p2.getX() && p1.getY()==p2.getY()){
                for (int j=p2.getX(); j<=p1.getX(); j++){
                    matrix[p1.getY()][j]+=1;
                }
            }
            if (p1.getY()>p2.getY() && p1.getX()==p2.getX()){
                for (int j=p2.getY(); j<=p1.getY(); j++){
                    matrix[j][p1.getX()]+=1;
                }
            }
            if (p2.getX() > p1.getX() && p1.getY()==p2.getY()){
                for (int j=p1.getX(); j<=p2.getX(); j++){
                    matrix[p1.getY()][j]+=1;
                }
            }
            if (p2.getY() > p1.getY() && p1.getX()==p2.getX()){
                for (int j=p1.getY(); j<=p2.getY(); j++){
                    matrix[j][p1.getX()]+=1;
                }
            }
        }
    }
    private static int getInterjections(Integer[][] matrix){
        int count=0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j< matrix.length; j++){
                if (matrix[i][j]>1)
                    count++;
            }
        }
        return count;
    }
}