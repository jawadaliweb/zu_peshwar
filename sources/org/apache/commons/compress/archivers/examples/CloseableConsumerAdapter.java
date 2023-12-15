package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;

final class CloseableConsumerAdapter implements Closeable {
    private Closeable closeable;
    private final CloseableConsumer consumer;

    CloseableConsumerAdapter(CloseableConsumer closeableConsumer) {
        Objects.requireNonNull(closeableConsumer, "consumer must not be null");
        this.consumer = closeableConsumer;
    }

    /* access modifiers changed from: package-private */
    public <C extends Closeable> C track(C c) {
        this.closeable = c;
        return c;
    }

    public void close() throws IOException {
        Closeable closeable2 = this.closeable;
        if (closeable2 != null) {
            this.consumer.accept(closeable2);
        }
    }
}
