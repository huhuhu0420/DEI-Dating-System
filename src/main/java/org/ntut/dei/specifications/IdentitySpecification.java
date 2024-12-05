package org.ntut.dei.specifications;

import java.util.List;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.UserProfile;

public class IdentitySpecification extends AbstractSpecification<UserProfile> {
    private List<GenderIdentity> preferedGenderIdentities;

    public IdentitySpecification(List<GenderIdentity> preferedGenderIdentities) {
        this.preferedGenderIdentities = preferedGenderIdentities;
    }

    @Override
    public boolean isSatisfiedBy(UserProfile candidate) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
