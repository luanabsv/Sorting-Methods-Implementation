public class Bucket {
    private Bucket proximo;
    private  Bucket anterior;
    private ListToBucket lista;
    private int info;


    public Bucket(Bucket proximo, Bucket anterior, ListToBucket lista, int info) {
        this.proximo = proximo;
        this.anterior = anterior;
        if(lista == null)
            this.lista = new ListToBucket();
        else
            this.lista = lista;
        this.info = info;
    }

    public Bucket(Bucket proximo, Bucket anterior, int info) {
        this.proximo = proximo;
        this.anterior = anterior;
        this.info = info;
    }

    public Bucket getProximo() {
        return proximo;
    }

    public void setProximo(Bucket proximo) {
        this.proximo = proximo;
    }

    public Bucket getAnterior() {
        return anterior;
    }

    public void setAnterior(Bucket anterior) {
        this.anterior = anterior;
    }


    public ListToBucket getLista() {
        return lista;
    }

    public void setLista(ListToBucket lista) {
        this.lista = lista;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

}
