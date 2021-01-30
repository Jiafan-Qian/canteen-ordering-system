package com.classboxes.canteenmanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classboxes.canteenmanagementapplication.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
