package com.github.dockerjava.core.command;

import com.github.dockerjava.api.model.SwarmNode;
import com.github.dockerjava.api.model.SwarmSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.List;

@Test(groups = "swarm-integration")
public class ListSwarmNodesCmdImplTest extends AbstractSwarmDockerClientTest {
    public static final Logger LOG = LoggerFactory.getLogger(ListSwarmNodesCmdImplTest.class);

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
    public void listSwarmNodes() {
        dockerClient.initializeSwarmCmd(new SwarmSpec()).withListenAddr("127.0.0.1").exec();

        List<SwarmNode> swarmNodes = dockerClient.listSwarmNodesCmd().exec();
    }
}
