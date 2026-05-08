package service;

import java.util.ArrayList;
import java.util.List;
import model.KitCirurgico;

public class KitService {

    private List<KitCirurgico> kits = new ArrayList<>();

    public void criarKit(KitCirurgico kit){
        kits.add(kit);
    }
    public List<KitCirurgico> listarKits() {
        return kits;
    }
}
