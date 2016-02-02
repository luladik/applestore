package com.madislav.store.model;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "purchase")
@Configurable
public class Purchase {
	
    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar orderDate;

    /**
     */
    @ManyToOne
    private Customer orderedBy;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchase", fetch = FetchType.EAGER)
    private List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();

    /**
     */
    private Boolean completed;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	public static final EntityManager entityManager() {
        EntityManager em = new Purchase().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public Calendar getOrderDate() {
        return this.orderDate;
    }

	public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

	public Customer getOrderedBy() {
        return this.orderedBy;
    }

	public void setOrderedBy(Customer orderedBy) {
        this.orderedBy = orderedBy;
    }

	public List<PurchaseItem> getPurchaseItems() {
        return this.purchaseItems;
    }

	public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

	public Boolean getCompleted() {
        return this.completed;
    }

	public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
