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
@Table(name = "recept")
@NamedQueries({
    @NamedQuery(name = "Recept.findAll", query = "SELECT r FROM Recept r")})
public class Recept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "receptID")
    private String receptID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "salesPersonID")
    private String salesPersonID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "payMetbod")
    private String payMetbod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private float discount;

    public Recept() {
    }

    public Recept(String receptID) {
        this.receptID = receptID;
    }

    public Recept(String receptID, Date time, String salesPersonID, double amount, String payMetbod, float discount) {
        this.receptID = receptID;
        this.time = time;
        this.salesPersonID = salesPersonID;
        this.amount = amount;
        this.payMetbod = payMetbod;
        this.discount = discount;
    }

    public String getReceptID() {
        return receptID;
    }

    public void setReceptID(String receptID) {
        this.receptID = receptID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSalesPersonID() {
        return salesPersonID;
    }

    public void setSalesPersonID(String salesPersonID) {
        this.salesPersonID = salesPersonID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayMetbod() {
        return payMetbod;
    }

    public void setPayMetbod(String payMetbod) {
        this.payMetbod = payMetbod;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receptID != null ? receptID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recept)) {
            return false;
        }
        Recept other = (Recept) object;
        if ((this.receptID == null && other.receptID != null) || (this.receptID != null && !this.receptID.equals(other.receptID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.Recept[ receptID=" + receptID + " ]";
    }
    
}
