import java.util.ArrayList;

public class AP {
	private ArrayList<NoTerminal> noTerminales;
	private ArrayList<Terminal> terminales;
	private Stack stack;
	private ArrayList<State> states;
	private ArrayList<Transition> allTransitions;
	
	private Word word;
	
	private ArrayList<Word> wordRegister;
	private ArrayList<Transition> transitionStack;
	private State currentState;
	
	public AP(ArrayList<NoTerminal> noTerminales, ArrayList<Terminal> terminales, ArrayList<State> states, ArrayList<Transition> allTransitions, Word word {
		this.noTerminales = noTerminales;
		this.terminales = terminales;
		this.states = states;
		this.allTransitions = allTransitions;
		this.word = word;
		this.stack = new Stack();
		this.wordRegister = new ArrayList<Word>();
		this.transitionStack = new ArrayList<Transition>();
	}
	public void step() {
		// Guardamos todas las transiciones posibles actualmente y su estado actual
		for(Transition i: getAllTransitions()) {
			if(i.hasPath(getCurrentState(), getWord(), (NoTerminal) getStack().seeTop())) {
				getTransitionStack().add(i);
				getWordRegister().add(getWord());
		}
		if(!getTransitionStack().isEmpty()) {
			Transition transicion = getTransitionStack().get(getTransitionStack().size() - 1);
			// Realizamos la última transición disponible
			// Si es posible una transición actual
			setCurrentState(transicion.getPrevState());
			System.out.println(transicion);
			if(getTransitionStack().get(getTransitionStack().size() - 1).hasPath(getCurrentState(), getWord(), (NoTerminal) getStack().seeTop())) {
				/**
				 * Volver al estado y a la palabra
				 * Setear el estado nuevo
				 * Borrar carácter
				 * Borrar pila y añadir pila
				 */
				setWord(getWordRegister().get(getWordRegister().size() - 1));
				setCurrentState(transicion.getNextState());
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
			
			// Realizamos la transicion
			// Seteamos estado a siguiente
			
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
	public ArrayList<Word> getWordRegister() {
		return this.wordRegister;
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
