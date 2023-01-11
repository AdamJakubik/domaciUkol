public class Zakaznik {

    private String jmeno;
    private int pocetProdeju;

    public Zakaznik(String jmeno, int pocetProdeju) throws ZvysPocetProdeju{
        this.jmeno = jmeno;
        setPocetProdeju(pocetProdeju);
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getPocetProdeju() {
        return pocetProdeju;
    }

    public void setPocetProdeju(int pocetProdeju) throws ZvysPocetProdeju {
        if (pocetProdeju <= 0) {
            throw new ZvysPocetProdeju("Nesmí být záporné (" + pocetProdeju + ")!");
        }
        this.pocetProdeju = pocetProdeju;
    }
}
