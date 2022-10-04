import java.util.Random;

public class OOP {
    public static void main(String[] args) {
        /*Kocka k = new Kocka(7);
        System.out.println(k.a);
        System.out.println(k.surface());*/

        /*Teglalap t = new Teglalap();
        System.out.println(t.getA());
        System.out.println(t.getB());
        System.out.println(t.kerulet());*/

        /*Masodfoku m = new Masodfoku(1,-3,2);
        if(m.megoldas() == 2) System.out.println("X1 = " + m.x1() + "\nX2 = " + m.x2());
        else if (m.megoldas() == 1) System.out.println("X = " + m.x1());
        else System.out.println("Nincs valós megoldás");*/

        /*Pont2D p1 = new Pont2D(5,4);
        Pont2D p2 = new Pont2D(3,2);
        Pont2D origo = new Pont2D();
        System.out.println("p1 origótól: " + p1.tavolsag());
        System.out.println("p1 origó ponttól: " + p1.tavolsag(origo));
        System.out.println("p1 és p2 távolsága: " + p1.tavolsag(p2));
        System.out.println("origó pont távolsága origótól: " + origo.tavolsag());
        System.out.println("p1: " + p1);*/

        Pont2D pontok[] = new Pont2D[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++){
            pontok[i] = new Pont2D(random.nextInt(10), random.nextInt(10));
            System.out.println("-----" + i + "-----");
            System.out.println(pontok[i]);
            System.out.println("Távolság az origótól: " + pontok[i].tavolsag());
        }
        System.out.println("-----------");
        System.out.println("Legtávolabbi pont: " + legtavolabbi(pontok));
    }

    //Visszaadja az origótól legtávolabbi pontot a megadott pontokból álló tömbből
    public static Pont2D legtavolabbi(Pont2D pontok[]){
        Pont2D maxPont = pontok[0];
        for (int i = 1; i < pontok.length; i++){
           if(pontok[i].tavolsag() > maxPont.tavolsag())
               maxPont = pontok[i];
        }
        return maxPont;
    }
}
