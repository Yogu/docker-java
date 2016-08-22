package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dockerjava.core.RemoteApiVersion;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.CheckForNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * The specification for containers as used in {@link TaskSpec}
 *
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public class ContainerSpec implements Serializable {
    public static final Long serialVersionUID = 1L;

    @JsonProperty("Image")
    private String image;

    @JsonProperty("Labels")
    private Map<String, String> labels;

    @JsonProperty("Command")
    private String command;

    @JsonProperty("Args")
    private List<String> args;

    @JsonProperty("Env")
    private List<String> env;

    @JsonProperty("Dir")
    private String dir;

    @JsonProperty("User")
    private String user;

    @JsonProperty("Groups")
    private String groups;

    @JsonProperty("TTY")
    private Boolean tty;

    @JsonProperty("Mounts")
    private List<Mount> mounts;

    @JsonProperty("Duration")
    private Long duration;

    @CheckForNull
    public String getImage() {
        return image;
    }

    public ContainerSpec withImage(String image) {
        this.image = image;
        return this;
    }

    @CheckForNull
    public Map<String, String> getLabels() {
        return labels;
    }

    public ContainerSpec withLabels(Map<String, String> labels) {
        this.labels = labels;
        return this;
    }

    @CheckForNull
    public String getCommand() {
        return command;
    }

    public ContainerSpec withCommand(String command) {
        this.command = command;
        return this;
    }

    @CheckForNull
    public List<String> getArgs() {
        return args;
    }

    public ContainerSpec withArgs(List<String> args) {
        this.args = args;
        return this;
    }

    @CheckForNull
    public List<String> getEnv() {
        return env;
    }

    public ContainerSpec withEnv(List<String> env) {
        this.env = env;
        return this;
    }

    @CheckForNull
    public String getDir() {
        return dir;
    }

    public ContainerSpec withDir(String dir) {
        this.dir = dir;
        return this;
    }

    @CheckForNull
    public String getUser() {
        return user;
    }

    public ContainerSpec withUser(String user) {
        this.user = user;
        return this;
    }

    @CheckForNull
    public String getGroups() {
        return groups;
    }

    public ContainerSpec withGroups(String groups) {
        this.groups = groups;
        return this;
    }

    @CheckForNull
    public Boolean getTty() {
        return tty;
    }

    public ContainerSpec withTty(Boolean tty) {
        this.tty = tty;
        return this;
    }

    @CheckForNull
    public List<Mount> getMounts() {
        return mounts;
    }

    public ContainerSpec withMounts(List<Mount> mounts) {
        this.mounts = mounts;
        return this;
    }

    @CheckForNull
    public Long getDuration() {
        return duration;
    }

    public ContainerSpec withDuration(Long duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
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
