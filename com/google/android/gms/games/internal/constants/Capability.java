package com.google.android.gms.games.internal.constants;

import java.util.ArrayList;

public class Capability {
    public static final ArrayList<String> Ri;

    static {
        Ri = new ArrayList();
        Ri.add("ibb");
        Ri.add("rtp");
        Ri.add("unreliable_ping");
    }
}
