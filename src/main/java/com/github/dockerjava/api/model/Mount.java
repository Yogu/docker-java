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
public class Mount implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("Type")
    private MountType type;

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Target")
    private String target;

    @JsonProperty("ReadOnly")
    private Boolean readOnly;

    @JsonProperty("BindOptions")
    private BindOptions bindOptions;

    @JsonProperty("VolumeOptions")
    private VolumeOptions volumeOptions;

    @CheckForNull
    public MountType getType() {
        return type;
    }

    public Mount withType(MountType type) {
        this.type = type;
        return this;
    }

    @CheckForNull
    public String getSource() {
        return source;
    }

    public Mount withSource(String source) {
        this.source = source;
        return this;
    }

    @CheckForNull
    public String getTarget() {
        return target;
    }

    public Mount withTarget(String target) {
        this.target = target;
        return this;
    }

    @CheckForNull
    public Boolean getReadOnly() {
        return readOnly;
    }

    public Mount withReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    @CheckForNull
    public BindOptions getBindOptions() {
        return bindOptions;
    }

    public Mount withBindOptions(BindOptions bindOptions) {
        this.bindOptions = bindOptions;
        return this;
    }

    @CheckForNull
    public VolumeOptions getVolumeOptions() {
        return volumeOptions;
    }

    public Mount withVolumeOptions(VolumeOptions volumeOptions) {
        this.volumeOptions = volumeOptions;
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
