public class Diak {
    public String nev;
    public String osztaly;
    public double eredmeny;

    public Diak(String nev, String osztaly, double eredmeny) {
        this.nev = nev;
        this.osztaly = osztaly;
        this.eredmeny = eredmeny;
    }

    @Override
    public String toString() {
        return "Diak{" +
                "nev='" + nev + '\'' +
                ", osztaly='" + osztaly + '\'' +
                ", eredmeny=" + eredmeny +
                '}';
    }
}
