package com.umlaut.crowd.internal;

public class c2 implements Cloneable {
    public double DisplayDimension;
    public int DisplayOrientation;
    public int DisplayPixelDensity;
    public b2 DisplayPixelDensityAndroid = b2.Unknown;
    public int DisplayPixelHeight;
    public int DisplayPixelWidth;
    public float DisplayRealPixelDensityX;
    public float DisplayRealPixelDensityY;
    public float DisplayRefreshRate;
    public float DisplayScaledDensity;
    public d2 DisplayState = d2.Unknown;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
