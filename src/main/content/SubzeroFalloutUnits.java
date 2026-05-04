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
    flare, //delta, sickle,
    //Support
    nerve,
    //Specialist

    //ALTECORIS

    //LEGION
    proxy, unify
    ;

    public static void load(){
    enkindle = new UnitType("enkindle"){{
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
                name = "enkindle-weapon";
                rotate = true;
                rotateSpeed = 7f;
                x = 10/4f;
                y = 10/4f;
                layerOffset = -0.001f;
                shootY = 3f;
            }});

        }});
        constructor = UnitEntity::create;
    }};

    flare = new TankUnitType("flare"){{
        hitSize = 14f;
        range = 60f;
        health = 650;
        armor = 4f;
        itemCapacity = 0;
        rotateSpeed = 3.5f;
        rotateMoveFirst = true;
        speed = 1.2f;
        floorMultiplier = 0.95f;
        immunities.addAll(StatusEffects.burning, StatusEffects.melting);
        treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 55), new Rect(0, 16 - 32f, 14, 25)};
        treadPullOffset = 3;
        researchCostMultiplier = 0f;
        tankMoveVolume *= 0.32f;
        tankMoveSound = Sounds.tankMoveSmall;


        weapons.add(new Weapon("subzerofallout-flare-weapon"){{
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
                damage = 20f;
                length = 60f;
                width = 3f;
                flareLength = 20f;
                knockback = 1f;
                pierceCap = 2;
                timescaleDamage = true;

                colors = new Color[]{Color.valueOf("eb7abe").a(0.55f), Color.valueOf("e189f5").a(0.7f), Color.valueOf("907ef7").a(0.8f), Color.valueOf("91a4ff"), Color.white};
            }};
        }});
        constructor = TankUnit::create;
    }};

    //delta = new UnitType("delta"){{
    //    canBoost = true;
    //    boostMultiplier = 1.5f;
    //    speed = 0.55f;
    //    hitSize = 8f;
    //    health = 120f;
    //    armor = 1f;
    //}};

    //sickle = new UnitType("sickle"){{
    //    speed = 1.1f;
    //    drag = 0.13f;
    //    hitSize = 10f;
    //    health = 280;
    //    armor = 2f;
    //    accel = 0.4f;
    //    rotateSpeed = 3.3f;
    //    faceTarget = false;

    //    trailLength = 20;
    //    waveTrailX = 4f;
    //    trailScl = 1.3f;

    //    moveSoundVolume = 0.4f;
    //    moveSound = Sounds.shipMove;
    //}};

    nerve = new UnitType("nerve"){{
        //defaultCommand = ModUnitCommand.SupportAlly;
        flying = true;
        lowAltitude = false;
        outlineColor = Pal.darkOutline;
        speed = 2.7f;
        accel = 0.08f;
        drag = 0.06f;
        health = 300f;
        armor = 3f;
        payloadCapacity = (2f * 2f) * tilePayload;
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

        float orbRad = 4f, partRad = 2f;
        int parts = 10;

        abilities.add(new EnergyFieldAbility(20f, 100f, 40f){{
            sectorRad = 0.1f;
            sectors = 3;
            effectRadius = 0f;
            statusDuration = 60f * 6f;
            maxTargets = 6;
            healPercent = 1.5f;
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
        constructor = UnitEntity::create;
    }};

    proxy = new UnitType("proxy"){{
        outlineColor = Pal.darkOutline;
        drawCell = false;
        speed = 0.55f;
        hitSize = 8.3f;
        health = 740f;
        armor = 2f;
        stepSoundVolume = 0.4f;

        weapons.add(new Weapon("subzerofallout-proxy-cannon"){{
            top = false;
            y = 0f;
            x = 4.8f;
            reload = 75f;
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
                splashDamage = 15f;
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
        constructor = MechUnit::create;
    }};

    unify = new UnitType("unify"){{
        outlineColor = Pal.darkOutline;
        drawCell = false;
        speed = 0f;
        drag = 0.11f;
        hitSize = 12f;
        rotateSpeed = 3f;
        health = 1040;
        armor = 7f;
        legStraightness = 0.3f;
        stepShake = 0f;
        stepSound = Sounds.walkerStepTiny;
        stepSoundVolume = 0.4f;

        legCount = 4;
        legLength = 12f;
        legExtension = -2f;
        legBaseOffset = 2f;
        legMaxLength = 1.1f;
        legMinLength = 0.2f;
        legLengthScl = 0.96f;
        legForwardScl = 0.8f;
        legGroupSize = 3;
        rippleScale = 0.2f;
        legMoveSpace = 1.4f;
        allowLegStep = true;
        hovering = true;
        legPhysicsLayer = false;
        shadowElevation = 0.1f;
        groundLayer = Layer.legUnit - 1f;
        researchCostMultiplier = 0f;

        weapons.add(new Weapon("subzerofallout-unify-weapon"){{
            top = false;
            shootSound = Sounds.shootCyclone;
            mirror = true;
            alternate = true;
            showStatSprite = true;
            x = 3f;
            y = 0.5f;
            shootY = 4f;
            reload = 63f;
            layerOffset = -0.001f;
            cooldownTime = 42f;

            bullet = new BasicBulletType(4f, 20){{
                sprite = "missile-large";
                smokeEffect = Fx.shootBigSmoke;
                shootEffect = Fx.shootBigColor;
                splashDamageRadius = 35f;
                splashDamage = 15f;
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
        constructor = LegsUnit::create;
    }};
    }
}

