package com.teragence.library;

enum u1 {
    Location(0),
    Service(1),
    Cell(2),
    Signal(3),
    CellInfo(4);
    
    private final int b;

    private u1(int i) {
        this.b = i;
    }

    public int a() {
        return this.b;
    }
}
