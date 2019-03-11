package guessme;

/**
 * An Array-based implementation of the Guess-A-Number game
 */
public class ArrayGame {

	// stores the next number to guess
	private int guess = 1000;
	
	// TODO: declare additional data members, such as arrays that store
	// prior guesses, eliminated candidates etc.
	int numGuesses = 0;
	boolean[] eliminationValues = new boolean[10000];
	int[] priorGuesses = new int[18];
	int[] correctGuesses = new int[18];
	boolean gameOver = false;
	int guessCounter = 0;
	int numMatches = 0;
	
	
	

	// NOTE: only primitive type arrays are allowed, such as int[], boolean[] etc.
	// You MAY NOT use any Collection type (such as ArrayList) provided by Java.
	
	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary,
	 * but DO NOT remove any provided method, otherwise your
	 * code will fail the JUnit tests!
	 * Also DO NOT create any new Java files, as they will
	 * be ignored by the autograder!
	 *******************************************************/
	
	// ArrayGame constructor method
	public ArrayGame() {
		
		reset();
	
	}
	
	// Resets data members and game state so we can play again
	public void reset() {
		// TODO
	for (int i = 0; i < eliminationValues.length; i++) {
		eliminationValues[i] = false;
	}
	for (int i = 0; i < priorGuesses.length; i++) {
		priorGuesses[i] = 0;
	}
	for (int i = 0; i < correctGuesses.length; i++) {
		correctGuesses[i] = 0;
	}
	guess = 1000;
	numGuesses = 0;
	gameOver = false;
	numMatches = 0;
	guessCounter = 0;
	
	
		
	}
	
	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		
	boolean isPriorGuess = false;
		for (int i = 0; i < priorGuesses.length; i++) {
			if (priorGuesses[i] == n) {
				isPriorGuess = true;
			}
		}
		
		return isPriorGuess;
		
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
	public static int numMatches(int a, int b) { // DO NOT remove the static qualifier
		// TODO
		int caseMatch = 0;
		for (int i = 0; i < 4; i++) {
			if ( (a%10) == (b%10)) {
				caseMatch++;
			}
		a = Math.round(a/10);
		b = Math.round(b/10);
		}
		
		
		return caseMatch;
	}
	
	/**
	 * Returns true if the game is over; false otherwise.
	 * The game is over if the number has been correctly guessed
	 * or if all candidates have been eliminated.
	 */
	public boolean isOver() {
		
		return gameOver;
	}
	// Returns the guess number and adds it to the list of prior guesses.
	public int getGuess() {
		// TODO: add guess to the list of prior guesses.
		
		priorGuesses[numGuesses] = guess;
		numGuesses++;
		return guess;
	}
	
	/**
	 * Updates guess based on the number of matches of the previous guess.
	 * If nmatches is 4, the previous guess is correct and the game is over.
	 * Check project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if all candidates
	 * have been eliminated (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {
		// TODO
		
		
		int x = 0;
		int tempGuess = guess;
		
		if (nmatches == 4) {
			gameOver = true;
			return true;
		}
		
		else {
			priorGuesses[guessCounter] = guess;
			eliminationValues[guess] = true;
			correctGuesses[guessCounter] = nmatches;
			for (int i = 1000; i < eliminationValues.length; i++) {
			if (eliminationValues[i] == false) {
				numMatches = numMatches(guess,i);
				if (numMatches != nmatches) {
					eliminationValues[i] = true;
				}
			
				if ((eliminationValues[i] == false) && (x==0)) {
					tempGuess = i;
					x = 1;
				}
			}
		}
		}
		
		if (x == 1) {
			guess = tempGuess;
			guessCounter++;
			x = 0;
			return true;
		}
		guessCounter++;
		return false;
	}
	
	// Returns the list of guesses so far as an integer array.
	// The size of the array must be the number of prior guesses.
	// Returns null if there has been no prior guess
	public int[] priorGuesses() {
		int[] tempGuesses = new int[numGuesses];
			
		if (numGuesses == 0) {
			return null;
		}
		
		if (numMatches == 4){
			reset();
		}
			
		for (int i = 0; i < tempGuesses.length; i++) {
			tempGuesses[i] = priorGuesses[i];
		}
		
		return tempGuesses;
	}
	
}
