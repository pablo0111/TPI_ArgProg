
import entidad.Partido;
import entidad.Pronostico;
import entidad.ResultadoEnum;
import entidad.Ronda;
import servicios.FileServicios;

public class Main {


    public static void main(String[] args) {
        FileServicios fileServicios = null;
        boolean ejecutar = false;
        if (args.length == 0) {
            fileServicios = new FileServicios();
            ejecutar = true;
        } else if (args.length == 2){
            fileServicios = new FileServicios(args[0], args[1]);
            ejecutar = true;
        } else {
            System.out.println("Parametros incorrectos. Ej ejecucion: java Main partidos.csv pronosticos.csv");
            System.out.println("Se reciben dos argementos, el primero para el csv con los partidos, y el segundo con el pronostico");
        }

        if (ejecutar) {
            Partido[] partidos = fileServicios.leePartidos();
            Pronostico[] pronosticos = fileServicios.leePronosticos(partidos);
            Ronda ronda = new Ronda("1",partidos);
            int puntaje = ronda.puntos(pronosticos);
            System.out.println("Puntaje obtenido: " + puntaje);
        }
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