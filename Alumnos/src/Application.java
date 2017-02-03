import java.util.Random;
import java.util.Scanner;

public class Application {
	
	public static SLinkedDouble ListDouble= new SLinkedDouble();
	private static String Nombres []={"Maria","Juano","Carlos","David","Christian" };
	private static String Apellidos[]={"Toledo","Castro","Pillajo","Barahona","Aviles"	};

	public static void main(String[] args)
	{
		int op=0;
		Scanner scann=new Scanner(System.in);
		String dato;
		
		
		
		System.out.println("*****************************Lista de Alumnos**************************");
		do{
		
			System.out.println("\n[1]-> Añadir Alumnos\n[2]-> Buscar por cedula\n[3]-> Imprimir Lista\n[0]-> Salir\nElija una opcion---->");
			op=scann.nextInt();
			switch(op){
			case 1:
				ListDouble.addNode(CI(),NameAlum());
				break;
			case 2:
				
					ListDouble.ListarAdelante();
					System.out.println("Ingrese la Cedula ->");
					dato=String.valueOf(scann.nextLong());
					System.out.println("El Alumno de CI  "+dato+ ", su estado de registo es: "+(ListDouble.Searchs(dato)!=-1 ? ("existente, en la posicion ->"+ListDouble.SearchI(dato)):"Inexistente"));
			
				break;
			case 3:
				ListDouble.ListarAdelante();
				break;

			}
		}while(op!=0);
	}
	public static String NameAlum()
	{
		Random rnd = new Random();
		String alumnos="";
		alumnos = Nombres[(int) (rnd.nextInt(Nombres.length-1))]+" "+Apellidos[(int) (rnd.nextInt(Apellidos.length-1))];
		System.out.println("\nSe ha aniadido un dato con exito");
		return alumnos;
	}
	
	public static String CI(){
		Random end= new Random();
		String Ci="";

		
		while(Ci.length()<10){
		
		Ci+= String.valueOf(end.nextInt(9));
		}
			
			return Ci;
			
		}
	}

