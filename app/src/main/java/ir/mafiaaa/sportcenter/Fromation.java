package ir.mafiaaa.sportcenter;

import java.util.HashMap;
import java.util.List;


public class Fromation {

    public HashMap<Integer, String> form_352;

    public HashMap<Integer, String> form_433;

    public HashMap<Integer, String> form_442;

    public HashMap<Integer, String> form_532;

    public Fromation(){

        form_352 = new HashMap<>();
        form_352.put(1,"دروازه بان");
        form_352.put(2,"مدافع");
        form_352.put(3,"مدافع");
        form_352.put(4,"مدافع");
        form_352.put(5,"هافبک");
        form_352.put(6,"هافبک");
        form_352.put(7,"هافبک");
        form_352.put(8,"هافبک");
        form_352.put(9,"هافبک");
        form_352.put(10,"مهاجم");
        form_352.put(11,"مهاجم");

        form_433 = new HashMap<>();
        form_433.put(1,"دروازه بان");
        form_433.put(2,"مدافع");
        form_433.put(3,"مدافع");
        form_433.put(4,"مدافع");
        form_433.put(5,"مدافع");
        form_433.put(6,"هافبک");
        form_433.put(7,"هافبک");
        form_433.put(8,"هافبک");
        form_433.put(9,"مهاجم");
        form_433.put(10,"مهاجم");
        form_433.put(11,"مهاجم");

        form_442 = new HashMap<>();
        form_442.put(1,"دروازه بان");
        form_442.put(2,"مدافع");
        form_442.put(3,"مدافع");
        form_442.put(4,"مدافع");
        form_442.put(5,"مدافع");
        form_442.put(6,"هافبک");
        form_442.put(7,"هافبک");
        form_442.put(8,"هافبک");
        form_442.put(9,"هافبک");
        form_442.put(10,"مهاجم");
        form_442.put(11,"مهاجم");

        form_532 = new HashMap<>();
        form_532.put(1,"دروازه بان");
        form_532.put(2,"مدافع");
        form_532.put(3,"مدافع");
        form_532.put(4,"مدافع");
        form_532.put(5,"مدافع");
        form_532.put(6,"مدافع");
        form_532.put(7,"هافبک");
        form_532.put(8,"هافبک");
        form_532.put(9,"هافبک");
        form_442.put(10,"مهاجم");
        form_442.put(11,"مهاجم");
    }


    public HashMap<Integer, String> build(HashMap<Integer, String> form, List<String> playersName){

        for (int i=0; i<11; i++){
            form.put(i,playersName.get(i));
        }

        return form;
    }
}