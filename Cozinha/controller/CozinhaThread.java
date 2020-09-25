package controller;

import java.util.concurrent.Semaphore;

public class CozinhaThread extends Thread {
	private int idPrato;
	private Semaphore Prato;
	private int tempoTotal;
	private String NomePrato;
	private int porcentagem;

	public CozinhaThread(Semaphore prato, int idPrato) {
		this.idPrato = idPrato;
		this.Prato = prato;
	}

	@Override
	public void run() {
		prepararPrato();

		try {
			Prato.acquire();
			entregarPrato();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Prato.release();
		}

	}

	private void prepararPrato() {
		if (idPrato % 2 == 0) {
			NomePrato = "Lasanha à Bolonhesa";
			tempoTotal = (int) ((Math.random() * 600) + 600);
			System.out.println("O prato #" + idPrato + " está sendo preparado | Prato: " + NomePrato);

			for (int tempoCozimento = 0; tempoCozimento < tempoTotal; tempoCozimento += 100) {
				try {
					sleep(100);
					porcentagem = ((tempoCozimento * 100) / tempoTotal);
					System.out
							.println("O prato #" + idPrato + " " + NomePrato + " quase pronto..." + porcentagem + "%");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			NomePrato = "Sopa de Cebola";
			tempoTotal = (int) ((Math.random() * 300) + 500);
			System.out.println("O prato #" + idPrato + " está sendo preparado | Prato: " + NomePrato);

			for (int tempoCozimento = 0; tempoCozimento < tempoTotal; tempoCozimento += 100) {
				try {
					sleep(100);
					porcentagem = ((tempoCozimento * 100) / tempoTotal);
					System.out
							.println("O prato #" + idPrato + " " + NomePrato + " quase pronto..." + porcentagem + "%");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("O prato #" + idPrato + " " + NomePrato + " está pronto. ");

	}

	private void entregarPrato() {
		try {
			System.out.println("O prato #" + idPrato + " está sendo entregue...");
			sleep(500);
			System.out.println("Prato entregue #" + idPrato);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
