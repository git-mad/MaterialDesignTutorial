package com.gitmad.tejasvinareddyteju.materialdesign.model;

/**
 * Class the represents the data in an text item.
 *
 * @author nareddyt
 */
public class TextContent implements Comparable<TextContent> {
    private final String name;

    public TextContent(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(TextContent another) {
        return name.compareTo(another.name);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof TextContent)) {
            return false;
        }

        TextContent aw = (TextContent) other;

        return aw.name.equals(name);
    }

    @Override
    public String toString() {
        return name + "-" + super.toString();
    }

    public String getName() {
        return name;
    }
}
