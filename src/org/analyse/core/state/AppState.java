package org.analyse.core.state;

public class AppState {
    private String fileName ;
    private String title ;
    private String currentPanel ; // name of the panel type

    public AppState() {
        this.fileName = "";
        this.title = "";
        this.currentPanel = "";
    }

    public AppState(AppState state ) {
        this.fileName = state.getFileName();
        this.title = state.getTitle();
        this.currentPanel = state.getCurrentPanel();
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

    public String getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(Object panel) {
        this.currentPanel = panel.getClass().getSimpleName();
    }

    public boolean isProjectFileEquals(AppState state ){

        try {
            if (!fileName.equals(state.getFileName())) return false;
            if (!title.equals(state.getTitle())) return false;
        }catch (Exception e) {
            return false;
        }
        
        return true ;
    }
}
