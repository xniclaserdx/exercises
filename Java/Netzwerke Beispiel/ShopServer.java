public class ShopServer extends Server
{
    private List bestellungen;
    public ShopServer(int pPortnummer)
    {
        super(pPortnummer);
        bestellungen = new List<Bestellung>();
    }
    public void processNewConnection(String pClientIP, int pClientPort)
    {
        this.send(pClientIP, pClientPort, "Willkommen! Wählen Sie eine Größe und eine Farbe für Ihr T-Shirt.");
    }
    public void processMessage(String pClientIP, int pClientPort, String pMessage)
    {
        String[] nachrichtTeil = pMessage.split(":");
        if(nachrichtTeil[0].equals("TSHIRT"))
        {
            bestellungAufnehmen(pClientIP, nachrichtTeil[1], nachrichtTeil[2]);
            this.send(pClientIP, pClientPort, "Die Groesse ist " + nachrichtTeil[1] + ", die Farbe ist " + nachrichtTeil[2]+" und es kostet 19,99 Euro!"+"\n"+"Bitte bestätigen Sie die Bestellung.");
        }
        else if(nachrichtTeil[0].equals("BESTAETIGUNG"))
        {
            if(nachrichtTeil[1].equals("ja"))
            {
                this.send (pClientIP, pClientPort, "Vielen Dank für Ihre Bestellung.");
                closeConnection(pClientIP, pClientPort);
            }
            else if (nachrichtTeil[1].equals("nein"))
            {
                closeConnection(pClientIP, pClientPort);
            }
            else
            {
                this.send(pClientIP, pClientPort, "Bitte geben Sie ja oder nein ein.");
            }
        }
        else if (nachrichtTeil[0].equals("ABMELDEN"))
        {
            closeConnection(pClientIP, pClientPort);
        }
        else
        {
            this.send(pClientIP, pClientPort, "Bitte korrigieren Sie Ihre Eingabe.");
            
        }
    }
    public void bestellungAufnehmen(String pIPIdnr, String pGroesse, String pFarbe)
    {
        System.out.println(pIPIdnr);
        TShirt ware = new TShirt();
        ware.setGroesse(pGroesse);
        ware.setFarbe(pFarbe);
        Bestellung aktuell = new Bestellung(ware);
        String id=pIPIdnr.replace(".","");
        System.out.println(id);
        aktuell.setIdnr(Long.parseLong(id));
        bestellungen.append(aktuell);
    }
}
