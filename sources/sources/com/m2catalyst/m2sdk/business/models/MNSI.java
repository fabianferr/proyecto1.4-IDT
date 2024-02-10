package com.m2catalyst.m2sdk.business.models;

import android.content.Context;
import com.google.common.base.Joiner;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.MobileNetworkSignalInfoMessage;
import com.m2catalyst.m2sdk.database.entities.MNSIEntity;
import com.m2catalyst.m2sdk.external.SDKState;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.m4;
import com.m2catalyst.m2sdk.o4;
import com.m2catalyst.m2sdk.s1;
import com.m2catalyst.m2sdk.y3;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b8\n\u0002\u0010\u0007\n\u0002\b-\n\u0002\u0010\u0015\n\u0002\b\u0018\n\u0002\u0010\u0006\n\u0003\bÐ\u0001\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0003\u0010\u0003B\u0012\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0005\b\u0003\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0007J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0000J\u000f\u0010 \u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00102\u001a\u0004\b8\u00104\"\u0004\b9\u00106R.\u0010;\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00068\u0006@FX\u000e¢\u0006\u0012\n\u0004\b;\u00102\u001a\u0004\b<\u00104\"\u0004\b=\u00106R*\u0010>\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b>\u0010\"\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bA\u0010\"\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R\"\u0010D\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bD\u0010\"\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R$\u0010G\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bG\u0010I\"\u0004\bJ\u0010KR$\u0010L\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bL\u0010H\u001a\u0004\bL\u0010I\"\u0004\bM\u0010KR$\u0010N\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010T\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bT\u0010O\u001a\u0004\bU\u0010Q\"\u0004\bV\u0010SR$\u0010W\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bW\u0010O\u001a\u0004\bX\u0010Q\"\u0004\bY\u0010SR$\u0010Z\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bZ\u0010O\u001a\u0004\b[\u0010Q\"\u0004\b\\\u0010SR$\u0010]\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b]\u0010O\u001a\u0004\b^\u0010Q\"\u0004\b_\u0010SR$\u0010`\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b`\u0010O\u001a\u0004\ba\u0010Q\"\u0004\bb\u0010SR$\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR$\u0010j\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bj\u0010O\u001a\u0004\bk\u0010Q\"\u0004\bl\u0010SR$\u0010m\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bm\u0010O\u001a\u0004\bn\u0010Q\"\u0004\bo\u0010SR$\u0010p\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bp\u0010O\u001a\u0004\bq\u0010Q\"\u0004\br\u0010SR$\u0010s\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bs\u0010O\u001a\u0004\bt\u0010Q\"\u0004\bu\u0010SR$\u0010v\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bv\u0010O\u001a\u0004\bw\u0010Q\"\u0004\bx\u0010SR$\u0010y\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\by\u0010O\u001a\u0004\bz\u0010Q\"\u0004\b{\u0010SR$\u0010|\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b|\u0010O\u001a\u0004\b}\u0010Q\"\u0004\b~\u0010SR&\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0014\n\u0004\b\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR,\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b\u0001\u0010SR(\u0010\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0001\u0010O\u001a\u0005\b\u0001\u0010Q\"\u0005\b \u0001\u0010SR(\u0010¡\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¡\u0001\u0010O\u001a\u0005\b¢\u0001\u0010Q\"\u0005\b£\u0001\u0010SR(\u0010¤\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¤\u0001\u0010O\u001a\u0005\b¥\u0001\u0010Q\"\u0005\b¦\u0001\u0010SR(\u0010§\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b§\u0001\u0010O\u001a\u0005\b¨\u0001\u0010Q\"\u0005\b©\u0001\u0010SR,\u0010«\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b­\u0001\u0010®\u0001\"\u0006\b¯\u0001\u0010°\u0001R,\u0010±\u0001\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b±\u0001\u0010¬\u0001\u001a\u0006\b²\u0001\u0010®\u0001\"\u0006\b³\u0001\u0010°\u0001R(\u0010´\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010O\u001a\u0005\bµ\u0001\u0010Q\"\u0005\b¶\u0001\u0010SR(\u0010·\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010O\u001a\u0005\b¸\u0001\u0010Q\"\u0005\b¹\u0001\u0010SR(\u0010º\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010O\u001a\u0005\b»\u0001\u0010Q\"\u0005\b¼\u0001\u0010SR(\u0010½\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010O\u001a\u0005\b¾\u0001\u0010Q\"\u0005\b¿\u0001\u0010SR(\u0010À\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010O\u001a\u0005\bÁ\u0001\u0010Q\"\u0005\bÂ\u0001\u0010SR(\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÃ\u0001\u0010O\u001a\u0005\bÄ\u0001\u0010Q\"\u0005\bÅ\u0001\u0010SR(\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÆ\u0001\u0010O\u001a\u0005\bÇ\u0001\u0010Q\"\u0005\bÈ\u0001\u0010SR(\u0010É\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010O\u001a\u0005\bÊ\u0001\u0010Q\"\u0005\bË\u0001\u0010SR(\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÌ\u0001\u0010O\u001a\u0005\bÍ\u0001\u0010Q\"\u0005\bÎ\u0001\u0010SR(\u0010Ï\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010O\u001a\u0005\bÐ\u0001\u0010Q\"\u0005\bÑ\u0001\u0010SR(\u0010Ò\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010O\u001a\u0005\bÓ\u0001\u0010Q\"\u0005\bÔ\u0001\u0010SR(\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010O\u001a\u0005\bÖ\u0001\u0010Q\"\u0005\b×\u0001\u0010SR(\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bØ\u0001\u0010O\u001a\u0005\bÙ\u0001\u0010Q\"\u0005\bÚ\u0001\u0010SR(\u0010Û\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÛ\u0001\u0010O\u001a\u0005\bÜ\u0001\u0010Q\"\u0005\bÝ\u0001\u0010SR(\u0010Þ\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÞ\u0001\u0010O\u001a\u0005\bß\u0001\u0010Q\"\u0005\bà\u0001\u0010SR(\u0010á\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bá\u0001\u0010O\u001a\u0005\bâ\u0001\u0010Q\"\u0005\bã\u0001\u0010SR(\u0010ä\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bä\u0001\u0010O\u001a\u0005\bå\u0001\u0010Q\"\u0005\bæ\u0001\u0010SR(\u0010ç\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010O\u001a\u0005\bè\u0001\u0010Q\"\u0005\bé\u0001\u0010SR(\u0010ê\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bê\u0001\u0010O\u001a\u0005\bë\u0001\u0010Q\"\u0005\bì\u0001\u0010SR(\u0010í\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010O\u001a\u0005\bî\u0001\u0010Q\"\u0005\bï\u0001\u0010SR(\u0010ð\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bð\u0001\u0010O\u001a\u0005\bñ\u0001\u0010Q\"\u0005\bò\u0001\u0010SR(\u0010ó\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bó\u0001\u0010O\u001a\u0005\bô\u0001\u0010Q\"\u0005\bõ\u0001\u0010SR,\u0010ö\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bö\u0001\u0010\u0001\u001a\u0006\b÷\u0001\u0010\u0001\"\u0006\bø\u0001\u0010\u0001R+\u0010ù\u0001\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R+\u0010ÿ\u0001\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bÿ\u0001\u0010ú\u0001\u001a\u0006\b\u0002\u0010ü\u0001\"\u0006\b\u0002\u0010þ\u0001R(\u0010\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0002\u0010O\u001a\u0005\b\u0002\u0010Q\"\u0005\b\u0002\u0010SR(\u0010\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0002\u0010O\u001a\u0005\b\u0002\u0010Q\"\u0005\b\u0002\u0010SR(\u0010\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0002\u0010O\u001a\u0005\b\u0002\u0010Q\"\u0005\b\u0002\u0010SR(\u0010\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0002\u0010O\u001a\u0005\b\u0002\u0010Q\"\u0005\b\u0002\u0010SR(\u0010\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0002\u0010O\u001a\u0005\b\u0002\u0010Q\"\u0005\b\u0002\u0010SR+\u0010\u0002\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0002\u0010ú\u0001\u001a\u0006\b\u0002\u0010ü\u0001\"\u0006\b\u0002\u0010þ\u0001R,\u0010\u0002\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0002\u0010¬\u0001\u001a\u0006\b\u0002\u0010®\u0001\"\u0006\b\u0002\u0010°\u0001R,\u0010\u0002\u001a\u0005\u0018\u00010ª\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0002\u0010¬\u0001\u001a\u0006\b\u0002\u0010®\u0001\"\u0006\b\u0002\u0010°\u0001R)\u0010\u0002\u001a\u00020c8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R(\u0010 \u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b \u0002\u00102\u001a\u0005\b¡\u0002\u00104\"\u0005\b¢\u0002\u00106R(\u0010£\u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b£\u0002\u00102\u001a\u0005\b¤\u0002\u00104\"\u0005\b¥\u0002\u00106R(\u0010¦\u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¦\u0002\u00102\u001a\u0005\b§\u0002\u00104\"\u0005\b¨\u0002\u00106R(\u0010©\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b©\u0002\u0010O\u001a\u0005\bª\u0002\u0010Q\"\u0005\b«\u0002\u0010SR(\u0010¬\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¬\u0002\u0010O\u001a\u0005\b­\u0002\u0010Q\"\u0005\b®\u0002\u0010SR(\u0010¯\u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¯\u0002\u00102\u001a\u0005\b°\u0002\u00104\"\u0005\b±\u0002\u00106R(\u0010²\u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b²\u0002\u00102\u001a\u0005\b³\u0002\u00104\"\u0005\b´\u0002\u00106R(\u0010µ\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bµ\u0002\u0010O\u001a\u0005\b¶\u0002\u0010Q\"\u0005\b·\u0002\u0010SR(\u0010¸\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¸\u0002\u0010O\u001a\u0005\b¹\u0002\u0010Q\"\u0005\bº\u0002\u0010SR(\u0010»\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b»\u0002\u0010O\u001a\u0005\b¼\u0002\u0010Q\"\u0005\b½\u0002\u0010SR(\u0010¾\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b¾\u0002\u0010O\u001a\u0005\b¿\u0002\u0010Q\"\u0005\bÀ\u0002\u0010SR(\u0010Á\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÁ\u0002\u0010O\u001a\u0005\bÂ\u0002\u0010Q\"\u0005\bÃ\u0002\u0010SR(\u0010Ä\u0002\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÄ\u0002\u0010H\u001a\u0005\bÅ\u0002\u0010I\"\u0005\bÆ\u0002\u0010KR(\u0010Ç\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÇ\u0002\u0010O\u001a\u0005\bÈ\u0002\u0010Q\"\u0005\bÉ\u0002\u0010SR(\u0010Ê\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÊ\u0002\u0010O\u001a\u0005\bË\u0002\u0010Q\"\u0005\bÌ\u0002\u0010SR(\u0010Í\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÍ\u0002\u0010O\u001a\u0005\bÎ\u0002\u0010Q\"\u0005\bÏ\u0002\u0010SR(\u0010Ð\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÐ\u0002\u0010O\u001a\u0005\bÑ\u0002\u0010Q\"\u0005\bÒ\u0002\u0010SR(\u0010Ó\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÓ\u0002\u0010O\u001a\u0005\bÔ\u0002\u0010Q\"\u0005\bÕ\u0002\u0010SR(\u0010Ö\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÖ\u0002\u0010O\u001a\u0005\b×\u0002\u0010Q\"\u0005\bØ\u0002\u0010SR(\u0010Ù\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÙ\u0002\u0010O\u001a\u0005\bÚ\u0002\u0010Q\"\u0005\bÛ\u0002\u0010SR(\u0010Ü\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bÜ\u0002\u0010O\u001a\u0005\bÝ\u0002\u0010Q\"\u0005\bÞ\u0002\u0010SR(\u0010ß\u0002\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bß\u0002\u0010H\u001a\u0005\bà\u0002\u0010I\"\u0005\bá\u0002\u0010KR+\u0010â\u0002\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bâ\u0002\u0010ú\u0001\u001a\u0006\bã\u0002\u0010ü\u0001\"\u0006\bä\u0002\u0010þ\u0001R+\u0010å\u0002\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bå\u0002\u0010ú\u0001\u001a\u0006\bæ\u0002\u0010ü\u0001\"\u0006\bç\u0002\u0010þ\u0001R&\u0010è\u0002\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bè\u0002\u0010\"\u001a\u0005\bé\u0002\u0010$\"\u0005\bê\u0002\u0010&R(\u0010ë\u0002\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bë\u0002\u0010e\u001a\u0005\bì\u0002\u0010g\"\u0005\bí\u0002\u0010iR(\u0010î\u0002\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bî\u0002\u00102\u001a\u0005\bï\u0002\u00104\"\u0005\bð\u0002\u00106R&\u0010ñ\u0002\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bñ\u0002\u0010\"\u001a\u0005\bò\u0002\u0010$\"\u0005\bó\u0002\u0010&R(\u0010ô\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bô\u0002\u0010O\u001a\u0005\bô\u0002\u0010Q\"\u0005\bõ\u0002\u0010SR(\u0010ö\u0002\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bö\u0002\u0010H\u001a\u0005\bö\u0002\u0010I\"\u0005\b÷\u0002\u0010KR(\u0010ø\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\bø\u0002\u0010O\u001a\u0005\bù\u0002\u0010Q\"\u0005\bú\u0002\u0010SR,\u0010ü\u0002\u001a\u0005\u0018\u00010û\u00028\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bü\u0002\u0010ý\u0002\u001a\u0006\bþ\u0002\u0010ÿ\u0002\"\u0006\b\u0003\u0010\u0003R(\u0010\u0003\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0003\u00102\u001a\u0005\b\u0003\u00104\"\u0005\b\u0003\u00106R(\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0015\n\u0005\b\u0003\u0010O\u001a\u0005\b\u0003\u0010Q\"\u0005\b\u0003\u0010SR+\u0010\u0003\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0003\u0010ú\u0001\u001a\u0006\b\u0003\u0010ü\u0001\"\u0006\b\u0003\u0010þ\u0001¨\u0006\u0003"}, d2 = {"Lcom/m2catalyst/m2sdk/business/models/MNSI;", "", "", "type", "", "setNetworkGlobalType", "", "", "isAtLeastBasic", "isStandardCompleteness", "Lcom/m2catalyst/m2sdk/y3;", "networkDataUsage", "setNetworkData$m2sdk_release", "(Lcom/m2catalyst/m2sdk/y3;)V", "setNetworkData", "Landroid/content/Context;", "context", "addPermissionValues", "isBasicCompleteness", "Lcom/m2catalyst/m2sdk/database/entities/MNSIEntity;", "entity", "setup$m2sdk_release", "(Lcom/m2catalyst/m2sdk/database/entities/MNSIEntity;)V", "setup", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/MobileNetworkSignalInfoMessage;", "toMessage", "getUniqueCellIdentifier", "toString", "mnsi", "isSameAntenna", "toEntity$m2sdk_release", "()Lcom/m2catalyst/m2sdk/database/entities/MNSIEntity;", "toEntity", "id", "I", "getId", "()I", "setId", "(I)V", "transmitted", "getTransmitted", "setTransmitted", "", "timeStamp", "J", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "timeZone", "Ljava/lang/String;", "getTimeZone", "()Ljava/lang/String;", "setTimeZone", "(Ljava/lang/String;)V", "phoneType", "getPhoneType", "setPhoneType", "value", "networkTypeString", "getNetworkTypeString", "setNetworkTypeString", "networkType", "getNetworkType", "setNetworkType", "voiceNetworkType", "getVoiceNetworkType", "setVoiceNetworkType", "dataNetworkType", "getDataNetworkType", "setDataNetworkType", "isUsingCarrierAggregation", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setUsingCarrierAggregation", "(Ljava/lang/Boolean;)V", "is5GConnected", "set5GConnected", "dbm", "Ljava/lang/Integer;", "getDbm", "()Ljava/lang/Integer;", "setDbm", "(Ljava/lang/Integer;)V", "asu", "getAsu", "setAsu", "ecio", "getEcio", "setEcio", "rsrp", "getRsrp", "setRsrp", "rsrq", "getRsrq", "setRsrq", "subscriber", "getSubscriber", "setSubscriber", "", "barometric", "Ljava/lang/Float;", "getBarometric", "()Ljava/lang/Float;", "setBarometric", "(Ljava/lang/Float;)V", "bitErrorRate", "getBitErrorRate", "setBitErrorRate", "lteSignalStrength", "getLteSignalStrength", "setLteSignalStrength", "lteRsrp", "getLteRsrp", "setLteRsrp", "lteRsrq", "getLteRsrq", "setLteRsrq", "lteRssnr", "getLteRssnr", "setLteRssnr", "lteRssi", "getLteRssi", "setLteRssi", "lteCqi", "getLteCqi", "setLteCqi", "lteDbm", "getLteDbm", "setLteDbm", "lteAsu", "getLteAsu", "setLteAsu", "lteTimingAdvance", "getLteTimingAdvance", "setLteTimingAdvance", "lteCi", "getLteCi", "setLteCi", "ltePci", "getLtePci", "setLtePci", "lteTac", "getLteTac", "setLteTac", "", "lteBand", "[I", "getLteBand", "()[I", "setLteBand", "([I)V", "lteEarfcn", "getLteEarfcn", "setLteEarfcn", "lteBandwidth", "getLteBandwidth", "setLteBandwidth", "cdmaDbm", "getCdmaDbm", "setCdmaDbm", "cdmaAsu", "getCdmaAsu", "setCdmaAsu", "cdmaEcio", "getCdmaEcio", "setCdmaEcio", "baseStationId", "getBaseStationId", "setBaseStationId", "", "baseStationLatitude", "Ljava/lang/Double;", "getBaseStationLatitude", "()Ljava/lang/Double;", "setBaseStationLatitude", "(Ljava/lang/Double;)V", "baseStationLongitude", "getBaseStationLongitude", "setBaseStationLongitude", "networkId", "getNetworkId", "setNetworkId", "systemId", "getSystemId", "setSystemId", "evdoDbm", "getEvdoDbm", "setEvdoDbm", "evdoAsu", "getEvdoAsu", "setEvdoAsu", "evdoEcio", "getEvdoEcio", "setEvdoEcio", "evdoSnr", "getEvdoSnr", "setEvdoSnr", "gsmDbm", "getGsmDbm", "setGsmDbm", "gsmAsu", "getGsmAsu", "setGsmAsu", "gsmBitError", "getGsmBitError", "setGsmBitError", "cid", "getCid", "setCid", "lac", "getLac", "setLac", "gsmArfcn", "getGsmArfcn", "setGsmArfcn", "gsmBsic", "getGsmBsic", "setGsmBsic", "nrAsuLevel", "getNrAsuLevel", "setNrAsuLevel", "nrCsiRsrp", "getNrCsiRsrp", "setNrCsiRsrp", "nrCsiRsrq", "getNrCsiRsrq", "setNrCsiRsrq", "nrCsiSinr", "getNrCsiSinr", "setNrCsiSinr", "nrDbm", "getNrDbm", "setNrDbm", "nrLevel", "getNrLevel", "setNrLevel", "nrSsRsrp", "getNrSsRsrp", "setNrSsRsrp", "nrSsRsrq", "getNrSsRsrq", "setNrSsRsrq", "nrSsSinr", "getNrSsSinr", "setNrSsSinr", "nrBand", "getNrBand", "setNrBand", "nrNci", "Ljava/lang/Long;", "getNrNci", "()Ljava/lang/Long;", "setNrNci", "(Ljava/lang/Long;)V", "secondaryNrNci", "getSecondaryNrNci", "setSecondaryNrNci", "nrArfcn", "getNrArfcn", "setNrArfcn", "nrPci", "getNrPci", "setNrPci", "nrTac", "getNrTac", "setNrTac", "tdscdmaDbm", "getTdscdmaDbm", "setTdscdmaDbm", "tdscdmaAsu", "getTdscdmaAsu", "setTdscdmaAsu", "locationTimeStamp", "getLocationTimeStamp", "setLocationTimeStamp", "latitude", "getLatitude", "setLatitude", "longitude", "getLongitude", "setLongitude", "accuracy", "F", "getAccuracy", "()F", "setAccuracy", "(F)V", "locationProvider", "getLocationProvider", "setLocationProvider", "networkOperatorName", "getNetworkOperatorName", "setNetworkOperatorName", "networkCountryIso", "getNetworkCountryIso", "setNetworkCountryIso", "networkMnc", "getNetworkMnc", "setNetworkMnc", "networkMcc", "getNetworkMcc", "setNetworkMcc", "simOperatorName", "getSimOperatorName", "setSimOperatorName", "simCountryIso", "getSimCountryIso", "setSimCountryIso", "simMnc", "getSimMnc", "setSimMnc", "simMcc", "getSimMcc", "setSimMcc", "resourcesMnc", "getResourcesMnc", "setResourcesMnc", "resourcesMcc", "getResourcesMcc", "setResourcesMcc", "registered", "getRegistered", "setRegistered", "gpsAvailable", "getGpsAvailable", "setGpsAvailable", "wcdmaBitErrorRate", "getWcdmaBitErrorRate", "setWcdmaBitErrorRate", "wcdmaDbm", "getWcdmaDbm", "setWcdmaDbm", "wcdmaAsu", "getWcdmaAsu", "setWcdmaAsu", "wcdmaCid", "getWcdmaCid", "setWcdmaCid", "wcdmaLac", "getWcdmaLac", "setWcdmaLac", "wcdmaPsc", "getWcdmaPsc", "setWcdmaPsc", "psc", "getPsc", "setPsc", "wcdmaUarfcn", "getWcdmaUarfcn", "setWcdmaUarfcn", "roaming", "getRoaming", "setRoaming", "dataRx", "getDataRx", "setDataRx", "dataTx", "getDataTx", "setDataTx", "level", "getLevel", "setLevel", "indoorOutdoorWeight", "getIndoorOutdoorWeight", "setIndoorOutdoorWeight", "cellIdentifier", "getCellIdentifier", "setCellIdentifier", "simSlot", "getSimSlot", "setSimSlot", "isDataDefaultSim", "setDataDefaultSim", "isPrimaryConnection", "setPrimaryConnection", "overrideNetworkType", "getOverrideNetworkType", "setOverrideNetworkType", "Lcom/m2catalyst/m2sdk/business/models/DataCompleteness;", "completeness", "Lcom/m2catalyst/m2sdk/business/models/DataCompleteness;", "getCompleteness", "()Lcom/m2catalyst/m2sdk/business/models/DataCompleteness;", "setCompleteness", "(Lcom/m2catalyst/m2sdk/business/models/DataCompleteness;)V", "permissions", "getPermissions", "setPermissions", "timeZoneOffset", "getTimeZoneOffset", "setTimeZoneOffset", "celltowerInfoTimestamp", "getCelltowerInfoTimestamp", "setCelltowerInfoTimestamp", "<init>", "()V", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: MNSI.kt */
public class MNSI {
    private float accuracy;
    private Integer asu;
    private Float barometric;
    private Integer baseStationId;
    private Double baseStationLatitude;
    private Double baseStationLongitude;
    private Integer bitErrorRate;
    private Integer cdmaAsu;
    private Integer cdmaDbm;
    private Integer cdmaEcio;
    private String cellIdentifier;
    private Long celltowerInfoTimestamp;
    private Integer cid;
    private DataCompleteness completeness;
    private int dataNetworkType;
    private Long dataRx;
    private Long dataTx;
    private Integer dbm;
    private Integer ecio;
    private Integer evdoAsu;
    private Integer evdoDbm;
    private Integer evdoEcio;
    private Integer evdoSnr;
    private Boolean gpsAvailable;
    private Integer gsmArfcn;
    private Integer gsmAsu;
    private Integer gsmBitError;
    private Integer gsmBsic;
    private Integer gsmDbm;
    private int id;
    private Float indoorOutdoorWeight;
    private Boolean is5GConnected;
    private Integer isDataDefaultSim;
    private Boolean isPrimaryConnection;
    private Boolean isUsingCarrierAggregation;
    private Integer lac;
    private Double latitude;
    private int level;
    private String locationProvider;
    private Long locationTimeStamp;
    private Double longitude;
    private Integer lteAsu;
    private int[] lteBand;
    private Integer lteBandwidth;
    private Integer lteCi;
    private Integer lteCqi;
    private Integer lteDbm;
    private Integer lteEarfcn;
    private Integer ltePci;
    private Integer lteRsrp;
    private Integer lteRsrq;
    private Integer lteRssi;
    private Integer lteRssnr;
    private Integer lteSignalStrength;
    private Integer lteTac;
    private Integer lteTimingAdvance;
    private String networkCountryIso;
    private Integer networkId;
    private Integer networkMcc;
    private Integer networkMnc;
    private String networkOperatorName;
    private int networkType;
    private String networkTypeString;
    private Integer nrArfcn;
    private Integer nrAsuLevel;
    private int[] nrBand;
    private Integer nrCsiRsrp;
    private Integer nrCsiRsrq;
    private Integer nrCsiSinr;
    private Integer nrDbm;
    private Integer nrLevel;
    private Long nrNci;
    private Integer nrPci;
    private Integer nrSsRsrp;
    private Integer nrSsRsrq;
    private Integer nrSsSinr;
    private Integer nrTac;
    private Integer overrideNetworkType;
    private String permissions;
    private String phoneType;
    private Integer psc;
    private Integer registered;
    private Integer resourcesMcc;
    private Integer resourcesMnc;
    private Boolean roaming;
    private Integer rsrp;
    private Integer rsrq;
    private Long secondaryNrNci;
    private String simCountryIso;
    private Integer simMcc;
    private Integer simMnc;
    private String simOperatorName;
    private int simSlot;
    private Integer subscriber;
    private Integer systemId;
    private Integer tdscdmaAsu;
    private Integer tdscdmaDbm;
    private long timeStamp;
    private String timeZone;
    private Integer timeZoneOffset;
    private int transmitted;
    private int voiceNetworkType;
    private Integer wcdmaAsu;
    private Integer wcdmaBitErrorRate;
    private Integer wcdmaCid;
    private Integer wcdmaDbm;
    private Integer wcdmaLac;
    private Integer wcdmaPsc;
    private Integer wcdmaUarfcn;

    public MNSI() {
        this.level = -1;
        this.simSlot = -1;
    }

    public final void addPermissionValues(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.permissions = o4.a(SDKState.Companion.getInstance(), context, "mnsi");
    }

    public final float getAccuracy() {
        return this.accuracy;
    }

    public final Integer getAsu() {
        return this.asu;
    }

    public final Float getBarometric() {
        return this.barometric;
    }

    public final Integer getBaseStationId() {
        return this.baseStationId;
    }

    public final Double getBaseStationLatitude() {
        return this.baseStationLatitude;
    }

    public final Double getBaseStationLongitude() {
        return this.baseStationLongitude;
    }

    public final Integer getBitErrorRate() {
        return this.bitErrorRate;
    }

    public final Integer getCdmaAsu() {
        return this.cdmaAsu;
    }

    public final Integer getCdmaDbm() {
        return this.cdmaDbm;
    }

    public final Integer getCdmaEcio() {
        return this.cdmaEcio;
    }

    public final String getCellIdentifier() {
        return this.cellIdentifier;
    }

    public final Long getCelltowerInfoTimestamp() {
        return this.celltowerInfoTimestamp;
    }

    public final Integer getCid() {
        return this.cid;
    }

    public final DataCompleteness getCompleteness() {
        return this.completeness;
    }

    public final int getDataNetworkType() {
        return this.dataNetworkType;
    }

    public final Long getDataRx() {
        return this.dataRx;
    }

    public final Long getDataTx() {
        return this.dataTx;
    }

    public final Integer getDbm() {
        return this.dbm;
    }

    public final Integer getEcio() {
        return this.ecio;
    }

    public final Integer getEvdoAsu() {
        return this.evdoAsu;
    }

    public final Integer getEvdoDbm() {
        return this.evdoDbm;
    }

    public final Integer getEvdoEcio() {
        return this.evdoEcio;
    }

    public final Integer getEvdoSnr() {
        return this.evdoSnr;
    }

    public final Boolean getGpsAvailable() {
        return this.gpsAvailable;
    }

    public final Integer getGsmArfcn() {
        return this.gsmArfcn;
    }

    public final Integer getGsmAsu() {
        return this.gsmAsu;
    }

    public final Integer getGsmBitError() {
        return this.gsmBitError;
    }

    public final Integer getGsmBsic() {
        return this.gsmBsic;
    }

    public final Integer getGsmDbm() {
        return this.gsmDbm;
    }

    public final int getId() {
        return this.id;
    }

    public final Float getIndoorOutdoorWeight() {
        return this.indoorOutdoorWeight;
    }

    public final Integer getLac() {
        return this.lac;
    }

    public final Double getLatitude() {
        return this.latitude;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getLocationProvider() {
        return this.locationProvider;
    }

    public final Long getLocationTimeStamp() {
        return this.locationTimeStamp;
    }

    public final Double getLongitude() {
        return this.longitude;
    }

    public final Integer getLteAsu() {
        return this.lteAsu;
    }

    public final int[] getLteBand() {
        return this.lteBand;
    }

    public final Integer getLteBandwidth() {
        return this.lteBandwidth;
    }

    public final Integer getLteCi() {
        return this.lteCi;
    }

    public final Integer getLteCqi() {
        return this.lteCqi;
    }

    public final Integer getLteDbm() {
        return this.lteDbm;
    }

    public final Integer getLteEarfcn() {
        return this.lteEarfcn;
    }

    public final Integer getLtePci() {
        return this.ltePci;
    }

    public final Integer getLteRsrp() {
        return this.lteRsrp;
    }

    public final Integer getLteRsrq() {
        return this.lteRsrq;
    }

    public final Integer getLteRssi() {
        return this.lteRssi;
    }

    public final Integer getLteRssnr() {
        return this.lteRssnr;
    }

    public final Integer getLteSignalStrength() {
        return this.lteSignalStrength;
    }

    public final Integer getLteTac() {
        return this.lteTac;
    }

    public final Integer getLteTimingAdvance() {
        return this.lteTimingAdvance;
    }

    public final String getNetworkCountryIso() {
        return this.networkCountryIso;
    }

    public final Integer getNetworkId() {
        return this.networkId;
    }

    public final Integer getNetworkMcc() {
        return this.networkMcc;
    }

    public final Integer getNetworkMnc() {
        return this.networkMnc;
    }

    public final String getNetworkOperatorName() {
        return this.networkOperatorName;
    }

    public final int getNetworkType() {
        return this.networkType;
    }

    public final String getNetworkTypeString() {
        return this.networkTypeString;
    }

    public final Integer getNrArfcn() {
        return this.nrArfcn;
    }

    public final Integer getNrAsuLevel() {
        return this.nrAsuLevel;
    }

    public final int[] getNrBand() {
        return this.nrBand;
    }

    public final Integer getNrCsiRsrp() {
        return this.nrCsiRsrp;
    }

    public final Integer getNrCsiRsrq() {
        return this.nrCsiRsrq;
    }

    public final Integer getNrCsiSinr() {
        return this.nrCsiSinr;
    }

    public final Integer getNrDbm() {
        return this.nrDbm;
    }

    public final Integer getNrLevel() {
        return this.nrLevel;
    }

    public final Long getNrNci() {
        return this.nrNci;
    }

    public final Integer getNrPci() {
        return this.nrPci;
    }

    public final Integer getNrSsRsrp() {
        return this.nrSsRsrp;
    }

    public final Integer getNrSsRsrq() {
        return this.nrSsRsrq;
    }

    public final Integer getNrSsSinr() {
        return this.nrSsSinr;
    }

    public final Integer getNrTac() {
        return this.nrTac;
    }

    public final Integer getOverrideNetworkType() {
        return this.overrideNetworkType;
    }

    public final String getPermissions() {
        return this.permissions;
    }

    public final String getPhoneType() {
        return this.phoneType;
    }

    public final Integer getPsc() {
        return this.psc;
    }

    public final Integer getRegistered() {
        return this.registered;
    }

    public final Integer getResourcesMcc() {
        return this.resourcesMcc;
    }

    public final Integer getResourcesMnc() {
        return this.resourcesMnc;
    }

    public final Boolean getRoaming() {
        return this.roaming;
    }

    public final Integer getRsrp() {
        return this.rsrp;
    }

    public final Integer getRsrq() {
        return this.rsrq;
    }

    public final Long getSecondaryNrNci() {
        return this.secondaryNrNci;
    }

    public final String getSimCountryIso() {
        return this.simCountryIso;
    }

    public final Integer getSimMcc() {
        return this.simMcc;
    }

    public final Integer getSimMnc() {
        return this.simMnc;
    }

    public final String getSimOperatorName() {
        return this.simOperatorName;
    }

    public final int getSimSlot() {
        return this.simSlot;
    }

    public final Integer getSubscriber() {
        return this.subscriber;
    }

    public final Integer getSystemId() {
        return this.systemId;
    }

    public final Integer getTdscdmaAsu() {
        return this.tdscdmaAsu;
    }

    public final Integer getTdscdmaDbm() {
        return this.tdscdmaDbm;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final Integer getTimeZoneOffset() {
        return this.timeZoneOffset;
    }

    public final int getTransmitted() {
        return this.transmitted;
    }

    public final String getUniqueCellIdentifier() {
        if (this.cellIdentifier == null) {
            if (this.cdmaDbm != null) {
                String valueOf = String.valueOf(this.systemId);
                Integer num = this.baseStationId;
                this.cellIdentifier = valueOf + num;
            } else if (this.gsmDbm != null) {
                Integer num2 = this.cid;
                Integer num3 = this.lac;
                StringBuilder sb = new StringBuilder();
                sb.append(num2);
                sb.append(num3);
                this.cellIdentifier = sb.toString();
            } else {
                Integer num4 = this.lteCi;
                if (num4 != null) {
                    this.cellIdentifier = String.valueOf(num4);
                } else if (this.wcdmaDbm != null) {
                    Integer num5 = this.wcdmaCid;
                    Integer num6 = this.wcdmaLac;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(num5);
                    sb2.append(num6);
                    this.cellIdentifier = sb2.toString();
                } else {
                    Long l = this.nrNci;
                    if (l != null) {
                        Intrinsics.checkNotNull(l);
                        this.cellIdentifier = String.valueOf(l.longValue());
                    }
                }
            }
        }
        Integer num7 = this.networkMcc;
        Integer num8 = this.networkMnc;
        String str = this.cellIdentifier;
        if (str == null) {
            str = "";
        }
        return num7 + num8 + str;
    }

    public final int getVoiceNetworkType() {
        return this.voiceNetworkType;
    }

    public final Integer getWcdmaAsu() {
        return this.wcdmaAsu;
    }

    public final Integer getWcdmaBitErrorRate() {
        return this.wcdmaBitErrorRate;
    }

    public final Integer getWcdmaCid() {
        return this.wcdmaCid;
    }

    public final Integer getWcdmaDbm() {
        return this.wcdmaDbm;
    }

    public final Integer getWcdmaLac() {
        return this.wcdmaLac;
    }

    public final Integer getWcdmaPsc() {
        return this.wcdmaPsc;
    }

    public final Integer getWcdmaUarfcn() {
        return this.wcdmaUarfcn;
    }

    public final Boolean is5GConnected() {
        return this.is5GConnected;
    }

    public final boolean isAtLeastBasic() {
        DataCompleteness dataCompleteness = this.completeness;
        return (dataCompleteness == null || dataCompleteness == DataCompleteness.USELESS || this.networkType < 1) ? false : true;
    }

    public final boolean isBasicCompleteness() {
        return this.completeness == DataCompleteness.BASIC;
    }

    public final Integer isDataDefaultSim() {
        return this.isDataDefaultSim;
    }

    public final Boolean isPrimaryConnection() {
        return this.isPrimaryConnection;
    }

    public final boolean isSameAntenna(MNSI mnsi) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        if (mnsi == null) {
            return false;
        }
        Integer num = this.networkMnc;
        if (!(num != null ? Intrinsics.areEqual((Object) num, (Object) mnsi.networkMnc) : mnsi.networkMnc == null)) {
            return false;
        }
        Integer num2 = this.networkMcc;
        if (!(num2 != null ? Intrinsics.areEqual((Object) num2, (Object) mnsi.networkMcc) : mnsi.networkMcc == null)) {
            return false;
        }
        Integer num3 = this.lteCi;
        if (!(num3 != null ? Intrinsics.areEqual((Object) num3, (Object) mnsi.lteCi) : mnsi.lteCi == null)) {
            return false;
        }
        Integer num4 = this.baseStationId;
        if (num4 != null) {
            Intrinsics.checkNotNull(num4);
            z = num4.equals(mnsi.baseStationId);
        } else {
            z = mnsi.baseStationId == null;
        }
        if (!z) {
            return false;
        }
        Integer num5 = this.networkId;
        if (num5 != null) {
            Intrinsics.checkNotNull(num5);
            z2 = num5.equals(mnsi.networkId);
        } else {
            z2 = mnsi.networkId == null;
        }
        if (!z2) {
            return false;
        }
        Integer num6 = this.systemId;
        if (num6 != null) {
            Intrinsics.checkNotNull(num6);
            z3 = num6.equals(mnsi.systemId);
        } else {
            z3 = mnsi.systemId == null;
        }
        if (!z3) {
            return false;
        }
        Integer num7 = this.cid;
        if (num7 != null) {
            Intrinsics.checkNotNull(num7);
            z4 = num7.equals(mnsi.cid);
        } else {
            z4 = mnsi.cid == null;
        }
        if (!z4) {
            return false;
        }
        Integer num8 = this.lac;
        if (num8 != null) {
            Intrinsics.checkNotNull(num8);
            z5 = num8.equals(mnsi.lac);
        } else {
            z5 = mnsi.lac == null;
        }
        if (!z5) {
            return false;
        }
        Long l = this.nrNci;
        if (l != null) {
            Intrinsics.checkNotNull(l);
            z6 = l.equals(mnsi.nrNci);
        } else {
            z6 = mnsi.nrNci == null;
        }
        if (!z6) {
            return false;
        }
        Integer num9 = this.nrPci;
        if (num9 != null) {
            Intrinsics.checkNotNull(num9);
            z7 = num9.equals(mnsi.nrPci);
        } else {
            z7 = mnsi.nrPci == null;
        }
        if (!z7) {
            return false;
        }
        Integer num10 = this.nrTac;
        if (num10 != null) {
            Intrinsics.checkNotNull(num10);
            z8 = num10.equals(mnsi.nrTac);
        } else {
            z8 = mnsi.nrTac == null;
        }
        if (!z8) {
            return false;
        }
        Integer num11 = this.nrArfcn;
        if (num11 != null) {
            Intrinsics.checkNotNull(num11);
            z9 = num11.equals(mnsi.nrArfcn);
        } else {
            z9 = mnsi.nrArfcn == null;
        }
        if (z9) {
            return true;
        }
        return false;
    }

    public final boolean isStandardCompleteness() {
        return this.completeness == DataCompleteness.STANDARD;
    }

    public final Boolean isUsingCarrierAggregation() {
        return this.isUsingCarrierAggregation;
    }

    public final void set5GConnected(Boolean bool) {
        this.is5GConnected = bool;
    }

    public final void setAccuracy(float f) {
        this.accuracy = f;
    }

    public final void setAsu(Integer num) {
        this.asu = num;
    }

    public final void setBarometric(Float f) {
        this.barometric = f;
    }

    public final void setBaseStationId(Integer num) {
        this.baseStationId = num;
    }

    public final void setBaseStationLatitude(Double d) {
        this.baseStationLatitude = d;
    }

    public final void setBaseStationLongitude(Double d) {
        this.baseStationLongitude = d;
    }

    public final void setBitErrorRate(Integer num) {
        this.bitErrorRate = num;
    }

    public final void setCdmaAsu(Integer num) {
        this.cdmaAsu = num;
    }

    public final void setCdmaDbm(Integer num) {
        this.cdmaDbm = num;
    }

    public final void setCdmaEcio(Integer num) {
        this.cdmaEcio = num;
    }

    public final void setCellIdentifier(String str) {
        this.cellIdentifier = str;
    }

    public final void setCelltowerInfoTimestamp(Long l) {
        this.celltowerInfoTimestamp = l;
    }

    public final void setCid(Integer num) {
        this.cid = num;
    }

    public final void setCompleteness(DataCompleteness dataCompleteness) {
        this.completeness = dataCompleteness;
    }

    public final void setDataDefaultSim(Integer num) {
        this.isDataDefaultSim = num;
    }

    public final void setDataNetworkType(int i) {
        this.dataNetworkType = i;
    }

    public final void setDataRx(Long l) {
        this.dataRx = l;
    }

    public final void setDataTx(Long l) {
        this.dataTx = l;
    }

    public final void setDbm(Integer num) {
        this.dbm = num;
    }

    public final void setEcio(Integer num) {
        this.ecio = num;
    }

    public final void setEvdoAsu(Integer num) {
        this.evdoAsu = num;
    }

    public final void setEvdoDbm(Integer num) {
        this.evdoDbm = num;
    }

    public final void setEvdoEcio(Integer num) {
        this.evdoEcio = num;
    }

    public final void setEvdoSnr(Integer num) {
        this.evdoSnr = num;
    }

    public final void setGpsAvailable(Boolean bool) {
        this.gpsAvailable = bool;
    }

    public final void setGsmArfcn(Integer num) {
        this.gsmArfcn = num;
    }

    public final void setGsmAsu(Integer num) {
        this.gsmAsu = num;
    }

    public final void setGsmBitError(Integer num) {
        this.gsmBitError = num;
    }

    public final void setGsmBsic(Integer num) {
        this.gsmBsic = num;
    }

    public final void setGsmDbm(Integer num) {
        this.gsmDbm = num;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setIndoorOutdoorWeight(Float f) {
        this.indoorOutdoorWeight = f;
    }

    public final void setLac(Integer num) {
        this.lac = num;
    }

    public final void setLatitude(Double d) {
        this.latitude = d;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setLocationProvider(String str) {
        this.locationProvider = str;
    }

    public final void setLocationTimeStamp(Long l) {
        this.locationTimeStamp = l;
    }

    public final void setLongitude(Double d) {
        this.longitude = d;
    }

    public final void setLteAsu(Integer num) {
        this.lteAsu = num;
    }

    public final void setLteBand(int[] iArr) {
        this.lteBand = iArr;
    }

    public final void setLteBandwidth(Integer num) {
        this.lteBandwidth = num;
    }

    public final void setLteCi(Integer num) {
        this.lteCi = num;
    }

    public final void setLteCqi(Integer num) {
        this.lteCqi = num;
    }

    public final void setLteDbm(Integer num) {
        this.lteDbm = num;
    }

    public final void setLteEarfcn(Integer num) {
        this.lteEarfcn = num;
    }

    public final void setLtePci(Integer num) {
        this.ltePci = num;
    }

    public final void setLteRsrp(Integer num) {
        this.lteRsrp = num;
    }

    public final void setLteRsrq(Integer num) {
        this.lteRsrq = num;
    }

    public final void setLteRssi(Integer num) {
        this.lteRssi = num;
    }

    public final void setLteRssnr(Integer num) {
        this.lteRssnr = num;
    }

    public final void setLteSignalStrength(Integer num) {
        this.lteSignalStrength = num;
    }

    public final void setLteTac(Integer num) {
        this.lteTac = num;
    }

    public final void setLteTimingAdvance(Integer num) {
        this.lteTimingAdvance = num;
    }

    public final void setNetworkCountryIso(String str) {
        this.networkCountryIso = str;
    }

    public final void setNetworkData$m2sdk_release(y3 y3Var) {
        Intrinsics.checkNotNullParameter(y3Var, "networkDataUsage");
        this.dataRx = Long.valueOf(y3Var.c);
        this.dataTx = Long.valueOf(y3Var.b);
    }

    public final void setNetworkGlobalType(int i) {
        String str;
        setNetworkType(i);
        M2SDKLogger m2SDKLogger = m4.a;
        switch (i) {
            case 0:
                str = "UNKNOWN";
                break;
            case 1:
                str = "GPRS";
                break;
            case 2:
                str = "EDGE";
                break;
            case 3:
                str = "UMTS";
                break;
            case 4:
                str = "CDMA";
                break;
            case 5:
                str = "EVDO_0";
                break;
            case 6:
                str = "EVDO_A";
                break;
            case 7:
                str = "1xRTT";
                break;
            case 8:
                str = "HSDPA";
                break;
            case 9:
                str = "HSUPA";
                break;
            case 10:
                str = "HSPA";
                break;
            case 11:
                str = "IDEN";
                break;
            case 12:
                str = "EVDO_B";
                break;
            case 13:
                str = "LTE";
                break;
            case 14:
                str = "EHRPD";
                break;
            case 15:
                str = "HSPAP";
                break;
            case 16:
                str = "GSM";
                break;
            case 17:
                str = "TD_SCDMA";
                break;
            case 18:
                str = "IWLAN";
                break;
            case 20:
                str = "NR";
                break;
            default:
                str = "failed to find networkType";
                break;
        }
        setNetworkTypeString(str);
    }

    public final void setNetworkId(Integer num) {
        this.networkId = num;
    }

    public final void setNetworkMcc(Integer num) {
        this.networkMcc = num;
    }

    public final void setNetworkMnc(Integer num) {
        this.networkMnc = num;
    }

    public final void setNetworkOperatorName(String str) {
        this.networkOperatorName = str;
    }

    public final void setNetworkType(int i) {
        this.networkType = i;
    }

    public final void setNetworkTypeString(String str) {
        this.networkTypeString = str;
    }

    public final void setNrArfcn(Integer num) {
        this.nrArfcn = num;
    }

    public final void setNrAsuLevel(Integer num) {
        this.nrAsuLevel = num;
    }

    public final void setNrBand(int[] iArr) {
        this.nrBand = iArr;
    }

    public final void setNrCsiRsrp(Integer num) {
        this.nrCsiRsrp = num;
    }

    public final void setNrCsiRsrq(Integer num) {
        this.nrCsiRsrq = num;
    }

    public final void setNrCsiSinr(Integer num) {
        this.nrCsiSinr = num;
    }

    public final void setNrDbm(Integer num) {
        this.nrDbm = num;
    }

    public final void setNrLevel(Integer num) {
        this.nrLevel = num;
    }

    public final void setNrNci(Long l) {
        this.nrNci = l;
    }

    public final void setNrPci(Integer num) {
        this.nrPci = num;
    }

    public final void setNrSsRsrp(Integer num) {
        this.nrSsRsrp = num;
    }

    public final void setNrSsRsrq(Integer num) {
        this.nrSsRsrq = num;
    }

    public final void setNrSsSinr(Integer num) {
        this.nrSsSinr = num;
    }

    public final void setNrTac(Integer num) {
        this.nrTac = num;
    }

    public final void setOverrideNetworkType(Integer num) {
        this.overrideNetworkType = num;
    }

    public final void setPermissions(String str) {
        this.permissions = str;
    }

    public final void setPhoneType(String str) {
        this.phoneType = str;
    }

    public final void setPrimaryConnection(Boolean bool) {
        this.isPrimaryConnection = bool;
    }

    public final void setPsc(Integer num) {
        this.psc = num;
    }

    public final void setRegistered(Integer num) {
        this.registered = num;
    }

    public final void setResourcesMcc(Integer num) {
        this.resourcesMcc = num;
    }

    public final void setResourcesMnc(Integer num) {
        this.resourcesMnc = num;
    }

    public final void setRoaming(Boolean bool) {
        this.roaming = bool;
    }

    public final void setRsrp(Integer num) {
        this.rsrp = num;
    }

    public final void setRsrq(Integer num) {
        this.rsrq = num;
    }

    public final void setSecondaryNrNci(Long l) {
        this.secondaryNrNci = l;
    }

    public final void setSimCountryIso(String str) {
        this.simCountryIso = str;
    }

    public final void setSimMcc(Integer num) {
        this.simMcc = num;
    }

    public final void setSimMnc(Integer num) {
        this.simMnc = num;
    }

    public final void setSimOperatorName(String str) {
        this.simOperatorName = str;
    }

    public final void setSimSlot(int i) {
        this.simSlot = i;
    }

    public final void setSubscriber(Integer num) {
        this.subscriber = num;
    }

    public final void setSystemId(Integer num) {
        this.systemId = num;
    }

    public final void setTdscdmaAsu(Integer num) {
        this.tdscdmaAsu = num;
    }

    public final void setTdscdmaDbm(Integer num) {
        this.tdscdmaDbm = num;
    }

    public final void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public final void setTimeZone(String str) {
        this.timeZone = str;
    }

    public final void setTimeZoneOffset(Integer num) {
        this.timeZoneOffset = num;
    }

    public final void setTransmitted(int i) {
        this.transmitted = i;
    }

    public final void setUsingCarrierAggregation(Boolean bool) {
        this.isUsingCarrierAggregation = bool;
    }

    public final void setVoiceNetworkType(int i) {
        this.voiceNetworkType = i;
    }

    public final void setWcdmaAsu(Integer num) {
        this.wcdmaAsu = num;
    }

    public final void setWcdmaBitErrorRate(Integer num) {
        this.wcdmaBitErrorRate = num;
    }

    public final void setWcdmaCid(Integer num) {
        this.wcdmaCid = num;
    }

    public final void setWcdmaDbm(Integer num) {
        this.wcdmaDbm = num;
    }

    public final void setWcdmaLac(Integer num) {
        this.wcdmaLac = num;
    }

    public final void setWcdmaPsc(Integer num) {
        this.wcdmaPsc = num;
    }

    public final void setWcdmaUarfcn(Integer num) {
        this.wcdmaUarfcn = num;
    }

    public void setup$m2sdk_release(MNSIEntity mNSIEntity) {
        Unit unit;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        int[] iArr;
        List<String> split$default;
        int[] iArr2;
        List<String> split$default2;
        Intrinsics.checkNotNullParameter(mNSIEntity, "entity");
        this.id = mNSIEntity.getId();
        this.transmitted = mNSIEntity.getTransmitted();
        Long timeStamp2 = mNSIEntity.getTimeStamp();
        this.timeStamp = timeStamp2 != null ? timeStamp2.longValue() : System.currentTimeMillis();
        this.timeZone = mNSIEntity.getTimeZone();
        this.timeZoneOffset = mNSIEntity.getTimeZoneOffset();
        this.phoneType = mNSIEntity.getPhoneType();
        String networkTypeString2 = mNSIEntity.getNetworkTypeString();
        Float f = null;
        if (networkTypeString2 != null) {
            setNetworkGlobalType(networkTypeString2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            setNetworkGlobalType(mNSIEntity.getNetworkType());
        }
        this.voiceNetworkType = mNSIEntity.getVoiceNetworkType();
        this.dataNetworkType = mNSIEntity.getDataNetworkType();
        Integer carrierAgregationUsed = mNSIEntity.getCarrierAgregationUsed();
        boolean z = true;
        if (carrierAgregationUsed != null) {
            Integer valueOf = Integer.valueOf(carrierAgregationUsed.intValue());
            Set<String> set = s1.a;
            bool = Boolean.valueOf((valueOf == null || valueOf.intValue() == 0) ? false : true);
        } else {
            bool = null;
        }
        this.isUsingCarrierAggregation = bool;
        Integer connectivityTo5G = mNSIEntity.getConnectivityTo5G();
        if (connectivityTo5G != null) {
            Integer valueOf2 = Integer.valueOf(connectivityTo5G.intValue());
            Set<String> set2 = s1.a;
            bool2 = Boolean.valueOf((valueOf2 == null || valueOf2.intValue() == 0) ? false : true);
        } else {
            bool2 = null;
        }
        this.is5GConnected = bool2;
        this.dbm = mNSIEntity.getDbm();
        this.asu = mNSIEntity.getAsu();
        this.ecio = mNSIEntity.getEcio();
        this.rsrp = mNSIEntity.getRsrp();
        this.rsrq = mNSIEntity.getRsrq();
        this.bitErrorRate = mNSIEntity.getBitErrorRate();
        this.lteSignalStrength = mNSIEntity.getLteSignalStrength();
        this.lteRsrp = mNSIEntity.getLteRsrp();
        this.lteRsrq = mNSIEntity.getLteRsrq();
        this.lteRssnr = mNSIEntity.getLteRssnr();
        this.lteRssi = mNSIEntity.getLteRssi();
        this.lteCqi = mNSIEntity.getLteCqi();
        this.lteDbm = mNSIEntity.getLteDbm();
        this.lteAsu = mNSIEntity.getLteAsu();
        this.lteTimingAdvance = mNSIEntity.getLteTimingAdvance();
        this.cdmaDbm = mNSIEntity.getCdmaDbm();
        this.cdmaAsu = mNSIEntity.getCdmaAsu();
        this.cdmaEcio = mNSIEntity.getCdmaEcio();
        this.evdoDbm = mNSIEntity.getEvdoDbm();
        this.evdoAsu = mNSIEntity.getEvdoAsu();
        this.evdoEcio = mNSIEntity.getEvdoEcio();
        this.evdoSnr = mNSIEntity.getEvdoSnr();
        this.gsmDbm = mNSIEntity.getGsmDbm();
        this.gsmAsu = mNSIEntity.getGsmAsu();
        this.gsmBitError = mNSIEntity.getGsmBitError();
        this.nrAsuLevel = mNSIEntity.getNrAsuLevel();
        this.nrCsiRsrp = mNSIEntity.getNrCsiRsrp();
        this.nrCsiRsrq = mNSIEntity.getNrCsiRsrq();
        this.nrCsiSinr = mNSIEntity.getNrCsiSinr();
        this.nrDbm = mNSIEntity.getNrDbm();
        this.nrLevel = mNSIEntity.getNrLevel();
        this.nrSsRsrp = mNSIEntity.getNrSsRsrp();
        this.nrSsRsrq = mNSIEntity.getNrSsRsrq();
        this.nrSsSinr = mNSIEntity.getNrSsSinr();
        if (mNSIEntity.getNrBand() != null && !StringsKt.equals$default(mNSIEntity.getNrBand(), "", false, 2, (Object) null)) {
            String nrBand2 = mNSIEntity.getNrBand();
            if (nrBand2 == null || (split$default2 = StringsKt.split$default((CharSequence) nrBand2, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                iArr2 = null;
            } else {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
                for (String trim : split$default2) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) trim).toString())));
                }
                iArr2 = CollectionsKt.toIntArray(arrayList);
            }
            this.nrBand = iArr2;
        }
        this.tdscdmaDbm = mNSIEntity.getTdscdmaDbm();
        this.tdscdmaAsu = mNSIEntity.getTdscdmaAsu();
        this.locationTimeStamp = mNSIEntity.getLocationTimeStamp();
        this.latitude = mNSIEntity.getLatitude();
        this.barometric = mNSIEntity.getBarometric();
        this.longitude = mNSIEntity.getLongitude();
        Float accuracy2 = mNSIEntity.getAccuracy();
        this.accuracy = accuracy2 != null ? accuracy2.floatValue() : 0.0f;
        this.locationProvider = mNSIEntity.getLocationProvider();
        this.networkOperatorName = mNSIEntity.getNetworkOperatorName();
        this.networkCountryIso = mNSIEntity.getNetworkCountryIso();
        this.networkMnc = mNSIEntity.getNetworkMnc();
        this.networkMcc = mNSIEntity.getNetworkMcc();
        this.simOperatorName = mNSIEntity.getSimOperatorName();
        this.simCountryIso = mNSIEntity.getSimCountryIso();
        this.simMnc = mNSIEntity.getSimMnc();
        this.simMcc = mNSIEntity.getSimMcc();
        Integer simSlot2 = mNSIEntity.getSimSlot();
        int i = -1;
        this.simSlot = simSlot2 != null ? simSlot2.intValue() : -1;
        this.isDataDefaultSim = mNSIEntity.isDataDefaultSim();
        this.isPrimaryConnection = mNSIEntity.isPrimaryConnection();
        this.overrideNetworkType = mNSIEntity.getOverrideNetworkType();
        this.resourcesMnc = mNSIEntity.getResourcesMnc();
        this.resourcesMcc = mNSIEntity.getResourcesMcc();
        this.registered = mNSIEntity.getRegistered();
        Integer gpsAvailable2 = mNSIEntity.getGpsAvailable();
        if (gpsAvailable2 != null) {
            Integer valueOf3 = Integer.valueOf(gpsAvailable2.intValue());
            Set<String> set3 = s1.a;
            bool3 = Boolean.valueOf((valueOf3 == null || valueOf3.intValue() == 0) ? false : true);
        } else {
            bool3 = null;
        }
        this.gpsAvailable = bool3;
        this.lteCi = mNSIEntity.getLteCi();
        this.ltePci = mNSIEntity.getLtePci();
        this.lteTac = mNSIEntity.getLteTac();
        if (mNSIEntity.getLteBand() != null && !StringsKt.equals$default(mNSIEntity.getLteBand(), "", false, 2, (Object) null)) {
            String lteBand2 = mNSIEntity.getLteBand();
            if (lteBand2 == null || (split$default = StringsKt.split$default((CharSequence) lteBand2, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                iArr = null;
            } else {
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
                for (String trim2 : split$default) {
                    arrayList2.add(Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) trim2).toString())));
                }
                iArr = CollectionsKt.toIntArray(arrayList2);
            }
            this.lteBand = iArr;
        }
        this.wcdmaBitErrorRate = mNSIEntity.getWcdmaBitErrorRate();
        this.wcdmaDbm = mNSIEntity.getWcdmaDbm();
        this.wcdmaAsu = mNSIEntity.getWcdmaAsu();
        this.wcdmaCid = mNSIEntity.getWcdmaCid();
        this.wcdmaLac = mNSIEntity.getWcdmaLac();
        this.wcdmaPsc = mNSIEntity.getWcdmaPsc();
        Integer roaming2 = mNSIEntity.getRoaming();
        if (roaming2 != null) {
            Integer valueOf4 = Integer.valueOf(roaming2.intValue());
            Set<String> set4 = s1.a;
            if (valueOf4 == null || valueOf4.intValue() == 0) {
                z = false;
            }
            bool4 = Boolean.valueOf(z);
        } else {
            bool4 = null;
        }
        this.roaming = bool4;
        Long dataRX = mNSIEntity.getDataRX();
        this.dataRx = dataRX != null ? Long.valueOf(dataRX.longValue()) : null;
        Long dataTX = mNSIEntity.getDataTX();
        this.dataTx = dataTX != null ? Long.valueOf(dataTX.longValue()) : null;
        Integer nrLevel2 = mNSIEntity.getNrLevel();
        if (nrLevel2 != null) {
            i = nrLevel2.intValue();
        }
        this.level = i;
        Double indoorOutdoorWeight2 = mNSIEntity.getIndoorOutdoorWeight();
        if (indoorOutdoorWeight2 != null) {
            f = Float.valueOf((float) indoorOutdoorWeight2.doubleValue());
        }
        this.indoorOutdoorWeight = f;
        this.permissions = mNSIEntity.getPermissions();
        this.celltowerInfoTimestamp = mNSIEntity.getCelltowerInfoTimestamp();
        this.baseStationId = mNSIEntity.getBaseStationId();
        this.baseStationLatitude = mNSIEntity.getBaseStationLatitude();
        this.baseStationLongitude = mNSIEntity.getBaseStationLongitude();
        this.networkId = mNSIEntity.getNetworkId();
        this.systemId = mNSIEntity.getSystemId();
        this.cid = mNSIEntity.getCid();
        this.lac = mNSIEntity.getLac();
        this.gsmArfcn = mNSIEntity.getGsmArfcn();
        this.gsmBsic = mNSIEntity.getGsmBsic();
        this.lteCi = mNSIEntity.getLteCi();
        this.ltePci = mNSIEntity.getLtePci();
        this.lteTac = mNSIEntity.getLteTac();
        this.lteEarfcn = mNSIEntity.getLteEarfcn();
        this.lteBandwidth = mNSIEntity.getLteBandwidth();
        this.psc = mNSIEntity.getPsc();
        this.wcdmaUarfcn = mNSIEntity.getWcdmaUarfcn();
        this.nrNci = mNSIEntity.getNrNci();
        this.nrArfcn = mNSIEntity.getNrArfcn();
        this.nrPci = mNSIEntity.getNrPci();
        this.nrTac = mNSIEntity.getNrTac();
        this.secondaryNrNci = mNSIEntity.getSecondaryNrNci();
        this.completeness = DataCompleteness.Companion.getById(mNSIEntity.getCompleteness());
        this.lteTimingAdvance = mNSIEntity.getLteTimingAdvance();
    }

    public final MNSIEntity toEntity$m2sdk_release() {
        String str;
        String str2;
        MNSIEntity mNSIEntity = new MNSIEntity();
        mNSIEntity.setTimeStamp(Long.valueOf(this.timeStamp));
        mNSIEntity.setTimeZoneOffset(this.timeZoneOffset);
        mNSIEntity.setTimeZone(this.timeZone);
        mNSIEntity.setPhoneType(this.phoneType);
        DataCompleteness dataCompleteness = this.completeness;
        Integer num = null;
        mNSIEntity.setCompleteness(dataCompleteness != null ? Integer.valueOf(dataCompleteness.getId()) : null);
        mNSIEntity.setNetworkTypeString(this.networkTypeString);
        mNSIEntity.setDbm(this.dbm);
        mNSIEntity.setAsu(this.asu);
        mNSIEntity.setEcio(this.ecio);
        mNSIEntity.setRsrp(this.rsrp);
        mNSIEntity.setRsrq(this.rsrq);
        mNSIEntity.setBitErrorRate(this.bitErrorRate);
        mNSIEntity.setWcdmaBitErrorRate(this.wcdmaBitErrorRate);
        mNSIEntity.setLocationTimeStamp(this.locationTimeStamp);
        mNSIEntity.setLocationProvider(this.locationProvider);
        mNSIEntity.setBarometric(this.barometric);
        mNSIEntity.setLatitude(this.latitude);
        mNSIEntity.setLongitude(this.longitude);
        mNSIEntity.setAccuracy(Float.valueOf(this.accuracy));
        mNSIEntity.setNetworkOperatorName(this.networkOperatorName);
        mNSIEntity.setNetworkCountryIso(this.networkCountryIso);
        int[] iArr = this.nrBand;
        if (iArr != null) {
            Joiner on = Joiner.on(",");
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int valueOf : iArr) {
                arrayList.add(StringsKt.trim((CharSequence) String.valueOf(valueOf)).toString());
            }
            str = on.join((Iterable<? extends Object>) CollectionsKt.toList(arrayList));
        } else {
            str = null;
        }
        mNSIEntity.setNrBand(str);
        mNSIEntity.setPermissions(this.permissions);
        mNSIEntity.setNetworkMnc(this.networkMnc);
        mNSIEntity.setNetworkMcc(this.networkMcc);
        mNSIEntity.setSimOperatorName(this.simOperatorName);
        mNSIEntity.setSimCountryIso(this.simCountryIso);
        mNSIEntity.setSimMnc(this.simMnc);
        mNSIEntity.setSimMcc(this.simMcc);
        mNSIEntity.setSimSlot(Integer.valueOf(this.simSlot));
        mNSIEntity.setDataDefaultSim(this.isDataDefaultSim);
        mNSIEntity.setPrimaryConnection(this.isPrimaryConnection);
        mNSIEntity.setOverrideNetworkType(this.overrideNetworkType);
        mNSIEntity.setResourcesMnc(this.resourcesMnc);
        mNSIEntity.setResourcesMcc(this.resourcesMcc);
        mNSIEntity.setRegistered(this.registered);
        mNSIEntity.setLteSignalStrength(this.lteSignalStrength);
        mNSIEntity.setLteRsrp(this.lteRsrp);
        mNSIEntity.setLteRsrq(this.lteRsrq);
        mNSIEntity.setLteRssnr(this.lteRssnr);
        mNSIEntity.setLteRssi(this.lteRssi);
        mNSIEntity.setLteCqi(this.lteCqi);
        mNSIEntity.setLteDbm(this.lteDbm);
        mNSIEntity.setLteAsu(this.lteAsu);
        mNSIEntity.setCdmaDbm(this.cdmaDbm);
        mNSIEntity.setCdmaAsu(this.cdmaAsu);
        mNSIEntity.setCdmaEcio(this.cdmaEcio);
        mNSIEntity.setEvdoDbm(this.evdoDbm);
        mNSIEntity.setEvdoAsu(this.evdoAsu);
        mNSIEntity.setEvdoEcio(this.evdoEcio);
        mNSIEntity.setEvdoSnr(this.evdoSnr);
        mNSIEntity.setGsmDbm(this.gsmDbm);
        mNSIEntity.setGsmAsu(this.gsmAsu);
        mNSIEntity.setGsmBitError(this.gsmBitError);
        mNSIEntity.setTdscdmaDbm(this.tdscdmaDbm);
        mNSIEntity.setTdscdmaAsu(this.tdscdmaAsu);
        Boolean bool = this.gpsAvailable;
        mNSIEntity.setGpsAvailable(bool != null ? Integer.valueOf(bool.booleanValue() ? 1 : 0) : null);
        mNSIEntity.setLteCi(this.lteCi);
        mNSIEntity.setLtePci(this.ltePci);
        mNSIEntity.setLteTac(this.lteTac);
        mNSIEntity.setWcdmaDbm(this.wcdmaDbm);
        mNSIEntity.setWcdmaAsu(this.wcdmaAsu);
        mNSIEntity.setWcdmaCid(this.wcdmaCid);
        mNSIEntity.setWcdmaLac(this.wcdmaLac);
        mNSIEntity.setWcdmaPsc(this.wcdmaPsc);
        Boolean bool2 = this.roaming;
        mNSIEntity.setRoaming(bool2 != null ? Integer.valueOf(bool2.booleanValue() ? 1 : 0) : null);
        mNSIEntity.setNetworkType(this.networkType);
        mNSIEntity.setDataNetworkType(this.dataNetworkType);
        mNSIEntity.setVoiceNetworkType(this.voiceNetworkType);
        mNSIEntity.setDataRX(this.dataRx);
        mNSIEntity.setDataTX(this.dataTx);
        Float f = this.indoorOutdoorWeight;
        mNSIEntity.setIndoorOutdoorWeight(f != null ? Double.valueOf((double) f.floatValue()) : null);
        mNSIEntity.setLteTimingAdvance(this.lteTimingAdvance);
        mNSIEntity.setNrAsuLevel(this.nrAsuLevel);
        mNSIEntity.setNrCsiRsrp(this.nrCsiRsrp);
        mNSIEntity.setNrCsiRsrq(this.nrCsiRsrq);
        mNSIEntity.setNrCsiSinr(this.nrCsiSinr);
        mNSIEntity.setNrDbm(this.nrDbm);
        mNSIEntity.setNrLevel(this.nrLevel);
        mNSIEntity.setNrSsRsrp(this.nrSsRsrp);
        mNSIEntity.setNrSsRsrq(this.nrSsRsrq);
        try {
            int[] iArr2 = this.lteBand;
            if (iArr2 != null) {
                Joiner on2 = Joiner.on(",");
                ArrayList arrayList2 = new ArrayList(iArr2.length);
                for (int valueOf2 : iArr2) {
                    arrayList2.add(StringsKt.trim((CharSequence) String.valueOf(valueOf2)).toString());
                }
                str2 = on2.join((Iterable<? extends Object>) CollectionsKt.toList(arrayList2));
            } else {
                str2 = null;
            }
            mNSIEntity.setLteBand(str2);
        } catch (Exception unused) {
        }
        mNSIEntity.setNrSsSinr(this.nrSsSinr);
        Boolean bool3 = this.isUsingCarrierAggregation;
        mNSIEntity.setCarrierAgregationUsed(bool3 != null ? Integer.valueOf(bool3.booleanValue() ? 1 : 0) : null);
        Boolean bool4 = this.is5GConnected;
        if (bool4 != null) {
            num = Integer.valueOf(bool4.booleanValue() ? 1 : 0);
        }
        mNSIEntity.setConnectivityTo5G(num);
        mNSIEntity.setBaseStationId(this.baseStationId);
        mNSIEntity.setBaseStationLongitude(this.baseStationLongitude);
        mNSIEntity.setNetworkId(this.networkId);
        mNSIEntity.setSystemId(this.systemId);
        mNSIEntity.setCid(this.cid);
        mNSIEntity.setCelltowerInfoTimestamp(this.celltowerInfoTimestamp);
        mNSIEntity.setLteEarfcn(this.lteEarfcn);
        mNSIEntity.setLteBandwidth(this.lteBandwidth);
        mNSIEntity.setGsmArfcn(this.gsmArfcn);
        mNSIEntity.setGsmBsic(this.gsmBsic);
        mNSIEntity.setLac(this.lac);
        mNSIEntity.setWcdmaUarfcn(this.wcdmaUarfcn);
        mNSIEntity.setNrNci(this.nrNci);
        mNSIEntity.setNrPci(this.nrPci);
        mNSIEntity.setNrArfcn(this.nrArfcn);
        mNSIEntity.setNrTac(this.nrTac);
        mNSIEntity.setBaseStationLatitude(this.baseStationLatitude);
        mNSIEntity.setSecondaryNrNci(this.secondaryNrNci);
        return mNSIEntity;
    }

    public MobileNetworkSignalInfoMessage toMessage() {
        MobileNetworkSignalInfoMessage.Builder builder = new MobileNetworkSignalInfoMessage.Builder();
        builder.timeStamp(Long.valueOf(this.timeStamp));
        builder.timeZone(this.timeZone);
        builder.timeZoneOffset(this.timeZoneOffset);
        builder.phoneType(this.phoneType);
        builder.networkType(this.networkTypeString);
        builder.permissions(this.permissions);
        builder.baseStationId(this.baseStationId);
        builder.baseStationLatitude(this.baseStationLatitude);
        builder.baseStationLongitude(this.baseStationLongitude);
        builder.networkId(this.networkId);
        builder.systemId(this.systemId);
        builder.cid(this.cid);
        builder.lac(this.lac);
        builder.cellTowerInfoTimeStamp(this.celltowerInfoTimestamp);
        builder.lteEarfcn(this.lteEarfcn);
        builder.lteBandwidth(this.lteBandwidth);
        builder.gsmArfcn(this.gsmArfcn);
        builder.gsmBsic(this.gsmBsic);
        builder.wcdmaUarfcn(this.wcdmaUarfcn);
        builder.nrNci(this.nrNci);
        builder.nrArfcn(this.nrArfcn);
        builder.nrPci(this.nrPci);
        builder.nrTac(this.nrTac);
        builder.secondaryCellNrNci(this.secondaryNrNci);
        builder.dbm(this.dbm);
        builder.asu(this.asu);
        builder.ecio(this.ecio);
        builder.rsrp(this.rsrp);
        builder.rsrq(this.rsrq);
        builder.bitErrorRate(this.bitErrorRate);
        builder.wcdmaBitErrorRate(this.wcdmaBitErrorRate);
        builder.locationTimeStamp(this.locationTimeStamp);
        builder.locationProvider(this.locationProvider);
        builder.latitude(this.latitude);
        builder.longitude(this.longitude);
        builder.accuracy(Double.valueOf((double) this.accuracy));
        builder.networkOperatorName(this.networkOperatorName);
        builder.networkCountryIso(this.networkCountryIso);
        builder.networkMnc(this.networkMnc);
        builder.networkMcc(this.networkMcc);
        builder.simOperatorName(this.simOperatorName);
        builder.simCountryIso(this.simCountryIso);
        builder.simMnc(this.simMnc);
        builder.simMcc(this.simMcc);
        builder.resourcesMnc(this.resourcesMnc);
        builder.resourcesMcc(this.resourcesMcc);
        builder.registered = this.registered;
        builder.lteSignalStrength(this.lteSignalStrength);
        builder.lteRsrp(this.lteRsrp);
        builder.lteRsrq(this.lteRsrq);
        builder.lteRssnr(this.lteRssnr);
        builder.lteCqi(this.lteCqi);
        builder.lteDbm(this.lteDbm);
        builder.lteRssi(this.lteRssi);
        builder.lteAsu(this.lteAsu);
        builder.cdmaDbm(this.cdmaDbm);
        builder.cdmaAsu(this.cdmaAsu);
        builder.cdmaEcio(this.cdmaEcio);
        builder.evdoDbm(this.evdoDbm);
        builder.evdoAsu(this.evdoAsu);
        builder.evdoEcio(this.evdoEcio);
        builder.evdoSnr(this.evdoSnr);
        builder.gsmDbm(this.gsmDbm);
        builder.gsmAsu(this.gsmAsu);
        builder.gsmBitError(this.gsmBitError);
        builder.tdscdmaDbm(this.tdscdmaDbm);
        builder.tdscdmaAsu(this.tdscdmaAsu);
        builder.gpsAvailable(this.gpsAvailable);
        builder.lteCi(this.lteCi);
        builder.ltePci(this.ltePci);
        builder.lteTac(this.lteTac);
        builder.wcdmaDbm(this.wcdmaDbm);
        builder.wcdmaAsu(this.wcdmaAsu);
        builder.wcdmaCid(this.wcdmaCid);
        builder.wcdmaLac(this.wcdmaLac);
        builder.wcdmaPsc(this.wcdmaPsc);
        builder.roaming(this.roaming);
        builder.rawNetworkType(Integer.valueOf(this.networkType));
        builder.dataNetworkType(Integer.valueOf(this.dataNetworkType));
        builder.voiceNetworkType(Integer.valueOf(this.voiceNetworkType));
        builder.dataRx(this.dataRx);
        builder.dataTx(this.dataTx);
        builder.indoorOutdoorWeight(this.indoorOutdoorWeight);
        builder.lteTimingAdvance(this.lteTimingAdvance);
        builder.nrAsuLevel(this.nrAsuLevel);
        builder.nrCsiRsrp(this.nrCsiRsrp);
        builder.nrCsiRsrq(this.nrCsiRsrq);
        builder.nrCsiSinr(this.nrCsiSinr);
        builder.nrDbm(this.nrDbm);
        int[] iArr = this.nrBand;
        if (iArr != null) {
            builder.nrBand(ArraysKt.toList(iArr));
        }
        int[] iArr2 = this.lteBand;
        if (iArr2 != null) {
            builder.lteBand(ArraysKt.toList(iArr2));
        }
        builder.nrLevel(this.nrLevel);
        builder.nrSsRsrp(this.nrSsRsrp);
        builder.nrSsRsrq(this.nrSsRsrq);
        builder.nrSsSinr(this.nrSsSinr);
        builder.isUsingCarrierAggregation(this.isUsingCarrierAggregation);
        builder.is5GConnected(this.is5GConnected);
        builder.barometric(this.barometric);
        DataCompleteness dataCompleteness = this.completeness;
        builder.completeness(dataCompleteness != null ? Integer.valueOf(dataCompleteness.getId()) : null);
        builder.overrideNetworkType(this.overrideNetworkType);
        builder.isDataDefaultSim(this.isDataDefaultSim);
        MobileNetworkSignalInfoMessage build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MNSI: ");
        int i = this.id;
        sb.append("id=" + i);
        int i2 = this.transmitted;
        sb.append(" transmitted= " + i2);
        long j = this.timeStamp;
        sb.append(" timeStamp= " + j);
        String str = this.timeZone;
        sb.append(" timeZone= " + str);
        String str2 = this.phoneType;
        sb.append(" phoneType= " + str2);
        String str3 = this.networkTypeString;
        sb.append(" networkTypeString= " + str3);
        int i3 = this.networkType;
        sb.append(" networkType= " + i3);
        int i4 = this.voiceNetworkType;
        sb.append("voiceNetworkType=" + i4);
        int i5 = this.dataNetworkType;
        sb.append(" dataNetworkType= " + i5);
        Boolean bool = this.isUsingCarrierAggregation;
        sb.append(" isUsingCarrierAggregation= " + bool);
        Boolean bool2 = this.is5GConnected;
        sb.append(" is5GConnected= " + bool2);
        Integer num = this.dbm;
        sb.append(" dbm= " + num);
        Integer num2 = this.asu;
        sb.append(" asu= " + num2);
        Integer num3 = this.ecio;
        sb.append(" ecio= " + num3);
        Integer num4 = this.rsrp;
        sb.append(" rsrp=" + num4);
        Integer num5 = this.rsrq;
        sb.append(" rsrq=" + num5);
        Integer num6 = this.subscriber;
        sb.append(" subscriber=" + num6);
        Float f = this.barometric;
        sb.append(" barometric=" + f);
        Integer num7 = this.bitErrorRate;
        sb.append(" bitErrorRate=" + num7);
        Integer num8 = this.lteSignalStrength;
        sb.append(" lteSignalStrength=" + num8);
        Integer num9 = this.lteRsrp;
        sb.append(" lteRsrp=" + num9);
        Integer num10 = this.lteRsrq;
        sb.append(" lteRsrq=" + num10);
        Integer num11 = this.lteRssnr;
        sb.append(" lteRssnr=" + num11);
        Integer num12 = this.lteRssi;
        sb.append(" lteRssi=" + num12);
        Integer num13 = this.lteCqi;
        sb.append(" lteCqi=" + num13);
        Integer num14 = this.lteDbm;
        sb.append(" lteDbm=" + num14);
        Integer num15 = this.lteAsu;
        sb.append(" lteAsu=" + num15);
        Integer num16 = this.lteTimingAdvance;
        sb.append(" lteTimingAdvance=" + num16);
        Integer num17 = this.lteCi;
        sb.append(" lteCi=" + num17);
        Integer num18 = this.ltePci;
        sb.append(" ltePci=" + num18);
        Integer num19 = this.lteTac;
        sb.append(" lteTac=" + num19);
        int[] iArr = this.lteBand;
        sb.append(" lteBand=" + iArr);
        Integer num20 = this.lteEarfcn;
        sb.append(" lteEarfcn=" + num20);
        Integer num21 = this.lteBandwidth;
        sb.append(" lteBandwidth=" + num21);
        Integer num22 = this.cdmaDbm;
        sb.append(" cdmaDbm=" + num22);
        Integer num23 = this.cdmaAsu;
        sb.append(" cdmaAsu=" + num23);
        Integer num24 = this.cdmaEcio;
        sb.append(" cdmaEcio=" + num24);
        Integer num25 = this.baseStationId;
        sb.append(" baseStationId=" + num25);
        Double d = this.baseStationLatitude;
        sb.append(" baseStationLatitude=" + d);
        Double d2 = this.baseStationLongitude;
        sb.append(" baseStationLongitude=" + d2);
        Integer num26 = this.networkId;
        sb.append(" networkId=" + num26);
        Integer num27 = this.systemId;
        sb.append(" systemId=" + num27);
        Integer num28 = this.evdoDbm;
        sb.append(" evdoDbm=" + num28);
        Integer num29 = this.evdoAsu;
        sb.append(" evdoAsu=" + num29);
        Integer num30 = this.evdoEcio;
        sb.append(" evdoEcio=" + num30);
        Integer num31 = this.evdoSnr;
        sb.append(" evdoSnr=" + num31);
        Integer num32 = this.gsmDbm;
        sb.append(" gsmDbm=" + num32);
        Integer num33 = this.gsmAsu;
        sb.append(" gsmAsu=" + num33);
        Integer num34 = this.gsmBitError;
        sb.append(" gsmBitError=" + num34);
        Integer num35 = this.cid;
        sb.append(" cid=" + num35);
        Integer num36 = this.lac;
        sb.append(" lac=" + num36);
        Integer num37 = this.gsmArfcn;
        sb.append(" gsmArfcn=" + num37);
        Integer num38 = this.gsmBsic;
        sb.append(" gsmBsic=" + num38);
        Integer num39 = this.nrAsuLevel;
        sb.append(" nrAsuLevel=" + num39);
        Integer num40 = this.nrCsiRsrp;
        sb.append(" nrCsiRsrp=" + num40);
        Integer num41 = this.nrCsiRsrq;
        sb.append(" nrCsiRsrq=" + num41);
        Integer num42 = this.nrCsiSinr;
        sb.append(" nrCsiSinr=" + num42);
        Integer num43 = this.nrDbm;
        sb.append(" nrDbm=" + num43);
        Integer num44 = this.nrLevel;
        sb.append(" nrLevel=" + num44);
        Integer num45 = this.nrSsRsrp;
        sb.append(" nrSsRsrp=" + num45);
        Integer num46 = this.nrSsRsrq;
        sb.append(" nrSsRsrq=" + num46);
        Integer num47 = this.nrSsSinr;
        sb.append(" nrSsSinr=" + num47);
        int[] iArr2 = this.nrBand;
        sb.append(" nrBand=" + iArr2);
        Long l = this.nrNci;
        sb.append(" nrNci=" + l);
        Long l2 = this.secondaryNrNci;
        sb.append(" secondaryNrNci=" + l2);
        Integer num48 = this.nrArfcn;
        sb.append(" nrArfcn=" + num48);
        Integer num49 = this.nrPci;
        sb.append(" nrPci=" + num49);
        Integer num50 = this.nrTac;
        sb.append(" nrTac=" + num50);
        Integer num51 = this.tdscdmaDbm;
        sb.append(" tdscdmaDbm=" + num51);
        Integer num52 = this.tdscdmaAsu;
        sb.append(" tdscdmaAsu=" + num52);
        Long l3 = this.locationTimeStamp;
        sb.append(" locationTimeStamp=" + l3);
        Double d3 = this.latitude;
        sb.append(" latitude=" + d3);
        Double d4 = this.longitude;
        sb.append(" longitude=" + d4);
        float f2 = this.accuracy;
        sb.append(" accuracy=" + f2);
        String str4 = this.locationProvider;
        sb.append(" locationProvider=" + str4);
        String str5 = this.networkOperatorName;
        sb.append(" networkOperatorName=" + str5);
        String str6 = this.networkCountryIso;
        sb.append(" networkCountryIso=" + str6);
        Integer num53 = this.networkMnc;
        sb.append(" networkMnc=" + num53);
        Integer num54 = this.networkMcc;
        sb.append(" networkMcc=" + num54);
        String str7 = this.simOperatorName;
        sb.append(" simOperatorName=" + str7);
        String str8 = this.simCountryIso;
        sb.append(" simCountryIso=" + str8);
        Integer num55 = this.simMnc;
        sb.append(" simMnc=" + num55);
        Integer num56 = this.simMcc;
        sb.append(" simMcc=" + num56);
        Integer num57 = this.resourcesMnc;
        sb.append(" resourcesMnc=" + num57);
        Integer num58 = this.resourcesMcc;
        sb.append(" resourcesMcc=" + num58);
        Integer num59 = this.registered;
        sb.append(" registered=" + num59);
        Boolean bool3 = this.gpsAvailable;
        sb.append(" gpsAvailable=" + bool3);
        Integer num60 = this.wcdmaBitErrorRate;
        sb.append(" wcdmaBitErrorRate=" + num60);
        Integer num61 = this.wcdmaDbm;
        sb.append(" wcdmaDbm=" + num61);
        Integer num62 = this.wcdmaAsu;
        sb.append(" wcdmaAsu=" + num62);
        Integer num63 = this.wcdmaCid;
        sb.append(" wcdmaCid=" + num63);
        Integer num64 = this.wcdmaLac;
        sb.append(" wcdmaLac=" + num64);
        Integer num65 = this.wcdmaPsc;
        sb.append(" wcdmaPsc=" + num65);
        Integer num66 = this.psc;
        sb.append(" psc=" + num66);
        Integer num67 = this.wcdmaUarfcn;
        sb.append(" wcdmaUarfcn=" + num67);
        Boolean bool4 = this.roaming;
        sb.append(" roaming=" + bool4);
        Long l4 = this.dataRx;
        sb.append(" dataRx=" + l4);
        Long l5 = this.dataTx;
        sb.append(" dataTx=" + l5);
        int i6 = this.level;
        sb.append(" level=" + i6);
        Float f3 = this.indoorOutdoorWeight;
        sb.append(" indoorOutdoorWeight=" + f3);
        String str9 = this.cellIdentifier;
        sb.append(" cellIdentifier=" + str9);
        int i7 = this.simSlot;
        sb.append(" simSlot=" + i7);
        Integer num68 = this.isDataDefaultSim;
        sb.append(" isDataDefaultSim=" + num68);
        Boolean bool5 = this.isPrimaryConnection;
        sb.append(" isPrimaryConnection=" + bool5);
        Integer num69 = this.overrideNetworkType;
        sb.append(" overrideNetworkType=" + num69);
        DataCompleteness dataCompleteness = this.completeness;
        sb.append(" completeness=" + dataCompleteness);
        String str10 = this.permissions;
        sb.append(" permissions=" + str10);
        Integer num70 = this.timeZoneOffset;
        sb.append(" timeZoneOffset=" + num70);
        Long l6 = this.celltowerInfoTimestamp;
        sb.append(" celltowerInfoTimestamp=" + l6);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MNSI(MNSIEntity mNSIEntity) {
        this();
        Intrinsics.checkNotNullParameter(mNSIEntity, "entity");
        setup$m2sdk_release(mNSIEntity);
    }

    public final void setNetworkGlobalType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        setNetworkTypeString(str);
        setNetworkType(m4.b(str));
    }
}
