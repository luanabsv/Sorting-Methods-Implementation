public class No {

    private No proximo;
    private  No anterior;


    private int info;

    public No(No proximo, No anterior, int info) {
        this.proximo = proximo;
        this.anterior = anterior;
        this.info = info;
    }


    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }


    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
}
