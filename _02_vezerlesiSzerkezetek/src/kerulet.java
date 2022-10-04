import java.util.Scanner;

public class kerulet {

    public static void kerekites(){
        int visszajaro = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Kérem adja meg a visszajárót: ");
        visszajaro = scan.nextInt();
        int kerekitett = visszajaro - visszajaro%10;
        switch (visszajaro%10){
            case 0 : case 1 : case 2:{
                System.out.println("0-ra kerekít");
                //marad a kerekített
                break;
            }
            case 3 : case 4: case 5 : case 6: case 7:{
                System.out.println("5-re kerekít");
                kerekitett += 5;
                break;
            }
            case 8: case 9:{
                System.out.println("10-re kerekít");
                kerekitett += 10;
                break;
            }
            default:{
                System.out.println("Lol");
                throw new IllegalArgumentException("Hibás a visszajáró");
            }
        }
        System.out.println("A visszajáró: " + kerekitett + " forint.");
        scan.close();
    }

    public static void kerulet(){
        int kerulet = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Kérem a kerület sorszámát: ");
        kerulet = scan.nextInt();
        switch (kerulet){
            case 1:{
                System.out.println("Budavár");
                break;
            }
            case 3:{
                System.out.println("Óbuda");
                break;
            }
            case 5:{
                System.out.println("Lipótváros");
                break;
            }
            case 6:{
                System.out.println("Terézváros");
                break;
            }
            case 7:{
                System.out.println("Erzsébetváros");
                break;
            }
            default:{
                System.out.println("Valamelyik kerület :)");
                break;
            }
        }
        scan.close();
    }

    public static void piSzamolas(){
        double pi = 0;
        double elojel = 1;
        for (int i = 1; i < 1000; i++){
            pi += 1/(i*elojel);
            elojel *=-1;
        }
        System.out.println(pi*4);
    }

    public static void tombok(){
        int szamok[] = {2,3,5,7,11,13,17,19};
        int szamok2[] = new int[10];
        System.out.println(szamok.length);

        for (int i = 0; i < szamok2.length; i++){
            szamok2[i] = 2*i;
            System.out.println(szamok2[i]);
        }
    }

    public static void fibonacci(){
        int szamok[] = new int[30];
        szamok[0] = 0;
        szamok[1] = 1;
        for (int i = 2; i < szamok.length; i++){
            szamok[i] = szamok[i-1] + szamok[i-2];
            System.out.print(szamok[i] + ", ");
        }
    }

    public static void tobbdimenziosTomb(){
        int width = 5;
        int height = 6;
        int matrix [][] = new int[height][width];
        int osszeg = 0;
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                matrix[i][j] = (int)(Math.random()*10);
                osszeg += matrix[i][j];
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxI = i;
                    maxJ = j;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Átlag: " + (osszeg/(width*height*1.0)));
        System.out.println("Legnagyobb szám: " + max + ", helye: [" + maxI + "," + maxJ + "]");
    }

    public static void valtozoMatrix(){
        int matrix [][] = new int[4][];
        matrix[0] = new int[3];
        matrix[1] = new int[4];
        matrix[2] = new int[5];
        matrix[3] = new int[6];

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = (int)(Math.random()*10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transzponalas(){
        int width = 8;
        int height = 8;
        int matrix [][] = new int[height][width];

        System.out.println("--EREDETI MÁTRIX--");
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                matrix[i][j] = (int)(Math.random()*10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if(i < j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        System.out.println("--TRANSZPONÁLT MÁTRIX--");
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        System.out.println("--TRANSZPONÁLT MÁTRIX ÁTLÓ ALATTI FELE--");
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                System.out.print(((j<=i)?matrix[i][j]:" ") + " ");
            }
            System.out.println();
        }

        int mellekatloOsszege = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++) {
                if(i+j==width-1)
                    mellekatloOsszege += matrix[i][j];
            }
        }
        System.out.println("Mellékátló összege: " + mellekatloOsszege);
    }

    public static void sorCsere(){
        int n = 4;
        int matrix [][] = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = (int)(Math.random()*10);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int egyik = 0;
        int masik = 0;
        System.out.print("Egyik sor: ");
        Scanner scan = new Scanner(System.in);
        egyik = scan.nextInt();
        System.out.print("Másik sor: ");
        masik = scan.nextInt();
        scan.close();

        int egyikSor[] = matrix[egyik];
        matrix[egyik] = matrix[masik];
        matrix[masik] = egyikSor;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void szinhaz(){
        //véletlenszerűen generálni foglaltsági 20x30 mátrixon (foglalt=1, üres=0)
        //mennyi jegyet adtak el, bevételt számolni
        //helyet bekérni, üres vagy foglalt
        //melyik sorban ülnek a legtöbben?

        int nezoter[][] = new int[20][30];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 30; j++){
                nezoter[i][j] = ((Math.random()<=0.5)?1:0);
            }
        }

        int jegyekSzama = 0;
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < 20; i++){
            int sorDb = 0;
            for (int j = 0; j < 30; j++){
                if(nezoter[i][j]==1) {
                    jegyekSzama++;
                    sorDb++;
                }
                System.out.print((nezoter[i][j]==1)?"O":" ");
            }
            if(sorDb > max){
                max = sorDb;
                maxIndex = i;
            }
            System.out.println();
        }

        System.out.println(jegyekSzama + " darab jegyet adtak el.");
        System.out.println(maxIndex + ". sorban ültek a legtöbben.");
    }

    public static void main(String[] args) {
        szinhaz();
    }
}
