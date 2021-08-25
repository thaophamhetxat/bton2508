package service;

import moduls.Classroom;

import java.util.ArrayList;

public interface IClassroomService {
    ArrayList<Classroom> showAllClassroom();
    Classroom findbyId(int id);
}
