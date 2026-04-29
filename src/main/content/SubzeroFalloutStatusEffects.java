package main.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import arc.math.Interp;
import arc.math.Mathf;
import mindustry.entities.units.StatusEntry;
import mindustry.gen.Unit;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;

public class SubzeroFalloutStatusEffects {
    public static StatusEffect
            crippled, invulnerable,
            scorched, overload
    ;

    public static void load(){
        crippled = new StatusEffect("crippled"){{
            speedMultiplier = 0.15f;
            healthMultiplier = 0.75f;
            disarm = true;
        }};
        invulnerable = new StatusEffect("invulnerable"){{
            color = Pal.accent;
            healthMultiplier = Float.POSITIVE_INFINITY;
            effect = Fx.shieldWave;
        }};

        scorched = new StatusEffect("scorched"){{
            color = Color.valueOf("f26f83");
            healthMultiplier = 0.8f;
            damage = 0.215f;
            effect = Fx.burning;
        }};
        overload = new StatusEffect("overload"){{
            color = Pal.accent;
            speedMultiplier = 1.35f;
            damage = 0.159f;
            effect = Fx.overclocked;
        }};
    }
}
