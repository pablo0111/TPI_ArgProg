package servicios;

import entidad.Equipo;
import entidad.Partido;
import entidad.Pronostico;
import entidad.ResultadoEnum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileServicios {
    private final String appPath= System.getProperty("user.dir");
    private Path archivoPartidos = Paths.get(appPath + "\\src\\datos\\partidos.csv");
    private Path archivoPronosticos = Paths.get(appPath + "\\src\\datos\\pronosticos.csv");


    public FileServicios() {
    }

    public FileServicios(String pathPartidos, String pathPronositco) {
        this.archivoPartidos = Paths.get(pathPartidos).toAbsolutePath();
        this.archivoPronosticos = Paths.get(pathPronositco).toAbsolutePath();

    }

    public Pronostico[] leePronosticos(Partido[] arrayPartidos) {
        String[] pronostico;
        Pronostico[] listaPronostico;
        final String X = "x"; //Marca X en Local,Empate,Visitante;

        try {
            //Leo el archivo y lo cargo a un List de String
            List<String> lineasPronostico = Files.readAllLines(archivoPronosticos);
            int s = lineasPronostico.size();//tamaño de la lista
            //instancio el Array
            listaPronostico = new Pronostico[s];

            //Recorro la lista de String
            for (String linea : lineasPronostico) {
                //Cada linea la convierto en Array de String [eqLocal, X(local), X(empate), X(visitante), eqVisitante]
                pronostico = linea.split(",");

                //Leo el resultado pronosticado
                ResultadoEnum prediccion;
                if (pronostico[1].equals(X)) {
                    prediccion = ResultadoEnum.LOCAL;
                } else if (pronostico[3].equals(X)) {
                    prediccion = ResultadoEnum.VISITANTE;
                } else {
                    prediccion = ResultadoEnum.EMPATE;
                }

                //Agrego el pronostico al Array
                int i = lineasPronostico.indexOf(linea);
                listaPronostico[i] = new Pronostico(arrayPartidos[i], prediccion);
            }
            return listaPronostico;

        }
        catch (IOException e){
            return null;
        }
    }


    public Partido[] leePartidos() {
        String[] partido;
        Partido[] listaPartidos;

        try {
            //Leo el archivo y lo cargo a un List de String
            List<String> lineasPartido = Files.readAllLines(archivoPartidos);
            int s = lineasPartido.size();//tamaño de la lista
            //instancio el Array
            listaPartidos = new Partido[s];

            //Recorro la lista de String
            for (String linea : lineasPartido) {
                //Cada linea la convierto en Array de String [eqLocal, golesLocal, golesVisitante, eqVisitante]
                partido = linea.split(",");

                //Creo los equipos usando los nombres leidos
                Equipo eqLocal = new Equipo(partido[0], "");
                Equipo eqVisitante = new Equipo(partido[3], "");

                //Leo los goles y los convierto a int
                int golesLocal = Integer.parseInt(partido[1]);
                int golesVisitante = Integer.parseInt(partido[2]);

                //Agrego el partido al Array
                int i = lineasPartido.indexOf(linea);
                listaPartidos[i] = new Partido(eqLocal, eqVisitante, golesLocal, golesVisitante);
            }
            return listaPartidos;

        } catch (IOException e) {
            return null;
        }
    }

}
