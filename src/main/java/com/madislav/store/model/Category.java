package com.madislav.store.model;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@XmlRootElement
@Scope(value= WebApplicationContext.SCOPE_SESSION,
		proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Category {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 700)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products = new ArrayList<Product>();

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }
	
	public String getName() {
        return this.name;
    }

	public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
        this.description = description;
    }

	@JsonIgnore
	public List<Product> getProducts() {
        return this.products;
    }

	public void setProducts(List<Product> products) {
        this.products = products;
    }

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	
	
}
