package com.github.dockerjava.netty.exec;


import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.SwarmNode;
import com.github.dockerjava.api.model.SwarmNodeAvailability;
import com.github.dockerjava.api.model.SwarmNodeRole;
import com.github.dockerjava.api.model.SwarmNodeSpec;
import com.github.dockerjava.netty.AbstractNettySwarmDockerClientTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;

public class RemoveSwarmNodeCmdExecTest extends AbstractNettySwarmDockerClientTest {
    public static final Logger LOG = LoggerFactory.getLogger(RemoveSwarmNodeCmdExecTest.class);

    @BeforeTest
    public void beforeTest() throws Exception {
        super.beforeTest();
    }

    @AfterTest
    public void afterTest() {
        super.afterTest();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        super.beforeMethod(method);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        super.afterMethod(result);
    }

    @Test
    public void removeSwarmNode() {
        DockerClient docker = setUpSwarmNodes();

        List<SwarmNode> swarmNodes = docker.listSwarmNodesCmd().exec();

        //node must be worker so it can be removed
        docker.updateSwarmNodeCmd(swarmNodes.get(1).getId(), new SwarmNodeSpec().withName("remove").withRole(SwarmNodeRole.WORKER).withAvailability(SwarmNodeAvailability.PAUSE)).withVersion(swarmNodes.get(1).getVersion().getIndex()).exec();

        assertEquals(swarmNodes.size(), 5);

        docker.removeSwarmNodeCmd(swarmNodes.get(1).getId()).exec();

        assertEquals(swarmNodes.size(), 4);

    }
}
