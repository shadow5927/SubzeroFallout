package main.content;

import arc.graphics.*;
import mindustry.type.*;
import arc.graphics.Color;
import arc.struct.*;
import mindustry.type.Liquid;

public class SubzeroFalloutLiquids {
    public static Liquid
        carbon, helium, argon
    ;

    public static void load(){
        carbon = new Liquid("carbon", Color.valueOf("424253")){{
            gas = true;
            barColor = Color.valueOf("1D1D25");
            flammability = 3f;
        }};
        helium = new Liquid("helium", Color.valueOf("a07856")){{
            gas = true;
        }};
        argon = new Liquid("argon", Color.valueOf("af8ed8")){{
            gas = true;
        }};
    }
}
