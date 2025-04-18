package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;

final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;

    DetectionResult(BarcodeMetadata barcodeMetadata2, BoundingBox boundingBox2) {
        this.barcodeMetadata = barcodeMetadata2;
        int columnCount = barcodeMetadata2.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox2;
        this.detectionResultColumns = new DetectionResultColumn[(columnCount + 2)];
    }

    /* access modifiers changed from: package-private */
    public DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int i = PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        while (true) {
            int adjustRowNumbers = adjustRowNumbers();
            if (adjustRowNumbers > 0 && adjustRowNumbers < i) {
                i = adjustRowNumbers;
            }
        }
        return this.detectionResultColumns;
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private int adjustRowNumbers() {
        int adjustRowNumbersByRow = adjustRowNumbersByRow();
        if (adjustRowNumbersByRow == 0) {
            return 0;
        }
        for (int i = 1; i < this.barcodeColumnCount + 1; i++) {
            Codeword[] codewords = this.detectionResultColumns[i].getCodewords();
            for (int i2 = 0; i2 < codewords.length; i2++) {
                if (codewords[i2] != null && !codewords[i2].hasValidRowNumber()) {
                    adjustRowNumbers(i, i2, codewords);
                }
            }
        }
        return adjustRowNumbersByRow;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[0] != null && detectionResultColumnArr[this.barcodeColumnCount + 1] != null) {
            Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
            Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
            for (int i = 0; i < codewords.length; i++) {
                if (!(codewords[i] == null || codewords2[i] == null || codewords[i].getRowNumber() != codewords2[i].getRowNumber())) {
                    for (int i2 = 1; i2 <= this.barcodeColumnCount; i2++) {
                        Codeword codeword = this.detectionResultColumns[i2].getCodewords()[i];
                        if (codeword != null) {
                            codeword.setRowNumber(codewords[i].getRowNumber());
                            if (!codeword.hasValidRowNumber()) {
                                this.detectionResultColumns[i2].getCodewords()[i] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromRRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i = this.barcodeColumnCount;
        if (detectionResultColumnArr[i + 1] == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumnArr[i + 1].getCodewords();
        int i2 = 0;
        for (int i3 = 0; i3 < codewords.length; i3++) {
            if (codewords[i3] != null) {
                int rowNumber = codewords[i3].getRowNumber();
                int i4 = 0;
                for (int i5 = this.barcodeColumnCount + 1; i5 > 0 && i4 < 2; i5--) {
                    Codeword codeword = this.detectionResultColumns[i5].getCodewords()[i3];
                    if (codeword != null) {
                        i4 = adjustRowNumberIfValid(rowNumber, i4, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    private int adjustRowNumbersFromLRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        if (detectionResultColumnArr[0] == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumnArr[0].getCodewords();
        int i = 0;
        for (int i2 = 0; i2 < codewords.length; i2++) {
            if (codewords[i2] != null) {
                int rowNumber = codewords[i2].getRowNumber();
                int i3 = 0;
                for (int i4 = 1; i4 < this.barcodeColumnCount + 1 && i3 < 2; i4++) {
                    Codeword codeword = this.detectionResultColumns[i4].getCodewords()[i2];
                    if (codeword != null) {
                        i3 = adjustRowNumberIfValid(rowNumber, i3, codeword);
                        if (!codeword.hasValidRowNumber()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    private static int adjustRowNumberIfValid(int i, int i2, Codeword codeword) {
        if (codeword == null || codeword.hasValidRowNumber()) {
            return i2;
        }
        if (!codeword.isValidRowNumber(i)) {
            return i2 + 1;
        }
        codeword.setRowNumber(i);
        return 0;
    }

    private void adjustRowNumbers(int i, int i2, Codeword[] codewordArr) {
        Codeword codeword = codewordArr[i2];
        Codeword[] codewords = this.detectionResultColumns[i - 1].getCodewords();
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i3 = i + 1;
        Codeword[] codewords2 = detectionResultColumnArr[i3] != null ? detectionResultColumnArr[i3].getCodewords() : codewords;
        Codeword[] codewordArr2 = new Codeword[14];
        codewordArr2[2] = codewords[i2];
        codewordArr2[3] = codewords2[i2];
        int i4 = 0;
        if (i2 > 0) {
            int i5 = i2 - 1;
            codewordArr2[0] = codewordArr[i5];
            codewordArr2[4] = codewords[i5];
            codewordArr2[5] = codewords2[i5];
        }
        if (i2 > 1) {
            int i6 = i2 - 2;
            codewordArr2[8] = codewordArr[i6];
            codewordArr2[10] = codewords[i6];
            codewordArr2[11] = codewords2[i6];
        }
        if (i2 < codewordArr.length - 1) {
            int i7 = i2 + 1;
            codewordArr2[1] = codewordArr[i7];
            codewordArr2[6] = codewords[i7];
            codewordArr2[7] = codewords2[i7];
        }
        if (i2 < codewordArr.length - 2) {
            int i8 = i2 + 2;
            codewordArr2[9] = codewordArr[i8];
            codewordArr2[12] = codewords[i8];
            codewordArr2[13] = codewords2[i8];
        }
        while (i4 < 14 && !adjustRowNumber(codeword, codewordArr2[i4])) {
            i4++;
        }
    }

    private static boolean adjustRowNumber(Codeword codeword, Codeword codeword2) {
        if (codeword2 == null || !codeword2.hasValidRowNumber() || codeword2.getBucket() != codeword.getBucket()) {
            return false;
        }
        codeword.setRowNumber(codeword2.getRowNumber());
        return true;
    }

    /* access modifiers changed from: package-private */
    public int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    /* access modifiers changed from: package-private */
    public int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    /* access modifiers changed from: package-private */
    public int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    /* access modifiers changed from: package-private */
    public void setBoundingBox(BoundingBox boundingBox2) {
        this.boundingBox = boundingBox2;
    }

    /* access modifiers changed from: package-private */
    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    /* access modifiers changed from: package-private */
    public void setDetectionResultColumn(int i, DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[i] = detectionResultColumn;
    }

    /* access modifiers changed from: package-private */
    public DetectionResultColumn getDetectionResultColumn(int i) {
        return this.detectionResultColumns[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        if (r1 != null) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008a, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008d, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r10 = this;
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r0 = r10.detectionResultColumns
            r1 = 0
            r2 = r0[r1]
            r3 = 1
            if (r2 != 0) goto L_0x000d
            int r2 = r10.barcodeColumnCount
            int r2 = r2 + r3
            r2 = r0[r2]
        L_0x000d:
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r4 = 0
        L_0x0013:
            com.google.zxing.pdf417.decoder.Codeword[] r5 = r2.getCodewords()     // Catch:{ all -> 0x007c }
            int r5 = r5.length     // Catch:{ all -> 0x007c }
            if (r4 >= r5) goto L_0x0074
            java.lang.String r5 = "CW %3d:"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x007c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007c }
            r6[r1] = r7     // Catch:{ all -> 0x007c }
            r0.format(r5, r6)     // Catch:{ all -> 0x007c }
            r5 = 0
        L_0x0028:
            int r6 = r10.barcodeColumnCount     // Catch:{ all -> 0x007c }
            r7 = 2
            int r6 = r6 + r7
            if (r5 >= r6) goto L_0x006a
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r6 = r10.detectionResultColumns     // Catch:{ all -> 0x007c }
            r8 = r6[r5]     // Catch:{ all -> 0x007c }
            java.lang.String r9 = "    |   "
            if (r8 != 0) goto L_0x003c
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007c }
            r0.format(r9, r6)     // Catch:{ all -> 0x007c }
            goto L_0x0067
        L_0x003c:
            r6 = r6[r5]     // Catch:{ all -> 0x007c }
            com.google.zxing.pdf417.decoder.Codeword[] r6 = r6.getCodewords()     // Catch:{ all -> 0x007c }
            r6 = r6[r4]     // Catch:{ all -> 0x007c }
            if (r6 != 0) goto L_0x004c
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007c }
            r0.format(r9, r6)     // Catch:{ all -> 0x007c }
            goto L_0x0067
        L_0x004c:
            java.lang.String r8 = " %3d|%3d"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x007c }
            int r9 = r6.getRowNumber()     // Catch:{ all -> 0x007c }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x007c }
            r7[r1] = r9     // Catch:{ all -> 0x007c }
            int r6 = r6.getValue()     // Catch:{ all -> 0x007c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x007c }
            r7[r3] = r6     // Catch:{ all -> 0x007c }
            r0.format(r8, r7)     // Catch:{ all -> 0x007c }
        L_0x0067:
            int r5 = r5 + 1
            goto L_0x0028
        L_0x006a:
            java.lang.String r5 = "%n"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007c }
            r0.format(r5, r6)     // Catch:{ all -> 0x007c }
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0074:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x007c }
            r0.close()
            return r1
        L_0x007c:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x007e }
        L_0x007e:
            r2 = move-exception
            if (r1 == 0) goto L_0x008a
            r0.close()     // Catch:{ all -> 0x0085 }
            goto L_0x008d
        L_0x0085:
            r0 = move-exception
            r1.addSuppressed(r0)
            goto L_0x008d
        L_0x008a:
            r0.close()
        L_0x008d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DetectionResult.toString():java.lang.String");
    }
}
