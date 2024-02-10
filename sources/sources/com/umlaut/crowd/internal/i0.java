package com.umlaut.crowd.internal;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.mediarouter.media.MediaRouter;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.umlaut.crowd.threads.ThreadManager;
import java.util.ArrayList;
import java.util.List;

public class i0 implements BluetoothProfile.ServiceListener {
    /* access modifiers changed from: private */
    public final Context a;
    /* access modifiers changed from: private */
    public BluetoothAdapter b;
    private BluetoothProfile c;
    private BluetoothProfile d;
    private BluetoothProfile e;

    class a implements Runnable {
        a() {
        }

        public void run() {
            i0.this.b.getProfileProxy(i0.this.a, i0.this, 2);
            i0.this.b.getProfileProxy(i0.this.a, i0.this, 1);
            if (Build.VERSION.SDK_INT < 29) {
                i0.this.b.getProfileProxy(i0.this.a, i0.this, 3);
            }
        }
    }

    public i0(Context context) {
        this.a = context;
        if (context.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0) {
            BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
            BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
            this.b = adapter;
            if (adapter != null) {
                ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
            }
        }
    }

    private m0 c(int i) {
        switch (i) {
            case 0:
                return m0.Misc;
            case 256:
                return m0.Computer;
            case 512:
                return m0.Phone;
            case 768:
                return m0.Networking;
            case 1024:
                return m0.AudioVideo;
            case 1280:
                return m0.Peripheral;
            case 1536:
                return m0.Imaging;
            case 1792:
                return m0.Wearable;
            case 2048:
                return m0.Toy;
            case 2304:
                return m0.Health;
            case 7936:
                return m0.Uncategorized;
            default:
                return m0.Unknown;
        }
    }

    public h0 d(int i) {
        return a(this.b.getProfileConnectionState(i));
    }

    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        if (i == 1) {
            this.d = bluetoothProfile;
        } else if (i == 3) {
            this.e = bluetoothProfile;
        } else if (i == 2) {
            this.c = bluetoothProfile;
        }
    }

    public void onServiceDisconnected(int i) {
        if (i == 1) {
            this.d = null;
        } else if (i == 3) {
            this.e = null;
        } else if (i == 2) {
            this.c = null;
        }
    }

    private k0 b(int i) {
        switch (i) {
            case 256:
                return k0.ComputerUncategorized;
            case 260:
                return k0.ComputerDesktop;
            case MediaRouter.GlobalMediaRouter.CallbackHandler.MSG_ROUTE_ANOTHER_SELECTED:
                return k0.ComputerServer;
            case 268:
                return k0.ComputerLaptop;
            case 272:
                return k0.ComputerHandheldPcPda;
            case 276:
                return k0.ComputerPalmSizePcPda;
            case 280:
                return k0.ComputerWearable;
            case 512:
                return k0.PhoneUncategorized;
            case 516:
                return k0.PhoneCellular;
            case IronSourceError.ERROR_NO_INTERNET_CONNECTION:
                return k0.PhoneCordless;
            case IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT:
                return k0.PhoneSmart;
            case 528:
                return k0.PhoneModemOoGateway;
            case 532:
                return k0.PhoneIsdn;
            case 1024:
                return k0.AudioVideoUncategorized;
            case 1028:
                return k0.AudioVideoWearableHeadset;
            case 1032:
                return k0.AudioVideoHandsfree;
            case IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION:
                return k0.AudioVideoMicrophone;
            case IronSourceError.ERROR_BN_LOAD_FAILED_NO_CANDIDATES:
                return k0.AudioVideoLoudspeaker;
            case 1048:
                return k0.AudioVideoHeadphones;
            case IronSourceError.ERROR_DO_IS_LOAD_TIMED_OUT:
                return k0.AudioVideoPortableAudio;
            case IronSourceError.ERROR_DO_RV_LOAD_DURING_SHOW:
                return k0.AudioVideoCarAaudio;
            case IronSourceError.ERROR_DO_RV_LOAD_MISSING_ACTIVITY:
                return k0.AudioVideoSetTopBox;
            case IronSourceError.ERROR_DO_IS_SHOW_DURING_SHOW:
                return k0.AudioVideoHifiAudio;
            case IronSourceError.ERROR_DO_RV_SHOW_DURING_LOAD:
                return k0.AudioVideoVcr;
            case 1072:
                return k0.AudioVideoVideoCamera;
            case 1076:
                return k0.AudioVideoCamcorder;
            case 1080:
                return k0.AudioVideoVideoMonitor;
            case 1084:
                return k0.AudioVideoVideoDisplayAndLoudspeaker;
            case 1088:
                return k0.AudioVideoVideoConferencing;
            case 1096:
                return k0.AudioVideoVideoGamingToy;
            case 1792:
                return k0.WearableUncategorized;
            case 1796:
                return k0.WearableWristWatch;
            case 1800:
                return k0.WearablePager;
            case 1804:
                return k0.WearableJacket;
            case 1808:
                return k0.WearableHelmet;
            case 1812:
                return k0.WearableGlasses;
            case 2048:
                return k0.ToyUncategorized;
            case 2052:
                return k0.ToyRobot;
            case 2056:
                return k0.ToyVehicle;
            case 2060:
                return k0.ToyDollActionFigure;
            case 2064:
                return k0.ToyController;
            case 2068:
                return k0.ToyGame;
            case 2304:
                return k0.HealthUncategorized;
            case 2308:
                return k0.HealthBloodPressure;
            case 2312:
                return k0.HealthThermometer;
            case 2316:
                return k0.HealthWeighing;
            case IronSourceConstants.IS_COLLECT_TOKENS:
                return k0.HealthGlucose;
            case 2324:
                return k0.HealthPulseOximeter;
            case 2328:
                return k0.HealthPulseRate;
            case 2332:
                return k0.HealthDataDisplay;
            default:
                return k0.Unknown;
        }
    }

    public l0 a() {
        int i;
        l0 l0Var = new l0();
        if (this.a.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == -1 || ((i = Build.VERSION.SDK_INT) >= 31 && this.a.checkCallingOrSelfPermission("android.permission.BLUETOOTH_CONNECT") == -1)) {
            l0Var.MissingPermission = true;
            return l0Var;
        }
        BluetoothAdapter bluetoothAdapter = this.b;
        if (bluetoothAdapter == null) {
            return l0Var;
        }
        try {
            if (!bluetoothAdapter.isEnabled()) {
                return l0Var;
            }
            l0Var.BluetoothEnabled = this.b.isEnabled();
            l0Var.PairedBluetoothDevices = a((List<BluetoothDevice>) new ArrayList(this.b.getBondedDevices()));
            if (i < 29) {
                l0Var.HealthConnectionState = d(3);
            }
            l0Var.HeadsetConnectionState = d(1);
            l0Var.A2DPConnectionState = d(2);
            BluetoothProfile bluetoothProfile = this.e;
            if (bluetoothProfile != null) {
                l0Var.ConnectedHealthBluetoothDevices = a(bluetoothProfile.getConnectedDevices());
            }
            BluetoothProfile bluetoothProfile2 = this.d;
            if (bluetoothProfile2 != null) {
                l0Var.ConnectedHeadsetBluetoothDevices = a(bluetoothProfile2.getConnectedDevices());
            }
            BluetoothProfile bluetoothProfile3 = this.c;
            if (bluetoothProfile3 != null) {
                l0Var.ConnectedA2DPBluetoothDevices = a(bluetoothProfile3.getConnectedDevices());
            }
            return l0Var;
        } catch (Exception e2) {
            Log.d("BluetoothController", e2.toString());
        }
    }

    private j0[] a(List<BluetoothDevice> list) {
        ArrayList arrayList = new ArrayList();
        for (BluetoothDevice next : list) {
            j0 j0Var = new j0();
            j0Var.Name = next.getName();
            if (next.getType() == 1) {
                j0Var.Type = n0.Classic;
            } else if (next.getType() == 2) {
                j0Var.Type = n0.LowEnergy;
            } else if (next.getType() == 3) {
                j0Var.Type = n0.DualMode;
            }
            if (next.getBondState() == 10) {
                j0Var.BondState = g0.None;
            } else if (next.getBondState() == 11) {
                j0Var.BondState = g0.Bonding;
            } else if (next.getBondState() == 12) {
                j0Var.BondState = g0.Bonded;
            }
            BluetoothClass bluetoothClass = next.getBluetoothClass();
            if (bluetoothClass != null) {
                j0Var.DeviceClass = b(bluetoothClass.getDeviceClass());
                j0Var.MajorDeviceClass = c(bluetoothClass.getMajorDeviceClass());
            }
            arrayList.add(j0Var);
        }
        return (j0[]) arrayList.toArray(new j0[0]);
    }

    private h0 a(int i) {
        if (i == 0) {
            return h0.Disconnected;
        }
        if (i == 1) {
            return h0.Connecting;
        }
        if (i == 2) {
            return h0.Connected;
        }
        if (i != 3) {
            return h0.Unknown;
        }
        return h0.Disconnecting;
    }
}
