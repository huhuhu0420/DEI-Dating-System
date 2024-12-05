package org.ntut.dei.specifications;

public class IdentitySpecification extends AbstractSpecification {
    private Object candidate;

    public IdentitySpecification(Object candidate) {
        this.candidate = candidate;
    }

    public boolean isSatisfiedBy(Object candidate) {
        return this.candidate.equals(candidate);
    }
}
