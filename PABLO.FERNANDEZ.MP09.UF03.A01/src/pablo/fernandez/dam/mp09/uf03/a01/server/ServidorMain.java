package pablo.fernandez.dam.mp09.uf03.a01.server;

import java.io.IOException;

public class ServidorMain {
	public static void main(String[] args) {
		try {
			new ConnexioServer().transmetre();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}
}
