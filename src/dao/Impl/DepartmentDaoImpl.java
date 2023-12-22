package dao.Impl;

import Models.Department;
import Models.Doctor;
import Models.Hospital;
import dao.DaoGroup;
import db.DataBace;

import java.util.List;

public class DepartmentDaoImpl implements DaoGroup<Department,Long> {
    private final DataBace dataBace;

    public DepartmentDaoImpl(DataBace dataBace) {
        this.dataBace = dataBace;
    }

    @Override
    public boolean add(Long hospitalId, List<Department> departments) {
        for (Hospital hospital : dataBace.getHospitalList()) {
            if (hospital.getId() == hospitalId){
                hospital.setDepartments(departments);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        for (Hospital hospital : dataBace.getHospitalList()) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId() == id){
                   return hospital.getDepartments().remove(department);
                }
            }
        }
        return false;
    }

    @Override
    public String updateById(Long id, Department department) {
        String aa = "Стамалотогия";
        for (Hospital hospital : dataBace.getHospitalList()) {
            for (Department hospitalDepartment : hospital.getDepartments()) {
                if (id == hospitalDepartment.getId()){
                   hospitalDepartment.setDepartmentName(aa);
                }
            }

        }
       return "Almashty";
    }
    @Override
    public List<Department> getAll() {
        for (Hospital hospital : dataBace.getHospitalList()) {
            return hospital.getDepartments();
        }
        throw new RuntimeException(" Incorrect type");
    }
}
