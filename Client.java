import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * La classe Client avvia un Client con un nickname scelto dall'utente in grado di mandare messaggi ad un server.
 * @author Banni Daniele, Bussu Manuel, Diaferia Emanuele, Nappa Camilla
 * @version 1.1
 */
public class Client {
    public static void main (String[] args) {
    	//creazione di un oggetto BufferedReader in grado di prendere l'input da tastiera
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //creazione di una connessione tra client e server
        try {
        	//creazione di un oggetto Socket attraverso il costruttore che richiede una stringa ed una porta
            Socket s = new Socket("localhost", 45);
            //richiesta di input del nickname
            System.out.print("Inserisci il tuo nickname: ");
            //creazione di un oggetto PrintWriter in grado di gestire il flusso di informazioni da comunicare al Server
            PrintWriter out = new PrintWriter(s.getOutputStream(), true); 
            //inserimento e invio del nickname al Server
            out.println(br.readLine());
            
            //ciclo infinito per continuare a mandare messaggi al server
            while(true) {
            out.println(br.readLine());

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}