public class hibernate_class_10 implements java.io.Serializable {
    private java.lang.String providerId;

    private java.lang.String providerName;

    // private int patientId;
    // private int providerSpec;
    private static final long serialVersionUID = 81073;

    public static void load(org.hibernate.Session session, java.util.List<java.lang.String> values) {
        hibernate_class_10 ProviderInfo = new hibernate_class_10();
        ProviderInfo.setProviderId(values.get(0));
        ProviderInfo.setProviderName(values.get(1));
        // ProviderInfo.setProviderSpec( Integer.parseInt(values.get(2)) );
        session.save(ProviderInfo);
    }

    /**
     *
     *
     * @return the ProviderName
     */
    public java.lang.String getProviderName() {
        return providerName;
    }

    /**
     *
     *
     * @param ProviderName
     * 		the ProviderName to set
     */
    public void setProviderName(java.lang.String name) {
        this.providerName = name;
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
     * 		the ProvId to set
     */
    public void setProviderId(java.lang.String id) {
        this.providerId = id;
    }

    /* public int getPatientId() {
    return this.patientId;
    }

    public void setPatientId( int id ) {
    this.patientId = id;
    }
     */
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

