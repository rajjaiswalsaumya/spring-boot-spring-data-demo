package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by rohitgupta on 3/23/16.
 */

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

    T findByIdAndDeletedAt(ID id, @NotNull Date date);

    default T findByIdWithNullableDeletedCheck(ID id, Date date) {
        if (date == null) {
            return findOne(id);
        } else {
            return findByIdAndDeletedAt(id, date);
        }
    }


}