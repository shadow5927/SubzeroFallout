package main.content;

import arc.graphics.*;
import arc.graphics.g2d.Lines;
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

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.stroke;
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
    //bulkDriver,
        //Tyr Power
    //windmill, capacitor, thermalSiphon,
        //Tyr Heat
    carbonHeater,
        //Tyr Units
    //rapidAssembler, supportAssembler, specialistAssembler,
        //Tyr Payload
        //Tyr Defense
        //Tyr Walls
    ironWall, ironWallLarge,
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
            squareSprite = false;
            buildCostMultiplier = 0.7f;
            unitCapModifier = 10;
            researchCostMultiplier = 0.06f;
        }};

        carbonicExtractor = new AttributeCrafter("carbonic-extractor"){{
           requirements(Category.crafting, with(Items.beryllium, 70, SubzeroFalloutItems.obsidianShard, 40, Items.silicon, 70));
           size = 3;
           attribute = Attribute.steam;
           minEfficiency = 9f - 0.0001f;
           baseEfficiency = 0f;
           displayEfficiency = false;
           craftTime = 120f;
           hasLiquids = true;
           boostScale = 1f / 9f;
           itemCapacity = 0;
           outputLiquid = new LiquidStack(SubzeroFalloutLiquids.carbon, 22f / 60f);
           consumePower(2.5f);
           liquidCapacity = 60f;
           ambientSound = Sounds.loopExtract;
           ambientSoundVolume = 0.06f;
        }};

        ferrumSmelter = new HeatCrafter("ferrum-smelter"){{
            requirements(Category.crafting, with(Items.beryllium, 100, Items.graphite, 60));
            size = 4;
            itemCapacity = 10;
            heatRequirement = 5f;
            maxEfficiency = 1f;
            craftTime = 60f * 1f;
            consumeItem(SubzeroFalloutItems.haematite, 4);
            consumeLiquid(SubzeroFalloutLiquids.carbon, 3f / 60f);
            outputItem = new ItemStack(SubzeroFalloutItems.iron, 2);
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.7f;
        }};

        //bulkDriver = new MassDriver("bulk-driver"){{
        //    requirements(Category.distribution, with(Items.graphite, 50));
        //    size = 2;
        //    itemCapacity = 100;
        //    reload = 150f;
        //    range = 300f;
        //    consumePower(1.5f);
        //}};

        //windmill = new SolarGenerator("windmill"){{
        //    requirements(Category.power, with(Items.graphite, 50));
        //    size = 2;
        //    powerProduction = 1.5f / 6f;
        //}};

        //capacitor = new Battery("capacitor"){{
        //    requirements(Category.power, with(Items.graphite, 50));
        //    size = 2;
        //    consumePowerBuffered(7500f);
        //    consumePower(0.5f);
        //    baseExplosiveness = 2.5f;
        //}};

        //thermalSiphon = new ThermalGenerator("thermal-siphon"){{
        //    requirements(Category.power, with(Items.graphite, 50));
        //    size = 3;
        //    powerProduction = 2f;
        //    floating = true;
        //    ambientSound = Sounds.loopHum;
        //    ambientSoundVolume = 0.04f;
        //}};

        carbonHeater = new HeatProducer("carbon-heater"){{
            requirements(Category.crafting, with(Items.graphite, 30, Items.silicon, 30, Items.beryllium, 60));
            size = 2;
            liquidCapacity = 10f;
            heatOutput = 2.5f;
            craftTime = 60f * 9f;
            ambientSound = Sounds.loopHum;
            consumeLiquid(SubzeroFalloutLiquids.carbon, 4f / 60f);
        }};

        //rapidAssembler = new UnitFactory("rapid-assembler"){{
        //    requirements(Category.units, with(Items.graphite, 50));
        //    plans = Seq.with(
        //            new UnitPlan(SubzeroFalloutUnits.flare, 60f * 40, with(Items.silicon, 40, SubzeroFalloutItems.iron, 50)),
        //            new UnitPlan(SubzeroFalloutUnits.delta, 60f * 20, with(Items.silicon, 50, Items.graphite, 30)),
        //            new UnitPlan(SubzeroFalloutUnits.sickle, 60f * 50, with(Items.silicon, 30, SubzeroFalloutItems.iron, 60, Items.graphite, 20))
        //    );
        //    consumePower(1.5f);
        //    size = 4;
        //}};

        //supportAssembler = new UnitFactory("support-assembler"){{
        //    requirements(Category.units, with(Items.graphite, 50));
        //    plans = Seq.with(
        //            new UnitPlan(SubzeroFalloutUnits.nerve, 60f * 50, with(Items.silicon, 70, Items.graphite, 30))
        //    );
        //    consumePower(1.5f);
        //    size = 4;
        //}};

        //specialistAssembler = new UnitFactory("specialist-assembler"){{
        //    requirements(Category.units, with(Items.graphite, 50));
        //    plans = Seq.with(
        //    );
        //    consumePower(1.5f);
        //    size = 4;
        //}};

        ironWall = new Wall("iron-wall"){{
            requirements(Category.defense, with(SubzeroFalloutItems.iron, 8));
            health = 150 * 4;
            armor = 8f;
            researchCostMultiplier = 0.1f;
        }};

        ironWallLarge = new Wall("iron-wall-large"){{
            requirements(Category.defense, with(SubzeroFalloutItems.iron, 32));
            health = 150 * 4 * 4;
            armor = 8f;
            size = 2;
            researchCostMultiplier = 0.1f;
        }};

        spear = new PowerTurret("spear"){{
            requirements(Category.turret, with(Items.graphite, 85, Items.silicon, 170, SubzeroFalloutItems.iron, 90));
            size = 3;
            recoil = 2f;
            reload = 100f;
            shake = 1f;
            shootY = -1f;
            range = 138f;
            shootEffect = SubzeroFalloutFx.spearLaserShoot;
            smokeEffect = Fx.colorSparkBig;
            heatColor = Color.blue;
            scaledHealth = 230;
            targetAir = false;
            predictTarget = true;
            moveWhileCharging = true;
            accurateDelay = false;
            shootSound = Sounds.shootLancer;
            coolant = consume(new ConsumeLiquid(Liquids.water, 15f / 60f));
            chargeSound = Sounds.chargeLancer;
            shootWarmupSpeed = 0.07f;
            shoot.firstShotDelay = 40f;

            consumePower(6f);

            shootType = new BasicBulletType(){{
                chargeEffect = new MultiEffect(Fx.lancerLaserCharge, Fx.lancerLaserChargeBegin);
                hitColor = Color.valueOf("8aa3f4");
                hitSound = Sounds.explosionAfflict;
                sprite = "large-orb";
                trailEffect = Fx.missileTrail;
                trailInterval = 3f;
                trailParam = 3f;
                buildingDamageMultiplier = 0.5f;
                fragOnHit = true;
                speed = 5.6f;
                damage = 50f;
                lifetime = 50f;
                width = height = 16f;
                backColor = Color.valueOf("6974c4");
                frontColor = Color.white;
                shrinkX = shrinkY = 0f;
                trailColor = Color.valueOf("8aa3f4");
                trailLength = 12;
                trailWidth = 2.2f;
                drag = 0.03f;
                fragBullets = 4;
                fragRandomSpread = 0f;
                fragSpread = 90f;

                despawnEffect = hitEffect = new MultiEffect(Fx.shootSmallColor, new Effect(11, e -> {
                    e.color = Color.valueOf("8aa3f4");
                    color(Color.white, e.color, e.fin());
                    stroke(0.9f + e.fout());
                    Lines.square(e.x, e.y, e.fin() * 20f, e.rotation + 45f);

                    Drawf.light(e.x, e.y, 25f, e.color, e.fout() * 0.7f);
                }));
                despawnSound = Sounds.explosionAfflict;
                shootSound = Sounds.shootLancer;
                fragBullet = new LaserBulletType(40f){{
                    colors = new Color[]{Color.valueOf("8aa3f4").cpy().a(0.4f), Color.valueOf("8aa3f4"), Color.white};

                    pierceArmor = true;
                    buildingDamageMultiplier = 0.25f;
                    hitEffect = Fx.hitLancer;
                    hitSize = 4;
                    fragOffsetMax = 0f;
                    fragOffsetMin = 0f;
                    lifetime = 16f;
                    drawSize = 400f;
                    pierceBuilding = true;
                    length = 96f;
                    ammoMultiplier = 1f;
                    pierceCap = 4;
                }};
            }};
            drawer = new DrawTurret("reinforced-"){{
                parts.add(new RegionPart("-blade"){{
                            progress = PartProgress.warmup;
                            heatProgress = PartProgress.warmup;
                            heatColor = Color.valueOf("8aa3f4").cpy().a(0.9f);
                            under = true;
                            mirror = true;
                            moveX = 1.7f;
                            moveY = -1f;
                            moveRot = 5f;
                            moves.add(new PartMove(PartProgress.recoil, 1f, -0.5f, -5f));
                          }},
                        new RegionPart("-mid"){{
                            under = true;
                            moveY = -1f;
                            progress = PartProgress.recoil;
                            heatProgress = PartProgress.recoil.add(0.25f).min(PartProgress.warmup);
                            heatColor = Color.valueOf("8aa3f4").cpy().a(0.9f);
                        }},
                        new RegionPart("-spine"){{
                            progress = PartProgress.warmup;
                            heatProgress = PartProgress.warmup;
                            under = true;
                            mirror = true;
                            outline = false;
                            layerOffset = -0.3f;
                            turretHeatLayer = Layer.turret - 0.2f;
                            color = heatColor = Color.valueOf("6974c4");
                            moveY = -4.5f;
                            moveX = 2f;
                            moveRot = 9f;
                            moves.add(new PartMove(PartProgress.recoil, 1f,-1f,-5f));
                        }}
                );
            }};
        }};

        sc1 = new ItemTurret("sc-1"){{
            requirements(Category.turret, with(SubzeroFalloutItems.iron, 200, Items.silicon, 150, Items.oxide, 25));
            size = 3;
            shootSound = Sounds.shootTank;
            ammoPerShot = 4;
            maxAmmo = ammoPerShot * 3;
            shake = 4f;
            recoil = 3f;
            reload = 60f;
            shootY = 7f;
            rotateSpeed = 1.4f;
            minWarmup = 0.85f;
            newTargetInterval = 40f;
            warmupMaintainTime = 120f;
            shootWarmupSpeed = 0.08f;
            outlineColor = Pal.darkOutline;
            consumeLiquid(Liquids.hydrogen, 5f / 60f);
            scaledHealth = 250f;
            range = 390f;
            ammo(
                Items.graphite, new BasicBulletType(10f, 108, "shell"){{
                        hitEffect = new MultiEffect(Fx.titanExplosionFrag, Fx.titanLightSmall, new WaveEffect(){{
                            lifetime = 8f;
                            strokeFrom = 1f;
                            sizeTo = 8f;
                        }});

                        despawnEffect = Fx.hitBulletColor;
                        width = 8f;
                        height = 12f;
                        lifetime = 40f;
                        knockback = 0.5f;
                        splashDamageRadius = 22f;
                        splashDamage = 50f;
                        scaledSplashDamage = true;
                        pierceArmor = true;
                        status = StatusEffects.slow;
                        statusDuration = 130f;
                        backColor = frontColor = hitColor = trailColor = Color.valueOf("fffd8b");
                        frontColor = Color.white;
                        buildingDamageMultiplier = 0.25f;
                        shrinkY = 0.3f;
                        trailLength = 12;
                        trailWidth = 2f;
                    }});
            drawer = new DrawTurret("reinforced-"){{
                parts.addAll(
                new RegionPart("-barrel"){{
                    progress = PartProgress.recoil.curve(Interp.pow2In);
                    moveY = -3.85f * 3f / 2f;
                    heatColor = Color.valueOf("f03b0e");
                    mirror = false;
                    under = true;
                    layerOffset = -0.3f;
                }},
                new RegionPart("-side"){{
                    heatProgress = PartProgress.warmup;
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveX = 0.5f;
                    under = true;
                    heatColor = Color.valueOf("f03b0e");
                    moves.add(new PartMove(PartProgress.recoil, 0f,-1.5f,0f));
                }},
                new RegionPart("-front"){{
                    heatProgress = PartProgress.warmup;
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveY = -2f;
                    moveX = 0.5f;
                    heatColor = Color.valueOf("f03b0e");
                }},
                new RegionPart("-rings"){{
                    heatProgress = PartProgress.warmup;
                    under = true;
                    heatColor = Color.valueOf("f03b0e");;
                }});
            }};
    }};
}}
