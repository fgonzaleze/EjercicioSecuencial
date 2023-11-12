package lecturaSecuencial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ejercicio {

	public static void main(String[] args) {
		
		try {
            // archivo que leemos
            String inputFile = "palabras.txt";

            // archivo donde guardaremos las palabras
            String outputFile = "palabras-Secuencial.txt";

            //BufferedReader para leer el archivo de entrada
            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            // BufferedWriter para escribir en el archivo de salida
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            // Llemos la linea del archivo
            String linea = br.readLine();

            // Para cada linea
            while (linea != null) {
                String[] palabras = linea.split("\\s+");

                // Procesar cada palabra
                for (String palabra : palabras) {
                    // Dividimos en segmentos de 5 letras ya que cada palabra tiene 5
                    for (int i = 0; i < palabra.length(); i += 5) {
                        int acaba = Math.min(i + 5, palabra.length());
                        String trozo = palabra.substring(i, acaba);
                        bw.write(trozo);
                        bw.newLine(); // Para la sigueinte palabnra
                    }
                }

                linea = br.readLine();
            }

            // Cerramos
            br.close();
            bw.close();
            
            // Cuando completemos y cerremos
            System.out.println("Completado");

        } catch (IOException e) { // para pillar las excepciones
            e.printStackTrace();
        }
	}

}
