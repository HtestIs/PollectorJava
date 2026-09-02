package user.inventory;

import clue.Clue;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class ClueInventory {
    private final List<Clue> clueList = new ArrayList<>();
    public List<Clue> getClueList(){
        return Collections.unmodifiableList(this.clueList);
    }
    public void addClue(Clue clue){
        if(clue == null){
            throw new IllegalArgumentException("Clue can't be null");
        }
        if(clueList.contains(clue)){
            throw new IllegalArgumentException("Clue already exists");
        }
        this.clueList.add(clue);
    }
}
