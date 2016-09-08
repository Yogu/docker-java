package com.github.dockerjava.core.command;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Swarm;
import com.github.dockerjava.api.model.SwarmJoinTokens;
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

        LOG.info("Initialized swarm docker1");
        DockerClient docker1 = startDockerInDocker();
        DockerClient docker2 = startDockerInDocker();

        docker1.initializeSwarmCmd(new SwarmSpec()).withListenAddr("127.0.0.1").exec();
        Swarm swarm = docker1.inspectSwarmCmd().exec();

        SwarmJoinTokens tokens = swarm.getJoinTokens();
        docker2.joinSwarmCmd()
                .withRemoteAddrs(new String[]{"docker1"})
                .withJoinToken(tokens.getManager())
                .exec();
        LOG.info("docker2 joined docker1's swarm");

        List<SwarmNode> swarmNodes = dockerClient.listSwarmNodesCmd().exec();

        System.out.println(swarmNodes.size());
    }

}
