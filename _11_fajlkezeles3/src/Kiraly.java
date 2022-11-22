public class Kiraly implements Comparable {
    private String nev;
    private int koronazasEve;
    private int uralkodasVege;
    private String uralkodoHaz;

    public Kiraly(String nev, int koronazasEve, int uralkodasVege, String uralkodoHaz) {
        this.nev = nev;
        this.koronazasEve = koronazasEve;
        this.uralkodasVege = uralkodasVege;
        this.uralkodoHaz = uralkodoHaz;
    }

    public Kiraly() {
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getKoronazasEve() {
        return koronazasEve;
    }

    public void setKoronazasEve(int koronazasEve) {
        this.koronazasEve = koronazasEve;
    }

    public int getUralkodasVege() {
        return uralkodasVege;
    }

    public void setUralkodasVege(int uralkodasVege) {
        this.uralkodasVege = uralkodasVege;
    }

    public String getUralkodoHaz() {
        return uralkodoHaz;
    }

    public void setUralkodoHaz(String uralkodoHaz) {
        this.uralkodoHaz = uralkodoHaz;
    }

    public int uralkodasiIdo(){
        return uralkodasVege - koronazasEve;
    }



    @Override
    public String toString() {
        return nev + ", " + uralkodoHaz + "i király, " + koronazasEve + "-" + uralkodasVege +
                ", azaz " + uralkodasiIdo() + " évig uralkodott.";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Kiraly){
            return this.uralkodasiIdo()-((Kiraly)o).uralkodasiIdo();
        }
        return 0;
    }
}
