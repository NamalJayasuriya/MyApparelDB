/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityDB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author namal
 */
@Entity
@Table(name = "companyOrder")
@NamedQueries({
    @NamedQuery(name = "CompanyOrder.findAll", query = "SELECT c FROM CompanyOrder c")})
public class CompanyOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "orderID")
    private String orderID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "companyID")
    private String companyID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;

    public CompanyOrder() {
    }

    public CompanyOrder(String orderID) {
        this.orderID = orderID;
    }

    public CompanyOrder(String orderID, String companyID, Date time, double amount) {
        this.orderID = orderID;
        this.companyID = companyID;
        this.time = time;
        this.amount = amount;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyOrder)) {
            return false;
        }
        CompanyOrder other = (CompanyOrder) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.CompanyOrder[ orderID=" + orderID + " ]";
    }
    
}
