import java.util.ArrayList;

public class Stack {
	private ArrayList<Symbol> stack;
	
	public Symbol seeTop() {
		return getStack().get(getStack().size() - 1);
	}
	public void push(Symbol symbol) {
		getStack().add(symbol);
	}
	public void delete() {
		getStack().remove(getStack().size() - 1);
	}
	public Symbol pop() {
		Symbol output = seeTop();
		delete();
		return output;
	}
	
	public ArrayList<Symbol> getStack() {
		return this.stack;
	}
	public void setStack(ArrayList<Symbol> stack) {
		this.stack = stack;
	}
}
