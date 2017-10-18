
public class Arma {
	//Atributos
	private String nombreArma = "";
	private int poder = 0;
	//Métodos
	public Arma(String nombreArma, int poder) {
		this.nombreArma = nombreArma;
		this.poder = poder;
	}
	
	
	
	//Métodos para Arbol
	 public int compareTo(Arma anotherArma) {
	        return compare(this.poder, anotherArma.poder);
	    }
	 public static int compare(int x, int y) {
	        return (x < y) ? -1 : ((x == y) ? 0 : 1);
	    }
	 public boolean equals(Object obj) {
	        return (this == obj);
	    }

}
