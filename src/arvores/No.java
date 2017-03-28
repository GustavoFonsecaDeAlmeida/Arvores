package arvores;

public class No {
    private No esq;
    private int info;
    private No dir;
    
    public No(int info) {
        esq = dir = null;
        this.info = info;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}