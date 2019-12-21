package com.fgs.dls.terminalsimulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.UUID;

public class Terminal {

    private final UUID id;
    @NotBlank
    private final String platform;
    @NotBlank
    private final String ip;
    @Positive
    private final Integer servicePort;

    public Terminal(@JsonProperty("id") UUID id,
                    @JsonProperty("platform") String platform,
                    @JsonProperty("ip") String ip,
                    @JsonProperty("port") Integer servicePort) {
        this.id = id;
        this.platform = platform;
        this.ip = ip;
        this.servicePort = servicePort;
    }

    public UUID getId() {
        return id;
    }

    public String getPlatform() {
        return platform;
    }

    public String getIp() {
        return ip;
    }

    public Integer getServicePort() {
        return servicePort;
    }
}
