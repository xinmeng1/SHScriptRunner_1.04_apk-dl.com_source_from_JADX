package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0217h;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final C0217h HF;
    private Contents HG;

    public CreateFileActivityBuilder() {
        this.HF = new C0217h(0);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        hm.m1228b(this.HG, (Object) "Must provide initial contents to CreateFileActivityBuilder.");
        try {
            this.HG.getParcelFileDescriptor().close();
        } catch (IOException e) {
        }
        this.HG.close();
        return this.HF.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.HF.m348a(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.HF.aM(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents) {
        this.HG = (Contents) hm.m1232f(contents);
        this.HF.aS(this.HG.getRequestId());
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.HF.m349a(metadataChangeSet);
        return this;
    }
}
