package view;

import java.util.concurrent.Semaphore;

import Controller.CorridaF1;

public class PrincipalF1 {

	public static void main(String[] args) {
		
		int permissao = 5;
		Semaphore semaforo = new Semaphore(permissao);
		int permissao2 = 1;
		Semaphore semaforo2 = new Semaphore(permissao2);
		
		for(int i = 1; i < 3; i ++) {
			Thread escuderia1 = new CorridaF1((1*i), semaforo, semaforo2);
			escuderia1.start();
			Thread escuderia2 = new CorridaF1((3*i), semaforo, semaforo2);
			escuderia2.start();
			Thread escuderia3 = new CorridaF1((4*i), semaforo, semaforo2);
			escuderia3.start();
			Thread escuderia4 = new CorridaF1((5*i), semaforo, semaforo2);
			escuderia4.start();
			Thread escuderia5 = new CorridaF1((11*i), semaforo, semaforo2);
			escuderia5.start();
			Thread escuderia6 = new CorridaF1((7*i), semaforo, semaforo2);
			escuderia6.start();
			Thread escuderia7 = new CorridaF1((9*i), semaforo, semaforo2);
			escuderia7.start();
			
		}
	}

}
