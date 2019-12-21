/*
 * JUnit tests for Date, Money, and Bill classes
 * @author Lesley Kalmin
 * Modified by Tanvir Tatla
 *  CSS162
 */

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * This JUnit tests the clone and compareTo methods in Money, Date, and Bill.
 * It also tests tho other methods which are below the clone and compare tests.
 */
public class DateMoneyBillJUnit {
    /**
     CloneMoneyTest - tests the clone method in the Money class
     */
    @Test
    public void CloneMoneyTest() {
        Money money1 = new Money(10, 40);

        Money money2 = money1.clone();

        assertEquals(10.40, money1.getMoney(), 0);
        assertEquals(10.40, money2.getMoney(), 0);
    }

    /**
     * CompareMoneyTest - tests the compareTo method in the Money class
     */
    @Test
    public void CompareMoneyTest()
    {
        Money m1 = new Money(5, 38);
        Money m2 = m1.clone();
        Money m3 = new Money(10);
        Money m4 = new Money(2, 67);

        assertTrue(m1.compareTo(m2) == 0);
        assertTrue( m1.compareTo(m3) < 0);
        assertTrue(m1.compareTo(m4) > 0);
    }

    /**
     CloneDateTest - tests the clone method in the Date class
     */
    @Test
    public void CloneDateTest() {
        Date date1 = new Date(1,1,2014);
        Date date2 = date1.clone();

        assertEquals(1, date2.getMonth());
        assertEquals(1, date2.getDay());
        assertEquals(2014, date2.getYear());
    }

    /**
     * CompareDateTest - tests the compareTo method in date
     */
    @Test
    public void CompareDateTest()
    {
        Date d1 = new Date(2,27,2018);
        Date d2 = d1.clone();
        Date d3 = new Date(1,4,2019);
        Date d4 = new Date(5,19,2014);

        assertTrue(d1.compareTo(d2) == 0);
        assertTrue( d1.compareTo(d3) < 0);
        assertTrue(d1.compareTo(d4) > 0);
    }
    /**
     CloneBillTest - test the clone method in the Bill class
     */
    @Test
    public void CloneBillTest() {
        Money amount = new Money(22);
        Date dueDate = new Date(9, 21,2019);
        Bill bill1 = new Bill(amount,dueDate,"Me");

        Bill bill2 = bill1.clone();

        assertEquals("Me", bill2.getOriginator());
        assertTrue(bill1.equals(bill2));
    }

    /**
     * CompareBillTest - tests the compareTo method in Bill
     */
    @Test
    public void CompareBillTest()
    {
        Date d = new Date(1,1,2014);
        Money amount = new Money(10);
        String s = "Me";

        Bill b1 = new Bill(amount, d, s);
        Bill b2 = b1.clone();
        Bill b3 = new Bill(new Money(8), d, s);
        b3.setPaid(d);

        assertTrue(b1.compareTo(b2) == 0);
        assertTrue( b1.compareTo(b3) < 0);
        assertTrue(b3.compareTo(b1) > 0);
    }

	/**
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

    /**
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

    /**
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

    /**
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

    /**
    ConstructDateTest - tests the constructor in the Date class
     */
    @Test
    public void ConstructDateTest() {
        Date date = new Date(2, 3, 2017);

        assertEquals(2, date.getMonth());
        assertEquals(3, date.getDay());
        assertEquals(2017, date.getYear());
    }

    /**
    SetYearDateTest - tests the setYear() method in the Date class
     */
    @Test
    public void SetYearDateTest() {
        Date date = new Date(1,1,2014);
        date.setYear(2018);

        assertEquals(2018, date.getYear());
    }

    /**
    SetMonthDateTest - tests the setMonth() method in the Date class
     */
    @Test
    public void SetMonthDateTest() {
        Date date = new Date(1,1,2014);
        date.setMonth(12);

        assertEquals(12, date.getMonth());
    }

    /**
    SetDayDateTest - tests the setDay() method in the Date class
     */
    @Test
    public void SetDayDateTest() {
        Date date = new Date(1,1,2014);
        date.setDay(31);

        assertEquals(31, date.getDay());
    }

    /**
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

    /**
    IsAfterDateTest - tests the isAfter() method in the Date class
     */
    @Test
    public void IsAfterDateTest() {
        Date date1 = new Date(1,1,2014);
        Date date2 = new Date(1,2,2014);

        assertTrue(date2.isAfter(date1));
    }

    /**
    EqualsDateTest - tests the equals() method in the Date class
     */
    @Test
    public void EqualsDateTest() {
        Date date1 = new Date(3,17,2015);
        Date date2 = date1.clone();

        assertTrue(date1.equals(date2));
    }

    /**
    ToStringDateTest - tests the toString in the Date class
     */
    @Test
    public void ToStringDateTest() {
        Date date = new Date(1,1,2014);

        assertEquals("01/01/2014", date.toString());
    }

    /**
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

    /**
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

    /**
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

    /**
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

    /**
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

    /**
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

    /**
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
