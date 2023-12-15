package com.google.android.play.core.internal;

import android.content.res.AssetManager;
import com.google.android.play.core.splitcompat.a;
import java.io.File;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class au {
    private final a a;
    private XmlPullParser b;

    public au(a aVar) {
        this.a = aVar;
    }

    public final void a(AssetManager assetManager, File file) throws IOException {
        this.b = assetManager.openXmlResourceParser(a.c(assetManager, file), "AndroidManifest.xml");
    }

    public final long b() throws IOException, XmlPullParserException {
        if (this.b != null) {
            while (true) {
                int next = this.b.next();
                if (next != 2) {
                    if (next == 1) {
                        break;
                    }
                } else if (this.b.getName().equals("manifest")) {
                    String attributeValue = this.b.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode");
                    String attributeValue2 = this.b.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCodeMajor");
                    if (attributeValue != null) {
                        try {
                            int parseInt = Integer.parseInt(attributeValue);
                            if (attributeValue2 == null) {
                                return (long) parseInt;
                            }
                            try {
                                return (((long) Integer.parseInt(attributeValue2)) << 32) | (((long) parseInt) & 4294967295L);
                            } catch (NumberFormatException e) {
                                throw new XmlPullParserException(String.format("Couldn't parse versionCodeMajor to int: %s", new Object[]{e.getMessage()}));
                            }
                        } catch (NumberFormatException e2) {
                            throw new XmlPullParserException(String.format("Couldn't parse versionCode to int: %s", new Object[]{e2.getMessage()}));
                        }
                    } else {
                        throw new XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
                    }
                }
            }
            throw new XmlPullParserException("Couldn't find manifest entry at top-level.");
        }
        throw new XmlPullParserException("Manifest file needs to be loaded before parsing.");
    }
}
