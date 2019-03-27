package tada.suzu;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testAnimal() {
        Animal dog = Animal.create("dog", 4, "aaa");
        assertEquals("dog", dog.name());
        assertEquals(4, dog.numberOfLegs());

        // You probably don't need to write assertions like these; just illustrating.
        assertTrue(Animal.create("dog", 4, "aaa").equals(dog));
        assertFalse(Animal.create("cat", 4, "aaa").equals(dog));
        assertFalse(Animal.create("dog", 2, "aaa").equals(dog));

        assertEquals("Animal{name=dog, numberOfLegs=4, aaa=aaa}", dog.toString());
    }
}
