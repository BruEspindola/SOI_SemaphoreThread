package view;

import java.util.concurrent.Semaphore;

import controller.CozinhaThread;

public class Principal_Cozinha {

	public static void main(String[] args) {
		int permissaoPrato = 1;
		Semaphore Prato = new Semaphore(permissaoPrato);

		for (int idPrato = 0; idPrato < 5; idPrato++) {
			Thread cozinha = new CozinhaThread(Prato, idPrato);
			cozinha.start();
		}
	}

}
