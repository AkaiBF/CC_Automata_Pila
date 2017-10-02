import java.util.ArrayList;

// Hay que pasar Word a ArrayList<Terminal>
public class Word {
	private ArrayList<Terminal> word;
	
	public Word(ArrayList<Terminal> word) {
		this.word = word;
	}
	
	public void delete() {
		getWord().remove(getWord().size() - 1);
	}
	public Terminal last() {
		return getWord().get(getWord().size() - 1);
	}
	
	public String toString() {
		String output = new String();
		for(Terminal i: getWord())
			output += i;
		return output;
	}
	
	public ArrayList<Terminal> getWord() {
		return this.word;
	}
	public void setWord(ArrayList<Terminal> word) {
		this.word = word;
	}
}
