package com.example.foxclub.repository;

import com.example.foxclub.models.Fox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoxRepository extends JpaRepository <Fox, String> {
}
