package com.classboxes.canteenmanagementapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.classboxes.canteenmanagementapplication.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
	
	Optional<Image> findByItem_ItemId(Long itemId);

}
