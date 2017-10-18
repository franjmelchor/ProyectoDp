
public class ArbolArmas extends Arbol{
	/** Dato almacenado en cada nodo del árbol. */
	private Arma datoRaiz;
	
	/** Atributo que indica si el árbol está vacío. */
	boolean esVacio;
	
	/** Hijo izquierdo del nodo actual */
	private ArbolArmas hIzq;
	
	/** Hijo derecho del nodo actual */
	private ArbolArmas hDer;
	
	/**
	 * Constructor por defecto de la clase. Inicializa un árbol vacío.
	 */
	public ArbolArmas(){
	    this.esVacio=true;
	    this.hIzq = null;
	    this.hDer = null;
	}

	/**
	 * Crea un nuevo árbol a partir de los datos pasados por parámetro.
	 *
	 * @param hIzq El hijo izquierdo del árbol que se está creando 
	 * @param datoRaiz Raíz del árbol que se está creando
	 * @param hDer El hijo derecho del árbol que se está creando
	 */
	public ArbolArmas (ArbolArmas hIzq, Arma datoRaiz, ArbolArmas hDer){
	        this.esVacio=false;
		this.datoRaiz = datoRaiz;
		this.hIzq = hIzq;
		this.hDer=hDer;
	}
	
	/**
	 * Devuelve el hijo izquierdo del árbol
	 *
	 * @return El hijo izquierdo
	 */
	public ArbolArmas getHijoIzq(){
		return hIzq;
	}
	
	/**
	 * Devuelve el hijo derecho del árbol
	 *
	 * @return Hijo derecho del árbol
	 */
	public ArbolArmas getHijoDer(){
		return hDer;
	}
	
	/**
	 * Devuelve la raíz del árbol
	 *
	 * @return La raíz del árbol
	 */
	public Arma getRaiz(){
		return datoRaiz;
	}
	
	/**
	 * Comprueba si el árbol está vacío.
	 * @return verdadero si el árbol está vacío, falso en caso contrario
	 */
	public boolean vacio(){
		return esVacio;
	}
	
	/**
	 * Inserta un nuevo dato en el árbol.
	 *
	 * @param dato El dato a insertar
	 * @return verdadero si el dato se ha insertado correctamente, falso en caso contrario
	 */
	public boolean insertar (Arma dato){
	    boolean resultado=true;
	    if (vacio()) {
	        datoRaiz = dato;
			esVacio = false;
		}
	    else {
	        if (!(this.datoRaiz.equals(dato))) {
	            ArbolArmas aux;
	            if (dato.compareTo(this.datoRaiz)<0) { //dato < datoRaiz
	                if ((aux=getHijoIzq())==null)
	                    hIzq = aux = new ArbolArmas();
	            }
	            else {									//dato > datoRaiz
	                if ((aux=getHijoDer())==null)
	                    hDer = aux = new ArbolArmas();
	            }
	            resultado = aux.insertar(dato);
	        }
	        else
	            resultado=false;
	    }
	    return resultado;
	}
	
	/**
	 * Comprueba si un dato se encuentra almacenado en el árbol
	 *
	 * @param dato El dato a buscar
	 * @return verdadero si el dato se encuentra en el árbol, falso en caso contrario
	 */
	public boolean pertenece(Arma dato){
	    ArbolArmas aux=null;
	    boolean encontrado=false;
	    if (!vacio()) {
	        if (this.datoRaiz.equals(dato))
	            encontrado = true;
	        else {
	            if (dato.compareTo(this.datoRaiz)<0)	//dato < datoRaiz
	                aux=getHijoIzq();
	            else									//dato > datoRaiz
	                aux = getHijoDer();
	            if (aux!=null)
	                encontrado = aux.pertenece(dato);
	        }
	    }
	    return encontrado;
	}
	
	/**
	 * Borrar un dato del árbol.
	 *
	 * @param dato El dato que se quiere borrar
	 */
	public void borrar(Arma dato){
	    if (!vacio()) {
	        if (dato.compareTo(this.datoRaiz)<0 && hIzq != null){			//dato<datoRaiz
					hIzq = hIzq.borrarOrden(dato);
			}	
	        else
	            if (dato.compareTo(this.datoRaiz)>0 && hDer != null) {		//dato>datoRaiz 
	            		hDer = hDer.borrarOrden(dato);
				}
	            else //En este caso el dato es datoRaiz
	            {
	                if (hIzq==null && hDer==null)
	                {
	                    esVacio=true;
	                }
	                else
	                    borrarOrden(dato);
	            }
	    }
	}
	

	/**
	 * Borrar un dato. Este método es utilizado por el método borrar anterior.
	 *
	 * @param dato El dato a borrar
	 * @return Devuelve el árbol resultante después de haber realizado el borrado
	 */
	private ArbolArmas borrarOrden(Arma dato)
	{
	    Arma datoaux;
	    ArbolArmas retorno=this;
	    ArbolArmas aborrar, candidato, antecesor;

	    if (!vacio()) {
	        if (dato.compareTo(this.datoRaiz)<0 && hIzq != null){		// dato<datoRaiz
		    	        hIzq = hIzq.borrarOrden(dato);
	        }
			else
	            if (dato.compareTo(this.datoRaiz)>0 && hDer != null) {	// dato>datoRaiz
	    	           hDer = hDer.borrarOrden(dato);
	            }
				else {
	                aborrar=this;
	                if ((hDer==null)&&(hIzq==null)) { /*si es hoja*/
	                    retorno=null;
	                }
	                else {
	                    if (hDer==null) { /*Solo hijo izquierdo*/
	                        aborrar=hIzq;
	                        datoaux=this.datoRaiz;
	                        datoRaiz=hIzq.getRaiz();
	                        hIzq.datoRaiz = datoaux;
	                        hIzq=hIzq.getHijoIzq();
	                        hDer=aborrar.getHijoDer();

	                        retorno=this;
	                    }
	                    else
	                        if (hIzq==null) { /*Solo hijo derecho*/
	                            aborrar=hDer;
	                            datoaux=datoRaiz;
	                            datoRaiz=hDer.getRaiz();
	                            hDer.datoRaiz = datoaux;
	                            hDer=hDer.getHijoDer();
	                            hIzq=aborrar.getHijoIzq();

	                            retorno=this;
	                        }
	                        else { /* Tiene dos hijos */
	                            candidato = this.getHijoIzq();
	                            antecesor = this;
	                            while (candidato.getHijoDer()!=null) {
	                                antecesor = candidato;
	                                candidato = candidato.getHijoDer();
	                            }

	                            /*Intercambio de datos de candidato*/
	                            datoaux = datoRaiz;
	                            datoRaiz = candidato.getRaiz();
	                            candidato.datoRaiz=datoaux;
	                            aborrar = candidato;
	                            if (antecesor==this)
	                                hIzq=candidato.getHijoIzq();
	                            else
	                                antecesor.hDer=candidato.getHijoIzq();
	                        } //Eliminar solo ese nodo, no todo el subarbol
	                    aborrar.hIzq=null;
	                    aborrar.hDer=null;
	                }
	            }
	    }
	    return retorno;
	}
	
	int profundidadArbol() {
		int profIzq=0;
		int profDer=0;
		int profundidad=0;
		if (!vacio()) {
			if((this.hIzq == null) && (this.hDer == null))
				profundidad = 1;
			else {
				if (this.hIzq != null) {
					profIzq =1 + this.hIzq.profundidadArbol ();
				}
				if (this.hDer!= null) {
					profDer = 1 + this.hDer.profundidadArbol ();
					
				}
				if( profIzq > profDer)
					profundidad = profIzq;
				else profundidad = profDer;
			}
		}
		return profundidad;
	}
	
	int contarNodos() {
		int profIzq=0;
		int profDer=0;
		int profundidad=0;
		if(!vacio()) {
			if ((this.hIzq == null) && (this.hDer == null))
				profundidad = 0 ;
			else {
				if ((this.hIzq != null) && (this.hDer != null ))
					profundidad = 1 + hIzq.contarNodos() + hDer.contarNodos();
				else {
					if (this.hIzq != null) {
						profIzq = 1 + this.hIzq.contarNodos();
					}
					if(this.hDer != null) {
						profDer = 1 + this.hDer.contarNodos();
					}
				profundidad =   profDer + profIzq;
				}
			}		
		}
		return profundidad;
	}
	
	int contarNodosHojas() {
		int profIzq = 0;
		int profDer = 0;
		int profundidad = 0;
		if (!vacio()) {
			if((this.hIzq == null) && (this.hDer == null))
				profundidad = 1;
			else {
				if( this.hIzq != null)
					profIzq = this.hIzq.contarNodosHojas();		
				if( this.hDer != null)
					profDer = this.hDer.contarNodosHojas();
				profundidad = profDer + profIzq;
			}

		}
		return profundidad;
	}
	
	int contarNodosInternos() {
		int profIzq = 0;
		int profDer = 0;
		int profundidad = 0;
		if (!vacio()) {
			if ((this.hIzq != null) && (this.hDer != null)) {
				profundidad = 1 + hIzq.contarNodosInternos() + hDer.contarNodosInternos();
			}
			else {
				if (this.hIzq != null)
					profIzq = 1 + this.hIzq.contarNodosInternos();
				if (this.hDer != null)
					profDer = 1 + this.hDer.contarNodosInternos();
				profundidad = profDer + profIzq ;
			}
		}
		return profundidad;
	}


//	 * Recorrido inOrden del árbol.
//	 */
	public void inOrden(){
	    ArbolArmas aux=null;
	    if (!vacio()) {
	        if ((aux=getHijoIzq())!=null) {
	            aux.inOrden();
	        }    
	      
	        System.out.println(this.datoRaiz);
	        
	        if ((aux=getHijoDer())!=null){
	            aux.inOrden();
	        }    
	    }
	}
	
	public void preOrden() {
		if(!vacio()) {
			System.out.println(this.datoRaiz);
			if(this.hIzq != null)
				hIzq.preOrden();
			if(this.hDer != null)
				hDer.preOrden();
		}
	}
	
	public void postOrden() {
		if(!vacio()) {
			if(this.hIzq != null)
				hIzq.postOrden();
			if(this.hDer != null)
				hDer.postOrden();
			System.out.println(this.datoRaiz);
		}
	}
	
	Arma nodoPadre (Arma Dato) {
		Arma Padre = null;
		if((this.hDer.datoRaiz.equals(Dato)) || (this.hIzq.datoRaiz.equals(Dato)))
				Padre = this.datoRaiz;
		else {
			if(this.datoRaiz.compareTo(Dato) < 0)
				Padre = hIzq.nodoPadre(Dato);
			else 
				Padre = hDer.nodoPadre(Dato);
		}
		return Padre;
	}
	
}
