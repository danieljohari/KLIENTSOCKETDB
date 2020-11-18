import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class KlientProjekt {
    public static void main(String[] args) throws Exception {
        String sentence; // Indtastede sætning
        String modifiedSentence; //Modtagene sætning med ændringer

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); //Læser fra indastning

        Socket clientSocket = new Socket("10.16.228.119", 33333); // IP adresse og portnummer (skal være ens på maskiner) //KP IP = 10.2.96.250
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); //Hvad der kommer ud til serveren fra klienten

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //

        sentence = inFromUser.readLine(); //sætningen får en værdi her

        outToServer.writeBytes(sentence + '\n'); //Skriver linjen og /n betyder den laver en ny linje.

        modifiedSentence = inFromServer.readLine(); //Modificeret sætning

        System.out.println("ORIGINAL: " + sentence);
        System.out.println("FROM SERVER: " + modifiedSentence);


        //clientSocket.close();
    }
}
