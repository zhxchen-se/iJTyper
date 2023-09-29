public class hibernate_class_9 implements java.io.Serializable {
    private int patientId;

    private java.lang.String patientName;

    private java.lang.String providerId;// foreign key to provider


    private static final long serialVersionUID = 81073;

    public static void load(org.hibernate.Session session, java.util.List<java.lang.String> values) {
        hibernate_class_9 PatientInfo = new hibernate_class_9();
        PatientInfo.setPatientId(java.lang.Integer.parseInt(values.get(0)));
        PatientInfo.setPatientName(values.get(1));
        PatientInfo.setProviderId(values.get(2));
        session.save(PatientInfo);
    }

    /**
     *
     *
     * @return the PatientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     *
     *
     * @param PatientId
     * 		the PatientId to set
     */
    public void setPatientId(int PatientId) {
        this.patientId = PatientId;
    }

    /**
     *
     *
     * @return the PatientName
     */
    public java.lang.String getPatientName() {
        return this.patientName;
    }

    /**
     *
     *
     * @param PatientName
     * 		the PatientName to set
     */
    public void setPatientName(java.lang.String PatientName) {
        this.patientName = PatientName;
    }

    /**
     *
     *
     * @return the ProvId
     */
    public java.lang.String getProviderId() {
        return this.providerId;
    }

    /**
     *
     *
     * @param id
     * 		the ProviderId to set
     */
    public void setProviderId(java.lang.String id) {
        this.providerId = id;
    }

    /**
     *
     *
     * @return the ProvId
     */
    public java.lang.String getProvider() {
        return this.providerId;
    }

    /**
     *
     *
     * @param id
     * 		the ProviderId to set
     */
    public void setProvider(java.lang.String id) {
        this.providerId = id;
    }

    /**
     *
     *
     * @param args
     * 		
     */
    public static void main(java.lang.String[] args) {
        // TODO Auto-generated method stub
    }
}

