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
public class UpdateConfig implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Parallelism")
    private Long parallelism;

    @JsonProperty("Delay")
    private Long delay;

    @JsonProperty("FailureAction")
    private UpdateFailureAction failureAction;

    @CheckForNull
    public Long getParallelism() {
        return parallelism;
    }

    public UpdateConfig withParallelism(long parallelism) {
        this.parallelism = parallelism;
        return this;
    }

    @CheckForNull
    public Long getDelay() {
        return delay;
    }

    public UpdateConfig setDelay(Long delay) {
        this.delay = delay;
        return this;
    }

    @CheckForNull
    public UpdateFailureAction getFailureAction() {
        return failureAction;
    }

    public UpdateConfig withFailureAction(UpdateFailureAction failureAction) {
        this.failureAction = failureAction;
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
