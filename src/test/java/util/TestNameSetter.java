package util;

import org.testng.ITest;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestNameSetter implements ITest {
    private String newTestName = "";

    public void setTestName(String newTestName){
        this.newTestName = newTestName;
    }

    public String getTestName() {

        return newTestName;
    }


//    @BeforeMethod(alwaysRun=true)
//    public void getTheNameFromParemeters(Method method, Object [] parameters){
//        SetTestName setTestName = method.getAnnotation(SetTestName.class);
//        String testCaseName = (String) parameters[setTestName.idx()];
//        setTestName(testCaseName);
//    }


}