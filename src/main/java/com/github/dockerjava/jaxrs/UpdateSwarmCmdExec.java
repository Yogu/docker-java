package com.github.dockerjava.jaxrs;

import com.github.dockerjava.api.command.UpdateSwarmCmd;
import com.github.dockerjava.core.DockerClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.client.Entity.entity;

public class UpdateSwarmCmdExec extends AbstrSyncDockerCmdExec<UpdateSwarmCmd, Void>
        implements UpdateSwarmCmd.Exec {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateSwarmCmdExec.class);

    public UpdateSwarmCmdExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    @Override
    protected Void execute(UpdateSwarmCmd command) {
        WebTarget webResource = getBaseResource().path("/swarm/update");

        if (command.getVersion() != null) {
            webResource.queryParam("version", command.getVersion());
        }

        if (command.getRotateManagerToken() != null) {
            webResource.queryParam("rotateManagerToken", command.getRotateManagerToken());
        }

        if (command.getRotateWorkerToken() != null) {
            webResource.queryParam("rotateWorkerToken", command.getRotateWorkerToken());
        }

        LOGGER.trace("POST: {} ", webResource);
        webResource.request().accept(MediaType.APPLICATION_JSON)
                .post(entity(command.getSwarmSpec(), MediaType.APPLICATION_JSON));
        return null;
    }
}
