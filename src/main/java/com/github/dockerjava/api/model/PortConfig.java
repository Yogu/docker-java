package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.annotation.CheckForNull;
import java.io.Serializable;

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public class PortConfig implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Protocol")
    private PortConfigProtocol protocol;

    @JsonProperty("TargetPort")
    private int targetPort;

    @JsonProperty("PublishedPort")
    private int publishedPort;

    public String getName() {
        return name;
    }

    public PortConfig withName(String name) {
        this.name = name;
        return this;
    }

    @CheckForNull
    public PortConfigProtocol getProtocol() {
        return protocol;
    }

    public PortConfig withProtocol(PortConfigProtocol protocol) {
        this.protocol = protocol;
        return this;
    }

    @CheckForNull
    public int getTargetPort() {
        return targetPort;
    }

    public PortConfig withTargetPort(int targetPort) {
        this.targetPort = targetPort;
        return this;
    }

    @CheckForNull
    public int getPublishedPort() {
        return publishedPort;
    }

    public PortConfig withPublishedPort(int publishedPort) {
        this.publishedPort = publishedPort;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
