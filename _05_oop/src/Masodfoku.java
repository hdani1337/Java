public class Masodfoku {
    private int a;
    private int b;
    private int c;

    public Masodfoku(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        System.out.println("D: " + diszkriminans());
        System.out.println("MSZ: " + megoldas());
    }

    public int diszkriminans(){
        return b*b-4*a*c;
    }

    public int megoldas(){
        return (this.diszkriminans() > 0) ? 2 :
                (this.diszkriminans() == 0) ? 1 : 0;
    }

    public double x1(){
        return (-b + Math.sqrt(diszkriminans()))/(2*a);
    }

    public double x2(){
        return (-b - Math.sqrt(diszkriminans()))/(2*a);
    }
}
