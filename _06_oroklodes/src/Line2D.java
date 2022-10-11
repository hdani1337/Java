public class Line2D {
    private Pont2D egyikVege;
    private Pont2D masikVege;

    public Line2D(Pont2D egyikVege, Pont2D masikVege) {
        this.egyikVege = new Pont2D(egyikVege.getX(), egyikVege.getY());
        this.masikVege = new Pont2D(masikVege.getX(), masikVege.getY());
    }

    public Line2D(int x1, int y1, int x2, int y2) {
        egyikVege = new Pont2D(x1,y1);
        masikVege = new Pont2D(x2,y2);
    }

    public double hossz(){
        return egyikVege.tavolsag(masikVege);
    }

    @Override
    public String toString() {
        return "Line2D{" +
                "egyikVege=" + egyikVege +
                ", masikVege=" + masikVege +
                '}';
    }
}
