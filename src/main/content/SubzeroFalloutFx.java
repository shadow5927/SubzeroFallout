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
    public static Effect

            spearLaserShoot = new Effect(21f, e -> {
        color(Color.valueOf("8aa3f4"));
        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 4f * e.fout(), 29f, e.rotation + 90f * i);
        }
    });
}
