package com.github.dockerjava.core.command;

import com.github.dockerjava.api.command.ListTasksCmd;
import com.github.dockerjava.api.model.Task;
import com.github.dockerjava.core.util.TaskFiltersBuilder;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * List tasks.
 */
public class ListTasksCmdImpl extends AbstrDockerCmd<ListTasksCmd, List<Task>> implements
        ListTasksCmd {

    private TaskFiltersBuilder filters = new TaskFiltersBuilder();

    public ListTasksCmdImpl(Exec exec) {
        super(exec);
    }

    @Override
    public Map<String, List<String>> getFilters() {
        return filters.build();
    }

    @Override
    public ListTasksCmd withIdFilter(List<String> ids) {
        checkNotNull(ids, "ids was not specified");
        this.filters.withIds(ids);
        return this;
    }

    @Override
    public ListTasksCmd withNameFilter(List<String> names) {
        checkNotNull(names, "names was not specified");
        this.filters.withNames(names);
        return this;
    }

    @Override
    public ListTasksCmd withServiceFilter(List<String> services) {
        checkNotNull(services, "services was not specified");
        this.filters.withServices(services);
        return this;
    }

    @Override
    public ListTasksCmd withNodeFilter(List<String> nodes) {
        checkNotNull(nodes, "nodes was not specified");
        this.filters.withNodes(nodes);
        return this;
    }

    @Override
    public ListTasksCmd withLabelFilter(String... labels) {
        checkNotNull(labels, "labels was not specified");
        this.filters.withLabels(labels);
        return this;
    }

    @Override
    public ListTasksCmd withLabelFilter(Map<String, String> labels) {
        checkNotNull(labels, "labels was not specified");
        this.filters.withLabels(labels);
        return this;
    }

    @Override
    public ListTasksCmd withDesiredStateFilter(List<String> desiredStates) {
        checkNotNull(desiredStates, "desiredStates was not specified");
        this.filters.withDesiredState(desiredStates);
        return this;
    }
}
