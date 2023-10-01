public class hibernate_class_44 extends org.apache.struts.actions.DispatchAction {
    public org.apache.struts.action.ActionForward add(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering Master add method");
        }
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            return mapping.findForward("failure");
        }
        return mapping.findForward("success1");
    }

    public org.apache.struts.action.ActionForward save(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
        org.hibernate.SessionFactory sessionFactory = null;
        org.hibernate.Session session = null;
        java.lang.System.out.println("in cargo Action");
        try {
            sessionFactory = ((org.hibernate.SessionFactory) (servlet.getServletContext().getAttribute("aa")));
            session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            java.lang.System.out.println("in cargo Action");
            tx.commit();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return mapping.findForward("success");
    }

    public org.apache.struts.action.ActionForward search(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
        java.lang.System.out.println("in cargo search Action");
        org.hibernate.SessionFactory sessionFactory = ((org.hibernate.SessionFactory) (servlet.getServletContext().getAttribute("aaa")));
        javax.servlet.http.HttpSession session1 = request.getSession();
        org.hibernate.Session session = sessionFactory.openSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        java.lang.System.out.println("in cargo search Action");
        java.lang.String name = null;
        java.lang.String status = null;
        java.lang.String createby = null;
        try {
            java.lang.String SQL_QUERY = "createby";
            org.hibernate.Query query = session.createQuery(SQL_QUERY);
            query.setParameter("name", name);
            query.setParameter("status", status);
            query.setParameter("createby", createby);
            java.util.ArrayList al = new java.util.ArrayList();
            for (java.util.Iterator i = query.iterate(); i.hasNext();) {
            }
            java.lang.System.out.println("Cargo list is:" + al.size());
            session1.setAttribute("clist", al);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        java.lang.System.out.println("search Cargo list is success");
        return mapping.findForward("success");
    }

    public org.apache.struts.action.ActionForward edit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
        org.hibernate.SessionFactory sessionFactory = null;
        org.hibernate.Session session = null;
        if (log.isDebugEnabled()) {
            log.debug("Entering Master Edit method");
        }
        try {
            sessionFactory = ((org.hibernate.SessionFactory) (servlet.getServletContext().getAttribute("aa")));
            session = sessionFactory.openSession();
            org.hibernate.Transaction transaction = session.beginTransaction();
            java.lang.String qstring = "from cargo c where c.id=:id";
            org.hibernate.Query query = session.createQuery(qstring);
            java.util.ArrayList all = new java.util.ArrayList();
            java.lang.System.out.println("Edit Cargo list " + all.size());
            java.util.Set purchaseArray = new java.util.HashSet();
            session.flush();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        java.lang.System.out.println("Edit Cargo list is success");
        return mapping.findForward("succ");
    }

    public org.apache.struts.action.ActionForward delete(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
        try {
            org.hibernate.SessionFactory sessionFactory = ((org.hibernate.SessionFactory) (servlet.getServletContext().getAttribute("aaa")));
            org.hibernate.Session session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            tx.commit();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        java.lang.System.out.println("Deleted success");
        return mapping.findForward("succes");
    }
}

