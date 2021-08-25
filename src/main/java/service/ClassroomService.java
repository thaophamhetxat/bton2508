package service;

import moduls.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IClassroomRepo;

import java.util.ArrayList;

public class ClassroomService implements IClassroomService{
    @Autowired
    IClassroomRepo iClassroomRepo;

    @Override
    public ArrayList<Classroom> showAllClassroom() {
        return (ArrayList<Classroom>) iClassroomRepo.findAll();
    }

    @Override
    public Classroom findbyId(int id) {
        return iClassroomRepo.findById(id).get();
    }
}
