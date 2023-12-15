package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.microsoft.appcenter.http.DefaultHttpClient;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.0.0 */
public final class zzabo {
    public static void zza(String str, zzabl zzabl, Type type, zzaau zzaau) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(60000);
            zzaau.zza(httpURLConnection);
            zzc(httpURLConnection, zzabl, type);
        } catch (SocketTimeoutException unused) {
            zzabl.zza("TIMEOUT");
        } catch (UnknownHostException unused2) {
            zzabl.zza("<<Network Error>>");
        } catch (IOException e) {
            zzabl.zza(e.getMessage());
        }
    }

    public static void zzb(String str, zzaaq zzaaq, zzabl zzabl, Type type, zzaau zzaau) {
        BufferedOutputStream bufferedOutputStream;
        try {
            Preconditions.checkNotNull(zzaaq);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zzaaq.zza().getBytes(Charset.defaultCharset());
            int length = bytes.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty(DefaultHttpClient.CONTENT_TYPE_KEY, "application/json");
            httpURLConnection.setConnectTimeout(60000);
            zzaau.zza(httpURLConnection);
            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), length);
            bufferedOutputStream.write(bytes, 0, length);
            bufferedOutputStream.close();
            zzc(httpURLConnection, zzabl, type);
            return;
        } catch (SocketTimeoutException unused) {
            zzabl.zza("TIMEOUT");
            return;
        } catch (UnknownHostException unused2) {
            zzabl.zza("<<Network Error>>");
            return;
        } catch (IOException | NullPointerException | JSONException e) {
            zzabl.zza(e.getMessage());
            return;
        } catch (Throwable th) {
            zzabn.zza(th, th);
        }
        throw th;
    }

    private static void zzc(HttpURLConnection httpURLConnection, zzabl zzabl, Type type) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (zzd(responseCode)) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            String sb2 = sb.toString();
            if (!zzd(responseCode)) {
                zzabl.zza((String) zzaap.zza(sb2, String.class));
            } else {
                zzabl.zzb((zzaar) zzaap.zza(sb2, type));
            }
            httpURLConnection.disconnect();
            return;
        } catch (SocketTimeoutException unused) {
            zzabl.zza("TIMEOUT");
            httpURLConnection.disconnect();
            return;
        } catch (zzyi | IOException e) {
            try {
                zzabl.zza(e.getMessage());
                return;
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th) {
            zzabn.zza(th, th);
        }
        throw th;
    }

    private static final boolean zzd(int i) {
        return i >= 200 && i < 300;
    }
}
