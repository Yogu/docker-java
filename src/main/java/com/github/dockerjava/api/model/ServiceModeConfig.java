package com.github.dockerjava.api.model;

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
public class ServiceModeConfig implements Serializable {
    public static final Long serialVersionUID = 1L;

    private ServiceReplicatedModeOptions replicated;

    private ServiceGlobalModeOptions global;

    @CheckForNull
    public ServiceMode getMode() {
        if (replicated != null) {
            return ServiceMode.REPLICATED;
        }
        if (global != null) {
            return ServiceMode.GLOBAL;
        }

        return null;
    }

    public ServiceReplicatedModeOptions getReplicated() {
        return replicated;
    }

    public ServiceModeConfig withReplicated(ServiceReplicatedModeOptions replicated) {
        if (replicated != null && this.global != null) {
            throw new IllegalStateException("Cannot set both replicated and global mode");
        }
        this.replicated = replicated;

        return this;
    }

    @CheckForNull
    public ServiceGlobalModeOptions getGlobal() {
        return global;
    }

    public ServiceModeConfig withGlobal(ServiceGlobalModeOptions global) {
        if (global != null && this.replicated != null) {
            throw new IllegalStateException("Cannot set both global and replicated mode");
        }
        this.global = global;

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
