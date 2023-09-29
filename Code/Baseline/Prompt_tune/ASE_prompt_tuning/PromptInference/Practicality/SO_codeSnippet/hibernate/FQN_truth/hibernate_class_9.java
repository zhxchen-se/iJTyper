public class hibernate_class_9 implements java.io.Serializable {
    private int patientId;

    private java.lang.String patientName;

    private java.lang.String providerId;


    private static final long serialVersionUID = 81073;

    public static void load(org.hibernate.Session session, java.util.List<java.lang.String> values) {
        hibernate.hibernate_class_9 PatientInfo = new hibernate.hibernate_class_9();
        PatientInfo.setPatientId(java.lang.Integer.parseInt(values.get(0)));
        PatientInfo.setPatientName(values.get(1));
        PatientInfo.setProviderId(values.get(2));
        session.save(PatientInfo);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int PatientId) {
        this.patientId = PatientId;
    }

    public java.lang.String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(java.lang.String PatientName) {
        this.patientName = PatientName;
    }

    public java.lang.String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(java.lang.String id) {
        this.providerId = id;
    }

    public java.lang.String getProvider() {
        return this.providerId;
    }

    public void setProvider(java.lang.String id) {
        this.providerId = id;
    }

    public static void main(java.lang.String[] args) {
    }
}

