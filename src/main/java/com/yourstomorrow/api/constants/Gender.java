package com.yourstomorrow.api.constants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {
    @JsonProperty("male")
    MALE,
    @JsonProperty("female")
    FEMALE,
    @JsonProperty("transgender")
    TRANSGENDER,
    @JsonProperty("not disclosed")
    NOTDISCLOSED;
}
