package com.colocationbudget.colocationbudget.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@MappedSuperclass
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    protected LocalDateTime dateCreation;
    protected LocalDateTime derniereModification;
    protected String dernierModificateur;

    /**
     * Définition des données qui doivent être mises sur l'objet avant chaque création en base.
     */
    @PrePersist
    protected void prePersist() {
        this.dateCreation = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.derniereModification = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.dernierModificateur = getRequestAttribute();
    }

    /**
     * Définition des données qui doivent être mises sur l'objet avant chaque mise à jour en base.
     */
    @PreUpdate
    protected void preUpdate() {
        this.derniereModification = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.dernierModificateur = getRequestAttribute();
    }

    /**
     * Récupère la date de création.
     *
     * @return LocalDateTime.
     */
    @Column(name = "date_creation")
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = getLocalDateTimePlusOneSecond(dateCreation);
    }

    /**
     * Récupère la date de dernière modification.
     *
     * @return LocalDateTime.
     */
    @Column(name = "derniere_modification")
    public LocalDateTime getDerniereModification() {
        return derniereModification;
    }

    public void setDerniereModification(LocalDateTime derniereModification) {
        this.derniereModification = getLocalDateTimePlusOneSecond(derniereModification);
    }

    @Column(name = "dernier_modificateur")
    public String getDernierModificateur() {
        return dernierModificateur;
    }

    public void setDernierModificateur(String dernierModificateur) {
        this.dernierModificateur = dernierModificateur;
    }

    /**
     * Récupère une date et y ajoute une seconde.
     *
     * @param localDateTime : Date récupérée.
     * @return Date à laquelle on a ajouté une seconde.
     */
    protected LocalDateTime getLocalDateTimePlusOneSecond(LocalDateTime localDateTime) {
        return (localDateTime != null && localDateTime.getSecond() == 0) ? localDateTime.plusSeconds(1) : localDateTime;
    }

    /**
     * Récupère un RequestAttribute.
     *
     * @return Objet correspondant à l'attribut récupéré.
     */
    @Transient
    private String getRequestAttribute() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        Object requestUserAttribute;
        String currentUser = "Système";
        int scope = RequestAttributes.SCOPE_SESSION;

        if (requestAttributes != null) {
            requestUserAttribute = requestAttributes.getAttribute("CURRENT_USER", scope);
            currentUser = requestUserAttribute != null ? requestUserAttribute.toString() : "Système";
        }
        return currentUser;
    }

    /**
     * ToString.
     *
     * @return this.toString().
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}


