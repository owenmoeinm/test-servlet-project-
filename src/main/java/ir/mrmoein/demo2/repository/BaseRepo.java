package ir.mrmoein.demo2.repository;

import ir.mrmoein.demo2.access.Locator;

public interface BaseRepo<T> extends Locator {

    void save(T user) throws RuntimeException;
    void remove(T user) throws RuntimeException;
    <V>T findByID(V value) throws RuntimeException;

}
