package com.nbu.Model;

/*
В магазина работят касиери, които имат име, идентификационен номер и определена месечна заплата.
На всяка от касите в магазина може да работи по един касиер. Всеки касиер може да работи на различна каса.
На всяка от касите в магазина, касиерите маркират стоките, които клиентите искат да си купят.
*/
public class Cashier {

    private String CashierName;
    private String CashierID;
    private Double Salary;
    private int workStationNumber;


    //Setters
    public void setCashierName(String cName) {
        if (cName.length () > 0) {
            this.CashierName = cName;
        } else CashierName = "NoName";
    }

    public void setCashierID(String cID) {
        if (cID.length () > 0) {
            this.CashierID = cID;
        } else CashierID = cID;
    }

    public void setSalary(double cSalary) {
        if (cSalary > 0) {
            this.Salary = cSalary;
        } else Salary = 0.0;
    }

    public void setWorkStationNumber(int number) {
        if (number > 0 && number < 7) {
            this.workStationNumber = number;
        }
    }

    //Getters
    private String getCashierName() {return this.CashierName;};
    private String CashierID() {return this.CashierID;};
    private Double Salary() {return this.Salary;};
    private int workStationNumber () {return this.workStationNumber;};

    //Constructors
    public Cashier () {
        CashierName = "NoName";
        CashierID = "0000";
        Salary = 0.0;
        workStationNumber = 0;
    }

    public Cashier (String cName, String cId, Double salary, int workSt) {
        setCashierName (cName);
        setCashierID (cId);
        setSalary (salary);
        setWorkStationNumber (workSt);
        Store.cashierArrayList.add(this);
    }


    public void getEmployeeDetails() {
        System.out.println ("-----------");
        System.out.println ("Cashier Name:" + CashierName);
        System.out.println ("Cashier ID:" + CashierID);
        System.out.println ("Salary:" + Salary);
        System.out.println ("Cashier working at station:" + workStationNumber);
        System.out.println ("-----------");

    }
}
