package org.analyse.core.state;

public class AppStateManagement {

    private AppState state ;
    private static AppStateManagement instance = null ;

    protected AppStateManagement() {
        state = new AppState();
    }


    public void saveState(AppState state ,
                          AppStateListener listener ){
        if(!instance.getStateCopy().isEquals(state)){
            listener.onStateChange(state);
            instance.saveState(state);
        }

    }

    public void saveState(AppState state){
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

    public AppState getStateCopy() {
        return new AppState(state);
    }

    @FunctionalInterface
    public interface AppStateListener {
        void onStateChange(AppState state );
    }
}


