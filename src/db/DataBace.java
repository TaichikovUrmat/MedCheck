package db;

import Models.Doctor;
import Models.Hospital;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataBace {
    private final ArrayList<Hospital> hospitalArrayList = new ArrayList<>();

    public boolean add(List<Hospital> hospitals) {
        return hospitalArrayList.addAll(hospitals);
    }


    public <T> boolean remove(T type) {
        if (type instanceof Hospital) {
            return hospitalArrayList.remove((Hospital) type);
        }
        throw new RuntimeException(" Incorrect type");
    }

    public List<Hospital> getHospitalList() {
        return hospitalArrayList;
    }
//   public ArrayList<Doctor> getDoctorList(){
//      return hospitalArrayList;
//   }


}
