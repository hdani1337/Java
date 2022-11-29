public class Hianyzas implements Comparable{
    private String osztaly;
    private String nev;
    private String hianyzas;
    private char nem;

    public Hianyzas(String osztaly, String nev, String hianyzas, char nem) {
        this.osztaly = osztaly;
        this.nev = nev;
        this.hianyzas = hianyzas;
        this.nem = nem;
    }

    public Hianyzas() {
    }

    public String getOsztaly() {
        return osztaly;
    }

    public void setOsztaly(String osztaly) {
        this.osztaly = osztaly;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getHianyzas() {
        return hianyzas;
    }

    public void setHianyzas(String hianyzas) {
        this.hianyzas = hianyzas;
    }

    public char getNem() {
        return nem;
    }

    public void setNem(char nem) {
        this.nem = nem;
    }

    public Hianyzas(Hianyzas h){
        setOsztaly(h.getOsztaly());
        setHianyzas(h.getHianyzas());
        setNev(h.getNev());
        setNem(h.getNem());
    }

    public Hianyzas(String line){
        String[] adatok = line.split(";");
        setOsztaly(adatok[0]);
        setNev(adatok[1]);
        setHianyzas(adatok[2]);
        setNem(adatok[3].charAt(0));
    }

    @Override
    public String toString() {
        return nev + " (" + osztaly + ", " + nem + "): " + hianyzas;
    }

    public boolean adottOranHianyzott(int nap){
        return hianyzas.charAt(nap) == 'x';
    }

    public int mennyitHianyzott(){
        int darab = 0;
        for (int i = 0; i < hianyzas.length(); i++){
            if(hianyzas.charAt(i) == 'x')
                darab++;
        }
        return darab;
    }

    @Override
    public int compareTo(Object o) {
        if(o != null && o instanceof Hianyzas){
            return this.mennyitHianyzott() - ((Hianyzas)o).mennyitHianyzott();
        }else return 0;
    }
}
