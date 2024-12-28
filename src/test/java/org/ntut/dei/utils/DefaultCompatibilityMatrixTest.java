package org.ntut.dei.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.SexualOrientation;

public class DefaultCompatibilityMatrixTest {

    private DefaultCompatibilityMatrix matrix;

    @BeforeEach
    public void setUp() {
        matrix = DefaultCompatibilityMatrix.getInstance();
    }

    @Test
    public void testGetInstance() {
        DefaultCompatibilityMatrix instance = DefaultCompatibilityMatrix.getInstance();
        assertNotNull(instance);
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_HeterosexualMale() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.HETEROSEXUAL,
                male);
        assertEquals(1, result.size());
        assertEquals(GenderIdentityEnum.FEMALE, result.get(0).getGenderIdentityEnum());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_HeterosexualFemale() {
        GenderIdentity female = new GenderIdentity(GenderIdentityEnum.FEMALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.HETEROSEXUAL,
                female);
        assertEquals(1, result.size());
        assertEquals(GenderIdentityEnum.MALE, result.get(0).getGenderIdentityEnum());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_HomosexualMale() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.HOMOSEXUAL, male);
        assertEquals(1, result.size());
        assertEquals(GenderIdentityEnum.MALE, result.get(0).getGenderIdentityEnum());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_HomosexualFemale() {
        GenderIdentity female = new GenderIdentity(GenderIdentityEnum.FEMALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.HOMOSEXUAL,
                female);
        assertEquals(1, result.size());
        assertEquals(GenderIdentityEnum.FEMALE, result.get(0).getGenderIdentityEnum());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_Bisexual() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.BISEXUAL, male);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_Pansexual() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.PANSEXUAL, male);
        assertEquals(GenderIdentityEnum.values().length, result.size());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_Asexual() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.ASEXUAL, male);
        assertEquals(GenderIdentityEnum.values().length, result.size());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_Demisexual() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.DEMISEXUAL, male);
        assertEquals(GenderIdentityEnum.values().length, result.size());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_Queer() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.QUEER, male);
        assertEquals(GenderIdentityEnum.values().length, result.size());
    }

    @Test
    public void testGetDefaultPreferencedGenderIdentities_Other() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        List<GenderIdentity> result = matrix.getDefaultPreferencedGenderIdentities(SexualOrientation.OTHER, male);
        assertEquals(GenderIdentityEnum.values().length, result.size());
    }
}