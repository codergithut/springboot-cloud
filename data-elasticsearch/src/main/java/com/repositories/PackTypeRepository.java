package com.repositories;

import com.domain.bean.PackType;
import com.domain.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 解放双手的接口 自动注入会自动实现各种查询操作(基础数据库版本)
 */
public interface PackTypeRepository extends JpaRepository<PackType, String>{

    List<PackType> findByUpdateFlag(String updateFlag);


}
