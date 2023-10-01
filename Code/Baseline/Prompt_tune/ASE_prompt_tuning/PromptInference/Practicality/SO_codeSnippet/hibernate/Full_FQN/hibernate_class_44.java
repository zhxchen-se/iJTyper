public class hibernate_class_44 extends org.apache.struts.actions.DispatchAction {
  public org.apache.struts.action.ActionForward add(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
    if (log.isDebugEnabled()) {
      log.debug(java.lang.String)
    }
    try {
      // cargoForm cargoForm = (cargoForm) form;
      // System.out.println("ID" + cargoForm.getId());
      // cargo cargo = new cargo();
      // System.out.println("in cargo Action");
      // // copy customerform to model
      // cargoForm.reset(mapping, request);
      // BeanUtils.copyProperties(cargo, cargoForm);
      // cargoForm.reset(mapping, request);
      // cargoForm.setInputParam("new");
      // updateFormBean(mapping, request, cargoForm);
    } catch (java.lang.Exception ex) {
      java.lang.Throwable.printStackTrace()
      return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
    }
    return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
  }

  public org.apache.struts.action.ActionForward save(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
    org.hibernate.SessionFactory sessionFactory = null;
    org.hibernate.Session session = null;
    java.io.PrintStream.println(java.lang.String)
    try {
      sessionFactory = servlet.getServletContext()###<unknown>.getAttribute(java.lang.String);
      session = org.hibernate.SessionFactory.openSession();
      org.hibernate.Transaction tx = org.hibernate.Session.beginTransaction();
      java.io.PrintStream.println(java.lang.String)
      org.hibernate.Transaction.commit()
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
    }
    return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
  }

  public org.apache.struts.action.ActionForward search(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
    java.io.PrintStream.println(java.lang.String)
    org.hibernate.SessionFactory sessionFactory = servlet.getServletContext()###<unknown>.getAttribute(java.lang.String);
    javax.servlet.http.HttpSession session1 = javax.servlet.http.HttpServletRequest.getSession();
    org.hibernate.Session session = org.hibernate.SessionFactory.openSession();
    org.hibernate.Transaction tx = org.hibernate.Session.beginTransaction();
    java.io.PrintStream.println(java.lang.String)
    // copy customerform to model
    // BeanUtils.copyProperties(cargo, cargoform);
    java.lang.String name = null;
    java.lang.String status = null;
    java.lang.String createby = null;
    // System.out.println("Name..." + name);
    // System.out.println("status..." + status);
    // System.out.println("createby..." + createby);
    try {
      // if ((name.equals("")) && (createby.equals(""))
      // && (status.equals("")))
      java.lang.String SQL_QUERY = "createby";
      org.hibernate.Query query = org.hibernate.Session.createQuery(java.lang.String);
      org.hibernate.Query.setParameter(java.lang.String,java.lang.String)
      org.hibernate.Query.setParameter(java.lang.String,java.lang.String)
      org.hibernate.Query.setParameter(java.lang.String,java.lang.String)
      java.util.ArrayList al = new java.util.ArrayList();
      for (java.util.Iterator i = org.hibernate.Query.iterate(); java.util.Iterator.hasNext();) {
        // cargo cargo1 = (cargo) i.next();
        // al.add(cargo1);
        // System.out.println("Cargo ID is:" + cargo1.getId());
      }
      java.io.PrintStream.println(java.lang.String)
      javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object)
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
      return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
    }
    java.io.PrintStream.println(java.lang.String)
    return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
  }

  public org.apache.struts.action.ActionForward edit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
    org.hibernate.SessionFactory sessionFactory = null;
    org.hibernate.Session session = null;
    if (log.isDebugEnabled()) {
      log.debug(java.lang.String)
    }
    try {
      sessionFactory = servlet.getServletContext()###<unknown>.getAttribute(java.lang.String);
      session = org.hibernate.SessionFactory.openSession();
      org.hibernate.Transaction transaction = org.hibernate.Session.beginTransaction();
      // cargoForm carForm = (cargoForm) form;
      // System.out.println(carForm.getStatus());
      // System.out.println(carForm.getCreate());
      // cargo cargo = new cargo();
      // BeanUtils.copyProperties(cargo, carForm);
      // System.out.println("In Cargo Edit "+cargo.getId());
      java.lang.String qstring = "from cargo c where c.id=:id";
      org.hibernate.Query query = org.hibernate.Session.createQuery(java.lang.String);
      // query.setParameter("id", cargo.getId());
      java.util.ArrayList all = new java.util.ArrayList();
      java.io.PrintStream.println(java.lang.String)
      java.util.Set purchaseArray = new java.util.HashSet();
      org.hibernate.Session.flush()
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
      return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
    }
    java.io.PrintStream.println(java.lang.String)
    return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
  }

  public org.apache.struts.action.ActionForward delete(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
    try {
      org.hibernate.SessionFactory sessionFactory = servlet.getServletContext()###<unknown>.getAttribute(java.lang.String);
      org.hibernate.Session session = org.hibernate.SessionFactory.openSession();
      org.hibernate.Transaction tx = org.hibernate.Session.beginTransaction();
      org.hibernate.Transaction.commit()
    } catch (java.lang.Exception e) {
      java.lang.Throwable.printStackTrace()
      return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
    }
    java.io.PrintStream.println(java.lang.String)
    return org.apache.struts.action.ActionMapping.findForward(java.lang.String);
  }
}
