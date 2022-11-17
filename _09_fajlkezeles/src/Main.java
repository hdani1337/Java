import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void bevezetes(){
        ArrayList<Integer> szamok = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            szamok.add(i);

        //kiírás direkten az ArrayListből foreach ciklussal
        for(int i : szamok)
            System.out.println(i);

        //kiírás iterátorral
        Iterator<Integer> it = szamok.iterator();
        while (it.hasNext()){//addig megy, amíg van kötelező iterátor
            System.out.println(it.next());//it.next() visszaadja a következő elem értékét, és tovább is lép az iterátor
        }
        it = szamok.iterator();//visszalép az iterátor az ArrayListelejére
        while(it.hasNext()){
            int w = it.next();//következő elem ideiglenes eltárolása, mert erről fogjuk lekérni az értékét
            if(w%2==0){
                it.remove();//páros számok törlése
            }
        }
        System.out.println(szamok);//ArrayList kiírása a saját toString() függvényével
    }

    public static void fajlbeolvasas(){
        ArrayList<Diak> diakok = new ArrayList<Diak>();
        try{
            FileReader fr = new FileReader("_09_fajlkezeles/src/eredmenyek.txt");
            BufferedReader bufferedReader = new BufferedReader(fr);

            String line = null;
            while((line = bufferedReader.readLine()) != null){//a belső zárójeles utasítás már értéket is ad a line változónak
                String[] adatok = line.split(",");
                Diak d = new Diak(adatok[0], adatok[1], Double.parseDouble(adatok[2]));
                //Double.parseDouble(adatok[2]) segítségével tudjuk átkonvertálni a stringet double-é
                diakok.add(d);
                System.out.println(d);
            }

            //azoknak a diákoknak a kiírása, akiknek az átlaga jobb 4.5-nél
            for(int i = 0; i < diakok.size(); i++){
                Diak temp = diakok.get(i);
                if(temp.eredmeny >= 4.5)
                    System.out.println(temp);
            }

            System.out.println("A diákok átlaga: " + atlag(diakok));

            bufferedReader.close();
            fr.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double atlag(ArrayList<Diak> diakok){
        double temp = 0.0;
        for(Diak d : diakok)
            temp += d.eredmeny;
        return temp/diakok.size();
    }

    public static void main(String[] args) {
       //bevezetes();
        fajlbeolvasas();
    }
}
