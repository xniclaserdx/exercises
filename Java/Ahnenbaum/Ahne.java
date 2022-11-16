public class Ahne
{
 private String vorname;
 private String nachname;
 private char geschlecht;
 public Ahne(String pVor,String pNach, char pG)
    {
        vorname= pVor;
        nachname= pNach;
        geschlecht= pG;
    }
 public String getVorname(){return vorname;}
 public String getNachname(){return nachname;}
 public char getGe(){return geschlecht;}
 public void setVorname(String pVor){vorname=pVor;}
 public void setNachame(String pNach){nachname=pNach;}
 public void setGeschlecht(char pG){geschlecht=pG;}
}
