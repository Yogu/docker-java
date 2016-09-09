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
import org.testng.collections.Lists;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Test(groups = "swarm-integration")
public class ListSwarmNodesCmdExecTest extends AbstractSwarmDockerClientTest {
    public static final Logger LOG = LoggerFactory.getLogger(ListSwarmNodesCmdExecTest.class);

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

        DockerClient docker = setUpSwarmNodes();
        List<SwarmNode> swarmNodes = docker.listSwarmNodesCmd().exec();
        assertEquals(swarmNodes.size(), 5);
        String testId = swarmNodes.get(0).getId();

        // update SwarmNode for testing of filteringMethods
        Map<String, String> labels = new HashMap<>();
        labels.put("testLabel", "testLabelKey");
        docker.updateSwarmNodeCmd(testId, new SwarmNodeSpec().withAvailability(SwarmNodeAvailability.ACTIVE).withLabels(labels).withName("testNode").withRole(SwarmNodeRole.MANAGER)).withVersion(swarmNodes.get(0).getVersion().getIndex()).exec();


        swarmNodes = docker.listSwarmNodesCmd().exec();


        List<String> ids = new ArrayList<>();
        ids.add(testId);

        // test id filter
        List<SwarmNode> filteredNodes = docker.listSwarmNodesCmd().withIdFilter(ids).exec();
        assertEquals(filteredNodes.size(), 1);
        String wrongId = "NOID";
        ids.clear();
        ids.add(wrongId);
        filteredNodes = docker.listSwarmNodesCmd().withIdFilter(ids).exec();
        assertEquals(filteredNodes.isEmpty(), true);

        // TODO test memberShipFilter

        // testNameFilter
        List<String> names = new ArrayList<>();
        names.add(swarmNodes.get(0).getSpec().getName());
        filteredNodes = docker.listSwarmNodesCmd().withNameFilter(names).exec();
        assertEquals(filteredNodes.size(), 1);

        // testRoleFilter
        filteredNodes = docker.listSwarmNodesCmd().withRoleFilter(Lists.newArrayList(swarmNodes.get(0).getSpec().getRole().name())).exec();
        assertEquals(filteredNodes.size(), 1);

    }

}
