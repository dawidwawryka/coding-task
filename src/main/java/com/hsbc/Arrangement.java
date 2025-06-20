package com.hsbc;

import java.util.List;
import java.util.stream.Stream;

final class Arrangement {

    private final List<Room> permutation;

    Arrangement(final List<Room> permutation) {
        this.permutation = permutation;
    }

    boolean isRightExposition() {
        int i = 0;
        for (Room room : permutation) {
            if (!room.isRightExposition(i++)) {
                return false;
            }
        }
        return true;
    }

    Stream<String> getOrderedRoomNames() {
        return permutation.stream()
                .map(Room::getName);
    }
}
