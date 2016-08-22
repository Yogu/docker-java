package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
 * Used for Listing services.
 *
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Service implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("ID")
    private String id;

    @JsonProperty("CreatedAt")
    private Date createdAt;

    @JsonProperty("UpdatedAt")
    private Date updatedAt;

    @JsonProperty("Spec")
    private ServiceSpec spec;

    @JsonProperty("Endpoint")
    private Endpoint endpoint;

    @JsonProperty("UpdateStatus")
    private ServiceUpdateStatus updateStatus;

    @CheckForNull
    public String getId() {
        return id;
    }

    public Service withId(String id) {
        this.id = id;
        return this;
    }

    @CheckForNull
    public Date getCreatedAt() {
        return createdAt;
    }

    public Service withCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    @CheckForNull
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Service withUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @CheckForNull
    public ServiceSpec getSpec() {
        return spec;
    }

    public Service withSpec(ServiceSpec spec) {
        this.spec = spec;
        return this;
    }

    @CheckForNull
    public Endpoint getEndpoint() {
        return endpoint;
    }

    public Service withEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    @CheckForNull
    public ServiceUpdateStatus getUpdateStatus() {
        return updateStatus;
    }

    public Service withUpdateStatus(ServiceUpdateStatus updateStatus) {
        this.updateStatus = updateStatus;
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
