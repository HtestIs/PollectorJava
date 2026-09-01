package clue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClue {
    @Test
    public void testClueFragment() {
        Clue clue = new Clue(1,"Mist Warden's Victims Location",484);
        ClueFragment clueFragment = new ClueFragment(1,clue,5,"...in the end of the road...");
    }
    @Test
            (expectedExceptions = IllegalArgumentException.class)
    public void testClueFragmentNegativeId() {
        Clue clue = new Clue(1,"Mist Warden's Victims Location",484);
        ClueFragment clueFragment = new ClueFragment(-1,clue,5,"...in the end of the road...");
    }
    @Test
            (expectedExceptions = IllegalArgumentException.class)
    public void testClueFragmentZeroId() {
        Clue clue = new Clue(1,"Mist Warden's Victims Location",484);
        ClueFragment clueFragment = new ClueFragment(0,clue,5,"...in the end of the road...");
    }
    @Test
            (expectedExceptions = IllegalArgumentException.class)
    public void testExceedFragment() {
        Clue clue = new Clue(1,"Treasure Map of Black Street Butcher",3);
        int maxAmount = clue.getAmount();
        ClueFragment clueFragment = new ClueFragment(1,clue,maxAmount+1,"...in the end of the road...");
    }
    @Test
            (expectedExceptions = IllegalArgumentException.class)
    public void testZeroFragment() {
        Clue clue = new Clue(1,"Mist Warden's Victims Location",484);
        ClueFragment clueFragment = new ClueFragment(1,clue,0,"...in the end of the road...");
    }
    @Test
            (expectedExceptions = IllegalArgumentException.class)
    public void testNegativeFragment() {
        Clue clue = new Clue(1,"Mist Warden's Victims Location",484);
        ClueFragment clueFragment = new ClueFragment(1,clue,-1,"...in the end of the road...");
    }
    @Test
    public void testValidClue(){
        Clue clue = new Clue(1,"Treasure Map of Black Street Butcher",3);
        Assert.assertEquals(clue.getId(),1);
        Assert.assertEquals(clue.getAmount(),3);
        Assert.assertEquals(clue.getClueFragment().size(),0);
    }
    @Test
    public void testAddingValidClueFragment(){
        Clue clue = new Clue(1,"Frozen Lake of Aggeudrok",4);
        ClueFragment clueFragment = new ClueFragment(1,clue,3,"...sacrifice one of your...");
        clue.addFragment(clueFragment);
        Assert.assertEquals(clue.getClueFragment().size(),1);
        Assert.assertEquals(clue.getClueFragment().getFirst(),clueFragment);
    }
    @Test(expectedExceptions = IllegalArgumentException.class,expectedExceptionsMessageRegExp = "The Fragment doesn't belong to this Clue")
    public void testAddingOthersClueFragment(){
        Clue clue1 = new Clue(1,"Frozen Lake of Aggeudrok",4);
        Clue clue2 = new Clue(2,"Pyramadama's Volcano",41);
        ClueFragment clueFragment1 = new ClueFragment(1,clue1,4,"...deepest desire");
        clue2.addFragment(clueFragment1);
    }
    @Test(expectedExceptions = IllegalArgumentException.class,expectedExceptionsMessageRegExp = "The Fragment part already exists")
    public void testAddingSamePartClueFragment(){
        Clue clue = new Clue(1,"Frozen Lake of Aggeudrok",4);
        ClueFragment clueFragment1 = new ClueFragment(1,clue,4,"...deepest desire");
        ClueFragment clueFragment2 = new ClueFragment(2,clue,4,"...d##p33t %35!&E");
        clue.addFragment(clueFragment1);
        clue.addFragment(clueFragment2);
    }
}
