package org.ntut.dei.specifications;

public class AndSpecification extends AbstractSpecification {
    private AbstractSpecification leftSpecification;
    private AbstractSpecification rightSpecification;

    public AndSpecification(AbstractSpecification left, AbstractSpecification right) {
        this.leftSpecification = left;
        this.rightSpecification = right;
    }

    public boolean isSatisfiedBy(Object candidate) {
        return leftSpecification.isSatisfiedBy(candidate) && rightSpecification.isSatisfiedBy(candidate);
    }
}
