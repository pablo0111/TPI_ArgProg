package entidad;

public class Pronostico {
    private Partido partdo;
    private ResultadoEnum resultado;


    public Pronostico(Partido partido, ResultadoEnum resultado) {
        this.partdo = partido;
        this.resultado = resultado;
    }

    public Partido getPartdo() {
        return partdo;
    }

    public void setPartdo(Partido partido) {
        this.partdo = partido;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

}

