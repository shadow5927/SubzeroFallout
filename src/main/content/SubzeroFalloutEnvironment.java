package main.content;

import mindustry.world.blocks.defense.Wall;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.type.Category;
import mindustry.graphics.CacheLayer;
import mindustry.content.Fx;
import arc.graphics.Color;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.BuildVisibility;

public class SubzeroFalloutEnvironment {
    public static Floor
    //TYR
    //Volcanic Masses
    hearthStone, obsidian, denseObsidian, //primordialStone, carbonChar, ash,
    //ALTECORIS
    //Haphazard Icelands
    irradiatedIce, dolomite, smoothDolomite,
    //Irradiated Wastes
    irradiatedSnow, greenschist,// quicksilverStone, snowyDirt,
    //Mountain Peaks
    //tyrianStone, onyxStone, coreSlag,
    //Shinelands
    //opalStone, shimmer,
    //Dormant Forest
    //blackIce,
    //Legion Refinery/Armory
    ruinedCoreZone//fortressPlating, ruinedFortressPlating, tyrianPanels
    ;
    public static Block
    hearthStoneWall, obsidianWall, //primordialStoneWall, ashWall,
    irradiatedIceWall, dolomiteWall,
    irradiatedSnowWall, greenschistWall //quicksilverStoneWall,
    //tyrianStoneWall, onyxStoneWall,
    //opalStoneWall,
    //blackIceWall,
    //fortressWall, ruinedFortressWall, tyrianPanelWall, forceWall
    ;
    public static void load(){
        hearthStone = new Floor("hearth-stone"){{
            variants = 4;
            attributes.set(Attribute.water, -1f);
        }};
        obsidian = new Floor("obsidian"){{
            variants = 4;
            itemDrop = SubzeroFalloutItems.obsidianShard;
            playerUnmineable = true;
            attributes.set(Attribute.water, -1f);
        }};
        denseObsidian = new Floor("dense-obsidian"){{
            variants = 4;
            itemDrop = SubzeroFalloutItems.obsidianShard;
            playerUnmineable = true;
            attributes.set(Attribute.water, -1f);
        }};
        irradiatedIce = new Floor("irradiated-ice"){{
            variants = 4;
            dragMultiplier = 0.35f;
            speedMultiplier = 0.9f;
            attributes.set(Attribute.water, 0.4f);
            albedo = 0.65f;
        }};
        irradiatedSnow = new Floor("irradiated-snow"){{
            variants = 4;
            attributes.set(Attribute.water, 0.2f);
            albedo = 0.7f;
        }};
        greenschist = new Floor("greenschist"){{
            variants = 3;
        }};
        dolomite = new Floor("dolomite-stone"){{
            variants = 4;
        }};
        smoothDolomite = new Floor("smooth-dolomite"){{
            variants = 4;
            dragMultiplier = 0.05f;
        }};
        ruinedCoreZone = new Floor("ruined-core-zone"){{
            variants = 3;
            allowCorePlacement = false;
        }};

        hearthStoneWall = new StaticWall("hearth-stone-wall"){{
            variants = 4;
            hearthStone.asFloor().wall = this;
            attributes.set(Attribute.sand, 1f);
        }};
        obsidianWall = new StaticWall("obsidian-wall"){{
            variants = 3;
            obsidian.asFloor().wall = denseObsidian.asFloor().wall = this;
            itemDrop = SubzeroFalloutItems.obsidian;
        }};
        irradiatedIceWall = new StaticWall("irradiated-ice-wall"){{
            variants = 4;
            irradiatedIce.asFloor().wall = this;
        }};
        irradiatedSnowWall = new StaticWall("irradiated-snow-wall"){{
            variants = 4;
            irradiatedSnow.asFloor().wall = this;
        }};
        greenschistWall = new StaticWall("greenschist-wall"){{
            variants = 3;
            greenschist.asFloor().wall = this;
        }};
        dolomiteWall = new StaticWall("dolomite-stone-wall"){{
            variants = 4;
            dolomite.asFloor().wall = smoothDolomite.asFloor().wall = this;
        }};
    }
}
