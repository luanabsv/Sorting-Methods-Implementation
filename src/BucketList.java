public class BucketList {
    private Bucket inicio;
    private Bucket fim;

    public BucketList() {
    }

    public Bucket getInicio() {
        return inicio;
    }

    public void setInicio(Bucket inicio) {
        this.inicio = inicio;
    }

    public Bucket getFim() {
        return fim;
    }

    public void setFim(Bucket fim) {
        this.fim = fim;
    }

    public void inserirFinal(int codigo) {
        Bucket novo = new Bucket(null, fim, null, codigo);
        if (inicio == null)
            inicio = fim = novo;
        else {
            fim.setProximo(novo);
            fim = novo;
        }
    }

    public Bucket buscaExaustiva(int info) {
        Bucket atual = inicio;

        while (atual != null && atual.getInfo() != info)
            atual = atual.getProximo();

        return atual;
    }
}
