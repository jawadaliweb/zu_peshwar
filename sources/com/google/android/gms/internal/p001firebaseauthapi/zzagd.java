package com.google.android.gms.internal.p001firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public enum zzagd {
    DOUBLE(0, 1, zzagt.DOUBLE),
    FLOAT(1, 1, zzagt.FLOAT),
    INT64(2, 1, zzagt.LONG),
    UINT64(3, 1, zzagt.LONG),
    INT32(4, 1, zzagt.INT),
    FIXED64(5, 1, zzagt.LONG),
    FIXED32(6, 1, zzagt.INT),
    BOOL(7, 1, zzagt.BOOLEAN),
    STRING(8, 1, zzagt.STRING),
    MESSAGE(9, 1, zzagt.MESSAGE),
    BYTES(10, 1, zzagt.BYTE_STRING),
    UINT32(11, 1, zzagt.INT),
    ENUM(12, 1, zzagt.ENUM),
    SFIXED32(13, 1, zzagt.INT),
    SFIXED64(14, 1, zzagt.LONG),
    SINT32(15, 1, zzagt.INT),
    SINT64(16, 1, zzagt.LONG),
    GROUP(17, 1, zzagt.MESSAGE),
    DOUBLE_LIST(18, 2, zzagt.DOUBLE),
    FLOAT_LIST(19, 2, zzagt.FLOAT),
    INT64_LIST(20, 2, zzagt.LONG),
    UINT64_LIST(21, 2, zzagt.LONG),
    INT32_LIST(22, 2, zzagt.INT),
    FIXED64_LIST(23, 2, zzagt.LONG),
    FIXED32_LIST(24, 2, zzagt.INT),
    BOOL_LIST(25, 2, zzagt.BOOLEAN),
    STRING_LIST(26, 2, zzagt.STRING),
    MESSAGE_LIST(27, 2, zzagt.MESSAGE),
    BYTES_LIST(28, 2, zzagt.BYTE_STRING),
    UINT32_LIST(29, 2, zzagt.INT),
    ENUM_LIST(30, 2, zzagt.ENUM),
    SFIXED32_LIST(31, 2, zzagt.INT),
    SFIXED64_LIST(32, 2, zzagt.LONG),
    SINT32_LIST(33, 2, zzagt.INT),
    SINT64_LIST(34, 2, zzagt.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzagt.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzagt.FLOAT),
    INT64_LIST_PACKED(37, 3, zzagt.LONG),
    UINT64_LIST_PACKED(38, 3, zzagt.LONG),
    INT32_LIST_PACKED(39, 3, zzagt.INT),
    FIXED64_LIST_PACKED(40, 3, zzagt.LONG),
    FIXED32_LIST_PACKED(41, 3, zzagt.INT),
    BOOL_LIST_PACKED(42, 3, zzagt.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzagt.INT),
    ENUM_LIST_PACKED(44, 3, zzagt.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzagt.INT),
    SFIXED64_LIST_PACKED(46, 3, zzagt.LONG),
    SINT32_LIST_PACKED(47, 3, zzagt.INT),
    SINT64_LIST_PACKED(48, 3, zzagt.LONG),
    GROUP_LIST(49, 2, zzagt.MESSAGE),
    MAP(50, 4, zzagt.VOID);
    
    private static final zzagd[] zzZ = null;
    private final zzagt zzab;
    private final int zzac;
    private final Class zzad;

    static {
        int i;
        zzZ = new zzagd[r1];
        for (zzagd zzagd : values()) {
            zzZ[zzagd.zzac] = zzagd;
        }
    }

    private zzagd(int i, int i2, zzagt zzagt) {
        this.zzac = i;
        this.zzab = zzagt;
        zzagt zzagt2 = zzagt.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzagt.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzagt.zza();
        }
        if (i2 == 1) {
            zzagt.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
