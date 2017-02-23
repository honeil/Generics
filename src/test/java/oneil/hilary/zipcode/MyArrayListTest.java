package oneil.hilary.zipcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hilaryoneil on 2/22/17.
 */
public class MyArrayListTest {


    @Test
    public void EnsureCapacityTest_ArraySizeShouldExpandPastTwoWithMoreAdds_returnsTrueIfObjectIsAdded() {
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        boolean test1 = myArrayList.add("Jim");
        boolean test2 = myArrayList.add("Pam");
        boolean test3 = myArrayList.add("Dwight");
        boolean test4 = myArrayList.add("Michael");
        boolean test5 = myArrayList.add("Stanley");
        boolean test6 = myArrayList.add("Angela");
        Assert.assertTrue(test1);
        Assert.assertTrue(test2);
        Assert.assertTrue(test3);
        Assert.assertTrue(test4);
        Assert.assertTrue(test5);
        Assert.assertTrue(test6);

    }

    @Test
    public void EnsureCapacityTest_ArraySizeShouldExpandPastTwoWithMoreAdds_CounterShouldBeEqualToNumberOfAdds() {
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        boolean test1 = myArrayList.add("Jim");
        boolean test2 = myArrayList.add("Pam");
        boolean test3 = myArrayList.add("Dwight");
        boolean test4 = myArrayList.add("Michael");
        boolean test5 = myArrayList.add("Stanley");
        boolean test6 = myArrayList.add("Angela");
        Assert.assertTrue(test1);
        Assert.assertTrue(test2);
        Assert.assertTrue(test3);
        Assert.assertTrue(test4);
        Assert.assertTrue(test5);
        Assert.assertTrue(test6);
        int numberOfAdds_expected = 6;
        int numberOfAdds_actual = myArrayList.getCounter();
        Assert.assertEquals(numberOfAdds_expected, numberOfAdds_actual);
        Assert.assertTrue(myArrayList.getCounter()==myArrayList.size());
    }

    @Test
    public void getMethod_returnsObjectAtIndex_testThatAddMethodAddsToEndOfArray() {
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        boolean test1 = myArrayList.add("Jim");
        boolean test2 = myArrayList.add("Pam");
        boolean test3 = myArrayList.add("Dwight");
        String expected = "Dwight";
        String actual = myArrayList.get(2);
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(myArrayList.getCounter()==3);
    }

    //http://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
    @Test (expected=IndexOutOfBoundsException.class)
    public void getMethod_returnsObjectAtIndex_testOutOfBoundsException_indexLessThanZero() {
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.get(-3);
    }

    @Test
    public void addObjectAtIndex_testCounterIncreased(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        myArrayList.add("Jim");
        myArrayList.add("Pam");
        myArrayList.add("Dwight");
        myArrayList.add(2, "Stanley");
        int expectedCounter = 4;
        int actualCounter = myArrayList.getCounter();
        Assert.assertEquals(expectedCounter, actualCounter);
    }

    @Test
    public void addObjectAtIndex_testThatObjectWasAddedAtCorrectPosition(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        myArrayList.add("Jim");
        myArrayList.add("Pam");
        myArrayList.add("Dwight");
        myArrayList.add(2, "Stanley");
        String expectedName= "Stanley";
        String actualName = myArrayList.get(2);
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void addObjectAtIndex_testThatObjectWasAddedAtCorrectPosition_indexInputIsGreaterThanArraySize(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        myArrayList.add("Jim");
        myArrayList.add("Pam");
        myArrayList.add("Dwight");
        myArrayList.add(10, "Stanley");
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void addObjectAtIndex_testThatObjectWasAddedAtCorrectPosition_indexInputIsLessThanZero(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        myArrayList.add("Jim");
        myArrayList.add("Pam");
        myArrayList.add("Dwight");
        myArrayList.add(-3, "Stanley");
    }

    @Test
    public void sizeTest_shouldReturnAnIntOfSizeOfArray(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(3);
        myArrayList.add("Jim");
        myArrayList.add("Pam");
        myArrayList.add("Dwight");
        myArrayList.remove("Pam");
        int expectedLength = 2;
        int actualLength = myArrayList.size();
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void removeByIndexValueTest_ShouldReturnIntegerRemoved(){
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        Object actual = myArrayList.remove(1);
        Assert.assertTrue(actual.equals(2));
    }

    @Test
    public void removeByIndexValueTest_ShouldReturnCounterAs2(){
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>(3);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        Object actual = myArrayList.remove(1);
        Assert.assertTrue(myArrayList.getCounter()==2);
    }

    @Test
    public void removeByIndexValueTest_ShouldRemoveObjectAtIndex1() {
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.add("Jim");
        myArrayList.add("Pam");
        myArrayList.add("Dwight");
        myArrayList.remove("Pam");
        Assert.assertFalse(myArrayList.get(1).equals("Pam"));
        Assert.assertFalse(myArrayList.get(0).equals("Pam"));
        int arraySizeExpected = 2;
        int arraySizeActual = myArrayList.size();
        Assert.assertEquals(arraySizeExpected,arraySizeActual);
        Assert.assertTrue(myArrayList.size()==myArrayList.getCounter());
    }

    @Test
    public void setNewValueAtIndexInput_ShouldReturnObjectAtIndexBeforeSetMethodWasUsed(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.add("Jim");
        myArrayList.add("Jim");
        myArrayList.add("Jim");
        myArrayList.add("Jim");
        myArrayList.set(1,"Pam");
        String expected = "Pam";
        String actual = myArrayList.get(1).toString();
        Assert.assertEquals(expected,actual);
        Assert.assertTrue(myArrayList.size()==myArrayList.getCounter());
    }

    @Test
    public void clearMethodTest_ResetsArraySizeToZero(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.add("Toby");
        myArrayList.add("Andy");
        myArrayList.add("Kevin");
        myArrayList.clear();
        int expectedArraySize = 0;
        int actualArraySize = myArrayList.size();
        Assert.assertEquals(expectedArraySize, actualArraySize);
        Assert.assertTrue(myArrayList.size()==myArrayList.getCounter());
    }

    @Test
    public void isEmptyTest_shouldReturnTrueIfArrayIsEmpty_ArrayInitializedButNotFilled(){
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        Assert.assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void isEmptyTest_shouldReturnFalse_ObjectsAddedToArray(){
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(1);
        myArrayList.add(2);
        Assert.assertFalse(myArrayList.isEmpty());
    }

    @Test
    public void containsTest_shouldReturnFalse_InputObjectNotInArray(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.add("Toby");
        myArrayList.add("Andy");
        myArrayList.add("Kevin");
        Assert.assertFalse(myArrayList.contains("Pam"));
    }

    @Test
    public void containsTest_shouldReturnTru_InputObjectIsInArray(){
        MyArrayList<String> myArrayList = new MyArrayList<String>(2);
        myArrayList.add("Toby");
        myArrayList.add("Andy");
        myArrayList.add("Kevin");
        Assert.assertTrue(myArrayList.contains("Kevin"));
    }

}
