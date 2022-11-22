public class Tanc {
    private String fiu;
    private String lany;
    private String tancnev;

    public Tanc(String fiu, String lany, String tancnev) {
        this.fiu = fiu;
        this.lany = lany;
        this.tancnev = tancnev;
    }

    public Tanc(Tanc t) {
        this.fiu = t.fiu;
        this.lany = t.lany;
        this.tancnev = t.tancnev;
    }

    /**Fájlból beolvasot sort kap meg, ezt szedi szét
     * Az értékek szóközökkel vannak elválasztva egymástól
     * Első érték mindig a fiú neve
     * Második érték mindig a lány neve
     * Harmadik érték mindig a tánc neve*/
    public Tanc(String sor){
        this.fiu = sor.split("\s")[0];
        this.lany = sor.split("\s")[1];
        this.tancnev = sor.split("\s")[2];
    }

    public String getFiu() {
        return fiu;
    }

    public void setFiu(String fiu) {
        this.fiu = fiu;
    }

    public String getLany() {
        return lany;
    }

    public void setLany(String lany) {
        this.lany = lany;
    }

    public String getTancnev() {
        return tancnev;
    }

    public void setTancnev(String tancnev) {
        this.tancnev = tancnev;
    }

    @Override
    public String toString() {
        return fiu + " és " + lany + " " + tancnev + " táncot ad elő.";
    }
}
