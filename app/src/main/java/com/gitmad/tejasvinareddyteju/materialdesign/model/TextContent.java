package com.gitmad.tejasvinareddyteju.materialdesign.model;

public class TextContent implements Comparable<TextContent> {
    private final String packageName;
    private int loadCount;

    public TextContent(String packageName) {

        if (packageName == null) {
            throw new IllegalArgumentException("Invalid package name!");
        }

        this.packageName = packageName;
        loadCount = 1;
    }

    @Override
    public int compareTo(TextContent another) {
        return packageName.compareTo(another.packageName);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof TextContent)) {
            return false;
        }

        TextContent aw = (TextContent) other;

        return aw.packageName.equals(packageName);
    }

    @Override
    public String toString() {
        return packageName + "-" + super.toString();
    }

    public int getLoadCount() {
        return loadCount;
    }

    public String getPackageName() {
        return packageName;
    }

    public void incrementLoadCount() {
        loadCount++;
    }
}
