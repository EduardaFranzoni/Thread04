package controller;

import java.util.Random;

public class ThreadSapo extends Thread{
	private int id;
	private int pista;
	private int distancia;
	private static int finalizados = 0;
	private static String podio = "";
	
	public ThreadSapo(int id) {
		this.id = id;
		this.distancia = 0;
		this.pista = 50;
	}
	
	@Override
	public void run() {
		while(!acabou() && !acabouf()) {
			pula();
		}
		pos();
		if(acabout()) {
			System.out.println(podio);
		}
	}
	
	private void pula() {
		Random random = new Random();
		int pulo = random.nextInt(10);
		this.distancia += pulo;
		System.out.println("O sapo " + this.id + " pulou por " + pulo + 
				"m e chegou a marca de " + this.distancia + "m");
	}
	
	private boolean acabou() {
		return distancia >= pista;
	}
	
	private boolean acabouf() {
		return finalizados >= 4;
	}
	
	private boolean acabout() {
		return finalizados >= 5;
	}
	
	private void pos() {
		finalizados++;
		podio += "O sapo " + this.id + " ficou em " + finalizados + "º lugar\n";
	}
}
