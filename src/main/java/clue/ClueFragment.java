package clue;

public class ClueFragment {
    private int id;
    private Clue clue;
    private int part;
    private String content;
    public ClueFragment(int id, Clue clue, int part, String content) {
        if(id <= 0|| clue == null || part <= 0 || content == null || part > clue.getAmount()) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        this.id = id;
        this.clue = clue;
        this.part = part;
        this.content = content;
    }
    public int getId() {
        return this.id;
    }
    public int getPart() {
        return this.part;
    }
    public Clue getClue() {
        return this.clue;
    }
}
