package org.analyse.core.state;

public class AppState {
    private String fileName ;
    private String title ;

    public AppState() {
        this.fileName = "";
        this.title = "";
    }

    public AppState(AppState state ) {
        this.fileName = state.getFileName();
        this.title = state.getTitle();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEquals(AppState state ){

        try {
            if (!fileName.equals(state.getFileName())) return false;
            if (!title.equals(state.getTitle())) return false;
        }catch (Exception e) {
            return false;
        }
        
        return true ;
    }
}
