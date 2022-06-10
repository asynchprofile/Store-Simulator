package com.nbu.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

enum Category {
    //категория (хранителни и нехранителни стоки)
    FOOD, OTHER, UNKNOWN
}

public class Products {
    private String ID;
    private String ProductName;
    private Category ProductCategory;
    private Date ExpiryDate;
    private Double price;
    private int quantity;

    public Products() {
        this.ID = "No ID";
        this.ProductName = "NoName";
        this.ProductCategory = Category.UNKNOWN;
    }

    public Products(String id, String productName, Category productCat, String dateInStr) {
        setID (id);
        setName (productName);
        setProductCategory (productCat);
        setExpiryDate (dateInStr);
        Store.productsArrayList.add (this);
    }

    //----- Getters
    public String getID() {
        return ID;
    }

    public String getName() {
        return ProductName;
    }

    public Category getProductCategory() {
        return ProductCategory;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    //----- Setter
    public void setID(String newID) {
        this.ID = newID;
    }

    public void setName(String newName) {
        this.ProductName = newName;
    }

    public void setProductCategory(Category newCategory) {
        this.ProductCategory = newCategory;
    }

    public void setExpiryDate(String newExpDate) {
        SimpleDateFormat formatter = new SimpleDateFormat ("dd-MMM-yyyy");
        try {
            Date date = formatter.parse (newExpDate);
            this.ExpiryDate = date;
            //  System.out.println(date);
            //  System.out.println(formatter.format(date));
        } catch (ParseException e) {
            System.out.println ("Wrong Date format, please try again!");
        }
    }


    //TODO
    // TODO 1: Price calculations
    // TODO 2: Quantity
    // TODO 3: Products in Store list
}


/*
В магазина се зареждат стоки, които ще се продават.
Всяка стока се определя от идентификационен номер, име, единична доставна цена и категория (хранителни и нехранителни стоки).
Освен това всяка стока има дата на изтичане на срока на годност.

Продажната цена на стоката се определя по следния начин: Хранителните и нехранителните стоки имат различен % надценка,
който се определя в магазина. Ако срокът на годност наближава, т.е. остават по-малко от даден брой дни до изтичането му,
продажната цена на стоката се намалява с определен %.
*Броят на дните до изтичането на срока и % намаление са различни за всеки магазин.
 */
