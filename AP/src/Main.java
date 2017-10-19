import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String file = new String("");
		AP ap = new Reader(file).getAP();
		
		ArrayList<Terminal> palabra = new ArrayList<Terminal>();
		Word word = new Word(palabra);
		
		ap.setWord(word);
		
		// Elegir modo
		int mode = 0;
		
		boolean traza = false;
		
		switch(mode) {
		case 0:
			System.out.println(ap.emptyStack(traza));
			break;
		case 1:
			System.out.println(ap.finalState(traza));
			break;
			default:
		}
	}
}
