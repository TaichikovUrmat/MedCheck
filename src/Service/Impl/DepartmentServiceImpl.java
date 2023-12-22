package Service.Impl;

import Models.Department;
import Models.Doctor;
import Models.Hospital;
import Service.DepartmentService;
import Service.GenericService;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.HospitalDaoImpl;
import db.DataBace;

import java.util.List;

public class DepartmentServiceImpl implements GenericService<Department>, DepartmentService {
    DataBace dataBace;
    private final DepartmentDaoImpl departmentDao;
    private final HospitalDaoImpl hospitalDao;

    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao, HospitalDaoImpl hospitalDao) {
        this.departmentDao = departmentDao;
        this.hospitalDao = hospitalDao;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getId() == id){
                return hospital.getDepartments();
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital hospital : hospitalDao.getAll()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getDepartmentName().equals(name)) {
                    return department;
                }
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public String add(Long hospitalId, List<Department> departmentList) {
        departmentDao.add(hospitalId,departmentList);
      return "asadd" ;
    }

    @Override
    public void removeById(Long id) {
        departmentDao.delete(id);
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public String updateById(Long id, Department department) {
           departmentDao.updateById(id,department);

        return " almashcan jok";
    }
}
