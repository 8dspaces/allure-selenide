import org.testng.ITest;
import org.testng.annotations.*;
import util.SetTestName;
import util.TestNameSetter;

import java.lang.reflect.Method;

public class TestTest implements ITest//extends TestNameSetter
{
    private  ThreadLocal<String> param = new ThreadLocal<>();
    //private String param;
    private String name;

    //private String newTestName = "";

    @Factory( dataProvider = "prov" )
    public TestTest( String name,String param)
    {
        System.out.println( "[" + Thread.currentThread().getId() +  "] factory" );
        this.param.set(param);
        this.name = name;
        System.out.println( "[" + Thread.currentThread().getId() +  "] factory" +this.param.get());
    }


//    public String getTestName() {
//        return newTestName ;
//    }

//    public void setTestName(String name){
//        this.name = name;
//    }

    @Override
    public String getTestName() {
        return this.param.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        this.param.set(this.param.get() + " " + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
        this.param.set(this.param.get().substring(0,
                this.param.get().length() - method.getName().length() - 1));
    }
//    @BeforeMethod(alwaysRun=true)
//    public void getTheNameFromParemeters(Method method, Object [] parameters){
//        SetTestName setTestName = method.getAnnotation(SetTestName.class);
//        String testCaseName = "AAA";//(String) parameters[setTestName.idx()];
//        setTestName(this.name + "-" + testCaseName);
//
//        System.out.print(method.getName());
//    }

    @DataProvider( name = "prov")
    public static Object[][] dataProvider()
    {
        System.out.println( "[" + Thread.currentThread().getId() +  "] Provide data" );
        return new Object[][] {
                { "One", "Case-One" },
                { "Two", "Case-Two" },
                { "Three", "Case-Three" },
        };
    }

    @BeforeClass
    public void prepare()
    {
        System.out.println( "[" + Thread.currentThread().getId() +  "] Prepare " + this.param.get() );
    }

    @Test
    public void test1()
    {
        System.out.println( "[" + Thread.currentThread().getId() +  "] Test1 " + this.param.get()  );
    }


    @Test( dependsOnMethods = "test1" )
    public void test2()
    {
        System.out.println( "[" + Thread.currentThread().getId() +  "] Test2 " + this.param.get()  );
        sleep();
    }

    @AfterClass
    public void clean()
    {
        System.out.println( "[" + Thread.currentThread().getId() +  "] Clean " + this.param.get()  );
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {}
    }
}