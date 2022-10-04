public class Kocka {
    public double a = 0;//a élének hossza, kezdésnek publikus

    public Kocka() {
        this(5);//ha nem adunk meg paramétert példányosításnál, legyen alapból 5 az oldal értéke
    }

    public Kocka(double a){
        this.a = a;
    }

    //kocka felszíne
    public double surface(){
        return 6*a*a;
    }

    //kocka térfogata
    public double volume(){
        return a*a*a;
    }

    //kocka alapterülete
    public double baseSurface(){
        return a*a;
    }
}
