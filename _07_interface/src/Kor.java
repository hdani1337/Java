public class Kor implements Alakzat, Printable{
    private int r;

    public Kor(){
        this.r = 1;
    }

    public Kor(Kor masik){
        this.r = masik.r;
    }

    @Override
    public double kerulet() {
        return 2*r*Math.PI;
    }

    @Override
    public double terulet() {
        return r*r*Math.PI;
    }

    @Override
    public void print() {

    }
}
