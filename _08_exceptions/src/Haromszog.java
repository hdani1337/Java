public class Haromszog {
    private int a;
    private int b;
    private int c;

    public Haromszog(int _a, int _b, int _c) throws HaromszogException{
        if(isValid(_a,_b,_c)){
            setA(_a);
            setB(_b);
            setC(_c);
        }else throw new HaromszogException("A háromszög nem megszerkeszthető!");
    }

    public static boolean isValid(int _a, int _b, int _c){
        return _a+_b > _c && _a+_c > _b && _b+_c > _a;
    }

    public boolean isValid(){
        return this.isValid(this.a, this.b, this.c);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) throws HaromszogException {
        if(a<= 0) throw new HaromszogException("A oldal nem lehet 0 vagy kisebb!");
        else this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) throws HaromszogException {
        if(b<= 0) throw new HaromszogException("B oldal nem lehet 0 vagy kisebb!");
        else this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) throws HaromszogException {
        if(c<= 0) throw new HaromszogException("C oldal nem lehet 0 vagy kisebb!");
        else this.c = c;
    }

    public int kerulet(){return a+b+c;}
    public double terulet(){
        double s = (a+b+c)/2;
        return Math.round(Math.sqrt(s*(s-a)*(s-b)*(s-c))*100) / 100.0;
    }

    @Override
    public String toString() {
        return "Haromszog{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
