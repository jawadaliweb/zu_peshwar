package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class bj extends j implements bl {
    bj(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    public final void c(String str, List<Bundle> list, Bundle bundle, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bnVar);
        b(2, a);
    }

    public final void d(String str, int i, Bundle bundle, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        l.b(a, bundle);
        l.c(a, bnVar);
        b(4, a);
    }

    public final void e(String str, int i, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        l.c(a, bnVar);
        b(5, a);
    }

    public final void f(String str, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.c(a, bnVar);
        b(6, a);
    }

    public final void g(String str, List<Bundle> list, Bundle bundle, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bnVar);
        b(7, a);
    }

    public final void h(String str, List<Bundle> list, Bundle bundle, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bnVar);
        b(8, a);
    }

    public final void i(String str, List<Bundle> list, Bundle bundle, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bnVar);
        b(13, a);
    }

    public final void j(String str, List<Bundle> list, Bundle bundle, bn bnVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bnVar);
        b(14, a);
    }
}
