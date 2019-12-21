/*
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin
 * Modified by Tanvir Tatla
 *  CSS162
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class DateMoneyBillJUnit {

	/*
	ConstructMoneyTest - tests each constructor in the Money class
	Original author: Lesley Kalmin
	Modified by: Tanvir Tatla
	 */
	@Test
	public void ConstructMoneyTest() {
		Money money1 = new Money(10);
		Money money2 = new Money(12,37);
		
		assertEquals(10, money1.getDollars());
		assertEquals(12.37, money2.getMoney(), 0);
	}

    /*
    SetMoneyTest - tests the setMoney method in Money
    Original author: Lesley Kalmin
     */
	@Test
	public void SetMoneyTest()
	{
		Money money1 = new Money();
		
		money1.setMoney(30,50);
        assertEquals(30, money1.getDollars());      
        assertEquals(50, money1.getCents());
	}

    /*
    ConstructMoneyCopyTest - tests the copy constructor in the Money class
    Original author: Lesley Kalmin
    Modified by: Tanvir Tatla
     */
	@Test
	public void ConstructMoneyCopyTest() {
		Money money1 = new Money(10, 40);
		
        Money money2 = new Money(money1);
        
        assertEquals(10.40, money1.getMoney(), 0);
        assertEquals(10.40, money2.getMoney(), 0);
	}

    /*
    PrintMoneyTest - tests the toString method in the Money class
    Original author: Lesley Kalmin
    Modified by: Tanvir Tatla
     */
	@Test
	public void PrintMoneyTest()
	{
		Money money1 = new Money(10);

        money1.setMoney(30,50);
        assertEquals("$30.50", money1.toString());
		
	}

    /*
    AddMoneyTest - tests each add method in the Money class
    */
	@Test
    public void AddMoneyTest() {
	    Money money1 = new Money();
	    money1.add(2);
	    assertEquals(2, money1.getDollars());

	    money1.add(0, 50);
	    assertEquals(2.50, money1.getMoney(), 0);

	    money1.add(money1);
	    assertEquals(5.00, money1.getMoney(), 0);
    }

    /*
    EqualsMoneyTest - tests the equals method in the Money class
    */
    @Test
    public void EqualsMoneyTest() {
	    Money money1 = new Money(19,19);
	    Money money2 = new Money(19,19);

	    assertTrue(money1.equals(money2));
    }

    /*
    ConstructDateTest - tests the constructor in the Date class
     */
    @Test
    public void ConstructDateTest() {
        Date date = new Date(2, 3, 2017);

        assertEquals(2, date.getMonth());
        assertEquals(3, date.getDay());
        assertEquals(2017, date.getYear());
    }

    /*
    CopyConstructDateTest - tests the copy constructor in the Date class
     */
    @Test
    public void CopyConstructDateTest() {
        Date date1 = new Date(1,1,2014);
        Date date2 = new Date(date1);

        assertEquals(1, date2.getMonth());
        assertEquals(1, date2.getDay());
        assertEquals(2014, date2.getYear());
    }

    /*
    SetYearDateTest - tests the setYear() method in the Date class
     */
    @Test
    public void SetYearDateTest() {
        Date date = new Date(1,1,2014);
        date.setYear(2018);

        assertEquals(2018, date.getYear());
    }

    /*
    SetMonthDateTest - tests the setMonth() method in the Date class
     */
    @Test
    public void SetMonthDateTest() {
        Date date = new Date(1,1,2014);
        date.setMonth(12);

        assertEquals(12, date.getMonth());
    }

    /*
    SetDayDateTest - tests the setDay() method in the Date class
     */
    @Test
    public void SetDayDateTest() {
        Date date = new Date(1,1,2014);
        date.setDay(31);

        assertEquals(31, date.getDay());
    }

    /*
    SetDateTest - tests the setDay() method in the Date class
     */
    @Test
    public void SetDateTest() {
        Date date = new Date(1,1,2014);
        date.setDate(7,7,2017);

        assertEquals(7, date.getDay());
        assertEquals(7,date.getMonth());
        assertEquals(2017, date.getYear());
    }

    /*
    IsAfterDateTest - tests the isAfter() method in the Date class
     */
    @Test
    public void IsAfterDateTest() {
        Date date1 = new Date(1,1,2014);
        Date date2 = new Date(1,2,2014);

        assertTrue(date2.isAfter(date1));
    }

    /*
    EqualsDateTest - tests the equals() method in the Date class
     */
    @Test
    public void EqualsDateTest() {
        Date date1 = new Date(3,17,2015);
        Date date2 = new Date(date1);

        assertTrue(date1.equals(date2));
    }

    /*
    ToStringDateTest - tests the toString in the Date class
     */
    @Test
    public void ToStringDateTest() {
        Date date = new Date(1,1,2014);

        assertEquals("01/01/2014", date.toString());
    }

    /*
    ConstructBillTest - test the constructor in the Bill class
     */
    @Test
    public void ConstructBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill = new Bill(amount, dueDate, "Me");

        assertEquals("$22.00", bill.getAmount().toString());
        assertEquals("09/21/2019", bill.getDueDate().toString());
    }

    /*
    CopyConstructBillTest - test the copy constructor in the Bill class
     */
    @Test
    public void CopyConstructBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill1 = new Bill(amount,dueDate,"Me");

        Bill bill2 = new Bill(bill1);

        assertEquals("Me", bill2.getOriginator());
    }

    /*
    SetPaidBillTest - test the setPaid() method in the Bill class
                      checks if paidDate is set
     */
    @Test
    public void SetPaidBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill = new Bill(amount,dueDate,"Me");

        bill.setPaid(new Date(9,17,2019));

        assertTrue(bill.isPaid());
    }

    /*
    SetDueDateBillTest - test the setDueDate() method (dueDate setter) in the
                         Bill class
     */
    @Test
    public void SetDueDateBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill = new Bill(amount,dueDate,"Me");

        bill.setDueDate(new Date(10, 4, 2019));

        assertEquals("10/04/2019", bill.getDueDate().toString());
    }

    /*
    SetAmountBillTest - tests setAmount() (amount setter) in the Bill class
     */
    @Test
    public void SetAmountBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill = new Bill(amount,dueDate,"Me");

        bill.setAmount(new Money(14,79));

        assertEquals(14.79, bill.getAmount().getMoney(), 0);
    }

    /*
    SetOriginatorBillTest - test the setOriginator() method in the Bill class
     */
    @Test
    public void SetOriginatorBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill = new Bill(amount,dueDate,"Me");

        bill.setOriginator("YOU");

        assertEquals("YOU", bill.getOriginator());
    }

    /*
    EqualsBillTest - test the equals() method in the Bill class
     */
    @Test
    public void EqualsBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill = new Bill(amount,dueDate,"Me");

        Bill bill2 = new Bill(amount, dueDate, "Me");

        assertTrue(bill2.equals(bill));
    }

    /*
    ToStringBillTest - test the toString in the Bill class
     */
    @Test
    public void ToStringBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill = new Bill(amount,dueDate,"Me");

        assertEquals("Amount due: $22.00\n" +
                "Due on: 09/21/2019\n" +
                "Pay to: Me\n" +
                "Has been paid: false", bill.toString());
    }
}
