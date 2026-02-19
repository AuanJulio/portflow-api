package com.portflow.core.domain.enums;

public enum ContainerSize {
    TWENTY_FOOT(20),
    FORTY_FOOT(40);

    private final int size;
    ContainerSize(int size) { this.size = size; }
    public int getSize() { return size; }
}
