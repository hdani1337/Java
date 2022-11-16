public class SMS implements Comparable{
    private String telefonszam;
    private String ido;
    private String uzenet;

    public SMS(String telefonszam, String ido, String uzenet) {
        this.telefonszam = telefonszam;
        this.ido = ido;
        this.uzenet = uzenet;
    }

    public SMS(SMS masik){
        this.telefonszam = masik.telefonszam;
        this.ido = masik.ido;
        this.uzenet = masik.uzenet;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }

    public String getIdo() {
        return ido;
    }

    public void setIdo(String ido) {
        this.ido = ido;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }

    @Override
    public String toString() {
        return "SMS{" +
                telefonszam + " telefonszámról " +
                 ido + "-kor érkezett üzenet: '" + uzenet + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof SMS){
            return this.telefonszam.compareTo(((SMS)o).telefonszam);
        }else throw new IllegalArgumentException("A megadott objektum nem SMS típusú!");
    }
}
