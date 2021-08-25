package service;

import moduls.HocVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import repository.IHocVienRepo;

import java.util.ArrayList;
@Transactional
public class HocVienService implements IHocVienService {
    @Autowired
    IHocVienRepo iHocVienRepo;

    @Override
    public HocVien save(HocVien hocVien) {
        return iHocVienRepo.save(hocVien);
    }

    @Override
    public HocVien findById(int id) {
        return iHocVienRepo.findById(id).get();
    }

    @Override
    public ArrayList<HocVien> findAll() {
        return (ArrayList<HocVien>) iHocVienRepo.findAll();
    }

    @Override
    public ArrayList<HocVien> findAllByName(String name) {
        return null;
    }

    @Override
    public Page<HocVien> findAll(Pageable pageable) {
        return iHocVienRepo.findAll(pageable);
    }

    @Override
    public void delete(HocVien hocVien) {
        iHocVienRepo.delete(hocVien);
    }

    @Override
    public void edit(HocVien hocVien) {
        iHocVienRepo.save(hocVien);
    }
}
