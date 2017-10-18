
public class Tablero {
	//Atributos
	private int dimensionX = 0;
	private int dimensionY = 0;
	private Sala matriz [][] = null  ;
	private int nSalas = 0;
	private int salaDailyPlanet = 0;
	
	//Métodos
	
	public Tablero (int dimensionX, int dimensionY, int salaDailyPlanet) {
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.nSalas = (dimensionX * dimensionY) - 1;
		this.salaDailyPlanet = salaDailyPlanet;
	}
	
	void iniciarTablero ( Tablero t ) {
		int i,j;
		for (i=0; i < t.dimensionY; i++) {
			for (j=0; j<t.dimensionX; j++) {
				t.matriz [i][j] = new Sala (j);
			}
		}
		
	}
	void insertarArmasSalas(int vectorSalas[],Arma vectorArmas[],int armasPorSala) {
		int j = 0;//Va aumentando como índice para el vectorSalas
		while(vectorSalas[j] != -1) {
			int k = (armasPorSala - 1) +j;//Va aumentando como 
											//índice para el vectorArmas
			int i = armasPorSala - 1;
			while(i >= 0) {
				insertarArmaSala(vectorSalas[j], vectorArmas[k]);
				k++;
				i--;
			}
			j++;
		}
		
	}
	
	void insertarArmaSala(int nSala, Arma arma) {
		int posX = nSala % dimensionX;
		int posY = (nSala - posX) / dimensionX;
		this.matriz[posY][posX].añadirArma(arma);
	}

}
