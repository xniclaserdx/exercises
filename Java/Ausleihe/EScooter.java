
public class EScooter extends Fahrzeug
{
    private int laufzeit;
    public EScooter(int pLaufzeit, int pPreis, String pName)
    {
        super(pName,pPreis);
        laufzeit=pLaufzeit;
    } 
    public String getKlasse()
    {
       return "EScooter";
    }
    public int getLaufzeit(){
        return laufzeit;
    }
}
