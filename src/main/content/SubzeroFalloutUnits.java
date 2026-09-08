package main.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class SubzeroFalloutUnits {
    public static UnitType
    //TYR
    enkindle,
    //Rapid
    corona, delta, sickle,
    //Support
    nerve, trident,
    //Specialist
    haze, nox,
    //ALTECORIS

    //LEGION
    proxy, unify
    ;

    public static void load(){
    enkindle = new UnitType("enkindle"){{
        constructor = UnitEntity::create;
        coreUnitDock = true;
        isEnemy = false;
        envDisabled = 0;
        outlineColor = Pal.darkOutline;
        range = 60f;
        faceTarget = true;
        targetPriority = -2;
        lowAltitude = false;
        mineWalls = true;
        mineFloor = false;
        mineHardnessScaling = false;
        flying = true;
        mineSpeed = 6f;
        mineTier = 3;
        buildSpeed = 1f;
        drag = 0.08f;
        speed = 4.3f;
        rotateSpeed = 7f;
        accel = 0.07f;
        itemCapacity = 60;
        health = 250f;
        armor = 1f;
        hitSize = 9f;
        engineSize = 0;
        payloadCapacity = 2f * 2f * tilesize * tilesize;
        pickupUnits = false;
        vulnerableWithPayloads = true;

        fogRadius = 0f;
        targetable = false;
        hittable = false;

        setEnginesMirror(
                new UnitEngine(15 / 4f, -17 / 4f, 2.2f, 300f)
        );

        weapons.add(new RepairBeamWeapon(){{
            widthSinMag = 0.11f;
            reload = 20f;
            x = 0f;
            y = 5f;
            rotate = false;
            shootY = 0f;
            beamWidth = 0.7f;
            repairSpeed = 2.9f;
            fractionRepairSpeed = 0.06f;
            aimDst = 0f;
            shootCone = 15f;
            mirror = false;

            targetUnits = false;
            targetBuildings = true;
            autoTarget = false;
            controllable = true;
            laserColor = Pal.accent;
            healColor = Pal.accent;

            bullet = new BulletType(){{
                maxRange = 60f;
            }};

            drawBuildBeam = false;

            weapons.add(new BuildWeapon("subzerofallout-enkindle-weapon"){{
                rotate = true;
                rotateSpeed = 7f;
                x = 2f;
                y = 1f;
                layerOffset = -0.001f;
                shootY = 3f;
            }});
        }});
    }};

    corona = new TankUnitType("corona"){{
        constructor = TankUnit::create;
        hitSize = 13f;
        range = 60f;
        health = 650;
        armor = 5f;
        itemCapacity = 0;
        rotateSpeed = 3.5f;
        rotateMoveFirst = true;
        speed = 1.2f;
        floorMultiplier = 0.95f;
        immunities.add(StatusEffects.melting);
        treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 55), new Rect(0, 16 - 32f, 14, 25)};
        treadPullOffset = 3;
        researchCostMultiplier = 0f;
        tankMoveVolume *= 0.32f;
        tankMoveSound = Sounds.tankMoveSmall;

        weapons.add(new Weapon("subzerofallout-corona-weapon"){{
            layerOffset = 0.01f;
            showStatSprite = true;
            top = true;
            reload = 60f;
            shootY = 4.5f;
            recoil = 0.5f;
            rotate = true;
            rotateSpeed = 2.5f;
            mirror = false;
            cooldownTime = 30f;
            heatColor = Color.valueOf("f9350f");
            x = 0f;
            y = 0f;
            continuous = alwaysContinuous = true;
            shootSound = Sounds.shootSublimate;
            bullet = new ContinuousFlameBulletType(){{
                damage = 17f;
                length = 60f;
                width = 3f;
                flareLength = 20f;
                knockback = 1f;
                pierceCap = 2;
                timescaleDamage = true;
                shootEffect = Fx.colorSparkBig;
                colors = new Color[]{Color.valueOf("eb7abe").a(0.55f), Color.valueOf("e189f5").a(0.7f), Color.valueOf("907ef7").a(0.8f), Color.valueOf("91a4ff"), Color.white};
            }};
        }});
    }};

    delta = new UnitType("delta"){{
        constructor = MechUnit::create;
        outlineColor = Pal.darkOutline;
        canBoost = true;
        boostMultiplier = 1.5f;
        speed = 0.85f;
        hitSize = 10f;
        health = 720f;
        armor = 4f;

        weapons.add(new Weapon("subzerofallout-delta-weapon"){{
            top = false;
            rotate = false;
            reload = 18f;
            recoil = 1f;
            x = 5f;
            shootY = 4f;
            shoot.shots = 3;
            shoot.shotDelay = 0.5f;
            ejectEffect = Fx.none;
            shootSound = Sounds.shootPulsar;
            bullet = new LightningBulletType(){{
                lightningColor = hitColor = Color.valueOf("5d92cf");
                damage = 20f;
                lightningLength = 9;
                lightningLengthRand = 8;
                followAimSpeed = 9f;
                shootEffect = Fx.colorSpark;
                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    followAimSpeed = 5f;
                    status = StatusEffects.shocked;
                    statusDuration = 10f;
                    hittable = false;
                    collidesTeam = true;
                }};
            }};
        }});
    }};

    sickle = new UnitType("sickle"){{
        constructor = UnitWaterMove::create;
        outlineColor = Pal.darkOutline;
        speed = 1.4f;
        drag = 0.13f;
        hitSize = 10f;
        health = 780f;
        armor = 3f;
        accel = 0.4f;
        rotateSpeed = 3.3f;
        faceTarget = false;
        trailLength = 20;
        waveTrailX = 3f;
        trailScl = 1.3f;
        moveSoundVolume = 0.4f;
        moveSound = Sounds.shipMove;

        immunities = ObjectSet.with(StatusEffects.melting);

        abilities.add(new StatusFieldAbility(SubzeroFalloutStatusEffects.overcharged, 60f * 4, 60f * 12f, 50f));

        weapons.add(new Weapon("subzerofallout-sickle-weapon"){{
            layerOffset = 0.01f;
            top = true;
            mirror = false;
            rotate = true;
            reload = 48f;
            recoil = 1f;
            x = 0f;
            y = -1f;
            shoot.shots = 3;
            shoot.shotDelay = 6f;
            shootSound = Sounds.shootMissile;
            rotationLimit = 120f;
            bullet = new BasicBulletType(4.3f, 20f){{
                sprite = "missile";
                backSprite = "missile-back";
                width = 8f;
                height = 16f;
                lifetime = 60 * 0.496f;
                splashDamageRadius = 35f;
                splashDamage = 30f;
                followAimSpeed = 5f;
                weaveScale = 9f;
                weaveMag = 1f;
                hitColor = backColor = trailColor = Color.valueOf("5d92cf");
                trailWidth = 2f;
                trailLength = 12;
                despawnSound = hitSound = Sounds.explosion;
                hitEffect = despawnEffect = Fx.blastExplosion;
            }};
        }});
    }};

    nerve = new UnitType("nerve"){{
        constructor = UnitEntity::create;
        aiController = DefenderAI::new;
        flying = true;
        lowAltitude = false;
        outlineColor = Pal.darkOutline;
        speed = 2.7f;
        accel = 0.08f;
        drag = 0.06f;
        health = 550f;
        armor = 3f;
        payloadCapacity = 2f * 2f * tilesize * tilesize;
        hitSize = 12.5f;
        itemCapacity = 10;
        targetPriority = -2f;
        faceTarget = false;
        rotateSpeed = 5f;
        wreckSoundVolume = 0.7f;
        moveSound = Sounds.loopHover;
        moveSoundPitchMin = 0.6f;
        moveSoundVolume = 0.2f;
        range = 40f;

        engineOffset = 7f;
        setEnginesMirror(
                new UnitEngine(23 / 4f, -10 / 4f, 2.2f, 300f)
        );

        float orbRad = 3f, partRad = 2f;
        int parts = 10;

        abilities.add(new EnergyFieldAbility(25f, 100f, 40f){{
            sectorRad = 0.1f;
            sectors = 3;
            effectRadius = 0f;
            statusDuration = 60f * 6f;
            maxTargets = 6;
            healPercent = 1.75f;
            sameTypeHealMult = 0.5f;
        }});

        abilities.add(new SuppressionFieldAbility(){{
            color = particleColor = effectColor = Pal.heal;
            orbRadius = orbRad;
            particleSize = partRad;
            y = -1f;
            particles = parts;
            active = false;
        }});
    }};

    trident = new UnitType("trident"){{
        constructor = UnitEntity::create;
        defaultCommand = UnitCommand.rebuildCommand;
        outlineColor = Pal.darkOutline;
        itemCapacity = 30;
        health = 790f;
        armor = 2f;
        mineTier = 2;
        buildSpeed = 2.5f;
        speed = 3.15f;
        accel = 0.1f;
        drag = 0.034f;
        flying = true;
        faceTarget = false;
        circleTarget = true;
        circleTargetRadius = 80f;
        moveSoundVolume = 0.4f;
        moveSound = Sounds.loopHover;
        hitSize = 8.85f;
        engineOffset = 5.75f;
        weapons.add(new Weapon("bomber"){{
            x = 2f;
            y = -2f;
            reload = 15f;
            shoot.shotDelay = 3f;
            shoot.shots = 4;
            alternate = true;
            ejectEffect = Fx.none;
            shootSound = Sounds.shootPayload;
            velocityRnd = 1f;
            inaccuracy = 20f;
            ignoreRotation = true;
            bullet = new BombBulletType(45f, 25f, "shell") {{
                width = 10f;
                height = 14f;
                hitColor = backColor = trailColor = Color.valueOf("a0b380");
                frontColor = Color.valueOf("e4ffd6");
                status = StatusEffects.corroded;
                statusDuration = 60f * 8f;
                hitEffect = despawnEffect = new MultiEffect(Fx.vapor, Fx.flakExplosion);
                shootEffect = Fx.none;
                smokeEffect = Fx.none;
                fragBullets = 1;
                fragBullet = new EmptyBulletType(){{
                    damage = 0f;
                    lifetime = 60f * 1.5f;
                    bulletInterval = 20f;
                    hitEffect = despawnEffect = Fx.none;
                    intervalBullet = new EmptyBulletType(){{
                        splashDamage = 20f;
                        collidesGround = true;
                        collidesAir = false;
                        collides = false;
                        hitEffect = despawnEffect = Fx.none;
                        pierce = true;
                        instantDisappear = true;
                        splashDamageRadius = 15f;
                        buildingDamageMultiplier = 0f;
                    }};
                }};
            }};
        }});
    }};

    haze = new UnitType("haze"){{
        constructor = UnitWaterMove::create;
        outlineColor = Pal.darkOutline;
        health = 960f;
        armor = 7f;
        accel = 0.5f;
        speed = 1.2f;
        rotateSpeed = 4f;
        hitSize = 11f;
        faceTarget = false;
        moveSoundVolume = 0.4f;
        trailLength = 20;
        waveTrailX = 5f;
        waveTrailY = -4f;
        trailScl = 1.9f;
        moveSound = Sounds.shipMove;

        immunities = ObjectSet.with(StatusEffects.melting);
    }};

    nox = new UnitType("nox"){{
        constructor = UnitEntity::create;
        outlineColor = Pal.darkOutline;
        health = 400f;
        armor = 3f;
        accel = 1f;
        speed = 2.85f;
        rotateSpeed = 8f;
        hitSize = 7.85f;
        engineOffset = 5.75f;
        flying = true;
        faceTarget = true;
        moveSoundVolume = 0.4f;
        moveSound = Sounds.loopHover;

        weapons.add(new Weapon(){{
            y = 1f;
            x = 0f;
            shootCone = 10f;
            reload = 80f;
            mirror = false;
            bullet = new ContinuousLaserBulletType(){{
                damage = 35f;
                width = 2f;
                length = 90f;
                lifetime = 32f;
                incendChance = 0f;
                continuous = true;
                alwaysContinuous = true;
                hitEffect = Fx.hitBeam;
                shootEffect = Fx.shootSmall;
                ammoMultiplier = 2;
                colors = new Color[]{Pal.sapBullet.cpy().a(.2f), Pal.sapBullet.cpy().a(.5f), Pal.sapBullet.cpy().mul(1.2f), Color.white};
            }};
        }});
    }};

    proxy = new UnitType("proxy"){{
        constructor = MechUnit::create;
        outlineColor = Pal.darkOutline;
        drawCell = false;
        canBoost = true;
        boostMultiplier = 1.5f;
        speed = 0.55f;
        hitSize = 8.3f;
        health = 740f;
        armor = 2f;
        stepSoundVolume = 0.4f;

        weapons.add(new Weapon("subzerofallout-proxy-cannon"){{
            top = false;
            y = 0f;
            x = 4.75f;
            reload = 68f;
            recoil = 1f;
            shake = 1f;
            ejectEffect = Fx.casing2;
            shootSound = Sounds.shootSalvo;
            shoot.shots = 2;
            shoot.shotDelay = 6f;
            bullet = new BasicBulletType(4f, 20){{
                sprite = "missile-large";
                smokeEffect = Fx.shootBigSmoke;
                shootEffect = Fx.shootBigColor;
                splashDamageRadius = 35f;
                splashDamage = 20f;
                width = 6f;
                height = 9f;
                lifetime = 32f;
                hitSize = 4f;
                hitColor = backColor = trailColor = Color.valueOf("fffd8b");
                frontColor = Color.white;
                trailWidth = 2f;
                trailLength = 12;
                despawnEffect = hitEffect = Fx.blastExplosion;
            }};
        }});
    }};

    unify = new UnitType("unify"){{
        constructor = LegsUnit::create;
        outlineColor = Pal.darkOutline;
        drawCell = false;
        speed = 0f;
        drag = 0.11f;
        hitSize = 12f;
        rotateSpeed = 3f;
        health = 1040;
        armor = 10f;
        stepShake = 0f;
        stepSound = Sounds.walkerStepTiny;
        stepSoundVolume = 0.4f;

        legCount = 4;
        legLength = 16f;
        legExtension = -5f;
        legBaseOffset = 2f;
        legLengthScl = 1f;
        legForwardScl = 0.8f;
        legGroupSize = 4;
        rippleScale = 0.2f;
        legMoveSpace = 1.4f;
        baseLegStraightness = 0f;
        legStraightness = 0f;
        allowLegStep = true;
        hovering = true;
        legPhysicsLayer = false;
        shadowElevation = 0.1f;
        groundLayer = Layer.legUnit - 1f;
        researchCostMultiplier = 0f;

        weapons.add(new Weapon("subzerofallout-unify-weapon"){{
            top = false;
            shootSound = Sounds.shootCyclone;
            mirror = false;
            showStatSprite = true;

            x = 0f;
            y = 1.9f;
            shootY = 4f;
            reload = 45f;
            layerOffset = -0.001f;
            cooldownTime = 42f;

            bullet = new BasicBulletType(6f, 75){{
                sprite = "shell";
                backSprite = "shell-back";
                smokeEffect = Fx.shootBigSmoke;
                shootEffect = Fx.shootBigColor;
                width = 6f;
                height = 9f;
                lifetime = 32f;
                hitSize = 4f;
                hitColor = backColor = trailColor = Color.valueOf("fffd8b");
                frontColor = Color.white;
                trailWidth = 2f;
                trailLength = 12;
                despawnEffect = hitEffect = trailEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                    color(Color.white, e.color, e.fin());
                    stroke(0.7f + e.fout());
                    Lines.square(e.x, e.y, e.fin() * 7f, e.rotation + 45f);

                    Drawf.light(e.x, e.y, 20f, e.color, e.fout() * 0.7f);
                }));
            }};
        }});
    }};
}}

