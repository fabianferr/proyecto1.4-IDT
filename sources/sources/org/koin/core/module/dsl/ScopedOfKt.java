package org.koin.core.module.dsl;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.ScopedInstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.dsl.ScopeDSL;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\bø\u0001\u0000\u001ac\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001aR\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001*\u00020\u00062\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00040\nH\bø\u0001\u0000\u001aq\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001*\u00020\u00062\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00040\n2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a`\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001*\u00020\u00062\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00040\u0010H\bø\u0001\u0000\u001a\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001*\u00020\u00062\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00040\u00102\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001an\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001*\u00020\u00062 \b\u0004\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00040\u0012H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001*\u00020\u00062 \b\u0004\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00040\u00122\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a|\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001*\u00020\u00062&\b\u0004\u0010\u0007\u001a \u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00040\u0014H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001*\u00020\u00062&\b\u0004\u0010\u0007\u001a \u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00040\u00142\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001*\u00020\u00062,\b\u0004\u0010\u0007\u001a&\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00040\u0016H\bø\u0001\u0000\u001a©\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001*\u00020\u00062,\b\u0004\u0010\u0007\u001a&\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00040\u00162\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001*\u00020\u000622\b\u0004\u0010\u0007\u001a,\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00040\u0018H\bø\u0001\u0000\u001a·\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001*\u00020\u000622\b\u0004\u0010\u0007\u001a,\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00040\u00182\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a¦\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001*\u00020\u000628\b\u0004\u0010\u0007\u001a2\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00040\u001aH\bø\u0001\u0000\u001aÅ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001*\u00020\u000628\b\u0004\u0010\u0007\u001a2\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00040\u001a2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a´\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001*\u00020\u00062>\b\u0004\u0010\u0007\u001a8\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00040\u001cH\bø\u0001\u0000\u001aÓ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001*\u00020\u00062>\b\u0004\u0010\u0007\u001a8\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00040\u001c2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001aÂ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001*\u00020\u00062D\b\u0004\u0010\u0007\u001a>\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u00040\u001eH\bø\u0001\u0000\u001aá\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001*\u00020\u00062D\b\u0004\u0010\u0007\u001a>\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u00040\u001e2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001aÐ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001\"\u0006\b\n\u0010\u001f\u0018\u0001*\u00020\u00062J\b\u0004\u0010\u0007\u001aD\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00040 H\bø\u0001\u0000\u001aï\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\u0006\b\u0000\u0010\u0004\u0018\u0001\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001\"\u0006\b\n\u0010\u001f\u0018\u0001*\u00020\u00062J\b\u0004\u0010\u0007\u001aD\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00040 2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006!"}, d2 = {"scopedOf", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "R", "Lorg/koin/core/module/KoinDefinition;", "Lorg/koin/dsl/ScopeDSL;", "constructor", "Lkotlin/Function0;", "options", "Lkotlin/Function1;", "Lorg/koin/core/definition/BeanDefinition;", "", "Lkotlin/ExtensionFunctionType;", "T1", "T2", "Lkotlin/Function2;", "T3", "Lkotlin/Function3;", "T4", "Lkotlin/Function4;", "T5", "Lkotlin/Function5;", "T6", "Lkotlin/Function6;", "T7", "Lkotlin/Function7;", "T8", "Lkotlin/Function8;", "T9", "Lkotlin/Function9;", "T10", "Lkotlin/Function10;", "koin-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScopedOf.kt */
public final class ScopedOfKt {
    public static final /* synthetic */ <R> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function0<? extends R> function0, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function0, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$1(function0), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function0, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$2(function0), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> function1, Function1<? super BeanDefinition<R>, Unit> function12) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function1, "constructor");
        Intrinsics.checkNotNullParameter(function12, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$3(function1), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function12.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function1, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$4(function1), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> function2, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function2, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$5(function2), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function2, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$6(function2), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function3, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$7(function3), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function3, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$8(function3), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function4, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$9(function4), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function4, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$10(function4), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function5, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$11(function5), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function5, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$12(function5), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function6, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$13(function6), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function6, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$14(function6), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function7, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$15(function7), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function7, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$16(function7), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function8, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$17(function8), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function8, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$18(function8), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function9, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$19(function9), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function9, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$20(function9), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function10, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$21(function10), kind, emptyList));
        BeanDefinition beanDefinition = scopedInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, scopedInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(scopedInstanceFactory);
        module.indexSecondaryTypes(scopedInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (scopedInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) scopedInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Pair<Module, InstanceFactory<R>> scopedOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function10, "constructor");
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Scoped;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        ScopedInstanceFactory scopedInstanceFactory = new ScopedInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopedOfKt$scopedOf$22(function10), kind, emptyList));
        scopeDSL.getModule().indexPrimaryType(scopedInstanceFactory);
        return new Pair<>(scopeDSL.getModule(), scopedInstanceFactory);
    }
}
