package main.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class SubzeroFalloutItems {
    public static Item
    //TYR
    iron, obsidian, arsenic, steel, ignisGlass,
    //ALTECORIS
    nickel, bauxite, coltan, quartz, aluminum, nitride, sodium, tantalum, niobium, uranium
    //LEGION

    ;

    public static void load(){
        iron = new Item("iron", Color.valueOf("F2F285")){{
            cost = 1f;
            healthScaling = 0.7f;
        }};
        obsidian = new Item("obsidian", Color.valueOf("F2F285")){{
            cost = 1f;
            healthScaling = 0.6f;
        }};
        steel = new Item("steel", Color.valueOf("F2F285")){{
            cost = 1.2f;
            healthScaling = 0.9f;
        }};
        ignisGlass = new Item("ignis-glass", Color.valueOf("F2F285")){{
            cost = 0.5f;
            healthScaling = 0.6f;
        }};
        arsenic = new Item("arsenic", Color.valueOf("F2F285")){{
            cost = 0.6f;
            healthScaling = 0.5f;
        }};
        nickel = new Item("nickel", Color.valueOf("C2AAA1")){{
            cost = 0.8f;
            hardness = 2;
            healthScaling = 0.4f;
        }};
        bauxite = new Item("bauxite", Color.valueOf("EBB481")){{
            hardness = 4;
            buildable = false;
        }};
        coltan = new Item("coltan", Color.valueOf("676B99")){{
            hardness = 6;
            buildable = false;
        }};
        quartz = new Item("quartz", Color.valueOf("FFEDF1")){{
            cost = 0.5f;
            hardness = 4;
            healthScaling = 0.25f;
        }};
        aluminum = new Item("aluminum", Color.valueOf("A7AAC4")){{
            cost = 1.1f;
            healthScaling = 0.75f;
        }};
        nitride = new Item("nitride", Color.valueOf("DACFE6")){{
            cost = 1.3f;
            healthScaling = 0.3f;
        }};
        sodium = new Item("sodium", Color.valueOf("DFEEF2")){{
            cost = 1f;
            healthScaling = 0.3f;
        }};
        tantalum = new Item("tantalum", Color.valueOf("FFEDF1")){{
            cost = 1.5f;
            hardness = 6;
            healthScaling = 1f;
        }};
        niobium = new Item("niobium", Color.valueOf("C6C190")){{
            cost = 1.5f;
            hardness = 6;
            healthScaling = 1f;
        }};
        uranium = new Item("uranium", Color.valueOf("FFEDF1")){{
            cost = 1.3f;
            hardness = 8;
            healthScaling = 1.2f;
            radioactivity = 0.9f;
        }};
    }
}
