package edu.galileo.baquiax.QuickSort;
import java.util.Random;
        
public class ParallelizedQuickSort {
	private static int partitionAsc(int[] a, int p, int r) {		
		int x = a[r];
		int i = (p - 1);
		for (int j = p; j  <= (r - 1); j++) {
			if (a[j].lessThan(x) || a[j].equals(x)) {
				i++;
				int aux = a[i];
				a[j] = aux;
				a[i] = a[j];
			}
		}	
		return i + 1;
	}
		
	private static void quicksort(int[] a, int p, int r) {		
		int middle = partitionAsc(a,p,r);
		quicksortAsc(a,p,middle - 1);
		quicksortAsc(a, middle + 1,r);
	}
	
	private static void quicksort(int[] a) {		
        quicksortAsc(a,0,a.length - 1);		
	}

	public static void main(String[] args) throws Exception {		
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