package org.ntut.dei.specifications;

public abstract class AbstractSpecification {
    public abstract boolean isSatisfiedBy(Object candidate);

    public AbstractSpecification and(AbstractSpecification other) {
        return new AndSpecification(this, other);
    }

    public AbstractSpecification or(AbstractSpecification other) {
        return new OrSpecification(this, other);
    }

    public AbstractSpecification not() {
        return new NotSpecification(this);
    }

}
