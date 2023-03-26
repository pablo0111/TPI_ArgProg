package entidad;
public class Ronda {
    private String nro;
    private Partido[] partidos;
    private int cantidadPartidos;
    private int puntosPorAcierto;

    public Ronda(String nro, Partido[] partidos) {
        this.nro = nro;
        this.partidos = partidos;
        this.puntosPorAcierto= 1;
        this.cantidadPartidos = partidos.length;
    }


    public int puntos ( Pronostico[] pronosticos) {
        int puntaje = 0;
        for (int i = 0; i < this.cantidadPartidos; i++) {
            //Resultado pronosticado
            ResultadoEnum resultadoPronosticado = pronosticos[i].getResultado();
            //Si el resultado de dicho equipo en el partido es igual al resultado pronosticado
            if (this.partidos[i].resultado().equals(resultadoPronosticado)) {
                System.out.print("OK - ");
                puntaje += this.puntosPorAcierto;
            }
            //PARA CONTROLAR
            System.out.print(partidos[i].getMatch() + " -> ");
            System.out.println(pronosticos[i].getResultado());
        }
        return puntaje;
    }


}
