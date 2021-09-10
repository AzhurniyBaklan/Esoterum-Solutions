package esoterum.type;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.util.*;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.gen.*;

public class BinarySwitch extends BinaryBlock {
    public BinarySwitch(String name){
        super(name);
        configurable = true;
        autoResetEnabled = false;
        targetable = false;
        emits = true;
    }

    public class BinarySwitchBuild extends BinaryBuild {
        @Override
        public boolean configTapped(){
            nextSignal = !nextSignal;
            lastSignal = nextSignal;
            Sounds.click.at(this);
            return false;
        }

        @Override
        public void draw() {
            Draw.rect(region, x, y);
            Draw.color(Color.white, Color.green, lastSignal ? 1f : 0f);
            if(drawConnection) for (int i = 0; i < 4; i++) {
                Draw.rect(connectionRegion, x, y, 90 * i);
            }
            Draw.rect(topRegion, x, y, rotdeg());
        }

    }
}
