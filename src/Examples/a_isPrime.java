package Examples;

import LinkedList_Single.*;

public class a_isPrime {

	public static void main(String[] args) {
		findPrimes(15).printList();
		
	}
	
	public static SingleLinkedList findPrimes(int N) {
		SingleLinkedList primeList = new SingleLinkedList();
		boolean isPrime;
		
		for (int i = 2; i <= N; i++) {
			isPrime = true; //her yeni sayýyý baþta prime kabul ediyoruz
			
			for (int j = 2; j < i; j++) {
				if(i % j == 0) {
					isPrime = false;  //eðer kendinden ve 1 den baþka sayýya bölünüyorsa prime deðil diyoruz.
					break;
				}
			}
			
			if(isPrime) {
				primeList.insertLast(i);
			}
		}
		
		return primeList;
	}

}
