public class Lista {
    private No inicio;
    private  No fim;

    private int tl = 0;

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

    public int getTl() {
        return tl;
    }

    public void setTl(int tl) {
        this.tl = tl;
    }

    public void inserirFinal(int info) {
        No novo = new No(null, fim, info);

        if (fim == null)
            inicio = fim = novo;
        else {
            fim.setProximo(novo);
            fim = novo;
        }
        tl++;
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

    public int returnPos(No noBusca) {
        int i = 0;
        No aux = inicio;

        while (aux != null && noBusca != aux) {
            aux = aux.getProximo();
            i++;
        }

        return i;
    }

    public No returnNo(int pos) {
        No atual = inicio;
        int i = 0;

        while(atual != null && i < pos) {
            i++;
            atual = atual.getProximo();
        }

        return atual;
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

    public void shake_sort() {
        No auxInicio = inicio, auxFim = fim, auxIn;
        int aux;
        boolean troca = true;

        while(auxInicio != auxFim && troca) {
            troca = false;

            auxIn = auxInicio;
            while(auxIn != auxFim) {
                if (auxIn.getInfo() > auxIn.getProximo().getInfo()) {
                    troca = true;
                    aux = auxIn.getInfo();
                    auxIn.setInfo(auxIn.getProximo().getInfo());
                    auxIn.getProximo().setInfo(aux);
                }

                auxIn = auxIn.getProximo();
            }

            auxFim = auxFim.getAnterior();

            if (troca) {
                troca = false;

                auxIn = auxFim;
                while(auxIn != auxInicio) {
                    if (auxIn.getInfo() < auxIn.getAnterior().getInfo()) {
                        troca = true;
                        aux = auxIn.getInfo();
                        auxIn.setInfo(auxIn.getAnterior().getInfo());
                        auxIn.getAnterior().setInfo(aux);
                    }

                    auxIn = auxIn.getAnterior();
                }
                auxInicio = auxIn.getProximo();
            }
        }
    }

    public void shell_sort() {
        int dist = 1, aux, i, j;

        while (dist < tl)
            dist = dist * 3 + 1;
        dist = dist / 3;

        while (dist > 0) {
            No atual;
            for (i = dist; i < tl; i++) {
                atual = returnNo(i);
                aux = atual.getInfo();
                j = i;

                No noJ = returnNo(j);
                No noJDist = returnNo(j - dist);

                while (j - dist >= 0 && aux < returnNo(j-dist).getInfo()) {
                    noJ.setInfo(noJDist.getInfo());
                    j = j - dist;

                    noJ = returnNo(j);
                    noJDist = returnNo(j - dist);
                }

                returnNo(j).setInfo(aux);
            }
            dist = dist / 3;
        }
    }

    public void heap_soart() {
        No auxFim, fe, fd, maiorF, pai;
        int posPai, posFe, aux, tl2 = tl;

        while(tl2 > 1) {
            posPai = tl2 / 2 - 1;

            while (posPai >= 0) {
                pai = returnNo(posPai);

                posFe = 2 * posPai + 1;
                fe = returnNo(posFe);
                fd = returnNo(posFe + 1);

                maiorF = fe;
                if (posFe + 1 < tl2 &&  fd.getInfo() > fe.getInfo()) {
                    maiorF = fd;
                }

                if (maiorF.getInfo() > pai.getInfo()) {
                    aux = pai.getInfo();
                    pai.setInfo(maiorF.getInfo());
                    maiorF.setInfo(aux);
                }

                posPai--;
            }

            aux = inicio.getInfo();
            auxFim = returnNo(tl2 - 1);
            inicio.setInfo(auxFim.getInfo());
            auxFim.setInfo(aux);
            tl2--;
        }

    }

    public void quickcpivo(){
        quickcp(0, tl-1);
    }

    private void quickcp(int ini, int auxFim) {
        int i = ini, j = auxFim, aux;

        No pivo = returnNo((ini + auxFim) / 2);
        No noI = returnNo(i);
        No noJ = returnNo(j);

        while(i < j) {
            while (noI.getInfo() < pivo.getInfo()) {
                i++;
                noI = noI.getProximo();
            }

            while(noJ.getInfo() > pivo.getInfo()) {
                j--;
                noJ = noJ.getAnterior();
            }

            if (i <= j) {
                aux = noI.getInfo();
                noI.setInfo(noJ.getInfo());
                noJ.setInfo(aux);
                i++;
                j--;
                noI = noI.getProximo();
                noJ = noJ.getAnterior();
            }
        }

        if (ini < j)
            quickcp(ini, j);
        if (i < auxFim)
            quickcp(i, auxFim);
    }

    public void quickspivo() {
        quicksp(0, tl-1);
    }

    private void quicksp(int ini, int auxFim) {
        No noIni, noFim;
        int aux, i = ini, j = auxFim;
        boolean flag = true;

        noIni = returnNo(i);
        noFim = returnNo(j);
        while (i < j) {

            if (flag) {
                while (i < j && noIni.getInfo() <= noFim.getInfo()) {
                    i++;
                    noIni = noIni.getProximo();

                }
            } else {
                while (j > i && noIni.getInfo() <= noFim.getInfo()) {
                    j--;
                    noFim = noFim.getAnterior();
                }
            }

            aux = noIni.getInfo();
            noIni.setInfo(noFim.getInfo());
            noFim.setInfo(aux);
            flag = !flag;
        }

        if (ini < i - 1)
            quicksp(ini, i - 1);
        if (j + 1 < auxFim)
            quicksp(j + 1, auxFim);
    }

    public void comb_sort() {
        int intervalo = tl, aux;

        while (intervalo > 0) {
            intervalo = (int) (intervalo / 1.3);
            int i = 0;

            while (i + intervalo < tl) {
                if (returnNo(i).getInfo() > returnNo(i + intervalo).getInfo()) {
                    aux = returnNo(i).getInfo();
                    returnNo(i).setInfo(returnNo(i + intervalo).getInfo());
                    returnNo(i + intervalo).setInfo(aux);
                }

                i++;
            }
        }

    }

    public void gnome_sort() {
        No atual = inicio.getProximo(), anterior = inicio, auxAtual;
        int aux;

        while (atual != null) {
            if (anterior.getInfo() > atual.getInfo()) {
                auxAtual =  atual;

                while(anterior != null && anterior.getInfo() > atual.getInfo()) {
                    aux = atual.getInfo();
                    atual.setInfo(anterior.getInfo());
                    anterior.setInfo(aux);

                    anterior = anterior.getAnterior();
                    atual = atual.getAnterior();
                }

                atual = auxAtual;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }
}
