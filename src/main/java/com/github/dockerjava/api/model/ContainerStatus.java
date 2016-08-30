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

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerStatus implements Serializable {

    public static final Long serialVersionUID = 1L;

    /**
     * @since 1.24
     */
    @JsonProperty("ContainerID")
    private String containerId;

    /**
     * @since 1.24
     */
    @JsonProperty("PID")
    private int pid;

    /**
     * @since 1.24
     */
    @JsonProperty("ExitCode")
    private int exitCode;

    /**
     * @see #containerId
     */
    @CheckForNull
    public String getContainerId() {
        return containerId;
    }

    /**
     * @see #containerId
     */
    public ContainerStatus withContainerId(String containerId) {
        this.containerId = containerId;
        return this;
    }

    /**
     * @see #pid
     */
    @CheckForNull
    public int getPid() {
        return pid;
    }

    /**
     * @see #pid
     */
    public ContainerStatus withPid(int pid) {
        this.pid = pid;
        return this;
    }

    /**
     * @see #exitCode
     */
    @CheckForNull
    public int getExitCode() {
        return exitCode;
    }

    /**
     * @see #exitCode
     */
    public ContainerStatus withExitCode(int exitCode) {
        this.exitCode = exitCode;
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
