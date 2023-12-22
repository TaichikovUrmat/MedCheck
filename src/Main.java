import Models.*;
import Service.*;
import Service.Impl.DepartmentServiceImpl;
import Service.Impl.DoctorServiceImpl;
import Service.Impl.HospitalServiceImpl;
import Service.Impl.PatientServiceImpl;
import dao.Impl.DepartmentDaoImpl;
import dao.Impl.DoctorDaoImp;
import dao.Impl.HospitalDaoImpl;
import dao.Impl.PatientDaoImpl;
import db.DataBace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBace dataBace = new DataBace();
        HospitalDaoImpl hospitalDao = new HospitalDaoImpl(dataBace);
        HospitalService hossss = new HospitalServiceImpl(hospitalDao);

        DoctorDaoImp doctorDaoImp = new DoctorDaoImp(dataBace);
        DoctorService doctor = new DoctorServiceImpl(doctorDaoImp, hospitalDao);

        PatientDaoImpl patientDao = new PatientDaoImpl(dataBace);
        PatientService patientService = new PatientServiceImpl(patientDao, hospitalDao);

        DepartmentDaoImpl departmentDao = new DepartmentDaoImpl(dataBace);
        DepartmentService departmentService = new DepartmentServiceImpl(departmentDao, hospitalDao);


        ArrayList<Doctor> doctorArrayListt = new ArrayList<>(List.of(
                new Doctor("Urmat", "Taichikov", Genders.Male, 4),
                new Doctor("Jigit","Turumbekov",Genders.Male,2),
                new Doctor("Myrzaйym","Keldibrkova",Genders.Female,5)

        ));

        ArrayList<Department> departmentArrayList = new ArrayList<>(List.of(
                new Department("14-Чирургия болуму"),
                new Department("11-Кабыл алуу болуму"),
                new Department("10-Кан алуу болуму")
        ));
        ArrayList<Patient> patientArrayList = new ArrayList<>(List.of(
                new Patient("Mirlan", "Arstanov", 22, Genders.Male),
                new Patient("Ajybek","Sadykov",17,Genders.Male),
                new Patient("Nurlan","Abidilaev",19,Genders.Male),
                new Patient("Nurkamil","Kamchiev",22,Genders.Male)
        ));


        Hospital hosp = new Hospital("Бишкек город hospital", "Chyu");
        hossss.addHospital(hosp);
        doctorDaoImp.add(1L, doctorArrayListt);
        patientDao.add(1L, patientArrayList);

        Department department = new Department();
        department.setDepartmentName("Стамалотогия");

        Doctor doctor1 = new Doctor();
        doctor1.setFirsName("Samat");
        Patient patient = new Patient();
        patient.setFirsName("Kanat");


        System.out.println("""
                Hospital:                                                  Doctor:
                  1. addHospital(Hospital hospital);                           7. Doctor findDoctorById(Long id);
                  2. findHospitalById(Long id);                                8. String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId);
                  3. getAllHospital();                                         9. List<Doctor> getAllDoctorsByHospitalId(Long id);
                  4. getAllPatientFromHospital(Long id);                       10. List<Doctor> getAllDoctorsByDepartmentId(Long id);
                  5. deleteHospitalById(Long id);                              11. String add(Long  hospitalId, List<T> t);
                  6. getAllHospitalByAddress(String address);                  12. void removeById(Long id);
                                                                               13. String updateById(Long id, T t);  
                                                                               
                                                                               
                Patient:                                                   
                  14. add(Long hospitalId, List<Patient> t)                Department:                                                                      
                  15. void removeById(Long id)                                  21.getAllDepartmentByHospital(Long id);                                                                      
                  16. updateById(Long id, Patient patient)                      22.findDepartmentByName(String name);
                  17. addPatientsToHospital(Long id, List<Patient> patients);   23.add(Long  hospitalId, List<T> t);                                                                 
                  18. getPatientById(Long id);                                  24.removeById(Long id);
                  19. Map<Integer, Patient> getPatientByAge();                  25.updateById(Long id, T t);
                  20. List<Patient> sortPatientsByAge(String ascOrDesc);           
                  
                      
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
                          """);


        while (true) {
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> System.out.println(hossss.addHospital(hosp));
                case "2" -> System.out.println(hossss.findHospitalById(1L));
                case "3" -> System.out.println(hossss.getAllHospital());
                case "4" -> System.out.println(hossss.getAllPatientFromHospital(1L));
                case "5" -> hossss.deleteHospitalById(1L);
                case "6" -> System.out.println(hossss.getAllHospitalByAddress("Chyu"));
                case "7" -> System.out.println(doctor.findDoctorById(1L));
                case "8" -> System.out.println(doctor.assignDoctorToDepartment(1L, Collections.singletonList(1L)));
                case "9" -> System.out.println(doctor.getAllDoctorsByHospitalId(1L));
                case "10" -> System.out.println(doctor.getAllDoctorsByDepartmentId(1L));
                case "11" -> System.out.println(doctorDaoImp.add(1L, doctorArrayListt));
                case "12" -> doctorDaoImp.delete(1L);
                case "13"-> System.out.println(doctorDaoImp.updateById(1L,doctor1));
                case "14" -> System.out.println(patientDao.add(1L, patientArrayList));
                case "15" -> System.out.println(patientDao.delete(1L));
                case "16"-> System.out.println(patientDao.updateById(1L,patient));
                case "17" -> System.out.println(patientService.addPatientsToHospital(1L, patientArrayList));
                case "18" -> System.out.println(patientService.getPatientById(1L));
                case "19" -> System.out.println(patientService.getPatientByAge());
                case "20" -> System.out.println(patientService.sortPatientsByAge("asc"));
                case "21" -> System.out.println(departmentService.getAllDepartmentByHospital(1L));
                case "22" -> System.out.println(departmentService.findDepartmentByName("10-Кан алуу болуму"));
                case "23" -> System.out.println(departmentDao.add(1L, departmentArrayList));
                case "24" -> System.out.println(departmentDao.delete(1L));
                 case "25"->System.out.println(departmentDao.updateById(1L, department));
            }
        }
    }
}