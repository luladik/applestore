package com.madislav.store.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "product")
//@XmlRootElement
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Length(min = 4, max = 100, message = "Product title should be from 4 to 100")
    private String name;

    @NotEmpty
    @Length(min = 10, max = 255, message = "Description is very short")
    private String description;

    @Length(min = 3, max = 255, message = "Incorrect image URL")
    private String imagePath;

    @ManyToOne(fetch = FetchType.EAGER) //old - EAGER
    private Category category;

    private Boolean featured;

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @DecimalMin("10.0")
    @DecimalMax("50000.0")
    private double price;

    public Product() {

    }

    @Valid
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Valid
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Valid
    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @JsonIgnore
    @XmlTransient
    public Category getCategory() {
        return this.category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    @Valid
    public Boolean getFeatured() {
        return this.featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    @Valid
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Valid
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}
