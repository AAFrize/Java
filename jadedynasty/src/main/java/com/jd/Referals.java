package com.jd;

public abstract class Referals
{

    public abstract float bSh(int level);
    public abstract float bSh(int level, int toLevel);
    public abstract float bSh(int level, int toLevel, int count);

    public float bSh(int levelNotRb, int toLevelRb, boolean rb) {
        if (rb) {
            NotReborn notReborn = new NotReborn();
            Reborn reborn = new Reborn();
            return notReborn.bSh(levelNotRb, 150) + reborn.bSh(1, toLevelRb);
        }
        else return bSh(levelNotRb, toLevelRb);
    }

    public float bSh (int levelNotRb, int toLevelRb, boolean rb, int count) {
        return count * bSh(levelNotRb, toLevelRb, rb);
    }
}