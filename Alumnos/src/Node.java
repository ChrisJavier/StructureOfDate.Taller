public class Node {
 Node adelante;
 Node atras;
 String CI;
 String Name;
 
 public Node(String entrada){
	 
	 this.CI=entrada;
	 this.adelante=atras=null;
	 
 }

 public Node (Node adelante_, Node atras_, String dato, String Name_)
 {
	 this.adelante=adelante_;
	 this.atras=atras_;
	 this.CI=dato;
	 this.Name=Name_;
 }

public Node getNext() {
	return adelante;
}


public void setNext(Node adelante) {
	this.adelante = adelante;
}


public Node getNextLast() {
	return atras;
}


public void setNextLast(Node atras) {
	this.atras = atras;
}


public String getCI() {
	return CI;
}


public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public void setCI(String dato) {
	this.CI = dato;
}



}