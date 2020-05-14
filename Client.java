import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Client {
    public static void main (String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //creare la connessione col server
        try {
            Socket s = new Socket("localhost", 45);
            String nome;
            System.out.print("Inserisci il tuo nickname: ");
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println(br.readLine());
            //invio il dato
            while(true) {
            out.println(br.readLine());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}