package org.ntut.dei.specifications;

public abstract class AbstractSpecification<T> implements Specification<T> {
    public abstract boolean isSatisfiedBy(T candidate);

    @Override
    public Specification<T> and(Specification<T> other) {
        return new AndSpecification<T>(this, other);
    }

    @Override
    public Specification<T> or(Specification<T> other) {
        return new OrSpecification<T>(this, other);
    }

    @Override
    public Specification<T> not() {
        return new NotSpecification<T>(this);
    }

}
