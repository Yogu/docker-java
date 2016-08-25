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
public class SwarmRaft implements Serializable {

    public static final Long serialVersionUID = 1L;

    /**
     * @since 1.24
     */
    @JsonProperty("LogEntriesForSlowFollowers")
    private long logEntriesForSlowFollowers;

    /**
     * @since 1.24
     */
    @JsonProperty("HeartbeatTick")
    private long heartbeatTick;

    /**
     * @since 1.24
     */
    @JsonProperty("SnapshotInterval")
    private long snapshotInterval;

    /**
     * @since 1.24
     */
    @JsonProperty("ElectionTick")
    private long electionTick;

    /**
     * @see #logEntriesForSlowFollowers
     */
    @CheckForNull
    public long getLogEntriesForSlowFollowers() {
        return logEntriesForSlowFollowers;
    }

    /**
     * @see #logEntriesForSlowFollowers
     */
    public SwarmRaft withLogEntriesForSlowFollowers(long logEntriesForSlowFollowers) {
        this.logEntriesForSlowFollowers = logEntriesForSlowFollowers;
        return this;
    }

    /**
     * @see #heartbeatTick
     */
    @CheckForNull
    public long getHeartbeatTick() {
        return heartbeatTick;
    }

    /**
     * @see #heartbeatTick
     */
    public SwarmRaft withHeartbeatTick(long heartbeatTick) {
        this.heartbeatTick = heartbeatTick;
        return this;
    }

    /**
     * @see #snapshotInterval
     */
    @CheckForNull
    public long getSnapshotInterval() {
        return snapshotInterval;
    }

    /**
     * @see #snapshotInterval
     */
    public SwarmRaft withSnapshotInterval(long snapshotInterval) {
        this.snapshotInterval = snapshotInterval;
        return this;
    }

    /**
     * @see #electionTick
     */
    @CheckForNull
    public long getElectionTick() {
        return electionTick;
    }

    /**
     * @see #electionTick
     */
    public SwarmRaft withElectionTick(long electionTick) {
        this.electionTick = electionTick;
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
