package superMercado;

public class Cliente {

	public int dinero;
	
	
//	constructor para un cliente, dinero
//	aleatorio
	
		public Cliente(int dinero) {
			this.setDinero(dinero);
		}
		
		private void setDinero(int dinero) {
			this.dinero=dinero;
}

//	Setter y getter
		
		public int getDinero() {
			return dinero;
		}
}
