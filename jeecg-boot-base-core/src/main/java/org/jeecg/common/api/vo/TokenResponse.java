package org.jeecg.common.api.vo;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class TokenResponse {
    @JsonRawValue
    private String token;

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}