package _exercise.p02_ExtendedDatabase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Person PAV = new Person(1, "Pav");
    private static final Person DI = new Person(2, "Di");
    private static final Person BIBI = new Person(3, "Bibi");
    private Database database;

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(PAV, DI, BIBI);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithMoreThan16Elements() throws OperationNotSupportedException {
        Person[] bigArray = new Person[17];
        new Database(bigArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowWithLessThan1Element() throws OperationNotSupportedException {
        Person[] emptyArray = new Person[0];
        new Database(emptyArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullShouldThrow() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddPersonInDB() throws OperationNotSupportedException {

        Person ivan = new Person(4, "Ivan");
        database.add(ivan);
        Person[] dbPersons = database.getElements();
        assertEquals("Ivan", dbPersons[3].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromOutOfBoundsShouldThrow() throws OperationNotSupportedException {
        Person[] personArr = database.getElements();

        for (int i = 0; i < personArr.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemovePersonFromDb() throws OperationNotSupportedException {
        Person[] arrBeforeRemove = database.getElements();
        database.remove();
        Person[] arrAfterRemove = database.getElements();
        assertEquals("Di", arrAfterRemove[1].getUsername());
        assertEquals(arrBeforeRemove.length - 1, arrAfterRemove.length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameButNoUserIsPresentShouldThrow() throws OperationNotSupportedException {
        database.findByUsername("Ivan");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUserNameNullShouldThrow() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("Pav");
        assertEquals(PAV, person);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdButNotExistShouldThrow() throws OperationNotSupportedException {
        database.findById(5);
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
        Person person = database.findById(1);
        assertEquals(PAV, person);
    }

}