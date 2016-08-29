package com.github.dockerjava.netty.exec;

import com.github.dockerjava.api.exception.DockerException;
import com.github.dockerjava.api.exception.NotAcceptableException;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.RemoteApiVersion;
import com.github.dockerjava.netty.AbstractNettyDockerClientTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static com.github.dockerjava.utils.TestUtils.getVersion;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Test(groups = "integration")
public class LeaveSwarmCmdExecTest extends AbstractNettyDockerClientTest {

    public static final Logger LOG = LoggerFactory.getLogger(LeaveSwarmCmdExecTest.class);

    @BeforeTest
    public void beforeTest() throws Exception {
        super.beforeTest();

        final RemoteApiVersion apiVersion = getVersion(dockerClient);
        if (!apiVersion.isGreaterOrEqual(RemoteApiVersion.VERSION_1_24)) {
            throw new SkipException("API version should be >= 1.24");
        }
    }

    @AfterTest
    public void afterTest() {
        super.afterTest();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        super.beforeMethod(method);
        leaveIfInSwarm();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        super.afterMethod(result);
    }

    private void leaveIfInSwarm() {
        try {
            // force in case this is a swarm manager
            dockerClient.leaveSwarmCmd().withForceEnabled(true).exec();
        } catch (NotAcceptableException e) {
            // do nothing, node is not part of a swarm
        }
    }

    public void leaveSwarmAsMaster() throws DockerException {
        SwarmSpec swarmSpec = new SwarmSpec().withName("firstSpec");
        dockerClient.initializeSwarmCmd(swarmSpec)
                .withListenAddr("127.0.0.1")
                .exec();
        LOG.info("Initialized swarm: {}", swarmSpec.toString());

        Info info = dockerClient.infoCmd().exec();
        LOG.info("Inspected docker: {}", info.toString());

        assertThat(info.getSwarm().getLocalNodeState(), is(LocalNodeState.ACTIVE));

        dockerClient.leaveSwarmCmd()
                .withForceEnabled(true)
                .exec();
        LOG.info("Left swarm");

        info = dockerClient.infoCmd().exec();
        LOG.info("Inspected docker: {}", info.toString());

        assertThat(info.getSwarm().getLocalNodeState(), is(LocalNodeState.INACTIVE));

    }

    @Test(expectedExceptions = NotAcceptableException.class)
    public void leavingSwarmThrowsWhenNotInSwarm() throws DockerException {
        dockerClient.leaveSwarmCmd().exec();
    }

}
