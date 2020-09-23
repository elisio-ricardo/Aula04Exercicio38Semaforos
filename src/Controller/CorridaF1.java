package Controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class CorridaF1 extends Thread {

	private int idCarro;
	private Semaphore semaforo;
	private Semaphore semaforo2;
	private static int pos = 0;
	private static String[] tempoVolta = new String[14];

	public CorridaF1(int idCarro, Semaphore semaforo,Semaphore semaforo2 ) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
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
		}
		if (pos == 14) {
			ranking();
		}
	}
//	int permissao = 1;
//	Semaphore semaforo2 = new Semaphore(permissao);
	private void corrida() {		
		double tempoT;
		double maior = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			double tempo = ((Math.random() * 5) + 2);
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
		try {
			semaforo2.acquire();
			tempoVolta[pos] = ("Com o tempo de " + maior + " o Carro " + idCarro);
			System.out.println(pos+ " " + idCarro);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo2.release();
		}		
		pos++;
	}
	
	private void ranking() {
		System.out.println("==================================");
		System.out.println("A Corrida vai começar e o Grid ficou  assim !!!!");
		System.out.println("==================================");
		Arrays.sort(tempoVolta);
		for (int i = 0; i < tempoVolta.length; i++) {
			System.out.println("Na " + (i + 1) + "° Posição ");
			System.out.println(tempoVolta[i]);
		}
	}
}
