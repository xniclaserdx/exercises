
public class Patient
{
    private String vorname;
    private String nachname;
    private long nummer;
    
    public Patient(String vorname,String nachname,long nummer)
    {
        this.vorname=vorname;
        this.nachname=nachname;
        this.nummer=nummer;
    } // Konstruktor

    public String getVorname(){
        return this.vorname;
    } // vorname
    
    public String getNachname(){
        return this.nachname;
    } // getNachname
    
    public long getNummer(){
        return this.nummer;
    } // getNummer
} // class
