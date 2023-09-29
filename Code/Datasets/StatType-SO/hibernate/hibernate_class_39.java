
//ID = 3573479
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.GenericDao;
import org.appfuse.dao.SearchException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
public class hibernate_class_39 {
@Transactional
@SuppressWarnings("unchecked")
public class GenericDaoImpl<T, ID extends Serializable> implements
  GenericDao<T, ID> {
 private SessionFactory sessionFactory;

 public void setSessionFactory(final SessionFactory sessionFactory) {
  this.sessionFactory = sessionFactory;
 }

 public ID create(final T newInstance) {
  ID id = null;
  final Session session = sessionFactory.openSession();
  final Transaction tx = session.beginTransaction();
  try {
   id = (ID) session.save(newInstance);
   tx.commit();
   session.close();
  } catch (final Exception e) {
   if (tx != null) {
    tx.rollback();
   }
   e.printStackTrace();
  } finally {
   if (session.isOpen()) {
    session.close();
   }
  }
  return id;
 }

 public T read(final ID primaryKey) {
  T id = null;
  final Session session = sessionFactory.openSession();
  final Transaction tx = session.beginTransaction();
  try {
   id = (T) session.get("aaa", primaryKey);
   tx.commit();
   session.close();
  } catch (final Exception e) {
   if (tx != null) {
    tx.rollback();
   }
   e.printStackTrace();
  } finally {
   if (session.isOpen()) {
    session.close();
   }
  }
  return id;
 }

 public void update(final T transientObject) {
  final Session session = sessionFactory.openSession();
  final Transaction tx = session.beginTransaction();
  try {
   session.saveOrUpdate(transientObject);
   tx.commit();
   session.close();
  } catch (final Exception e) {
   if (tx != null) {
    tx.rollback();
   }
   e.printStackTrace();
  } finally {
   if (session.isOpen()) {
    session.close();
   }
  }
 }

 public void delete(final T persistentObject) {
  final Session session = sessionFactory.openSession();
  final Transaction tx = session.beginTransaction();
  try {
   session.delete(persistentObject);
   tx.commit();
   session.close();
  } catch (final Exception e) {
   if (tx != null) {
    tx.rollback();
   }
   e.printStackTrace();
  } finally {
   if (session.isOpen()) {
    session.close();
   }
  }
 }

@Override
public boolean exists(ID arg0) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public List<T> findByNamedQuery(String arg0, Map<String, Object> arg1) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public T get(ID arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<T> getAll() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<T> getAllDistinct() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void reindex() {
	// TODO Auto-generated method stub
	
}

@Override
public void reindexAll(boolean arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void remove(T arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void remove(ID arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public T save(T arg0) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<T> search(String arg0) throws SearchException {
	// TODO Auto-generated method stub
	return null;
}
}
}
