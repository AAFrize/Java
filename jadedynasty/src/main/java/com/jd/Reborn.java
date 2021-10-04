package com.jd;

public class Reborn extends Referals {
    public float bSh(int level) {
        if (level < 120) return 0;
        else
            return (float) (level-100)/10;
    }
    public float bSh(int level, int toLevel) {
        if (level < 120 && toLevel > 120)
            return (bSh(120) + bSh(toLevel)) * (toLevel - 119) / 2;
        else if (level < 120 && toLevel == 120) return 2;
        else if (toLevel < 120) return 0;
        else
            return (bSh(level) + bSh(toLevel)) * (toLevel + 1 - level) / 2;
    }
    public float bSh(int level, int toLevel, int count) {
        return bSh(level, toLevel) * count;
    }
}
