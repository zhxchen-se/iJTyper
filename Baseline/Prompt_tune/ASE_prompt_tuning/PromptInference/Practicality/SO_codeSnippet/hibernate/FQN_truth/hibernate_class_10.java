public class hibernate_class_10 implements java.io.Serializable {
    private java.lang.String providerId;

    private java.lang.String providerName;

    private static final long serialVersionUID = 81073;

    public static void load(org.hibernate.Session session, java.util.List<java.lang.String> values) {
        hibernate.hibernate_class_10 ProviderInfo = new hibernate.hibernate_class_10();
        ProviderInfo.setProviderId(values.get(0));
        ProviderInfo.setProviderName(values.get(1));
        session.save(ProviderInfo);
    }

    public java.lang.String getProviderName() {
        return providerName;
    }

    public void setProviderName(java.lang.String name) {
        this.providerName = name;
    }

    public java.lang.String getProviderId() {
        return this.providerId;
    }

    public void setProviderId(java.lang.String id) {
        this.providerId = id;
    }

    public static void main(java.lang.String[] args) {
    }
}

