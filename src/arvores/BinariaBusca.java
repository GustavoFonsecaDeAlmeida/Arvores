package arvores;

public class BinariaBusca {
    private No raiz;
    
    public BinariaBusca() {
        raiz = null;
    }
    
    public void setRaiz(No no) {
        raiz = no;
    }
    
    public No getRaiz() {
        return raiz;
    }
    
    public boolean vazia(No no) {
        return (no == null);
    }
    
    public void inserir(No arv, No no) {
        
        if (vazia(raiz)) {
            raiz = no;
            return;
        }
        if (no.getInfo() < arv.getInfo()) {
            if (arv.getEsq() == null)
                arv.setEsq(no);
            else
                inserir(arv.getEsq(), no);
        }
        else if (no.getInfo() > arv.getInfo()) {
            if (arv.getDir() == null)
                arv.setDir(no);
            else
                inserir(arv.getDir(), no);
        }
    }
    
    public No excluir(No no, int toDelete) {
        
        if (no == null) 
            throw new RuntimeException("Não foi possível excluir");
        else if (toDelete < no.getInfo()) {
            // Caminha para a esquerda
            no.setEsq(excluir(no.getEsq(), toDelete));
        }
        else if (toDelete > no.getInfo()) {
            // Caminha para a direita
            no.setDir(excluir(no.getDir(), toDelete));
        }
        else { // Achou
            if (no.getDir() == null) 
                // No possui um filho a esquerda
                no = no.getEsq();
            else {
                // No possui um filho a direita
                int min = minimo(no.getDir());
                System.out.println("Minimo " + min);
                no.setInfo(min);
                no.setDir(excluir(no.getDir(), min));
            }
        }   
        return no;
   }
    
    private int minimo(No no) {
      
        while (no.getEsq() != null) 
            no = no.getEsq();
        return no.getInfo();
   }
   
    public void emOrdem(No no) {
       
        if (vazia(no) == false) {
            emOrdem(no.getEsq());
            System.out.print(no.getInfo() + " ");
            emOrdem(no.getDir());
        }
    }

    public void preOrdem(No no) {
       
        if (vazia(no) == false) {
            System.out.print(no.getInfo() + " ");
            preOrdem(no.getEsq());
            preOrdem(no.getDir());
        }
    }
    
    public void posOrdem(No no) {
       
        if (vazia(no) == false) {
            posOrdem(no.getEsq());
            posOrdem(no.getDir());
            System.out.print(no.getInfo() + " ");
        }
    }
    
    public No pesquisar(No arv, int elem) {
        No no = null;
        boolean achou = false;
        
        while ((achou == false) && (vazia(arv) == false)) {
            if (elem == arv.getInfo()) {
                no = arv;
                achou = true;
            }    
            else if (elem < arv.getInfo())
                arv = arv.getEsq();
            else if (elem > arv.getInfo())
                arv = arv.getDir();
        }    
        return no;
    }
    
    public int altura(No arv) {
        int altesq, altdir;

        if (arv == null)
            return 0;
        altesq = altura(arv.getEsq());
        altdir = altura(arv.getDir());
        if (altesq > altdir)
            return (altesq+1);
        else
            return (altdir+1);
    }
}