/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.ordering.app;

/**
 *
 * @author nehal
 */
public class Model {
    
    String phone,type,payment;
    boolean wc,c,n,deliver;
    int quantity,amount;

    public Model(String phone, String type, int quantity, boolean wc, boolean c, boolean n, int amount,String payment, boolean deliver) {
        this.phone = phone;
        this.type = type;
        this.payment = payment;
        this.wc = wc;
        this.c = c;
        this.n = n;
        this.quantity = quantity;
        this.amount = amount;
        this.deliver = deliver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public boolean isWc() {
        return wc;
    }

    public void setWc(boolean wc) {
        this.wc = wc;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public boolean isN() {
        return n;
    }

    public void setN(boolean n) {
        this.n = n;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getDeliver() {
        return deliver;
    }

    public void setDeliver(boolean deliver) {
        this.deliver = deliver;
    }
    
}