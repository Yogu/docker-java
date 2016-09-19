package com.github.dockerjava.core.command;


import com.github.dockerjava.api.model.Statistics;
import com.github.dockerjava.netty.exec.StatsNoStreamCmd;

import static com.google.common.base.Preconditions.checkNotNull;

public class StatsNoStreamCmdImpl extends AbstrDockerCmd<StatsNoStreamCmd, Statistics> implements StatsNoStreamCmd {

    private String containerId;

    public StatsNoStreamCmdImpl(StatsNoStreamCmd.Exec exec, String containerId) {
        super(exec);
        withContainerId(containerId);
    }

    @Override
    public StatsNoStreamCmd withContainerId(String containerId) {
        checkNotNull(containerId, "containerId was not specified");
        this.containerId = containerId;
        return this;
    }

    @Override
    public String getContainerId() {
        return containerId;
    }
}
