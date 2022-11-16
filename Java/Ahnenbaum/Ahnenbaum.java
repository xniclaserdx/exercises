public class Ahnenbaum
{
    private BinaryTree<Ahne> lisasAhnenbaum;
    public Ahnenbaum()
    {
        BinaryTree<Ahne> b1 =new BinaryTree<Ahne>(new Ahne("Jaqueline","Bouvier",'w'));
        BinaryTree<Ahne> b2 =new BinaryTree<Ahne>(new Ahne("Clancy","Bouvier",'m'));
        BinaryTree<Ahne> b3 =new BinaryTree<Ahne>(new Ahne("Marge","Simpson",'w'),b1,b2);
        BinaryTree<Ahne> b4 =new BinaryTree<Ahne>(new Ahne("Mona","Simpson",'w'));
        BinaryTree<Ahne> b5 =new BinaryTree<Ahne>(new Ahne("Abraham J.","Simpson",'m'));
        BinaryTree<Ahne> b6 =new BinaryTree<Ahne>(new Ahne("Homer","Simpson",'m'),b4,b5);
        lisasAhnenbaum= new BinaryTree<Ahne>(new Ahne("Lisa","Simpson",'w'),b3,b6);
        System.out.println("");
        System.out.println("Preorder");
        System.out.println("");
        besuchePreorder(lisasAhnenbaum);
        System.out.println("");
        System.out.println("Inorder");
        System.out.println("");
        besucheInorder(lisasAhnenbaum);
        System.out.println("");
        System.out.println("Postorder");
        System.out.println("");
        besuchePostorder(lisasAhnenbaum);
    }
    void besuchePreorder(BinaryTree<Ahne> tree){
        Ahne pAhne=tree.getContent();
        System.out.println(pAhne.getVorname());
        if(!tree.getLeftTree().isEmpty()){
            besuchePreorder(tree.getLeftTree());
        }
        if(!tree.getRightTree().isEmpty()){
            besuchePreorder(tree.getRightTree());
        }
    }
    void besucheInorder(BinaryTree<Ahne> tree){
        if(!tree.getLeftTree().isEmpty()){
            besucheInorder(tree.getLeftTree());
        }
        Ahne pAhne=tree.getContent();
        System.out.println(pAhne.getVorname());
        if(!tree.getRightTree().isEmpty()){
            besucheInorder(tree.getRightTree());
        }
     }
    void besuchePostorder(BinaryTree<Ahne> tree){
        if(!tree.getLeftTree().isEmpty()){
            besuchePostorder(tree.getLeftTree());
        }
        if(!tree.getRightTree().isEmpty()){
            besuchePostorder(tree.getRightTree());
        }
        Ahne pAhne=tree.getContent();
        System.out.println(pAhne.getVorname());
    }
}