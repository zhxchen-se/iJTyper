package java.hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


public class hb2 {

        @Entity
        public static class University<Student> {
            private String address;
            @OneToMany(fetch = FetchType.LAZY)
            private List<Student> students;

        }
}
