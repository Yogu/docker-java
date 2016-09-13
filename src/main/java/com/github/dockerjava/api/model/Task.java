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
 * Used for Listing tasks.
 *
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task implements Serializable {

    public static final Long serialVersionUID = 1L;

    /**
     * @since 1.24
     */
    @JsonProperty("ID")
    private String id;

    /**
     * @since 1.24
     */
    @JsonProperty("Version")
    private ResourceVersion version;

    /**
     * @since 1.24
     */
    @JsonProperty("CreatedAt")
    private Date createdAt;

    /**
     * @since 1.24
     */
    @JsonProperty("UpdatedAt")
    private Date updatedAt;

    /**
     * @since 1.24
     */
    @JsonProperty("Name")
    private String name;

    /**
     * @since 1.24
     */
    @JsonProperty("Spec")
    private TaskSpec spec;

    /**
     * @since 1.24
     */
    @JsonProperty("ServiceID")
    private String serviceId;

    /**
     * @since 1.24
     */
    @JsonProperty("Slot")
    private int slot;

    /**
     * @since 1.24
     */
    @JsonProperty("NodeID")
    private String nodeId;

    /**
     * @since 1.24
     */
    @JsonProperty("Status")
    private TaskStatus status;

    /**
     * @since 1.24
     */
    @JsonProperty("DesiredState")
    private TaskState desiredState;

    /**
     * @since 1.24
     */
    @JsonProperty("NetworksAttachments")
    private NetworkAttachement[] networkAttachements;

    /**
     * @see #id
     */
    @CheckForNull
    public String getId() {
        return id;
    }

    /**
     * @see #id
     */
    public Task withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * @see #version
     */
    @CheckForNull
    public ResourceVersion getVersion() {
        return version;
    }


    /**
     * @see #version
     */
    public Task withVersion(ResourceVersion version) {
        this.version = version;
        return this;
    }

    /**
     * @see #createdAt
     */
    @CheckForNull
    public Date getCreatedAt() {
        return createdAt;
    }


    /**
     * @see #createdAt
     */
    public Task withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * @see #updatedAt
     */
    @CheckForNull
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @see #updatedAt
     */
    public Task withUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * @see #name
     */
    @CheckForNull
    public String getName() {
        return name;
    }

    /**
     * @see #name
     */
    public Task withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @see #spec
     */
    @CheckForNull
    public TaskSpec getSpec() {
        return spec;
    }

    /**
     * @see #spec
     */
    public Task withSpec(TaskSpec spec) {
        this.spec = spec;
        return this;
    }

    /**
     * @see #serviceId
     */
    @CheckForNull
    public String getServiceId() {
        return serviceId;
    }

    /**
     * @see #serviceId
     */
    public Task withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * @see #slot
     */
    @CheckForNull
    public int getSlot() {
        return slot;
    }

    /**
     * @see #slot
     */
    public Task withSlot(int slot) {
        this.slot = slot;
        return this;
    }

    /**
     * @see #nodeId
     */
    @CheckForNull
    public String getNodeId() {
        return nodeId;
    }

    /**
     * @see #nodeId
     */
    public Task withNodeId(String nodeId) {
        this.nodeId = nodeId;
        return this;
    }

    /**
     * @see #status
     */
    @CheckForNull
    public TaskStatus getStatus() {
        return status;
    }

    /**
     * @see #status
     */
    public Task withStatus(TaskStatus status) {
        this.status = status;
        return this;
    }

    /**
     * @see #desiredState
     */
    @CheckForNull
    public TaskState getDesiredState() {
        return desiredState;
    }

    /**
     * @see #desiredState
     */
    public Task withDesiredState(TaskState desiredState) {
        this.desiredState = desiredState;
        return this;
    }

    /**
     * @see #networkAttachements
     */
    @CheckForNull
    public NetworkAttachement[] getNetworkAttachements() {
        return networkAttachements;
    }

    /**
     * @see #networkAttachements
     */
    public Task withNetworkAttachements(NetworkAttachement[] networkAttachements) {
        this.networkAttachements = networkAttachements;
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
