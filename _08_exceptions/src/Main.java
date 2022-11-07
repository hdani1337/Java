import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void exceptionBevezeto(){
        Scanner scan = new Scanner(System.in);
        /*int x = 5;
        int y = 0;
        int z = x/y;//Ebben a sorban ArithmeticExceptiont dob, 0-val való osztás miatt*/

        try {
            int x = 5;
            int y = 3;
            int z = x/y;//Itt is kivételt dob, de elkapjuk

            int szamok[] = {1,2,3,4};
            System.out.println(szamok[3]);//Túlindexelési kivételt dob

            System.out.println(Integer.parseInt("asd"));
        }catch (ArithmeticException e){
            //Algebrai hiba
            System.out.println(e.getStackTrace()[0] +  ": 0-val nem lehet osztani!");
        }catch (IndexOutOfBoundsException e){
            //Túlindexelés
            System.out.println(e.getStackTrace()[0] +  ": Túlindexelés!");
        }catch (Exception e){
            //Általános hiba
            System.out.println(e.getStackTrace()[0] +  ": " + e.getMessage());
        }
        System.out.println("Vége");
        scan.close();
    }

    /**Mértani közép kiszámítása, nemnegatív számokkal működik
     * Negatív paraméternél IllegalArgumentExceptiont dob*/
    public static double mertaniKozep(int x, int y) throws IllegalArgumentException{
        if(x < 0 || y < 0)
            throw new IllegalArgumentException("Mértani közép számításánál nem lehet negatív szám!");
        return Math.sqrt(x*y);
    }

    public static void fajlkezeles() throws FileNotFoundException {
        FileReader fr = new FileReader("src/input.txt");
        try {
            String osszefuzes = "";
            BufferedReader reader = new BufferedReader(fr);
            for (Object o : reader.lines().toArray())
                osszefuzes += o.toString();
            System.out.println(osszefuzes);
            reader.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //exceptionBevezeto();
       /* Scanner scanner = new Scanner(System.in);
        try {
            //System.out.println(mertaniKozep(3, 4));
            Diak diak = new Diak("Józsi",4);
            System.out.println(diak.osztondij());
            Haromszog haromszog = new Haromszog(1,2,-3);
            Haromszog haromszog2 = new Haromszog(1,0,3);
            System.out.print("A oldal: ");
            int a = scanner.nextInt();
            System.out.print("B oldal: ");
            int b = scanner.nextInt();
            System.out.print("C oldal: ");
            int c = scanner.nextInt();
            Haromszog egyediHaromszog = new Haromszog(a,b,c);
            System.out.println(egyediHaromszog);
            System.out.println("K = "+egyediHaromszog.kerulet());
            System.out.println("T = "+egyediHaromszog.terulet());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            scanner.close();
        }*/
        try {
            fajlkezeles();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
