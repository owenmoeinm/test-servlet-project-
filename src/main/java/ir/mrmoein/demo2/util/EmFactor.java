package ir.mrmoein.demo2.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public final class EmFactor {

    private static EntityManagerFactory emf;

    private EmFactor() {
    }

    public static EntityManagerFactory getEmf() {
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("default");
            return emf;
        } else return emf;
    }

}
