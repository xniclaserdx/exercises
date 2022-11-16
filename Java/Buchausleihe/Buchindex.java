
public class Buchindex {
  private BinarySearchTree<Stichwort> suchbaum;

  public Buchindex() {
    suchbaum = new BinarySearchTree<Stichwort>();
  }

  public void erzeugeTestbelegung() {
    insert("FIFO",10);
    insert("Liste",14);
    insert("Schlange",17);
    insert("Schlange",19);
    insert("Liste",20);
    insert("LIFO",20);
    insert("Baum",34);
    insert("Automat",5);
    insert("Automat",63);
    insert("Liste",65);
    insert("Baum",78);
    insert("Baum",83);
    insert("Liste",89);
    insert("Liste",95);
  }

  public void insert(String pWort, int pSeite)     {
    Stichwort myItem = new Stichwort(pWort,pSeite);
    // lokale Variable 
    if (suchbaum.search(myItem) != null)
      ((Stichwort) suchbaum.search(myItem)).fuegeSeitenzahlEin(pSeite);
    else 
      suchbaum.insert(myItem);      
  }

  public List<Stichwort> sortierteListe(BinarySearchTree<Stichwort> baum) {
    if (baum.isEmpty()) {
      return new List<Stichwort>();
    } else {
      List<Stichwort> links = sortierteListe(baum.getLeftTree());
      links.append(baum.getContent());
      List<Stichwort> rechts = sortierteListe(baum.getRightTree());
      links.concat(rechts);
      return links ;
    }
  }

  public String toString() {
    List<Stichwort> liste = sortierteListe(suchbaum);
    String ausgabe="";
    liste.toFirst();
    while (liste.hasAccess()) {
      ausgabe = ausgabe+( liste.getContent()).toString()+"\n";
      liste.next();
    }
    return ausgabe;
  }

}
