package com.hsbc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.hsbc.Exposition.*;

@SuppressWarnings("unused")
final class GroundFloorRooms {

    private static final List<Room> rooms;

    static {
        final List<Room> mutableRooms = new ArrayList<>(8);
        mutableRooms.add(new Room ("Bedroom", NW, SW, SE));
        mutableRooms.add(new Room ("Entryway", N, W));
        mutableRooms.add(new Room ("Basement", N, NE));
        mutableRooms.add(new Room ("Bathroom", N, NE, E));
        mutableRooms.add(new Room ("Kitchen", NW, NE, E, SE));
        mutableRooms.add(new Room ("Dining Room", W, E, SW, S, SE));
        mutableRooms.add(new Room ("Living Room", SW, S, SE));
        mutableRooms.add(new Room ("Stairs", N, S));
        rooms = Collections.unmodifiableList(mutableRooms);
    }

    static List<Room> getRooms () {
        return rooms;
    }

    private GroundFloorRooms() {}
}
