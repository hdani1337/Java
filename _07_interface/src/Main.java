import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       /*Diak diakok[] = {
               new Diak("Józsi",3.9),
               new Diak("Béla",3.9),
               new Diak("Kázmér",4.7),
               new Diak("Tihamér",4.2),
               new Diak("Adolf",2.1),
       };

        Arrays.sort(diakok);

        for (Diak d : diakok)
            System.out.println(d);*/
        /*
        int x = 15;
        System.out.println(MyMath.isPrim(15));
        System.out.println(MyMath.abs(-5));
        System.out.println(MyMath.pow(2,5));*/

        Diak a = new Diak("Józsi",4);
        Diak b = new Diak("Józsi",4);
        Negyzet negyzet = new Negyzet();
        System.out.println(a.equals(b));
        System.out.println(a.equals(negyzet));

        /*
        * Tömbbe 5 autó, rendezés, adók összege*/
        Auto autok[] = {
                new Auto("Toyota","XCD-340",1600,"Józsika",2006),
                new Auto("Fiat","IYT-643",1300, "Ilonka", 2003),
                new Auto("Suzuki","GBY-341",1300, "Tihamér",1997),
                new Auto("Honda","GFJ-382",2200, "Kristóf",2011),
                new Auto("BMW","FKE-482",4900, "Lacika",2001)
        };

        Arrays.sort(autok);
        int osszAdo = 0;
        for(Auto auto : autok) {
            System.out.println(auto);
            osszAdo += auto.ado();
        }

        System.out.println("Összadó: " + osszAdo);
    }
}
