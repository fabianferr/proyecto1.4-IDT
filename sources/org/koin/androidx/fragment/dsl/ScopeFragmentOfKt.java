package org.koin.androidx.fragment.dsl;

import androidx.fragment.app.Fragment;
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
import org.koin.dsl.ScopeDSL;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006*\u00020\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\bø\u0001\u0000\u001ag\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006*\u00020\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\t2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001aV\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001*\u00020\u00072\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00040\u000bH\bø\u0001\u0000\u001au\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001*\u00020\u00072\u0014\b\u0004\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00040\u000b2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001ad\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001*\u00020\u00072\u001a\b\u0004\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00040\u0011H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001*\u00020\u00072\u001a\b\u0004\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00040\u00112\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001ar\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001*\u00020\u00072 \b\u0004\u0010\b\u001a\u001a\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00040\u0013H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001*\u00020\u00072 \b\u0004\u0010\b\u001a\u001a\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00040\u00132\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001*\u00020\u00072&\b\u0004\u0010\b\u001a \u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00040\u0015H\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001*\u00020\u00072&\b\u0004\u0010\b\u001a \u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00040\u00152\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001*\u00020\u00072,\b\u0004\u0010\b\u001a&\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00040\u0017H\bø\u0001\u0000\u001a­\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001*\u00020\u00072,\b\u0004\u0010\b\u001a&\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00040\u00172\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001a\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001*\u00020\u000722\b\u0004\u0010\b\u001a,\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00040\u0019H\bø\u0001\u0000\u001a»\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001*\u00020\u000722\b\u0004\u0010\b\u001a,\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u00040\u00192\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001aª\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001*\u00020\u000728\b\u0004\u0010\b\u001a2\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u00040\u001bH\bø\u0001\u0000\u001aÉ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001*\u00020\u000728\b\u0004\u0010\b\u001a2\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u00040\u001b2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001a¸\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001\"\u0006\b\b\u0010\u001c\u0018\u0001*\u00020\u00072>\b\u0004\u0010\b\u001a8\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u00040\u001dH\bø\u0001\u0000\u001a×\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001\"\u0006\b\b\u0010\u001c\u0018\u0001*\u00020\u00072>\b\u0004\u0010\b\u001a8\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u00040\u001d2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001aÆ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001\"\u0006\b\b\u0010\u001c\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001*\u00020\u00072D\b\u0004\u0010\b\u001a>\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u00040\u001fH\bø\u0001\u0000\u001aå\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001\"\u0006\b\b\u0010\u001c\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001*\u00020\u00072D\b\u0004\u0010\b\u001a>\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H\u00040\u001f2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u001aÔ\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001\"\u0006\b\b\u0010\u001c\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010 \u0018\u0001*\u00020\u00072J\b\u0004\u0010\b\u001aD\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u00040!H\bø\u0001\u0000\u001aó\u0001\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001j\b\u0012\u0004\u0012\u0002H\u0004`\u0005\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0006\"\u0006\b\u0001\u0010\u000f\u0018\u0001\"\u0006\b\u0002\u0010\u0010\u0018\u0001\"\u0006\b\u0003\u0010\u0012\u0018\u0001\"\u0006\b\u0004\u0010\u0014\u0018\u0001\"\u0006\b\u0005\u0010\u0016\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001a\u0018\u0001\"\u0006\b\b\u0010\u001c\u0018\u0001\"\u0006\b\t\u0010\u001e\u0018\u0001\"\u0006\b\n\u0010 \u0018\u0001*\u00020\u00072J\b\u0004\u0010\b\u001aD\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u00040!2\u001d\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\""}, d2 = {"fragmentOf", "Lkotlin/Pair;", "Lorg/koin/core/module/Module;", "Lorg/koin/core/instance/InstanceFactory;", "R", "Lorg/koin/core/module/KoinDefinition;", "Landroidx/fragment/app/Fragment;", "Lorg/koin/dsl/ScopeDSL;", "constructor", "Lkotlin/Function0;", "options", "Lkotlin/Function1;", "Lorg/koin/core/definition/BeanDefinition;", "", "Lkotlin/ExtensionFunctionType;", "T1", "T2", "Lkotlin/Function2;", "T3", "Lkotlin/Function3;", "T4", "Lkotlin/Function4;", "T5", "Lkotlin/Function5;", "T6", "Lkotlin/Function6;", "T7", "Lkotlin/Function7;", "T8", "Lkotlin/Function8;", "T9", "Lkotlin/Function9;", "T10", "Lkotlin/Function10;", "koin-android_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ScopeFragmentOf.kt */
public final class ScopeFragmentOfKt {
    public static final /* synthetic */ <R extends Fragment> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function0<? extends R> function0, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function0, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$1(function0), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function0, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$2(function0), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> function1, Function1<? super BeanDefinition<R>, Unit> function12) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function1, "constructor");
        Intrinsics.checkNotNullParameter(function12, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$3(function1), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function1<? super T1, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function1, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$4(function1), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> function2, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function2, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$5(function2), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function2, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$6(function2), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function3, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$7(function3), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function3, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$8(function3), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function4, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$9(function4), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function4, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$10(function4), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function5, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$11(function5), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function5, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$12(function5), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function6, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$13(function6), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function6, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$14(function6), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function7, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$15(function7), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function7, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$16(function7), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7, T8> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function8, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$17(function8), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7, T8> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function8, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$18(function8), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7, T8, T9> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function9, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$19(function9), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7, T8, T9> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function9, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$20(function9), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10, Function1<? super BeanDefinition<R>, Unit> function1) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function10, "constructor");
        Intrinsics.checkNotNullParameter(function1, "options");
        Module module = scopeDSL.getModule();
        Intrinsics.needClassReification();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        InstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$21(function10), kind, emptyList));
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

    public static final /* synthetic */ <R extends Fragment, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Pair<Module, InstanceFactory<R>> fragmentOf(ScopeDSL scopeDSL, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        Intrinsics.checkNotNullParameter(scopeDSL, "<this>");
        Intrinsics.checkNotNullParameter(function10, "constructor");
        Intrinsics.needClassReification();
        Module module = scopeDSL.getModule();
        Qualifier scopeQualifier = scopeDSL.getScopeQualifier();
        Kind kind = Kind.Factory;
        List emptyList = CollectionsKt.emptyList();
        Intrinsics.reifiedOperationMarker(4, "R");
        FactoryInstanceFactory factoryInstanceFactory = new FactoryInstanceFactory(new BeanDefinition(scopeQualifier, Reflection.getOrCreateKotlinClass(Object.class), (Qualifier) null, new ScopeFragmentOfKt$fragmentOf$22(function10), kind, emptyList));
        module.indexPrimaryType(factoryInstanceFactory);
        return new Pair<>(module, factoryInstanceFactory);
    }
}
