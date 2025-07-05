package org.analyse.core.state;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AppStateTest {

    private AppState state ;
    @Before
    public void setup(){
        state = new AppState();
    }

    @Parameterized.Parameters(name = "{index}: expected = {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "","","", "", true } ,
                {"","","","fileName", false},
                { "","","title", "", false },
                { "title","","title", "", true } ,
                { "title","file name","title", "file", false } ,
                { "title","file name","title", "file name", true } ,
        });
    }

    private final String fileName ;
    private final String title;

    private final String fileName2 ;
    private final String title2;

    private final boolean expected;
    public AppStateTest(String fileName , String title ,
                        String fileName2 , String title2,
                        boolean expected){
        this.fileName = fileName;
        this.title = title;
        this.fileName2 = fileName2;
        this.title2 = title2;
        this.expected = expected;
    }

    @Test
    public void isProjectFileEquals() {
        state.setTitle(title);
        state.setFileName(fileName);
        AppState newState = new AppState();
        newState.setTitle(title2);
        newState.setFileName(fileName2);


        assertEquals(state.isProjectFileEquals(newState), expected);
    }
}