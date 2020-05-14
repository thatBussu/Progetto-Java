import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
        public static void main(String[] args) throws IOException {
        	System.out.println("Server avviato.");
        	System.out.println("In attesa di connessioni...");
        	ServerSocket ss = new ServerSocket(45);
        	Vector<Socket> s = new Vector<Socket>();
        	Vector<String> nome = new Vector<String>();
        	BufferedReader bl = new BufferedReader (new InputStreamReader(System.in));
        	String a;
        	int c = 0;
            do {
            		s.addElement(ss.accept());
            		BufferedReader br = new BufferedReader(new InputStreamReader(s.elementAt(c).getInputStream()));
                    nome.addElement(br.readLine());
                    System.out.println(nome.elementAt(c) + " si è connesso.");
            		System.out.print("Si vuole accettare un'altra connessione? S/N: ");
            		a = bl.readLine();
            		c++;
            		
            	} while ( a.equals("S") || a.equals("s"));
                System.out.println();
                while (true) {
                    //leggere i dati passati
                    for (int i = 0; i<s.size(); i++) {
                    	BufferedReader br = new BufferedReader(new InputStreamReader(s.elementAt(i).getInputStream()));
                    	System.out.println(nome.get(i) + ": " + br.readLine() );
                    }
                }
        }
}
                    
    
                

        
