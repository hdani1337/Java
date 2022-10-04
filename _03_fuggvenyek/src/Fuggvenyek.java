import java.util.Random;

public class Fuggvenyek {
    /**Teszt*/
    public static void hello(){
        System.out.println("Hello World!");
    }

    /**Paraméterben megadott szám kétszerese*/
    public static int ketszeres(int szam){
        return szam*2;
    }

    /**Két egész érték összegzése*/
    public static int osszead(int a, int b){
        return a+b;
    }

    /**Két valós érték összegzése*/
    public static double osszead(double a, double b){
        return a+b;
    }

    /**Nem működik, mert cím szerinti paraméter átadás van
     * Primitív típus**/
    public static int csere(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        return -1;
    }

    /**Oszály típus átadása*/
    public static void csere(Integer a, Integer b){
        Integer temp = a;
        a = b;
        b = temp;
    }

    /**Paraméterben megadott tömb kiírása konzolos felületre*/
    public static void tombKiir(int[] tomb){
        for (int i = 0; i < tomb.length-1; i++){
            System.out.print(tomb[i] + ", ");
        }
        System.out.println(tomb[tomb.length-1]);
    }

    /**Visszaadja a paraméterben megadott tömb számainak átlagát*/
    public static double tombAtlag(int[] tomb){
        double sum = 0;
        for (int x : tomb)
            sum += x;
        return sum/tomb.length;
    }

    /**Visszaadja, hogy a paraméterben megadott számnak hány osztója van*/
    public static int oszto(int x){
        int db = 0;
        for(int i = 1; i < x; i++)
            if(x%i==0) db++;
        return db;
    }

    /**Visszaadja, hogy a paraméterben megadott szám prímszám e*/
    public static boolean isPrim(int szam){
        if(szam == 1) return false;
        for (int i = 2; i <= Math.sqrt(szam); i++)
            if(szam%i==0)
                return false;
        return true;
    }

    /**1-100 között kiírja a prím számokat*/
    public static void elsoSzazKozulPrim(){
        for (int i = 1; i < 100; i++){
            if(isPrim(i))
                System.out.print(i + " ");
        }
    }

    /**Paraméterben megadott oldalhosszak alapján visszaadja a háromszög kerületét
     * Érvénytelen háromszög esetén -1-et ad vissza*/
    public static double haromszogKerulet(double a, double b, double c){
        return (haromszogValid(a,b,c)) ? (a+b+c) : -1;
    }

    /**Paraméterben megadott oldalhosszak alapján visszaadja a háromszög területét
     * Érvénytelen háromszög esetén -1-et ad vissza*/
    public static double haromszogTerulet(double a, double b, double c){
        double s = haromszogKerulet(a,b,c)/2;
        double T = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return (haromszogValid(a,b,c)) ? T : -1;
    }

    /**Visszaadja, hogy az oldalhosszak alapján megszerkeszthető e a háromszög*/
    public static boolean haromszogValid(double a, double b, double c){
        if(a<=0 || b<=0 || c<=0) return false;//Ha valamelyik oldal 0 vagy kisebb, akkor nem szerkeszthető meg
        if((a+b<c) || (a+c<b) || (b+c<a)) return false;//Ha valamelyik oldal nagyobb a másik kettő összegénél, akkor nem szerkeszthető meg
        return true;//Ha egyik feltétel sem dobta el a vezérlést, akkor megszerkeszthető a háromszög
    }

    /**@param tizedesSzam ennyi darab tizedesjegyre kerekíti a számot*/
    public static double tizedesreKerekit(double szam, int tizedesSzam){
        double temp = Math.round(szam * Math.pow(10,tizedesSzam)) / Math.pow(10,tizedesSzam);
        return temp;
    }

    /**Visszaadja a másodfokú függvény diszkriminánsát*/
    public static double diszkriminans(double a, double b, double c){
        return b*b-4.0*a*c;
    }

    /**Diszkrimináns alapján kiszámolja a másodfokú függvény megoldásainak számát*/
    public static int megoldasokSzama(double a, double b, double c){
        double d = diszkriminans(a,b,c);
        return (d == 0) ? 1 : (d > 0) ? 2 : 0;
    }

    /**Megoldja a másodfokú egyenletet*/
    public static void masodfoku(double a, double b, double c){
        System.out.println("Diszkrimináns értéke: " + diszkriminans(a,b,c));
        switch (megoldasokSzama(a,b,c)){
            case 0:{
                System.out.println("Nincs valós megoldás");
                break;
            }
            case 1:{
                double x = (-b+Math.sqrt(diszkriminans(a,b,c)))/(2.0*a);
                System.out.println("Megoldás: " + x);
                break;
            }
            case 2:{
                double x1 = (-b+Math.sqrt(diszkriminans(a,b,c)))/(2.0*a);
                double x2 = (-b-Math.sqrt(diszkriminans(a,b,c)))/(2.0*a);
                System.out.println("Egyik megoldás: " + x1);
                System.out.println("Másik megoldás: " + x2);
                break;
            }
        }
    }

    /**@param x hatványozandó szám
     * @param n hatvány
     * Visszaadja x n-edik hatványát rekurzívan*/
    public static int hatvany(int x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        return x * hatvany(x, n-1);
    }

    public static int faktorialis(int x){
        if(x == 0 || x == 1) return 1;
        return x * faktorialis(x-1);
    }

    public static int fibonacci(int x){
        if(x == 0 || x == 1) return x;
        return fibonacci(x-2)+fibonacci(x-1);
    }

    /**Minimum kiválasztásos rendezés*/
    public static void rendezes(int [] tomb){
        for (int i = 0; i < tomb.length-1; i++){
            for (int j = i+1; j < tomb.length; j++){
                if(tomb[i] > tomb[j]){
                    csere(i,j,tomb);
                }
            }
        }
    }

    public static void csere(int i, int j, int[] x){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static int[] randomTomb(int min, int max, int darabszam){
        int[] temp = new int[darabszam];
        Random random = new Random();
        for (int i = 0; i < darabszam; i++){
            temp[i] = random.nextInt(min,max);
        }
        return temp;
    }

    public static int[] elsoTizPrimTombben(){
        int[] temp = new int[10];
        int db = 0;
        int szam = 2;
        while(db < 10){
            if(isPrim(szam)){
                temp[db] = szam;
                db++;
            }
            szam++;
        }
        return temp;
    }

    public static void main(String[] args) {
        //hello();
        //int a = 2;
        //int b = ketszeres(a);
        //System.out.println(b);
        //System.out.println(osszead(a,b));
        //Integer c = 5;
        //Integer d = 23;
        //csere(c,d);
        //System.out.println("c: " + c + " d: " + d);
        //int[] tomb = {1,3,5,7,9,11,17};
        //tombKiir(tomb);
        //System.out.println(tombAtlag(tomb));
        //elsoSzazKozulPrim();
        //System.out.println(haromszogKerulet(1,2,5));
        //System.out.println(haromszogTerulet(5,6,10));
        //System.out.println(tizedesreKerekit(haromszogTerulet(5,6,10),2));
        //masodfoku(1,-3,4);
        //System.out.println(hatvany(2,5));
        int[] szamok = {3,2,67,5,8,7,24,13};
        for (int i = 0; i < szamok.length; i++)
            System.out.print(szamok[i]+" ");
        rendezes(szamok);
        System.out.println();
        for (int i = 0; i < szamok.length; i++)
            System.out.print(szamok[i]+" ");
        System.out.println("---------------------------------");

        int[] szamok2 = randomTomb(5,30,50);
        for (int i = 0; i < szamok2.length; i++)
            System.out.print(szamok2[i]+" ");
        rendezes(szamok2);
        System.out.println();
        for (int i = 0; i < szamok2.length; i++)
            System.out.print(szamok2[i]+" ");

        System.out.println("---------------------------------");

        int[] szamok3 = elsoTizPrimTombben();
        for (int i = 0; i < szamok3.length; i++)
            System.out.print(szamok3[i]+" ");
    }
}
