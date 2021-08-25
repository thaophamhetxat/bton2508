package repository;

import moduls.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface IClassroomRepo extends CrudRepository<Classroom, Integer> {
}
