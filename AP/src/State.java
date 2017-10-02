
public class State {
	private String name;
	private boolean terminal;
	
	public State (String name, boolean terminal) {
		this.name = name;
		this.terminal = terminal;
	}
	
	public String getName() {
		return this.name;
	}
	public boolean isTerminal() {
		return this.terminal;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}
}
