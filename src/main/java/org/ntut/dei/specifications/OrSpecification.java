package org.ntut.dei.specifications;

public class OrSpecification extends AbstractSpecification {
    private AbstractSpecification leftSpecification;
    private AbstractSpecification rightSpecification;

    public OrSpecification(AbstractSpecification left, AbstractSpecification right) {
        this.leftSpecification = left;
        this.rightSpecification = right;
    }

    public boolean isSatisfiedBy(Object candidate) {
        return leftSpecification.isSatisfiedBy(candidate) || rightSpecification.isSatisfiedBy(candidate);
    }
}
