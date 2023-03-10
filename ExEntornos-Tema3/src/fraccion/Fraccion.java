package fraccion;

// Clase que define una fracción
/**
 * Clase para definir la fracción
 * 
 * @author fmigg
 *
 */
public class Fraccion {
	// Numerador
	/**
	 * Numerador
	 */
	private int num;

	// Denominador
	/**
	 * Denominador
	 */
	private int den;

	// Constructor por defecto
	/**
	 * Valor neutro 0/1
	 */
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	/**
	 * debo evitar crear fracciones con 0 en el divisor
	 * 
	 * @param num
	 * @param den
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// Constructor copia
	/**
	 * Este método configura lsa variables, las obtiene y devuelve su valor actual
	 * 
	 * @param f
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	/**
	 * 
	 * @return
	 */
	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * Cálculo del máximo común divisor por el algoritmo de Euclides
	 * 
	 * @return
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	// método para simplificar fracciones
	/**
	 * método para simplificar fracciones
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	// Método toString
/**
 * Método toString
 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
