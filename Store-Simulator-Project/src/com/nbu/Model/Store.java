package com.nbu.Model;

import java.util.ArrayList;

public class Store {
    // Every store has a name and location
    private String storeName;
    private String storeLocation;

    public static ArrayList<Products> productsArrayList = new ArrayList<> ();


    public Store() {
        this.storeName = "noName";
        this.storeLocation = "noLocation";
    }

    public Store(String sName, String sLoc) {
        this.storeName = sName;
        this.storeLocation = sLoc;
        //Adding the newliy created object to the global list
        GlobalDataStructures.storeArrayList.add (this);
    }

    //getters
    String getStoreName() {
        return storeName;
    }

    String getStoreLocation() {
        return storeLocation;
    }

    //Setters
    public void setStoreName(String name) {
        this.storeName = name;
    }

    public void setStoreLocation(String storeLoc) {
        this.storeLocation = storeLoc;
    }

    public void getStoreInfo() {
        System.out.println ("\n--------- Store Information --------");
        System.out.println ("Store Name: " + this.storeName);
        System.out.println ("Store Location: " + this.storeLocation);
        System.out.println ("----------------");
    }

    // Has a list of Goods with : ID, Name, Price by delivery, Category, Expiry Date
    // Has a list of Employees
    // Has a list of recepits
    // Good price: Defined by the dates left until the expiry date

}




/*
Задание: Решението на задачата включва моделиране и реализация на процеса на зареждане и продажба на стоки в магазин.

В магазина се зареждат стоки, които ще се продават.
Всяка стока се определя от идентификационен номер, име, единична доставна цена и категория (хранителни и нехранителни стоки).
Освен това всяка стока има дата на изтичане на срока на годност.

Продажната цена на стоката се определя по следния начин: Хранителните и нехранителните стоки имат различен % надценка,
който се определя в магазина. Ако срокът на годност наближава, т.е. остават по-малко от даден брой дни до изтичането му,
продажната цена на стоката се намалява с определен %.
*Броят на дните до изтичането на срока и % намаление са различни за всеки магазин.

!Стоки с изтекъл срок на годност не трябва да се продават.

::::Shop Employees::::
В магазина работят касиери, които имат име, идентификационен номер и определена месечна заплата.
На всяка от касите в магазина може да работи по един касиер. Всеки касиер може да работи на различна каса.
На всяка от касите в магазина, касиерите маркират стоките, които клиентите искат да си купят.
Ако клиентите имат достатъчно пари, за да си купят стоките, касиерите им ги продават и издават касови бележки.


При продажба на стока, да се проверява дали има достатъчно налично количество от нея.
Ако количеството не е достатъчно да се хвърля изключение.
Изключението да показва от коя стока какво количество не достига, за да се извърши покупката. Касовата бележка трябва да съдържат минимум следната информация: пореден номер, касиер, който издава касовата бележка, дата и час на издаване на касовата бележка, списък със стоки, които се включват в касовата бележка включително цената и количеството им и общата стойност, която трябва да се заплати от клиента. Необходимо е да се съхранява общия брой на издадените касови бележки до момента и общата сума, която се генерира като оборот при издаването. При издаването на касовата бележка е необходимо нейното съдържание да се показва и да се запазва във файл. Всяка касова бележка трябва да се пази в отделен файл с име на файла, което да съдържа поредния номер на издадената касова бележка. Трябва да може да се провери колко са издадените касови бележки към момента. Информацията във файла, в който се записва касовата бележка трябва да може да се прочете. В магазина се съхранява информация касиерите, които работят в него, за списъка с доставените и продадените стоки както и за издадените касови бележки. За всеки магазин трябва да може да се изчисли колко са разходите за: заплати на касиери и за доставка на стоки и колко са приходите от продадени стоки. Освен това, трябва да се изчислява колко е печалбата на магазина. В магазина всички каси работят паралелно. Да се осъществи работата на касите в отделни нишки. Да се показва информация за това кой касиер работи на касата в момента и общата стойност на всяка издадена касова бележка. Приложението трябва да бъде разработено на Java и да позволява данните и да изпълнява изискванията, които са описани по-горе.



 */