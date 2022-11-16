public class Bestellung
{
    private long idnr;
    private TShirt ware;
    public Bestellung(TShirt pTShirt){
       ware=pTShirt;
    }
    void setIdnr(long pIdnr){
       idnr=pIdnr;
    }
}
