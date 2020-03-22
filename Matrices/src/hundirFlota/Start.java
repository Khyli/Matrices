package hundirFlota;

public class Start {

	public static void main(String[] args) {
		
		

		Hundir h1=new Hundir();
		h1.portaviones(0, 0, 0, 1, 0, 2, 0, 3);
		h1.acorazado(7, 9, 8, 9, 9, 9);
		h1.submarino(5, 4, 5, 5, 5, 6);
		h1.destructor1(2, 2, 2, 3);
		h1.destructor2(8, 0, 9, 0);
		h1.lancha1(1, 6);
		h1.lancha2(0, 9);
		h1.imprimir();
		h1.jugar();
		h1.imprimir();
		
		
		
	}

}
