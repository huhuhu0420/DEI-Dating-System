package org.ntut.dei.specifications;

public class NotSpecification extends AbstractSpecification {
    private AbstractSpecification spec;

    public NotSpecification(AbstractSpecification spec) {
        this.spec = spec;
    }

    public boolean isSatisfiedBy(Object candidate) {
        return !spec.isSatisfiedBy(candidate);
    }
}
