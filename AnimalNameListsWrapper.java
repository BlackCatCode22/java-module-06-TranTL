package tran.zoo.com;

import java.util.ArrayList;

public class AnimalNameListsWrapper {
    private final ArrayList<String> hyenaNameList;
    private final ArrayList<String> lionNameList;
    private final ArrayList<String> tigerNameList;
    private final ArrayList<String> bearNameList;

    public AnimalNameListsWrapper(ArrayList<String> hyenaNameList, ArrayList<String> lionNameList, ArrayList<String> tigerNameList, ArrayList<String> bearNameList) {
        this.hyenaNameList = hyenaNameList;
        this.lionNameList = lionNameList;
        this.tigerNameList = tigerNameList;
        this.bearNameList = bearNameList;
    }

    // Getters for each list
    public ArrayList<String> getHyenaNameList() {
        return hyenaNameList;
    }

    public ArrayList<String> getLionNameList() {
        return lionNameList;
    }

    public ArrayList<String> getTigerNameList() {
        return tigerNameList;
    }

    public ArrayList<String> getBearNameList() {
        return bearNameList;
    }
}