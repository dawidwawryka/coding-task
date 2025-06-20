package com.hsbc;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import static com.hsbc.Exposition.*;

final class TemplateSupplier implements Supplier<String> {

    private static final String PLUS = "+";
    private static final String VERTICAL = "|";
    private static final String NEW_LINE = "%n";

    private final String template;

    TemplateSupplier(final List<Room> rooms) {
        if (rooms.size() != values().length) {
            throw new InvalidRoomsAmountException();
        }
        final int maxLength = rooms.stream()
                .map(Room::getName)
                .mapToInt(String::length)
                .max()
                .orElseThrow(InvalidRoomsAmountException::new);
        final String cellBorder = String.join("", Collections.nCopies(maxLength + 2, "-"));
        final String middleCell = String.join("", Collections.nCopies(maxLength + 2, " "));
        final String cellTemplate = " %-" + maxLength + "s ";
        template = PLUS + cellBorder + PLUS + cellBorder + PLUS + cellBorder + PLUS + NEW_LINE
                + VERTICAL + cellTemplate + VERTICAL + cellTemplate + VERTICAL + cellTemplate + VERTICAL + NEW_LINE
                + PLUS + cellBorder + PLUS + cellBorder + PLUS + cellBorder + PLUS + NEW_LINE
                + VERTICAL + cellTemplate + VERTICAL + middleCell + VERTICAL + cellTemplate + VERTICAL + NEW_LINE
                + PLUS + cellBorder + PLUS + cellBorder + PLUS + cellBorder + PLUS + NEW_LINE
                + VERTICAL + cellTemplate + VERTICAL + cellTemplate + VERTICAL + cellTemplate + VERTICAL + NEW_LINE
                + PLUS + cellBorder + PLUS + cellBorder + PLUS + cellBorder + PLUS + NEW_LINE
                + NEW_LINE + NEW_LINE + NEW_LINE;
    }

    @Override
    public String get() {
        return template;
    }
}
