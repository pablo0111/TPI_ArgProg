
import entidad.Partido;
import entidad.Pronostico;
import entidad.ResultadoEnum;
import servicios.FileServicios;

public class Main {


    public static void main(String[] args) {
        FileServicios fileServicios = new FileServicios();
        Partido[] partidos = fileServicios.leePartidos();
        Pronostico[] pronosticos = fileServicios.leePronosticos(partidos);
        int puntaje = puntos(partidos,pronosticos);


        System.out.println("Puntaje obtenido: " + puntaje);
    }

    public static int puntos(Partido[] partidos , Pronostico[] pronosticos){
        final int PUNTO = 1; //Puntaje por acierto

        int puntaje = 0;
        for(int i=0;i<partidos.length;i++){
            //Resultado pronosticado
            ResultadoEnum resultadoPronosticado = pronosticos[i].getResultado();
            //Si el resultado de dicho equipo en el partido es igual al resultado pronosticado
            if (partidos[i].resultado().equals(resultadoPronosticado)){
                System.out.print("OK ");
                puntaje += PUNTO;
            }

            //PARA CONTROLAR
            System.out.print(partidos[i].getMatch() + " -> ");
            System.out.println(pronosticos[i].getResultado());


        }
        return puntaje;
    }
}