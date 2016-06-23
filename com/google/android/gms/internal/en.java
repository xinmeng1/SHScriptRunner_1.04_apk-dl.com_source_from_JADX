package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class en {
    private static final ThreadFactory sh;
    private static final ThreadPoolExecutor si;

    /* renamed from: com.google.android.gms.internal.en.1 */
    static class C03381 implements Runnable {
        final /* synthetic */ Runnable sj;

        C03381(Runnable runnable) {
            this.sj = runnable;
        }

        public void run() {
            Process.setThreadPriority(10);
            this.sj.run();
        }
    }

    /* renamed from: com.google.android.gms.internal.en.2 */
    static class C03392 implements ThreadFactory {
        private final AtomicInteger sk;

        C03392() {
            this.sk = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.sk.getAndIncrement());
        }
    }

    static {
        sh = new C03392();
        si = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), sh);
    }

    public static void execute(Runnable task) {
        try {
            si.execute(new C03381(task));
        } catch (Throwable e) {
            eu.m1017c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), e);
        }
    }

    public static int getPoolSize() {
        return si.getPoolSize();
    }
}
