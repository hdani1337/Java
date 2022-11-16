import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<SMS> smsek = new ArrayList<SMS>();
    static Mozi mozi;
    /*
    * 0. feladat: SMS osztály: telszám, idő, üzenet
    * 1. feladat: Üzenetek száma
    * 2. feladat: Időpont bekérése, ahhoz milyen üzenet tartozik
    * 3. feladat: Leghosszabb üzenet
    * 4. feladat: Hány perc telt el az első és utolsó SMS között?
    * 5. feladat: Melyik szolgáltatótól jött az SMS?
    * 6. feladat: Mozi fájl beolvasása
    * 7. feladat: Hány jegyet adtak el a moziban?
    * 8. feladat: Hány %-a üres a mozinak?
    * 9. feladat: Kérjünk be egy sort, hány üres hely van abban?
    * 10. feladat: 1-3. 500ft, 4-6. 1000ft, 7-10. 1500ft a jegy. Teljes bevétel számítása
    */
    public static void main(String[] args) {
        //smsfajlbeolvasas();
        //System.out.println("1. feladat, üzenetek száma: " + smsek.size());
        //idopont();
        //leghosszabb();
        //idoKulonbseg();
        //statisztika();
        mozifajlbeolvasas();
        System.out.println("7.feladat: " + mozi.foglaltHelyek() + " darab jegyet adtak el a moziban.");
        System.out.println("8.feladat: " + ((mozi.size()*1.0 - mozi.foglaltHelyek())/mozi.size())*100 + "%-a üres a moziteremnek.");
        sorBekeresMozihoz();
        System.out.println("10. feladat: " + mozi.bevetel() + " forint a mozi teljes bevétele.");
    }

    //2. feladat
    public static void idopont(){
        System.out.println("---2. feladat---");
        System.out.print("Kérek egy időpontot: ");
        Scanner scanner = new Scanner(System.in);
        String ido = scanner.next();
        SMS egyezoSMS = null;
        for (SMS s : smsek)
            if(s.getIdo().equals(ido)) {
                egyezoSMS = s;
                break;
            }
        System.out.println("A megadott időpontban" + ((egyezoSMS==null)?" nem":"") + " érkezett SMS.");
        if(egyezoSMS != null)
            System.out.println("SMS tartama: " + egyezoSMS.getUzenet());

        scanner.close();
        System.out.println("---2. feladat vége---");
    }

    //3. feladat
    public static void leghosszabb(){
        SMS temp = smsek.get(0);
        for (SMS s : smsek)
            if(s.getUzenet().length() > temp.getUzenet().length())
                temp = s;
        System.out.println("3. feladat, leghosszabb üzenet: " + temp.getUzenet());
    }

    //4. feladat
    public static void idoKulonbseg(){
        System.out.println("---4. feladat---");
        SMS legelso = smsek.get(0);
        SMS legutolso = smsek.get(smsek.size()-1);

        System.out.println("Első SMS időpontja: " + legelso.getIdo());
        System.out.println("Utolsó SMS időpontja: " + legutolso.getIdo());

        int kulonbseg = idoPercbe(legutolso.getIdo()) - idoPercbe(legelso.getIdo());

        System.out.println(kulonbseg + " perc telt el a két üzenet között");
        System.out.println((kulonbseg/60) + " óra, " + (kulonbseg%60) + " perc");
        System.out.println("---4. feladat vége---");
    }

    //5. feladat
    public static void statisztika(){
        int telekom = 0;
        int yettel = 0;
        int vodafone = 0;
        for (SMS s : smsek){
            switch (s.getTelefonszam().charAt(2)){
                case '2':{
                    yettel++;
                    break;
                }
                case '3':{
                    telekom++;
                    break;
                }
                case '7':{
                    vodafone++;
                    break;
                }
            }
        }
        System.out.println("---5. feladat---");
        System.out.println("Yettel (20): " + yettel + " darab SMS");
        System.out.println("Telekom (30): " + telekom + " darab SMS");
        System.out.println("Vodafone (70): " + vodafone + " darab SMS");
        System.out.println("---5. feladat vége---");
    }

    //9. feladat
    public static void sorBekeresMozihoz(){
        System.out.println("---9. feladat---");
        System.out.print("Kérek egy sorszámot: ");
        Scanner scanner = new Scanner(System.in);
        int sor = scanner.nextInt();
        sor--;//Ez azért kell, mert az átlag ember 1-től kezdi a sorszámozást, nem 0-tól
        if(sor < mozi.getTerem().length){
            System.out.println(mozi.getUresHelyekSorbol(sor) + " üres hely van a " + (sor+1) + ". sorban.");
        }else System.out.println("Nincs ennyi sor!");
        scanner.close();
    }

    //1. feladat
    public static void smsfajlbeolvasas(){
        try{
            FileReader fr = new FileReader("sms.txt");
            BufferedReader bufferedReader = new BufferedReader(fr);

            String line = null;
            while((line = bufferedReader.readLine()) != null){
                String[] adatok = line.split(" ");
                /*
                * Feltételezzük, hogy az első sorban szóközzel elválasztva van a telefonszám és az időbélyeg,
                * a következő sorban pedig csak az üzenet van.*/
                SMS s = new SMS(adatok[0], adatok[1], bufferedReader.readLine());
                smsek.add(s);
            }

           /* for (SMS s : smsek)
                System.out.println(s);*/

            bufferedReader.close();
            fr.close();
        }catch (FileNotFoundException e){
            System.out.println("sms.txt megnyitása nem sikerült!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Általános hiba.");
            e.printStackTrace();
        }
    }

    //6. feladat
    public static void mozifajlbeolvasas(){
        try{
            FileReader fr = new FileReader("mozi.txt");
            BufferedReader bufferedReader = new BufferedReader(fr);

            mozi = new Mozi();

            String line = null;
            int sor = 0;
            while((line = bufferedReader.readLine()) != null){
                String[] adatok = line.split(" ");
                for (int i = 0; i < adatok.length; i++)
                    mozi.getTerem()[sor][i] = adatok[i];
                sor++;
            }

            mozi.print();

            bufferedReader.close();
            fr.close();
        }catch (FileNotFoundException e){
            System.out.println("mozi.txt megnyitása nem sikerült!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Általános hiba.");
            e.printStackTrace();
        }
    }

    //4. feladathoz tartozó segédfüggvény
    public static int idoPercbe(String ido){
        String ora = ido.substring(0,ido.indexOf(':'));
        String perc = ido.substring(ido.indexOf(':')+1);
        int oraInt = Integer.parseInt(ora);
        int percInt = Integer.parseInt(perc);
        return oraInt*60+percInt;
    }
}
