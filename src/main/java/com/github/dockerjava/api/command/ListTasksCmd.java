package com.github.dockerjava.api.command;


import com.github.dockerjava.api.model.Task;
import com.github.dockerjava.core.RemoteApiVersion;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

/**
 * Command to list all tasks in a docker swarm. Task operations require the engine to be part of a swarm.
 *
 * @since {@link RemoteApiVersion#VERSION_1_24}
 */
public interface ListTasksCmd extends SyncDockerCmd<List<Task>> {

    @CheckForNull
    Map<String, List<String>> getFilters();

    /**
     * @param ids
     *            - Show only tasks with the given ids
     */
    ListTasksCmd withIdFilter(List<String> ids);

    /**
     *
     * @param names
     *            - Show only tasks with the given names
     */
    ListTasksCmd withNameFilter(List<String> names);

    /**
     *
     * @param services
     *            - Show only tasks with the given serviceNames
     */
    ListTasksCmd withServiceFilter(List<String> services);

    /**
     *
     * @param nodes
     *            - Show only tasks with the given nodeIds
     */
    ListTasksCmd withNodeFilter(List<String> nodes);

    /**
     * @param labels
     *            - Show only tasks with the passed labels.
     */
    ListTasksCmd withLabelFilter(String... labels);

    /**
     * @param labels
     *            - Show only tasks with the passed labels. Labels is a {@link Map} that contains label keys and values
     */
    ListTasksCmd withLabelFilter(Map<String, String> labels);

    /**
     *
     * @param desiredStates
     *            - Show only tasks with the given desiredState
     */
    ListTasksCmd withDesiredStateFilter(List<String> desiredStates);

    interface Exec extends DockerCmdSyncExec<ListTasksCmd, List<Task>> {
    }
}
