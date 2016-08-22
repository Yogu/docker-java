package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.annotation.CheckForNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public class ServiceUpdateStatus implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("State")
    private ServiceUpdateState state;

    @JsonProperty("StartedAt")
    private Date startedAt;

    @JsonProperty("CompletedAt")
    private Date completedAt;

    @JsonProperty("Message")
    private String message;

    @CheckForNull
    public ServiceUpdateState getState() {
        return state;
    }

    public ServiceUpdateStatus withState(ServiceUpdateState state) {
        this.state = state;
        return this;
    }

    @CheckForNull
    public Date getStartedAt() {
        return startedAt;
    }

    public ServiceUpdateStatus withStartedAt(Date startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    @CheckForNull
    public Date getCompletedAt() {
        return completedAt;
    }

    public ServiceUpdateStatus withCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
        return this;
    }

    @CheckForNull
    public String getMessage() {
        return message;
    }

    public ServiceUpdateStatus withMessage(String message) {
        this.message = message;
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
