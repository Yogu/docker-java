package com.github.dockerjava.core.command;

import com.github.dockerjava.api.command.InspectTaskCmd;
import com.github.dockerjava.api.exception.NotFoundException;
import com.github.dockerjava.api.model.Task;

import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by martin on 07.09.16.
 */
public class InspectTaskCmdImpl extends AbstrDockerCmd<InspectTaskCmd, Task> implements
        InspectTaskCmd {

    private String taskId;

    public InspectTaskCmdImpl(Exec exec, String taskId) {
        super(exec);
        withTaskId(taskId);
    }

    @Override
    public String getTaskId() {
        return taskId;
    }

    @Override
    public InspectTaskCmd withTaskId(@Nonnull String taskId) {
        checkNotNull(taskId, "taskId was not specified");
        this.taskId = taskId;
        return this;
    }

    /**
     * @throws NotFoundException No such service
     */
    @Override
    public Task exec() throws NotFoundException {
        return super.exec();
    }
}
