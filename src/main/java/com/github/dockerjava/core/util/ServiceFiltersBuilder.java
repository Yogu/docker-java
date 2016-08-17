package com.github.dockerjava.core.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representation of filters to service lists.
 */
public class ServiceFiltersBuilder {

    private Map<String, List<String>> filters = new HashMap<String, List<String>>();

    public ServiceFiltersBuilder() {
    }

    public ServiceFiltersBuilder withFilter(String key, String... value) {
        filters.put(key, Arrays.asList(value));
        return this;
    }

    public ServiceFiltersBuilder withFilter(String key, List<String> value) {
        filters.put(key, value);
        return this;
    }

    public List<String> getFilter(String key) {
        return filters.get(key);
    }

    public ServiceFiltersBuilder withIds(List<String> ids) {
        withFilter("id", ids);
        return this;
    }

    public List<String> getIds() {
        return getFilter("name");
    }

    public ServiceFiltersBuilder withNames(List<String> names) {
        withFilter("name", names);
        return this;
    }

    public List<String> getNames() {
        return getFilter("names");
    }

    // CHECKSTYLE:OFF
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ServiceFiltersBuilder filters1 = (ServiceFiltersBuilder) o;

        return filters.equals(filters1.filters);

    }

    // CHECKSTYLE:ON

    @Override
    public int hashCode() {
        return filters.hashCode();
    }

    public Map<String, List<String>> build() {
        return filters;
    }
}
