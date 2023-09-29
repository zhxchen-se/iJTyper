package jodatime;
//ID = 4268472
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

public class JodaTime10 {


	// ...
	    private Object writeReplace() {
	        return new Stub(null);
	    }

	    private static final class Stub implements Serializable {
	        private static final long serialVersionUID = -6212696554273812441L;

	        private transient DateTimeZone iZone;

	        Stub(DateTimeZone zone) {
	            iZone = zone;
	        }

	        private Object readResolve() {
	            return ISOChronology.getInstance(iZone);
	        }

	        private void writeObject(ObjectOutputStream out) throws IOException {
	            out.writeObject(iZone);
	        }

	        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	            iZone = (DateTimeZone)in.readObject();
	        }
	    }
}
