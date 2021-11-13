package com.google.ads.mediation;

import com.google.android.gms.internal.jn;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public class e {

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String a();

        boolean b() default true;
    }

    public void a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            b bVar = (b) field.getAnnotation(b.class);
            if (bVar != null) {
                hashMap.put(bVar.a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            jn.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry next : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(next.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, next.getValue());
                } catch (IllegalAccessException e) {
                    String str = (String) next.getKey();
                    jn.e(new StringBuilder(String.valueOf(str).length() + 49).append("Server option \"").append(str).append("\" could not be set: Illegal Access").toString());
                } catch (IllegalArgumentException e2) {
                    String str2 = (String) next.getKey();
                    jn.e(new StringBuilder(String.valueOf(str2).length() + 43).append("Server option \"").append(str2).append("\" could not be set: Bad Type").toString());
                }
            } else {
                String str3 = (String) next.getKey();
                String str4 = (String) next.getValue();
                jn.b(new StringBuilder(String.valueOf(str3).length() + 31 + String.valueOf(str4).length()).append("Unexpected server option: ").append(str3).append(" = \"").append(str4).append("\"").toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((b) field3.getAnnotation(b.class)).b()) {
                String valueOf = String.valueOf(((b) field3.getAnnotation(b.class)).a());
                jn.e(valueOf.length() != 0 ? "Required server option missing: ".concat(valueOf) : new String("Required server option missing: "));
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(((b) field3.getAnnotation(b.class)).a());
            }
        }
        if (sb.length() > 0) {
            String valueOf2 = String.valueOf(sb.toString());
            throw new a(valueOf2.length() != 0 ? "Required server option(s) missing: ".concat(valueOf2) : new String("Required server option(s) missing: "));
        }
    }
}
