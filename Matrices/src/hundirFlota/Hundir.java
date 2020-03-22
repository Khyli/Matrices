package hundirFlota;

public class Hundir {
	
	public String tablero[][];
	public int filas;
	public int columnas;
	public String portaviones="P";
	public String acorazado="A";
	public String submarino="S";
	public String destructor1="D";
	public String destructor2="E";
	public String lancha1="L";
	public String lancha2="N";
	public int contador;
	public int barcos=0;
	
	
	public Hundir() {
		filas=10;
		columnas=10;
		tablero=new String[filas][columnas];
		
		addValores();
	}
	
	private void addValores() {
		for (int i=0;i<filas;i++) {
			for(int j=0;j<columnas;j++) {
				tablero[i][j]="0";
		
			}
		
	
		}
		
	}

	public void imprimir() {
		System.out.print("  _   _                       _   _            _              __   _           _           \r\n" + 
				" | | | |  _   _   _ __     __| | (_)  _ __    | |   __ _     / _| | |   ___   | |_    __ _ \r\n" + 
				" | |_| | | | | | | '_ \\   / _` | | | | '__|   | |  / _` |   | |_  | |  / _ \\  | __|  / _` |\r\n" + 
				" |  _  | | |_| | | | | | | (_| | | | | |      | | | (_| |   |  _| | | | (_) | | |_  | (_| |\r\n" + 
				" |_| |_|  \\__,_| |_| |_|  \\__,_| |_| |_|      |_|  \\__,_|   |_|   |_|  \\___/   \\__|  \\__,_|\r\n" + 
				"                                                                                           \r\n" + 
				"");
		for (int i=0;i<filas;i++) {
			System.out.print("\n               (f"+i+")|");
			for(int j=0;j<columnas;j++) {
				if(tablero[i][j]=="0") {
					System.out.print("  •  ");
				}
				else 
				System.out.print(" ["+tablero[i][j]+"] ");
				
			}
			System.out.println();
		}
		System.out.print("               _____");
		for(int j=0;j<columnas;j++) {
			
			System.out.print("_____");
		}
		System.out.println();
		System.out.print("                   ");
		for(int j=0;j<columnas;j++) {
			
			System.out.print("  c"+j+" ");   
		}
		System.out.println("");
		System.out.println("__________________________________________________________________________________________________________");
	}
	
	public void portaviones(int f1, int c1, int f2, int c2, int f3, int c3, int f4, int c4) {
		tablero[f1][c1]=portaviones;
		tablero[f2][c2]=portaviones;
		tablero[f3][c3]=portaviones;
		tablero[f4][c4]=portaviones;
	}
	public void acorazado(int f1, int c1, int f2, int c2, int f3, int c3) {
		tablero[f1][c1]=acorazado;
		tablero[f2][c2]=acorazado;
		tablero[f3][c3]=acorazado;
	}
	public void submarino(int f1, int c1, int f2, int c2, int f3, int c3) {
		tablero[f1][c1]=submarino;
		tablero[f2][c2]=submarino;
		tablero[f3][c3]=submarino;
	}
	public void destructor1(int f1, int c1, int f2, int c2) {
		tablero[f1][c1]=destructor1;
		tablero[f2][c2]=destructor1;
	}
	public void destructor2(int f1, int c1, int f2, int c2) {
		tablero[f1][c1]=destructor2;
		tablero[f2][c2]=destructor2;
	}
	public void lancha1(int f1, int c1) {
		tablero[f1][c1]=lancha1;
	}
	public void lancha2(int f1, int c1) {
		tablero[f1][c1]=lancha2;
	}
	

	public void jugar() {
		System.out.println("¡EMPECEMOS A JUGAR!");
		int a;
		int b;
		Boolean hundir=false;
		
		while(barcos<7) {
		
		hundir=false;
		a=(int)(Math.random()*10);
		b=(int)(Math.random()*10);
//		a=5;
//		b=6;
		
			if((tablero[a][b]!="0")&&(tablero[a][b]!="X")) {
				System.out.println(a+","+b);
				tablero[a][b]="X";
				System.out.println("¡TOCADO!");
				hundir=comprobarBarca(a,b);
				
				if((b+1)<columnas) {
					if((tablero[a][b+1]=="0")&&(!hundir)) {
						System.out.println(a+","+(b+1));
						System.out.println("¡AGUA!");
					}
					if((tablero[a][b+1]!="0")&&!hundir) {
						hundir=comprobarHorizontal(a,b);
					}
				}
				if((b-1)>=0) {
					if((tablero[a][b-1]=="0")&&!hundir) {
						System.out.println(a+","+(b-1));
						System.out.println("¡AGUA!");
					}
					if((tablero[a][b-1]!="0")&&!hundir) {
						hundir=comprobarHorizontal(a,b);
					}
				}
				if((a+1)<filas) {
					if((tablero[a+1][b]=="0")&&!hundir) {
						System.out.println((a+1)+","+b);
						System.out.println("¡AGUA!");
					}
					if((tablero[a+1][b]!="0")&&!hundir) {
						hundir=comprobarVertical(a,b);
					}
				}
				if((a-1)>=0) {
					if((tablero[a-1][b]=="0")&&!hundir) {
						System.out.println((a-1)+","+b);
						System.out.println("¡AGUA!");
					}
					if((tablero[a-1][b]!="0")&&!hundir) {
						hundir=comprobarVertical(a,b);
					}
				}
				if(hundir) {
					System.out.println("¡BARCO HUNDIDO!");
					barcos++;
			}
			
			}
			else if (tablero[a][b]=="0"||tablero[a][b]=="X") {

				System.out.println(a+","+b);
				System.out.println("¡AGUA!");
			}
	}
		if(barcos==7) {
			System.out.println("¡TODOS LOS BARCOS HAN SIDO HUNDIDOS, "
					+ "HAS PERDIDO!");
		}
		
}


	private Boolean comprobarBarca(int a, int b) {
		Boolean hundir=false;
		
		if(b==0&!hundir) {
			if(a==0&!hundir) {
				if((tablero[a+1][b]=="0")&&(tablero[a][b+1]=="0")) {
					hundir=true;
				}
			}
			else if(a==9&!hundir) {
				if((tablero[a-1][b]=="0")&&(tablero[a][b+1]=="0")) {
					hundir=true;
				}
			}
			else if ((tablero[a+1][b]=="0")&&(tablero[a-1][b]=="0")
					&&(tablero[a][b+1]=="0")) {
					hundir=true;
			}
			}
		else if(b==9&&!hundir) {
			if(a==0&!hundir) {
				if((tablero[a+1][b]=="0")&&(tablero[a][b-1]=="0")) {
					hundir=true;
				}
			}
			else if(a==9&!hundir) {
				if((tablero[a-1][b]=="0")&&(tablero[a][b-1]=="0")) {
					hundir=true;
				}
			}
			else if((tablero[a+1][b]=="0")&&(tablero[a-1][b]=="0")
					&(tablero[a][b-1]=="0")&&(!hundir)) {
				hundir=true;
			}
		}
		else if(a==9&&!hundir) {
			if((tablero[a][b+1]=="0")&&(tablero[a][b-1]=="0")
					&&(tablero[a-1][b]=="0")&&(!hundir)) {
				hundir=true;
			}
		}
		else if(a==0&&!hundir) {
			if((tablero[a][b+1]=="0")&&(tablero[a][b-1]=="0")
					&&(tablero[a+1][b]=="0")&&(!hundir)) {
				hundir=true;
			}
		}
		else if ((tablero[a+1][b]=="0")&&(tablero[a-1][b]=="0")
				&&(tablero[a][b+1]=="0")&&(tablero[a][b-1]=="0")) {
				hundir=true;
		}
		return hundir;	
		}
	

	private Boolean comprobarVertical(int a, int b) {
		boolean hundir=true;
		
		if((a+1)<filas) {
			for(int c=1;tablero[a+c][b]!="0"&&((a+c)<filas);c++) {
				System.out.println((a+c)+","+b);
				tablero[a+c][b]="X";
				System.out.println("¡TOCADO!");
				if((a+c)==filas-1) break;
			}
		}
		if((a-1)>=0) {
			for(int c=1;tablero[a-c][b]!="0"&&(a-c)>=0;c++) {
				System.out.println((a-c)+","+b);
				tablero[a-c][b]="X";
				System.out.println("¡TOCADO!");
				if((a-c)==0) break;
			}
		}
		return hundir;
	}

	private Boolean comprobarHorizontal(int a, int b) {
		boolean hundir=true;
		
		if((b+1)<columnas) {
			for(int c=1;tablero[a][b+c]!="0"&&(b+c)<columnas;c++) {
				System.out.println(a+","+(b+c));
				tablero[a][b+c]="X";
				System.out.println("¡TOCADO!");
				if((b+c)==columnas-1) break;
			}
		}
		if((b-1)>=0) {
			for(int c=1;tablero[a][b-c]!="0"&&(b-c)>=0;c++) {
				System.out.println(a+","+(b-c));
				tablero[a][b-c]="X";
				System.out.println("¡TOCADO!");
				if((b-c)==0) break;
			}
		}
		return hundir;
		
	}
	
	
}



	


	



