package stikerwap.appdys;

import android.telephony.PreciseDisconnectCause;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.WebSocketProtocol;

public final class TweetNaclFast {
    private static final long[] D = {30883, 4953, 19914, 30187, 55467, 16705, 2637, 112, 59544, 30585, 16505, 36039, 65139, 11119, 27886, 20995};
    private static final long[] D2 = {61785, 9906, 39828, 60374, 45398, 33411, 5274, 224, 53552, 61171, 33010, 6542, 64743, 22239, 55772, 9222};
    private static final long[] I = {41136, 18958, 6951, 50414, 58488, 44335, 6150, 12099, 55207, 15867, 153, 11085, 57099, 20417, 9344, 11139};
    private static final long[] K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    private static final long[] L = {237, 211, 245, 92, 26, 99, 18, 88, 214, 156, 247, 162, 222, 249, 222, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16};
    private static final String TAG = "TweetNaclFast";
    private static final long[] X = {54554, 36645, 11616, 51542, 42930, 38181, 51040, 26924, 56412, 64982, 57905, 49316, 21502, 52590, 14035, 8553};
    private static final long[] Y = {26200, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214, 26214};
    private static final byte[] _0 = new byte[16];
    private static final long[] _121665;
    private static final byte[] _9;
    private static final long[] gf0 = new long[16];
    private static final long[] gf1;
    private static final SecureRandom jrandom = new SecureRandom();
    private static final byte[] sigma = {101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107};

    public static final class Box {
        private static final String TAG = "Box";
        public static final int boxzerobytesLength = 16;
        public static final int nonceLength = 24;
        public static final int overheadLength = 16;
        public static final int publicKeyLength = 32;
        public static final int secretKeyLength = 32;
        public static final int sharedKeyLength = 32;
        public static final int zerobytesLength = 32;
        private byte[] mySecretKey;
        private AtomicLong nonce;
        private byte[] sharedKey;
        private byte[] theirPublicKey;

        public Box(byte[] bArr, byte[] bArr2) {
            this(bArr, bArr2, 68);
        }

        public Box(byte[] bArr, byte[] bArr2, long j) {
            this.theirPublicKey = bArr;
            this.mySecretKey = bArr2;
            this.nonce = new AtomicLong(j);
            before();
        }

        public void setNonce(long j) {
            this.nonce.set(j);
        }

        public long getNonce() {
            return this.nonce.get();
        }

        public long incrNonce() {
            return this.nonce.incrementAndGet();
        }

        private byte[] generateNonce() {
            long j = this.nonce.get();
            byte[] bArr = new byte[24];
            for (int i = 0; i < 24; i += 8) {
                bArr[i + 0] = (byte) ((int) (j >>> 0));
                bArr[i + 1] = (byte) ((int) (j >>> 8));
                bArr[i + 2] = (byte) ((int) (j >>> 16));
                bArr[i + 3] = (byte) ((int) (j >>> 24));
                bArr[i + 4] = (byte) ((int) (j >>> 32));
                bArr[i + 5] = (byte) ((int) (j >>> 40));
                bArr[i + 6] = (byte) ((int) (j >>> 48));
                bArr[i + 7] = (byte) ((int) (j >>> 56));
            }
            return bArr;
        }

        public byte[] box(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return box(bArr, 0, bArr.length);
        }

        public byte[] box(byte[] bArr, int i) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return box(bArr, i, bArr.length - i);
        }

        public byte[] box(byte[] bArr, int i, int i2) {
            if (bArr == null || bArr.length < i + i2) {
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return after(bArr, i, i2);
        }

        public byte[] box(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                return null;
            }
            return box(bArr, 0, bArr.length, bArr2);
        }

        public byte[] box(byte[] bArr, int i, byte[] bArr2) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return box(bArr, i, bArr.length - i, bArr2);
        }

        public byte[] box(byte[] bArr, int i, int i2, byte[] bArr2) {
            if (bArr == null || bArr.length < i + i2 || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return after(bArr, i, i2, bArr2);
        }

        public byte[] open(byte[] bArr) {
            if (bArr == null) {
                Log.e("phantom", "box es null!");
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return open_after(bArr, 0, bArr.length);
        }

        public byte[] open(byte[] bArr, int i) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return open_after(bArr, i, bArr.length - i);
        }

        public byte[] open(byte[] bArr, int i, int i2) {
            if (bArr == null || bArr.length < i + i2) {
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return open_after(bArr, i, i2);
        }

        public byte[] open(byte[] bArr, byte[] bArr2) {
            if (bArr == null || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return open_after(bArr, 0, bArr.length, bArr2);
        }

        public byte[] open(byte[] bArr, int i, byte[] bArr2) {
            if (bArr == null || bArr.length <= i || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return open_after(bArr, i, bArr.length - i, bArr2);
        }

        public byte[] open(byte[] bArr, int i, int i2, byte[] bArr2) {
            if (bArr == null || bArr.length < i + i2 || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            if (this.sharedKey == null) {
                before();
            }
            return open_after(bArr, i, i2, bArr2);
        }

        public byte[] before() {
            if (this.sharedKey == null) {
                Log.e("phantom", "sharedKey era null !!!");
                this.sharedKey = new byte[32];
                Log.e("phantom", "sharedkey generada:" + this.sharedKey);
                TweetNaclFast.crypto_box_beforenm(this.sharedKey, this.theirPublicKey, this.mySecretKey);
            }
            Log.e("phantom", "se torne" + this.sharedKey);
            return this.sharedKey;
        }

        public byte[] after(byte[] bArr, int i, int i2) {
            return after(bArr, i, i2, generateNonce());
        }

        public byte[] after(byte[] bArr, int i, int i2, byte[] bArr2) {
            if (bArr == null || bArr.length < i + i2 || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            int i3 = i2 + 32;
            byte[] bArr3 = new byte[i3];
            byte[] bArr4 = new byte[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i4 + 32] = bArr[i4 + i];
            }
            if (TweetNaclFast.crypto_box_afternm(bArr4, bArr3, i3, bArr2, this.sharedKey) != 0) {
                return null;
            }
            int i5 = i3 - 16;
            byte[] bArr5 = new byte[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                bArr5[i6] = bArr4[i6 + 16];
            }
            return bArr5;
        }

        public byte[] open_after(byte[] bArr, int i, int i2) {
            return open_after(bArr, i, i2, generateNonce());
        }

        public byte[] open_after(byte[] bArr, int i, int i2, byte[] bArr2) {
            if (bArr == null || bArr.length < i + i2 || i2 < 16) {
                return null;
            }
            int i3 = i2 + 16;
            byte[] bArr3 = new byte[i3];
            byte[] bArr4 = new byte[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i4 + 16] = bArr[i4 + i];
            }
            if (TweetNaclFast.crypto_box_open_afternm(bArr4, bArr3, i3, bArr2, this.sharedKey) != 0) {
                return null;
            }
            int i5 = i3 - 32;
            byte[] bArr5 = new byte[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                bArr5[i6] = bArr4[i6 + 32];
            }
            return bArr5;
        }

        public static class KeyPair {
            private byte[] publicKey = new byte[32];
            private byte[] secretKey = new byte[32];

            public byte[] getPublicKey() {
                return this.publicKey;
            }

            public byte[] getSecretKey() {
                return this.secretKey;
            }
        }

        public static KeyPair keyPair() {
            KeyPair keyPair = new KeyPair();
            TweetNaclFast.crypto_box_keypair(keyPair.getPublicKey(), keyPair.getSecretKey());
            return keyPair;
        }

        public static KeyPair keyPair_fromSecretKey(byte[] bArr) {
            KeyPair keyPair = new KeyPair();
            byte[] secretKey = keyPair.getSecretKey();
            byte[] publicKey = keyPair.getPublicKey();
            for (int i = 0; i < secretKey.length; i++) {
                secretKey[i] = bArr[i];
            }
            TweetNaclFast.crypto_scalarmult_base(publicKey, secretKey);
            return keyPair;
        }
    }

    public static final class SecretBox {
        private static final String TAG = "SecretBox";
        public static final int boxzerobytesLength = 16;
        public static final int keyLength = 32;
        public static final int nonceLength = 24;
        public static final int overheadLength = 16;
        public static final int zerobytesLength = 32;
        private byte[] key;
        private AtomicLong nonce;

        public SecretBox(byte[] bArr) {
            this(bArr, 68);
        }

        public SecretBox(byte[] bArr, long j) {
            this.key = bArr;
            this.nonce = new AtomicLong(j);
        }

        public void setNonce(long j) {
            this.nonce.set(j);
        }

        public long getNonce() {
            return this.nonce.get();
        }

        public long incrNonce() {
            return this.nonce.incrementAndGet();
        }

        private byte[] generateNonce() {
            long j = this.nonce.get();
            byte[] bArr = new byte[24];
            for (int i = 0; i < 24; i += 8) {
                bArr[i + 0] = (byte) ((int) (j >>> 0));
                bArr[i + 1] = (byte) ((int) (j >>> 8));
                bArr[i + 2] = (byte) ((int) (j >>> 16));
                bArr[i + 3] = (byte) ((int) (j >>> 24));
                bArr[i + 4] = (byte) ((int) (j >>> 32));
                bArr[i + 5] = (byte) ((int) (j >>> 40));
                bArr[i + 6] = (byte) ((int) (j >>> 48));
                bArr[i + 7] = (byte) ((int) (j >>> 56));
            }
            return bArr;
        }

        public byte[] box(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return box(bArr, 0, bArr.length);
        }

        public byte[] box(byte[] bArr, int i) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return box(bArr, i, bArr.length - i);
        }

        public byte[] box(byte[] bArr, int i, int i2) {
            if (bArr == null || bArr.length < i2 + i) {
                return null;
            }
            return box(bArr, i, bArr.length - i, generateNonce());
        }

        public byte[] box(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                return null;
            }
            return box(bArr, 0, bArr.length, bArr2);
        }

        public byte[] box(byte[] bArr, int i, byte[] bArr2) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return box(bArr, i, bArr.length - i, bArr2);
        }

        public byte[] box(byte[] bArr, int i, int i2, byte[] bArr2) {
            if (bArr == null || bArr.length < i + i2 || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            int i3 = i2 + 32;
            byte[] bArr3 = new byte[i3];
            byte[] bArr4 = new byte[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i4 + 32] = bArr[i4 + i];
            }
            if (TweetNaclFast.crypto_secretbox(bArr4, bArr3, i3, bArr2, this.key) != 0) {
                return null;
            }
            int i5 = i3 - 16;
            byte[] bArr5 = new byte[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                bArr5[i6] = bArr4[i6 + 16];
            }
            return bArr5;
        }

        public byte[] open(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return open(bArr, 0, bArr.length);
        }

        public byte[] open(byte[] bArr, int i) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return open(bArr, i, bArr.length - i);
        }

        public byte[] open(byte[] bArr, int i, int i2) {
            if (bArr == null || bArr.length < i + i2 || i2 < 16) {
                return null;
            }
            return open(bArr, i, bArr.length - i, generateNonce());
        }

        public byte[] open(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                return null;
            }
            return open(bArr, 0, bArr.length, bArr2);
        }

        public byte[] open(byte[] bArr, int i, byte[] bArr2) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return open(bArr, i, bArr.length - i, bArr2);
        }

        public byte[] open(byte[] bArr, int i, int i2, byte[] bArr2) {
            if (bArr == null || bArr.length < i + i2 || i2 < 16 || bArr2 == null || bArr2.length != 24) {
                return null;
            }
            int i3 = i2 + 16;
            byte[] bArr3 = new byte[i3];
            byte[] bArr4 = new byte[i3];
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i4 + 16] = bArr[i4 + i];
            }
            if (TweetNaclFast.crypto_secretbox_open(bArr4, bArr3, i3, bArr2, this.key) != 0) {
                return null;
            }
            int i5 = i3 - 32;
            byte[] bArr5 = new byte[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                bArr5[i6] = bArr4[i6 + 32];
            }
            return bArr5;
        }
    }

    public static final class ScalarMult {
        private static final String TAG = "ScalarMult";
        public static final int groupElementLength = 32;
        public static final int scalarLength = 32;

        public static byte[] scalseMult(byte[] bArr, byte[] bArr2) {
            if (bArr.length != 32 || bArr2.length != 32) {
                return null;
            }
            byte[] bArr3 = new byte[32];
            TweetNaclFast.crypto_scalarmult(bArr3, bArr, bArr2);
            return bArr3;
        }

        public static byte[] scalseMult_base(byte[] bArr) {
            if (bArr.length != 32) {
                return null;
            }
            byte[] bArr2 = new byte[32];
            TweetNaclFast.crypto_scalarmult_base(bArr2, bArr);
            return bArr2;
        }
    }

    public static final class Hash {
        private static final String TAG = "Hash";
        public static final int hashLength = 64;

        public static byte[] sha512(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[64];
            TweetNaclFast.crypto_hash(bArr2, bArr);
            return bArr2;
        }

        public static byte[] sha512(String str) throws UnsupportedEncodingException {
            return sha512(str.getBytes("utf-8"));
        }
    }

    public static final class Signature {
        private static final String TAG = "Signature";
        public static final int publicKeyLength = 32;
        public static final int secretKeyLength = 64;
        public static final int seedLength = 32;
        public static final int signatureLength = 64;
        private byte[] mySecretKey;
        private byte[] theirPublicKey;

        public Signature(byte[] bArr, byte[] bArr2) {
            this.theirPublicKey = bArr;
            this.mySecretKey = bArr2;
        }

        public byte[] sign(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return sign(bArr, 0, bArr.length);
        }

        public byte[] sign(byte[] bArr, int i) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return sign(bArr, i, bArr.length - i);
        }

        public byte[] sign(byte[] bArr, int i, int i2) {
            if (bArr == null || bArr.length < i + i2) {
                return null;
            }
            byte[] bArr2 = new byte[(i2 + 64)];
            TweetNaclFast.crypto_sign(bArr2, -1, bArr, i, i2, this.mySecretKey);
            return bArr2;
        }

        public byte[] open(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            return open(bArr, 0, bArr.length);
        }

        public byte[] open(byte[] bArr, int i) {
            if (bArr == null || bArr.length <= i) {
                return null;
            }
            return open(bArr, i, bArr.length - i);
        }

        public byte[] open(byte[] bArr, int i, int i2) {
            byte[] bArr2 = null;
            if (bArr != null && bArr.length >= i + i2 && i2 >= 64) {
                if (TweetNaclFast.crypto_sign_open(new byte[i2], -1, bArr, i, i2, this.theirPublicKey) != 0) {
                    return null;
                }
                int i3 = i2 - 64;
                bArr2 = new byte[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr2[i4] = bArr[i + i4 + 64];
                }
            }
            return bArr2;
        }

        public byte[] detached(byte[] bArr) {
            byte[] sign = sign(bArr);
            byte[] bArr2 = new byte[64];
            for (int i = 0; i < 64; i++) {
                bArr2[i] = sign[i];
            }
            return bArr2;
        }

        public boolean detached_verify(byte[] bArr, byte[] bArr2) {
            if (bArr2.length != 64 || this.theirPublicKey.length != 32) {
                return false;
            }
            int length = bArr.length + 64;
            byte[] bArr3 = new byte[length];
            byte[] bArr4 = new byte[(bArr.length + 64)];
            for (int i = 0; i < 64; i++) {
                bArr3[i] = bArr2[i];
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr3[i2 + 64] = bArr[i2];
            }
            if (TweetNaclFast.crypto_sign_open(bArr4, -1, bArr3, 0, length, this.theirPublicKey) >= 0) {
                return true;
            }
            return false;
        }

        public static class KeyPair {
            private byte[] publicKey = new byte[32];
            private byte[] secretKey = new byte[64];

            public byte[] getPublicKey() {
                return this.publicKey;
            }

            public byte[] getSecretKey() {
                return this.secretKey;
            }
        }

        public static KeyPair keyPair() {
            KeyPair keyPair = new KeyPair();
            TweetNaclFast.crypto_sign_keypair(keyPair.getPublicKey(), keyPair.getSecretKey(), false);
            return keyPair;
        }

        public static KeyPair keyPair_fromSecretKey(byte[] bArr) {
            KeyPair keyPair = new KeyPair();
            byte[] publicKey = keyPair.getPublicKey();
            byte[] secretKey = keyPair.getSecretKey();
            for (int i = 0; i < keyPair.getSecretKey().length; i++) {
                secretKey[i] = bArr[i];
            }
            for (int i2 = 0; i2 < keyPair.getPublicKey().length; i2++) {
                publicKey[i2] = bArr[i2 + 32];
            }
            return keyPair;
        }

        public static KeyPair keyPair_fromSeed(byte[] bArr) {
            KeyPair keyPair = new KeyPair();
            byte[] publicKey = keyPair.getPublicKey();
            byte[] secretKey = keyPair.getSecretKey();
            for (int i = 0; i < 32; i++) {
                secretKey[i] = bArr[i];
            }
            TweetNaclFast.crypto_sign_keypair(publicKey, secretKey, true);
            return keyPair;
        }
    }

    static {
        byte[] bArr = new byte[32];
        _9 = bArr;
        bArr[0] = 9;
        long[] jArr = new long[16];
        gf1 = jArr;
        long[] jArr2 = new long[16];
        _121665 = jArr2;
        jArr[0] = 1;
        jArr2[0] = 56129;
        jArr2[1] = 1;
    }

    private static void ts64(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) ((int) (j & 255));
        long j2 = j >>> 8;
        bArr[i + 6] = (byte) ((int) (j2 & 255));
        long j3 = j2 >>> 8;
        bArr[i + 5] = (byte) ((int) (j3 & 255));
        long j4 = j3 >>> 8;
        bArr[i + 4] = (byte) ((int) (j4 & 255));
        long j5 = j4 >>> 8;
        bArr[i + 3] = (byte) ((int) (j5 & 255));
        long j6 = j5 >>> 8;
        bArr[i + 2] = (byte) ((int) (j6 & 255));
        long j7 = j6 >>> 8;
        bArr[i + 1] = (byte) ((int) (j7 & 255));
        bArr[i + 0] = (byte) ((int) ((j7 >>> 8) & 255));
    }

    private static int vn(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        byte b = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            b |= (bArr[i4 + i] ^ bArr2[i4 + i2]) & 255;
        }
        return (((b - 1) >>> 8) & 1) - 1;
    }

    private static int crypto_verify_16(byte[] bArr, int i, byte[] bArr2, int i2) {
        return vn(bArr, i, bArr2, i2, 16);
    }

    public static int crypto_verify_16(byte[] bArr, byte[] bArr2) {
        return crypto_verify_16(bArr, 0, bArr2, 0);
    }

    private static int crypto_verify_32(byte[] bArr, int i, byte[] bArr2, int i2) {
        return vn(bArr, i, bArr2, i2, 32);
    }

    public static int crypto_verify_32(byte[] bArr, byte[] bArr2) {
        return crypto_verify_32(bArr, 0, bArr2, 0);
    }

    /* JADX WARNING: type inference failed for: r44v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r45v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r46v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r1v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r5v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r7v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r7v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v6, types: [byte] */
    /* JADX WARNING: type inference failed for: r10v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r12v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r5v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v6, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v5, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v10, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v15, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v18, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v8, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v11, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v14, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v17, types: [byte] */
    /* JADX WARNING: type inference failed for: r0v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r2v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v20, types: [byte] */
    /* JADX WARNING: type inference failed for: r2v7, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v21, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v24, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v27, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v30, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r12v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v33, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v34, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v35, types: [byte] */
    /* JADX WARNING: type inference failed for: r11v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v15, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v18, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v10, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v40, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v41, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v26, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v43, types: [byte] */
    /* JADX WARNING: type inference failed for: r4v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v47, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v51, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v30, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v54, types: [byte] */
    /* JADX WARNING: type inference failed for: r6v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v35, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v58, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v62, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v66, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v70, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v73, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v77, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v7, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v81, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v40, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v44, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void core_salsa20(byte[] r43, byte[] r44, byte[] r45, byte[] r46) {
        /*
            r0 = 0
            byte r1 = r46[r0]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 1
            byte r3 = r46[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 8
            int r3 = r3 << r4
            r1 = r1 | r3
            r3 = 2
            byte r5 = r46[r3]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = 16
            int r5 = r5 << r6
            r1 = r1 | r5
            r5 = 3
            byte r7 = r46[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            r8 = 24
            int r7 = r7 << r8
            r1 = r1 | r7
            byte r7 = r45[r0]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r9 = r45[r2]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r4
            r7 = r7 | r9
            byte r9 = r45[r3]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r6
            r7 = r7 | r9
            byte r9 = r45[r5]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r8
            r7 = r7 | r9
            r9 = 4
            byte r10 = r45[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r11 = 5
            byte r12 = r45[r11]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r4
            r10 = r10 | r12
            r12 = 6
            byte r13 = r45[r12]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r6
            r10 = r10 | r13
            r13 = 7
            byte r14 = r45[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r8
            r10 = r10 | r14
            byte r14 = r45[r4]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r15 = 9
            byte r5 = r45[r15]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r4
            r5 = r5 | r14
            r14 = 10
            byte r15 = r45[r14]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r5 = r5 | r15
            r15 = 11
            byte r14 = r45[r15]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r8
            r5 = r5 | r14
            r14 = 12
            byte r15 = r45[r14]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r17 = 13
            byte r14 = r45[r17]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r4
            r14 = r14 | r15
            r15 = 14
            byte r3 = r45[r15]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r6
            r3 = r3 | r14
            r14 = 15
            byte r14 = r45[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r8
            r3 = r3 | r14
            byte r14 = r46[r9]
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte r15 = r46[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r14 = r14 | r15
            byte r15 = r46[r12]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r14 = r14 | r15
            byte r15 = r46[r13]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r14 = r14 | r15
            byte r15 = r44[r0]
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r0 = r44[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            r0 = r0 | r15
            r15 = 2
            byte r2 = r44[r15]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r0 = r0 | r2
            r2 = 3
            byte r15 = r44[r2]
            r2 = r15 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r8
            r0 = r0 | r2
            byte r2 = r44[r9]
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r15 = r44[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r2 = r2 | r15
            byte r15 = r44[r12]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r2 = r2 | r15
            byte r15 = r44[r13]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r2 = r2 | r15
            byte r15 = r44[r4]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r16 = 9
            byte r13 = r44[r16]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r4
            r13 = r13 | r15
            r15 = 10
            byte r12 = r44[r15]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r6
            r12 = r12 | r13
            r13 = 11
            byte r15 = r44[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r8
            r12 = r12 | r13
            r13 = 12
            byte r15 = r44[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r44[r17]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r13 = r13 | r15
            r15 = 14
            byte r11 = r44[r15]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << r6
            r11 = r11 | r13
            r13 = 15
            byte r13 = r44[r13]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r8
            r11 = r11 | r13
            byte r13 = r46[r4]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r15 = 9
            byte r9 = r46[r15]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r4
            r9 = r9 | r13
            r13 = 10
            byte r15 = r46[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r6
            r9 = r9 | r13
            r13 = 11
            byte r15 = r46[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r8
            r9 = r9 | r13
            byte r13 = r45[r6]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r15 = 17
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r13 = r13 | r15
            r15 = 18
            byte r4 = r45[r15]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r6
            r4 = r4 | r13
            r13 = 19
            byte r15 = r45[r13]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r4 = r4 | r15
            r15 = 20
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r22 = 21
            byte r13 = r45[r22]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r21 = 8
            int r13 = r13 << 8
            r13 = r13 | r15
            r15 = 22
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r13 = r13 | r15
            r15 = 23
            byte r6 = r45[r15]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r8
            r6 = r6 | r13
            byte r13 = r45[r8]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r24 = 25
            byte r15 = r45[r24]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r21 = 8
            int r15 = r15 << 8
            r13 = r13 | r15
            r15 = 26
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r22 = 16
            int r15 = r15 << 16
            r13 = r13 | r15
            r15 = 27
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r13 = r13 | r15
            r15 = 28
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r26 = 29
            byte r8 = r45[r26]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r21 = 8
            int r8 = r8 << 8
            r8 = r8 | r15
            r15 = 30
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r22 = 16
            int r15 = r15 << 16
            r8 = r8 | r15
            r15 = 31
            byte r15 = r45[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r26 = 24
            int r15 = r15 << 24
            r8 = r8 | r15
            r45 = r8
            r15 = 12
            byte r8 = r46[r15]
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r15 = r46[r17]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r21 = 8
            int r15 = r15 << 8
            r8 = r8 | r15
            r26 = r13
            r15 = 14
            byte r13 = r46[r15]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r15 = 16
            int r13 = r13 << r15
            r8 = r8 | r13
            r13 = 15
            byte r13 = r46[r13]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r15 = 24
            int r13 = r13 << r15
            r8 = r8 | r13
            r40 = r45
            r32 = r0
            r15 = r1
            r33 = r2
            r30 = r3
            r37 = r4
            r29 = r5
            r38 = r6
            r27 = r7
            r46 = r8
            r41 = r46
            r36 = r9
            r28 = r10
            r35 = r11
            r34 = r12
            r31 = r14
            r39 = r26
            r13 = 0
        L_0x01f1:
            r8 = 20
            if (r13 >= r8) goto L_0x03b5
            int r8 = r15 + r38
            r20 = 0
            r8 = r8 | 0
            int r42 = r8 << 7
            int r8 = r8 >>> 25
            r8 = r42 | r8
            r8 = r30 ^ r8
            int r30 = r8 + r15
            r30 = r30 | 0
            int r42 = r30 << 9
            r25 = 23
            int r30 = r30 >>> 23
            r30 = r42 | r30
            r30 = r34 ^ r30
            int r34 = r30 + r8
            r34 = r34 | 0
            int r42 = r34 << 13
            r23 = 19
            int r34 = r34 >>> 19
            r34 = r42 | r34
            r34 = r38 ^ r34
            int r38 = r34 + r30
            r38 = r38 | 0
            int r42 = r38 << 18
            r19 = 14
            int r38 = r38 >>> 14
            r38 = r42 | r38
            r15 = r15 ^ r38
            int r38 = r31 + r27
            r38 = r38 | 0
            int r42 = r38 << 7
            int r38 = r38 >>> 25
            r38 = r42 | r38
            r35 = r35 ^ r38
            int r38 = r35 + r31
            r38 = r38 | 0
            int r42 = r38 << 9
            r25 = 23
            int r38 = r38 >>> 23
            r38 = r42 | r38
            r38 = r39 ^ r38
            int r39 = r38 + r35
            r39 = r39 | 0
            int r42 = r39 << 13
            r23 = 19
            int r39 = r39 >>> 19
            r39 = r42 | r39
            r27 = r27 ^ r39
            int r39 = r27 + r38
            r39 = r39 | 0
            int r42 = r39 << 18
            r19 = 14
            int r39 = r39 >>> 14
            r39 = r42 | r39
            r31 = r31 ^ r39
            int r39 = r36 + r32
            r39 = r39 | 0
            int r42 = r39 << 7
            int r39 = r39 >>> 25
            r39 = r42 | r39
            r39 = r40 ^ r39
            int r40 = r39 + r36
            r40 = r40 | 0
            int r42 = r40 << 9
            r25 = 23
            int r40 = r40 >>> 23
            r40 = r42 | r40
            r28 = r28 ^ r40
            int r40 = r28 + r39
            r40 = r40 | 0
            int r42 = r40 << 13
            r23 = 19
            int r40 = r40 >>> 19
            r40 = r42 | r40
            r32 = r32 ^ r40
            int r40 = r32 + r28
            r40 = r40 | 0
            int r42 = r40 << 18
            r19 = 14
            int r40 = r40 >>> 14
            r40 = r42 | r40
            r36 = r36 ^ r40
            int r40 = r41 + r37
            r40 = r40 | 0
            int r42 = r40 << 7
            int r40 = r40 >>> 25
            r40 = r42 | r40
            r29 = r29 ^ r40
            int r40 = r29 + r41
            r40 = r40 | 0
            int r42 = r40 << 9
            r25 = 23
            int r40 = r40 >>> 23
            r40 = r42 | r40
            r33 = r33 ^ r40
            int r40 = r33 + r29
            r40 = r40 | 0
            int r42 = r40 << 13
            r23 = 19
            int r40 = r40 >>> 19
            r40 = r42 | r40
            r37 = r37 ^ r40
            int r40 = r37 + r33
            r40 = r40 | 0
            int r42 = r40 << 18
            r19 = 14
            int r40 = r40 >>> 14
            r40 = r42 | r40
            r40 = r41 ^ r40
            int r41 = r15 + r29
            r41 = r41 | 0
            int r42 = r41 << 7
            int r41 = r41 >>> 25
            r41 = r42 | r41
            r27 = r27 ^ r41
            int r41 = r27 + r15
            r41 = r41 | 0
            int r42 = r41 << 9
            r25 = 23
            int r41 = r41 >>> 23
            r41 = r42 | r41
            r28 = r28 ^ r41
            int r41 = r28 + r27
            r41 = r41 | 0
            int r42 = r41 << 13
            r23 = 19
            int r41 = r41 >>> 19
            r41 = r42 | r41
            r29 = r29 ^ r41
            int r41 = r29 + r28
            r41 = r41 | 0
            int r42 = r41 << 18
            r19 = 14
            int r41 = r41 >>> 14
            r41 = r42 | r41
            r15 = r15 ^ r41
            int r41 = r31 + r8
            r41 = r41 | 0
            int r42 = r41 << 7
            int r41 = r41 >>> 25
            r41 = r42 | r41
            r32 = r32 ^ r41
            int r41 = r32 + r31
            r41 = r41 | 0
            int r42 = r41 << 9
            r25 = 23
            int r41 = r41 >>> 23
            r41 = r42 | r41
            r33 = r33 ^ r41
            int r41 = r33 + r32
            r41 = r41 | 0
            int r42 = r41 << 13
            r23 = 19
            int r41 = r41 >>> 19
            r41 = r42 | r41
            r8 = r8 ^ r41
            int r41 = r8 + r33
            r41 = r41 | 0
            int r42 = r41 << 18
            r19 = 14
            int r41 = r41 >>> 14
            r41 = r42 | r41
            r31 = r31 ^ r41
            int r41 = r36 + r35
            r41 = r41 | 0
            int r42 = r41 << 7
            int r41 = r41 >>> 25
            r41 = r42 | r41
            r37 = r37 ^ r41
            int r41 = r37 + r36
            r41 = r41 | 0
            int r42 = r41 << 9
            r25 = 23
            int r41 = r41 >>> 23
            r41 = r42 | r41
            r30 = r30 ^ r41
            int r41 = r30 + r37
            r41 = r41 | 0
            int r42 = r41 << 13
            r23 = 19
            int r41 = r41 >>> 19
            r41 = r42 | r41
            r35 = r35 ^ r41
            int r41 = r35 + r30
            r41 = r41 | 0
            int r42 = r41 << 18
            r19 = 14
            int r41 = r41 >>> 14
            r41 = r42 | r41
            r36 = r36 ^ r41
            int r41 = r40 + r39
            r41 = r41 | 0
            int r42 = r41 << 7
            int r41 = r41 >>> 25
            r41 = r42 | r41
            r34 = r34 ^ r41
            int r41 = r34 + r40
            r41 = r41 | 0
            int r42 = r41 << 9
            r25 = 23
            int r41 = r41 >>> 23
            r41 = r42 | r41
            r38 = r38 ^ r41
            int r41 = r38 + r34
            r41 = r41 | 0
            int r42 = r41 << 13
            r23 = 19
            int r41 = r41 >>> 19
            r41 = r42 | r41
            r39 = r39 ^ r41
            int r41 = r39 + r38
            r41 = r41 | 0
            int r42 = r41 << 18
            r19 = 14
            int r41 = r41 >>> 14
            r41 = r42 | r41
            r41 = r40 ^ r41
            int r13 = r13 + 2
            r40 = r39
            r39 = r38
            r38 = r34
            r34 = r30
            r30 = r8
            goto L_0x01f1
        L_0x03b5:
            r20 = 0
            int r15 = r15 + r1
            r1 = r15 | 0
            int r27 = r27 + r7
            r7 = r27 | 0
            int r28 = r28 + r10
            r8 = r28 | 0
            int r29 = r29 + r5
            r5 = r29 | 0
            int r30 = r30 + r3
            r3 = r30 | 0
            int r31 = r31 + r14
            r10 = r31 | 0
            int r32 = r32 + r0
            r0 = r32 | 0
            int r33 = r33 + r2
            r2 = r33 | 0
            int r34 = r34 + r12
            r12 = r34 | 0
            int r35 = r35 + r11
            r11 = r35 | 0
            int r36 = r36 + r9
            r9 = r36 | 0
            int r37 = r37 + r4
            r4 = r37 | 0
            int r38 = r38 + r6
            r6 = r38 | 0
            int r39 = r39 + r26
            r13 = r39 | 0
            int r40 = r40 + r45
            r14 = r40 | 0
            int r41 = r41 + r46
            r15 = r41 | 0
            r45 = r15
            int r15 = r1 >>> 0
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = (byte) r15
            r43[r20] = r15
            int r15 = r1 >>> 8
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = (byte) r15
            r20 = 1
            r43[r20] = r15
            int r15 = r1 >>> 16
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = (byte) r15
            r18 = 2
            r43[r18] = r15
            r15 = 24
            int r1 = r1 >>> r15
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r15 = 3
            r43[r15] = r1
            int r1 = r7 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r15 = 4
            r43[r15] = r1
            int r1 = r7 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r15 = 5
            r43[r15] = r1
            int r1 = r7 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r15 = 6
            r43[r15] = r1
            r1 = 24
            int r7 = r7 >>> r1
            r1 = r7 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r7 = 7
            r43[r7] = r1
            int r1 = r8 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r7 = 8
            r43[r7] = r1
            int r1 = r8 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r7 = 9
            r43[r7] = r1
            int r1 = r8 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r7 = 10
            r43[r7] = r1
            r1 = 24
            int r7 = r8 >>> 24
            r1 = r7 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r7 = 11
            r43[r7] = r1
            int r1 = r5 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r7 = 12
            r43[r7] = r1
            int r1 = r5 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r43[r17] = r1
            int r1 = r5 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r7 = 14
            r43[r7] = r1
            r1 = 24
            int r5 = r5 >>> r1
            r1 = r5 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r5 = 15
            r43[r5] = r1
            int r1 = r3 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r5 = 16
            r43[r5] = r1
            int r1 = r3 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r5 = 17
            r43[r5] = r1
            int r1 = r3 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r5 = 18
            r43[r5] = r1
            r1 = 24
            int r3 = r3 >>> r1
            r1 = r3 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r3 = 19
            r43[r3] = r1
            int r1 = r10 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r3 = 20
            r43[r3] = r1
            int r1 = r10 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r3 = 21
            r43[r3] = r1
            int r1 = r10 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r3 = 22
            r43[r3] = r1
            r1 = 24
            int r3 = r10 >>> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r5 = 23
            r43[r5] = r3
            int r3 = r0 >>> 0
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r43[r1] = r3
            int r1 = r0 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r43[r24] = r1
            int r1 = r0 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r3 = 26
            r43[r3] = r1
            r1 = 24
            int r0 = r0 >>> r1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 27
            r43[r1] = r0
            int r0 = r2 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 28
            r43[r1] = r0
            int r0 = r2 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 29
            r43[r1] = r0
            int r0 = r2 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 30
            r43[r1] = r0
            r0 = 24
            int r1 = r2 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 31
            r43[r1] = r0
            int r0 = r12 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 32
            r43[r1] = r0
            int r0 = r12 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 33
            r43[r1] = r0
            int r0 = r12 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 34
            r43[r1] = r0
            r0 = 24
            int r1 = r12 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 35
            r43[r1] = r0
            int r0 = r11 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 36
            r43[r1] = r0
            int r0 = r11 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 37
            r43[r1] = r0
            int r0 = r11 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 38
            r43[r1] = r0
            r0 = 24
            int r1 = r11 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 39
            r43[r1] = r0
            int r0 = r9 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 40
            r43[r1] = r0
            int r0 = r9 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 41
            r43[r1] = r0
            int r0 = r9 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 42
            r43[r1] = r0
            r0 = 24
            int r1 = r9 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 43
            r43[r1] = r0
            int r0 = r4 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 44
            r43[r1] = r0
            int r0 = r4 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 45
            r43[r1] = r0
            int r0 = r4 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 46
            r43[r1] = r0
            r0 = 24
            int r1 = r4 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 47
            r43[r1] = r0
            int r0 = r6 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 48
            r43[r1] = r0
            int r0 = r6 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 49
            r43[r1] = r0
            int r0 = r6 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 50
            r43[r1] = r0
            r0 = 24
            int r1 = r6 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 51
            r43[r1] = r0
            int r0 = r13 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 52
            r43[r1] = r0
            int r0 = r13 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 53
            r43[r1] = r0
            int r0 = r13 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 54
            r43[r1] = r0
            r0 = 24
            int r1 = r13 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 55
            r43[r1] = r0
            int r0 = r14 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 56
            r43[r1] = r0
            int r0 = r14 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 57
            r43[r1] = r0
            int r0 = r14 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 58
            r43[r1] = r0
            r0 = 24
            int r1 = r14 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 59
            r43[r1] = r0
            int r0 = r45 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 60
            r43[r1] = r0
            int r0 = r45 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 61
            r43[r1] = r0
            int r0 = r45 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 62
            r43[r1] = r0
            r0 = 24
            int r0 = r45 >>> 24
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 63
            r43[r1] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.TweetNaclFast.core_salsa20(byte[], byte[], byte[], byte[]):void");
    }

    /* JADX WARNING: type inference failed for: r29v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r30v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r31v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r1v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r5v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r7v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r7v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v6, types: [byte] */
    /* JADX WARNING: type inference failed for: r10v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r12v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v0, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r5v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v6, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v5, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v10, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v15, types: [byte] */
    /* JADX WARNING: type inference failed for: r14v18, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v8, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v11, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v14, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v17, types: [byte] */
    /* JADX WARNING: type inference failed for: r0v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r2v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v20, types: [byte] */
    /* JADX WARNING: type inference failed for: r2v7, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v21, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v24, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v27, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v30, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r12v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v33, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v34, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v35, types: [byte] */
    /* JADX WARNING: type inference failed for: r11v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v15, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v18, types: [byte] */
    /* JADX WARNING: type inference failed for: r9v10, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v40, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v41, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v26, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v43, types: [byte] */
    /* JADX WARNING: type inference failed for: r4v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v47, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v51, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v30, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v54, types: [byte] */
    /* JADX WARNING: type inference failed for: r6v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r13v35, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v58, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v62, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v66, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v70, types: [byte] */
    /* JADX WARNING: type inference failed for: r8v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v73, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v77, types: [byte] */
    /* JADX WARNING: type inference failed for: r0v7, types: [byte] */
    /* JADX WARNING: type inference failed for: r15v81, types: [byte] */
    /* JADX WARNING: type inference failed for: r1v5, types: [byte] */
    /* JADX WARNING: type inference failed for: r1v9, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void core_hsalsa20(byte[] r28, byte[] r29, byte[] r30, byte[] r31) {
        /*
            r0 = 0
            byte r1 = r31[r0]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 1
            byte r3 = r31[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 8
            int r3 = r3 << r4
            r1 = r1 | r3
            r3 = 2
            byte r5 = r31[r3]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = 16
            int r5 = r5 << r6
            r1 = r1 | r5
            r5 = 3
            byte r7 = r31[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            r8 = 24
            int r7 = r7 << r8
            r1 = r1 | r7
            byte r7 = r30[r0]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r9 = r30[r2]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r4
            r7 = r7 | r9
            byte r9 = r30[r3]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r6
            r7 = r7 | r9
            byte r9 = r30[r5]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r8
            r7 = r7 | r9
            r9 = 4
            byte r10 = r30[r9]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r11 = 5
            byte r12 = r30[r11]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r4
            r10 = r10 | r12
            r12 = 6
            byte r13 = r30[r12]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r6
            r10 = r10 | r13
            r13 = 7
            byte r14 = r30[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r8
            r10 = r10 | r14
            byte r14 = r30[r4]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r15 = 9
            byte r5 = r30[r15]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << r4
            r5 = r5 | r14
            r14 = 10
            byte r15 = r30[r14]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r5 = r5 | r15
            r15 = 11
            byte r14 = r30[r15]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r8
            r5 = r5 | r14
            r14 = 12
            byte r15 = r30[r14]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r17 = 13
            byte r14 = r30[r17]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r4
            r14 = r14 | r15
            r15 = 14
            byte r3 = r30[r15]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r6
            r3 = r3 | r14
            r14 = 15
            byte r14 = r30[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << r8
            r3 = r3 | r14
            byte r14 = r31[r9]
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte r15 = r31[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r14 = r14 | r15
            byte r15 = r31[r12]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r14 = r14 | r15
            byte r15 = r31[r13]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r14 = r14 | r15
            byte r15 = r29[r0]
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r0 = r29[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r0 = r0 << r4
            r0 = r0 | r15
            r15 = 2
            byte r2 = r29[r15]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r0 = r0 | r2
            r2 = 3
            byte r15 = r29[r2]
            r2 = r15 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r8
            r0 = r0 | r2
            byte r2 = r29[r9]
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r15 = r29[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r2 = r2 | r15
            byte r15 = r29[r12]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r2 = r2 | r15
            byte r15 = r29[r13]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r2 = r2 | r15
            byte r15 = r29[r4]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r16 = 9
            byte r13 = r29[r16]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r4
            r13 = r13 | r15
            r15 = 10
            byte r12 = r29[r15]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r6
            r12 = r12 | r13
            r13 = 11
            byte r15 = r29[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r8
            r12 = r12 | r13
            r13 = 12
            byte r15 = r29[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            byte r15 = r29[r17]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r13 = r13 | r15
            r15 = 14
            byte r11 = r29[r15]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << r6
            r11 = r11 | r13
            r13 = 15
            byte r13 = r29[r13]
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r8
            r11 = r11 | r13
            byte r13 = r31[r4]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r15 = 9
            byte r9 = r31[r15]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r9 = r9 << r4
            r9 = r9 | r13
            r13 = 10
            byte r15 = r31[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r6
            r9 = r9 | r13
            r13 = 11
            byte r15 = r31[r13]
            r13 = r15 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r8
            r9 = r9 | r13
            byte r13 = r30[r6]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r15 = 17
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r4
            r13 = r13 | r15
            r15 = 18
            byte r4 = r30[r15]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r6
            r4 = r4 | r13
            r13 = 19
            byte r15 = r30[r13]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r4 = r4 | r15
            r15 = 20
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r21 = 21
            byte r13 = r30[r21]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r20 = 8
            int r13 = r13 << 8
            r13 = r13 | r15
            r15 = 22
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r6
            r13 = r13 | r15
            r15 = 23
            byte r6 = r30[r15]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r8
            r6 = r6 | r13
            byte r13 = r30[r8]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r23 = 25
            byte r15 = r30[r23]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r20 = 8
            int r15 = r15 << 8
            r13 = r13 | r15
            r15 = 26
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r21 = 16
            int r15 = r15 << 16
            r13 = r13 | r15
            r15 = 27
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << r8
            r13 = r13 | r15
            r15 = 28
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r25 = 29
            byte r8 = r30[r25]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r20 = 8
            int r8 = r8 << 8
            r8 = r8 | r15
            r15 = 30
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r21 = 16
            int r15 = r15 << 16
            r8 = r8 | r15
            r15 = 31
            byte r15 = r30[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r25 = 24
            int r15 = r15 << 24
            r8 = r8 | r15
            r25 = r0
            r15 = 12
            byte r0 = r31[r15]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r15 = r31[r17]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r20 = 8
            int r15 = r15 << 8
            r0 = r0 | r15
            r26 = r1
            r15 = 14
            byte r1 = r31[r15]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r15 = 16
            int r1 = r1 << r15
            r0 = r0 | r1
            r1 = 15
            byte r1 = r31[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r15 = 24
            int r1 = r1 << r15
            r0 = r0 | r1
            r30 = r2
            r1 = r26
            r15 = 0
        L_0x01d4:
            r2 = 20
            if (r15 >= r2) goto L_0x038c
            int r2 = r1 + r6
            r19 = 0
            r2 = r2 | 0
            int r26 = r2 << 7
            int r2 = r2 >>> 25
            r2 = r26 | r2
            r2 = r2 ^ r3
            int r3 = r2 + r1
            r3 = r3 | 0
            int r26 = r3 << 9
            r24 = 23
            int r3 = r3 >>> 23
            r3 = r26 | r3
            r3 = r3 ^ r12
            int r12 = r3 + r2
            r12 = r12 | 0
            int r26 = r12 << 13
            r22 = 19
            int r12 = r12 >>> 19
            r12 = r26 | r12
            r6 = r6 ^ r12
            int r12 = r6 + r3
            r12 = r12 | 0
            int r26 = r12 << 18
            r18 = 14
            int r12 = r12 >>> 14
            r12 = r26 | r12
            r1 = r1 ^ r12
            int r12 = r14 + r7
            r12 = r12 | 0
            int r26 = r12 << 7
            int r12 = r12 >>> 25
            r12 = r26 | r12
            r11 = r11 ^ r12
            int r12 = r11 + r14
            r12 = r12 | 0
            int r26 = r12 << 9
            r24 = 23
            int r12 = r12 >>> 23
            r12 = r26 | r12
            r12 = r12 ^ r13
            int r13 = r12 + r11
            r13 = r13 | 0
            int r26 = r13 << 13
            r22 = 19
            int r13 = r13 >>> 19
            r13 = r26 | r13
            r7 = r7 ^ r13
            int r13 = r7 + r12
            r13 = r13 | 0
            int r26 = r13 << 18
            r18 = 14
            int r13 = r13 >>> 14
            r13 = r26 | r13
            r13 = r13 ^ r14
            int r14 = r9 + r25
            r14 = r14 | 0
            int r26 = r14 << 7
            int r14 = r14 >>> 25
            r14 = r26 | r14
            r8 = r8 ^ r14
            int r14 = r8 + r9
            r14 = r14 | 0
            int r26 = r14 << 9
            r24 = 23
            int r14 = r14 >>> 23
            r14 = r26 | r14
            r10 = r10 ^ r14
            int r14 = r10 + r8
            r14 = r14 | 0
            int r26 = r14 << 13
            r22 = 19
            int r14 = r14 >>> 19
            r14 = r26 | r14
            r14 = r25 ^ r14
            int r25 = r14 + r10
            r25 = r25 | 0
            int r26 = r25 << 18
            r18 = 14
            int r25 = r25 >>> 14
            r25 = r26 | r25
            r9 = r9 ^ r25
            int r25 = r0 + r4
            r25 = r25 | 0
            int r26 = r25 << 7
            int r25 = r25 >>> 25
            r25 = r26 | r25
            r5 = r5 ^ r25
            int r25 = r5 + r0
            r25 = r25 | 0
            int r26 = r25 << 9
            r24 = 23
            int r25 = r25 >>> 23
            r25 = r26 | r25
            r25 = r30 ^ r25
            int r26 = r25 + r5
            r26 = r26 | 0
            int r27 = r26 << 13
            r22 = 19
            int r26 = r26 >>> 19
            r26 = r27 | r26
            r4 = r4 ^ r26
            int r26 = r4 + r25
            r26 = r26 | 0
            int r27 = r26 << 18
            r18 = 14
            int r26 = r26 >>> 14
            r26 = r27 | r26
            r0 = r0 ^ r26
            int r26 = r1 + r5
            r26 = r26 | 0
            int r27 = r26 << 7
            int r26 = r26 >>> 25
            r26 = r27 | r26
            r7 = r7 ^ r26
            int r26 = r7 + r1
            r26 = r26 | 0
            int r27 = r26 << 9
            r24 = 23
            int r26 = r26 >>> 23
            r26 = r27 | r26
            r10 = r10 ^ r26
            int r26 = r10 + r7
            r26 = r26 | 0
            int r27 = r26 << 13
            r22 = 19
            int r26 = r26 >>> 19
            r26 = r27 | r26
            r5 = r5 ^ r26
            int r26 = r5 + r10
            r26 = r26 | 0
            int r27 = r26 << 18
            r18 = 14
            int r26 = r26 >>> 14
            r26 = r27 | r26
            r1 = r1 ^ r26
            int r26 = r13 + r2
            r26 = r26 | 0
            int r27 = r26 << 7
            int r26 = r26 >>> 25
            r26 = r27 | r26
            r14 = r14 ^ r26
            int r26 = r14 + r13
            r26 = r26 | 0
            int r27 = r26 << 9
            r24 = 23
            int r26 = r26 >>> 23
            r26 = r27 | r26
            r25 = r25 ^ r26
            int r26 = r25 + r14
            r26 = r26 | 0
            int r27 = r26 << 13
            r22 = 19
            int r26 = r26 >>> 19
            r26 = r27 | r26
            r2 = r2 ^ r26
            int r26 = r2 + r25
            r26 = r26 | 0
            int r27 = r26 << 18
            r18 = 14
            int r26 = r26 >>> 14
            r26 = r27 | r26
            r13 = r13 ^ r26
            int r26 = r9 + r11
            r26 = r26 | 0
            int r27 = r26 << 7
            int r26 = r26 >>> 25
            r26 = r27 | r26
            r4 = r4 ^ r26
            int r26 = r4 + r9
            r26 = r26 | 0
            int r27 = r26 << 9
            r24 = 23
            int r26 = r26 >>> 23
            r26 = r27 | r26
            r3 = r3 ^ r26
            int r26 = r3 + r4
            r26 = r26 | 0
            int r27 = r26 << 13
            r22 = 19
            int r26 = r26 >>> 19
            r26 = r27 | r26
            r11 = r11 ^ r26
            int r26 = r11 + r3
            r26 = r26 | 0
            int r27 = r26 << 18
            r18 = 14
            int r26 = r26 >>> 14
            r26 = r27 | r26
            r9 = r9 ^ r26
            int r26 = r0 + r8
            r26 = r26 | 0
            int r27 = r26 << 7
            int r26 = r26 >>> 25
            r26 = r27 | r26
            r6 = r6 ^ r26
            int r26 = r6 + r0
            r26 = r26 | 0
            int r27 = r26 << 9
            r24 = 23
            int r26 = r26 >>> 23
            r26 = r27 | r26
            r12 = r12 ^ r26
            int r26 = r12 + r6
            r26 = r26 | 0
            int r27 = r26 << 13
            r22 = 19
            int r26 = r26 >>> 19
            r26 = r27 | r26
            r8 = r8 ^ r26
            int r26 = r8 + r12
            r26 = r26 | 0
            int r27 = r26 << 18
            r18 = 14
            int r26 = r26 >>> 14
            r26 = r27 | r26
            r0 = r0 ^ r26
            int r15 = r15 + 2
            r30 = r25
            r25 = r14
            r14 = r13
            r13 = r12
            r12 = r3
            r3 = r2
            goto L_0x01d4
        L_0x038c:
            int r2 = r1 >>> 0
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r3 = 0
            r28[r3] = r2
            int r2 = r1 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r3 = 1
            r28[r3] = r2
            int r2 = r1 >>> 16
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r3 = 2
            r28[r3] = r2
            r2 = 24
            int r1 = r1 >>> r2
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 3
            r28[r2] = r1
            int r1 = r14 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 4
            r28[r2] = r1
            int r1 = r14 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 5
            r28[r2] = r1
            int r1 = r14 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 6
            r28[r2] = r1
            r1 = 24
            int r2 = r14 >>> 24
            r1 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 7
            r28[r2] = r1
            int r1 = r9 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 8
            r28[r2] = r1
            int r1 = r9 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 9
            r28[r2] = r1
            int r1 = r9 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 10
            r28[r2] = r1
            r1 = 24
            int r2 = r9 >>> 24
            r1 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 11
            r28[r2] = r1
            int r1 = r0 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 12
            r28[r2] = r1
            int r1 = r0 >>> 8
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r28[r17] = r1
            int r1 = r0 >>> 16
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 14
            r28[r2] = r1
            r1 = 24
            int r0 = r0 >>> r1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 15
            r28[r1] = r0
            int r0 = r25 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 16
            r28[r1] = r0
            int r0 = r25 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 17
            r28[r1] = r0
            int r0 = r25 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 18
            r28[r1] = r0
            r0 = 24
            int r1 = r25 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 19
            r28[r1] = r0
            int r0 = r30 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 20
            r28[r1] = r0
            int r0 = r30 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 21
            r28[r1] = r0
            int r0 = r30 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 22
            r28[r1] = r0
            r0 = 24
            int r1 = r30 >>> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r2 = 23
            r28[r2] = r1
            int r1 = r12 >>> 0
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = (byte) r1
            r28[r0] = r1
            int r0 = r12 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r28[r23] = r0
            int r0 = r12 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 26
            r28[r1] = r0
            r0 = 24
            int r1 = r12 >>> 24
            r0 = r1 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 27
            r28[r1] = r0
            int r0 = r11 >>> 0
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 28
            r28[r1] = r0
            int r0 = r11 >>> 8
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 29
            r28[r1] = r0
            int r0 = r11 >>> 16
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 30
            r28[r1] = r0
            r0 = 24
            int r0 = r11 >>> 24
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r1 = 31
            r28[r1] = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.TweetNaclFast.core_hsalsa20(byte[], byte[], byte[], byte[]):void");
    }

    public static int crypto_core_salsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        core_salsa20(bArr, bArr2, bArr3, bArr4);
        return 0;
    }

    public static int crypto_core_hsalsa20(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        core_hsalsa20(bArr, bArr2, bArr3, bArr4);
        return 0;
    }

    private static int crypto_stream_salsa20_xor(byte[] bArr, int i, byte[] bArr2, int i2, long j, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = bArr4;
        byte[] bArr6 = new byte[16];
        byte[] bArr7 = new byte[64];
        for (int i3 = 0; i3 < 16; i3++) {
            bArr6[i3] = 0;
        }
        for (int i4 = 0; i4 < 8; i4++) {
            bArr6[i4] = bArr3[i4];
        }
        int i5 = i;
        int i6 = i2;
        long j2 = j;
        while (j2 >= 64) {
            crypto_core_salsa20(bArr7, bArr6, bArr5, sigma);
            for (int i7 = 0; i7 < 64; i7++) {
                bArr[i5 + i7] = (byte) ((bArr2[i6 + i7] ^ bArr7[i7]) & 255);
            }
            int i8 = 1;
            for (int i9 = 8; i9 < 16; i9++) {
                int i10 = (i8 + (bArr6[i9] & 255)) | 0;
                bArr6[i9] = (byte) (i10 & 255);
                i8 = i10 >>> 8;
            }
            j2 -= 64;
            i5 += 64;
            i6 += 64;
        }
        if (j2 > 0) {
            crypto_core_salsa20(bArr7, bArr6, bArr5, sigma);
            for (int i11 = 0; ((long) i11) < j2; i11++) {
                bArr[i5 + i11] = (byte) ((bArr2[i6 + i11] ^ bArr7[i11]) & 255);
            }
        }
        return 0;
    }

    public static int crypto_stream_salsa20(byte[] bArr, int i, long j, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[64];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr4[i2] = 0;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            bArr4[i3] = bArr2[i3];
        }
        while (j >= 64) {
            crypto_core_salsa20(bArr5, bArr4, bArr3, sigma);
            for (int i4 = 0; i4 < 64; i4++) {
                bArr[i + i4] = bArr5[i4];
            }
            int i5 = 1;
            for (int i6 = 8; i6 < 16; i6++) {
                int i7 = (i5 + (bArr4[i6] & 255)) | 0;
                bArr4[i6] = (byte) (i7 & 255);
                i5 = i7 >>> 8;
            }
            j -= 64;
            i += 64;
        }
        if (j > 0) {
            crypto_core_salsa20(bArr5, bArr4, bArr3, sigma);
            for (int i8 = 0; ((long) i8) < j; i8++) {
                bArr[i + i8] = bArr5[i8];
            }
        }
        return 0;
    }

    public static int crypto_stream(byte[] bArr, int i, long j, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[32];
        crypto_core_hsalsa20(bArr4, bArr2, bArr3, sigma);
        byte[] bArr5 = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr5[i2] = bArr2[i2 + 16];
        }
        return crypto_stream_salsa20(bArr, i, j, bArr5, bArr4);
    }

    public static int crypto_stream_xor(byte[] bArr, int i, byte[] bArr2, int i2, long j, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = bArr3;
        byte[] bArr6 = new byte[32];
        crypto_core_hsalsa20(bArr6, bArr5, bArr4, sigma);
        byte[] bArr7 = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr7[i3] = bArr5[i3 + 16];
        }
        return crypto_stream_salsa20_xor(bArr, i, bArr2, i2, j, bArr7, bArr6);
    }

    public static final class poly1305 {
        private byte[] buffer = new byte[16];
        private int fin;
        private int[] h;
        private int leftover;
        private int[] pad;
        private int[] r;

        public poly1305(byte[] bArr) {
            int[] iArr = new int[10];
            this.r = iArr;
            this.h = new int[10];
            int[] iArr2 = new int[8];
            this.pad = iArr2;
            this.leftover = 0;
            this.fin = 0;
            byte b = (bArr[0] & 255) | ((bArr[1] & 255) << 8);
            iArr[0] = b & 8191;
            byte b2 = (bArr[2] & 255) | ((bArr[3] & 255) << 8);
            iArr[1] = ((b >>> Ascii.CR) | (b2 << 3)) & 8191;
            byte b3 = (bArr[4] & 255) | ((bArr[5] & 255) << 8);
            iArr[2] = ((b2 >>> 10) | (b3 << 6)) & 7939;
            byte b4 = ((bArr[7] & 255) << 8) | (bArr[6] & 255);
            iArr[3] = ((b3 >>> 7) | (b4 << 9)) & 8191;
            byte b5 = ((bArr[9] & 255) << 8) | (bArr[8] & 255);
            iArr[4] = ((b4 >>> 4) | (b5 << Ascii.FF)) & 255;
            iArr[5] = (b5 >>> 1) & 8190;
            byte b6 = (bArr[10] & 255) | ((bArr[11] & 255) << 8);
            iArr[6] = ((b5 >>> Ascii.SO) | (b6 << 2)) & 8191;
            byte b7 = (bArr[12] & 255) | ((bArr[13] & 255) << 8);
            iArr[7] = ((b6 >>> Ascii.VT) | (b7 << 5)) & 8065;
            byte b8 = (bArr[14] & 255) | ((bArr[15] & 255) << 8);
            iArr[8] = ((b7 >>> 8) | (b8 << 8)) & 8191;
            iArr[9] = (b8 >>> 5) & 127;
            iArr2[0] = (bArr[16] & 255) | ((bArr[17] & 255) << 8);
            iArr2[1] = (bArr[18] & 255) | ((bArr[19] & 255) << 8);
            iArr2[2] = (bArr[20] & 255) | ((bArr[21] & 255) << 8);
            iArr2[3] = (bArr[22] & 255) | ((bArr[23] & 255) << 8);
            iArr2[4] = (bArr[24] & 255) | ((bArr[25] & 255) << 8);
            iArr2[5] = (bArr[26] & 255) | ((bArr[27] & 255) << 8);
            iArr2[6] = (bArr[28] & 255) | ((bArr[29] & 255) << 8);
            iArr2[7] = (bArr[30] & 255) | ((bArr[31] & 255) << 8);
        }

        public poly1305 blocks(byte[] bArr, int i, int i2) {
            int i3 = 0;
            int i4 = this.fin != 0 ? 0 : 2048;
            int[] iArr = this.h;
            int i5 = iArr[0];
            int i6 = iArr[1];
            int i7 = iArr[2];
            int i8 = iArr[3];
            byte b = 4;
            int i9 = iArr[4];
            int i10 = iArr[5];
            int i11 = iArr[6];
            int i12 = iArr[7];
            int i13 = iArr[8];
            int i14 = iArr[9];
            int[] iArr2 = this.r;
            int i15 = iArr2[0];
            int i16 = iArr2[1];
            int i17 = iArr2[2];
            int i18 = iArr2[3];
            int i19 = iArr2[4];
            int i20 = iArr2[5];
            int i21 = iArr2[6];
            int i22 = iArr2[7];
            int i23 = iArr2[8];
            int i24 = iArr2[9];
            int i25 = i12;
            int i26 = i13;
            int i27 = i10;
            int i28 = i11;
            int i29 = i8;
            int i30 = i9;
            int i31 = i6;
            int i32 = i7;
            int i33 = i14;
            int i34 = i5;
            int i35 = i;
            int i36 = i2;
            while (i36 >= 16) {
                byte b2 = ((bArr[i35 + 1] & 255) << 8) | (bArr[i35 + 0] & 255);
                int i37 = i34 + (b2 & 8191);
                byte b3 = (bArr[i35 + 2] & 255) | ((bArr[i35 + 3] & 255) << 8);
                int i38 = i31 + (((b2 >>> Ascii.CR) | (b3 << 3)) & 8191);
                byte b4 = (bArr[i35 + 4] & 255) | ((bArr[i35 + 5] & 255) << 8);
                int i39 = i32 + (((b3 >>> 10) | (b4 << 6)) & 8191);
                byte b5 = (bArr[i35 + 6] & 255) | ((bArr[i35 + 7] & 255) << 8);
                int i40 = i29 + (((b4 >>> 7) | (b5 << 9)) & 8191);
                byte b6 = (bArr[i35 + 8] & 255) | ((bArr[i35 + 9] & 255) << 8);
                int i41 = i30 + (((b5 >>> b) | (b6 << Ascii.FF)) & 8191);
                int i42 = i27 + ((b6 >>> 1) & 8191);
                byte b7 = (bArr[i35 + 10] & 255) | ((bArr[i35 + 11] & 255) << 8);
                int i43 = i28 + (((b6 >>> Ascii.SO) | (b7 << 2)) & 8191);
                byte b8 = (bArr[i35 + 12] & 255) | ((bArr[i35 + 13] & 255) << 8);
                int i44 = i25 + (((b7 >>> Ascii.VT) | (b8 << 5)) & 8191);
                byte b9 = (bArr[i35 + 14] & 255) | ((bArr[i35 + 15] & 255) << 8);
                int i45 = i26 + (((b8 >>> 8) | (b9 << 8)) & 8191);
                int i46 = i33 + ((b9 >>> 5) | i4);
                int i47 = i24 * 5;
                int i48 = i23 * 5;
                int i49 = i22 * 5;
                int i50 = i21 * 5;
                int i51 = (i37 * i15) + i3 + (i38 * i47) + (i39 * i48) + (i40 * i49) + (i41 * i50);
                int i52 = i51 >>> 13;
                int i53 = i20 * 5;
                int i54 = i19 * 5;
                int i55 = i18 * 5;
                int i56 = i17 * 5;
                int i57 = (i51 & 8191) + (i42 * i53) + (i43 * i54) + (i44 * i55) + (i45 * i56) + (i16 * 5 * i46);
                int i58 = i52 + (i57 >>> 13) + (i37 * i16) + (i38 * i15) + (i39 * i47) + (i40 * i48) + (i41 * i49);
                int i59 = i58 >>> 13;
                int i60 = (i58 & 8191) + (i42 * i50) + (i43 * i53) + (i44 * i54) + (i45 * i55) + (i56 * i46);
                int i61 = i59 + (i60 >>> 13) + (i37 * i17) + (i38 * i16) + (i39 * i15) + (i40 * i47) + (i41 * i48);
                int i62 = i61 >>> 13;
                int i63 = (i61 & 8191) + (i42 * i49) + (i43 * i50) + (i44 * i53) + (i45 * i54) + (i55 * i46);
                int i64 = i62 + (i63 >>> 13) + (i37 * i18) + (i38 * i17) + (i39 * i16) + (i40 * i15) + (i41 * i47);
                int i65 = i64 >>> 13;
                int i66 = (i64 & 8191) + (i42 * i48) + (i43 * i49) + (i44 * i50) + (i45 * i53) + (i54 * i46);
                int i67 = i4;
                int i68 = i65 + (i66 >>> 13) + (i37 * i19) + (i38 * i18) + (i39 * i17) + (i40 * i16) + (i41 * i15);
                int i69 = i68 >>> 13;
                int i70 = (i68 & 8191) + (i42 * i47) + (i43 * i48) + (i44 * i49) + (i45 * i50) + (i53 * i46);
                int i71 = i70 & 8191;
                int i72 = i69 + (i70 >>> 13) + (i37 * i20) + (i38 * i19) + (i39 * i18) + (i40 * i17) + (i41 * i16);
                int i73 = i72 >>> 13;
                int i74 = (i72 & 8191) + (i42 * i15) + (i43 * i47) + (i44 * i48) + (i45 * i49) + (i50 * i46);
                boolean z = i74 & true;
                int i75 = i73 + (i74 >>> 13) + (i37 * i21) + (i38 * i20) + (i39 * i19) + (i40 * i18) + (i41 * i17);
                int i76 = i75 >>> 13;
                int i77 = (i75 & 8191) + (i42 * i16) + (i43 * i15) + (i44 * i47) + (i45 * i48) + (i49 * i46);
                int i78 = i77 & 8191;
                int i79 = i76 + (i77 >>> 13) + (i37 * i22) + (i38 * i21) + (i39 * i20) + (i40 * i19) + (i41 * i18);
                int i80 = i79 >>> 13;
                int i81 = (i79 & 8191) + (i42 * i17) + (i43 * i16) + (i44 * i15) + (i45 * i47) + (i48 * i46);
                int i82 = i80 + (i81 >>> 13) + (i37 * i23) + (i38 * i22) + (i39 * i21) + (i40 * i20) + (i41 * i19);
                int i83 = i82 >>> 13;
                int i84 = (i82 & 8191) + (i42 * i18) + (i43 * i17) + (i44 * i16) + (i45 * i15) + (i47 * i46);
                int i85 = i84 & 8191;
                int i86 = i83 + (i84 >>> 13) + (i37 * i24) + (i38 * i23) + (i39 * i22) + (i40 * i21) + (i41 * i20);
                int i87 = i86 >>> 13;
                int i88 = (i86 & 8191) + (i42 * i19) + (i43 * i18) + (i44 * i17) + (i45 * i16) + (i46 * i15);
                int i89 = i87 + (i88 >>> 13);
                i33 = i88 & 8191;
                int i90 = ((((i89 << 2) + i89) | 0) + (i57 & 8191)) | 0;
                i34 = i90 & 8191;
                i31 = (i60 & 8191) + (i90 >>> 13);
                i35 += 16;
                i36 -= 16;
                i25 = i81 & 8191;
                i29 = i66 & 8191;
                i26 = i85;
                i32 = i63 & 8191;
                i28 = i78;
                i27 = z;
                i30 = i71;
                i4 = i67;
                i3 = 0;
                b = 4;
            }
            int[] iArr3 = this.h;
            iArr3[0] = i34;
            iArr3[1] = i31;
            iArr3[2] = i32;
            iArr3[3] = i29;
            iArr3[4] = i30;
            iArr3[5] = i27;
            iArr3[6] = i28;
            iArr3[7] = i25;
            iArr3[8] = i26;
            iArr3[9] = i33;
            return this;
        }

        public poly1305 finish(byte[] bArr, int i) {
            int[] iArr = new int[10];
            int i2 = this.leftover;
            if (i2 != 0) {
                this.buffer[i2] = 1;
                for (int i3 = i2 + 1; i3 < 16; i3++) {
                    this.buffer[i3] = 0;
                }
                this.fin = 1;
                blocks(this.buffer, 0, 16);
            }
            int[] iArr2 = this.h;
            int i4 = iArr2[1];
            int i5 = i4 >>> 13;
            iArr2[1] = i4 & 8191;
            for (int i6 = 2; i6 < 10; i6++) {
                int[] iArr3 = this.h;
                int i7 = iArr3[i6] + i5;
                iArr3[i6] = i7;
                i5 = i7 >>> 13;
                iArr3[i6] = i7 & 8191;
            }
            int[] iArr4 = this.h;
            int i8 = iArr4[0] + (i5 * 5);
            iArr4[0] = i8;
            int i9 = i8 >>> 13;
            int i10 = i8 & 8191;
            iArr4[0] = i10;
            int i11 = iArr4[1] + i9;
            iArr4[1] = i11;
            iArr4[1] = i11 & 8191;
            iArr4[2] = iArr4[2] + (i11 >>> 13);
            int i12 = i10 + 5;
            iArr[0] = i12;
            int i13 = i12 >>> 13;
            iArr[0] = i12 & 8191;
            for (int i14 = 1; i14 < 10; i14++) {
                int i15 = this.h[i14] + i13;
                iArr[i14] = i15;
                i13 = i15 >>> 13;
                iArr[i14] = i15 & 8191;
            }
            int i16 = iArr[9] - 8192;
            iArr[9] = i16;
            iArr[9] = i16 & 65535;
            int i17 = ((i13 ^ 1) - 1) & 65535;
            for (int i18 = 0; i18 < 10; i18++) {
                iArr[i18] = iArr[i18] & i17;
            }
            int i19 = i17 ^ -1;
            for (int i20 = 0; i20 < 10; i20++) {
                int[] iArr5 = this.h;
                iArr5[i20] = (iArr5[i20] & i19) | iArr[i20];
            }
            int[] iArr6 = this.h;
            int i21 = iArr6[0];
            int i22 = iArr6[1];
            int i23 = (i21 | (i22 << 13)) & 65535;
            iArr6[0] = i23;
            int i24 = iArr6[2];
            iArr6[1] = ((i22 >>> 3) | (i24 << 10)) & 65535;
            int i25 = iArr6[3];
            iArr6[2] = ((i24 >>> 6) | (i25 << 7)) & 65535;
            int i26 = iArr6[4];
            iArr6[3] = ((i25 >>> 9) | (i26 << 4)) & 65535;
            int i27 = (i26 >>> 12) | (iArr6[5] << 1);
            int i28 = iArr6[6];
            iArr6[4] = (i27 | (i28 << 14)) & 65535;
            int i29 = iArr6[7];
            iArr6[5] = ((i28 >>> 2) | (i29 << 11)) & 65535;
            int i30 = iArr6[8];
            iArr6[6] = ((i29 >>> 5) | (i30 << 8)) & 65535;
            iArr6[7] = ((iArr6[9] << 5) | (i30 >>> 8)) & 65535;
            int i31 = i23 + this.pad[0];
            iArr6[0] = i31 & 65535;
            for (int i32 = 1; i32 < 8; i32++) {
                int[] iArr7 = this.h;
                i31 = (((iArr7[i32] + this.pad[i32]) | 0) + (i31 >>> 16)) | 0;
                iArr7[i32] = i31 & 65535;
            }
            int[] iArr8 = this.h;
            int i33 = iArr8[0];
            bArr[i + 0] = (byte) ((i33 >>> 0) & 255);
            bArr[i + 1] = (byte) ((i33 >>> 8) & 255);
            int i34 = iArr8[1];
            bArr[i + 2] = (byte) ((i34 >>> 0) & 255);
            bArr[i + 3] = (byte) ((i34 >>> 8) & 255);
            int i35 = iArr8[2];
            bArr[i + 4] = (byte) ((i35 >>> 0) & 255);
            bArr[i + 5] = (byte) ((i35 >>> 8) & 255);
            int i36 = iArr8[3];
            bArr[i + 6] = (byte) ((i36 >>> 0) & 255);
            bArr[i + 7] = (byte) ((i36 >>> 8) & 255);
            int i37 = iArr8[4];
            bArr[i + 8] = (byte) ((i37 >>> 0) & 255);
            bArr[i + 9] = (byte) ((i37 >>> 8) & 255);
            int i38 = iArr8[5];
            bArr[i + 10] = (byte) ((i38 >>> 0) & 255);
            bArr[i + 11] = (byte) ((i38 >>> 8) & 255);
            int i39 = iArr8[6];
            bArr[i + 12] = (byte) ((i39 >>> 0) & 255);
            bArr[i + 13] = (byte) ((i39 >>> 8) & 255);
            int i40 = iArr8[7];
            bArr[i + 14] = (byte) ((i40 >>> 0) & 255);
            bArr[i + 15] = (byte) ((i40 >>> 8) & 255);
            return this;
        }

        public poly1305 update(byte[] bArr, int i, int i2) {
            int i3 = this.leftover;
            if (i3 != 0) {
                int i4 = 16 - i3;
                if (i4 > i2) {
                    i4 = i2;
                }
                for (int i5 = 0; i5 < i4; i5++) {
                    this.buffer[this.leftover + i5] = bArr[i + i5];
                }
                i2 -= i4;
                i += i4;
                int i6 = this.leftover + i4;
                this.leftover = i6;
                if (i6 < 16) {
                    return this;
                }
                blocks(this.buffer, 0, 16);
                this.leftover = 0;
            }
            if (i2 >= 16) {
                int i7 = i2 - (i2 % 16);
                blocks(bArr, i, i7);
                i += i7;
                i2 -= i7;
            }
            if (i2 != 0) {
                for (int i8 = 0; i8 < i2; i8++) {
                    this.buffer[this.leftover + i8] = bArr[i + i8];
                }
                this.leftover += i2;
            }
            return this;
        }
    }

    private static int crypto_onetimeauth(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3) {
        poly1305 poly13052 = new poly1305(bArr3);
        poly13052.update(bArr2, i2, i3);
        poly13052.finish(bArr, i);
        return 0;
    }

    public static int crypto_onetimeauth(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        return crypto_onetimeauth(bArr, 0, bArr2, 0, i, bArr3);
    }

    private static int crypto_onetimeauth_verify(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3) {
        byte[] bArr4 = new byte[16];
        crypto_onetimeauth(bArr4, 0, bArr2, i2, i3, bArr3);
        return crypto_verify_16(bArr, i, bArr4, 0);
    }

    public static int crypto_onetimeauth_verify(byte[] bArr, byte[] bArr2, int i, byte[] bArr3) {
        return crypto_onetimeauth_verify(bArr, 0, bArr2, 0, i, bArr3);
    }

    public static int crypto_onetimeauth_verify(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return crypto_onetimeauth_verify(bArr, bArr2, bArr2 != null ? bArr2.length : 0, bArr3);
    }

    public static int crypto_secretbox(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        int i2 = i;
        if (i2 < 32) {
            return -1;
        }
        crypto_stream_xor(bArr, 0, bArr2, 0, (long) i2, bArr3, bArr4);
        crypto_onetimeauth(bArr, 16, bArr, 32, i2 - 32, bArr);
        return 0;
    }

    public static int crypto_secretbox_open(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        int i2 = i;
        byte[] bArr5 = new byte[32];
        if (i2 < 32) {
            return -1;
        }
        crypto_stream(bArr5, 0, 32, bArr3, bArr4);
        if (crypto_onetimeauth_verify(bArr2, 16, bArr2, 32, i2 - 32, bArr5) != 0) {
            return -1;
        }
        crypto_stream_xor(bArr, 0, bArr2, 0, (long) i2, bArr3, bArr4);
        return 0;
    }

    private static void set25519(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 16; i++) {
            jArr[i] = jArr2[i];
        }
    }

    private static void car25519(long[] jArr) {
        long j = 1;
        for (int i = 0; i < 16; i++) {
            long j2 = jArr[i] + j + WebSocketProtocol.PAYLOAD_SHORT_MAX;
            j = j2 >> 16;
            jArr[i] = j2 - (65536 * j);
        }
        long j3 = j - 1;
        jArr[0] = jArr[0] + j3 + (37 * j3);
    }

    private static void sel25519(long[] jArr, long[] jArr2, int i) {
        sel25519(jArr, 0, jArr2, 0, i);
    }

    private static void sel25519(long[] jArr, int i, long[] jArr2, int i2, int i3) {
        long j = (long) ((i3 - 1) ^ -1);
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = i4 + i;
            long j2 = jArr[i5];
            int i6 = i4 + i2;
            long j3 = (jArr2[i6] ^ j2) & j;
            jArr[i5] = j2 ^ j3;
            jArr2[i6] = jArr2[i6] ^ j3;
        }
    }

    private static void pack25519(byte[] bArr, long[] jArr, int i) {
        long[] jArr2 = new long[16];
        long[] jArr3 = new long[16];
        for (int i2 = 0; i2 < 16; i2++) {
            jArr3[i2] = jArr[i2 + i];
        }
        car25519(jArr3);
        car25519(jArr3);
        car25519(jArr3);
        for (int i3 = 0; i3 < 2; i3++) {
            jArr2[0] = jArr3[0] - 65517;
            for (int i4 = 1; i4 < 15; i4++) {
                int i5 = i4 - 1;
                jArr2[i4] = (jArr3[i4] - WebSocketProtocol.PAYLOAD_SHORT_MAX) - (1 & (jArr2[i5] >> 16));
                jArr2[i5] = WebSocketProtocol.PAYLOAD_SHORT_MAX & jArr2[i5];
            }
            long j = jArr2[14];
            long j2 = (jArr3[15] - 32767) - ((j >> 16) & 1);
            jArr2[15] = j2;
            jArr2[14] = WebSocketProtocol.PAYLOAD_SHORT_MAX & j;
            sel25519(jArr3, 0, jArr2, 0, 1 - ((int) (1 & (j2 >> 16))));
        }
        for (int i6 = 0; i6 < 16; i6++) {
            int i7 = i6 * 2;
            long j3 = jArr3[i6];
            bArr[i7] = (byte) ((int) (255 & j3));
            bArr[i7 + 1] = (byte) ((int) (j3 >> 8));
        }
    }

    private static int neq25519(long[] jArr, long[] jArr2) {
        return neq25519(jArr, 0, jArr2, 0);
    }

    private static int neq25519(long[] jArr, int i, long[] jArr2, int i2) {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[32];
        pack25519(bArr, jArr, i);
        pack25519(bArr2, jArr2, i2);
        return crypto_verify_32(bArr, 0, bArr2, 0);
    }

    private static byte par25519(long[] jArr) {
        return par25519(jArr, 0);
    }

    private static byte par25519(long[] jArr, int i) {
        byte[] bArr = new byte[32];
        pack25519(bArr, jArr, i);
        return (byte) (bArr[0] & 1);
    }

    private static void unpack25519(long[] jArr, byte[] bArr) {
        for (int i = 0; i < 16; i++) {
            int i2 = i * 2;
            jArr[i] = ((long) (bArr[i2] & 255)) + ((long) ((bArr[i2 + 1] << 8) & 65535));
        }
        jArr[15] = jArr[15] & 32767;
    }

    private static void A(long[] jArr, long[] jArr2, long[] jArr3) {
        A(jArr, 0, jArr2, 0, jArr3, 0);
    }

    private static void A(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 16; i4++) {
            jArr[i4 + i] = jArr2[i4 + i2] + jArr3[i4 + i3];
        }
    }

    private static void Z(long[] jArr, long[] jArr2, long[] jArr3) {
        Z(jArr, 0, jArr2, 0, jArr3, 0);
    }

    private static void Z(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 16; i4++) {
            jArr[i4 + i] = jArr2[i4 + i2] - jArr3[i4 + i3];
        }
    }

    private static void M(long[] jArr, long[] jArr2, long[] jArr3) {
        M(jArr, 0, jArr2, 0, jArr3, 0);
    }

    /* JADX WARNING: type inference failed for: r96v0, types: [long[]] */
    /* JADX WARNING: type inference failed for: r100v0, types: [long[]] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void M(long[] r96, int r97, long[] r98, int r99, long[] r100, int r101) {
        /*
            int r0 = r101 + 0
            r0 = r100[r0]
            int r2 = r101 + 1
            r2 = r100[r2]
            int r4 = r101 + 2
            r4 = r100[r4]
            int r6 = r101 + 3
            r6 = r100[r6]
            int r8 = r101 + 4
            r8 = r100[r8]
            int r10 = r101 + 5
            r10 = r100[r10]
            int r12 = r101 + 6
            r12 = r100[r12]
            int r14 = r101 + 7
            r14 = r100[r14]
            int r16 = r101 + 8
            r16 = r100[r16]
            int r18 = r101 + 9
            r18 = r100[r18]
            int r20 = r101 + 10
            r20 = r100[r20]
            int r22 = r101 + 11
            r22 = r100[r22]
            int r24 = r101 + 12
            r24 = r100[r24]
            int r26 = r101 + 13
            r26 = r100[r26]
            int r28 = r101 + 14
            r28 = r100[r28]
            int r30 = r101 + 15
            r30 = r100[r30]
            int r32 = r99 + 0
            r32 = r98[r32]
            long r34 = r32 * r0
            r36 = 0
            long r34 = r34 + r36
            long r38 = r32 * r2
            long r38 = r38 + r36
            long r40 = r32 * r4
            long r40 = r40 + r36
            long r42 = r32 * r6
            long r42 = r42 + r36
            long r44 = r32 * r8
            long r44 = r44 + r36
            long r46 = r32 * r10
            long r46 = r46 + r36
            long r48 = r32 * r12
            long r48 = r48 + r36
            long r50 = r32 * r14
            long r50 = r50 + r36
            long r52 = r32 * r16
            long r52 = r52 + r36
            long r54 = r32 * r18
            long r54 = r54 + r36
            long r56 = r32 * r20
            long r56 = r56 + r36
            long r58 = r32 * r22
            long r58 = r58 + r36
            long r60 = r32 * r24
            long r60 = r60 + r36
            long r62 = r32 * r26
            long r62 = r62 + r36
            long r64 = r32 * r28
            long r64 = r64 + r36
            long r32 = r32 * r30
            long r32 = r32 + r36
            int r66 = r99 + 1
            r66 = r98[r66]
            long r68 = r66 * r0
            long r38 = r38 + r68
            long r68 = r66 * r2
            long r40 = r40 + r68
            long r68 = r66 * r4
            long r42 = r42 + r68
            long r68 = r66 * r6
            long r44 = r44 + r68
            long r68 = r66 * r8
            long r46 = r46 + r68
            long r68 = r66 * r10
            long r48 = r48 + r68
            long r68 = r66 * r12
            long r50 = r50 + r68
            long r68 = r66 * r14
            long r52 = r52 + r68
            long r68 = r66 * r16
            long r54 = r54 + r68
            long r68 = r66 * r18
            long r56 = r56 + r68
            long r68 = r66 * r20
            long r58 = r58 + r68
            long r68 = r66 * r22
            long r60 = r60 + r68
            long r68 = r66 * r24
            long r62 = r62 + r68
            long r68 = r66 * r26
            long r64 = r64 + r68
            long r68 = r66 * r28
            long r32 = r32 + r68
            long r66 = r66 * r30
            long r66 = r66 + r36
            int r68 = r99 + 2
            r68 = r98[r68]
            long r70 = r68 * r0
            long r40 = r40 + r70
            long r70 = r68 * r2
            long r42 = r42 + r70
            long r70 = r68 * r4
            long r44 = r44 + r70
            long r70 = r68 * r6
            long r46 = r46 + r70
            long r70 = r68 * r8
            long r48 = r48 + r70
            long r70 = r68 * r10
            long r50 = r50 + r70
            long r70 = r68 * r12
            long r52 = r52 + r70
            long r70 = r68 * r14
            long r54 = r54 + r70
            long r70 = r68 * r16
            long r56 = r56 + r70
            long r70 = r68 * r18
            long r58 = r58 + r70
            long r70 = r68 * r20
            long r60 = r60 + r70
            long r70 = r68 * r22
            long r62 = r62 + r70
            long r70 = r68 * r24
            long r64 = r64 + r70
            long r70 = r68 * r26
            long r32 = r32 + r70
            long r70 = r68 * r28
            long r66 = r66 + r70
            long r68 = r68 * r30
            long r68 = r68 + r36
            int r70 = r99 + 3
            r70 = r98[r70]
            long r72 = r70 * r0
            long r42 = r42 + r72
            long r72 = r70 * r2
            long r44 = r44 + r72
            long r72 = r70 * r4
            long r46 = r46 + r72
            long r72 = r70 * r6
            long r48 = r48 + r72
            long r72 = r70 * r8
            long r50 = r50 + r72
            long r72 = r70 * r10
            long r52 = r52 + r72
            long r72 = r70 * r12
            long r54 = r54 + r72
            long r72 = r70 * r14
            long r56 = r56 + r72
            long r72 = r70 * r16
            long r58 = r58 + r72
            long r72 = r70 * r18
            long r60 = r60 + r72
            long r72 = r70 * r20
            long r62 = r62 + r72
            long r72 = r70 * r22
            long r64 = r64 + r72
            long r72 = r70 * r24
            long r32 = r32 + r72
            long r72 = r70 * r26
            long r66 = r66 + r72
            long r72 = r70 * r28
            long r68 = r68 + r72
            long r70 = r70 * r30
            long r70 = r70 + r36
            int r72 = r99 + 4
            r72 = r98[r72]
            long r74 = r72 * r0
            long r44 = r44 + r74
            long r74 = r72 * r2
            long r46 = r46 + r74
            long r74 = r72 * r4
            long r48 = r48 + r74
            long r74 = r72 * r6
            long r50 = r50 + r74
            long r74 = r72 * r8
            long r52 = r52 + r74
            long r74 = r72 * r10
            long r54 = r54 + r74
            long r74 = r72 * r12
            long r56 = r56 + r74
            long r74 = r72 * r14
            long r58 = r58 + r74
            long r74 = r72 * r16
            long r60 = r60 + r74
            long r74 = r72 * r18
            long r62 = r62 + r74
            long r74 = r72 * r20
            long r64 = r64 + r74
            long r74 = r72 * r22
            long r32 = r32 + r74
            long r74 = r72 * r24
            long r66 = r66 + r74
            long r74 = r72 * r26
            long r68 = r68 + r74
            long r74 = r72 * r28
            long r70 = r70 + r74
            long r72 = r72 * r30
            long r72 = r72 + r36
            int r74 = r99 + 5
            r74 = r98[r74]
            long r76 = r74 * r0
            long r46 = r46 + r76
            long r76 = r74 * r2
            long r48 = r48 + r76
            long r76 = r74 * r4
            long r50 = r50 + r76
            long r76 = r74 * r6
            long r52 = r52 + r76
            long r76 = r74 * r8
            long r54 = r54 + r76
            long r76 = r74 * r10
            long r56 = r56 + r76
            long r76 = r74 * r12
            long r58 = r58 + r76
            long r76 = r74 * r14
            long r60 = r60 + r76
            long r76 = r74 * r16
            long r62 = r62 + r76
            long r76 = r74 * r18
            long r64 = r64 + r76
            long r76 = r74 * r20
            long r32 = r32 + r76
            long r76 = r74 * r22
            long r66 = r66 + r76
            long r76 = r74 * r24
            long r68 = r68 + r76
            long r76 = r74 * r26
            long r70 = r70 + r76
            long r76 = r74 * r28
            long r72 = r72 + r76
            long r74 = r74 * r30
            long r74 = r74 + r36
            int r76 = r99 + 6
            r76 = r98[r76]
            long r78 = r76 * r0
            long r48 = r48 + r78
            long r78 = r76 * r2
            long r50 = r50 + r78
            long r78 = r76 * r4
            long r52 = r52 + r78
            long r78 = r76 * r6
            long r54 = r54 + r78
            long r78 = r76 * r8
            long r56 = r56 + r78
            long r78 = r76 * r10
            long r58 = r58 + r78
            long r78 = r76 * r12
            long r60 = r60 + r78
            long r78 = r76 * r14
            long r62 = r62 + r78
            long r78 = r76 * r16
            long r64 = r64 + r78
            long r78 = r76 * r18
            long r32 = r32 + r78
            long r78 = r76 * r20
            long r66 = r66 + r78
            long r78 = r76 * r22
            long r68 = r68 + r78
            long r78 = r76 * r24
            long r70 = r70 + r78
            long r78 = r76 * r26
            long r72 = r72 + r78
            long r78 = r76 * r28
            long r74 = r74 + r78
            long r76 = r76 * r30
            long r76 = r76 + r36
            int r78 = r99 + 7
            r78 = r98[r78]
            long r80 = r78 * r0
            long r50 = r50 + r80
            long r80 = r78 * r2
            long r52 = r52 + r80
            long r80 = r78 * r4
            long r54 = r54 + r80
            long r80 = r78 * r6
            long r56 = r56 + r80
            long r80 = r78 * r8
            long r58 = r58 + r80
            long r80 = r78 * r10
            long r60 = r60 + r80
            long r80 = r78 * r12
            long r62 = r62 + r80
            long r80 = r78 * r14
            long r64 = r64 + r80
            long r80 = r78 * r16
            long r32 = r32 + r80
            long r80 = r78 * r18
            long r66 = r66 + r80
            long r80 = r78 * r20
            long r68 = r68 + r80
            long r80 = r78 * r22
            long r70 = r70 + r80
            long r80 = r78 * r24
            long r72 = r72 + r80
            long r80 = r78 * r26
            long r74 = r74 + r80
            long r80 = r78 * r28
            long r76 = r76 + r80
            long r78 = r78 * r30
            long r78 = r78 + r36
            int r80 = r99 + 8
            r80 = r98[r80]
            long r82 = r80 * r0
            long r52 = r52 + r82
            long r82 = r80 * r2
            long r54 = r54 + r82
            long r82 = r80 * r4
            long r56 = r56 + r82
            long r82 = r80 * r6
            long r58 = r58 + r82
            long r82 = r80 * r8
            long r60 = r60 + r82
            long r82 = r80 * r10
            long r62 = r62 + r82
            long r82 = r80 * r12
            long r64 = r64 + r82
            long r82 = r80 * r14
            long r32 = r32 + r82
            long r82 = r80 * r16
            long r66 = r66 + r82
            long r82 = r80 * r18
            long r68 = r68 + r82
            long r82 = r80 * r20
            long r70 = r70 + r82
            long r82 = r80 * r22
            long r72 = r72 + r82
            long r82 = r80 * r24
            long r74 = r74 + r82
            long r82 = r80 * r26
            long r76 = r76 + r82
            long r82 = r80 * r28
            long r78 = r78 + r82
            long r80 = r80 * r30
            long r80 = r80 + r36
            int r82 = r99 + 9
            r82 = r98[r82]
            long r84 = r82 * r0
            long r54 = r54 + r84
            long r84 = r82 * r2
            long r56 = r56 + r84
            long r84 = r82 * r4
            long r58 = r58 + r84
            long r84 = r82 * r6
            long r60 = r60 + r84
            long r84 = r82 * r8
            long r62 = r62 + r84
            long r84 = r82 * r10
            long r64 = r64 + r84
            long r84 = r82 * r12
            long r32 = r32 + r84
            long r84 = r82 * r14
            long r66 = r66 + r84
            long r84 = r82 * r16
            long r68 = r68 + r84
            long r84 = r82 * r18
            long r70 = r70 + r84
            long r84 = r82 * r20
            long r72 = r72 + r84
            long r84 = r82 * r22
            long r74 = r74 + r84
            long r84 = r82 * r24
            long r76 = r76 + r84
            long r84 = r82 * r26
            long r78 = r78 + r84
            long r84 = r82 * r28
            long r80 = r80 + r84
            long r82 = r82 * r30
            long r82 = r82 + r36
            int r84 = r99 + 10
            r84 = r98[r84]
            long r86 = r84 * r0
            long r56 = r56 + r86
            long r86 = r84 * r2
            long r58 = r58 + r86
            long r86 = r84 * r4
            long r60 = r60 + r86
            long r86 = r84 * r6
            long r62 = r62 + r86
            long r86 = r84 * r8
            long r64 = r64 + r86
            long r86 = r84 * r10
            long r32 = r32 + r86
            long r86 = r84 * r12
            long r66 = r66 + r86
            long r86 = r84 * r14
            long r68 = r68 + r86
            long r86 = r84 * r16
            long r70 = r70 + r86
            long r86 = r84 * r18
            long r72 = r72 + r86
            long r86 = r84 * r20
            long r74 = r74 + r86
            long r86 = r84 * r22
            long r76 = r76 + r86
            long r86 = r84 * r24
            long r78 = r78 + r86
            long r86 = r84 * r26
            long r80 = r80 + r86
            long r86 = r84 * r28
            long r82 = r82 + r86
            long r84 = r84 * r30
            long r84 = r84 + r36
            int r86 = r99 + 11
            r86 = r98[r86]
            long r88 = r86 * r0
            long r58 = r58 + r88
            long r88 = r86 * r2
            long r60 = r60 + r88
            long r88 = r86 * r4
            long r62 = r62 + r88
            long r88 = r86 * r6
            long r64 = r64 + r88
            long r88 = r86 * r8
            long r32 = r32 + r88
            long r88 = r86 * r10
            long r66 = r66 + r88
            long r88 = r86 * r12
            long r68 = r68 + r88
            long r88 = r86 * r14
            long r70 = r70 + r88
            long r88 = r86 * r16
            long r72 = r72 + r88
            long r88 = r86 * r18
            long r74 = r74 + r88
            long r88 = r86 * r20
            long r76 = r76 + r88
            long r88 = r86 * r22
            long r78 = r78 + r88
            long r88 = r86 * r24
            long r80 = r80 + r88
            long r88 = r86 * r26
            long r82 = r82 + r88
            long r88 = r86 * r28
            long r84 = r84 + r88
            long r86 = r86 * r30
            long r86 = r86 + r36
            int r88 = r99 + 12
            r88 = r98[r88]
            long r90 = r88 * r0
            long r60 = r60 + r90
            long r90 = r88 * r2
            long r62 = r62 + r90
            long r90 = r88 * r4
            long r64 = r64 + r90
            long r90 = r88 * r6
            long r32 = r32 + r90
            long r90 = r88 * r8
            long r66 = r66 + r90
            long r90 = r88 * r10
            long r68 = r68 + r90
            long r90 = r88 * r12
            long r70 = r70 + r90
            long r90 = r88 * r14
            long r72 = r72 + r90
            long r90 = r88 * r16
            long r74 = r74 + r90
            long r90 = r88 * r18
            long r76 = r76 + r90
            long r90 = r88 * r20
            long r78 = r78 + r90
            long r90 = r88 * r22
            long r80 = r80 + r90
            long r90 = r88 * r24
            long r82 = r82 + r90
            long r90 = r88 * r26
            long r84 = r84 + r90
            long r90 = r88 * r28
            long r86 = r86 + r90
            long r88 = r88 * r30
            long r88 = r88 + r36
            int r90 = r99 + 13
            r90 = r98[r90]
            long r92 = r90 * r0
            long r62 = r62 + r92
            long r92 = r90 * r2
            long r64 = r64 + r92
            long r92 = r90 * r4
            long r32 = r32 + r92
            long r92 = r90 * r6
            long r66 = r66 + r92
            long r92 = r90 * r8
            long r68 = r68 + r92
            long r92 = r90 * r10
            long r70 = r70 + r92
            long r92 = r90 * r12
            long r72 = r72 + r92
            long r92 = r90 * r14
            long r74 = r74 + r92
            long r92 = r90 * r16
            long r76 = r76 + r92
            long r92 = r90 * r18
            long r78 = r78 + r92
            long r92 = r90 * r20
            long r80 = r80 + r92
            long r92 = r90 * r22
            long r82 = r82 + r92
            long r92 = r90 * r24
            long r84 = r84 + r92
            long r92 = r90 * r26
            long r86 = r86 + r92
            long r92 = r90 * r28
            long r88 = r88 + r92
            long r90 = r90 * r30
            long r90 = r90 + r36
            int r92 = r99 + 14
            r92 = r98[r92]
            long r94 = r92 * r0
            long r64 = r64 + r94
            long r94 = r92 * r2
            long r32 = r32 + r94
            long r94 = r92 * r4
            long r66 = r66 + r94
            long r94 = r92 * r6
            long r68 = r68 + r94
            long r94 = r92 * r8
            long r70 = r70 + r94
            long r94 = r92 * r10
            long r72 = r72 + r94
            long r94 = r92 * r12
            long r74 = r74 + r94
            long r94 = r92 * r14
            long r76 = r76 + r94
            long r94 = r92 * r16
            long r78 = r78 + r94
            long r94 = r92 * r18
            long r80 = r80 + r94
            long r94 = r92 * r20
            long r82 = r82 + r94
            long r94 = r92 * r22
            long r84 = r84 + r94
            long r94 = r92 * r24
            long r86 = r86 + r94
            long r94 = r92 * r26
            long r88 = r88 + r94
            long r94 = r92 * r28
            long r90 = r90 + r94
            long r92 = r92 * r30
            long r92 = r92 + r36
            int r94 = r99 + 15
            r94 = r98[r94]
            long r0 = r0 * r94
            long r32 = r32 + r0
            long r2 = r2 * r94
            long r66 = r66 + r2
            long r4 = r4 * r94
            long r68 = r68 + r4
            long r6 = r6 * r94
            long r70 = r70 + r6
            long r8 = r8 * r94
            long r72 = r72 + r8
            long r10 = r10 * r94
            long r74 = r74 + r10
            long r12 = r12 * r94
            long r76 = r76 + r12
            long r14 = r14 * r94
            long r78 = r78 + r14
            long r16 = r16 * r94
            long r80 = r80 + r16
            long r18 = r18 * r94
            long r82 = r82 + r18
            long r20 = r20 * r94
            long r84 = r84 + r20
            long r22 = r22 * r94
            long r86 = r86 + r22
            long r24 = r24 * r94
            long r88 = r88 + r24
            long r26 = r26 * r94
            long r90 = r90 + r26
            long r28 = r28 * r94
            long r92 = r92 + r28
            long r94 = r94 * r30
            long r94 = r94 + r36
            r0 = 38
            long r66 = r66 * r0
            long r34 = r34 + r66
            long r68 = r68 * r0
            long r38 = r38 + r68
            long r70 = r70 * r0
            long r40 = r40 + r70
            long r72 = r72 * r0
            long r42 = r42 + r72
            long r74 = r74 * r0
            long r44 = r44 + r74
            long r76 = r76 * r0
            long r46 = r46 + r76
            long r78 = r78 * r0
            long r48 = r48 + r78
            long r80 = r80 * r0
            long r50 = r50 + r80
            long r82 = r82 * r0
            long r52 = r52 + r82
            long r84 = r84 * r0
            long r54 = r54 + r84
            long r86 = r86 * r0
            long r56 = r56 + r86
            long r88 = r88 * r0
            long r58 = r58 + r88
            long r90 = r90 * r0
            long r60 = r60 + r90
            long r92 = r92 * r0
            long r62 = r62 + r92
            long r94 = r94 * r0
            long r64 = r64 + r94
            r0 = 1
            long r34 = r34 + r0
            r2 = 65535(0xffff, double:3.23786E-319)
            long r34 = r34 + r2
            r4 = 16
            long r5 = r34 >> r4
            r7 = 65536(0x10000, double:3.2379E-319)
            long r9 = r5 * r7
            long r34 = r34 - r9
            long r38 = r38 + r5
            long r38 = r38 + r2
            long r5 = r38 >> r4
            long r9 = r5 * r7
            long r38 = r38 - r9
            long r40 = r40 + r5
            long r40 = r40 + r2
            long r5 = r40 >> r4
            long r9 = r5 * r7
            long r40 = r40 - r9
            long r42 = r42 + r5
            long r42 = r42 + r2
            long r5 = r42 >> r4
            long r9 = r5 * r7
            long r42 = r42 - r9
            long r44 = r44 + r5
            long r44 = r44 + r2
            long r5 = r44 >> r4
            long r9 = r5 * r7
            long r44 = r44 - r9
            long r46 = r46 + r5
            long r46 = r46 + r2
            long r5 = r46 >> r4
            long r9 = r5 * r7
            long r46 = r46 - r9
            long r48 = r48 + r5
            long r48 = r48 + r2
            long r5 = r48 >> r4
            long r9 = r5 * r7
            long r48 = r48 - r9
            long r50 = r50 + r5
            long r50 = r50 + r2
            long r5 = r50 >> r4
            long r9 = r5 * r7
            long r50 = r50 - r9
            long r52 = r52 + r5
            long r52 = r52 + r2
            long r5 = r52 >> r4
            long r9 = r5 * r7
            long r52 = r52 - r9
            long r54 = r54 + r5
            long r54 = r54 + r2
            long r5 = r54 >> r4
            long r9 = r5 * r7
            long r54 = r54 - r9
            long r56 = r56 + r5
            long r56 = r56 + r2
            long r5 = r56 >> r4
            long r9 = r5 * r7
            long r56 = r56 - r9
            long r58 = r58 + r5
            long r58 = r58 + r2
            long r5 = r58 >> r4
            long r9 = r5 * r7
            long r58 = r58 - r9
            long r60 = r60 + r5
            long r60 = r60 + r2
            long r5 = r60 >> r4
            long r9 = r5 * r7
            long r60 = r60 - r9
            long r62 = r62 + r5
            long r62 = r62 + r2
            long r5 = r62 >> r4
            long r9 = r5 * r7
            long r62 = r62 - r9
            long r64 = r64 + r5
            long r64 = r64 + r2
            long r5 = r64 >> r4
            long r9 = r5 * r7
            long r64 = r64 - r9
            long r32 = r32 + r5
            long r32 = r32 + r2
            long r5 = r32 >> r4
            long r9 = r5 * r7
            long r32 = r32 - r9
            long r5 = r5 - r0
            r9 = 37
            long r9 = r9 * r5
            long r5 = r5 + r9
            long r34 = r34 + r5
            long r34 = r34 + r0
            long r34 = r34 + r2
            long r5 = r34 >> r4
            long r9 = r5 * r7
            long r34 = r34 - r9
            long r38 = r38 + r5
            long r38 = r38 + r2
            long r5 = r38 >> r4
            long r9 = r5 * r7
            long r38 = r38 - r9
            long r40 = r40 + r5
            long r40 = r40 + r2
            long r5 = r40 >> r4
            long r9 = r5 * r7
            long r40 = r40 - r9
            long r42 = r42 + r5
            long r42 = r42 + r2
            long r5 = r42 >> r4
            long r9 = r5 * r7
            long r42 = r42 - r9
            long r44 = r44 + r5
            long r44 = r44 + r2
            long r5 = r44 >> r4
            long r9 = r5 * r7
            long r44 = r44 - r9
            long r46 = r46 + r5
            long r46 = r46 + r2
            long r5 = r46 >> r4
            long r9 = r5 * r7
            long r46 = r46 - r9
            long r48 = r48 + r5
            long r48 = r48 + r2
            long r5 = r48 >> r4
            long r9 = r5 * r7
            long r48 = r48 - r9
            long r50 = r50 + r5
            long r50 = r50 + r2
            long r5 = r50 >> r4
            long r9 = r5 * r7
            long r50 = r50 - r9
            long r52 = r52 + r5
            long r52 = r52 + r2
            long r5 = r52 >> r4
            long r9 = r5 * r7
            long r52 = r52 - r9
            long r54 = r54 + r5
            long r54 = r54 + r2
            long r5 = r54 >> r4
            long r9 = r5 * r7
            long r54 = r54 - r9
            long r56 = r56 + r5
            long r56 = r56 + r2
            long r5 = r56 >> r4
            long r9 = r5 * r7
            long r56 = r56 - r9
            long r58 = r58 + r5
            long r58 = r58 + r2
            long r5 = r58 >> r4
            long r9 = r5 * r7
            long r58 = r58 - r9
            long r60 = r60 + r5
            long r60 = r60 + r2
            long r5 = r60 >> r4
            long r9 = r5 * r7
            long r60 = r60 - r9
            long r62 = r62 + r5
            long r62 = r62 + r2
            long r5 = r62 >> r4
            long r9 = r5 * r7
            long r62 = r62 - r9
            long r64 = r64 + r5
            long r64 = r64 + r2
            long r5 = r64 >> r4
            long r9 = r5 * r7
            long r64 = r64 - r9
            long r32 = r32 + r5
            long r32 = r32 + r2
            long r2 = r32 >> r4
            long r7 = r7 * r2
            long r32 = r32 - r7
            long r2 = r2 - r0
            r0 = 37
            long r0 = r0 * r2
            long r2 = r2 + r0
            long r34 = r34 + r2
            int r0 = r97 + 0
            r96[r0] = r34
            int r0 = r97 + 1
            r96[r0] = r38
            int r0 = r97 + 2
            r96[r0] = r40
            int r0 = r97 + 3
            r96[r0] = r42
            int r0 = r97 + 4
            r96[r0] = r44
            int r0 = r97 + 5
            r96[r0] = r46
            int r0 = r97 + 6
            r96[r0] = r48
            int r0 = r97 + 7
            r96[r0] = r50
            int r0 = r97 + 8
            r96[r0] = r52
            int r0 = r97 + 9
            r96[r0] = r54
            int r0 = r97 + 10
            r96[r0] = r56
            int r0 = r97 + 11
            r96[r0] = r58
            int r0 = r97 + 12
            r96[r0] = r60
            int r0 = r97 + 13
            r96[r0] = r62
            int r0 = r97 + 14
            r96[r0] = r64
            int r0 = r97 + 15
            r96[r0] = r32
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stikerwap.appdys.TweetNaclFast.M(long[], int, long[], int, long[], int):void");
    }

    private static void S(long[] jArr, long[] jArr2) {
        S(jArr, 0, jArr2, 0);
    }

    private static void S(long[] jArr, int i, long[] jArr2, int i2) {
        M(jArr, i, jArr2, i2, jArr2, i2);
    }

    private static void inv25519(long[] jArr, int i, long[] jArr2, int i2) {
        long[] jArr3 = new long[16];
        for (int i3 = 0; i3 < 16; i3++) {
            jArr3[i3] = jArr2[i3 + i2];
        }
        for (int i4 = PreciseDisconnectCause.RADIO_ACCESS_FAILURE; i4 >= 0; i4--) {
            S(jArr3, 0, jArr3, 0);
            if (!(i4 == 2 || i4 == 4)) {
                M(jArr3, 0, jArr3, 0, jArr2, i2);
            }
        }
        for (int i5 = 0; i5 < 16; i5++) {
            jArr[i5 + i] = jArr3[i5];
        }
    }

    private static void pow2523(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[16];
        for (int i = 0; i < 16; i++) {
            jArr3[i] = jArr2[i];
        }
        for (int i2 = 250; i2 >= 0; i2--) {
            S(jArr3, 0, jArr3, 0);
            if (i2 != 1) {
                M(jArr3, 0, jArr3, 0, jArr2, 0);
            }
        }
        for (int i3 = 0; i3 < 16; i3++) {
            jArr[i3] = jArr3[i3];
        }
    }

    public static int crypto_scalarmult(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[32];
        long[] jArr = new long[80];
        long[] jArr2 = new long[16];
        long[] jArr3 = new long[16];
        long[] jArr4 = new long[16];
        long[] jArr5 = new long[16];
        long[] jArr6 = new long[16];
        long[] jArr7 = new long[16];
        for (int i = 0; i < 31; i++) {
            bArr4[i] = bArr2[i];
        }
        bArr4[31] = (byte) (((bArr2[31] & Byte.MAX_VALUE) | SignedBytes.MAX_POWER_OF_TWO) & 255);
        bArr4[0] = (byte) (bArr4[0] & 248);
        unpack25519(jArr, bArr3);
        for (int i2 = 0; i2 < 16; i2++) {
            jArr3[i2] = jArr[i2];
            jArr4[i2] = 0;
            jArr2[i2] = 0;
            jArr5[i2] = 0;
        }
        jArr5[0] = 1;
        jArr2[0] = 1;
        for (int i3 = PreciseDisconnectCause.RADIO_LINK_FAILURE; i3 >= 0; i3--) {
            int i4 = (bArr4[i3 >>> 3] >>> (i3 & 7)) & 1;
            sel25519(jArr2, jArr3, i4);
            sel25519(jArr4, jArr5, i4);
            A(jArr6, jArr2, jArr4);
            Z(jArr2, jArr2, jArr4);
            A(jArr4, jArr3, jArr5);
            Z(jArr3, jArr3, jArr5);
            S(jArr5, jArr6);
            S(jArr7, jArr2);
            M(jArr2, jArr4, jArr2);
            M(jArr4, jArr3, jArr6);
            A(jArr6, jArr2, jArr4);
            Z(jArr2, jArr2, jArr4);
            S(jArr3, jArr2);
            Z(jArr4, jArr5, jArr7);
            M(jArr2, jArr4, _121665);
            A(jArr2, jArr2, jArr5);
            M(jArr4, jArr4, jArr2);
            M(jArr2, jArr5, jArr7);
            M(jArr5, jArr3, jArr);
            S(jArr3, jArr6);
            sel25519(jArr2, jArr3, i4);
            sel25519(jArr4, jArr5, i4);
        }
        for (int i5 = 0; i5 < 16; i5++) {
            jArr[i5 + 16] = jArr2[i5];
            jArr[i5 + 32] = jArr4[i5];
            jArr[i5 + 48] = jArr3[i5];
            jArr[i5 + 64] = jArr5[i5];
        }
        inv25519(jArr, 32, jArr, 32);
        M(jArr, 16, jArr, 16, jArr, 32);
        pack25519(bArr, jArr, 16);
        return 0;
    }

    public static int crypto_scalarmult_base(byte[] bArr, byte[] bArr2) {
        return crypto_scalarmult(bArr, bArr2, _9);
    }

    public static int crypto_box_keypair(byte[] bArr, byte[] bArr2) {
        randombytes(bArr2, 32);
        return crypto_scalarmult_base(bArr, bArr2);
    }

    public static int crypto_box_beforenm(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[32];
        crypto_scalarmult(bArr4, bArr3, bArr2);
        return crypto_core_hsalsa20(bArr, _0, bArr4, sigma);
    }

    public static int crypto_box_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return crypto_secretbox(bArr, bArr2, i, bArr3, bArr4);
    }

    public static int crypto_box_open_afternm(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return crypto_secretbox_open(bArr, bArr2, i, bArr3, bArr4);
    }

    public static int crypto_box(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = new byte[32];
        crypto_box_beforenm(bArr6, bArr4, bArr5);
        return crypto_box_afternm(bArr, bArr2, i, bArr3, bArr6);
    }

    public static int crypto_box_open(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = new byte[32];
        crypto_box_beforenm(bArr6, bArr4, bArr5);
        return crypto_box_open_afternm(bArr, bArr2, i, bArr3, bArr6);
    }

    private static int crypto_hashblocks_hl(int[] iArr, int[] iArr2, byte[] bArr, int i, int i2) {
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        byte b = 0;
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = iArr[2];
        int i6 = iArr[3];
        int i7 = iArr[4];
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = iArr2[0];
        int i12 = iArr2[1];
        int i13 = iArr2[2];
        int i14 = iArr2[3];
        int i15 = iArr2[4];
        int i16 = iArr2[5];
        int i17 = iArr2[6];
        int i18 = iArr2[7];
        int i19 = 0;
        int i20 = i17;
        int i21 = i16;
        int i22 = i15;
        int i23 = i14;
        int i24 = i13;
        int i25 = i12;
        int i26 = i11;
        int i27 = i10;
        int i28 = i9;
        int i29 = i8;
        int i30 = i7;
        int i31 = i6;
        int i32 = i5;
        int i33 = i4;
        int i34 = i3;
        int i35 = i2;
        while (i35 >= 128) {
            for (int i36 = 0; i36 < 16; i36++) {
                int i37 = (i36 * 8) + i19;
                iArr3[i36] = ((bArr[(i37 + 1) + i] & 255) << Ascii.DLE) | ((bArr[(i37 + 0) + i] & 255) << Ascii.CAN) | ((bArr[(i37 + 2) + i] & 255) << 8) | ((bArr[(i37 + 3) + i] & 255) << b);
                iArr4[i36] = ((bArr[(i37 + 4) + i] & 255) << Ascii.CAN) | ((bArr[(i37 + 5) + i] & 255) << Ascii.DLE) | ((bArr[(i37 + 6) + i] & 255) << 8) | ((bArr[(i37 + 7) + i] & 255) << b);
            }
            int i38 = 0;
            while (i38 < 80) {
                int i39 = (((i30 >>> 14) | (i22 << 18)) ^ ((i30 >>> 18) | (i22 << 14))) ^ ((i22 >>> 9) | (i30 << 23));
                int i40 = (((i22 >>> 14) | (i30 << 18)) ^ ((i22 >>> 18) | (i30 << 14))) ^ ((i30 >>> 9) | (i22 << 23));
                int i41 = (i18 & 65535) + (i40 & 65535);
                int i42 = (i18 >>> 16) + (i40 >>> 16);
                int i43 = (i27 & 65535) + (i39 & 65535);
                int i44 = (i27 >>> 16) + (i39 >>> 16);
                int i45 = (i30 & i29) ^ ((i30 ^ -1) & i28);
                int i46 = (i22 & i21) ^ ((i22 ^ -1) & i20);
                int i47 = i42 + (i46 >>> 16);
                long j = K[i38];
                int i48 = i34;
                int i49 = (int) ((j >>> 32) & -1);
                int i50 = i35;
                int i51 = (int) ((j >>> b) & -1);
                int i52 = i41 + (i46 & 65535) + (i51 & 65535);
                int i53 = i47 + (i51 >>> 16);
                int i54 = i43 + (i45 & 65535) + (i49 & 65535);
                int i55 = i44 + (i45 >>> 16) + (i49 >>> 16);
                int i56 = i38 % 16;
                int i57 = iArr3[i56];
                int i58 = iArr4[i56];
                int i59 = i52 + (i58 & 65535);
                int i60 = i53 + (i58 >>> 16) + (i59 >>> 16);
                int i61 = i54 + (i57 & 65535) + (i60 >>> 16);
                int i62 = (i61 & 65535) | (((i55 + (i57 >>> 16)) + (i61 >>> 16)) << 16);
                int i63 = (i59 & 65535) | (i60 << 16);
                int i64 = i63 & 65535;
                int i65 = i63 >>> 16;
                int i66 = i62 & 65535;
                int i67 = i62 >>> 16;
                int i68 = (((i48 >>> 28) | (i26 << 4)) ^ ((i26 >>> 2) | (i48 << 30))) ^ ((i26 >>> 7) | (i48 << 25));
                int i69 = (((i26 >>> 28) | (i48 << 4)) ^ ((i48 >>> 2) | (i26 << 30))) ^ ((i48 >>> 7) | (i26 << 25));
                int i70 = ((i48 & i33) ^ (i48 & i32)) ^ (i33 & i32);
                int i71 = ((i26 & i25) ^ (i26 & i24)) ^ (i25 & i24);
                int i72 = i64 + (i69 & 65535) + (i71 & 65535);
                int i73 = i65 + (i69 >>> 16) + (i71 >>> 16) + (i72 >>> 16);
                int i74 = i66 + (i68 & 65535) + (i70 & 65535) + (i73 >>> 16);
                int i75 = (i74 & 65535) | ((((i67 + (i68 >>> 16)) + (i70 >>> 16)) + (i74 >>> 16)) << 16);
                int i76 = (i72 & 65535) | (i73 << 16);
                int i77 = (i23 & 65535) + i64;
                int i78 = (i23 >>> 16) + i65 + (i77 >>> 16);
                int i79 = (i31 & 65535) + i66 + (i78 >>> 16);
                int i80 = (i79 & 65535) | ((((i31 >>> 16) + i67) + (i79 >>> 16)) << 16);
                int i81 = (i77 & 65535) | (i78 << 16);
                if (i56 == 15) {
                    int i82 = 0;
                    while (i82 < 16) {
                        int i83 = iArr3[i82];
                        int i84 = iArr4[i82];
                        int i85 = (i82 + 9) % 16;
                        int i86 = iArr3[i85];
                        int i87 = iArr4[i85];
                        int i88 = (i84 & 65535) + (i87 & 65535);
                        int i89 = (i84 >>> 16) + (i87 >>> 16);
                        int i90 = (i83 & 65535) + (i86 & 65535);
                        int i91 = (i83 >>> 16) + (i86 >>> 16);
                        int i92 = i82 + 1;
                        int i93 = i92 % 16;
                        int i94 = iArr3[i93];
                        int i95 = iArr4[i93];
                        int i96 = (((i94 >>> 1) | (i95 << 31)) ^ ((i94 >>> 8) | (i95 << 24))) ^ (i94 >>> 7);
                        int i97 = (((i95 >>> 1) | (i94 << 31)) ^ ((i95 >>> 8) | (i94 << 24))) ^ ((i95 >>> 7) | (i94 << 25));
                        int i98 = i88 + (i97 & 65535);
                        int i99 = i89 + (i97 >>> 16);
                        int i100 = i90 + (i96 & 65535);
                        int i101 = i91 + (i96 >>> 16);
                        int i102 = (i82 + 14) % 16;
                        int i103 = iArr3[i102];
                        int i104 = iArr4[i102];
                        int i105 = (((i103 >>> 19) | (i104 << 13)) ^ ((i104 >>> 29) | (i103 << 3))) ^ (i103 >>> 6);
                        int i106 = (((i104 >>> 19) | (i103 << 13)) ^ ((i103 >>> 29) | (i104 << 3))) ^ ((i104 >>> 6) | (i103 << 26));
                        int i107 = i98 + (i106 & 65535);
                        int i108 = i99 + (i106 >>> 16) + (i107 >>> 16);
                        int i109 = i100 + (i105 & 65535) + (i108 >>> 16);
                        iArr3[i82] = (i109 & 65535) | (((i101 + (i105 >>> 16)) + (i109 >>> 16)) << 16);
                        iArr4[i82] = (i107 & 65535) | (i108 << 16);
                        i82 = i92;
                    }
                }
                i38++;
                i31 = i32;
                i27 = i28;
                i23 = i24;
                b = 0;
                i32 = i33;
                i28 = i29;
                i24 = i25;
                i33 = i48;
                i29 = i30;
                i25 = i26;
                i26 = i76;
                i30 = i80;
                i35 = i50;
                int i110 = i22;
                i22 = i81;
                i34 = i75;
                i18 = i20;
                i20 = i21;
                i21 = i110;
            }
            int i111 = i35;
            int i112 = i34;
            int i113 = i26 & 65535;
            int i114 = i26 >>> 16;
            int i115 = iArr[0];
            int i116 = iArr2[0];
            int i117 = i113 + (i116 & 65535);
            int i118 = i114 + (i116 >>> 16) + (i117 >>> 16);
            int i119 = (i112 & 65535) + (i115 & 65535) + (i118 >>> 16);
            i34 = (i119 & 65535) | ((((i112 >>> 16) + (i115 >>> 16)) + (i119 >>> 16)) << 16);
            iArr[0] = i34;
            i26 = (i117 & 65535) | (i118 << 16);
            iArr2[0] = i26;
            int i120 = i25 & 65535;
            int i121 = i25 >>> 16;
            int i122 = iArr[1];
            int i123 = iArr2[1];
            int i124 = i120 + (i123 & 65535);
            int i125 = i121 + (i123 >>> 16) + (i124 >>> 16);
            int i126 = (i33 & 65535) + (i122 & 65535) + (i125 >>> 16);
            i33 = ((((i33 >>> 16) + (i122 >>> 16)) + (i126 >>> 16)) << 16) | (i126 & 65535);
            iArr[1] = i33;
            i25 = (i124 & 65535) | (i125 << 16);
            iArr2[1] = i25;
            int i127 = iArr[2];
            int i128 = iArr2[2];
            int i129 = (i24 & 65535) + (i128 & 65535);
            int i130 = (i24 >>> 16) + (i128 >>> 16) + (i129 >>> 16);
            int i131 = (i32 & 65535) + (i127 & 65535) + (i130 >>> 16);
            i32 = ((((i32 >>> 16) + (i127 >>> 16)) + (i131 >>> 16)) << 16) | (i131 & 65535);
            iArr[2] = i32;
            i24 = (i129 & 65535) | (i130 << 16);
            iArr2[2] = i24;
            int i132 = iArr[3];
            int i133 = iArr2[3];
            int i134 = (i23 & 65535) + (i133 & 65535);
            int i135 = (i23 >>> 16) + (i133 >>> 16) + (i134 >>> 16);
            int i136 = (i31 & 65535) + (i132 & 65535) + (i135 >>> 16);
            i31 = (i136 & 65535) | ((((i31 >>> 16) + (i132 >>> 16)) + (i136 >>> 16)) << 16);
            iArr[3] = i31;
            int i137 = (i134 & 65535) | (i135 << 16);
            iArr2[3] = i137;
            int i138 = iArr[4];
            int i139 = iArr2[4];
            int i140 = (i22 & 65535) + (i139 & 65535);
            int i141 = (i22 >>> 16) + (i139 >>> 16) + (i140 >>> 16);
            int i142 = (i30 & 65535) + (i138 & 65535) + (i141 >>> 16);
            i30 = (i142 & 65535) | ((((i30 >>> 16) + (i138 >>> 16)) + (i142 >>> 16)) << 16);
            iArr[4] = i30;
            i22 = (i140 & 65535) | (i141 << 16);
            iArr2[4] = i22;
            int i143 = iArr[5];
            int i144 = iArr2[5];
            int i145 = (i21 & 65535) + (i144 & 65535);
            int i146 = (i21 >>> 16) + (i144 >>> 16) + (i145 >>> 16);
            int i147 = (i29 & 65535) + (i143 & 65535) + (i146 >>> 16);
            i29 = (i147 & 65535) | ((((i29 >>> 16) + (i143 >>> 16)) + (i147 >>> 16)) << 16);
            iArr[5] = i29;
            i21 = (i145 & 65535) | (i146 << 16);
            iArr2[5] = i21;
            int i148 = iArr[6];
            int i149 = iArr2[6];
            int i150 = (i20 & 65535) + (i149 & 65535);
            int i151 = (i20 >>> 16) + (i149 >>> 16) + (i150 >>> 16);
            int i152 = (i28 & 65535) + (i148 & 65535) + (i151 >>> 16);
            i28 = (i152 & 65535) | ((((i28 >>> 16) + (i148 >>> 16)) + (i152 >>> 16)) << 16);
            iArr[6] = i28;
            i20 = (i150 & 65535) | (i151 << 16);
            iArr2[6] = i20;
            int i153 = iArr[7];
            int i154 = iArr2[7];
            int i155 = (i18 & 65535) + (i154 & 65535);
            int i156 = (i18 >>> 16) + (i154 >>> 16) + (i155 >>> 16);
            int i157 = (i27 & 65535) + (i153 & 65535) + (i156 >>> 16);
            i27 = (i157 & 65535) | ((((i27 >>> 16) + (i153 >>> 16)) + (i157 >>> 16)) << 16);
            iArr[7] = i27;
            i18 = (i155 & 65535) | (i156 << 16);
            iArr2[7] = i18;
            i19 += 128;
            i35 = i111 - 128;
            i23 = i137;
            b = 0;
        }
        return i35;
    }

    public static int crypto_hash(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3;
        int[] iArr = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};
        int[] iArr2 = {-205731576, -2067093701, -23791573, 1595750129, -1377402159, 725511199, -79577749, 327033209};
        byte[] bArr3 = new byte[256];
        if (i2 >= 128) {
            crypto_hashblocks_hl(iArr, iArr2, bArr2, i, i2);
            i3 = i2 % 128;
        } else {
            i3 = i2;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = bArr2[(i2 - i3) + i4 + i];
        }
        bArr3[i3] = Byte.MIN_VALUE;
        int i5 = 256 - ((i3 < 112 ? 1 : 0) * 128);
        bArr3[i5 - 9] = 0;
        ts64(bArr3, i5 - 8, (long) (i2 << 3));
        crypto_hashblocks_hl(iArr, iArr2, bArr3, 0, i5);
        for (int i6 = 0; i6 < 8; i6++) {
            ts64(bArr, i6 * 8, (((long) iArr[i6]) << 32) | (((long) iArr2[i6]) & 4294967295L));
        }
        return 0;
    }

    public static int crypto_hash(byte[] bArr, byte[] bArr2) {
        return crypto_hash(bArr, bArr2, 0, bArr2 != null ? bArr2.length : 0);
    }

    private static void add(long[][] jArr, long[][] jArr2) {
        long[] jArr3 = new long[16];
        long[] jArr4 = new long[16];
        long[] jArr5 = new long[16];
        long[] jArr6 = new long[16];
        long[] jArr7 = new long[16];
        long[] jArr8 = new long[16];
        long[] jArr9 = new long[16];
        long[] jArr10 = new long[16];
        long[] jArr11 = new long[16];
        long[] jArr12 = jArr[0];
        long[] jArr13 = jArr[1];
        long[] jArr14 = jArr[2];
        long[] jArr15 = jArr[3];
        long[] jArr16 = jArr2[0];
        long[] jArr17 = jArr2[1];
        long[] jArr18 = jArr2[2];
        long[] jArr19 = jArr2[3];
        Z(jArr3, 0, jArr13, 0, jArr12, 0);
        Z(jArr7, 0, jArr17, 0, jArr16, 0);
        M(jArr3, 0, jArr3, 0, jArr7, 0);
        A(jArr4, 0, jArr12, 0, jArr13, 0);
        A(jArr7, 0, jArr16, 0, jArr17, 0);
        M(jArr4, 0, jArr4, 0, jArr7, 0);
        long[] jArr20 = jArr5;
        M(jArr20, 0, jArr15, 0, jArr19, 0);
        M(jArr20, 0, jArr5, 0, D2, 0);
        long[] jArr21 = jArr6;
        M(jArr21, 0, jArr14, 0, jArr18, 0);
        A(jArr21, 0, jArr6, 0, jArr6, 0);
        Z(jArr8, 0, jArr4, 0, jArr3, 0);
        long[] jArr22 = jArr6;
        long[] jArr23 = jArr5;
        Z(jArr9, 0, jArr22, 0, jArr23, 0);
        A(jArr10, 0, jArr22, 0, jArr23, 0);
        A(jArr11, 0, jArr4, 0, jArr3, 0);
        M(jArr12, 0, jArr8, 0, jArr9, 0);
        M(jArr13, 0, jArr11, 0, jArr10, 0);
        M(jArr14, 0, jArr10, 0, jArr9, 0);
        M(jArr15, 0, jArr8, 0, jArr11, 0);
    }

    private static void cswap(long[][] jArr, long[][] jArr2, byte b) {
        for (int i = 0; i < 4; i++) {
            sel25519(jArr[i], 0, jArr2[i], 0, b);
        }
    }

    private static void pack(byte[] bArr, long[][] jArr) {
        long[] jArr2 = new long[16];
        long[] jArr3 = new long[16];
        long[] jArr4 = new long[16];
        inv25519(jArr4, 0, jArr[2], 0);
        long[] jArr5 = jArr4;
        M(jArr2, 0, jArr[0], 0, jArr5, 0);
        M(jArr3, 0, jArr[1], 0, jArr5, 0);
        pack25519(bArr, jArr3, 0);
        bArr[31] = (byte) (bArr[31] ^ (par25519(jArr2, 0) << 7));
    }

    private static void scalarmult(long[][] jArr, long[][] jArr2, byte[] bArr, int i) {
        long[] jArr3 = jArr[0];
        long[] jArr4 = gf0;
        set25519(jArr3, jArr4);
        long[] jArr5 = jArr[1];
        long[] jArr6 = gf1;
        set25519(jArr5, jArr6);
        set25519(jArr[2], jArr6);
        set25519(jArr[3], jArr4);
        for (int i2 = 255; i2 >= 0; i2--) {
            byte b = (byte) ((bArr[(i2 / 8) + i] >>> (i2 & 7)) & 1);
            cswap(jArr, jArr2, b);
            add(jArr2, jArr);
            add(jArr, jArr);
            cswap(jArr, jArr2, b);
        }
    }

    private static void scalarbase(long[][] jArr, byte[] bArr, int i) {
        long[] jArr2 = new long[16];
        long[][] jArr3 = {jArr2, new long[16], new long[16], new long[16]};
        long[] jArr4 = X;
        set25519(jArr2, jArr4);
        long[] jArr5 = jArr3[1];
        long[] jArr6 = Y;
        set25519(jArr5, jArr6);
        set25519(jArr3[2], gf1);
        M(jArr3[3], 0, jArr4, 0, jArr6, 0);
        scalarmult(jArr, jArr3, bArr, i);
    }

    public static int crypto_sign_keypair(byte[] bArr, byte[] bArr2, boolean z) {
        byte[] bArr3 = new byte[64];
        long[][] jArr = {new long[16], new long[16], new long[16], new long[16]};
        if (!z) {
            randombytes(bArr2, 32);
        }
        crypto_hash(bArr3, bArr2, 0, 32);
        bArr3[0] = (byte) (bArr3[0] & 248);
        byte b = (byte) (bArr3[31] & Byte.MAX_VALUE);
        bArr3[31] = b;
        bArr3[31] = (byte) (64 | b);
        scalarbase(jArr, bArr3, 0);
        pack(bArr, jArr);
        for (int i = 0; i < 32; i++) {
            bArr2[i + 32] = bArr[i];
        }
        return 0;
    }

    private static void modL(byte[] bArr, int i, long[] jArr) {
        long j;
        int i2 = 63;
        while (true) {
            j = 0;
            if (i2 < 32) {
                break;
            }
            int i3 = i2 - 32;
            long j2 = 0;
            int i4 = i3;
            while (i4 < i2 - 12) {
                long j3 = jArr[i4] + (j2 - ((jArr[i2] * 16) * L[i4 - i3]));
                jArr[i4] = j3;
                j2 = (128 + j3) >> 8;
                jArr[i4] = j3 - (j2 << 8);
                i4++;
            }
            jArr[i4] = jArr[i4] + j2;
            jArr[i2] = 0;
            i2--;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 32; i6++) {
            long j4 = jArr[i6] + (j - ((jArr[31] >> 4) * L[i6]));
            jArr[i6] = j4;
            j = j4 >> 8;
            jArr[i6] = 255 & j4;
        }
        for (int i7 = 0; i7 < 32; i7++) {
            jArr[i7] = jArr[i7] - (L[i7] * j);
        }
        while (i5 < 32) {
            int i8 = i5 + 1;
            jArr[i8] = jArr[i8] + (jArr[i5] >> 8);
            bArr[i5 + i] = (byte) ((int) (jArr[i5] & 255));
            i5 = i8;
        }
    }

    private static void reduce(byte[] bArr) {
        long[] jArr = new long[64];
        for (int i = 0; i < 64; i++) {
            jArr[i] = (long) (bArr[i] & 255);
        }
        for (int i2 = 0; i2 < 64; i2++) {
            bArr[i2] = 0;
        }
        modL(bArr, 0, jArr);
    }

    public static int crypto_sign(byte[] bArr, long j, byte[] bArr2, int i, int i2, byte[] bArr3) {
        byte[] bArr4 = bArr;
        int i3 = i2;
        byte[] bArr5 = bArr3;
        byte[] bArr6 = new byte[64];
        byte[] bArr7 = new byte[64];
        byte[] bArr8 = new byte[64];
        long[] jArr = new long[64];
        long[][] jArr2 = {new long[16], new long[16], new long[16], new long[16]};
        int i4 = 32;
        crypto_hash(bArr6, bArr5, 0, 32);
        bArr6[0] = (byte) (bArr6[0] & 248);
        byte b = (byte) (bArr6[31] & Byte.MAX_VALUE);
        bArr6[31] = b;
        bArr6[31] = (byte) (b | SignedBytes.MAX_POWER_OF_TWO);
        for (int i5 = 0; i5 < i3; i5++) {
            bArr4[i5 + 64] = bArr2[i5 + i];
        }
        for (int i6 = 0; i6 < 32; i6++) {
            int i7 = i6 + 32;
            bArr4[i7] = bArr6[i7];
        }
        crypto_hash(bArr8, bArr4, 32, i3 + 32);
        reduce(bArr8);
        scalarbase(jArr2, bArr8, 0);
        pack(bArr4, jArr2);
        for (int i8 = 0; i8 < 32; i8++) {
            int i9 = i8 + 32;
            bArr4[i9] = bArr5[i9];
        }
        crypto_hash(bArr7, bArr4, 0, i3 + 64);
        reduce(bArr7);
        for (int i10 = 0; i10 < 64; i10++) {
            jArr[i10] = 0;
        }
        for (int i11 = 0; i11 < 32; i11++) {
            jArr[i11] = (long) (bArr8[i11] & 255);
        }
        int i12 = 0;
        while (i12 < i4) {
            int i13 = 0;
            while (i13 < i4) {
                int i14 = i12 + i13;
                jArr[i14] = jArr[i14] + (((long) (bArr7[i12] & 255)) * ((long) (bArr6[i13] & 255)));
                i13++;
                i4 = 32;
            }
            i12++;
            i4 = 32;
        }
        modL(bArr4, 32, jArr);
        return 0;
    }

    private static int unpackneg(long[][] jArr, byte[] bArr) {
        long[] jArr2 = new long[16];
        long[] jArr3 = new long[16];
        long[] jArr4 = new long[16];
        long[] jArr5 = new long[16];
        long[] jArr6 = new long[16];
        long[] jArr7 = new long[16];
        long[] jArr8 = new long[16];
        set25519(jArr[2], gf1);
        unpack25519(jArr[1], bArr);
        S(jArr4, jArr[1]);
        M(jArr5, jArr4, D);
        Z(jArr4, jArr4, jArr[2]);
        A(jArr5, jArr[2], jArr5);
        S(jArr6, jArr5);
        S(jArr7, jArr6);
        M(jArr8, jArr7, jArr6);
        M(jArr2, jArr8, jArr4);
        M(jArr2, jArr2, jArr5);
        pow2523(jArr2, jArr2);
        M(jArr2, jArr2, jArr4);
        M(jArr2, jArr2, jArr5);
        M(jArr2, jArr2, jArr5);
        M(jArr[0], jArr2, jArr5);
        S(jArr3, jArr[0]);
        M(jArr3, jArr3, jArr5);
        if (neq25519(jArr3, jArr4) != 0) {
            long[] jArr9 = jArr[0];
            M(jArr9, jArr9, I);
        }
        S(jArr3, jArr[0]);
        M(jArr3, jArr3, jArr5);
        if (neq25519(jArr3, jArr4) != 0) {
            return -1;
        }
        if (par25519(jArr[0]) == ((bArr[31] & 255) >>> 7)) {
            long[] jArr10 = jArr[0];
            Z(jArr10, gf0, jArr10);
        }
        M(jArr[3], jArr[0], jArr[1]);
        return 0;
    }

    public static int crypto_sign_open(byte[] bArr, long j, byte[] bArr2, int i, int i2, byte[] bArr3) {
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        int i3 = i;
        int i4 = i2;
        byte[] bArr6 = bArr3;
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[64];
        long[][] jArr = {new long[16], new long[16], new long[16], new long[16]};
        long[][] jArr2 = {new long[16], new long[16], new long[16], new long[16]};
        if (i4 < 64 || unpackneg(jArr2, bArr6) != 0) {
            return -1;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            bArr4[i5] = bArr5[i5 + i3];
        }
        for (int i6 = 0; i6 < 32; i6++) {
            bArr4[i6 + 32] = bArr6[i6];
        }
        crypto_hash(bArr8, bArr4, 0, i4);
        reduce(bArr8);
        scalarmult(jArr, jArr2, bArr8, 0);
        scalarbase(jArr2, bArr5, i3 + 32);
        add(jArr, jArr2);
        pack(bArr7, jArr);
        return crypto_verify_32(bArr5, i3, bArr7, 0) != 0 ? -1 : 0;
    }

    public static byte[] randombytes(byte[] bArr) {
        jrandom.nextBytes(bArr);
        return bArr;
    }

    public static byte[] randombytes(int i) {
        return randombytes(new byte[i]);
    }

    public static byte[] randombytes(byte[] bArr, int i) {
        System.arraycopy(randombytes(i), 0, bArr, 0, i);
        return bArr;
    }

    public static byte[] makeBoxNonce() {
        return randombytes(24);
    }

    public static byte[] makeSecretBoxNonce() {
        return randombytes(24);
    }

    public static String hexEncodeToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append("0123456789ABCDEF".charAt((b & 240) >> 4));
            sb.append("0123456789ABCDEF".charAt(b & Ascii.SI));
        }
        return sb.toString();
    }

    public static byte[] hexDecode(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
