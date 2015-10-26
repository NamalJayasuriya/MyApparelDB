/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityDB;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author namal
 */
@Entity
@Table(name = "companyOrderQty")
@NamedQueries({
    @NamedQuery(name = "CompanyOrderQty.findAll", query = "SELECT c FROM CompanyOrderQty c")})
public class CompanyOrderQty implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompanyOrderQtyPK companyOrderQtyPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemQty")
    private int itemQty;

    public CompanyOrderQty() {
    }

    public CompanyOrderQty(CompanyOrderQtyPK companyOrderQtyPK) {
        this.companyOrderQtyPK = companyOrderQtyPK;
    }

    public CompanyOrderQty(CompanyOrderQtyPK companyOrderQtyPK, int itemQty) {
        this.companyOrderQtyPK = companyOrderQtyPK;
        this.itemQty = itemQty;
    }

    public CompanyOrderQty(String orderID, String itemID) {
        this.companyOrderQtyPK = new CompanyOrderQtyPK(orderID, itemID);
    }

    public CompanyOrderQtyPK getCompanyOrderQtyPK() {
        return companyOrderQtyPK;
    }

    public void setCompanyOrderQtyPK(CompanyOrderQtyPK companyOrderQtyPK) {
        this.companyOrderQtyPK = companyOrderQtyPK;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyOrderQtyPK != null ? companyOrderQtyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyOrderQty)) {
            return false;
        }
        CompanyOrderQty other = (CompanyOrderQty) object;
        if ((this.companyOrderQtyPK == null && other.companyOrderQtyPK != null) || (this.companyOrderQtyPK != null && !this.companyOrderQtyPK.equals(other.companyOrderQtyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityDB.CompanyOrderQty[ companyOrderQtyPK=" + companyOrderQtyPK + " ]";
    }
    
}
