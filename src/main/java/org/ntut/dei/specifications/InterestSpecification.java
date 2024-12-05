package org.ntut.dei.specifications;

public class InterestSpecification extends AbstractSpecification {
    private String interest;

    public InterestSpecification(String interest) {
        this.interest = interest;
    }

    public boolean isSatisfiedBy(Object candidate) {
        return this.interest.equals(candidate);
    }
}
