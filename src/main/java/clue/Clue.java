package clue;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Clue {
    private int id;
    private String name;
    private int amount;
    private List<ClueFragment> clueFragment = new ArrayList<>();

    public Clue(int id, String name,int amount) {
        if(id <= 0 || name == null || name.isEmpty() || amount <= 0) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
    public int getId() {
        return this.id;
    }
    public int getAmount() {
        return this.amount;
    }
    public String getName() {
        return this.name;
    }
    public List<ClueFragment> getClueFragment() {
        return Collections.unmodifiableList(this.clueFragment);
    }
    public void addFragment(ClueFragment clueFragment) {
        if(clueFragment == null || clueFragment.getClue() != this) {
            throw new IllegalArgumentException("The Fragment doesn't belong to this Clue");
        }
        for(ClueFragment existingFragment : this.clueFragment) {
            if (existingFragment.getId() == clueFragment.getId()) {
                throw new IllegalArgumentException(
                        "Fragment id already exists"
                );
            }
            if(existingFragment.getPart() == clueFragment.getPart()) {
                throw new IllegalArgumentException("The Fragment part already exists");
            }
        }
        this.clueFragment.add(clueFragment);
    }
}
