package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.annotation.CheckForNull;
import java.io.Serializable;
import java.util.List;

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public class EndpointSpec implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Mode")
    EndpointResolutionMode mode;

    @JsonProperty("Ports")
    List<PortConfig> ports;

    @CheckForNull
    public EndpointResolutionMode getMode() {
        return mode;
    }

    public EndpointSpec withMode(EndpointResolutionMode mode) {
        this.mode = mode;
        return this;
    }

    @CheckForNull
    public List<PortConfig> getPorts() {
        return ports;
    }

    public EndpointSpec withPorts(List<PortConfig> ports) {
        this.ports = ports;
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
