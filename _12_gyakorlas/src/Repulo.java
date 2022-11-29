public class Repulo {
    //óra, perc-kor érkezik, honnan indult hová, óra, perc repülési idő, légitársaság neve
    //beolvasni, eltárolni
    //repcsi osztály, get, set, tostring
    //rendezés az indulási idő alapján
    //hány repülő érkezik Bp-re, illetve mennyi indul onnan?
    //mikor érkezik meg a repülő? (indulás+menetidő)
    //hány járatuk van a repülőtársaságoknak?
    //londoni (induló és érkező is) járatok átlagos utazási idejét
    //Budapestről mely európai városokba indul járat
    //Budapestről induló járatokat kiírni budapest.txt-be (mikor indul, mikor érkezik, melyik városba)
    //Fájlba példa: 14:10 16:50 Budapest Párizs
    int oraIndul;
    int percIndul;
    String indulasHelye;
    int oraRepules;
    int percRepules;
    String legitarsasagNeve;

    public Repulo(int oraIndul, int percIndul, String indulasHelye, int oraRepules, int percRepules, String legitarsasagNeve) {
        this.oraIndul = oraIndul;
        this.percIndul = percIndul;
        this.indulasHelye = indulasHelye;
        this.oraRepules = oraRepules;
        this.percRepules = percRepules;
        this.legitarsasagNeve = legitarsasagNeve;
    }

    @Override
    public String toString() {
        return "Repulo{" +
                "oraIndul=" + oraIndul +
                ", percIndul=" + percIndul +
                ", indulasHelye='" + indulasHelye + '\'' +
                ", oraRepules=" + oraRepules +
                ", percRepules=" + percRepules +
                ", legitarsasagNeve='" + legitarsasagNeve + '\'' +
                '}';
    }

    public Repulo(String line){
        String[] adatok = line.split("\s");
        setOraIndul(Integer.parseInt(adatok[0]));
        setPercIndul(Integer.parseInt(adatok[1]));
        setIndulasHelye(adatok[2]);
        setOraRepules(Integer.parseInt(adatok[3]));
        setPercRepules(Integer.parseInt(adatok[4]));
        setLegitarsasagNeve(adatok[5]);
    }

    public int getOraIndul() {
        return oraIndul;
    }

    public void setOraIndul(int oraIndul) {
        this.oraIndul = oraIndul;
    }

    public int getPercIndul() {
        return percIndul;
    }

    public void setPercIndul(int percIndul) {
        this.percIndul = percIndul;
    }

    public String getIndulasHelye() {
        return indulasHelye;
    }

    public void setIndulasHelye(String indulasHelye) {
        this.indulasHelye = indulasHelye;
    }

    public int getOraRepules() {
        return oraRepules;
    }

    public void setOraRepules(int oraRepules) {
        this.oraRepules = oraRepules;
    }

    public int getPercRepules() {
        return percRepules;
    }

    public void setPercRepules(int percRepules) {
        this.percRepules = percRepules;
    }

    public String getLegitarsasagNeve() {
        return legitarsasagNeve;
    }

    public void setLegitarsasagNeve(String legitarsasagNeve) {
        this.legitarsasagNeve = legitarsasagNeve;
    }

    public String erkezesiIdo(){
        int idoPercben = oraIndul*60+percIndul + oraRepules*60+percRepules;
        int ora = idoPercben / 60;
        int perc = idoPercben  % 60;
        return ora + ":" + perc;
    }
}
