import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //hashmapPelda();
        fajlbeolvasas();
    }

    public static void hashmapPelda(){
        Random random = new Random();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 20; i++){
            int x = random.nextInt(0,6);
            if(!map.containsKey(x))
                map.put(x,1);
            else
                map.put(x, map.get(x)+1);
        }
        System.out.println("Megoldás:");
        for (int i : map.keySet()){
            System.out.println(i + ": " + map.get(i) + " db");
        }
    }

    public static void fajlbeolvasas(){
        //Fájlbeolvasás kezdete
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("_11_fajlkezeles3/tanc.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        /**Táncokat tartalmazó lista, illetve annak feltöltése
         * bufferedReader.lines().toList() => Egy lista, ami a fájlból beolvasott sorokat tartalmazza
         * ForEach ciklussal ezen a listán megyünk végig, minden sora egy String, amit paraméterként adunk meg a táncnak
         * Kicsit rövidebb és egyszerűbb, mint a sorokat egyesével beolvasgatni és szétszedni*/
        ArrayList<Tanc> tancok = new ArrayList<Tanc>();
        for (String l : bufferedReader.lines().toList())
            tancok.add(new Tanc(l));

        //HashMapbe kigyűjteni a táncok darabszámait
        HashMap<String,Integer> tancokDarabszam = new HashMap<String,Integer>();
        for (Tanc t : tancok)
            if (!tancokDarabszam.containsKey(t.getTancnev()))
                tancokDarabszam.put(t.getTancnev(), 1);
            else
                tancokDarabszam.put(t.getTancnev(), tancokDarabszam.get(t.getTancnev()) + 1);

        //Kiírás
        System.out.println("Megoldás:");
        for (String tancTipus : tancokDarabszam.keySet())
            System.out.println(tancTipus + ": " + tancokDarabszam.get(tancTipus) + " darab fellépés");

        //Beolvasó lezárása
        scanner.close();
    }
}