public class Diak implements Comparable<Diak> {
    private String nev;
    private double atlag;

    public Diak(String nev, double atlag) {
        this.nev = nev;
        this.atlag = atlag;
    }

    @Override
    public int compareTo(Diak o) {
        if(this.atlag - o.atlag != 0)
            return (int) (this.atlag - o.atlag);
        else return this.nev.compareTo(o.nev);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Diak){
            return ((Diak)obj).nev == this.nev && ((Diak)obj).atlag == this.atlag;
        }else return false;
    }

    @Override
    public String toString() {
        return nev + ": " + atlag;
    }
}
