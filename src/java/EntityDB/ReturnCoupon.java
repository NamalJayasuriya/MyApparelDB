/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author namal
 */
@Entity
@Table(name = "returnCoupon")
@NamedQueries({
    @NamedQuery(name = "ReturnCoupon.findAll", query = "SELECT r FROM ReturnCoupon r")})
public class ReturnCoupon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "reternCouponID")
    private String reternCouponID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "receptID")
    private String receptID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "itemID")
    private String itemID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "returnSalesID")
    private String returnSalesID;

    public ReturnCoupon() {
    }

    public ReturnCoupon(String reternCouponID) {
        this.reternCouponID = reternCouponID;
    }

    public ReturnCoupon(String reternCouponID, String receptID, String itemID, int qty, String description, String returnSalesID) {
        this.reternCouponID = reternCouponID;
        this.receptID = receptID;
        this.itemID = itemID;
        this.qty = qty;
        this.description = description;
        this.returnSalesID = returnSalesID;
    }

    public String getReternCouponID() {
        return reternCouponID;
    }

    public void setReternCouponID(String reternCouponID) {
        this.reternCouponID = reternCouponID;
    }

    public String getReceptID() {
        return receptID;
    }

    public void setReceptID(String receptID) {
        this.receptID = receptID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReturnSalesID() {
        return returnSalesID;
    }

    public void setReturnSalesID(String returnSalesID) {
        this.returnSalesID = returnSalesID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reternCouponID != null ? reternCouponID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReturnCoupon)) {
            return false;
        }
        ReturnCoupon other = (ReturnCoupon) object;
        if ((this.reternCouponID == null && other.reternCouponID != null) || (this.reternCouponID != null && !this.reternCouponID.equals(other.reternCouponID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.ReturnCoupon[ reternCouponID=" + reternCouponID + " ]";
    }
    
}
