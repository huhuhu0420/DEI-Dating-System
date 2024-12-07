package org.ntut.dei.specifications;

import java.util.List;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.UserProfile;

public class IdentitySpecification extends AbstractSpecification<UserProfile> {
    private List<GenderIdentity> preferedGenderIdentities;

    public IdentitySpecification(List<GenderIdentity> preferedGenderIdentities) {
        this.preferedGenderIdentities = preferedGenderIdentities;
    }

    @Override
    public boolean isSatisfiedBy(UserProfile candidate) {
        GenderIdentity candidateGenderIdentity = candidate.getGenderIdentity();
        // if the candidate gender identity is custom, then compare the display name
        for (GenderIdentity preferedGenderIdentity : preferedGenderIdentities) {
            if (candidateGenderIdentity.getGenderIdentityEnum() == preferedGenderIdentity.getGenderIdentityEnum()) {
                if (preferedGenderIdentity.getGenderIdentityEnum() == GenderIdentityEnum.CUSTOM) {
                    if (candidateGenderIdentity.getGenderIdentity()
                            .equals(preferedGenderIdentity.getGenderIdentity())) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
