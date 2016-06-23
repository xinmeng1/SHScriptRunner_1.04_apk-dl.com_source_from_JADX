package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.C0279c.C0686a;

/* renamed from: com.google.android.gms.dynamic.h */
public final class C1058h extends C0686a {
    private Fragment FV;

    private C1058h(Fragment fragment) {
        this.FV = fragment;
    }

    public static C1058h m3261a(Fragment fragment) {
        return fragment != null ? new C1058h(fragment) : null;
    }

    public void m3262c(C0280d c0280d) {
        this.FV.registerForContextMenu((View) C1057e.m3259e(c0280d));
    }

    public void m3263d(C0280d c0280d) {
        this.FV.unregisterForContextMenu((View) C1057e.m3259e(c0280d));
    }

    public C0280d gI() {
        return C1057e.m3260h(this.FV.getActivity());
    }

    public C0279c gJ() {
        return C1058h.m3261a(this.FV.getParentFragment());
    }

    public C0280d gK() {
        return C1057e.m3260h(this.FV.getResources());
    }

    public C0279c gL() {
        return C1058h.m3261a(this.FV.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.FV.getArguments();
    }

    public int getId() {
        return this.FV.getId();
    }

    public boolean getRetainInstance() {
        return this.FV.getRetainInstance();
    }

    public String getTag() {
        return this.FV.getTag();
    }

    public int getTargetRequestCode() {
        return this.FV.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.FV.getUserVisibleHint();
    }

    public C0280d getView() {
        return C1057e.m3260h(this.FV.getView());
    }

    public boolean isAdded() {
        return this.FV.isAdded();
    }

    public boolean isDetached() {
        return this.FV.isDetached();
    }

    public boolean isHidden() {
        return this.FV.isHidden();
    }

    public boolean isInLayout() {
        return this.FV.isInLayout();
    }

    public boolean isRemoving() {
        return this.FV.isRemoving();
    }

    public boolean isResumed() {
        return this.FV.isResumed();
    }

    public boolean isVisible() {
        return this.FV.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.FV.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.FV.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.FV.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.FV.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.FV.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.FV.startActivityForResult(intent, requestCode);
    }
}
