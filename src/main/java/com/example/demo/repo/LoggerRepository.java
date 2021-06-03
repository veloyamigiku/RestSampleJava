package com.example.demo.repo;

import com.example.demo.bean.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Integer> {
}
