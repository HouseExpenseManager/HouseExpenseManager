package org.openjfx.dao;

import java.util.List;

public interface DAO<T> {
    T findByPhoneNumber(Integer id);

    List<T> selectAll();

    T delete(Integer phoneNumber);


    T insert(T model);

    T delete(T model);
}
