package superMercado;

public class Caja {
	
	private Boolean cerrar=false;
	private Cliente[] clientes;
	private int numClientes=0;
	
//	constructor para hacer una caja, max indica la capacidad 
//	maxima de la caja
	
	public Caja() {
		cerrar=false;
		clientes=new Cliente[10];
	}
//	setters y getters
	public Boolean getCerrar() {
		return cerrar;
	}
	public int getClientes() {
		return numClientes;
	}
	
	
//	llegada de nuevo cliente
	
	public void newCliente(Cliente b) {
		clientes[lastPosition()]=b;
	}
//	miramos cual es la ultima posicion de 
//	la cola
	
	public int lastPosition() {
		boolean a=false;
		int contador=0;
		int posicion=-1;
		
		while((!a)&&(contador<(clientes.length))) {
			if(clientes[contador]==null) {
				a=true;
				posicion=contador;
			}
			else contador++;
		}
		return posicion;
				
	}
	
//	cobramos el dinero del cliente y 
//	mandamos la cola avanzar una posicion
	
	public int siguiente() {
		int dineroCaja=0;
		
		dineroCaja=clientes[0].getDinero();
		numClientes++;
		
		avanzar();
		
		return dineroCaja;
	}
	
	private void avanzar() {
		
		for(int i=0;i<9;i++) {
			clientes[i]=clientes[i+1];
		}
	
	
}
//	abrir y cerrar caja

	public void abrirCaja() {
		cerrar=false;
	}
	public void cerrarCaja() {
		cerrar=true;
	}
	
	
	
	
	
	
	
	

}
