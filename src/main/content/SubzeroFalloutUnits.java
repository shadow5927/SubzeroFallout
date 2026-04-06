package main.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
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
    enkindle
    //Rapid
    //flare, delta, sickle,
    //Support
    //nerve,
    //Specialist

    //ALTECORIS

    //LEGION
    //proxy
    ;

    public static void load(){
    enkindle = new TankUnitType("enkindle"){{
        constructor = UnitEntity::create;
        coreUnitDock = true;
        isEnemy = false;
        envDisabled = 0;

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
        buildSpeed = 1.2f;
        drag = 0.08f;
        speed = 5.6f;
        rotateSpeed = 7f;
        accel = 0.09f;
        itemCapacity = 60;
        health = 300f;
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
                new UnitEngine(21 / 4f, 19 / 4f, 2.2f, 45f),
                new UnitEngine(23 / 4f, -22 / 4f, 2.2f, 315f)
        );

        weapons.add(new RepairBeamWeapon(){{
            widthSinMag = 0.11f;
            reload = 20f;
            x = 0f;
            y = 6.5f;
            rotate = false;
            shootY = 0f;
            beamWidth = 0.7f;
            repairSpeed = 3.1f;
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
        }});
    }};

    //flare = new TankUnitType("flare"){{
    //    hitSize = 12f;
    //   treadPullOffset = 3;
    //    speed = 0.75f;
    //    rotateSpeed = 3.5f;
    //    health = 850;
    //    armor = 6f;
    //    itemCapacity = 0;
    //    floorMultiplier = 0.95f;
    //    treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
    //    researchCostMultiplier = 0f;

    //    tankMoveVolume *= 0.32f;
    //    tankMoveSound = Sounds.tankMoveSmall;
    //}};

    //delta = new UnitType("delta"){{
    //    canBoost = true;
    //    boostMultiplier = 1.5f;
    //    speed = 0.55f;
    //    hitSize = 8f;
    //    health = 120f;
    //    armor = 1f;
    //}};

    //sickle = new UnitType("sickle"){{
    //    naval = true;
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

    //nerve = new UnitType("nerve"){{
    //    defaultCommand = UnitCommand.repairCommand;
    //    flying = true;
    //    lowAltitude = true;
    //    isEnemy = false;
    //    speed = 2.7f;
    //    accel = 0.08f;
    //    drag = 0.04f;
    //    health = 70;
    //    engineOffset = 5.75f;
    //    payloadCapacity = (2 * 2) * tilePayload;
    //    targetFlags = new BlockFlag[]{BlockFlag.generator, null};
    //    hitSize = 9;
    //    itemCapacity = 10;
    //    targetPriority = -2;
    //    circleTarget = false;
    //    omniMovement = false;
    //    rotateSpeed = 5f;
    //    circleTargetRadius = 60f;
    //    wreckSoundVolume = 0.7f;

    //    moveSound = Sounds.loopThruster;
    //    moveSoundPitchMin = 0.6f;
    //    moveSoundVolume = 0.2f;
    //}};

    //proxy = new UnitType("proxy"){{
    //    speed = 0.55f;
    //    hitSize = 8f;
    //    health = 120f;
    //    armor = 1f;
    //}};
    }
}

