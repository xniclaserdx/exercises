public class Erwachsener extends Person
{
    private int alter;
    private int kontaktpersonen;
    public Erwachsener(String pName,boolean pInfiziert,int pKontaktpersonen)
    {
     super(pName,pInfiziert);
     if(infiziert){
        kontaktpersonen=pKontaktpersonen;
        }
    }
    public int getAlter()
    {
       return alter;
    }
    public String getAlterstatus(){
        return "Erwachsener";
    }
    public int getKontaktpersonen(){
        return kontaktpersonen;
    }
}
