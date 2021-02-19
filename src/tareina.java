import java.util.Arrays;
import java.util.Scanner;

public class tareina {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		System.out.print("Ingrese la cantidad de personas a registrar: ");
		int cantidad = teclado.nextInt();
		
		String[][] almacen= new String[cantidad][3];
		
		for (int i = 0; i < almacen.length; i++) {
			System.out.println("Ingresa los datos de la persona #" + (i+1) + ": ");
			
			System.out.print("DPI: ");
			almacen[i][0] = teclado.next();
			
			System.out.print("Nombre: ");
			almacen[i][1] = teclado.next();
			
			System.out.print("Edad:");
			almacen[i][2] = teclado.next();
		}
		
		// Imprimimos los datos
		imprimir_datos(almacen);
		
		//Ordenamos los datos
		almacen = ordenar(almacen);
		
		//Imprimimos de nuevo
		imprimir_datos(almacen);
		
		//Busqueda de los datos
		System.out.println("DPI a buscar: ");
		String buscando_dato = teclado.next();
		
		if (busquedaHazel(almacen, buscando_dato)) {
			System.out.println("Dato encontrado");
			
			for (int i = 0; i < almacen.length; i++) {
					if (almacen[i][0].equals(buscando_dato)) {
						System.out.print("DPI: " + almacen[i][0]);
						System.out.print(" Nombre: " + almacen[i][1]);
						System.out.print(" Edad: " + almacen[i][2]);
					}
			}
			
		} else {
			System.out.println("Dato no hallado");
		}
		
		
		
		
		teclado.close();
	}
	
	public static void imprimir_datos(String[][] datos){
		System.out.println();
		System.out.println();
		for (int i = 0; i < datos.length; i++) {
			System.out.println("===============================");
			System.out.println("Dato #" + (i+1));
			System.out.println("DPI: " + datos[i][0]);
			System.out.println("Nombre: " + datos[i][1]);
			System.out.println("Edad: " + datos[i][2]);
			System.out.println("===============================");
			
		}
	}
	
	public static String[][] ordenar(String[][] datos) {
		for (int i = 0; i < datos.length - 1; i++) {
			for (int j = i+1; j < datos.length; j++) {
				long dato1 = Long.parseLong(datos[i][0]);
				long dato2 = Long.parseLong(datos[j][0]);
				
				if(dato1 > dato2) {
					String temporal;
					
					//Ordenando DPI
					temporal = datos[i][0];
					datos[i][0] = datos[j][0];
					datos[j][0] = temporal;
					
					//Ordenando Nombre
					temporal = datos[i][1];
					datos[i][1] = datos[j][1];
					datos[j][1] = temporal;
					
					//Ordenando Edad 
					temporal= datos[i][2];
					datos[i][2] = datos[j][2];
					datos[j][2] = temporal;					
					
				}
			}
		}
		return datos;
	}

	public static boolean busquedaHazel(String[][] busqueda, String buscado) {
		int tamanio = busqueda.length;
		int medio = tamanio/2;
		
		long busquedaLong = Long.parseLong(busqueda[medio][0]);
		long buscadoLong = Long.parseLong(buscado);
		
		if(busqueda[medio][0].equals(buscado)) {
			return true;
		} else if(tamanio == 1) {
			return false; 
		} else if (busquedaLong > buscadoLong) {
			return  busquedaHazel(Arrays.copyOfRange(busqueda,0,medio),buscado); //llamada recursiva
		} else {
			return busquedaHazel(Arrays.copyOfRange(busqueda, medio+1, tamanio), buscado);
		}
	}	
}
