package main.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import main.content.SubzeroFalloutItems;
import main.content.SubzeroFalloutLiquids;
import mindustry.*;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.UnitTypes;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class SubzeroFalloutBlocks {
    public static Block
    //TYR
        //Tyr Cores
    coreRampart,
        //Tyr Crafting
    carbonicExtractor, ferrumSmelter,
        //Tyr Production
        //Tyr Transport
    bulkDriver,
        //Tyr Power
    windmill, capacitor, thermalSiphon,
        //Tyr Heat
    carbonHeater,
        //Tyr Units
    rapidAssembler, supportAssembler, specialistAssembler,
        //Tyr Payload
        //Tyr Defense
        //Tyr Walls
        //Tyr Turrets
    spear, sc1
    //ALTECORIS
    ;
    public static void load(){
        coreRampart = new CoreBlock("core-rampart"){{
            requirements(Category.effect, with(Items.graphite, 500, Items.silicon, 800, Items.beryllium, 500));
            size = 3;
            isFirstTier = true;
            unitType = UnitTypes.poly;
            health = 2500;
            itemCapacity = 1000;
            armor = 5f;
            incinerateNonBuildable = true;
            requiresCoreZone = true;
            buildCostMultiplier = 0.7f;
            unitCapModifier = 10;
            researchCostMultiplier = 0.06f;
        }};

        carbonicExtractor = new AttributeCrafter("carbonic-extractor"){{
           requirements(Category.crafting, with(Items.graphite, 50));
           size = 3;
           attribute = Attribute.steam;
           minEfficiency = 9f - 0.0001f;
           baseEfficiency = 0f;
           displayEfficiency = false;
           craftTime = 120f;
           hasLiquids = true;
           boostScale = 1f / 9f;
           itemCapacity = 0;
           outputLiquid = new LiquidStack(SubzeroFalloutLiquids.carbon, 30f / 60f);
           consumePower(2.5f);
           liquidCapacity = 60f;
           ambientSound = Sounds.loopHum;
           ambientSoundVolume = 0.06f;
        }};

        ferrumSmelter = new HeatCrafter("ferrum-smelter"){{
            requirements(Category.crafting, with(Items.graphite, 50));
            size = 3;
            itemCapacity = 25;
            heatRequirement = 5f;
            craftTime = 60f * 2f;
            liquidCapacity = 80f * 5;
            outputItem = new ItemStack(SubzeroFalloutItems.iron, 1);
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.9f;
        }};

        bulkDriver = new MassDriver("bulk-driver"){{

        }};

        windmill = new MassDriver("windmill"){{

        }};

        capacitor = new Battery("capacitor"){{

        }};

        thermalSiphon = new ThermalGenerator("thermal-siphon"){{

        }};

        carbonHeater = new HeatProducer("carbon-heater"){{

        }};

        rapidAssembler = new UnitFactory("rapid-assembler"){{

        }};

        supportAssembler = new UnitFactory("support-assembler"){{

        }};

        specialistAssembler = new UnitFactory("specialist-assembler"){{

        }};
    }

}
