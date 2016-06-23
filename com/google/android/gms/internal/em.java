package com.google.android.gms.internal;

public abstract class em {
    private final Runnable lg;
    private volatile Thread sf;

    /* renamed from: com.google.android.gms.internal.em.1 */
    class C03371 implements Runnable {
        final /* synthetic */ em sg;

        C03371(em emVar) {
            this.sg = emVar;
        }

        public final void run() {
            this.sg.sf = Thread.currentThread();
            this.sg.bh();
        }
    }

    public em() {
        this.lg = new C03371(this);
    }

    public abstract void bh();

    public final void cancel() {
        onStop();
        if (this.sf != null) {
            this.sf.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        en.execute(this.lg);
    }
}
