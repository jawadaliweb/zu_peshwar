package com.kbeanie.multipicker.api;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.kbeanie.multipicker.api.callbacks.ContactPickerCallback;
import com.kbeanie.multipicker.api.entity.ChosenContact;
import com.kbeanie.multipicker.api.exceptions.PickerException;
import com.kbeanie.multipicker.core.PickerManager;
import com.kbeanie.multipicker.utils.LogUtils;

public class ContactPicker extends PickerManager {
    private static final String TAG = "ContactPicker";
    private ContactPickerCallback callback;

    public ContactPicker(Activity activity) {
        super(activity, (int) Picker.PICK_CONTACT);
    }

    public ContactPicker(Fragment fragment) {
        super(fragment, (int) Picker.PICK_CONTACT);
    }

    public ContactPicker(android.app.Fragment fragment) {
        super(fragment, (int) Picker.PICK_CONTACT);
    }

    public void setContactPickerCallback(ContactPickerCallback contactPickerCallback) {
        this.callback = contactPickerCallback;
    }

    public void pickContact() {
        try {
            checkPermission();
            pick();
        } catch (PickerException e) {
            e.printStackTrace();
            ContactPickerCallback contactPickerCallback = this.callback;
            if (contactPickerCallback != null) {
                contactPickerCallback.onError(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public String pick() throws PickerException {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/contact");
        if (this.extras != null) {
            intent.putExtras(this.extras);
        }
        pickInternal(intent, Picker.PICK_CONTACT);
        return null;
    }

    public void submit(Intent intent) {
        if (intent != null && intent.getData() != null && (intent.getData() instanceof Uri)) {
            Uri data = intent.getData();
            String str = TAG;
            LogUtils.d(str, "submit: " + data);
            queryForContact(data);
        }
    }

    private int getRawContactId(int i) {
        String[] strArr = {i + ""};
        Cursor query = getContext().getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id"}, "contact_id = ?", strArr, (String) null);
        int i2 = -1;
        if (query != null && query.getCount() > 0) {
            if (query.moveToFirst()) {
                i2 = query.getInt(query.getColumnIndexOrThrow("_id"));
            }
            query.close();
        }
        return i2;
    }

    private void queryForContact(Uri uri) {
        int i;
        ChosenContact chosenContact = new ChosenContact();
        chosenContact.setRequestId(this.requestId);
        Cursor query = getContext().getContentResolver().query(uri, new String[]{"display_name", "photo_uri", "_id"}, (String) null, (String[]) null, (String) null);
        if (query.moveToFirst()) {
            i = query.getInt(query.getColumnIndexOrThrow("_id"));
            String string = query.getString(query.getColumnIndexOrThrow("display_name"));
            String string2 = query.getString(query.getColumnIndexOrThrow("photo_uri"));
            chosenContact.setDisplayName(string);
            chosenContact.setPhotoUri(string2);
        } else {
            i = 0;
        }
        int rawContactId = getRawContactId(i);
        if (rawContactId != -1) {
            Cursor query2 = getContext().getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{"mimetype", "data1"}, "raw_contact_id = ?", new String[]{rawContactId + ""}, (String) null);
            while (query2.moveToNext()) {
                try {
                    String string3 = query2.getString(0);
                    String string4 = query2.getString(1);
                    if (string3.equals("vnd.android.cursor.item/name")) {
                        chosenContact.setDisplayName(string4);
                    }
                    if (string3.equals("vnd.android.cursor.item/phone_v2")) {
                        chosenContact.addPhone(string4);
                    }
                    if (string3.equals("vnd.android.cursor.item/email_v2")) {
                        chosenContact.addEmail(string4);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    query2.close();
                    throw th;
                }
            }
            query2.close();
            query.close();
            try {
                ContactPickerCallback contactPickerCallback = this.callback;
                if (contactPickerCallback != null) {
                    contactPickerCallback.onContactChosen(chosenContact);
                }
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        } else {
            this.callback.onError("Contact Not found - Error - Please report to developer");
        }
    }

    private void checkPermission() {
        boolean z = getContext().checkCallingOrSelfPermission("android.permission.READ_CONTACTS") == 0;
        String str = TAG;
        LogUtils.d(str, "checkIfPermissionsAvailable: In Manifest(READ_CONTACTS): " + z);
        if (!z) {
            Log.e(str, "android.permission.READ_CONTACTS permission is missing in manifest file");
            throw new RuntimeException("Permissions missing in Manifest");
        }
    }
}
