package com.cellrebel.sdk.youtube.ui.menu;

public class MenuItem {
    private final String a;
    private final int b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MenuItem menuItem = (MenuItem) obj;
        return this.b == menuItem.b && this.a.equals(menuItem.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }
}
