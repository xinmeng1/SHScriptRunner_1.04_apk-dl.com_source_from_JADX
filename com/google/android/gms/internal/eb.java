package com.google.android.gms.internal;

import com.google.android.gms.plus.PlusShare;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class eb {
    private final List<String> qS;
    private final List<String> qT;
    private final String qU;
    private final String qV;
    private final String qW;
    private final String qX;
    private final String qY;
    private final boolean qZ;
    private final int ra;

    public eb(Map<String, String> map) {
        this.qY = (String) map.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        this.qV = (String) map.get("base_uri");
        this.qW = (String) map.get("post_parameters");
        this.qZ = parseBoolean((String) map.get("drt_include"));
        this.qU = (String) map.get("activation_overlay_url");
        this.qT = m945t((String) map.get("check_packages"));
        this.ra = parseInt((String) map.get("request_id"));
        this.qX = (String) map.get("type");
        this.qS = m945t((String) map.get("errors"));
    }

    private static boolean parseBoolean(String bool) {
        return bool != null && (bool.equals("1") || bool.equals("true"));
    }

    private int parseInt(String i) {
        return i == null ? 0 : Integer.parseInt(i);
    }

    private List<String> m945t(String str) {
        return str == null ? null : Arrays.asList(str.split(","));
    }

    public boolean bA() {
        return this.qZ;
    }

    public List<String> by() {
        return this.qS;
    }

    public String bz() {
        return this.qW;
    }

    public String getType() {
        return this.qX;
    }

    public String getUrl() {
        return this.qY;
    }
}
