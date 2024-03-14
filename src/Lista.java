public class Lista {
    private No inicio;
    private  No fim;

    public Lista(No inicio, No fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public void inserirFinal(int info) {
        No novo = new No(fim, null, info);

        if (fim == null)
            inicio = fim = novo;
        else {
            fim.setProximo(novo);
            fim = novo;
        }
    }

    public void exibir() {
        No atual = inicio;

        while (atual != null) {
            System.out.println("| " + atual.getInfo() + " |");
            atual = atual.getProximo();
        }
    }

    public No buscaExaustiva(int info) {
        No atual = inicio;

        while (atual != null && atual.getInfo() != info) {
            atual = atual.getProximo();
        }

        return atual;
    }
    public void remover(int info) {
        No remover = buscaExaustiva(info);

        if (remover != null) {
            if (inicio == fim)
                inicio = fim = null;
            else if(inicio == remover) {
                inicio = inicio.getProximo();
                inicio.setAnterior(null);
            }
            else if(fim == remover) {
                fim = fim.getAnterior();
                fim.setAnterior(null);
            }
            else {
                No anterior = remover.getAnterior(), proximo = remover.getProximo();

                anterior.setProximo(proximo);
                proximo.setAnterior(anterior);
            }
        }
    }

    public void insertion_sort() {
        int aux;
        No atual = inicio.getProximo(), pos;

        while(atual != null) {
            pos = atual;
            aux = atual.getInfo();

            while(pos != inicio && atual.getAnterior().getInfo() > aux) {
                atual.setInfo(atual.getAnterior().getInfo());
                pos = pos.getAnterior();
            }

            pos.setInfo(aux);
            atual = atual.getProximo();
        }
    }
}
