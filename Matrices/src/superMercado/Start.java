package superMercado;

public class Start {

	public static void main(String[] args) {
		
		Super s1=new Super();
		s1.nuevoCliente(new Cliente(100));
		s1.nuevoCliente(new Cliente(100));
		s1.nuevoCliente(new Cliente(300));
		s1.cobrar(1);
		s1.cobrar(0);
		s1.cobrar(0);
		s1.nuevoCliente(new Cliente(150));
		s1.nuevoCliente(new Cliente(150));
		s1.cerrarCaja(1);
		s1.nuevoCliente(new Cliente(300));
		s1.nuevoCliente(new Cliente(300));
		s1.cobrar(1);
		s1.cobrar(0);
		s1.cobrar(0);
		s1.cobrar(0);
		s1.cerrarSuper();
		
		s1.imprimir();

	}

}
