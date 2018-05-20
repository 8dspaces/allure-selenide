import com.beust.jcommander.JCommander;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class RunHelper {

    public static void main(String[] args) {
//        CommandLineOptions options = new CommandLineOptions();
//        JCommander jCommander = new JCommander(options, args);

        XmlSuite suite = new XmlSuite();
        suite.setName("MyTestSuite");
//        suite.setParameters(options.convertToMap());
        suite.setGroupByInstances(true);


        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("TestTest"));

        XmlTest test = new XmlTest(suite);
        test.setName("MyTests");
        test.setXmlClasses(classes);

        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);

        TestNG testNG = new TestNG();
        testNG.setXmlSuites(suites);
        testNG.run();
    }

}
