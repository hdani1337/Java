import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //hashMapPelda();
        //hashMapTanc();
        //hashSetPelda();
        kiralyHashSetPelda();
    }

    public static void hashMapPelda(){
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

    public static void hashMapTanc(){
        //Fájlbeolvasás kezdete
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
    }

    public static void hashSetPelda(){
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < 10; i++)
            hashSet.add(random.nextInt(1,10));

        System.out.println("Egyedi értékek: " + hashSet);
    }

    public static void kiralyHashSetPelda(){
        ArrayList<Kiraly> kiralyok = new ArrayList<Kiraly>();
        HashSet<String> egyediHazak = new HashSet<String>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("_11_fajlkezeles3/kiraly.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            /**
             * Egyesével beolvassuk a sorokat, egy ciklusban 4 sort olvasunk be
             * Első sor mindig a név
             * Második sor mindig a koronázás éve
             * Harmadik sor mindig az uralkodás végének éve
             * Negyedik sor mindig az uralkodóház neve*/
            while((line = bufferedReader.readLine()) != null){
                Kiraly k = new Kiraly();//Üres király objektum, ezt töltjük fel adatokkal
                k.setNev(line);//1. sor a név
                k.setKoronazasEve(Integer.parseInt(bufferedReader.readLine()));//2. sor a koronázás éve
                k.setUralkodasVege(Integer.parseInt(bufferedReader.readLine()));//3. sor az uralkodás végének éve
                k.setUralkodoHaz(bufferedReader.readLine());//4. sor az uralkodóház neve
                kiralyok.add(k);//Feltöltött király hozzáadása a tömbhöz

                egyediHazak.add(k.getUralkodoHaz());//Uralkodóház hozzáadása az házakhoz
            }
            fileReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Összes király kiírása
        System.out.println("----Királyok----");
        for (Kiraly k : kiralyok)
            System.out.println(k);

        //Uralkodóházak kigyűjtése HashMapbe
        HashMap<String, Integer> hazak = new HashMap<String, Integer>();
        for (Kiraly k : kiralyok) {
            if (!hazak.containsKey(k.getUralkodoHaz()))
                hazak.put(k.getUralkodoHaz(), 1);
            else
                hazak.put(k.getUralkodoHaz(), hazak.get(k.getUralkodoHaz()) + 1);
        }
        System.out.println(hazak);

        //Uralkodóház kiválasztása, ahol a legtöbb király uralkodott
        int maxHazDb = 0;
        String maxHazNev = null;
        for (String txt : hazak.keySet()){
            int darab = hazak.get(txt);
            if(darab > maxHazDb){
                maxHazNev = txt;
                maxHazDb = darab;
            }
        }
        System.out.println("A legtöbben a(z) " + maxHazNev + "ban uralkodtak, ahol " + maxHazDb + " uralkodó volt.");

        System.out.println("----Uralkodóházak----");
        for (String haz : egyediHazak){
            System.out.println(haz);
        }

        System.out.println("----Top 10 legtovább uralkodó király----");
        Collections.sort(kiralyok);
        for (int i = kiralyok.size()-1; i > kiralyok.size()-11; i--){
            if(i >= 0)
                System.out.println(kiralyok.get(i));
        }

        uralkodoHazakFajlba(egyediHazak, kiralyok);
    }

    /**
     * Minden uralkodóházhoz egy fájl
     * A fájlokba a hozzájuk tartozó uralkodók neveit írjuk*/
    public static void uralkodoHazakFajlba(HashSet<String> egyediHazak, ArrayList<Kiraly> kiralyok){
        for (String s : egyediHazak){
            try {
                FileWriter out = new FileWriter(s + ".txt");
                BufferedWriter output = new BufferedWriter(out);
                for (Kiraly k : kiralyok){
                    if(k.getUralkodoHaz().equals(s)){
                        output.append(k.getNev() + ", " + k.getKoronazasEve() + "-" + k.getUralkodasVege() + "\n");
                    }
                }
                output.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**Feladat: Uralkodóháznak hány év volt az uralkodási ideje?*/
}