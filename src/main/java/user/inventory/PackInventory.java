package user.inventory;

import pack.Pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PackInventory {
    private final List<Pack> packs = new ArrayList<>();
    public List<Pack> getOwnedPacks() {
        return Collections.unmodifiableList(this.packs);
    }
    public void addPackToInventory(Pack pack) {
        if(pack != null) {
            this.packs.add(pack);
        }
        else  {
            throw new IllegalArgumentException("Unable to find the pack");
        }
    }
}
