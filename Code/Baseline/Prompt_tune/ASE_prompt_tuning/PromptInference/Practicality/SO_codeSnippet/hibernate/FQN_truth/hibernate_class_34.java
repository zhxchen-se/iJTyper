public class hibernate_class_34 {
    public void testUserClassAndUsers() {
        java.lang.System.out.println("Testing Users and UserClasses...");
        org.hibernate.Session newSession = null;
        java.lang.System.out.println("1 - Creating UserClasses:");
        org.hibernate.Transaction t1 = newSession.beginTransaction();
        t1.commit();
        java.lang.System.out.println("2 - Creating Users:");
        org.hibernate.Transaction t2 = newSession.beginTransaction();
        t2.commit();
        java.lang.System.out.println("3 - Deleting UserClass (\"UserClass 1\"):");
        org.hibernate.Transaction t3 = newSession.beginTransaction();
        t3.commit();
        newSession.close();
    }

    public static void main(java.lang.String[] args) {
        hibernate.hibernate_class_34 instance = new hibernate.hibernate_class_34();
        instance.testUserClassAndUsers();
    }
}

