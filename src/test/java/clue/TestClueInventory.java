package clue;

import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;
import java.util.List;

public class TestClueInventory {
    @Test
            (description = "Test adding a clue to Clue Inventory")
    public void TestAddingClueToInventory() {
        User player =  new User(1,"Hieu");
        Clue clue = new Clue(1,"Deadman's Gold",3);
        player.getClueInventory().addClue(clue);
        List<Clue> clueList = player.getClueInventory().getClueList();
        Assert.assertEquals(clueList.size(), 1);
        Assert.assertEquals(clueList.getFirst(), clue);
    }
    @Test
            (description = "Test adding Null object to Clue Inventory",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Clue can't be null")
    public void TestAddingNullClueToInventory() {
        User player =  new User(1,"Hieu");
        player.getClueInventory().addClue(null);
    }
    @Test
            (description = "Test modify unmodifiable list"
            ,expectedExceptions = UnsupportedOperationException.class)
    public void TestModifyClueList(){
        User player =  new User(1,"Hieu");
        Clue clue = new Clue(1,"Deadman's Gold",3);
        player.getClueInventory().addClue(clue);
        List<Clue> clueList = player.getClueInventory().getClueList();
        clueList.clear();
    }
    @Test
            (description = "Test adding already existed clue",
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Clue already exists")
    public void TestAddExistingClue() {
        User player =  new User(1,"Hieu");
        Clue clue = new Clue(1,"Deadman's Gold",3);
        player.getClueInventory().addClue(clue);
        player.getClueInventory().addClue(clue);
    }
    @Test(description = "Completing Clue")
    public void TestAcquireAllClueFragmentToCollectClue() {
        User player = new User(1, "Hieu");
        Clue clue = new Clue(1, "River of Blood", 3);
        ClueFragment clueFragment1 = new ClueFragment(1, clue, 1, "Across the blood-soaked ancient battlefield ....");
        ClueFragment clueFragment2 = new ClueFragment(2, clue, 2, "...the Old King crashed from his mount...");
        ClueFragment clueFragment3 = new ClueFragment(3, clue, 3, "...leaving a savage massacre in his wake");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
        clue.addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment1);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        player.getClueFragmentInventory().addFragment(clueFragment3);
        player.getClueFragmentInventory().completeClue(clue, player.getClueInventory());
        List<Clue> clueList = player.getClueInventory().getClueList();
        Assert.assertEquals(clueList.size(), 1);
        Assert.assertEquals(clueList.getFirst(), clue);
    }
}
