package com.google.zxing.datamatrix.encoder;

import org.apache.commons.compress.archivers.tar.TarConstants;

final class DataMatrixSymbolInfo144 extends SymbolInfo {
    public int getDataLengthForInterleavedBlock(int i) {
        if (i <= 8) {
            return 156;
        }
        return TarConstants.PREFIXLEN;
    }

    public int getInterleavedBlockCount() {
        return 10;
    }

    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }
}
