package PolynomArithmetic;

public class Term {
	public int coefficient;
	public int degree;
	public Term next;
	
	public Term(int coefficient, int degree) {
		this.coefficient = coefficient;
		this.degree = degree;
		next = null;
	}
}
