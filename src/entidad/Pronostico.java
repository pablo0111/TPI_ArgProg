package entidad;

public class Pronostico {
    private Partido partdo;
    private ResultadoEnum resultado;


    public Pronostico(Partido partdo, ResultadoEnum resultado) {
        this.partdo = partdo;
        this.resultado = resultado;
    }

    public Partido getPartdo() {
        return partdo;
    }

    public void setPartdo(Partido partdo) {
        this.partdo = partdo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

}

