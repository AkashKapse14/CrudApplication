package com.after.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.after.model.AfModel;

public interface AfDao extends JpaRepository<AfModel, Integer> {

}
