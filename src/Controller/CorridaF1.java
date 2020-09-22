package Controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class CorridaF1 extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private static int pos = 0;
	private static String[] tempoVolta = new String[14];

	public CorridaF1(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			corrida();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			if (pos == 14) {
				ranking();
			}
		}
	}

	private void corrida() {
		double tempoT;
		double maior = 3;
		for (int i = 0; i < 3; i++) {
			double tempo = ((Math.random() * 1) + 2);
			try {
				sleep((long) tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tempoT = tempo;
			System.out.println("Volta " + (i + 1) + " do carro " + idCarro + " tempo " + tempoT);
			if (maior > tempoT) {
				maior = tempoT;
			}
		}
		tempoVolta[pos] = ("Com o tempo de " + maior + " o Carro " + idCarro);
		pos++;
	}

	private void ranking() {
		System.out.println("==================================");
		System.out.println("A Corrida vai começar e o Grid ficou  assim !!!!");
		System.out.println("==================================");
		Arrays.sort(tempoVolta);
		for (int i = 0; i < pos; i++) {
			System.out.println("Na " + (i + 1) + "° Posição ");
			System.out.println(tempoVolta[i]);
		}
	}
}
