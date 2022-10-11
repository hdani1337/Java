public class Fonok extends Dolgozo{
    public int potlek;

    public Fonok(String nev, String szakma, int fizetes, int potlek) {
        super(nev, szakma, fizetes);
        this.potlek = potlek;
    }

    public int getPotlek() {return potlek;}
    public void setPotlek(int potlek) {this.potlek = potlek;}

    @Override
    public int evesFizetes() {
        return fizetes*12 + potlek*12;
    }

    @Override
    public String toString() {
        return "Fonok{" +
                "potlek=" + potlek +
                ", nev='" + nev + '\'' +
                ", szakma='" + szakma + '\'' +
                ", fizetes=" + fizetes +
                '}';
    }
}
