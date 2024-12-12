package org.ntut.dei.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.SexualOrientation;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("age")
    @NotNull
    private int age;

    @JsonProperty("genderIdentity")
    @NotNull
    private GenderIdentity genderIdentity;

    @JsonProperty("sexualOrientation")
    private SexualOrientation sexualOrientation;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("interests")
    private List<String> interests;

    @JsonProperty("preferedGenderIdentity")
    private List<GenderIdentity> preferedGenderIdentity;

    @JsonProperty("preferedInterests")
    private List<String> preferedInterests;

    @JsonProperty("preferedMinAge")
    private int preferedMinAge;

    @JsonProperty("preferedMaxAge")
    private int preferedMaxAge;

    @JsonProperty("matchStrategy")
    private String matchStrategy;
}
