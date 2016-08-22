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

    @JsonProperty("ContainerSpec")
    private ContainerSpec containerSpec;

    @JsonProperty("Resources")
    private ResourceRequirements resources;

    @JsonProperty("RestartPolicy")
    private ServiceRestartPolicy restartPolicy;

    @JsonProperty("Placement")
    private ServicePlacement placement;

    @JsonProperty("LogDriver")
    private Driver logDriver;

    @CheckForNull
    public ContainerSpec getContainerSpec() {
        return containerSpec;
    }

    public void withContainerSpec(ContainerSpec containerSpec) {
        this.containerSpec = containerSpec;
    }

    @CheckForNull
    public ResourceRequirements getResources() {
        return resources;
    }

    public TaskSpec withResources(ResourceRequirements resources) {
        this.resources = resources;
        return this;
    }

    @CheckForNull
    public ServiceRestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    public TaskSpec withRestartPolicy(ServiceRestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
        return this;
    }

    @CheckForNull
    public ServicePlacement getPlacement() {
        return placement;
    }

    public TaskSpec withPlacement(ServicePlacement placement) {
        this.placement = placement;
        return this;
    }

    @CheckForNull
    public Driver getLogDriver() {
        return logDriver;
    }

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
