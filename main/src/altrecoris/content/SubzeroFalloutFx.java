package main.content;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.units.UnitAssembler.*;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class SubzeroFalloutFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static Effect

    spearLaserShoot = new Effect(21f, e -> {
        color(Color.valueOf("8aa3f4"));
        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 4f * e.fout(), 29f, e.rotation + 90f * i);
        }
    }),

    spearCharge = new Effect(38f, e -> {
        color(Color.valueOf("8aa3f4"));
        randLenVectors(e.id, 14, 1f + 20f * e.fout(), e.rotation, 120f, (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), e.fslope() * 3f + 1f);
        });
    }),

    scorched = new Effect(35f, e -> {
        color(Color.valueOf("f0a3b0"), Color.valueOf("83222c"), e.fin());

        randLenVectors(e.id, 3, 2f + e.fin() * 7f, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.1f + e.fout() * 1.4f);
        });
    }),

    scExplosion = new Effect(20f, 50f, e -> {
        color(e.color);
        stroke(e.fout() * 2f);
        float circleRad = 6f + e.finpow() * 20f;
        Lines.circle(e.x, e.y, circleRad);

        rand.setSeed(e.id);
        for(int i = 0; i < 8; i++){
            float angle = rand.random(360f);
            float lenRand = rand.random(0.5f, 1f);
            Tmp.v1.trns(angle, circleRad);

            for(int s : Mathf.signs){
                Drawf.tri(e.x + Tmp.v1.x, e.y + Tmp.v1.y, e.foutpow() * 15f, e.fout() * 20f * lenRand + 6f, angle + 90f + s * 90f);
            }
        }
    });
}
