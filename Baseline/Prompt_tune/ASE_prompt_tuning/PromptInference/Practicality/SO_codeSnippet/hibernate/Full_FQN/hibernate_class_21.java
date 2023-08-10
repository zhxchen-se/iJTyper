public class hibernate_class_21 {
  public static void main(java.lang.String[] args) {
    org.hibernate.Session session = null;
    org.hibernate.SessionFactory sessionFactory = org.hibernate.cfg.Configuration.configure()###<unknown>.buildSessionFactory();
    session = org.hibernate.SessionFactory.openSession();
    org.hibernate.Transaction transaction = org.hibernate.Session.getTransaction();
    // BusinessCard card = new BusinessCard();
    // card.setId(1);
    // card.setName("zgr");
    // card.setDescription("Ac?klama");
    try {
      org.hibernate.Transaction.begin()
      org.hibernate.Transaction.commit()
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
    } finally {
      org.hibernate.Session.close()
    }
  }
}
