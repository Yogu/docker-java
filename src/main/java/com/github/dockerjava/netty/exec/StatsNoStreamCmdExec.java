package com.github.dockerjava.netty.exec;


import com.fasterxml.jackson.core.type.TypeReference;
import com.github.dockerjava.api.model.Statistics;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.netty.MediaType;
import com.github.dockerjava.netty.WebTarget;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatsNoStreamCmdExec extends AbstrSyncDockerCmdExec<StatsNoStreamCmd, Statistics>
        implements StatsNoStreamCmd.Exec {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatsNoStreamCmdExec.class);

    public StatsNoStreamCmdExec(WebTarget baseResource, DockerClientConfig dockerClientConfig) {
        super(baseResource, dockerClientConfig);
    }

    @Override
    protected Statistics execute(StatsNoStreamCmd command) {
        WebTarget webResource = getBaseResource().path("/nodes/{id}").resolveTemplate("id",
                command.getContainerId()).queryParam("stream", false);

        LOGGER.debug("GET: {}", webResource);
        return webResource.request().accept(MediaType.APPLICATION_JSON)
                .get(new TypeReference<Statistics>() {
                });
    }
}
