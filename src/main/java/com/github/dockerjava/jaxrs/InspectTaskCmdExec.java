package com.github.dockerjava.jaxrs;

import com.github.dockerjava.api.command.InspectTaskCmd;
import com.github.dockerjava.api.model.Task;
import com.github.dockerjava.core.DockerClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class InspectTaskCmdExec extends AbstrSyncDockerCmdExec<InspectTaskCmd, Task>
        implements InspectTaskCmd.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(InspectTaskCmdExec.class);

    public InspectTaskCmdExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    @Override
    protected Task execute(InspectTaskCmd command) {
        WebTarget webResource = getBaseResource().path("/tasks/{id}")
                .resolveTemplate("id", command.getTaskId());

        LOGGER.debug("GET: {}", webResource);
        return webResource.request().accept(MediaType.APPLICATION_JSON).get(Task.class);
    }
}
