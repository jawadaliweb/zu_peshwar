package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
final class zzahr {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzahp zzahp, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzahp, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            zzc(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzaiq.zza(new zzafc(((String) obj).getBytes(zzagq.zzb))));
                sb.append(Typography.quote);
            } else if (obj instanceof zzaff) {
                sb.append(": \"");
                sb.append(zzaiq.zza((zzaff) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzagk) {
                sb.append(" {");
                zzd((zzagk) obj, sb, i + 2);
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i3 = i + 2;
                zzb(sb, i3, "key", entry.getKey());
                zzb(sb, i3, "value", entry.getValue());
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzahp zzahp, StringBuilder sb, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zzahp zzahp2 = zzahp;
        StringBuilder sb2 = sb;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzahp.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 4), zzagk.zzD(method2, zzahp2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 3), zzagk.zzD(method, zzahp2, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzD = zzagk.zzD(method4, zzahp2, new Object[0]);
                    if (method5 == null) {
                        if (zzD instanceof Boolean) {
                            if (!((Boolean) zzD).booleanValue()) {
                            }
                        } else if (zzD instanceof Integer) {
                            if (((Integer) zzD).intValue() == 0) {
                            }
                        } else if (zzD instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzD).floatValue()) == 0) {
                            }
                        } else if (!(zzD instanceof Double)) {
                            if (zzD instanceof String) {
                                z = zzD.equals("");
                            } else if (zzD instanceof zzaff) {
                                z = zzD.equals(zzaff.zzb);
                            } else if (zzD instanceof zzahp) {
                                if (zzD == ((zzahp) zzD).zzM()) {
                                }
                            } else if ((zzD instanceof Enum) && ((Enum) zzD).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzD).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzagk.zzD(method5, zzahp2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i3, substring, zzD);
                }
            }
            i2 = 3;
        }
        if (!(zzahp2 instanceof zzagh)) {
            zzaiw zzaiw = ((zzagk) zzahp2).zzc;
            if (zzaiw != null) {
                zzaiw.zzi(sb2, i3);
                return;
            }
            return;
        }
        zzagc zzagc = ((zzagh) zzahp2).zzb;
        throw null;
    }
}
