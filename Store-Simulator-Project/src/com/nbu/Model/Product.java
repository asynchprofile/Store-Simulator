package com.nbu.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Product {
    private String ID;
    private String ProductName;
    private Category ProductCategory;
    private Date ExpiryDate;
    private Double PriceByDelivery;
    private Double Price;
    private int Quantity;

    public Product() {
        this.ID = "No ID";
        this.ProductName = "NoName";
        this.ProductCategory = Category.UNKNOWN;
    }

    public Product(String id, String productName, Category productCat, String dateInStr, double priceByDelivery, int quantity) {
        setID (id);
        setName (productName);
        setProductCategory (productCat);
        setExpiryDate (dateInStr);
        setPriceByDelivery(priceByDelivery);
        setPrice ();
        setQuantity (quantity);
        Store.productArrayList.add (this);
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

    public String getExpiryDateStr() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
        String strDate = dateFormat.format(this.ExpiryDate);
        return strDate;
    }
    public Double getPriceByDelivery() {
        return PriceByDelivery;
    }

    public Double getPrice() {
        return Price;
    }

    public Integer getQuantity() {
        return Quantity;
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
        try {
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(newExpDate);
            this.ExpiryDate = date1;
        } catch (ParseException e) {
            System.out.println ("Wrong Date format, please try again-!");
        }
    }


    public void setQuantity(int quantity) {
        if (quantity > 0 && quantity <= 200) {
            this.Quantity = quantity;
        } else this.Quantity = 0;
    }

    public void setPriceByDelivery(Double pbd) {
       if(pbd >0) {
           this.PriceByDelivery = pbd;
       }
    }

    //TODO Check price calculations
    public void setPrice () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy/");
        LocalDate localDate = LocalDate.now();
        int discount = 0;

        //70% of the price if the expiration date is today
        if(localDate.equals (this.ExpiryDate)) {
            discount = 70;
            this.Price = (this.PriceByDelivery * discount) / 100;
        }
        //If the expiration date has not passed, price = Delivery Price * 2
        else this.Price = PriceByDelivery*2;

        //TODO Calculate 50% lower price if the expiration date is in 2 days

    }

    public void getProductDetails() {
    System.out.println("Product ID:" + getID ());
    System.out.println("Product name:" + getName ());
    System.out.println("Product category:" + getProductCategory ());
    System.out.println("Expiry Date:" + getExpiryDateStr ());
    System.out.println("Price by Delivery:" + getPriceByDelivery ());
    System.out.println("Price:" + getPrice ());
    System.out.println("Quantity:" + getQuantity ());
    System.out.println("-----------");
    }


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
