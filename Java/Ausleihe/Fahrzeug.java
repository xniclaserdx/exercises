public abstract class Fahrzeug
{
    private String name;
    private int preis;
    public Fahrzeug(String pName,int pPreis){
        name=pName;
        preis=pPreis;
    }
    abstract public String getKlasse();
}
