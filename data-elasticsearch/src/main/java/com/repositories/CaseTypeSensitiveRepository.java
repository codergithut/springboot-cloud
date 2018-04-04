package com.repositories;

import com.domain.bean.CaseTypeSensitive;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 解放双手的接口 自动注入会自动实现各种查询操作(基础数据库版本)
 */
public interface CaseTypeSensitiveRepository extends JpaRepository<CaseTypeSensitive, Long>{
}
