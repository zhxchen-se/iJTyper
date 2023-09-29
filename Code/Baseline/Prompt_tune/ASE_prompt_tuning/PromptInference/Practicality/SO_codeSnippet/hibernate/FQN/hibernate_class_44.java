public class hibernate_class_44 extends org.apache.struts.actions.DispatchAction {
    public org.apache.struts.action.ActionForward add(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering Master add method");
        }
        try {
            // cargoForm cargoForm = (cargoForm) form;
            // System.out.println("ID" + cargoForm.getId());
            // cargo cargo = new cargo();
            // System.out.println("in cargo Action");
            // copy customerform to model
            // cargoForm.reset(mapping, request);
            // BeanUtils.copyProperties(cargo, cargoForm);
            // cargoForm.reset(mapping, request);
            // cargoForm.setInputParam("new");
            // updateFormBean(mapping, request, cargoForm);
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
            // cargoForm carForm = (cargoForm) form;
            // cargo cargo = new cargo();
            java.lang.System.out.println("in cargo Action");
            // BeanUtils.copyProperties();
            // System.out.println("id"+ carForm.getId());
            // System.out.println("item id"+ carForm.getItemid());
            // Set itemset = carForm.getItemDtl();
            // System.out.println("size"+itemset.size());
            // Iterator iterator =itemset.iterator();
            // while(iterator.hasNext()) {
            // Item it = (Item)iterator.next();
            // System.out.println("name"+it.getItemName()); //log.debug("HERE");
            // it.setCargo(cargo); }
            // cargo.setItemList(itemset);
            // System.out.println("size"+ itemset.size());
            // session.saveOrUpdate("cargo",cargo);
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
        // cargoForm cargoform = (cargoForm) form;
        // System.out.println("Name"+cargoForm.getName());
        // cargo cargo = new cargo();
        java.lang.System.out.println("in cargo search Action");
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
            org.hibernate.Query query = session.createQuery(SQL_QUERY);
            query.setParameter("name", name);
            query.setParameter("status", status);
            query.setParameter("createby", createby);
            java.util.ArrayList al = new java.util.ArrayList();
            for (java.util.Iterator i = query.iterate(); i.hasNext();) {
                // cargo cargo1 = (cargo) i.next();
                // al.add(cargo1);
                // System.out.println("Cargo ID is:" + cargo1.getId());
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
            // cargoForm carForm = (cargoForm) form;
            // System.out.println(carForm.getStatus());
            // System.out.println(carForm.getCreate());
            // cargo cargo = new cargo();
            // BeanUtils.copyProperties(cargo, carForm);
            // System.out.println("In Cargo Edit "+cargo.getId());
            java.lang.String qstring = "from cargo c where c.id=:id";
            org.hibernate.Query query = session.createQuery(qstring);
            // query.setParameter("id", cargo.getId());
            java.util.ArrayList all = new java.util.ArrayList();
            // cargo c = (cargo) query.iterate().next();
            java.lang.System.out.println("Edit Cargo list " + all.size());
            java.util.Set purchaseArray = new java.util.HashSet();
            // System.out.println("Edit"+c.getItemList().size());
            // carForm.setItemDtl(purchaseArray);
            // BeanUtils.copyProperties(carForm,c);
            // transaction.commit();
            session.flush();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        // return a forward to edit forward
        java.lang.System.out.println("Edit Cargo list is success");
        return mapping.findForward("succ");
    }

    public org.apache.struts.action.ActionForward delete(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception {
        try {
            org.hibernate.SessionFactory sessionFactory = ((org.hibernate.SessionFactory) (servlet.getServletContext().getAttribute("aaa")));
            org.hibernate.Session session = sessionFactory.openSession();
            org.hibernate.Transaction tx = session.beginTransaction();
            // cargoForm carForm = (cargoForm) form;
            // System.out.println(carForm.getStatus());
            // System.out.println(carForm.getCreate());
            // cargo cargo = new cargo();
            // BeanUtils.copyProperties(cargo, carForm);
            // System.out.println("In Cargo Delete "+cargo.getId());
            // String qstring = "delete from cargo c where c.id=:id";
            // Query query = session.createQuery(qstring);
            // session.delete("cargo",cargo);
            // session.delete(cargo);
            // session.flush();
            // query.setParameter("id", cargo.getId());
            // int row=query.executeUpdate();
            // System.out.println("deleted row"+row);
            tx.commit();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        // return a forward to edit forward
        java.lang.System.out.println("Deleted success");
        return mapping.findForward("succes");
    }
}

