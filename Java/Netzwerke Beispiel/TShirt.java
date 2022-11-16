
public class TShirt
{
    private String groesse,farbe;
    private double preis;
    public TShirt()
    {
        preis=19.99;
    }
    String getFarbe(){
        return farbe;
    }
    Double getPreis(){
        return preis;
    }
    String getGroesse(){
        return groesse;
    }
    void setGroesse(String pGroesse){
        groesse=pGroesse;
    }
    void setFarbe(String pFarbe){
        farbe=pFarbe;
    }
    void setPreis(double pPreis){
        preis=pPreis;
    }
}
