import java.util.Arrays;

public class Mozi {
    private String terem[][];

    public Mozi(String[][] terem) {
        this.terem = terem;
    }

    public Mozi() {
        this.terem = new String[10][10];
    }

    public String[][] getTerem() {
        return terem;
    }

    public void setTerem(String[][] terem) {
        this.terem = terem;
    }

    public void print(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                System.out.print(terem[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int foglaltHelyek(){
        int foglalt = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(terem[i][j].equals("1")){
                    foglalt++;
                }
            }
        }
        return foglalt;
    }

    public int getUresHelyekSorbol(int sor){
        int ures = 0;
        for (int j = 0; j < 10; j++){
            if(terem[sor][j].equals("0")){
                ures++;
            }
        }
        return ures;
    }

    public int size(){
        return 100;
    }

    public int bevetel(){
        //1-3. 500ft, 4-6. 1000ft, 7-10. 1500ft a jegy
        int osszeg = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(terem[i][j].equals("1")){
                    osszeg += 500;
                    if(i >= 3) osszeg += 500;
                    if(i >= 6) osszeg += 500;
                }
            }
        }
        return osszeg;
    }

    @Override
    public String toString() {
        return "Mozi{" +
                "terem=" + Arrays.toString(terem) +
                '}';
    }
}
