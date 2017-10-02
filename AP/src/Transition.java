import java.util.ArrayList;

public class Transition {
	private State prevState;
	private Terminal terminal;
	private NoTerminal prevNoTerminal;
	private State nextState;
	private ArrayList<NoTerminal> nextNoTerminal;
	
	public Transition(State prevState, Terminal terminal, NoTerminal prevNoTerminal, State nextState, ArrayList<NoTerminal> nextNoTerminal) {
		this.prevState = prevState;
		this.terminal = terminal;
		this.prevNoTerminal = prevNoTerminal;
		this.nextState = nextState;
		this.nextNoTerminal = nextNoTerminal;
	}
	
	public boolean hasPath(State prevState, Word word, NoTerminal prevNoTerminal) {
		if(prevState == getPrevState() && word.last() == getTerminal() && prevNoTerminal == getPrevNoTerminal())
			return true;
		return false;
	}
	
	public String toString() {
		String output = new String();
		output += "(" + getPrevState() + ", " + prevNoTerminal + ")";
		output += "\u2208" + " " + "\u0394".toLowerCase();
		output += "(" + nextState + ", " + terminal + ", " + nextNoTerminal + ")";
		return output;
	}
	
	public State getPrevState() {
		return this.prevState;
	}
	public State getNextState() {
		 return this.nextState;
	}
	public ArrayList<NoTerminal> getNextNoTerminal() {
		return this.nextNoTerminal;
	}
	public Terminal getTerminal() {
		return this.terminal;
	}
	public NoTerminal getPrevNoTerminal() {
		return this.prevNoTerminal;
	}
}
