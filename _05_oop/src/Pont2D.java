public class Pont2D {
    private int x;
    private int y;

    public Pont2D() {
        this(0,0);
    }

    public Pont2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double tavolsag(){
        //távolság az origotol
        return this.tavolsag(new Pont2D());
    }

    public double tavolsag(Pont2D masik){
        int dSquare = (x-masik.x)*(x-masik.x) + (y-masik.y)*(y-masik.y);
        return Math.sqrt(dSquare);
    }

    @Override
    public String toString() {
        return "Pont2D(" + x + "," + y + ")";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
