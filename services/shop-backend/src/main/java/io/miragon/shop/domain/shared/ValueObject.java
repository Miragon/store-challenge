package io.miragon.shop.domain.shared;

import java.util.Objects;

public abstract class ValueObject<T> {
    protected final T value;

    protected ValueObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || other.getClass() != this.getClass()) return false;
        ValueObject<?> that = (ValueObject<?>) other;
        return Objects.equals(this.value, that.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
