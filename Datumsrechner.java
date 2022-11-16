public class Datumsrechner
{
    public static void main(String[] args){
        int tag, monat, jahr, t;
        
        tag = SimpleIO.getInt ("Bitte geben Sie die Tageskomponente des Startdatums ein.");
        monat = SimpleIO.getInt ("Bitte geben Sie die Monatskomponente des Startdatums ein.");
        jahr = SimpleIO.getInt ("Bitte geben Sie die Jahreskomponente des Startdatums ein.");
        t = SimpleIO.getInt("Bitte geben Sie die Anzahl an Tagen ein:");
        
        if((tag<32 && (monat==1 ||  monat==3 || monat==5 || monat==7 || monat==8 ||monat==10 || monat==12)) || (tag<29 && monat==2) || (tag<30 && (monat==4 || monat==6 || monat==9  || monat==11)) && t>=0){
            for(int i=0; i<t; i++){
                if(monat==1 || monat==3 || monat==5 || monat==7 || monat==8 ||monat==10 || monat==12){
                    tag++;
                    if(tag>31){
                        tag=1;
                        monat++;
                    } 
                    if(monat>12){
                        jahr++;
                        monat=1;
                    } 
                } 
                if(monat==2){
                    tag++;
                    if(tag>28){
                        tag=1;
                        monat++;
                    } 
                } 
                if(monat==4 || monat==6 || monat==9  || monat==11){
                    tag++;
                    if(tag>30){
                        tag=1;
                        monat++;
                    } 
                } 
            } 
            String resultat = tag+"."+monat+"."+jahr;
            System.out.println(resultat);
        } 
        else{
            System.out.println("ungültige Eingabe");
        } 
    }
}    