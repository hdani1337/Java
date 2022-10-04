import java.util.Scanner;

public class Stringek {

    public static void bevezetes(){
        String nev = "Jókai Mór";
        String x = new String("Petőfi Sándor");
        System.out.println(nev.length());
        System.out.println(nev.toUpperCase());
        System.out.println(nev.toLowerCase());
        int n = nev.length();
        for (int i = 0; i < n; i++){
            char ch = nev.charAt(i);
            System.out.println(ch);
        }
        String[] temp = nev.split(" ");
        for (int i = 0; i < temp.length; i++){
            System.out.println(temp[i]);
        }
        System.out.println(nev.startsWith("Jókai"));
        System.out.println(nev.startsWith("Jokai"));
    }

    public static String megfordit(String szoveg){
        String temp = "";
        for (int i = szoveg.length()-1; i >= 0; i--){
            temp += szoveg.charAt(i);
        }
        return temp;
    }

    public static boolean isPalindrom(String szoveg){
        return megfordit(szoveg).compareTo(szoveg) == 0;
    }

    public static boolean jelszoMegfelel(String jelszo){
        if(jelszo.length() < 8) return false;
        //van benne kisbetű, nagybetű, szám, legalább 8 karakter
        boolean kisbetu = false;
        boolean nagybetu = false;
        boolean szam = false;

        for (int i = 0; i < jelszo.length(); i++){
            char c = jelszo.charAt(i);
            if(c >= 'A' && c <= 'Z') nagybetu = true;
            else if (c >= 'a' && c <= 'z') kisbetu = true;
            else if (c >= '0' && c <= '9') szam = true;
        }

        return kisbetu && nagybetu && szam;
    }

    public static void jelszoKeres(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Adjon meg egy jelszót: ");
        String password = scan.nextLine();
        System.out.println(jelszoMegfelel(password) ? "Megfelel a jelszó!" : "Nem felel meg a jelszó!");
        scan.close();
    }

    //HF: Személyi szám ellenőrzés
    //1 860415 2056
    //Férfi, 1986.04.15., 205. ember aznap, 6 az ellenörző szám
    //Ellenőrzés (1*1+2*8+3*6+4*0+5*4...)/11
    //Ellenőrzést ellenőrizze le a függvény

    public static void main(String[] args) {
        //bevezetes();
        //System.out.println(megfordit("abcdefgh"));
        //System.out.println(isPalindrom("asdfasfsaf"));
        jelszoKeres();
    }
}
