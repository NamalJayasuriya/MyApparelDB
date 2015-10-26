/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author namal
 */
@Embeddable
public class CompanyOrderQtyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "orderID")
    private String orderID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "itemID")
    private String itemID;

    public CompanyOrderQtyPK() {
    }

    public CompanyOrderQtyPK(String orderID, String itemID) {
        this.orderID = orderID;
        this.itemID = itemID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyOrderQtyPK)) {
            return false;
        }
        CompanyOrderQtyPK other = (CompanyOrderQtyPK) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.CompanyOrderQtyPK[ orderID=" + orderID + ", itemID=" + itemID + " ]";
    }
    
}
