package PolynomArithmetic;

public class Polynom {
	public Term first;
	public Term last;

	public Polynom() {
		first = null;
		last = null;
	}

	
	//INSERT && DELETE
	public void insert(int coefficient, int degree) {

		Term new_term = new Term(coefficient, degree);

		if (isContainElement()) {

			if (degree > first.degree) { //insert to head of list
				
				new_term.next = first;
				first = new_term;
				
			} else if (degree < last.degree) { //insert to tail of list
				
				last.next = new_term;
				last = new_term;
				
			} else { 

				Term pointer = first;
				boolean key = true;

				while (key) {

					if (pointer.degree == new_term.degree) { //if there is same degree					
						pointer.coefficient = pointer.coefficient + new_term.coefficient;
						key = false;						
					}
					
					else if ( (pointer.degree > new_term.degree) && (pointer.next.degree < new_term.degree) ) {
															 //if the new degree does not exist in the list
						Term temp = pointer.next;
						pointer.next = new_term;
						new_term.next = temp;
						key = false;
						
					}

					pointer = pointer.next;
				}
			}

		} else {
			first = new_term;
			last = new_term;
		}

	}
	
	public void delete(int degree) {
		
		if(isContainElement()) {		
			
			if(first.degree == degree) {
				first = first.next;			
			}
			else if(last.degree == degree) {
				Term pointer = first;
				
				while(pointer.next != last) {
					pointer = pointer.next;
				}
				
				last = pointer;
				pointer.next = null;		
			}
			else {
				Term pointer = first;
				Term temp = null;
				
				while(pointer != null) {
					if(pointer.degree == degree) {
						temp.next = pointer.next;
						pointer.next = null;
					}
					
					temp = pointer;
					pointer = pointer.next;
				}
			}
			
		}
		else {
			System.out.println("Polynom does not contain an element.");
		}
	}
	
	//POLYNOMIAL OPERATIONS
	public static Polynom sum(Polynom p1, Polynom p2) {
		Polynom summation = new Polynom();
		int coefficent = 0;
		int degree = 0;
		
		Term i = p1.first; //we will iterate all terms of each polynoms. 
		Term j = p2.first; 
		Term k = null; //if polynom's lenght does not equal each other, we need this "k" to complete the rest terms.
		
		while(i != null && j != null) {	
			
			if(i.degree == j.degree) {		
				coefficent = i.coefficient + j.coefficient;
				degree = i.degree;
				
				summation.insert(coefficent,degree);
				
				i = i.next;
				j = j.next;
			}
			
			else if(i.degree > j.degree) {
				coefficent = i.coefficient;
				degree = i.degree;
				
				summation.insert(coefficent, degree);
				
				i = i.next;
			}
			
			else if(j.degree > i.degree) {
				coefficent = j.coefficient;
				degree = j.degree;
				
				summation.insert(coefficent, degree);
				
				j = j.next;
			}
			
			//if we reach the end of one of the polynoms.
			if(i == null) k = j;			
			if(j == null) k = i;
			
			while(k != null) {
				coefficent = k.coefficient;
				degree = k.degree;
				summation.insert(coefficent, degree);
				
				k = k.next;
			}
		}
		
		return summation;
	}
	
	public static Polynom multiply(Polynom p1, Polynom p2) {
		Polynom product = new Polynom();
		int degree = 0;
		int coefficient = 0;
		
		Term i = p1.first;
		Term j = p2.first;
		
		while(i != null)  {
			while(j != null) {
				coefficient = i.coefficient * j.coefficient;
				degree = i.degree + j.degree;
				
				product.insert(coefficient, degree);
				
				j = j.next;
			}
			
			i = i.next;
			j = p2.first; 
		}
		
		return product;
	}
	
	//EXTRA OPERATIONS
	
	/**
	 * Takes start and end index of a polynom, and copies that interval.
	 * Insertes that interval into the indicated polynom. 
	 */
	public Polynom copyPaste(int startIndex, int endIndex, Polynom p) {
		
		//determine and create the copied interval
		Polynom copiedArea = new Polynom();
		Term pointer = first;		
		
		for (int i = 0; i <= endIndex; i++) {
			if(i >= startIndex) {
				copiedArea.insert(pointer.coefficient, pointer.degree);
			}
			
			pointer = pointer.next;
		}
		
		
		//insert the copied area to indicated polynom
		Term pointer2 = copiedArea.first; 
		
		while(pointer2 != null) {
			p.insert(pointer2.coefficient, pointer2.degree);
			
			pointer2 = pointer2.next;
		}
		
		return p;
	}

	
	//SUPPORT
	public void print() {
		Term pointer = first;

		while (pointer != null) {

			if (pointer == last) {
				System.out.print(pointer.coefficient + "x^" + pointer.degree);
				break;
			}

			if(pointer.coefficient == 0) {
				System.out.print("");
				
			}else if(pointer.coefficient == 1) {
				System.out.print("x^" + pointer.degree + " + ");
				
			}else if(pointer.degree == 0) {
				System.out.println(pointer.coefficient + " + ");
				
			}else if(pointer.degree == 1) {
				System.out.println(pointer.coefficient + "x" + " + ");
				
			}else {
				System.out.print(pointer.coefficient + "x^" + pointer.degree + " + ");
			}

			pointer = pointer.next;
		}

		System.out.println();
	}
	
	public int length() {
		Term pointer = first;
		int counter = 0;
		
		while(pointer != null) {
			counter++;
			pointer = pointer.next;
		}
		
		return counter;
	}

	public boolean isContainElement() {
		if (first == null) {
			return false;
		}

		return true;
	}
}
