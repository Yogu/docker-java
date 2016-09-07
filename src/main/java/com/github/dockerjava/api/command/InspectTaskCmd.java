package com.github.dockerjava.api.command;

import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.Task;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public interface InspectTaskCmd extends SyncDockerCmd<Task> {

    @CheckForNull
    String getTaskId();

    InspectTaskCmd withTaskId(@Nonnull String taskId);

    /**
     * @throws NotFoundException Unknown task
     */
    @Override
    Task exec() throws NotFoundException;

    interface Exec extends DockerCmdSyncExec<InspectTaskCmd, Task> {
    }
}
