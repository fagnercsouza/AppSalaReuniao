package com.appreuniao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appreuniao.exception.ResourceNotFoundException;
import com.appreuniao.model.Room;
import com.appreuniao.repository.RoomRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/rooms")
public class RoomController {

	@Autowired
	private RoomRepository repository;
	
	@GetMapping
	public List<Room> getAll(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomByIs(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		Room room = repository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Room not found: "+id));
		
		return ResponseEntity.ok().body(room);
	}
	@PostMapping
	public Room createRoom(@RequestBody Room room) {
		return repository.save(room);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long id, @RequestBody Room roomDetails) throws ResourceNotFoundException{
		Room room = repository.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Room not fouond for this id: "+id));
		room.setName(roomDetails.getName());
		room.setDate(roomDetails.getDate());
		room.setStartHour(roomDetails.getStartHour());
		room.setEndHour(roomDetails.getEndHour());
		final Room updateRoom = repository.save(room);
		return ResponseEntity.ok(updateRoom);
	}
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		Room room = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Room not found for this id:" +id));
		repository.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
