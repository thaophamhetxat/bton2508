package repository;

import moduls.HocVien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;


public interface IHocVienRepo extends PagingAndSortingRepository<HocVien,Integer> {
    @Query(value = "select c from HocVien c where c.name like concat('%',:name,'%')")
    ArrayList<HocVien> findAllByName(@Param("name") String name);
}
