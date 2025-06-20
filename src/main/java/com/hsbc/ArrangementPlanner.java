package com.hsbc;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public final class ArrangementPlanner {

    @SuppressWarnings("java: S106")
    public static void main(String[] args) {
        final List<Room> rooms = GroundFloorRooms.getRooms();
        final TemplateSupplier templateSupplier = new TemplateSupplier(rooms);
        final Consumer<Stream<String>> print =
                stream -> System.out.printf(templateSupplier.get(), stream.toArray());
        Permutations.allPermutations(rooms)
                .parallel()
                .map(Arrangement::new)
                .filter(Arrangement::isRightExposition)
                .map(Arrangement::getOrderedRoomNames)
                .forEach(print);
    }
}
