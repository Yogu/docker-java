package com.github.dockerjava.netty.exec;

import com.github.dockerjava.api.command.DockerCmdSyncExec;
import com.github.dockerjava.api.command.SyncDockerCmd;
import com.github.dockerjava.api.model.Statistics;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * Get container stats with no-stream property
 */
public interface StatsNoStreamCmd extends SyncDockerCmd<Statistics> {

    @CheckForNull
    String getContainerId();

    StatsNoStreamCmd withContainerId(@Nonnull String containerId);

    interface Exec extends DockerCmdSyncExec<StatsNoStreamCmd, Statistics> {
    }
}
