package com.bykv.vk.openvk.preload.geckox.i;

import com.bykv.vk.openvk.preload.b.b;
import com.bykv.vk.openvk.preload.b.d;
import org.json.JSONObject;

/* compiled from: GeckoPipeline */
public final class a {
    public static com.bykv.vk.openvk.preload.b.b.a a(final com.bykv.vk.openvk.preload.geckox.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void b(b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                bVar.b(com.bykv.vk.openvk.preload.geckox.d.b.class);
            }

            public final <T> void a(b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                bVar.a((Class<? extends d<I, ?>>) com.bykv.vk.openvk.preload.geckox.d.b.class);
            }
        };
    }

    public static com.bykv.vk.openvk.preload.b.b.a a(final com.bykv.vk.openvk.preload.geckox.e.a aVar, final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void a(b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                if (aVar != null) {
                    bVar.a((Class<? extends d<I, ?>>) com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            public final <T> void a(b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(b<T> bVar, d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        };
    }

    public static com.bykv.vk.openvk.preload.b.b.a b(final com.bykv.vk.openvk.preload.geckox.e.a aVar, final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void a(b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                if (aVar != null) {
                    bVar.a((Class<? extends d<I, ?>>) com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                if (aVar != null) {
                    bVar.b(com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }

            public final <T> void a(b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                if (aVar != null) {
                    bVar.a((Class<? extends d<I, ?>>) com.bykv.vk.openvk.preload.geckox.d.b.class);
                }
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(b<T> bVar, d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }
        };
    }

    public static com.bykv.vk.openvk.preload.b.b.a a(final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new com.bykv.vk.openvk.preload.b.b.a() {
            public final <T> void a(b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onException", th.toString());
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(b<T> bVar, d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                } catch (Throwable unused) {
                }
            }

            public final <T> void a(b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onEnd", "");
                } catch (Throwable unused) {
                }
            }
        };
    }
}
