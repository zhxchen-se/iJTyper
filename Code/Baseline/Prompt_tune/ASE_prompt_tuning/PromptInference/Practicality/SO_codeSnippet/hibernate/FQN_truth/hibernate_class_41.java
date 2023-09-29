public class hibernate_class_41 {
    @java.lang.SuppressWarnings("null")
    public static org.hibernate.mapping.List list(java.lang.Class<?> className, int start, int limit, java.lang.String[] searchFilter) {
        org.hibernate.Session session = hibernate.HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            org.hibernate.Criteria criteria = session.createCriteria(className);
            criteria.setFirstResult(start);
            criteria.setMaxResults(limit);
            for (java.lang.String sf : searchFilter) {
                java.lang.String[] values = null;
                if (values == null) {
                    if (values.length == 1) {
                        criteria.add(org.hibernate.criterion.Restrictions.eq(sf, values[0]));
                    } else {
                        criteria.add(org.hibernate.criterion.Restrictions.in(sf, values));
                    }
                }
            }
            transaction.commit();
        } catch (java.lang.Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}

