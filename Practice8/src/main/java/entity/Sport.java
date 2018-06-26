package entity;

import java.util.ArrayList;
import java.util.List;

public class Sport {

    private int countOfVoices;
    private List<String> users;

    public Sport() {
        countOfVoices = 0;
        users = new ArrayList<>();
    }

    public int getCountOfVoices() {
        return countOfVoices;
    }

    public void setCountOfVoices(int countOfVoices) {
        this.countOfVoices = countOfVoices;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
