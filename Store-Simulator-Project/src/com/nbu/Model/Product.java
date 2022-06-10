package com.nbu.Model;

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
        setPrice (getExpiryDate ());
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


    public void setQuantity(int quantity) {
        if (quantity > 0 && quantity < 100) {
            this.Quantity = quantity;
        } else this.Quantity = 0;
    }

    public void setPriceByDelivery(Double pbd) {
       if(pbd >0) {
           this.PriceByDelivery = pbd;
       }
    }

    //TODO Check price calculations
    public void setPrice (Date expiryDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu/");
        LocalDate localDate = LocalDate.now();
        int discount = 0;

        //70% of the price if the expiration date is today
        if(dtf.equals (expiryDate)) {
            discount = 70;
            this.Price = (this.PriceByDelivery * discount) / 100;
        }
        else this.Price = PriceByDelivery*2;

        //30% lower price if the expiration date is more than a week

        //50% lower price if the expiration date is 2 days

    }

    public void getProductDetails() {
    System.out.println("-----------");
    System.out.println("Product ID:" + this.ID);
    System.out.println("Product name:" + this.ProductName);
    System.out.println("Product category:" + this.ProductCategory);
    System.out.println("Expiry Date:" + this.getExpiryDate ());
    System.out.println("Price by Delivery:" + this.PriceByDelivery);
    System.out.println("Price:" + this.Price);
    System.out.println("Quantity:" + this.Quantity);
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
