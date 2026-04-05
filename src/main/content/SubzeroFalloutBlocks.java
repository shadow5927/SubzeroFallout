package main.content;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
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
            unitType = SubzeroFalloutUnits.enkindle;
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
            consumeItem(Items.silicon, 3);
            outputItem = new ItemStack(SubzeroFalloutItems.iron, 1);
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.9f;
        }};

        bulkDriver = new MassDriver("bulk-driver"){{
            requirements(Category.distribution, with(Items.graphite, 50));
            size = 2;
            itemCapacity = 100;
            reload = 150f;
            range = 300f;
            consumePower(1.5f);
        }};

        windmill = new SolarGenerator("windmill"){{
            requirements(Category.power, with(Items.graphite, 50));
            size = 2;
            powerProduction = 1.5f / 6f;
        }};

        capacitor = new Battery("capacitor"){{
            requirements(Category.power, with(Items.graphite, 50));
            size = 2;
            consumePowerBuffered(7500f);
            consumePower(0.5f);
            baseExplosiveness = 2.5f;
        }};

        thermalSiphon = new ThermalGenerator("thermal-siphon"){{
            requirements(Category.power, with(Items.graphite, 50));
            size = 3;
            powerProduction = 2f;
            floating = true;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.04f;
        }};

        carbonHeater = new HeatProducer("carbon-heater"){{
            requirements(Category.crafting, with(Items.graphite, 50));
            size = 2;
            liquidCapacity = 10f;
            heatOutput = 2.5f;
            craftTime = 60f * 9f;
            ambientSound = Sounds.loopHum;
            consumeLiquid(SubzeroFalloutLiquids.carbon, 4f / 60f);
        }};

        rapidAssembler = new UnitFactory("rapid-assembler"){{
            requirements(Category.units, with(Items.graphite, 50));
            plans = Seq.with(
                    new UnitPlan(SubzeroFalloutUnits.flare, 60f * 40, with(Items.silicon, 40, SubzeroFalloutItems.iron, 50)),
                    new UnitPlan(SubzeroFalloutUnits.delta, 60f * 20, with(Items.silicon, 50, Items.graphite, 30)),
                    new UnitPlan(SubzeroFalloutUnits.sickle, 60f * 50, with(Items.silicon, 30, SubzeroFalloutItems.iron, 60, Items.graphite, 20))
            );
            consumePower(1.5f);
            size = 4;
        }};

        supportAssembler = new UnitFactory("support-assembler"){{
            requirements(Category.units, with(Items.graphite, 50));
            plans = Seq.with(
                    new UnitPlan(SubzeroFalloutUnits.nerve, 60f * 50, with(Items.silicon, 70, Items.graphite, 30))
            );
            consumePower(1.5f);
            size = 4;
        }};

        specialistAssembler = new UnitFactory("specialist-assembler"){{
            requirements(Category.units, with(Items.graphite, 50));
            plans = Seq.with(
            );
            consumePower(1.5f);
            size = 4;
        }};

        spear = new PowerTurret("spear"){{
            requirements(Category.turret, with(Items.graphite, 50));
            size = 3;
            shootType = new LaserBulletType(140){{
                colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.black};
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);

                buildingDamageMultiplier = 0.25f;
                hitEffect = Fx.hitLancer;
                hitSize = 4;
                lifetime = 16f;
                drawSize = 400f;
                pierceBuilding = true;
                length = 173f;
                ammoMultiplier = 1f;
                pierceCap = 4;
            }};
            shootWarmupSpeed = 0.08f;
            range = 165f;
            scaledHealth = 420;
            recoil = 3f;
            reload = 80f;
            shake = 2f;
            shootEffect = Fx.lancerLaserShoot;
            smokeEffect = Fx.none;
            heatColor = Color.red;
            chargeSound = Sounds.chargeLancer;
            shootSound = Sounds.shootLancer;
        }};

        sc1 = new ItemTurret("sc-1"){{
            requirements(Category.turret, with(Items.graphite, 50));
            size = 3;
            ammo(
                Items.thorium, new ArtilleryBulletType(6f, 350, "shell"){{
                hitEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
                despawnEffect = Fx.none;
                knockback = 2f;
                lifetime = 140f;
                height = 19f;
                width = 17f;
                splashDamageRadius = 20f;
                splashDamage = 350f;
                scaledSplashDamage = true;
                backColor = hitColor = trailColor = Color.valueOf("fffd8b").lerp(Pal.redLight, 0.5f);
                frontColor = Color.white;
                ammoMultiplier = 1f;
                hitSound = Sounds.explosionTitan;

                status = StatusEffects.slow;
                statusDuration = 100f;

                trailLength = 32;
                trailWidth = 3.35f;
                trailSinScl = 2.5f;
                trailSinMag = 0.5f;
                trailEffect = Fx.none;
                despawnShake = 7f;
                shootEffect = Fx.shootTitan;
                smokeEffect = Fx.shootSmokeTitan;
                trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
                shrinkX = 0.2f;
                shrinkY = 0.1f;
                buildingDamageMultiplier = 0.3f;
            }});
            shootSound = Sounds.shootTank;
            ammoPerShot = 4;
            maxAmmo = ammoPerShot * 3;
            shake = 4f;
            recoil = 1f;
            reload = 60f * 2.3f;
            shootY = 7f;
            rotateSpeed = 1.4f;
            minWarmup = 0.85f;
            newTargetInterval = 40f;
            warmupMaintainTime = 120f;
            shootWarmupSpeed = 0.08f;
            outlineColor = Pal.darkOutline;
            consumeLiquid(Liquids.hydrogen, 5f / 60f);
            scaledHealth = 250;
            range = 390f;
            size = 4;
        }};
    }

}
