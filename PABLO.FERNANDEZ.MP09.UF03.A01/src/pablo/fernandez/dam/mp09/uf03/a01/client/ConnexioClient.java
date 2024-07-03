package pablo.fernandez.dam.mp09.uf03.a01.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import pablo.fernandez.dam.mp09.uf03.a01.config.Settings;
import pablo.fernandez.dam.mp09.uf03.a01.domain.Llibre;
import pablo.fernandez.dam.mp09.uf03.a01.view.LlibreView;

public class ConnexioClient {
	private Socket clientSocket;

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;

	public void transmetre() throws UnknownHostException, IOException, ClassNotFoundException {
		clientSocket = new Socket(Settings.IP, Settings.PORT);


		// =============================
		System.out.println("C:Esperant la transmissió del servidor ...");
		objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
		Llibre llibreRebudaServidor = (Llibre) objectInputStream.readObject();
		System.out.println("C: Hem rebut del servidor: " + llibreRebudaServidor.toString());

		// =============================
		System.out.println("C: Demanem a l'usuari les dades de la llibre a transmetre");
		LlibreView llibreView = new LlibreView();
		Llibre llibreClient = llibreView.getLlibre();
		System.out.println("C: Transmeterem aquesta llibre: " + llibreClient.toString());
		objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
		objectOutputStream.writeObject(llibreClient);

		// =============================
		objectInputStream.close();
		objectOutputStream.close();
		clientSocket.close();

	}
}
