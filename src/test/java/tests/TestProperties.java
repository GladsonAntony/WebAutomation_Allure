package tests;

import org.testng.annotations.Test;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.File("./src/main/resources/environment.properties")
//@Resource.Classpath("${system.file.name}.path.${system.scope.value}.properties")
public class TestProperties 
{
	@Property("java.version")
	public String portName;
	
	@Property("Browser")
	public String Browser;

	public TestProperties() {
        PropertyLoader.newInstance()
                //.withPropertyProvider(new SysPropPathReplacerProvider())
                .populate(this);
    }
		
	
	@Test
	public void test1() throws Exception
	{
		System.out.println(portName);
		System.out.println(Browser);
	}
}
