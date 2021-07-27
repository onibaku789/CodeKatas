package codingdojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lift {
    private final String id;
    private final int floor;
    private final List<Integer> requests;
    private boolean doorsOpen;

    public Lift(String id, int floor, List<Integer> requests, boolean doorsOpen) {
        this.id = id;
        this.floor = floor;
        this.requests = requests;
        this.doorsOpen = doorsOpen;
    }

    public Lift(String id, int floor) {
        this(id, floor, new ArrayList<>(), false);
    }

    public Lift(String id, int floor, List<Integer> requests) {
        this(id, floor, requests, false);
    }

    public Lift(String id, int floor, boolean doorsOpen) {
        this(id, floor, new ArrayList<>(), doorsOpen);
    }
    public String getId() {
        return id;
    }
    public int getFloor() {
        return floor;
    }

    public boolean hasRequestForFloor(int floor) {
        return this.requests.contains(floor);
    }

    public boolean areDoorsOpen() {
        return doorsOpen;
    }

    public void openDoor(){
        doorsOpen = true;
    }

    public void closeDoor(){
        doorsOpen = false;
    }


}
