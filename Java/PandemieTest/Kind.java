package Desktop;

public class Kind extends Person
{
    private int alter;
    public Kind(String pName,boolean pInfiziert)
    {
     super(pName,pInfiziert);
    }
    public int getAlter()
    {
       return alter;
    }
    public String getKlasse(){
        return "Kind";
    }
}
