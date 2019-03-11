package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game
 */
public class LinkedListGame {

	// TODO: declare data members as necessary
	private int guess = 1000;
	
	//LLIntegerNode priorGuesses = new LLIntegerNode(0,null);
	//LLIntegerNode guessHead = new LLIntegerNode(0,null);
	//LLIntegerNode canidateNums = null;
    boolean gameOver = false;
	//LLIntegerNode canidateHead = new LLIntegerNode(1000,null);
	//LLIntegerNode tailCanidate = canidateHead;
	//LLIntegerNode guessTail = guessHead;
	int numGuesses = 0;
	myLinkedList priorGuesses;
	myLinkedList canidateNums;
	


	

	
	/********************************************************
	 * NOTE: for this project you must use linked lists
	 * implemented by yourself. You are NOT ALLOWED to use
	 * Java arrays of any type, or any class in the java.util
	 * package (such as ArrayList).
	 *******************************************************/	 
	
	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary,
	 * but DO NOT remove any provided method, and do NOT add
	 * new files (as they will be ignored by the autograder).
	 *******************************************************/
	
	// LinkedListGame constructor method
	public LinkedListGame() {
		
	priorGuesses = new myLinkedList();
	canidateNums = new myLinkedList();
	//LLIntegerNode tempNode = canidateHead;
	for (int i = 1000; i < 10000; i++) {
		canidateNums.add(i);
		//LLIntegerNode canidateNums = new LLIntegerNode(i,null);
		//tempNode.setLink(canidateNums);
		//tempNode = canidateNums;
		
		

	}
	
	System.out.println("hello everyone" + guess);	
		
		
	}
	
	// Resets data members and game state so we can play again
	public void reset() {
		//priorGuesses = new LLIntegerNode(0,null);
		//guessHead = new LLIntegerNode(0,null);
	    gameOver = false;
	    //canidateNums = null;
	    //canidateHead = new LLIntegerNode(1000,null);
		//tailCanidate = canidateHead;
	    //guessTail = guessHead;
		numGuesses = 0;
		guess = 1000;
		
		
		//LLIntegerNode tempNode = canidateHead;
		//for (int i = 1000; i < 10000; i++) {
			//LLIntegerNode canidateNums = new LLIntegerNode(i,null);
			//tempNode.setLink(canidateNums);
			//tempNode = canidateNums;
		
		priorGuesses = new myLinkedList();
		canidateNums = new myLinkedList();
		for (int i = 1000; i < 10000; i++) {
			canidateNums.add(i);
		}

		
	}
	
	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		/**LLIntegerNode tempNode = guessHead;
		while (tempNode!=null) {
			if (tempNode.getInfo() == n) {
				return true;
			}
			tempNode = tempNode.getLink();
		}
		
		return false; **/
		return priorGuesses.contains(n);
		
		
	}
	
	// Returns the number of guesses so far.
	public int numGuesses() {
		// TODO
		return numGuesses;
	}
	
	/**
	 * Returns the number of matches between integers a and b.
	 * You can assume that both are 4-digits long (i.e. between 1000 and 9999).
	 * The return value must be between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example:
	 *   1234 and 4321 have 0 match;
	 *   1234 and 1114 have 2 matches (1 and 4);
	 *   1000 and 9000 have 3 matches (three 0's).
	 */
	public static int numMatches(int a, int b) {
		// TODO
		int caseMatch = 0;
		for (int i = 0; i < 4; i++) {
			if ( (a%10) == (b%10)) {
				caseMatch++;
			}
		a = (a/10);
		b = (b/10);
		}
		
		
		return caseMatch;
	}
	
	/**
	 * Returns true if the game is over; false otherwise.
	 * The game is over if the number has been correctly guessed
	 * or if no candidate is left.
	 */
	public boolean isOver() {
		// TODO
		return gameOver;
	}
	
	/**
	 * Returns the guess number and adds it to the list of prior guesses.
	 * The insertion should occur at the end of the prior guesses list,
	 * so that the order of the nodes follow the order of prior guesses.
	 */	
	public int getGuess() {
		// TODO: add guess to the list of prior guesses.
		
		/**if (numGuesses == 0) {
			guessHead = new LLIntegerNode(guess,null);
			guessTail = guessHead;
			numGuesses++;
			return guess;
			
		}
		
	
		
		
		guess = canidateHead.getInfo();
		LLIntegerNode guessNode = new LLIntegerNode(guess,null);
		guessTail.setLink(guessNode);
		guessTail = guessNode;
		numGuesses++;
		return guess; **/
		numGuesses++;
		guess = canidateNums.head.getInfo();
		priorGuesses.add(guess);
		return guess;
	}
	
	/**
	 * Updates guess based on the number of matches of the previous guess.
	 * If nmatches is 4, the previous guess is correct and the game is over.
	 * Check project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if no candidate 
	 * is left (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {
		
		if(nmatches == 4) {
			gameOver = true;
		}
		/**
		LLIntegerNode headCanidate = null;
		LLIntegerNode tailCanidate = null;
		
		LLIntegerNode tempNode = canidateHead;
		
		while(tempNode!=null) {
			int canidate = tempNode.getInfo();
			
			if(numMatches(canidate, guess)==nmatches) {
				LLIntegerNode newNode = new LLIntegerNode(canidate,null);
				if (headCanidate==null) {
					headCanidate = tailCanidate = newNode;
				}
				else {
					tailCanidate.setLink(newNode);
					tailCanidate = newNode;
				}
			}
			
		 tempNode = tempNode.getLink();
		 
		}
		
		canidateHead = headCanidate;
		
		if (canidateHead == null) {
			gameOver = true;
			return false;
		}
		// TODO
		guess = canidateHead.getInfo();
		return true; **/
		myLinkedList tempList = new myLinkedList();
		LLIntegerNode tempNode = canidateNums.head;
		while (tempNode != null) {
			if (numMatches(tempNode.getInfo(), guess) == nmatches) {
				tempList.add(tempNode.getInfo());
			
			}
			tempNode = tempNode.getLink();
		} 
		canidateNums = tempList;
		if (canidateNums.head == null) {
			return false;
		}
		return true;
	}
	
	// Returns the head of the prior guesses list.
	// Returns null if there hasn't been any prior guess
	public LLIntegerNode priorGuesses() {
		// TODO
		/**if (numGuesses == 0) {
			return null;
		}
		
		return guessHead;**/
		return priorGuesses.head;
		
			
	}
	
	/**
	 * Returns the list of prior guesses as a String. For example,
	 * if the prior guesses are 1000, 2111, 3222, in that order,
	 * the returned string should be "1000, 2111, 3222", in the same order,
	 * with every two numbers separated by a comma and space, except the
	 * last number (which should not be followed by either comma or space).
	 *
	 * Returns an empty string if here hasn't been any prior guess
	 */
	public String priorGuessesString() {
		// TODO
		String tempString = "";
		if (numGuesses == 0) {
			return "";
		}
		
		else {
			LLIntegerNode tempNode = priorGuesses.head;
			tempString = Integer.toString(tempNode.getInfo());
			tempNode = tempNode.getLink();
			while (tempNode!=null) {
				tempString +=  ", " + tempNode.getInfo();
				tempNode = tempNode.getLink();
			}
		
		
		}
		
	return tempString;
			
		
	}
	
	class myLinkedList {
		LLIntegerNode head;
		LLIntegerNode tail;
		int size;
		
		myLinkedList() {
			head = null;
			tail = null;
			size = 0;
		}
		
		public void add(int input) {
			
			LLIntegerNode tempNode = new LLIntegerNode(input,null);
			if (head == null) {
				head = tempNode;
				tail = tempNode;
				size++;
				return;
			}
			
			tail.setLink(tempNode);
			tail = tempNode;
			
			
		}
		
		public boolean contains(int input) {
			
			LLIntegerNode tempNode = head;
			
			while (tempNode != null) {
				if (tempNode.getInfo() == input) {
				return true;
				}
				tempNode = tempNode.getLink();
				
				
			}
			return false; }   
		
		public int size() {
			return size;
		}
	}
	
	
	
}

