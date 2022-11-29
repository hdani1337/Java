import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //hianyzasokFeladat();
        //lakasFeladat();
        repuloFeladat();
    }

    public static void lakasFeladat(){
        //Beolvasás, eltárolás
        ArrayList<Lakas> lakasok = new ArrayList<Lakas>();
        try {
            FileReader fileReader = new FileReader("_12_gyakorlas/lakas.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (String line : bufferedReader.lines().toList())
                lakasok.add(new Lakas(line));
        } catch (FileNotFoundException e) {
            System.out.println("A fájl nem található!");
        }

        //Legdrágább lakás
        Lakas legdragabb = lakasok.get(0);
        for (Lakas l : lakasok)
            if(l.getArMillio() > legdragabb.getArMillio())
                legdragabb = l;
        System.out.println("A legdrágább lakás: " + legdragabb);

        //Átlagár egy tizedes pontossággal
        double osszAr = 0.0f;
        for (Lakas l : lakasok)
            osszAr += l.getArMillio();
        osszAr /= lakasok.size();
        osszAr = Math.floor(osszAr*10);
        osszAr /= 10;
        System.out.println("A lakások átlagára: " + osszAr + " millió Ft.");

        //HashMapek
        HashMap<String, Integer> darabAllapotSzerint = new HashMap<String, Integer>();
        HashMap<Integer, Integer> darabKeruletSzerint = new HashMap<Integer, Integer>();
        for (Lakas l : lakasok){
            if(darabAllapotSzerint.containsKey(l.getAllapot())){
                darabAllapotSzerint.put(l.getAllapot(),darabAllapotSzerint.get(l.getAllapot())+1);
            }else darabAllapotSzerint.put(l.getAllapot(),1);

            if(darabKeruletSzerint.containsKey(l.getKerulet())){
                darabKeruletSzerint.put(l.getKerulet(),darabKeruletSzerint.get(l.getKerulet())+1);
            }else darabKeruletSzerint.put(l.getKerulet(),1);
        }
        System.out.println("Darabszámok állapot szerint: " + darabAllapotSzerint);
        System.out.println("Darabszámok kerület szerint: " + darabKeruletSzerint);

        //Kerületek
        HashSet<Integer> keruletek = new HashSet<Integer>();
        for (Lakas l : lakasok)
            keruletek.add(l.getKerulet());
        System.out.println("Kerületek: " + keruletek);

        //Azonosító bekérése, hozzá tartozó adatok kiírása
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem adjon meg egy lakásazonosítót: ");
        int id = scanner.nextInt();
        Lakas valasztottLakas = null;
        for (Lakas l : lakasok){
            if(l.getId() == id){
                valasztottLakas = l;
                break;
            }
        }
        if(valasztottLakas != null){
            System.out.println("A választott lakás adatai: " + valasztottLakas);
        }else System.out.println("Nincs ilyen lakás!");
    }

    public static void hianyzasokFeladat(){
        ArrayList<Hianyzas> hianyzasok = new ArrayList<Hianyzas>();
        try {
            FileReader fileReader = new FileReader("_12_gyakorlas/hianyzas.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (String line : bufferedReader.lines().toList())
                hianyzasok.add(new Hianyzas(line));
        } catch (FileNotFoundException e) {
            System.out.println("A fájl nem található!");
        }

        Collections.sort(hianyzasok);

        for (Hianyzas h : hianyzasok)
            System.out.println(h + ", " + h.mennyitHianyzott() + " óra hiányzás");

        //Melyik osztályból hányan vannak
        HashMap<String, Integer> osztalyok = new HashMap<String, Integer>();
        for (Hianyzas h : hianyzasok){
            if(!osztalyok.containsKey(h.getOsztaly())){
                osztalyok.put(h.getOsztaly(),1);
            }else osztalyok.put(h.getOsztaly(),osztalyok.get(h.getOsztaly())+1);
        }

        //Legalább 3 hiányzó
        for (String key : osztalyok.keySet()){
            if(osztalyok.get(key) >= 3){
                System.out.println(key + ": " + osztalyok.get(key));
            }
        }

        //oraszamBekeres(hianyzasok);
        //osztalyBekeres(hianyzasok);
        adottOrabanMelyikOsztalyHianyzott(hianyzasok);
    }

    public static void oraszamBekeres(ArrayList<Hianyzas> hianyzasArrayList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adjon meg egy óraszámot: ");
        int oraszam = scanner.nextInt();
        if(oraszam >= 1 && oraszam <= 7){
            System.out.println(oraszam + ". órában hiányoztak");
            for (Hianyzas h : hianyzasArrayList){
                if(h.adottOranHianyzott(oraszam))
                    System.out.println(h.getNev());
            }
        }else{
            System.out.println("Az óraszámnak 1 és 7 között kell lennie. Próbálja újra!");
            oraszamBekeres(hianyzasArrayList);
        }
        scanner.close();
    }

    public static void osztalyBekeres(ArrayList<Hianyzas> hianyzasArrayList){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adjon meg egy osztályt: ");
        String osztaly = scanner.nextLine();
        int darab = 0;
        for (Hianyzas h : hianyzasArrayList)
            if(h.getOsztaly().equals(osztaly))
                darab+=h.mennyitHianyzott();
        System.out.println(osztaly + " osztályban " + darab + " óra hiányzás volt.");
        scanner.close();
    }

    public static void adottOrabanMelyikOsztalyHianyzott(ArrayList<Hianyzas> hianyzasArrayList){
        HashSet<String> osztaly = new HashSet<String>();
        for (Hianyzas h : hianyzasArrayList)
            osztaly.add(h.getOsztaly());
        for (String o : osztaly){
            System.out.println(o);
        }
    }

    //HF: Nem egy sorban vannak az adatok, hanem külön sorokban, egy bejegyzés 4 sorból áll

    public static void repuloFeladat(){
        //Beolvasás, eltárolás
        ArrayList<Repulo> repcsik = new ArrayList<Repulo>();
        try {
            FileReader fileReader = new FileReader("_12_gyakorlas/repulo.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (String line : bufferedReader.lines().toList())
                repcsik.add(new Repulo(line));
        } catch (FileNotFoundException e) {
            System.out.println("A fájl nem található!");
        }
        for (Repulo r : repcsik)
            System.out.println(r);
    }
}