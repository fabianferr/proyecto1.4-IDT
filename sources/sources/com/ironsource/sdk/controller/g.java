package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import com.ironsource.environment.thread.a;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.a.f;
import com.ironsource.sdk.a.h;
import com.ironsource.sdk.controller.B;
import com.ironsource.sdk.controller.h;
import com.ironsource.sdk.controller.n;
import com.ironsource.sdk.g.c;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.g.e;
import com.ironsource.sdk.h.b;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g implements e, n {
    public n a;
    public final Map<String, n.b> b;
    /* access modifiers changed from: private */
    public final String c = "g";
    private d.b d = d.b.None;
    private CountDownTimer e;
    private final C0235b f = new C0235b("NativeCommandExecutor");
    private final C0235b g = new C0235b("ControllerCommandsExecutor");
    private final a h;
    /* access modifiers changed from: private */
    public final B i;
    /* access modifiers changed from: private */
    public final Map<String, n.a> j;

    public g(Context context, C0236c cVar, com.ironsource.sdk.service.d dVar, k kVar, a aVar, int i2, JSONObject jSONObject, String str, String str2) {
        a aVar2 = aVar;
        this.h = aVar2;
        this.j = new HashMap();
        this.b = new HashMap();
        String networkStorageDir = IronSourceStorageUtils.getNetworkStorageDir(context);
        com.ironsource.sdk.l.d a2 = com.ironsource.sdk.l.d.a(networkStorageDir, aVar2, jSONObject);
        this.i = new B(context, cVar, dVar, kVar, i2, a2, networkStorageDir);
        final Context context2 = context;
        final C0236c cVar2 = cVar;
        final com.ironsource.sdk.service.d dVar2 = dVar;
        final k kVar2 = kVar;
        final int i3 = i2;
        final com.ironsource.sdk.l.d dVar3 = a2;
        final String str3 = networkStorageDir;
        final String str4 = str;
        final String str5 = str2;
        b((Runnable) new Runnable() {
            public final void run() {
                try {
                    g gVar = g.this;
                    n unused = gVar.a = g.a(gVar, context2, cVar2, dVar2, kVar2, i3, dVar3, str3, str4, str5);
                    g.this.a.g();
                } catch (Throwable th) {
                    g.this.c(Log.getStackTraceString(th));
                }
            }
        });
        this.e = new CountDownTimer(200000, 1000) {
            public final void onFinish() {
                Logger.i(g.this.c, "Global Controller Timer Finish");
                g.this.c("controller html - download timeout");
            }

            public final void onTick(long j) {
                String d = g.this.c;
                Logger.i(d, "Global Controller Timer Tick " + j);
            }
        }.start();
    }

    static /* synthetic */ A a(g gVar, Context context, C0236c cVar, com.ironsource.sdk.service.d dVar, k kVar, int i2, com.ironsource.sdk.l.d dVar2, String str, String str2, String str3) {
        g gVar2 = gVar;
        Context context2 = context;
        com.ironsource.sdk.l.d dVar3 = dVar2;
        f.a(h.c);
        A a2 = new A(context, kVar, cVar, gVar2, gVar2.h, i2, dVar2, str, new n.a() {
            public final void onReceive(h.a aVar) {
                n.a aVar2 = (n.a) g.this.j.remove(aVar.a());
                if (aVar2 != null) {
                    aVar2.onReceive(aVar);
                }
            }
        }, new n.b() {
            public final void onReceive(r rVar) {
                n.b bVar = (n.b) g.this.b.get(rVar.a());
                if (bVar != null) {
                    bVar.onReceive(rVar);
                }
            }
        }, str2, str3);
        b bVar = new b(context2, dVar3, new com.ironsource.sdk.h.a(a.a()), new com.ironsource.sdk.h.d(dVar3.b));
        a2.p = new y(context2, dVar);
        a2.n = new t(context2);
        a2.o = new u(context2);
        a2.q = new l(context2);
        a2.r = new C0234a(context2);
        C0234a aVar = a2.r;
        if (a2.t == null) {
            a2.t = new C() {
                public final void a(String str, JSONObject jSONObject) {
                    A.this.b(A.b(str, jSONObject.toString()));
                }
            };
        }
        aVar.a = a2.t;
        a2.s = new m(dVar3.b, bVar);
        return a2;
    }

    private void a(d.e eVar, c cVar, final String str, final String str2) {
        Logger.i(this.c, "recoverWebController for product: " + eVar.toString());
        com.ironsource.sdk.a.a aVar = new com.ironsource.sdk.a.a();
        aVar.a("producttype", eVar.toString());
        aVar.a("demandsourcename", cVar.a);
        f.a(com.ironsource.sdk.a.h.b, (Map<String, Object>) aVar.a);
        B b2 = this.i;
        if (b2.j != B.a.c) {
            b2.h++;
            Logger.i(b2.i, "recoveringStarted - trial number " + b2.h);
            b2.j = B.a.c;
        }
        destroy();
        b((Runnable) new Runnable() {
            public final void run() {
                try {
                    g gVar = g.this;
                    n unused = gVar.a = g.a(gVar, gVar.i.b, g.this.i.d, g.this.i.c, g.this.i.e, g.this.i.f, g.this.i.g, g.this.i.a, str, str2);
                    g.this.a.g();
                } catch (Throwable th) {
                    g.this.c(Log.getStackTraceString(th));
                }
            }
        });
        this.e = new CountDownTimer(200000, 1000) {
            public final void onFinish() {
                Logger.i(g.this.c, "Recovered Controller | Global Controller Timer Finish");
                g.this.c("controller html - download timeout");
            }

            public final void onTick(long j) {
                String d = g.this.c;
                Logger.i(d, "Recovered Controller | Global Controller Timer Tick " + j);
            }
        }.start();
    }

    private void b(Runnable runnable) {
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(runnable);
        } else {
            Logger.e(this.c, "mThreadManager = null");
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        f.a(com.ironsource.sdk.a.h.d, (Map<String, Object>) new com.ironsource.sdk.a.a().a("callfailreason", str).a);
        this.d = d.b.Loading;
        this.a = new s(str, this.h);
        this.f.a();
        this.f.c();
        a aVar = this.h;
        if (aVar != null) {
            aVar.c(new Runnable() {
                public final void run() {
                    g.this.b();
                }
            });
        }
    }

    private boolean h() {
        return d.b.Ready.equals(this.d);
    }

    public final void a() {
        Logger.i(this.c, "handleControllerLoaded");
        this.d = d.b.Loaded;
        this.f.a();
        this.f.c();
    }

    public final void a(Activity activity) {
        this.a.a(activity);
    }

    public final void a(Context context) {
        n nVar;
        if (h() && (nVar = this.a) != null) {
            nVar.a(context);
        }
    }

    public final void a(final h.b bVar, final n.a aVar) {
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    if (aVar != null) {
                        g.this.j.put(bVar.b(), aVar);
                    }
                    g.this.a.a(bVar, aVar);
                }
            }
        });
    }

    public final void a(final c cVar) {
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(cVar);
                }
            }
        });
    }

    public final void a(final c cVar, final Map<String, String> map, final com.ironsource.sdk.j.a.b bVar) {
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(cVar, (Map<String, String>) map, bVar);
                }
            }
        });
    }

    public final void a(final c cVar, final Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        this.g.a(new Runnable() {
            public final void run() {
                com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("demandsourcename", cVar.a).a("producttype", com.ironsource.sdk.a.g.a(cVar, d.e.c)).a("isbiddinginstance", Boolean.valueOf(com.ironsource.sdk.a.g.a(cVar)));
                com.ironsource.sdk.service.a aVar = com.ironsource.sdk.service.a.a;
                f.a(com.ironsource.sdk.a.h.j, (Map<String, Object>) a2.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.c(cVar.b))).a);
                if (g.this.a != null) {
                    g.this.a.a(cVar, (Map<String, String>) map, cVar2);
                }
            }
        });
    }

    public final void a(Runnable runnable) {
        this.f.a(runnable);
    }

    public final void a(String str) {
        Logger.i(this.c, "handleControllerFailed ");
        com.ironsource.sdk.a.a aVar = new com.ironsource.sdk.a.a();
        aVar.a("callfailreason", str);
        aVar.a("generalmessage", String.valueOf(this.i.a()));
        f.a(com.ironsource.sdk.a.h.o, (Map<String, Object>) aVar.a);
        this.i.a(false);
        com.ironsource.sdk.j.d initListener = IronSourceNetwork.getInitListener();
        if (initListener != null) {
            initListener.onFail(new e(1001, str));
            IronSourceNetwork.setInitListener((com.ironsource.sdk.j.d) null);
        }
        if (this.e != null) {
            Logger.i(this.c, "cancel timer mControllerReadyTimer");
            this.e.cancel();
        }
        c(str);
    }

    public final void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.b bVar) {
        if (this.i.a(c(), this.d)) {
            a(d.e.a, cVar, str, str2);
        }
        final String str3 = str;
        final String str4 = str2;
        final c cVar2 = cVar;
        final com.ironsource.sdk.j.a.b bVar2 = bVar;
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(str3, str4, cVar2, bVar2);
                }
            }
        });
    }

    public final void a(String str, String str2, c cVar, com.ironsource.sdk.j.a.c cVar2) {
        if (this.i.a(c(), this.d)) {
            a(d.e.c, cVar, str, str2);
        }
        final String str3 = str;
        final String str4 = str2;
        final c cVar3 = cVar;
        final com.ironsource.sdk.j.a.c cVar4 = cVar2;
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(str3, str4, cVar3, cVar4);
                }
            }
        });
    }

    public final void a(final String str, final String str2, final com.ironsource.sdk.j.e eVar) {
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(str, str2, eVar);
                }
            }
        });
    }

    public final void a(String str, String str2, Map<String, String> map, com.ironsource.sdk.j.e eVar) {
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map2 = map;
        final com.ironsource.sdk.j.e eVar2 = eVar;
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(str3, str4, (Map<String, String>) map2, eVar2);
                }
            }
        });
    }

    public final void a(final Map<String, String> map, final com.ironsource.sdk.j.e eVar) {
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a((Map<String, String>) map, eVar);
                }
            }
        });
    }

    public final void a(final JSONObject jSONObject) {
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.a(jSONObject);
                }
            }
        });
    }

    public final void b() {
        Logger.i(this.c, "handleControllerReady ");
        if (d.c.Web.equals(c())) {
            f.a(com.ironsource.sdk.a.h.e, (Map<String, Object>) new com.ironsource.sdk.a.a().a("generalmessage", String.valueOf(this.i.a())).a);
            com.ironsource.sdk.j.d initListener = IronSourceNetwork.getInitListener();
            if (initListener != null) {
                initListener.onSuccess();
                IronSourceNetwork.setInitListener((com.ironsource.sdk.j.d) null);
            }
        }
        Logger.i(this.c, "handleReadyState");
        this.d = d.b.Ready;
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.i.a(true);
        n nVar = this.a;
        if (nVar != null) {
            nVar.b(this.i.b());
        }
        this.g.a();
        this.g.c();
        n nVar2 = this.a;
        if (nVar2 != null) {
            nVar2.f();
        }
    }

    public final void b(Context context) {
        n nVar;
        if (h() && (nVar = this.a) != null) {
            nVar.b(context);
        }
    }

    public final void b(final c cVar, final Map<String, String> map, final com.ironsource.sdk.j.a.c cVar2) {
        this.g.a(new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.b(cVar, map, cVar2);
                }
            }
        });
    }

    public final void b(String str) {
        f.a(com.ironsource.sdk.a.h.x, (Map<String, Object>) new com.ironsource.sdk.a.a().a("generalmessage", str).a);
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        c(str);
    }

    public final void b(JSONObject jSONObject) {
    }

    public final d.c c() {
        n nVar = this.a;
        return nVar != null ? nVar.c() : d.c.None;
    }

    public final void d() {
        n nVar;
        if (h() && (nVar = this.a) != null) {
            nVar.d();
        }
    }

    public void destroy() {
        Logger.i(this.c, "destroy controller");
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.g.b();
        this.e = null;
        b((Runnable) new Runnable() {
            public final void run() {
                if (g.this.a != null) {
                    g.this.a.destroy();
                    n unused = g.this.a = null;
                }
            }
        });
    }

    public final void e() {
        n nVar;
        if (h() && (nVar = this.a) != null) {
            nVar.e();
        }
    }

    @Deprecated
    public final void f() {
    }

    public final void g() {
    }
}
