public class Diak<T> {
    public String nev;
    public String osztaly;
    public T tanulmanyiAtlag;

    public Diak(String nev, String osztaly, T tanulmanyiAtlag) {
        this.nev = nev;
        this.osztaly = osztaly;
        this.tanulmanyiAtlag = tanulmanyiAtlag;
    }

    public Diak(String nev, String osztaly) {
        this.nev = nev;
        this.osztaly = osztaly;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getOsztaly() {
        return osztaly;
    }

    public void setOsztaly(String osztaly) {
        this.osztaly = osztaly;
    }

    public T getTanulmanyiAtlag() {
        return tanulmanyiAtlag;
    }

    public void setTanulmanyiAtlag(T tanulmanyiAtlag) {
        this.tanulmanyiAtlag = tanulmanyiAtlag;
    }

    @Override
    public String toString() {
        return "Diak{" +
                "nev='" + nev + '\'' +
                ", osztaly='" + osztaly + '\'' +
                ", tanulmanyiAtlag=" + tanulmanyiAtlag +
                '}';
    }
}
