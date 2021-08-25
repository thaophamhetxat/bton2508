package moduls;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idClass;
    String nameClass;

    public Classroom() {
    }

    public Classroom(int idClass, String nameClass) {
        this.idClass = idClass;
        this.nameClass = nameClass;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
