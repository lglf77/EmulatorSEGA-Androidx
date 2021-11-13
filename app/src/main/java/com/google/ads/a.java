package com.google.ads;

@Deprecated
public final class a {

    /* renamed from: com.google.ads.a$a  reason: collision with other inner class name */
    public enum C0012a {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String e;

        private C0012a(String str) {
            this.e = str;
        }

        public final String toString() {
            return this.e;
        }
    }

    public enum b {
        UNKNOWN,
        MALE,
        FEMALE
    }
}
