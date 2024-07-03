package pablo.fernandez.dam.mp09.uf03.a01.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import pablo.fernandez.dam.mp09.uf03.a01.config.Settings;
import pablo.fernandez.dam.mp09.uf03.a01.domain.Llibre;
import pablo.fernandez.dam.mp09.uf03.a01.view.LlibreView;

public class ConnexioServer {
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	public void transmetre() throws IOException, ClassNotFoundException
	{
		serverSocket = new ServerSocket(Settings.PORT);
		
		LlibreView llibreView = new LlibreView();
		
		while(true)
		{
			System.out.println("S:Esperant connexions de clients ...");
			clientSocket = serverSocket.accept();
			System.out.println("S:Client connectat");
			
			
			//=============================
			Llibre llibreServidor = llibreView.getLlibre();
			System.out.println("S: Enviem llibre al client: " + llibreServidor.toString());
			objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			objectOutputStream.writeObject(llibreServidor);
			
			//=============================
			System.out.println("S: Esperant a que el client transmeti un arxiu ...");
			objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
			Object objecteRetornat = objectInputStream.readObject();
			Llibre llibreClient = (Llibre)objecteRetornat;
			System.out.println("S: Hem rebut del client: " + llibreClient.toString());

			
			//=============================
			objectInputStream.close();
			objectOutputStream.close();
			clientSocket.close();
			
		}
	}
}
