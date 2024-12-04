package org.ntut.dei.models;

public class AgeRange {
    private int minAge;
    private int maxAge;

    public AgeRange(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }
}
