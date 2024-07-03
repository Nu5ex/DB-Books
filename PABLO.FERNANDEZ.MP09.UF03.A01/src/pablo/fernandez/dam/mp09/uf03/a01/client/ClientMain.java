package pablo.fernandez.dam.mp09.uf03.a01.client;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientMain {
	public static void main(String[] args) {
		try {
			new ConnexioClient().transmetre();
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
}
