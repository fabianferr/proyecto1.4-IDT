package org.koin.androidx.viewmodel.dsl;

import androidx.lifecycle.ViewModel;
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
import org.koin.core.instance.FactoryInstanceFactory;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.registry.ScopeRegistry;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006*\u00020\u00022\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\bø\u0001\u0000\u001ag\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006*\u00020\u00022\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\b2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001aV\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00040\nH\bø\u0001\u0000\u001au\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00040\n2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001ad\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001*\u00020\u00022\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00040\u0010H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001*\u00020\u00022\u001a\b\u0004\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00040\u00102\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001ar\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001*\u00020\u00022 \b\u0004\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00040\u0012H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001*\u00020\u00022 \b\u0004\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00040\u00122\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001*\u00020\u00022&\b\u0004\u0010\u0007\u001a \u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00040\u0014H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001*\u00020\u00022&\b\u0004\u0010\u0007\u001a \u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00040\u00142\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001*\u00020\u00022,\b\u0004\u0010\u0007\u001a&\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00040\u0016H\bø\u0001\u0000\u001a­\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001*\u00020\u00022,\b\u0004\u0010\u0007\u001a&\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00040\u00162\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001*\u00020\u000222\b\u0004\u0010\u0007\u001a,\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00040\u0018H\bø\u0001\u0000\u001a»\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001*\u00020\u000222\b\u0004\u0010\u0007\u001a,\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00040\u00182\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001aª\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001*\u00020\u000228\b\u0004\u0010\u0007\u001a2\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00040\u001aH\bø\u0001\u0000\u001aÉ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001*\u00020\u000228\b\u0004\u0010\u0007\u001a2\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00040\u001a2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a¸\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001*\u00020\u00022>\b\u0004\u0010\u0007\u001a8\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00040\u001cH\bø\u0001\u0000\u001a×\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001*\u00020\u00022>\b\u0004\u0010\u0007\u001a8\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00040\u001c2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001aÆ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001*\u00020\u00022D\b\u0004\u0010\u0007\u001a>\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u00040\u001eH\bø\u0001\u0000\u001aå\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001*\u00020\u00022D\b\u0004\u0010\u0007\u001a>\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u00040\u001e2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u001aÔ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001\"\u0006\b\n\u0010\u001f\u0018\u0001*\u00020\u00022J\b\u0004\u0010\u0007\u001aD\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00040 H\bø\u0001\u0000\u001aó\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000e\u0018\u0001\"\u0006\b\u0002\u0010\u000f\u0018\u0001\"\u0006\b\u0003\u0010\u0011\u0018\u0001\"\u0006\b\u0004\u0010\u0013\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0017\u0018\u0001\"\u0006\b\u0007\u0010\u0019\u0018\u0001\"\u0006\b\b\u0010\u001b\u0018\u0001\"\u0006\b\t\u0010\u001d\u0018\u0001\"\u0006\b\n\u0010\u001f\u0018\u0001*\u00020\u00022J\b\u0004\u0010\u0007\u001aD\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00040 2\u001d\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006!"}, d2 = {"viewModelOf", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "R", "Lorg/koin/core/module/KoinDefinition;", "Landroidx/lifecycle/ViewModel;", "constructor", "Lkotlin/Function0;", "options", "Lkotlin/Function1;", "Lorg/koin/core/definition/BeanDefinition;", "", "Lkotlin/ExtensionFunctionType;", "T1", "T2", "Lkotlin/Function2;", "T3", "Lkotlin/Function3;", "T4", "Lkotlin/Function4;", "T5", "Lkotlin/Function5;", "T6", "Lkotlin/Function6;", "T7", "Lkotlin/Function7;", "T8", "Lkotlin/Function8;", "T9", "Lkotlin/Function9;", "T10", "Lkotlin/Function10;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewModelOf.kt */
public final class ViewModelOfKt {
    public static final /* synthetic */ <R extends ViewModel> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function0<? extends R> function0, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function0, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$1(function0), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function0, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$2(function0), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function1<? super T1, ? extends R> function1, Function1<? super BeanDefinition<R>, Unit> function12) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function1, "constructor");
        Intrinsics.checkNotNullParameter(function12, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$3(function1), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function12.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function1<? super T1, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function1, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$4(function1), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function2<? super T1, ? super T2, ? extends R> function2, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function2, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$5(function2), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function2, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$6(function2), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function3, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$7(function3), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function3, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$8(function3), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function4, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$9(function4), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function4, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$10(function4), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function5, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$11(function5), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function5, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$12(function5), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function6, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$13(function6), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function6, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$14(function6), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function7, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$15(function7), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function7, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$16(function7), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function8, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$17(function8), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function8, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$18(function8), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function9, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$19(function9), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function9, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$20(function9), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function10, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$21(function10), kind, emptyList));
        BeanDefinition beanDefinition = factoryInstanceFactory.getBeanDefinition();
        Pair<Module, InstanceFactory<R>> pair = new Pair<>(module, factoryInstanceFactory);
        function1.invoke(beanDefinition);
        module.indexPrimaryType(factoryInstanceFactory);
        module.indexSecondaryTypes(factoryInstanceFactory);
        if (beanDefinition.get_createdAtStart() && (factoryInstanceFactory instanceof SingleInstanceFactory)) {
            module.prepareForCreationAtStart((SingleInstanceFactory) factoryInstanceFactory);
        }
        return pair;
    }

    public static final /* synthetic */ <R extends ViewModel, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Pair<Module, InstanceFactory<R>> viewModelOf(Module module, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function10, "constructor");
        Intrinsics.needClassReification();
        Qualifier rootScopeQualifier = ScopeRegistry.Companion.getRootScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(rootScopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ViewModelOfKt$viewModelOf$22(function10), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }
}
