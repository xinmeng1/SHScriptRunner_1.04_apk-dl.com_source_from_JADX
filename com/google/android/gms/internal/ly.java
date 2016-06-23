package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.wearable.DataEvent;
import java.io.IOException;

public final class ly {
    private int amN;
    private int amO;
    private int amP;
    private int amQ;
    private int amR;
    private int amS;
    private int amT;
    private int amU;
    private int amV;
    private final byte[] buffer;

    private ly(byte[] bArr, int i, int i2) {
        this.amS = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.amU = 64;
        this.amV = 67108864;
        this.buffer = bArr;
        this.amN = i;
        this.amO = i + i2;
        this.amQ = i;
    }

    public static long m1369A(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static ly m1370a(byte[] bArr, int i, int i2) {
        return new ly(bArr, i, i2);
    }

    public static int ew(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    private void nM() {
        this.amO += this.amP;
        int i = this.amO;
        if (i > this.amS) {
            this.amP = i - this.amS;
            this.amO -= this.amP;
            return;
        }
        this.amP = 0;
    }

    public static ly m1371p(byte[] bArr) {
        return m1370a(bArr, 0, bArr.length);
    }

    public void m1372a(me meVar) throws IOException {
        int nI = nI();
        if (this.amT >= this.amU) {
            throw md.nY();
        }
        nI = ex(nI);
        this.amT++;
        meVar.m1430b(this);
        eu(0);
        this.amT--;
        ey(nI);
    }

    public void m1373a(me meVar, int i) throws IOException {
        if (this.amT >= this.amU) {
            throw md.nY();
        }
        this.amT++;
        meVar.m1430b(this);
        eu(mh.m1436u(i, 4));
        this.amT--;
    }

    public byte[] eA(int i) throws IOException {
        if (i < 0) {
            throw md.nT();
        } else if (this.amQ + i > this.amS) {
            eB(this.amS - this.amQ);
            throw md.nS();
        } else if (i <= this.amO - this.amQ) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.amQ, obj, 0, i);
            this.amQ += i;
            return obj;
        } else {
            throw md.nS();
        }
    }

    public void eB(int i) throws IOException {
        if (i < 0) {
            throw md.nT();
        } else if (this.amQ + i > this.amS) {
            eB(this.amS - this.amQ);
            throw md.nS();
        } else if (i <= this.amO - this.amQ) {
            this.amQ += i;
        } else {
            throw md.nS();
        }
    }

    public void eu(int i) throws md {
        if (this.amR != i) {
            throw md.nW();
        }
    }

    public boolean ev(int i) throws IOException {
        switch (mh.eN(i)) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                nE();
                return true;
            case DataEvent.TYPE_CHANGED /*1*/:
                nL();
                return true;
            case DataEvent.TYPE_DELETED /*2*/:
                eB(nI());
                return true;
            case DetectedActivity.STILL /*3*/:
                nC();
                eu(mh.m1436u(mh.eO(i), 4));
                return true;
            case DetectedActivity.UNKNOWN /*4*/:
                return false;
            case DetectedActivity.TILTING /*5*/:
                nK();
                return true;
            default:
                throw md.nX();
        }
    }

    public int ex(int i) throws md {
        if (i < 0) {
            throw md.nT();
        }
        int i2 = this.amQ + i;
        int i3 = this.amS;
        if (i2 > i3) {
            throw md.nS();
        }
        this.amS = i2;
        nM();
        return i3;
    }

    public void ey(int i) {
        this.amS = i;
        nM();
    }

    public void ez(int i) {
        if (i > this.amQ - this.amN) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.amQ - this.amN));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.amQ = this.amN + i;
        }
    }

    public int getPosition() {
        return this.amQ - this.amN;
    }

    public int nB() throws IOException {
        if (nO()) {
            this.amR = 0;
            return 0;
        }
        this.amR = nI();
        if (this.amR != 0) {
            return this.amR;
        }
        throw md.nV();
    }

    public void nC() throws IOException {
        int nB;
        do {
            nB = nB();
            if (nB == 0) {
                return;
            }
        } while (ev(nB));
    }

    public long nD() throws IOException {
        return nJ();
    }

    public int nE() throws IOException {
        return nI();
    }

    public boolean nF() throws IOException {
        return nI() != 0;
    }

    public int nG() throws IOException {
        return ew(nI());
    }

    public long nH() throws IOException {
        return m1369A(nJ());
    }

    public int nI() throws IOException {
        byte nP = nP();
        if (nP >= null) {
            return nP;
        }
        int i = nP & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte nP2 = nP();
        if (nP2 >= null) {
            return i | (nP2 << 7);
        }
        i |= (nP2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        nP2 = nP();
        if (nP2 >= null) {
            return i | (nP2 << 14);
        }
        i |= (nP2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        nP2 = nP();
        if (nP2 >= null) {
            return i | (nP2 << 21);
        }
        i |= (nP2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        nP2 = nP();
        i |= nP2 << 28;
        if (nP2 >= null) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (nP() >= null) {
                return i;
            }
        }
        throw md.nU();
    }

    public long nJ() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte nP = nP();
            j |= ((long) (nP & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((nP & TransportMediator.FLAG_KEY_MEDIA_NEXT) == 0) {
                return j;
            }
        }
        throw md.nU();
    }

    public int nK() throws IOException {
        return (((nP() & MotionEventCompat.ACTION_MASK) | ((nP() & MotionEventCompat.ACTION_MASK) << 8)) | ((nP() & MotionEventCompat.ACTION_MASK) << 16)) | ((nP() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long nL() throws IOException {
        byte nP = nP();
        byte nP2 = nP();
        return ((((((((((long) nP2) & 255) << 8) | (((long) nP) & 255)) | ((((long) nP()) & 255) << 16)) | ((((long) nP()) & 255) << 24)) | ((((long) nP()) & 255) << 32)) | ((((long) nP()) & 255) << 40)) | ((((long) nP()) & 255) << 48)) | ((((long) nP()) & 255) << 56);
    }

    public int nN() {
        if (this.amS == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            return -1;
        }
        return this.amS - this.amQ;
    }

    public boolean nO() {
        return this.amQ == this.amO;
    }

    public byte nP() throws IOException {
        if (this.amQ == this.amO) {
            throw md.nS();
        }
        byte[] bArr = this.buffer;
        int i = this.amQ;
        this.amQ = i + 1;
        return bArr[i];
    }

    public byte[] m1374o(int i, int i2) {
        if (i2 == 0) {
            return mh.ank;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.amN + i, obj, 0, i2);
        return obj;
    }

    public byte[] readBytes() throws IOException {
        int nI = nI();
        if (nI > this.amO - this.amQ || nI <= 0) {
            return eA(nI);
        }
        Object obj = new byte[nI];
        System.arraycopy(this.buffer, this.amQ, obj, 0, nI);
        this.amQ = nI + this.amQ;
        return obj;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(nL());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(nK());
    }

    public String readString() throws IOException {
        int nI = nI();
        if (nI > this.amO - this.amQ || nI <= 0) {
            return new String(eA(nI), "UTF-8");
        }
        String str = new String(this.buffer, this.amQ, nI, "UTF-8");
        this.amQ = nI + this.amQ;
        return str;
    }
}
