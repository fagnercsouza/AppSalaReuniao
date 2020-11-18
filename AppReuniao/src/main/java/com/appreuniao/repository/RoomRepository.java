package com.appreuniao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appreuniao.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

}
