public class Lakas {
    //budapesti lakások
    //kerület, azonosító, négyzetméter, állapot, ára millió forintban

    //beolvasni, eltárolni
    //melyik lakás a legdrágább
    //egy tizedes pontossággal átlagár
    //kétfajta hashmap
    //állapotok szerinti darabszám
    //kerület szerinti darabszám
    //melyik kerületekben vannak lakások (hashset)
    //lakás azonosítót bekérni, adatokat kiírni

    private int kerulet;
    private int id;
    private int terulet;
    private String allapot;
    private int arMillio;

    public Lakas(String line){
        String[] adatok = line.split(",");
        kerulet = Integer.parseInt(adatok[0]);
        id = Integer.parseInt(adatok[1]);
        terulet = Integer.parseInt(adatok[2]);
        allapot = adatok[3];
        arMillio = Integer.parseInt(adatok[4]);
    }

    public int getKerulet() {
        return kerulet;
    }

    public void setKerulet(int kerulet) {
        this.kerulet = kerulet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTerulet() {
        return terulet;
    }

    public void setTerulet(int terulet) {
        this.terulet = terulet;
    }

    public String getAllapot() {
        return allapot;
    }

    public void setAllapot(String allapot) {
        this.allapot = allapot;
    }

    public int getArMillio() {
        return arMillio;
    }

    public void setArMillio(int arMillio) {
        this.arMillio = arMillio;
    }

    @Override
    public String toString() {
        return "Lakas{" +
                "kerulet=" + kerulet +
                ", id=" + id +
                ", terulet=" + terulet +
                ", allapot='" + allapot + '\'' +
                ", arMillio=" + arMillio +
                '}';
    }
}
