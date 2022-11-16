public class Patient
{
    private String vorname;
    private String nachname;
    public Patient(String pVorname,String pNachname)
    {
        vorname=pVorname;
        nachname=pNachname;
    }
    public void setVorname(String pVorname){
        vorname=pVorname;
    }
    public void setNachname(String pNachname){
        nachname=pNachname;
    }
    public String getVorname(){
        return vorname;
    }
    public String getNachname(){
        return nachname;
    }
}