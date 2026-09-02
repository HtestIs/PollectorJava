package clue;

import org.testng.Assert;
import org.testng.annotations.Test;
import user.User;
import user.inventory.ClueFragmentInventory;

import java.util.List;
import java.util.Map;

public class TestClueFragmentInventory {
    @Test(description = "Adding clue fragment to User's inventory")
    public void TestClueFragmentInventoryValid(){
        User player =  new User(1,"Hieu");
        Clue clue = new Clue(1,"Is this place... real ?",13);
        ClueFragment clueFragment = new ClueFragment(1,clue,4,"! $0*8% (8)@");
        clue.addFragment(clueFragment);
        player.getClueFragmentInventory().addFragment(clueFragment);
        Map<ClueFragment,Integer> fragments = player.getClueFragmentInventory().getFragments();
        Assert.assertEquals(fragments.get(clueFragment),1);
    }
    @Test(description = "Adding 2 copies of the same clue to user's inventory")
    public void TestClueFragmentInventoryValidDuplicate(){
        User player =  new User(1,"Hieu");
        Clue clue = new Clue(1,"Is this place... real ?",13);
        ClueFragment clueFragment = new ClueFragment(1,clue,4,"! $0*8% (8)@");
        clue.addFragment(clueFragment);
        player.getClueFragmentInventory().addFragment(clueFragment);
        player.getClueFragmentInventory().addFragment(clueFragment);
        Map<ClueFragment,Integer> fragments = player.getClueFragmentInventory().getFragments();
        Assert.assertEquals(fragments.get(clueFragment),2);
    }
    @Test(description = "Adding a null Fragment"
    ,expectedExceptions = IllegalArgumentException.class
    ,expectedExceptionsMessageRegExp = "Fragment cannot be found!")
    public void TestClueFragmentNull(){
        User player =  new User(1,"Hieu");
        player.getClueFragmentInventory().addFragment(null);
    }
    @Test(description = "Remove from Map"
            ,expectedExceptions = UnsupportedOperationException.class)
    public void TestClueFragmentRemoval(){
        User player =  new User(1,"Hieu");
        Clue clue = new Clue(1,"Is this place... real ?",13);
        ClueFragment clueFragment = new ClueFragment(1,clue,4,"! $0*8% (8)@");
        player.getClueFragmentInventory().addFragment(clueFragment);
        Map<ClueFragment,Integer> fragments = player.getClueFragmentInventory().getFragments();
        fragments.clear();
    }
    @Test(description = "Acquire all the parts!")
    public void TestCollectedFullFragments(){
        User player =  new User(1,"Hieu");
        Clue clue =  new Clue(1,"River of Blood",3);
        ClueFragment clueFragment1 = new ClueFragment(1,clue,1,"Across the blood-soaked ancient battlefield ....");
        ClueFragment clueFragment2 = new ClueFragment(2,clue,2,"...the Old King crashed from his mount...");
        ClueFragment clueFragment3 = new ClueFragment(3,clue,3,"...leaving a savage massacre in his wake");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
        clue.addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment1);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        player.getClueFragmentInventory().addFragment(clueFragment3);
        Assert.assertTrue(player.getClueFragmentInventory().hasCompleted(clue));
    }
    @Test(description = "Missing 1 fragment!")
    public void TestMissingOneFragment(){
        User player =  new User(1,"Hieu");
        Clue clue =  new Clue(1,"Widow's grief",3);
        ClueFragment clueFragment1 = new ClueFragment(1,clue,1,"Confronted by the cruel truth");
        ClueFragment clueFragment2 = new ClueFragment(2,clue,2,"...the Queen vanished down her husband's faded path...");
        ClueFragment clueFragment3 = new ClueFragment(3,clue,3,"...leaving no trace behind.");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
        clue.addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment1);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        Assert.assertFalse(player.getClueFragmentInventory().hasCompleted(clue));
    }
    @Test(description = "Missing 1 unique fragment")
    public void TestMissingUniqueFragment(){
        User player =  new User(1,"Hieu");
        Clue clue =  new Clue(1,"Widow's grief",3);
        ClueFragment clueFragment1 = new ClueFragment(1,clue,1,"Confronted by the cruel truth");
        ClueFragment clueFragment2 = new ClueFragment(2,clue,2,"...The Queen vanished down her husband's faded path...");
        ClueFragment clueFragment3 = new ClueFragment(3,clue,3,"...leaving no trace behind.");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
        clue.addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment1);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        Assert.assertFalse(player.getClueFragmentInventory().hasCompleted(clue));
    }
    @Test(description = "Same fragment, different object")
    public void TestSameFragmentDifferentObject(){
        User player =  new User(1,"Hieu");
        Clue clue = new Clue(1, "River of Blood", 3);

        ClueFragment fragment1 =
                new ClueFragment(1, clue, 1, "Part one");

        ClueFragment fragment2 =
                new ClueFragment(1, clue, 1, "Part one");

        clue.addFragment(fragment1);

        player.getClueFragmentInventory().addFragment(fragment1);
        player.getClueFragmentInventory().addFragment(fragment2);
        Map<ClueFragment, Integer> fragments = player.getClueFragmentInventory().getFragments();

        Assert.assertEquals(fragments.size(), 1);
        Assert.assertEquals(fragments.get(fragment1), 2);
    }
    @Test(description = "Completing Clue")
    public void TestCompletingClue(){
        User player =  new User(1,"Hieu");
        Clue clue =  new Clue(1,"River of Blood",3);
        ClueFragment clueFragment1 = new ClueFragment(1,clue,1,"Across the blood-soaked ancient battlefield ....");
        ClueFragment clueFragment2 = new ClueFragment(2,clue,2,"...the Old King crashed from his mount...");
        ClueFragment clueFragment3 = new ClueFragment(3,clue,3,"...leaving a savage massacre in his wake");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
        clue.addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment1);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        player.getClueFragmentInventory().addFragment(clueFragment3);
        player.getClueFragmentInventory().completeClue(clue,player.getClueInventory());
        Map<ClueFragment, Integer> fragments = player.getClueFragmentInventory().getFragments();

        Assert.assertEquals(fragments.size(), 0);
        Assert.assertFalse(fragments.containsKey(clueFragment1));
        Assert.assertFalse(fragments.containsKey(clueFragment2));
        Assert.assertFalse(fragments.containsKey(clueFragment3));
    }
    @Test(description = "Completing Clue 2")
    public void TestCompletingClue2(){
        User player =  new User(1,"Hieu");
        Clue clue =  new Clue(1,"River of Blood",3);
        ClueFragment clueFragment1 = new ClueFragment(1,clue,1,"Across the blood-soaked ancient battlefield ....");
        ClueFragment clueFragment2 = new ClueFragment(2,clue,2,"...the Old King crashed from his mount...");
        ClueFragment clueFragment4 = new ClueFragment(2,clue,2,"...the Old King crashed from his mount...");
        ClueFragment clueFragment3 = new ClueFragment(3,clue,3,"...leaving a savage massacre in his wake");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
        clue.addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment1);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        player.getClueFragmentInventory().addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment4);
        player.getClueFragmentInventory().completeClue(clue, player.getClueInventory());
        Map<ClueFragment, Integer> fragments = player.getClueFragmentInventory().getFragments();

        Assert.assertEquals(fragments.size(), 1);
        Assert.assertFalse(fragments.containsKey(clueFragment1));
        Assert.assertEquals(fragments.get(clueFragment2),1);
        Assert.assertFalse(fragments.containsKey(clueFragment3));
    }
    @Test(description = "Incomplete Clue",
        expectedExceptions = IllegalStateException.class,
        expectedExceptionsMessageRegExp = "You don't have all required fragments!")
    public void TestIncompleteClue(){
        User player =  new User(1,"Hieu");
        Clue clue =  new Clue(1,"River of Blood",3);
        ClueFragment clueFragment1 = new ClueFragment(1,clue,1,"Across the blood-soaked ancient battlefield ....");
        ClueFragment clueFragment2 = new ClueFragment(2,clue,2,"...the Old King crashed from his mount...");
        ClueFragment clueFragment3 = new ClueFragment(3,clue,3,"...leaving a savage massacre in his wake");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
        clue.addFragment(clueFragment3);
        player.getClueFragmentInventory().addFragment(clueFragment1);
        player.getClueFragmentInventory().addFragment(clueFragment2);
        player.getClueFragmentInventory().completeClue(clue, player.getClueInventory());
    }
}
