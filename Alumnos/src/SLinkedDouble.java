public class SLinkedDouble {
	
	protected int size=0;
	
	protected Node header, trailer;
	
	public SLinkedDouble()
	{
		size=0;
		header= new Node(null, null,null,null);
		trailer= new Node(null, null, null,null);
		header.setNext(trailer);
	}

	public void addNode(String ci, String Name){
		
		Node New =  new Node(null,null,null,null);
		Node Last = new Node(null,null,null,null);
		if(IsEmpty()){
			New.setCI(ci);
			New.setName(Name);
			header=New;
		
		}else{
			Node Aux=header;
			while(Aux.getNext()!=null){
				Aux=Aux.getNext();
			}
			if(size>=2){
				New.setCI(ci);
				New.setName(Name);
				New.setNextLast(Aux);
				Aux.setNext(New);
				trailer=New;
			}else{
				Last=trailer;
				Last.setCI(ci);
				Last.setName(Name);
				Last.setNextLast(Aux);
				Aux.setNext(trailer);
				
				
			}
			
			
			
		}
		size++;
			
	}
	public int Size(){return size;}
	
	public boolean IsEmpty(){return (size==0);}
	
	public Node getFirst() throws IllegalStateException {
		if(IsEmpty()) throw new IllegalStateException("La lista esta vacia");
		return header.getNext();
	}
	
	public Node getLast() throws IllegalStateException{
		if(IsEmpty()) throw new IllegalStateException("La lista esta vacia");
		return trailer.getNextLast();
	}
	
	public Node getPrev(Node v) throws IllegalStateException{
		if(v==header) throw new IllegalStateException("no se puede mover mas alla de Atras de la lista");
		return v.getNextLast();
	}
	
	public void addBefore(Node v, Node z) throws IllegalStateException{
		Node u= v.getNextLast();
		z.setNextLast(u);
		z.setNext(v);
		v.setNextLast(z);
		u.setNext(z);
		size++;
	}
	public void addAfter(Node v, Node z){
		Node w=v.getNext();
		z.setNextLast(v);
		z.setNext(w);
		w.setNextLast(z);
		v.setNext(z);
		size++;
	}
	public void addFirst(Node v){
		addAfter(header, v);
	}
	public void addLast(Node v){
		addBefore(trailer, v);
	}
	
	public boolean Search1(String Ci){
		 Boolean encontrado= null;
		 Node aux=header;
		while(aux !=null && encontrado!=true){
			
			if(aux.getCI().equalsIgnoreCase(Ci)){
				encontrado=true;
				return encontrado;
				}else{
				aux=aux.getNext();
				}
		}
			return false;
	}
	public void AddFirst(String dato){
		
		if(IsEmpty())
			System.out.println("La Lista esta vacia");
		
		Node Aux=header;
		Node New= new Node (null, null,null,null);
		
		New.setCI(dato);
		New.setNext(Aux);
		Aux.setNextLast(New);
		header=New;
		size++;
		
	}
	
public void AddLast(String dato){
		
		if(IsEmpty())
			System.out.println("La Lista esta vacia");
		
		Node Aux=trailer;
		Node New= new Node (null, null,null,null);
		
		New.setCI(dato);
		New.setNextLast(Aux);
		Aux.setNext(New);
		trailer=New;
		
		size++;
	}
	public Node Search(String Ci){
		Node aux= new Node(null,null,null,null);
		Node Find=new Node(null,null,null,null);
		boolean encontrado=false;
		aux= header;
		while(aux !=null && encontrado!=true){
		
			if(aux.getCI()==Ci){
				Find=aux;
				encontrado=true;
				return Find;
				}else{
				aux=aux.getNext();
				}
		}
			return null;
		}
			
	public int Searchs(String dato){
		Node aux= new Node(null,null,null,null);
		aux= header;
		if(IsEmpty()){
			System.out.println("La lista esta vacia");
			return -1;
		}
		
		for(int i=0;i<size;i++){
			
			if(aux.getCI().equalsIgnoreCase(dato)){
				return i;
				}else{
				aux=aux.getNext();
				}
		}
			return -1;
		}
	public void CleanList(){
		
		header.setNext(null);
		size=0;
		System.out.println("La Lista esta vacia");
	}
	public void ListarAdelante(){
		if(!IsEmpty()){
			Node Aux= header;
			int i=0;
			System.out.println("#Alumno" +"  "+ "[      Cedula     ]"+"[   Nombre Y Apellido   ]");
			while(i!=size){
				System.out.println(i +"-> "+ "        [ "+Aux.getCI()+" ]"+"        [ "+Aux.getName()+" ]");
			Aux= Aux.getNext();
			i++;
			}
		}}
	public void ListarAtras()
	{
		if(!IsEmpty()){
			Node Aux= trailer;
			int i=0;
			while(i!=size){
				System.out.println((size-i-1) +"-> "+ "["+Aux.getCI()+"]");
			Aux= Aux.getNextLast();
			i++;
			}
	}
	}
	
	public int SearchI(String dato)
	{
		Node Aux= new Node(null,null,null,null);
		Aux=header;
	
		if(IsEmpty()){
			System.out.println("La Lista esta vacia");
			return -1;
		}
			for(int i=0; i<size;i++){
				if(Aux.getCI().equalsIgnoreCase(dato)){
					return i;}
				Aux= Aux.getNext();
			}
			return -1;
	}
	
	public void InsertNewElementPerRefBefore(String dato,String ref){
		
		Node New= new Node(null,null,null,null);
		Node Aux=header;
		Node Aux1=new Node(null,null,null,null);
		
		for(int i=0;i<size;i++)
			if(Aux.getCI()==ref){
				New.setCI(dato);
				New.setNextLast(Aux.getNextLast());
				New.setNext(Aux);
				Aux1.setNext(New);
				Aux.setNextLast(New);
				size++;
				return;
			}else{
				Aux1=Aux;
				Aux=Aux.getNext();
				
			}
				
	}
	public void InsertNewElementPerRefLast(String dato,String ref){
		
		Node New= new Node(null,null,null,null);
		Node Aux=header;
		
		for(int i=0;i<size;i++)
			if(Aux.getCI()==ref){
				New.setCI(dato);
				New.setNext(Aux.getNext());
				New.setNextLast(Aux);
				Aux.getNext().setNextLast(New);
				Aux.setNext(New);
				size++;
				return;
			}else{

				Aux=Aux.getNext();
				
			}
				
	}
	
	public void EditNode(String dato, String ref)
	{
		Node Aux=Search(ref);
		Aux.setCI(dato);
	}
	
	public void Remove(String dato){
		
		Node aux= Search(dato);
		
		if(aux==null)
			System.out.println("no existe el dato");
		if(aux.getCI()==header.getCI()){
			header=header.getNext();
			aux.setNext(null);
			aux.setNextLast(null);
			size--;
			System.out.println("El elemento ha sido elimindado");
			return;
		}else if(aux==trailer){
			trailer=trailer.getNextLast();
			aux.setNextLast(null);
			aux.setNext(null);
			System.out.println("El elemento ha sido elimindado");
			size--;
			return;
		}else {
			Node Aux1= new Node(null,null,null,null);
			Node Aux2= new Node(null,null,null,null);
			Aux1=aux.getNextLast();
			Aux2=aux.getNext();
			aux.setNext(null);
			aux.setNextLast(null);
			Aux2.setNextLast(Aux1);
			Aux1.setNext(Aux2);
			size--;
		}
	
	}
	}