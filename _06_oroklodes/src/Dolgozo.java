public class Dolgozo {
    protected String nev;
    protected String szakma;
    protected int fizetes;

    public Dolgozo() {
    }

    public Dolgozo(String nev, String szakma, int fizetes) {
        this.nev = nev;
        this.szakma = szakma;
        this.fizetes = fizetes;
    }

    public int evesFizetes(){return fizetes*12;}

    public String getNev() {return nev;}
    public void setNev(String nev) {this.nev = nev;}

    public String getSzakma() {return szakma;}
    public void setSzakma(String szakma) {this.szakma = szakma;}

    public int getFizetes() {return fizetes;}
    public void setFizetes(int fizetes) {this.fizetes = fizetes;}

    @Override
    public String toString() {
        return nev + " vagyok, " + szakma + ", " + fizetes + " forintból éhezek.";
    }
}
