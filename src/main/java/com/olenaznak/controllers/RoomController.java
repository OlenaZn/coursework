package com.olenaznak.controllers;

import com.olenaznak.models.Room;
import com.olenaznak.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class RoomController {

    private RoomService roomService;


    @GetMapping(value = "/rooms")
    public ModelAndView getRooms(Authentication authentication){
        ModelAndView roomView = new ModelAndView("room");
       // User user = (User) authentication.getPrincipal();
        List<Room> rooms = roomService.getAll();

        roomView.addObject("rooms", rooms);

        return roomView;
    }

    @GetMapping(value = "/room/{1d}")
    public ModelAndView getRoom(@PathVariable("id") Integer id, Authentication authentication){
        ModelAndView roomView = new ModelAndView("/form/lecture");
        Room room = roomService.getById(id);
        roomView.addObject("room", room);

        return roomView;
    }

    @GetMapping(value = "/free-rooms")
    public ModelAndView getFreeRooms( Authentication authentication){
        ModelAndView roomView = new ModelAndView("room");
        List<Room> rooms = roomService.getRoomsWithFreeBeds();
        roomView.addObject("rooms", rooms);

        return roomView;
    }

    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }
}
