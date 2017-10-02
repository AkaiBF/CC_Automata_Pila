import java.util.ArrayList;

public class AP {
	private ArrayList<NoTerminal> noTerminales;
	private ArrayList<Terminal> terminales;
	private Stack stack;
	private ArrayList<State> states;
	private ArrayList<Transition> allTransitions;
	
	private Word word;
	
	private ArrayList<Transition> transitionStack;
	private State currentState;
	
	public AP() {
		
	}
	public void step() {
		if(!getTransitionStack().isEmpty()) {
			// Si es posible una transición actual
			if(getTransitionStack().get(getTransitionStack().size() - 1).hasPath(getCurrentState(), getWord(), (NoTerminal) getStack().seeTop())) {
				// Registramos todas las transiciones actuales
				for(Transition i: getAllTransitions()) {
					if(i.hasPath(getCurrentState(), getWord(), (NoTerminal) getStack().seeTop()))
						getTransitionStack().add(i);
				}
			}
			// Realizamos la última transición disponible
			// Seteamos estado a siguiente
			setCurrentState(getTransitionStack().get(getTransitionStack().size() - 1).getNextState());
			// Borramos el terminal
			word.delete();
			// Borramos el no terminal
			stack.pop();
			// Añadimos no terminales
			ArrayList<NoTerminal> toInsert = getTransitionStack().get(getTransitionStack().size() - 1).getNextNoTerminal();
			for(int i = toInsert.size() - 1; i >= 0; i--) {
				stack.push(toInsert.get(i));
			}
		}
	}
	
	public ArrayList<NoTerminal> getNoTerminales() {
		return this.noTerminales;
	}
	public ArrayList<Terminal> getTerminales() {
		return this.terminales;
	}
	public Stack getStack() {
		return this.stack;
	}
	public ArrayList<State> getStates() {
		return this.states;
	}
	public State getCurrentState() {
		return currentState;
	}
	public ArrayList<Transition> getTransitionStack() {
		return this.transitionStack;
	}
	public Word getWord() {
		return this.word;
	}
	public void setNoTerminales(ArrayList<NoTerminal> noTerminales) {
		this.noTerminales = noTerminales;
	}
	public void setTerminales(ArrayList<Terminal> terminales) {
		this.terminales = terminales;
	}
	public void setStack(Stack stack) {
		this.stack = stack;
	}
	public void setStates(ArrayList<State> states) {
		this.states = states;
	}
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	public ArrayList<Transition> getAllTransitions() {
		return allTransitions;
	}
	public void setAllTransitions(ArrayList<Transition> allTransitions) {
		this.allTransitions = allTransitions;
	}
}
