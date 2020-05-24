package Chatroom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 * La classe Server avvia un Server in grado di accettare più connessioni e di stampare i messaggi ricevuti dai diversi Client
 * @author Banni Daniele, Bussu Manuel, Diaferia Emanuele, Nappa Camilla
 * @version 1.0
 */
public class Server {
        public static void main(String[] args) throws IOException {
        	//notifica di sistema in cui si avverte dell'avvio del server
        	System.out.println("Server avviato.");
        	//notifica di sistema in cui si aspettano delle connessioni
        	System.out.println("In attesa di connessioni...");
        	//creazione di un oggetto ServerSocket attraverso il costruttore che prevede l'inserimento di una porta sulla quale comunicare
        	ServerSocket ss = new ServerSocket(45);
        	//creazione di un vettore di Socket per poter gestire più connessioni
        	Vector<Socket> s = new Vector<Socket>();
        	//creazione di un vettore di Stringhe dove poter inserire gli nickname dei diversi Client
        	Vector<String> nome = new Vector<String>();
        	//creazione di un oggetto BufferedReader in grado di prendere l'input da tastiera
        	BufferedReader bl = new BufferedReader (new InputStreamReader(System.in));
        	//dichiarazione di una Stringa da poter utilizzare in futuro
        	String a;
        	//dichiarazione e inizializzazione del contatore
        	int c = 0;
        	//ciclo che si ripete nel caso in cui si volessero accettare più connessioni, con il conseguente inserimento dei nickname
            do {
            		//inserimento di più connessioni all'interno del vettore
            		s.addElement(ss.accept());
            		//creazione di un oggetto BufferedReader in grado di prendere l'input dal flusso di dati del Socket
            		BufferedReader br = new BufferedReader(new InputStreamReader(s.elementAt(c).getInputStream()));
            		//Inserimento di un nickname all'interno del vettore di stringhe
                    nome.addElement(br.readLine());
                    //notifica di sistema in cui si avverte della connessione di un Client
                    System.out.println(nome.elementAt(c) + " si è connesso.");
                    //notifica di sistema per poter accettare più connessioni
            		System.out.print("Si vuole accettare un'altra connessione? S/N: ");
            		//inserimento della conferma
            		a = bl.readLine();
            		//incremento del contatore
            		c++;
            		
            	} while ( a.equals("S") || a.equals("s") );
            	//spazio
                System.out.println();
                //ciclo infinito in cui si stampano i messaggi ricevuti dai Client
                while (true) {
                    //ciclo che stampa a video i messaggi ricevuti dai Client
                    for (int i = 0; i<s.size(); i++) {
                    	BufferedReader br = new BufferedReader(new InputStreamReader(s.elementAt(i).getInputStream()));
                    	System.out.println(nome.get(i) + ": " + br.readLine() );
                    }
                }
        }
}
                    
    
                

        
