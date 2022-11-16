import basis.*;
public class UserInterface implements KnopfLauscher
{
   private TextFeld tf1, tf2;
   private Fenster f;
   private Knopf k1,k2;
   private BinaryTree<Character> baum;
   public boolean neueszeichen, fertig;
   public String code, textneu;
   public String ausgabe;
   public UserInterface()
   {
     f = new Fenster(500,500);
     tf1 = new TextFeld(20,20,200,50);
     tf2 = new TextFeld(20,100,200,50);
     k1 = new Knopf("übersetzen",20,200,200,50);
     k2 = new Knopf("zuhrück übersetzen",20,300,200,50);
     k1.setzeKnopfLauscher(this);
     k2.setzeKnopfLauscher(this);     BinaryTree<Character> b1=new BinaryTree<Character>('H');
     BinaryTree<Character> b2=new BinaryTree<Character>('V');
     
     BinaryTree<Character> b3=new BinaryTree<Character>('S',b1,b2);
     BinaryTree<Character> b4=new BinaryTree<Character>('F');
     BinaryTree<Character> b5=new BinaryTree<Character>('Ü');
     
     BinaryTree<Character> b6=new BinaryTree<Character>('U',b4,b5);
     BinaryTree<Character> b7=new BinaryTree<Character>('L');
     BinaryTree<Character> b8=new BinaryTree<Character>('Ä');
     
     BinaryTree<Character> b9=new BinaryTree<Character>('R',b7,b8);
     BinaryTree<Character> b10=new BinaryTree<Character>('P');
     BinaryTree<Character> b11=new BinaryTree<Character>('J');
     
     BinaryTree<Character> b12=new BinaryTree<Character>('W',b10,b11);
     BinaryTree<Character> b13=new BinaryTree<Character>('B');
     BinaryTree<Character> b14=new BinaryTree<Character>('X');
     
     BinaryTree<Character> b15=new BinaryTree<Character>('D',b13,b14);
     BinaryTree<Character> b16=new BinaryTree<Character>('C');
     BinaryTree<Character> b17=new BinaryTree<Character>('Y');
     
     BinaryTree<Character> b18=new BinaryTree<Character>('K',b16,b17);
     BinaryTree<Character> b19=new BinaryTree<Character>('Z');
     BinaryTree<Character> b20=new BinaryTree<Character>('Q');
     
     BinaryTree<Character> b21=new BinaryTree<Character>('G',b19,b20);
     BinaryTree<Character> b22=new BinaryTree<Character>('Ö');
     BinaryTree<Character> b23=new BinaryTree<Character>('O',b22,new BinaryTree<Character>());
     
     BinaryTree<Character> b24=new BinaryTree<Character>('I',b3,b6);
     BinaryTree<Character> b25=new BinaryTree<Character>('A',b9,b12);
     BinaryTree<Character> b26=new BinaryTree<Character>('N',b15,b18);
     BinaryTree<Character> b27=new BinaryTree<Character>('M',b21,b23);
     BinaryTree<Character> b28=new BinaryTree<Character>('E',b24,b25);
     BinaryTree<Character> b29=new BinaryTree<Character>('T',b26,b27);
     
     baum=new BinaryTree<Character>(' ',b28,b29);
    }
   public void bearbeiteKnopfDruck(Knopf knopf){ 
        if(knopf==k1){
             tf2.setzeText("");
             translate();
        }
        if(knopf==k2){
             tf1.setzeText("");
             zurueckcode();
        }
    }
    public void translate(){
        neueszeichen=false;
        code=tf1.text();
        char[] codearray=code.toCharArray();
        int k=0;
        while(k<codearray.length){
              BinaryTree<Character> tempbaum=baum;
              neueszeichen=false;
              while(!neueszeichen){
                    if(k==codearray.length){
                        k++;
                        neueszeichen=true;
                        tf2.setzeText(tf2.text()+Character.toString(tempbaum.getContent()));
                   }
                    else if(codearray[k]=='/'){
                        k++;
                        neueszeichen=true;
                        tf2.setzeText(tf2.text()+Character.toString(tempbaum.getContent()));
                   } 
                    else if(codearray[k]=='-'){
                        tempbaum=tempbaum.getRightTree();
                        k++;
                   }
                    else if(codearray[k]=='.'){
                        tempbaum=tempbaum.getLeftTree();
                        k++;
                   }
                    else{
                       neueszeichen=true;
                       tf2.setzeText("");
                   }
              }
        }
   }
    public void zurueckcode(){ // idee: array wird durchlaufen und dann je nach dem ob der Char gleich ist . oder - hinzugefügt
        textneu=tf2.text();
        char[] arrayCode=textneu.toCharArray();
        int j=0;
        while(j<arrayCode.length){
            fertig=false;
            // vergleicheChar(arrayCode[j],baum); : potentielle Methode welche Char vergleicht und dann mit Algorhytmus (postorder,preorder, inorder) entweder . oder - hinzufügt.
            if(fertig){
                 tf1.setzeText(ausgabe);  // ausgeben des übersetzten Texts
                 if(j<arrayCode.length-1){
                     tf1.setzeText(tf1.text()+"/"); // wenn der entsprechende Buchstabe übersetzt ist und das limit überschreitet, wird dann durch / getrennt.
                }
            }
            j++;
        } 
   } 
   // vergleicheChar(char vergleichschar,BinaryTree<Character> tree){   }
}
