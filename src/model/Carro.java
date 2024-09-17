package model;

import java.util.Random;
import java.util.concurrent.Semaphore;

import br.com.wesley.fatec.Lista.*;
import control.ControlTrafic;

public class Carro extends Thread{
	private final ControlTrafic controltrafic;
	private static final Lista <String> sentidos = new Lista<>();
	private static final String [] COORDENADAS = {"Norte" , "Sul", "Leste", "Oeste" };
	private static final Semaphore semaphore = new Semaphore(1);
	private long idCar;
	private int distcruz = 0;
	
	private static void initSentidos() {
		for (String sentido : COORDENADAS) {
			try {
				if (sentidos.isEmpty())
				sentidos.addFirst(sentido);
				else {
				sentidos.addLast(sentido);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public Carro (ControlTrafic controlTrafic) {
		this.controltrafic = controlTrafic;
		
	}
	
	public void run () {
		idCar= getId();
		Random rd = new Random();
		int distPerc = rd.nextInt(1500)+100;
		do {distcruz += distPerc;
			if (distcruz > 1500) {
				System.out.println("O carro " + idCar + " chegou ao cruzamento, aguardando liberaçãp");
			}else {
			System.out.println("O carro " + idCar +  " percorreu " + distcruz +" mts");
			}
			if (distPerc > 500) {
				try {
					sleep (1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}while(distcruz <= 1500);
		try {
			semaphore.acquire();
			if (sentidos.isEmpty()) {
				initSentidos();
			}
			String sentido = sentidos.get(0);
			controltrafic.Cruzamento(idCar, sentido);
			sentidos.remove(0);
		} catch (Exception e) {
			e.getMessage();	
		} finally {
			semaphore.release();
		}
		
		
		
		
	}
}
