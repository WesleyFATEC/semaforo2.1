package view;
import control.ControlTrafic;
import model.Carro;
import java.util.Random;
import br.com.wesley.fatec.Lista.*;

public class Principal {

	
	public static void main(String[] args) {
		ControlTrafic controlTrafic = new ControlTrafic (0, null);
		Random rd = new Random ();
		int quantCar = rd.nextInt(23)+4;
		Lista < Carro > carList= new Lista <>();
		
		for (int i = 0; i <quantCar; i ++){
			try {
				Carro car = new Carro(controlTrafic);
				carList.addFirst(car);
				car.start();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		
	}

}
