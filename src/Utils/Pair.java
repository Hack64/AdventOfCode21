package Utils;

public class Pair {

    private int x,y;

    public Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Pair(){
        this.x=0;
        this.y=0;
    }

    public String getPair(){
        return "<"+x+","+y+">";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
