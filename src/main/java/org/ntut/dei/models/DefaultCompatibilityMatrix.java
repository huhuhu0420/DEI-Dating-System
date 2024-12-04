package org.ntut.dei.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class DefaultCompatibilityMatrix {
    private static DefaultCompatibilityMatrix instance;
    private Map<SexualOrientation, Function<GenderIdentity, Set<GenderIdentity>>> defaultMappings;

    private DefaultCompatibilityMatrix() {
        defaultMappings = new HashMap<>();
        initializeDefaultMappings();
    }

    public static synchronized DefaultCompatibilityMatrix getInstance() {
        if (instance == null) {
            instance = new DefaultCompatibilityMatrix();
        }
        return instance;
    }

    private void initializeDefaultMappings() {
        defaultMappings.put(SexualOrientation.HETEROSEXUAL, this::getOppositeGender);
        defaultMappings.put(SexualOrientation.HOMOSEXUAL, this::getSameGender);
        defaultMappings.put(SexualOrientation.BISEXUAL, gender -> Set.of(GenderIdentity.MALE, GenderIdentity.FEMALE));
        defaultMappings.put(SexualOrientation.PANSEXUAL, gender -> this.getAllGenderIdentities());
    }

    public Set<GenderIdentity> getDefaultPreferencedGenderIdentities(SexualOrientation sexualOrientation,
            GenderIdentity genderIdentity) {
        Function<GenderIdentity, Set<GenderIdentity>> mapping = defaultMappings.get(sexualOrientation);
        if (mapping == null) {
            return Set.of();
        }
        return mapping.apply(genderIdentity);
    }

    private Set<GenderIdentity> getOppositeGender(GenderIdentity genderIdentity) {
        if (genderIdentity == GenderIdentity.MALE) {
            return Set.of(GenderIdentity.FEMALE);
        } else if (genderIdentity == GenderIdentity.FEMALE) {
            return Set.of(GenderIdentity.FEMALE);
        } else {
            return getAllGenderIdentitiesExcluding(genderIdentity);
        }
    }

    private Set<GenderIdentity> getSameGender(GenderIdentity genderIdentity) {
        if (genderIdentity == GenderIdentity.MALE) {
            return Set.of(GenderIdentity.MALE);
        } else if (genderIdentity == GenderIdentity.FEMALE) {
            return Set.of(GenderIdentity.FEMALE);
        } else {
            return Set.of(genderIdentity);
        }
    }

    private Set<GenderIdentity> getAllGenderIdentitiesExcluding(GenderIdentity genderIdentity) {
        Set<GenderIdentity> allGenderIdentities = getAllGenderIdentities();
        allGenderIdentities.remove(genderIdentity);
        return Set.copyOf(allGenderIdentities);
    }

    private Set<GenderIdentity> getAllGenderIdentities() {
        return Set.of(GenderIdentity.values());
    }

}
