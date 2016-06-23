package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C0280d.C0688a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.e */
public final class C1057e<T> extends C0688a {
    private final T Mk;

    private C1057e(T t) {
        this.Mk = t;
    }

    public static <T> T m3259e(C0280d c0280d) {
        if (c0280d instanceof C1057e) {
            return ((C1057e) c0280d).Mk;
        }
        IBinder asBinder = c0280d.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static <T> C0280d m3260h(T t) {
        return new C1057e(t);
    }
}
