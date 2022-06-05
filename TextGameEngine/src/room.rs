use std::fs;
pub(crate) struct Room {


}

impl Room {
    pub(crate) fn room_info(&self, room_number: &i32) -> (bool, bool, bool, bool) {
        // Get the room file, x is the characters current room number
        let room_format = format!("/Users/ryancox/Desktop/Applied Programming/TextGameEngine/rooms/room{x}", x = room_number);
        let data = fs::read_to_string(room_format);
        let file_data = data.unwrap();

        // Display the room info to the player
        println!("{}", file_data);
        let north: bool;
        let south: bool;
        let east: bool;
        let west: bool;

        // Search the file for keywords
        let has_north = file_data.find("NORTH");
        let has_south = file_data.find("SOUTH");
        let has_east = file_data.find("EAST");
        let has_west = file_data.find("WEST");

        // Set each boolean for the character to know directions
        if has_north != None { north = true; } else { north = false; }
        if has_south != None { south = true; } else { south = false }
        if has_east != None { east = true; } else { east = false }
        if has_west != None { west = true; } else { west = false }

        let directions = (north, south, east, west);

        // Return directions for the player
        return directions;
    }
}
