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
public class ServiceRestartPolicy implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Condition")
    private ServiceRestartCondition condition;

    @JsonProperty("Delay")
    private Long delay;

    @JsonProperty("MaxAttempts")
    private Long maxAttempts;

    @JsonProperty("Window")
    private Long window;

    @CheckForNull
    public ServiceRestartCondition getCondition() {
        return condition;
    }

    public ServiceRestartPolicy withCondition(ServiceRestartCondition condition) {
        this.condition = condition;
        return this;
    }

    @CheckForNull
    public Long getDelay() {
        return delay;
    }

    public ServiceRestartPolicy withDelay(Long delay) {
        this.delay = delay;
        return this;
    }

    @CheckForNull
    public Long getMaxAttempts() {
        return maxAttempts;
    }

    public ServiceRestartPolicy withMaxAttempts(Long maxAttempts) {
        this.maxAttempts = maxAttempts;
        return this;
    }

    @CheckForNull
    public Long getWindow() {
        return window;
    }

    public ServiceRestartPolicy withWindow(Long window) {
        this.window = window;
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
