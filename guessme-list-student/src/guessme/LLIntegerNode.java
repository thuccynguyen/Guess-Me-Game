package guessme;

/**
 * This class defines a linked list node storing an integer.
 * Use primitive type int (do not use wrapper class Integer)
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */
public class LLIntegerNode {
	// TODO
	private int info;
	private LLIntegerNode link;
	
	
	
	
	// a constructor 
	public LLIntegerNode(int info, LLIntegerNode link) {
		this.info = info;
		this.link = link;
	}
	
	//setter methods
	public void setInfo(int input) {
		info = input;
	}
	
	public void setLink(LLIntegerNode link) {
		this.link = link;
	}
	
	//getter methods
	public int getInfo() {
		return info;
	}
	
	public LLIntegerNode getLink() {
		return link;
	}
	
	
}

