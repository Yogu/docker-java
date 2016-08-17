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
public class TaskSpec implements Serializable {
    public static final Long serialVersionUID = 1L;

    /**
     * @since 1.24
     */
    @JsonProperty("ContainerSpec")
    private ContainerSpec containerSpec;

    /**
     * @since 1.24
     */
    @JsonProperty("Resources")
    private ResourceRequirements resources;

    /**
     * @since 1.24
     */
    @JsonProperty("RestartPolicy")
    private ServiceRestartPolicy restartPolicy;

    /**
     * @since 1.24
     */
    @JsonProperty("Placement")
    private ServicePlacement placement;

    /**
     * @since 1.24
     */
    @JsonProperty("LogDriver")
    private Driver logDriver;

    /**
     * @see #containerSpec
     */
    @CheckForNull
    public ContainerSpec getContainerSpec() {
        return containerSpec;
    }

    /**
     * @see #containerSpec
     */
    public void withContainerSpec(ContainerSpec containerSpec) {
        this.containerSpec = containerSpec;
    }

    /**
     * @see #resources
     */
    @CheckForNull
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * @see #resources
     */
    public TaskSpec withResources(ResourceRequirements resources) {
        this.resources = resources;
        return this;
    }

    /**
     * @see #restartPolicy
     */
    @CheckForNull
    public ServiceRestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    /**
     * @see #restartPolicy
     */
    public TaskSpec withRestartPolicy(ServiceRestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
        return this;
    }

    /**
     * @see #placement
     */
    @CheckForNull
    public ServicePlacement getPlacement() {
        return placement;
    }

    /**
     * @see #placement
     */
    public TaskSpec withPlacement(ServicePlacement placement) {
        this.placement = placement;
        return this;
    }

    /**
     * @see #logDriver
     */
    @CheckForNull
    public Driver getLogDriver() {
        return logDriver;
    }

    /**
     * @see #logDriver
     */
    public TaskSpec withLogDriver(Driver logDriver) {
        this.logDriver = logDriver;
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
