package org.analyse.core.state;

public class AppState {
    private String fileName ;

    public AppState() {
        this.fileName = "";
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
