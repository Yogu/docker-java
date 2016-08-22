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
public class ResourceRequirements implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Limits")
    private ResourceSpecs limits;

    @JsonProperty("Reservations")
    private ResourceSpecs reservations;

    @CheckForNull
    public ResourceSpecs getLimits() {
        return limits;
    }

    public ResourceRequirements withLimits(ResourceSpecs limits) {
        this.limits = limits;
        return this;
    }

    @CheckForNull
    public ResourceSpecs getReservations() {
        return reservations;
    }

    public ResourceRequirements withReservations(ResourceSpecs reservations) {
        this.reservations = reservations;
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
