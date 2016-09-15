package com.github.dockerjava.netty.exec;

import com.github.dockerjava.api.model.ContainerSpec;
import com.github.dockerjava.api.model.ServiceSpec;
import com.github.dockerjava.api.model.SwarmSpec;
import com.github.dockerjava.api.model.Task;
import com.github.dockerjava.api.model.TaskSpec;
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

public class ListTasksCmdExecTest extends AbstractNettySwarmDockerClientTest {
    public static final Logger LOG = LoggerFactory.getLogger(ListTasksCmdExecTest.class);

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

        dockerClient.createServiceCmd(new ServiceSpec()
                .withName("testService")
                .withTaskTemplate(new TaskSpec()
                        .withContainerSpec(new ContainerSpec()
                                .withImage("busybox"))))
                .exec();

        List<Task> tasks = dockerClient.listTaskCmd().exec();

        assertEquals(tasks.size(), 1);

    }
}
