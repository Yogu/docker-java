package com.github.dockerjava.netty;

import com.github.dockerjava.core.TestDockerCmdExecFactory;
import com.github.dockerjava.core.command.AbstractSwarmCmdExecTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractNettySwarmDockerClientTest extends AbstractSwarmCmdExecTest {

    public static final Logger LOG = LoggerFactory.getLogger(AbstractNettySwarmDockerClientTest.class);

    @Override
    protected TestDockerCmdExecFactory initTestDockerCmdExecFactory() {
        return new TestDockerCmdExecFactory(new NettyDockerCmdExecFactory());
    }
}
