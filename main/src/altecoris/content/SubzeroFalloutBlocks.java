package main.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
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
    carbonicExtractor, ferrumSmelter, compressedElectrolyzer, reactionChamber, titaniumGasFurnace, heavyForge,
        //Tyr Production
    incisionBore,
        //Tyr Distribution
    pulseDuct, //bulkDriver,
        //Tyr Liquid
    reinforcedPulseConduit,
        //Tyr Power
    capacitor, thermalSiphon,
        //Tyr Heat
    carbonHeater,
        //Tyr Units
    //rapidAssembler, supportAssembler, specialistAssembler, deltaPad
        //Tyr Payload
        //Tyr Defense
        //Tyr Walls
    ironWall, ironWallLarge, platedTitaniumWall, platedTitaniumWallLarge,
        //Tyr Turrets
    spear, sc1
    //ALTECORIS
    ;
    public static void load(){
        coreRampart = new CoreBlock("core-rampart"){{
            requirements(Category.effect, with(Items.graphite, 700, Items.silicon, 500, Items.beryllium, 700));
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
           boostScale = 1f/9f;
           itemCapacity = 0;
            liquidCapacity = 60f;
           consumePower(2.5f);
           outputLiquid = new LiquidStack(SubzeroFalloutLiquids.carbon, 12f / 60f);
           ambientSound = Sounds.loopExtract;
           ambientSoundVolume = 0.2f;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(SubzeroFalloutLiquids.carbon, 4.1f), new DrawDefault(), new DrawHeatInput());
        }};

        ferrumSmelter = new HeatCrafter("ferrum-smelter"){{
            requirements(Category.crafting, with(Items.beryllium, 200, Items.graphite, 60, Items.silicon, 100));
            size = 4;
            itemCapacity = 10;
            heatRequirement = 5f;
            maxEfficiency = 1f;
            consumePower(4f);
            consumeItem(SubzeroFalloutItems.haematite, 4);
            consumeLiquid(SubzeroFalloutLiquids.carbon, 3f/60f);
            outputItem = new ItemStack(SubzeroFalloutItems.iron, 3);
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.3f;
            craftTime = 75f;
            craftEffect = new RadialEffect(Fx.surgeCruciSmoke, 4, 90f, 8f); new MultiEffect(Fx.massiveExplosion);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawCrucibleFlame(), new DrawDefault(), new DrawHeatInput(), new DrawFlame(Color.valueOf("ffc499")));
        }};

        compressedElectrolyzer = new GenericCrafter("compressed-electrolyzer"){{
            requirements(Category.crafting, with(Items.beryllium, 70, Items.graphite, 20, Items.silicon, 25));
            group = BlockGroup.liquids;
            size = 2;
            rotate = true;
            invertFlip = true;
            itemCapacity = 0;
            liquidCapacity = 50f;
            consumePower(0.5f);
            consumeLiquid(Liquids.water, 5f/60f);
            ambientSound = Sounds.loopElectricHum;
            ambientSoundVolume = 0.08f;
            regionRotated1 = 3;
            outputLiquids = LiquidStack.with(Liquids.ozone, 2f / 60, Liquids.hydrogen, 3f / 60);
            liquidOutputDirections = new int[]{1, 3};

            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(Liquids.water, 2f),
                    new DrawBubbles(Color.valueOf("7693e3")){{
                        sides = 10;
                        recurrence = 3f;
                        spread = 6;
                        radius = 1.5f;
                        amount = 20;
                    }},
                    new DrawRegion(),
                    new DrawLiquidOutputs(),
                    new DrawGlowRegion(){{
                        alpha = 0.7f;
                        color = Color.valueOf("c4bdf3");
                        glowIntensity = 0.3f;
                        glowScale = 6f;
                    }}
            );
        }};

        reactionChamber = new HeatProducer("reaction-chamber"){{
            requirements(Category.crafting, with(SubzeroFalloutItems.iron, 300, SubzeroFalloutItems.obsidianShard, 80, Items.graphite, 80, Items.silicon, 150));
            size = 4;
            hasLiquids = true;
            outputItem = new ItemStack(Items.oxide, 2);
            researchCostMultiplier = 1.1f;
            consumeLiquid(Liquids.ozone, 8f/60f);
            consumeItem(Items.beryllium, 3);
            consumePower(2f);
            rotateDraw = false;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidRegion(), new DrawDefault(), new DrawHeatOutput());
            ambientSound = Sounds.loopExtract;
            ambientSoundVolume = 0.08f;
            regionRotated1 = 2;
            craftTime = 60f * 2f;
            liquidCapacity = 100f;
            heatOutput = 10f;
        }};

        titaniumGasFurnace = new GenericCrafter("titanium-gas-furnace"){{
            requirements(Category.crafting, with(SubzeroFalloutItems.iron, 200, Items.silicon, 80, Items.oxide, 40));
            size = 3;
            hasLiquids = true;
            outputItem = new ItemStack(Items.titanium, 3);
            outputLiquid = new LiquidStack(Liquids.ozone, 4f/60f);
            researchCostMultiplier = 1.1f;
            consumeLiquids(LiquidStack.with(SubzeroFalloutLiquids.carbon, 4f/60f, Liquids.hydrogen, 1.5f/60f));
            consumeItem(SubzeroFalloutItems.rutileCluster, 6);
            consumePower(2f);
        }};

        heavyForge = new AttributeCrafter("heavy-forge"){{
            requirements(Category.crafting, with(Items.silicon, 100, Items.titanium, 180, Items.graphite, 60, Items.oxide, 60, SubzeroFalloutItems.vanadium, 60));
            size = 6;
            hasLiquids = true;
            outputItem = new ItemStack(SubzeroFalloutItems.heavyPlating, 6);
            researchCostMultiplier = 1.1f;
            boostScale = 0.15f;
            craftTime = 60f * 5f;
            consumeLiquid(Liquids.ozone, 6f/60);
            consumeItems(with(SubzeroFalloutItems.iron, 6, Items.silicon, 2, SubzeroFalloutItems.vanadium, 2));
            consumePower(4f);
        }};

        incisionBore = new BeamDrill("incision-bore"){{
            requirements(Category.production, with(SubzeroFalloutItems.iron, 100, Items.beryllium, 50, Items.silicon, 50, Items.oxide, 25));
            size = 3;
            tier = 5;
            range = 4;
            laserWidth = 0.7f;
            itemCapacity = 20;
            liquidCapacity = 10f;
            drillTime = 120f;
            consumePower(0.5f);
            consumeLiquid(Liquids.hydrogen, 0.75f/60f);

        }};

        pulseDuct = new Duct("pulse-duct"){{
            requirements(Category.distribution, with(Items.beryllium, 2, Items.titanium, 1));
            health = 180;
            speed = 8f;
            armored = true;
            researchCost = with(Items.beryllium, 200, Items.titanium, 100);
        }};

        //bulkDriver = new MassDriver("bulk-driver"){{
        //    requirements(Category.distribution, with(Items.graphite, 50));
        //    size = 2;
        //    itemCapacity = 100;
        //    reload = 150f;
        //    range = 300f;
        //    consumePower(1.5f);
        //}};

        reinforcedPulseConduit = new ArmoredConduit("reinforced-pulse-conduit"){{
            requirements(Category.liquid, with(SubzeroFalloutItems.obsidianShard, 1, Items.titanium, 1));
            botColor = Pal.darkestMetal;
            leaks = false;
            liquidCapacity = 65f;
            liquidPressure = 1.05f;
            health = 300;
            researchCostMultiplier = 3;
            underBullets = true;
            explosivenessScale = flammabilityScale = 20f/50f;
        }};

        capacitor = new Battery("capacitor"){{
            requirements(Category.power, with(Items.oxide, 5, SubzeroFalloutItems.arsenic, 5, Items.graphite, 60, Items.silicon, 60));
            size = 2;
            consumePowerBuffered(10000f);
            baseExplosiveness = 2.5f;
        }};

        thermalSiphon = new ThermalGenerator("thermal-siphon"){{
            requirements(Category.power, with(Items.titanium, 60, Items.graphite, 40, SubzeroFalloutItems.arsenic, 20,Items.oxide, 40));
            size = 3;
            powerProduction = 2f;
            floating = true;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.04f;
        }};

        carbonHeater = new HeatProducer("carbon-heater"){{
            requirements(Category.crafting, with(Items.graphite, 30, Items.silicon, 30, Items.beryllium, 60));
            size = 2;
            liquidCapacity = 10f;
            heatOutput = 2.5f;
            craftTime = 60f * 9f;
            ambientSound = Sounds.loopHum;
            consumeLiquid(SubzeroFalloutLiquids.carbon, 1.5f / 60f);
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
            health = 175 * 4;
            armor = 8f;
            researchCostMultiplier = 0.1f;
        }};

        ironWallLarge = new Wall("iron-wall-large"){{
            requirements(Category.defense, with(SubzeroFalloutItems.iron, 32));
            health = 175 * 4 * 4;
            armor = 8f;
            size = 2;
            researchCostMultiplier = 0.1f;
        }};

        platedTitaniumWall = new Wall("plated-titanium-wall"){{
            requirements(Category.defense, with(Items.titanium, 8, SubzeroFalloutItems.vanadium, 2));
            health = 225 * 4;
            armor = 12f;
            researchCostMultiplier = 0.1f;

        }};

        platedTitaniumWallLarge = new Wall("plated-titanium-wall-large"){{
            requirements(Category.defense, with(Items.titanium, 32, SubzeroFalloutItems.vanadium, 8));
            health = 225 * 4 * 4;
            armor = 12f;
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
                chargeEffect = new MultiEffect(SubzeroFalloutFx.spearCharge, Fx.lancerLaserChargeBegin);
                hitColor = Color.valueOf("8aa3f4");
                hitSound = Sounds.explosionAfflict;
                sprite = "large-orb";
                trailEffect = Fx.missileTrail;
                trailInterval = 3f;
                trailParam = 3f;
                buildingDamageMultiplier = 0.5f;
                predictTarget = true;
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
            shootEffect = Fx.shootBig;
            ammoPerShot = 2;
            maxAmmo = 10;
            shake = 4f;
            recoil = 3f;
            reload = 240f;
            shootY = 7f;
            rotateSpeed = 1.6f;
            minWarmup = 0.85f;
            newTargetInterval = 40f;
            warmupMaintainTime = 120f;
            shootWarmupSpeed = 0.08f;
            outlineColor = Pal.darkOutline;
            consumeLiquid(Liquids.hydrogen, 5f / 60f);
            scaledHealth = 250f;
            range = 390f;
            ammo(
                Items.graphite, new BasicBulletType(10f, 60, "shell"){{
                    hitEffect = new MultiEffect(SubzeroFalloutFx.scExplosion, Fx.titanLightSmall, new WaveEffect() {{
                        lifetime = 8f;
                        strokeFrom = 1f;
                        sizeTo = 12f;
                    }});
                    despawnSound = hitSound = Sounds.explosionDull;
                    despawnEffect = Fx.hitBulletColor;
                    width = 8f;
                    height = 12f;
                    lifetime = 38f;
                    pierceCap = 2;
                    knockback = 1.5f;
                    splashDamageRadius = 32f;
                    splashDamage = 150f;
                    scaledSplashDamage = true;
                    pierceArmor = true;
                    status = SubzeroFalloutStatusEffects.crippled;
                    statusDuration = 150f;
                    backColor = hitColor = trailColor = Pal.graphiteAmmoBack;
                    frontColor = Color.white;
                    buildingDamageMultiplier = 0.25f;
                    shrinkY = 0.3f;
                    trailLength = 12;
                    trailWidth = 2f;
                }},
                Items.silicon, new BasicBulletType(10f, 125, "shell"){{
                    hitEffect = new MultiEffect(Fx.titanLightSmall, Fx.shieldWave, new WaveEffect() {{
                            lifetime = 8f;
                            strokeFrom = 1f;
                            sizeTo = 12f;
                    }});
                    despawnSound = hitSound = Sounds.explosionDull;
                    despawnEffect = Fx.hitBulletColor;
                    width = 8f;
                    height = 12f;
                    lifetime = 38f;
                    splashDamageRadius = 8f;
                    splashDamage = 50f;
                    scaledSplashDamage = true;
                    reloadMultiplier = 1.33f;
                    pierceArmor = true;
                    homingPower = 0.2f;
                    backColor = hitColor = trailColor = Pal.siliconAmmoBack;
                    frontColor = Color.white;
                    buildingDamageMultiplier = 0.25f;
                    shrinkY = 0.3f;
                    trailEffect = Fx.artilleryTrail;
                    trailInterval = 1f;
                    trailLength = 12;
                    trailWidth = 2f;
                }},
                Items.surgeAlloy, new BasicBulletType(10f, 160, "shell"){{
                    float rad = 100f;
                    hitEffect = new Effect(50f, 100f, e -> {
                        e.scaled(7f, b -> {
                            color(Pal.heal, b.fout());
                            Fill.circle(e.x, e.y, rad);
                        });

                        color(Pal.surgeAmmoBack);
                        stroke(e.fout() * 3f);
                        Lines.circle(e.x, e.y, rad);

                        int points = 10;
                        float offset = Mathf.randomSeed(e.id, 360f);
                        for(int i = 0; i < points; i++){
                            float angle = i* 360f / points + offset;
                            //for(int s : Mathf.zeroOne){
                            Drawf.tri(e.x + Angles.trnsx(angle, rad), e.y + Angles.trnsy(angle, rad), 6f, 50f * e.fout(), angle/* + s*180f*/);
                            //}
                        }

                        Fill.circle(e.x, e.y, 12f * e.fout());
                        color();
                        Fill.circle(e.x, e.y, 6f * e.fout());
                        Drawf.light(e.x, e.y, rad * 1.6f, Pal.heal, e.fout());
                    });
                    despawnSound = hitSound = Sounds.explosionDull;
                    despawnEffect = Fx.hitBulletColor;
                    width = 8f;
                    height = 12f;
                    lifetime = 38f;
                    splashDamageRadius = 8f;
                    splashDamage = 60f;
                    scaledSplashDamage = true;
                    pierceArmor = true;
                    status = StatusEffects.shocked;
                    statusDuration = 150f;
                    backColor = hitColor = trailColor = Pal.surgeAmmoBack;
                    frontColor = Color.white;
                    buildingDamageMultiplier = 0.25f;
                    shrinkY = 0.3f;
                    trailRotation = true;
                    trailEffect = Fx.disperseTrail;
                    trailInterval = 2f;
                    trailLength = 12;
                    trailWidth = 2f;
                    fragBullets = 12;
                    fragBullet = new LightningBulletType(){{
                        damage = 30;
                        collidesAir = false;
                        ammoMultiplier = 1f;
                        lightningColor = Pal.accent;
                        lightningLength = 4;
                        lightningLengthRand = 7;
                    }};
                }});
            drawer = new DrawTurret("reinforced-"){{
                parts.addAll(
                new RegionPart("-barrel"){{
                    progress = PartProgress.recoil.curve(Interp.pow2In);
                    moveY = -3.85f * 3f / 2f;
                    heatColor = Color.valueOf("f03b0e");
                    mirror = false;
                    under = true;
                }},
                new RegionPart("-side"){{
                    heatProgress = PartProgress.warmup;
                    progress = PartProgress.warmup;
                    mirror = true;
                    moveX = 0.5f;
                    under = true;
                    heatColor = Color.valueOf("f03b0e");
                    moves.add(new PartMove(PartProgress.recoil, 0f,-1f,0f));
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
