public class NoBuket {
    private NoBuket proximo;
    private NoBuket anterior;
    private Registro registro;

    public NoBuket(NoBuket proximo, NoBuket anterior, Registro registro) {
        this.proximo = proximo;
        this.anterior = anterior;
        this.registro = new Registro(registro.getNumero());
    }

    public NoBuket getProximo() {
        return proximo;
    }

    public void setProximo(NoBuket proximo) {
        this.proximo = proximo;
    }

    public NoBuket getAnterior() {
        return anterior;
    }

    public void setAnterior(NoBuket anterior) {
        this.anterior = anterior;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
}
