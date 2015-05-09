package com.github.rmnasri.model;

/**
 * Created by riadh on 02/05/15.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "RECETTE")
public class Recette {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "RECETTE_ID")
    @GeneratedValue
    private Long id;

    @Column(name = "RECETTE_NAME")
    @Size(min = 1, max = 30)
    @NotNull
    private String recetteName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecetteName() {
        return recetteName;
    }

    public void setRecetteName(String recetteName) {
        this.recetteName = recetteName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recette recette = (Recette) o;

        if (!id.equals(recette.id)) return false;
        return recetteName.equals(recette.recetteName);

    }

    @Override
    public int hashCode() {
        int result = 0;
        if(id != null){
            result = id.hashCode();
        }
        result = 31 * result + recetteName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Recette [recette_id=" + id + ", recette_name=" + recetteName+ "]";
    }

}
