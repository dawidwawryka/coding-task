package com.hsbc;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

final class Room {

    private final String name;
    private final List<Integer> applicableOrdinals;

    Room(final String name, final Exposition... applicableExpositions) {
        Objects.requireNonNull(name, "Room name cannot be null");
        this.name = name;
        applicableOrdinals = Stream.of(applicableExpositions)
                .map(Enum::ordinal)
                .collect(toList());
    }

    String getName() {
        return name;
    }

    boolean isRightExposition(final int ordinal) {
        return applicableOrdinals.contains(ordinal);
    }
}
