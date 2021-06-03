package com.colocationbudget.colocationbudget.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe modèle de base pour les repositories. DOIT être étendue dans tous ces derniers.
 */
abstract class BaseRepository {

    static final String WHERE_QUERY = "WHERE ";
    static final String AND_QUERY = "AND ";
    static final String PERCENTAGE_SYMBOL = "%";

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Vérifie que la chaîne fournie n'est ni nulle ni vide.
     *
     * @param string : Chaîne à vérifier.
     * @return True si non vide et non nulle. Sinon, false.
     */
    boolean isNotNullOrEmpty(String string) {
        return string != null && !string.isEmpty();
    }

    /**
     * Ajout d'un préfixe à la suite d'une query.
     *
     * @param hasPrevious : Est-ce qu'il y a des parties avant le bout de query fournie ?
     * @param query       : Query à préfixer.
     */
    void prefixAppend(boolean hasPrevious, StringBuilder query) {
        if (hasPrevious) {
            query.append(AND_QUERY);
        } else {
            query.append(WHERE_QUERY);
        }
    }

    /**
     * Complète une requête si le paramètre spécifié est non null.
     *
     * @param query       : Query à compléter.
     * @param parameter   : Paramètre de requête.
     * @param subQuery    : Sous-requête iée au paramètre spécifié.
     * @param hasPrevious : Est-ce qu'il y a des parties avant le bout de query fournie ?
     * @return hasPrevious.
     */
    boolean appendIfParameterIsNotNull(StringBuilder query, String parameter, String subQuery, boolean hasPrevious) {
        if (isNotNullOrEmpty(parameter)) {
            prefixAppend(hasPrevious, query);
            query.append(subQuery);
            hasPrevious = true;
        }
        return hasPrevious;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}

