import java.util.Scanner;

public class main {
    public void keruletTerulet(){
        int a, b, c;
        a = 3;
        b = 4;
        c = 5;
        int k = a+b+c;
        int s = k/2;
        double t = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.out.println("Kerület: " + k + " cm");
        System.out.println("Terület: " + t + " cm\u00b2");
    }

    public static void keruletTeruletBeolvasva(){
        Scanner input = new Scanner(System.in);

        System.out.print("Adja meg az ,,a'' oldalt: ");
        int a = Integer.parseInt(input.nextLine());

        System.out.print("Adja meg az ,,b'' oldalt: ");
        int b = Integer.parseInt(input.nextLine());

        System.out.print("Adja meg az ,,c'' oldalt: ");
        int c = Integer.parseInt(input.nextLine());

        int k = a+b+c;
        int s = k/2;
        double t = Math.sqrt(s*(s-a)*(s-b)*(s-c));

        double tKerekit = Math.round(t*100)/100.0;

        System.out.println("Kerület: " + k + " cm");
        System.out.println("Terület: " + t + " cm\u00b2");
        System.out.println("Terület két tizedesjegyre kerekítve: " + tKerekit + " cm\u00b2");

        input.close();
    }

    public static void logikaiMuveletek(){
        boolean x = true;
        boolean y = false;
        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }

    public static void parosParatlan(){
        Scanner input = new Scanner(System.in);

        System.out.print("Adjon meg egy számot: ");
        int a = Integer.parseInt(input.nextLine());

        System.out.println(a + ((a%2==0) ? " páros" : " páratlan") + " szám.");

        input.close();
    }

    public static void main(String[] args) {
        //keruletTeruletBeolvasva();
        //logikaiMuveletek();
        parosParatlan();
    }
}
