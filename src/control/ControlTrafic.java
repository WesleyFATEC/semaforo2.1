package control;
import br.com.wesley.fatec.Lista.*;
import model.Carro;
import java.util.concurrent.Semaphore;

public class ControlTrafic {
	private final Semaphore semaphore;
	private final Lista <Carro> carros;
	
			 
			 
	public ControlTrafic (long idCar, String sentido) {
		this.carros = new Lista<>();
		this.semaphore = new Semaphore(1);
		 
	 }
	
	public void Cruzamento (long idCar, String sentido) {
		do {
			try {
				semaphore.acquire();
				
				System.out.println("O carro "+ idCar + " cruzou no sentido "+ sentido);
				carros.removeLast();
			}
			catch (Exception e) {
				e.getMessage();
			}
			finally{
				semaphore.release();
			}
			
			}
		while(!carros.isEmpty());
		}
		
		
	}

