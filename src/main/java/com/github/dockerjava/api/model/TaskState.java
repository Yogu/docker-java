package com.github.dockerjava.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;

/**
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public enum TaskState {

    @JsonProperty("new")
    NEW,

    @JsonProperty("allocated")
    ALLOCATED,

    @JsonProperty("pending")
    PENDING,

    @JsonProperty("assigned")
    ASSIGNED,

    @JsonProperty("accepted")
    ACCEPTED,

    @JsonProperty("preparing")
    PREPARING,

    @JsonProperty("ready")
    READY,

    @JsonProperty("starting")
    STARTING,

    @JsonProperty("running")
    RUNNING,

    @JsonProperty("complete")
    COMPLETE,

    @JsonProperty("shutdown")
    SHUTDOWN,

    @JsonProperty("failed")
    FAILED,

    @JsonProperty("rejected")
    REJECTED
}
