package entidad;

public class Partido {
    private Equipo eqLocal;
    private Equipo eqVisitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(Equipo eqLocal, Equipo eqVisitante, int golesLocal, int golesVisitante) {
        this.eqLocal = eqLocal;
        this.eqVisitante = eqVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }



    public ResultadoEnum resultado(){
        if(golesLocal > golesVisitante){
            return ResultadoEnum.LOCAL;
        }
        else if(golesLocal < golesVisitante){
            return ResultadoEnum.VISITANTE;
        }
        else{
            return ResultadoEnum.EMPATE;
        }

    }
public String getMatch(){
        return eqLocal.getNombre() + " " + golesLocal + " - vs - " + golesVisitante + " " + eqVisitante.getNombre();
}


}

