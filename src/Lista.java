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
        No novo = new No(null, fim, info);

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
            System.out.print("| " + atual.getInfo() + " |");
            atual = atual.getProximo();
        }

        System.out.println("\n-------------------------------\n");
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

            while(pos != inicio && pos.getAnterior().getInfo() > aux) {
                pos.setInfo(pos.getAnterior().getInfo());
                pos = pos.getAnterior();
            }

            pos.setInfo(aux);
            atual = atual.getProximo();
        }
    }

    public void selection_sort () {
        No atual = inicio, j, menorNo;
        int aux;

        while (atual.getProximo() != null) {
            menorNo = atual;
            j = atual;

            while (j != null ) {
                if (j.getInfo() < menorNo.getInfo())
                    menorNo = j;

                j = j.getProximo();
            }

            aux = atual.getInfo();
            atual.setInfo(menorNo.getInfo());
            menorNo.setInfo(aux);

            atual = atual.getProximo();
        }
    }
    public void bubble_sort() {
        No atual, auxFim = fim;
        int aux;
        boolean troca = true;

        while (auxFim != inicio.getProximo() && troca) {
            troca = false;
            atual = inicio;

            while (atual != auxFim) {
                if (atual.getInfo() > atual.getProximo().getInfo()) {
                    troca = true;
                    aux = atual.getInfo();
                    atual.setInfo(atual.getProximo().getInfo());
                    atual.getProximo().setInfo(aux);
                }

                atual = atual.getProximo();
            }
            auxFim = auxFim.getAnterior();
        }
    }
}
