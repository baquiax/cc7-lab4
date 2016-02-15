import edu.galileo.baquiax.QuickSort.ParallelizedQuickSort;
import java.util.Random;

public class App {    
    public static void main(String args[]) {
        if (args.length == 2) {
			Random r = new Random();
			String firstFlag = args[0];
			String secondFlag = args[1];
			int cartas = 0;
			PockerCard[] baraja;
			try {
				cartas = Integer.parseInt(secondFlag);
				if (cartas < 15 || cartas > 25) {				
					System.out.println("El rango de cartas es 15 a 25");		
				}
			} catch(Exception e) {
				System.out.println("Debe ingresar un numero!");
			}
			baraja = new PockerCard[cartas];
			if (firstFlag.trim().toLowerCase().equals("-quick")) {
				for (int i = 0; i < cartas; i++) {					
					baraja[i] = new PockerCard((byte)(r.nextInt(4) + 1 ),(byte)(r.nextInt(13) + 1));
				}
				quicksort(baraja,true);
			} else if (firstFlag.trim().toLowerCase().equals("-merge")) {

			} else {
				System.out.println("Algoritmo invalido");
			}
		} else {
			System.out.println("Parametros invalidos");
		}
    }
}