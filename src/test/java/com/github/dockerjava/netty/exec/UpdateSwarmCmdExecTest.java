package com.github.dockerjava.netty.exec;

import com.github.dockerjava.api.exception.DockerException;
import com.github.dockerjava.api.exception.NotAcceptableException;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.netty.AbstractNettyDockerClientTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@Test(groups = "integration")
public class UpdateSwarmCmdExecTest extends AbstractNettyDockerClientTest {

    public static final Logger LOG = LoggerFactory.getLogger(UpdateSwarmCmdExecTest.class);

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

    public void updateSwarm() throws DockerException {
        SwarmSpec firstSpec = new SwarmSpec().withName("firstSpec");

        SwarmSpec secondSpec = new SwarmSpec()
                .withName("secondSpec")
                .withDispatcher(new SwarmDispatcher()
                        .withHeartbeatPeriod(10000000)
                ).withOrchestration(new SwarmOrchestration()
                        .withTaskHistoryRententionLimit(100)
                ).withCaConfig(new SwarmCAConfig()
                        .withNodeCertExpiry(60 * 60 * 1000000000L /*ns */))
                .withRaft(new SwarmRaft()
                        .withElectionTick(8)
                        .withSnapshotInterval(20000)
                        .withHeartbeatTick(5)
                        .withLogEntriesForSlowFollowers(200)
                ).withTaskDefaults(new TaskDefaults());

        dockerClient.initializeSwarmCmd(firstSpec)
                .withListenAddr("127.0.0.1")
                .exec();
        LOG.info("Initialized swarm: {}", firstSpec.toString());

        Swarm swarm = dockerClient.inspectSwarmCmd().exec();
        LOG.info("Inspected swarm: {}", swarm.toString());
        assertThat(swarm.getSpec(), is(not(equalTo(secondSpec))));

        dockerClient.updateSwarmCmd(secondSpec)
                .withVersion(swarm.getVersion().getIndex())
                .exec();
        LOG.info("Updated swarm: {}", secondSpec.toString());

        swarm = dockerClient.inspectSwarmCmd().exec();
        LOG.info("Inspected swarm: {}", swarm.toString());
        assertThat(swarm.getSpec(), is(equalTo(secondSpec)));
    }

    @Test(expectedExceptions = NotAcceptableException.class)
    public void updatingSwarmThrowsWhenNotInSwarm() throws DockerException {
        SwarmSpec swarmSpec = new SwarmSpec()
                .withName("swarm");

        Swarm swarm = dockerClient.inspectSwarmCmd().exec();
        LOG.info("Inspected swarm: {}", swarm.toString());

        dockerClient.updateSwarmCmd(swarmSpec)
                .withVersion(swarm.getVersion().getIndex())
                .exec();
    }

}
