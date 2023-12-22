package Service.Impl;

import Models.Hospital;
import Models.Patient;
import Service.HospitalService;
import dao.Impl.HospitalDaoImpl;
import db.DataBace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HospitalServiceImpl implements HospitalService {
    DataBace dataBace = new DataBace();
    private final HospitalDaoImpl hospitalDao;

    public HospitalServiceImpl(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {
        hospitalDao.getAll().add(hospital);
        return  "Saktaldy ";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getId() == id) {
                return hospital;
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAll();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for (Hospital hospital : hospitalDao.getAll()) {
            for (Patient patient : hospital.getPatients()) {
                if (id == patient.getId()){
                  return   hospital.getPatients();
                }
            }
        }
        throw new RuntimeException(" Incorrect id");
    }

    @Override
    public String deleteHospitalById(Long id) {
        hospitalDao.delete(id);
        return  " ochty";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital> map = new HashMap<>();
        for (Hospital hospital : hospitalDao.getAll()) {
            if (hospital.getAddress().equals(address)){
              map.put(address,hospital);
//                System.out.println(map);
            }
        }
        return map;
    }
}
