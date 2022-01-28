package com.cutm.erp.fees.repository;

import com.cutm.erp.fees.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
}