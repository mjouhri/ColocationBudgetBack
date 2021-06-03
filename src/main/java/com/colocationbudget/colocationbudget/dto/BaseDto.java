package com.colocationbudget.colocationbudget.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseDto {

    private static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";
    private static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    protected String dateCreation;
    protected String derniereModification;
    protected String dernierModificateur;

    /**
     * Récupère la date de création.
     *
     * @return LocalDateTime.
     */
    public LocalDateTime getDateCreation() {
        return getFormattedLocalDateTime(this.dateCreation);
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Récupère la date de dernière modification.
     *
     * @return LocalDateTime.
     */
    public LocalDateTime getDerniereModification() {
        return getFormattedLocalDateTime(this.derniereModification);
    }

    public void setDerniereModification(String derniereModification) {
        this.derniereModification = derniereModification;
    }

    public String getDernierModificateur() {
        return dernierModificateur;
    }

    public void setDernierModificateur(String dernierModificateur) {
        this.dernierModificateur = dernierModificateur;
    }

    /**
     * Renvoie une LocalDate formattée.
     *
     * @param localDate : La String à formatter.
     * @return La LocalDate formatté.
     */
    protected LocalDate getFormattedLocalDate(String localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT);
        return (localDate != null && !localDate.equals("")) ? LocalDate.parse(localDate, formatter) : null;
    }

    /**
     * Renvoie un LocalDateTime formatté.
     *
     * @param localDateTime : La String à formatter.
     * @return Le LocalDateTime formatté.
     */
    protected LocalDateTime getFormattedLocalDateTime(String localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT);
        return (localDateTime != null && !localDateTime.trim().equals("")) ? LocalDateTime.parse(localDateTime, formatter) : null;
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


