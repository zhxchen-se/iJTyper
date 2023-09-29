public class JodaTime10 {
    // ...
    private java.lang.Object writeReplace() {
        return new jodatime.JodaTime10.Stub(null);
    }

    private static final class Stub implements java.io.Serializable {
        private static final long serialVersionUID = -6212696554273812441L;

        private transient org.joda.time.DateTimeZone iZone;

        Stub(org.joda.time.DateTimeZone zone) {
            iZone = zone;
        }

        private java.lang.Object readResolve() {
            return org.joda.time.chrono.ISOChronology.getInstance(iZone);
        }

        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            out.writeObject(iZone);
        }

        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
            iZone = ((org.joda.time.DateTimeZone) (in.readObject()));
        }
    }
}

