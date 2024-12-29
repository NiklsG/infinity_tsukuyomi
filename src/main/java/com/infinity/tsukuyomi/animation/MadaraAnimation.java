package com.infinity.tsukuyomi.animation;

import software.bernie.geckolib.core.animation.RawAnimation;

public class MadaraAnimation {
    public static final RawAnimation walking = RawAnimation.begin().thenLoop("animation.madara.walking");
    public static final RawAnimation staying = RawAnimation.begin().thenLoop("animation.madara.staying");
}

