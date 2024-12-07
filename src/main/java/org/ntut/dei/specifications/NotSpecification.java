package org.ntut.dei.specifications;

public class NotSpecification<T> extends AbstractSpecification<T> {
    private Specification<T> specification;

    public NotSpecification(Specification<T> specification) {
        this.specification = specification;
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return !this.specification.isSatisfiedBy(candidate);
    }
}
