public class Fahrrad extends Fahrzeug
{
    private String schlossquali;
    public Fahrrad(String pSchlossquali, int pPreis, String pName)
    {
        super(pName,pPreis);
        schlossquali=pSchlossquali;
    } 
    public String getKlasse()
    {
       return "Fahrrad";
    }
    public String getSchlossquali(){
        return schlossquali;
    }
}
