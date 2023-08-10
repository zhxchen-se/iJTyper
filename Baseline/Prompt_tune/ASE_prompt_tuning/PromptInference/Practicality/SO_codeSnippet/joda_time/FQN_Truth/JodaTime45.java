public class JodaTime45 {
    public class FastDateTimeZoneProvider implements javax.xml.ws.Provider {
        public final java.util.Set<java.lang.String> AVAILABLE_IDS = new java.util.HashSet<java.lang.String>();

        public org.joda.time.DateTimeZone getZone(java.lang.String id) {
            if (id == null) {
                return org.joda.time.DateTimeZone.UTC;
            }
            java.util.TimeZone tz = java.util.TimeZone.getTimeZone(id);
            if (tz == null) {
                return org.joda.time.DateTimeZone.UTC;
            }
            int rawOffset = tz.getRawOffset();
            if (tz.inDaylightTime(new java.util.Date())) {
                rawOffset += tz.getDSTSavings();
            }
            return org.joda.time.DateTimeZone.forOffsetMillis(rawOffset);
        }

        public java.util.Set getAvailableIDs() {
            return AVAILABLE_IDS;
        }

        @java.lang.Override
        public java.lang.Object invoke(java.lang.Object request) {
            return null;
        }
    }
}

