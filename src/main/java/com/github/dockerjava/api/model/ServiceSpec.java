package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.annotation.CheckForNull;
import java.io.Serializable;
import java.util.List;

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public class ServiceSpec implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("TaskTemplate")
    private TaskSpec taskTemplate;

    @JsonProperty("Mode")
    private ServiceModeConfig mode;

    @JsonProperty("UpdateConfig")
    private UpdateConfig updateConfig;

    @JsonProperty("Configs")
    private List<NetworkAttachmentConfig> networks;

    @JsonProperty("EndpointSpec")
    private EndpointSpec endpointSpec;

    public String getName() {
        return name;
    }

    public ServiceSpec withName(String name) {
        this.name = name;
        return this;
    }

    @CheckForNull
    public TaskSpec getTaskTemplate() {
        return taskTemplate;
    }

    public ServiceSpec withTaskTemplate(TaskSpec taskTemplate) {
        this.taskTemplate = taskTemplate;
        return this;
    }

    @CheckForNull
    public ServiceModeConfig getMode() {
        return mode;
    }

    public ServiceSpec withMode(ServiceModeConfig mode) {
        this.mode = mode;
        return this;
    }

    @CheckForNull
    public UpdateConfig getUpdateConfig() {
        return updateConfig;
    }

    public ServiceSpec withUpdateConfig(UpdateConfig updateConfig) {
        this.updateConfig = updateConfig;
        return this;
    }

    @CheckForNull
    public List<NetworkAttachmentConfig> getNetworks() {
        return networks;
    }

    public ServiceSpec withNetworks(List<NetworkAttachmentConfig> networks) {
        this.networks = networks;
        return this;
    }

    @CheckForNull
    public EndpointSpec getEndpointSpec() {
        return endpointSpec;
    }

    public ServiceSpec withEndpointSpec(EndpointSpec endpointSpec) {
        this.endpointSpec = endpointSpec;
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
