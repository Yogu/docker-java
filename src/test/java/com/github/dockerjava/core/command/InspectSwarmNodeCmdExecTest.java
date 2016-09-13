package com.github.dockerjava.core.command;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.SwarmNode;
import com.github.dockerjava.api.model.SwarmNodeAvailability;
import com.github.dockerjava.api.model.SwarmNodeRole;
import com.github.dockerjava.api.model.SwarmNodeSpec;
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

public class InspectSwarmNodeCmdExecTest extends AbstractSwarmDockerClientTest {
    public static final Logger LOG = LoggerFactory.getLogger(InspectSwarmNodeCmdExecTest.class);

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
    public void inspectSwarmNode() {
        DockerClient docker = setUpSwarmNodes();

        List<SwarmNode> swarmNodes = docker.listSwarmNodesCmd().exec();
        docker.updateSwarmNodeCmd(swarmNodes.get(0).getId(), new SwarmNodeSpec().withName("testNode").withAvailability(SwarmNodeAvailability.ACTIVE).withRole(SwarmNodeRole.MANAGER)).withVersion(swarmNodes.get(0).getVersion().getIndex()).exec();

        SwarmNode testNode = docker.inspectSwarmNodeCmd(docker.listSwarmNodesCmd().exec().get(0).getId()).exec();


        assertEquals(testNode.getSpec().getName(), "testNode");
    }
}

