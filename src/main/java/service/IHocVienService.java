package service;

import moduls.HocVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IHocVienService {
    HocVien save(HocVien hocVien);
    HocVien findById(int id);

    ArrayList<HocVien> findAll();

    ArrayList<HocVien> findAllByName(String name);

    Page<HocVien> findAll(Pageable pageable);

    void delete(HocVien hocVien);

    void edit(HocVien hocVien);

}
