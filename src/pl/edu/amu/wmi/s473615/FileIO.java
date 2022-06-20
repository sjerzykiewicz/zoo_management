package pl.edu.amu.wmi.s473615;

import java.io.*;

public class FileIO {
    public ZooManagement readFile(String filepath) throws IncorrectFileNameException, Exception {
        File f = new File(filepath);
        if (f.isFile()) {
            FileInputStream fileInputStream = new FileInputStream(filepath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ZooManagement zooManagement = (ZooManagement) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            System.out.println("File read!\n");
            return zooManagement;
        }
        else {
            throw new IncorrectFileNameException("Incorrect filepath!");
        }
    }

    public void saveFile(String filepath, ZooManagement zooManagement) throws Exception{
        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(zooManagement);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("File saved!\n");
    }
}
