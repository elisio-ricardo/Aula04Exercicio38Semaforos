package view;

import java.util.concurrent.Semaphore;

import Controller.CorridaF1;

public class PrincipalF1 {

	public static void main(String[] args) {
		
		int permissao = 5;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int i = 1; i < 3; i ++) {
			Thread escuderia1 = new CorridaF1((1*i), semaforo);
			escuderia1.start();
			Thread escuderia2 = new CorridaF1((3*i), semaforo);
			escuderia2.start();
			Thread escuderia3 = new CorridaF1((4*i), semaforo);
			escuderia3.start();
			Thread escuderia4 = new CorridaF1((5*i), semaforo);
			escuderia4.start();
			Thread escuderia5 = new CorridaF1((6*i), semaforo);
			escuderia5.start();
			Thread escuderia6 = new CorridaF1((7*i), semaforo);
			escuderia6.start();
			Thread escuderia7 = new CorridaF1((9*i), semaforo);
			escuderia7.start();
			
		}
	}

}
