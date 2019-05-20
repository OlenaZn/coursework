package com.olenaznak.dao;

import com.olenaznak.models.GeneralModel;

import java.util.Optional;

public interface GeneralDao {
    Optional<GeneralModel> getById(int id);
}
