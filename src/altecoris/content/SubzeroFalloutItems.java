package main.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class SubzeroFalloutItems {
    public static Item
    //TYR
    haematite, iron, obsidianShard, vanadium, arsenic, heavyPlating, ignisGlass,
    //ALTECORIS
    nickel, bauxite, coltan, quartz, rutileCluster, aluminum, nitride, sodium, tantalum, niobium, uranium
    //LEGION

    ;

    public static void load(){
        haematite = new Item("haematite", Color.valueOf("9C6552")){{
            cost = 1f;
            healthScaling = 0.7f;
            buildable = false;
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
        rutileCluster = new Item("rutile-cluster", Color.valueOf("AE9B89")){{
            hardness = 5;
            buildable = false;
        }};
        obsidianShard = new Item("obsidian-shards", Color.valueOf("3D3A45")){{
            cost = 1f;
            healthScaling = 0.6f;
        }};
        iron = new Item("iron", Color.valueOf("AE9B89")){{
            cost = 1f;
            healthScaling = 0.7f;
        }};
        vanadium = new Item("vanadium", Color.valueOf("8cb2cf")){{
            cost = 1f;
            healthScaling = 0.5f;
        }};
        arsenic = new Item("arsenic", Color.valueOf("F2F285")){{
            cost = 0.2f;
            healthScaling = 0.5f;
        }};
        heavyPlating = new Item("heavy-plating", Color.valueOf("3E4551")){{
            cost = 1.2f;
            healthScaling = 0.9f;
        }};
        ignisGlass = new Item("ignis-glass", Color.valueOf("F2F285")){{
            cost = 0.5f;
            healthScaling = 0.6f;
        }};
        nickel = new Item("nickel", Color.valueOf("C2AAA1")){{
            cost = 0.8f;
            hardness = 2;
            healthScaling = 0.4f;
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
            radioactivity = 2f;
        }};
    }
}
