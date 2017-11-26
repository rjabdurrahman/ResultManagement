package resultmanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student{
    private SimpleIntegerProperty roll;
    private SimpleStringProperty name;
    public Student(Integer roll, String name){
        this.roll = new SimpleIntegerProperty(roll);
        this.name = new SimpleStringProperty(name);
    }
    public Integer getRoll(){
        return roll.get();
    }
    public String getName(){
        return name.get();
    }
    //Sutudent Class
}