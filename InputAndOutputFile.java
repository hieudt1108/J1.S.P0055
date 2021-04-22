
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducth
 */
public class InputAndOutputFile {
    public static void writeFile(ArrayList<Doctor> doctor){
        try{
            FileOutputStream fileO = new FileOutputStream("data.txt");
            ObjectOutputStream outStream = new ObjectOutputStream(fileO);
            outStream.writeObject(doctor);
            fileO.close();
        }catch(IOException e){
            System.out.println("Error file");
        }
    }
    public static ArrayList<Doctor> readFile() {       // doc theo Object
        ArrayList<Doctor> doctor =new ArrayList<>();
        try {   // dat try cacth de tranh ngoai le khi tao va doc File
            FileInputStream f = new FileInputStream("data.txt"); // tao file f tro den student.dat
            ObjectInputStream inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
            // dung inStream doc theo Object, ep kieu tra ve la Student
            doctor = (ArrayList<Doctor>) inStream.readObject();
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            return doctor;
            
        }
        return doctor;
    }
}
