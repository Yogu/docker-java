package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.CheckForNull;
import java.io.Serializable;

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public class ResourceSpecs implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("MemoryBytes")
    private Long memoryBytes;

    @JsonProperty("NanoCPUs")
    private Long nanoCPUs;

    @CheckForNull
    public Long getMemoryBytes() {
        return memoryBytes;
    }

    public ResourceSpecs withMemoryBytes(long memoryBytes) {
        this.memoryBytes = memoryBytes;
        return this;
    }

    @CheckForNull
    public Long getNanoCPUs() {
        return nanoCPUs;
    }

    public ResourceSpecs withNanoCPUs(long nanoCPUs) {
        this.nanoCPUs = nanoCPUs;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
