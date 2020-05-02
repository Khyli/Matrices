package superMercado;

public class Super {
	
	private Caja[] cajas;
	private int beneficios=0;
	private Boolean estado=true;
	
//	constructor del super y las cajas
	
	public Super() {
		beneficios=0;
		cajas=new Caja[2];
		crearCajas();
	}
	
private void crearCajas() {
		Caja caja0=new Caja();
		Caja caja1=new Caja();
		
		cajas[0]=caja0;
		cajas[1]=caja1;
	
}

//	entra nuevo cliente y se posiciona con el metodo
//	posicionar();

	public void nuevoCliente(Cliente b) {
		if(!cajas[0].getCerrar() || !cajas[1].getCerrar()) {
			posicionar(b);
		}
		else System.out.println("LAS CAJAS ESTAN CERRADAS");
	}

	private void posicionar(Cliente b) {
		
		if(cajas[1].getCerrar()) {
			cajas[0].newCliente(b);
		}
		if(cajas[0].getCerrar()) {
			cajas[1].newCliente(b);
		}
		else if(!cajas[1].getCerrar()&&cajas[0].lastPosition()<=cajas[1].lastPosition()) {
			cajas[0].newCliente(b);
		}
		else if(!cajas[1].getCerrar()&&cajas[1].lastPosition()<cajas[0].lastPosition()) {
			cajas[1].newCliente(b);
		}
		
	}
	
//	metodo para cobrar el dinero
	
	public void cobrar(int a) {
		int dinero;
		
		dinero=cajas[a].siguiente();
		
		beneficios+=dinero;
			
	}
	
//	metodo para imprimir 
	
	public void imprimir() {
		if(estado) {
			System.out.println("EL SUPERMERCADO ESTA ABIERTO");
			if(!cajas[0].getCerrar()) {
				System.out.println("LA CAJA 0 SE ENCUENTRA ABIERTA");
			}
			else if(cajas[0].getCerrar()) {
				System.out.println("LA CAJA 0 SE ENCUENTRA CERRADA");
			}
			if(!cajas[1].getCerrar()) {
				System.out.println("LA CAJA 1 SE ENCUENTRA ABIERTA");
			}
			else if(cajas[1].getCerrar()) {
				System.out.println("LA CAJA 1 SE ENCUENTRA CERRADA");
			}
		}
		else {
		System.out.println("EL SUPERMERCADO HA CERRADO");
		System.out.println("EL TOTAL DE CLIENTES HA SIDO "+
		(cajas[1].getClientes()+cajas[0].getClientes()));
		
		System.out.println("SE HA HECHO UN TOTAL DE "+
		beneficios+"€");
		}
		
	}
	
//	abrir supermercado y cerrarlo
	
	public void abrirSuper() {
		estado=true;
	}
	public void cerrarSuper() {
		estado=false;
	}
	
//	abrir cajas y cerrarlas
	
	public void abrirCaja(int b) {
		cajas[b].cerrarCaja();
	}
	public void cerrarCaja(int b) {
		cajas[b].cerrarCaja();
	}
	


	
	
}
