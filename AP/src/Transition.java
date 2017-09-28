
public class Transition {
	private State prevState;
	private Terminal terminal;
	private NoTerminal prevNoTerminal;
	private State nextState;
	private NoTerminal nextNoTerminal;
	
	public Transition(State prevState, Terminal terminal, NoTerminal prevNoTerminal, State nextState, NoTerminal nextNoTerminal) {
		this.prevState = prevState;
		this.terminal = terminal;
		this.prevNoTerminal = prevNoTerminal;
		this.nextState = nextState;
		this.nextNoTerminal = nextNoTerminal;
	}
	
	public String toString() {
		String output = new String();
		output += "(" + prevState + ", " + prevNoTerminal + ")";
		output += "\u2208" + " " + "\u0394".toLowerCase();
		output += "(" + nextState + ", " + terminal + ", " + nextNoTerminal + ")";
		return output;
	}
}
