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
public class Endpoint implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Spec")
    private EndpointSpec spec;

    @JsonProperty("Ports")
    private PortConfig[] ports;

    @JsonProperty("VirtualIPs")
    private EndpointVirtualIP[] virtualIPs;

    @CheckForNull
    public EndpointSpec getSpec() {
        return spec;
    }

    public Endpoint withSpec(EndpointSpec spec) {
        this.spec = spec;
        return this;
    }

    @CheckForNull
    public PortConfig[] getPorts() {
        return ports;
    }

    public Endpoint withPorts(PortConfig[] ports) {
        this.ports = ports;
        return this;
    }

    @CheckForNull
    public EndpointVirtualIP[] getVirtualIPs() {
        return virtualIPs;
    }

    public Endpoint withVirtualIPs(EndpointVirtualIP[] virtualIPs) {
        this.virtualIPs = virtualIPs;
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
