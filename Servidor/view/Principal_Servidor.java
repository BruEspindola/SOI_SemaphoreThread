package view;

import java.util.concurrent.Semaphore;

import controller.ServidorThread;

public class Principal_Servidor {
	public static void main(String[] args) {
		int permissao = 1;
		Semaphore Requisicao = new Semaphore(permissao);

		for (int id = 1 ; id <= 21; id++) {
			Thread Servidor = new ServidorThread (id, Requisicao);
			Servidor.start();
		}
	}       

}
