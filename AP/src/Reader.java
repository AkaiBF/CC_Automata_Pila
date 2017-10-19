import java.io.*;
import java.util.*;

public class Reader {
	private AP ap;
	
	public Reader(String fichero) {
		try {
			FileReader fileReader = new FileReader(fichero);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = bufferedReader.readLine();
			String[] qSet = line.split(" ");
			ArrayList<State> states = new ArrayList<State>();
			for(String i:qSet) {
				states.add(new State(i, false));
			}
			
			line = bufferedReader.readLine();
			String[] eSet = line.split(" ");
			ArrayList<Terminal> terminales = new ArrayList<Terminal>();
			for(String i: eSet) {
				terminales.add(new Terminal(i));
			}
			
			line = bufferedReader.readLine();
			String[] rSet = line.split(" ");
			ArrayList<NoTerminal> noTerminales = new ArrayList<NoTerminal>();
			for(String i: rSet) {
				noTerminales.add(new NoTerminal(i));
			}
			
			State start = null;
			line = bufferedReader.readLine();
			String[] pStates = line.split(" ");
			for(State i: states) {
				for(String j: pStates)
					if(i.getName().equals(j)) start = i;
			}
			
			line = bufferedReader.readLine();
			String[] symbolsStack = line.split(" ");
			Stack stack = new Stack();
			for(String i: symbolsStack) {
				stack.push(new Symbol(i));
			}
			
			line = bufferedReader.readLine();
			pStates = line.split(" ");
			for(State i: states) {
				for(String j: pStates)
					if(i.getName().equals(j)) i.setTerminal(true);;
			}
			
			ArrayList<Transition> transitions = new ArrayList<Transition>();
			while((line = bufferedReader.readLine()) != null && line.length() != 0) {
				String[] data = line.split(" ");
				State prev = null;
				for(State i: states) {
					if(i.getName().equals(data[0])) 
						prev = i;
				}
				Terminal terminal = new Terminal(data[1]);
				NoTerminal consumed = new NoTerminal(data[2]);
				State next = null;
				for(State i: states) {
					if(i.getName().equals(data[3])) 
						next = i;
				}
				ArrayList<NoTerminal> toInsert = new ArrayList<NoTerminal>();
				for(int i = 4; i < data.length; i++) {
					toInsert.add(new NoTerminal(data[i]));
				}
				transitions.add(new Transition(prev, terminal, consumed, next, toInsert));
			}
			ap = new AP(noTerminales, terminales, states, transitions, new Word(new ArrayList<Terminal>()), start);
			bufferedReader.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AP getAP() {
		return ap;
	}
}
