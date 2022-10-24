package PolynomArithmetic;

public class Test {

	public static void main(String[] args) {
		Polynom poly = new Polynom();
		poly.insert(4, 2);
		poly.insert(3, 3);
		poly.insert(5, 7);
		poly.insert(3, 4);
		poly.insert(9, 9);
		poly.insert(1, 6);
		poly.print();
		

		
		Polynom poly2 = new Polynom();
		poly2.insert(4, 4);
		poly2.insert(11, 2);
		poly2.insert(5, 3);
		poly2.insert(9, 8);
		poly2.print();
		
		poly.copyPaste(0, 2, poly2).print();

	}

}
