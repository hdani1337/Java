public class Diak {
    private String nev;
    private double tanulmanyiAtlag;

    public Diak(String nev, double tanulmanyiAtlag) throws DiakException {
        setNev(nev);
        setTanulmanyiAtlag(tanulmanyiAtlag);
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public double getTanulmanyiAtlag() {
        return tanulmanyiAtlag;
    }

    public void setTanulmanyiAtlag(double tanulmanyiAtlag) throws DiakException {
        if(tanulmanyiAtlag < 1 || tanulmanyiAtlag > 5){
            throw new DiakException("Tanulmányi átlag 1.0 és 5.0 között lehet csak!");
        }else this.tanulmanyiAtlag = tanulmanyiAtlag;
    }

    public int osztondij(){
        return (tanulmanyiAtlag >= 3.5) ? 20000 : 10000;
    }

    @Override
    public String toString() {
        return "Diak{" +
                "nev='" + nev + '\'' +
                ", tanulmanyiAtlag=" + tanulmanyiAtlag +
                '}';
    }
}
