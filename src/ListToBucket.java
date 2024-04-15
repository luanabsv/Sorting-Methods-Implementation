public class ListToBucket {
    private NoBuket inicio;
    private NoBuket fim;
    private int comparacoes;

    public ListToBucket() {
        comparacoes = 0;
    }

    public int getComparacoes() {
        return this.comparacoes;
    }

    public NoBuket getInicio() {
        return this.inicio;
    }

    public void exibir() {
        NoBuket atual = inicio;

        while (atual != null) {
            System.out.print("| " + atual.getRegistro().getNumero() + " |");
            atual = atual.getProximo();
        }

        System.out.println("\n-------------------------------\n");
    }

    public void inserirFinal(Registro registro) {
        NoBuket novo = new NoBuket(null, fim, registro);
        if (inicio == null)
            inicio = fim = novo;
        else {
            fim.setProximo(novo);
            fim = novo;
        }
    }

    public void insertion_sort() {
        Registro registro;
        NoBuket atual = inicio.getProximo(), pos;

        while (atual != null) {
            pos = atual;
            registro = atual.getRegistro();
            comparacoes++;

            while (pos != inicio && pos.getAnterior().getRegistro().getNumero() > registro.getNumero()) {
                pos.setRegistro(pos.getAnterior().getRegistro());
                pos = pos.getAnterior();
            }

            pos.setRegistro(registro);
            atual = atual.getProximo();
        }
    }
}
