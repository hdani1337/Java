public class Teglalap {
    private int a;
    private int b;

    //paraméter nélküli konstruktor
    public Teglalap(){
        this(3,5);
    }

    //csak az A oldalt adja meg
    public Teglalap(int a){
        this(a,1);
    }

    //paraméteres konstruktor
    public Teglalap(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int kerulet(){
        return 2*(a+b);
    }

    public int terulet(){
        return a*b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
