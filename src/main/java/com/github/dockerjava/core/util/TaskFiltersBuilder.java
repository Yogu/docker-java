package com.github.dockerjava.core.util;

import com.github.dockerjava.api.model.TaskState;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.*;

/**
 * Representation of filters to task lists.
 */
public class TaskFiltersBuilder {
    private Map<String, List<String>> filters = new HashMap<String, List<String>>();

    public TaskFiltersBuilder() {
    }

    public TaskFiltersBuilder withFilter(String key, String... value) {
        filters.put(key, Arrays.asList(value));
        return this;
    }

    public TaskFiltersBuilder withFilter(String key, List<String> value) {
        filters.put(key, value);
        return this;
    }

    public List<String> getFilter(String key) {
        return filters.get(key);
    }

    public TaskFiltersBuilder withIds(List<String> ids) {
        withFilter("id", ids);
        return this;
    }

    public List<String> getIds() {
        return getFilter("name");
    }

    public TaskFiltersBuilder withNames(List<String> names) {
        withFilter("name", names);
        return this;
    }

    public List<String> getNames() {
        return getFilter("names");
    }


    /**
     * Filter by labels
     *
     * @param labels string array in the form ["key"] or ["key=value"] or a mix of both
     */
    public TaskFiltersBuilder withLabels(String... labels) {
        withFilter("label", labels);
        return this;
    }

    /**
     * Filter by labels
     *
     * @param labels {@link Map} of labels that contains label keys and values
     */
    public TaskFiltersBuilder withLabels(Map<String, String> labels) {
        withFilter("label", labelsMapToList(labels).toArray(new String[labels.size()]));
        return this;
    }

    private static List<String> labelsMapToList(Map<String, String> labels) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, String> entry : labels.entrySet()) {
            String rest = (entry.getValue() != null & !entry.getValue().isEmpty()) ? "=" + entry.getValue() : "";

            String label = entry.getKey() + rest;

            result.add(label);
        }
        return result;
    }

    public TaskFiltersBuilder withServices(List<String> serviceName) {
        withFilter("service", serviceName);
        return this;
    }

    public List<String> getService() {
        return getFilter("service");
    }

    public TaskFiltersBuilder withNodes(List<String> nodeId) {
        withFilter("node", nodeId);
        return this;
    }

    public List<String> getNode() {
        return getFilter("node");
    }

    public TaskFiltersBuilder withDesiredState(List<String> state) {
        withFilter("desired-state", state);
        return this;
    }

    public List<String> getDesiredState() {
        return getFilter("desired-state");
    }



    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);

    }

    @Override
    public int hashCode() {
        return filters.hashCode();
    }

    public Map<String, List<String>> build() {
        return filters;
    }
}
