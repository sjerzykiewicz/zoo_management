package pl.edu.amu.wmi.s473615;

import java.io.FileNotFoundException;

public class IncorrectFileNameException extends FileNotFoundException {
    public IncorrectFileNameException(String errorMessage) {
        super(errorMessage);
    }
}
