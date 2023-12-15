package com.kbeanie.multipicker.utils;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamHelper {
    static final String TAG = "StreamHelper";

    public static void closeSilent(Closeable closeable) {
        try {
            close(closeable);
        } catch (PickerException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public static void close(Closeable closeable) throws PickerException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new PickerException(e);
            }
        }
    }

    public static void flush(OutputStream outputStream) throws PickerException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                throw new PickerException(e);
            }
        }
    }

    public static void verifyCursor(Uri uri, Cursor cursor) throws PickerException {
        if (cursor == null) {
            throw new PickerException("Didnt not get cursor in return for = " + uri);
        }
    }

    public static void verifyStream(String str, ParcelFileDescriptor parcelFileDescriptor) throws PickerException {
        if (parcelFileDescriptor == null) {
            throw new PickerException("Could not read file descriptor from file at path = " + str);
        }
    }

    public static void verifyStream(String str, InputStream inputStream) throws PickerException {
        if (inputStream == null) {
            throw new PickerException("Could not open stream to read path = " + str);
        }
    }

    public static void verifyBitmap(String str, Bitmap bitmap) throws PickerException {
        if (bitmap == null) {
            throw new PickerException("Could not read bitmap from this path = " + str);
        }
    }

    public static boolean isNonNull(Bitmap bitmap) {
        if (bitmap != null) {
            return true;
        }
        Log.w(TAG, "Bitmap is null. No good.");
        return false;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
