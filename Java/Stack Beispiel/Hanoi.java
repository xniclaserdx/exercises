
public class Hanoi
{
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private Stack<Integer> s3;
    public Hanoi()
    {
        s1=new Stack();
        s2=new Stack();
        s3=new Stack();
        
     //   s1.push(new Integer(5));   // Weitere Scheiben - Dann muss i beim Aufruf erhöht werden.
     //   s1.push(new Integer(4));
        s1.push(new Integer(3));
        s1.push(new Integer(2));
        s1.push(new Integer(1));
              
        // Rekursion
        verschiebe(3,s1,s2,s3);
        
        // Kontrolle
        if(s1.isEmpty()) System.out.println("S1 ist leer");
        else System.out.println("S1 ist nicht leer");
        
        if(s2.isEmpty()) System.out.println("S2 ist leer");
        else System.out.println("S2 ist nicht leer");
        
        System.out.println("S3:");
        while(!s3.isEmpty()){
          Integer i=s3.top();
          System.out.println(i.toString());
          s3.pop();
        } // while
        
    } // Konstruktor
    
    // Verschiebe

    public void verschiebe(int i,Stack<Integer> a, Stack<Integer> b,Stack<Integer> c){
      if(i>0){
        
        verschiebe(i-1,a,c,b);   
        
        Integer scheibe =a.top();
        a.pop();
        
        c.push(scheibe);
              
        if(a.equals(s1)) System.out.print("von A - "+scheibe.toString());
        if(a.equals(s2)) System.out.print("von B - "+scheibe.toString());
        if(a.equals(s3)) System.out.print("von C - "+scheibe.toString());
        if(c.equals(s1)) System.out.println(" nach A ");
        if(c.equals(s2)) System.out.println(" nach B ");
        if(c.equals(s3)) System.out.println(" nach C ");
               
        verschiebe(i-1,b,a,c);
      } // if
        
    } // verschiebe
  
}
