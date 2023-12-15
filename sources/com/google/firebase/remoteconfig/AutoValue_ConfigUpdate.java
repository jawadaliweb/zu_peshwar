package com.google.firebase.remoteconfig;

import java.util.Objects;
import java.util.Set;

final class AutoValue_ConfigUpdate extends ConfigUpdate {
    private final Set<String> updatedKeys;

    AutoValue_ConfigUpdate(Set<String> set) {
        Objects.requireNonNull(set, "Null updatedKeys");
        this.updatedKeys = set;
    }

    public Set<String> getUpdatedKeys() {
        return this.updatedKeys;
    }

    public String toString() {
        return "ConfigUpdate{updatedKeys=" + this.updatedKeys + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConfigUpdate) {
            return this.updatedKeys.equals(((ConfigUpdate) obj).getUpdatedKeys());
        }
        return false;
    }

    public int hashCode() {
        return this.updatedKeys.hashCode() ^ 1000003;
    }
}
