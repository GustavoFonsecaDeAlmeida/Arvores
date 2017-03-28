package arvores;

public class Arvores {
    public static void main(String[] args) {
        BinariaBusca bb = new BinariaBusca();
        
        bb.inserir(bb.getRaiz(), new No(50));
        bb.inserir(bb.getRaiz(), new No(15));
        bb.inserir(bb.getRaiz(), new No(25));
        bb.inserir(bb.getRaiz(), new No(5));
        bb.inserir(bb.getRaiz(), new No(35));
        bb.inserir(bb.getRaiz(), new No(30));
        bb.inserir(bb.getRaiz(), new No(45));
        bb.inserir(bb.getRaiz(), new No(90));
        bb.inserir(bb.getRaiz(), new No(70));
        bb.inserir(bb.getRaiz(), new No(100));
        bb.inserir(bb.getRaiz(), new No(150));
        
        bb.preOrdem(bb.getRaiz());
        System.out.println();
        bb.emOrdem(bb.getRaiz());
        System.out.println();
        bb.posOrdem(bb.getRaiz());
        System.out.println();

        No ret = bb.pesquisar(bb.getRaiz(), 35);
        if (ret != null) 
            System.out.println("Achou elemento " + ret.getInfo());
        else
            System.out.println("Não achou elemento");
        
        System.out.println("Altura: " + (bb.altura(bb.getRaiz())-1));

        bb.emOrdem(bb.getRaiz());
        System.out.println();        
        bb.excluir(bb.getRaiz(), 45);
        bb.emOrdem(bb.getRaiz());
        System.out.println();
    }
}
