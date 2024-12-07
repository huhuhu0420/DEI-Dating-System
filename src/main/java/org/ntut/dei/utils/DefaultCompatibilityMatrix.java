package org.ntut.dei.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.SexualOrientation;

public class DefaultCompatibilityMatrix {
    private static DefaultCompatibilityMatrix instance;
    private Map<SexualOrientation, Function<GenderIdentity, List<GenderIdentity>>> defaultMappings;

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
        defaultMappings.put(SexualOrientation.BISEXUAL, gender -> List.of(GenderIdentity.MALE, GenderIdentity.FEMALE));
        defaultMappings.put(SexualOrientation.PANSEXUAL, gender -> this.getAllGenderIdentities());
        defaultMappings.put(SexualOrientation.ASEXUAL, gender -> this.getAllGenderIdentities());
        defaultMappings.put(SexualOrientation.DEMISEXUAL, gender -> this.getAllGenderIdentities());
        defaultMappings.put(SexualOrientation.QUEER, gender -> this.getAllGenderIdentities());
        defaultMappings.put(SexualOrientation.OTHER, gender -> this.getAllGenderIdentities());
    }

    public List<GenderIdentity> getDefaultPreferencedGenderIdentities(SexualOrientation sexualOrientation,
            GenderIdentity genderIdentity) {
        Function<GenderIdentity, List<GenderIdentity>> mapping = defaultMappings.get(sexualOrientation);
        if (mapping == null) {
            return List.of();
        }
        return mapping.apply(genderIdentity);
    }

    private List<GenderIdentity> getOppositeGender(GenderIdentity genderIdentity) {
        if (genderIdentity == GenderIdentity.MALE) {
            return List.of(GenderIdentity.FEMALE);
        } else if (genderIdentity == GenderIdentity.FEMALE) {
            return List.of(GenderIdentity.FEMALE);
        } else {
            return getAllGenderIdentitiesExcluding(genderIdentity);
        }
    }

    private List<GenderIdentity> getSameGender(GenderIdentity genderIdentity) {
        if (genderIdentity == GenderIdentity.MALE) {
            return List.of(GenderIdentity.MALE);
        } else if (genderIdentity == GenderIdentity.FEMALE) {
            return List.of(GenderIdentity.FEMALE);
        } else {
            return List.of(genderIdentity);
        }
    }

    private List<GenderIdentity> getAllGenderIdentitiesExcluding(GenderIdentity genderIdentity) {
        List<GenderIdentity> allGenderIdentities = getAllGenderIdentities();
        allGenderIdentities.remove(genderIdentity);
        return List.copyOf(allGenderIdentities);
    }

    private List<GenderIdentity> getAllGenderIdentities() {
        return List.of(GenderIdentity.values());
    }

}
