package org.ntut.dei.specifications;

public class OrSpecification<T> implements Specification<T> {
    private Specification<T> leftSpecification;
    private Specification<T> rightSpecification;

    public OrSpecification(Specification<T> left, Specification<T> right) {
        this.leftSpecification = left;
        this.rightSpecification = right;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return this.leftSpecification.isSatisfiedBy(candidate) || this.rightSpecification.isSatisfiedBy(candidate);
    }
}
