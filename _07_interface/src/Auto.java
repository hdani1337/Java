public class Auto extends Jarmu implements Comparable<Auto>{
    /*
    * extends Jarmu
    * - típus
    * - rendszám
    * - hengerűrtartalom
    * - adószámoló függvény
    *   - 0-1000 között 6*ccm3
    *   - 1001-2000 között 8*ccm3
    *   - 2001 felett 10*ccm3
    * - compareTo: első az adó, második a rendszám*/

    private String tipus;
    private String rendszam;
    private int hengerurtartalom;

    public Auto(String tipus, String rendszam, int hengerurtartalom, String tulajdonos, int ev) {
        super(tulajdonos, ev);
        this.tipus = tipus;
        this.rendszam = rendszam;
        this.hengerurtartalom = hengerurtartalom;
    }

    public int ado(){
        return (hengerurtartalom > 2000) ? hengerurtartalom * 10 : (hengerurtartalom > 1000) ? hengerurtartalom * 8 : hengerurtartalom * 6;
    }

    @Override
    public int compareTo(Auto o) {
        if(this.ado() != o.ado()) return this.ado() - o.ado();
        else return this.rendszam.compareTo(o.rendszam);
    }

    @Override
    public String toString() {
        return "Auto{" +
                "tipus='" + tipus + '\'' +
                ", rendszam='" + rendszam + '\'' +
                ", hengerurtartalom=" + hengerurtartalom +
                ", tulajdonos='" + tulajdonos + '\'' +
                ", ev=" + ev +
                '}';
    }
}
