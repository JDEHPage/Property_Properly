package com.propertyproperly.codeclan.PropertyProperlyService.Repositories.BookableItem;

import com.propertyproperly.codeclan.PropertyProperlyService.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
