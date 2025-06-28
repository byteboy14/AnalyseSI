package org.analyse.core.state;

public class AppStateManagement {

    private AppState state ;
    private static AppStateManagement instance = null ;

    private AppStateManagement() {
        state = new AppState();
    }


    public void saveState(AppState state ){
        instance = getInstance();
        instance.setState(state);
    }


    public static AppStateManagement getInstance() {
        if(instance == null ) {
            instance = getNewInstance();
        }

        return  instance;
    }

    public static AppStateManagement getNewInstance(){
        instance = new AppStateManagement();
        return instance;
    }



    protected void setState(AppState state ) {
        this.state = state ;
    }

    public AppState getState() {
        return state;
    }
}
