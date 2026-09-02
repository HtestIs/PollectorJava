package user.inventory;

import clue.Clue;
import clue.ClueFragment;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class ClueFragmentInventory {
    private final Map<ClueFragment,Integer> clueFragments =  new HashMap<>();

    public void addFragment(ClueFragment clueFragment) {
        if(clueFragment == null) {
            throw new IllegalArgumentException("Fragment cannot be found!");
        }
        int currentAmount = this.clueFragments.getOrDefault(clueFragment,0);
        this.clueFragments.put(clueFragment,currentAmount+1);
    }
    public Map<ClueFragment,Integer> getFragments() {
        return Collections.unmodifiableMap(this.clueFragments);
    }
    public boolean hasCompleted(Clue clue) {
        if(clue == null) {
            throw new IllegalArgumentException("Clue cannot be found!");
        }
        for(ClueFragment requiredFragment : clue.getClueFragment()) {
            int ownedAmount = this.clueFragments.getOrDefault(requiredFragment,0);
            if(ownedAmount == 0) {
                return false;
            }
        }
        return true;
    }
    public void completeClue(Clue clue,ClueInventory clueInventory) {
        if(!hasCompleted(clue)) {
            throw new IllegalStateException("You don't have all required fragments!");
        }
            for(ClueFragment requiredFragment : clue.getClueFragment()) {
                int ownedAmount = this.clueFragments.get(requiredFragment);
                if (ownedAmount == 1) {
                    this.clueFragments.remove(requiredFragment);
                } else {
                    this.clueFragments.put(requiredFragment, ownedAmount - 1);
                }

        }
            clueInventory.addClue(clue);

    }

}
