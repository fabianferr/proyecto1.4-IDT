package stikerwap.appdys;

import android.graphics.Bitmap;

public class claseChat {
    protected Bitmap b1;
    protected String c1;
    protected String c2;
    protected boolean cargada_1;
    protected boolean coments;
    protected int fotos_chat;
    protected int fotos_perfil;
    protected boolean galeria;
    protected int id;
    protected int idapp;
    protected int idtema;
    protected boolean mostrada = false;
    protected int nfoto1;
    protected int nusus;
    protected int p_descr;
    protected int p_dist;
    protected int p_fnac;
    protected int p_sexo;
    protected boolean privados;
    protected String titulo;

    public claseChat(int i, int i2, int i3, String str, String str2, String str3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, boolean z2, boolean z3, int i10, Bitmap bitmap, int i11, boolean z4) {
        this.idapp = i;
        this.id = i2;
        this.idtema = i3;
        this.titulo = str;
        this.c1 = str2;
        this.c2 = str3;
        this.fotos_perfil = i4;
        this.p_fnac = i5;
        this.p_sexo = i6;
        this.p_descr = i7;
        this.p_dist = i8;
        this.fotos_chat = i9;
        this.privados = z;
        this.coments = z2;
        this.galeria = z3;
        this.nusus = i10;
        this.b1 = bitmap;
        this.nfoto1 = i11;
        this.cargada_1 = z4;
    }
}
