package com.github.dockerjava.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskStatus implements Serializable {

    public static final Long serialVersionUID = 1L;

    /**
     * @since 1.24
     */
    @JsonProperty("Timestamp")
    private Date timestamp;

    /**
     * @since 1.24
     */
    @JsonProperty("State")
    private TaskState state;

    /**
     * @since 1.24
     */
    @JsonProperty("Message")
    private String message;

    /**
     * @since 1.24
     */
    @JsonProperty("Err")
    private String err;

    /**
     * @since 1.24
     */
    @JsonProperty("ContainerStatus")
    private ContainerStatus containerStatus;

    /**
     * @see #timestamp
     */
    @CheckForNull
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @see #timestamp
     */
    public TaskStatus withTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * @see #state
     */
    @CheckForNull
    public TaskState getState() {
        return state;
    }

    /**
     * @see #state
     */
    public TaskStatus withState(TaskState state) {
        this.state = state;
        return this;
    }

    /**
     * @see #message
     */
    @CheckForNull
    public String getMessage() {
        return message;
    }

    /**
     * @see #message
     */
    public TaskStatus withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * @see #err
     */
    @CheckForNull
    public String getErr() {
        return err;
    }

    /**
     * @see #err
     */
    public TaskStatus withErr(String err) {
        this.err = err;
        return this;
    }

    /**
     * @see #containerStatus
     */
    @CheckForNull
    public ContainerStatus getContainerStatus() {
        return containerStatus;
    }

    /**
     * @see #containerStatus
     */
    public TaskStatus withContainerStatus(ContainerStatus containerStatus) {
        this.containerStatus = containerStatus;
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
