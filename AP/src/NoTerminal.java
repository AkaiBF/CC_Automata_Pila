
public class NoTerminal extends Symbol {
	public NoTerminal(String name) {
		super(name);
	}
	
	public String toString() {
		String output = new String();
		output += getName();
		return output;
	}
}
