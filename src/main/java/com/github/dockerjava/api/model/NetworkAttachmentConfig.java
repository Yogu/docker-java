package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.CheckForNull;
import java.io.Serializable;
import java.util.List;

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public class NetworkAttachmentConfig implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Target")
    private String target;

    @JsonProperty("Aliases")
    private List<String> aliases;

    @CheckForNull
    public String getTarget() {
        return target;
    }

    public NetworkAttachmentConfig withTarget(String target) {
        this.target = target;
        return this;
    }

    @CheckForNull
    public List<String> getAliases() {
        return aliases;
    }

    public NetworkAttachmentConfig withAliases(List<String> aliases) {
        this.aliases = aliases;
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
