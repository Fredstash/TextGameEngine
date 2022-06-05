use std::fs;
pub(crate) struct Character {
    pub(crate) name: String,
    pub(crate) flash_light: bool,
    pub(crate) food: bool,
    pub(crate) sword: bool,
    pub(crate) time: i32,
    pub(crate) key: bool,
    pub(crate) room: i32,
    pub(crate) health: i32
}

// Character functions
impl Character {
    pub(crate) fn print_inventory(&mut self) {
     // Display inventory and time
        println!("{} has:", self.name.trim_end());
        if self.get_flash() { println!("Flash light") }
        if self.get_food() { println!("Food") }
        if self.get_sword() { println!("Sword") }
        if self.get_key() { println!("Key") }
        println!("Time is {}", self.time);
        println!("Health: {}", self.health)
 }
    // Getters
    pub(crate) fn get_name(&self) -> String { return self.name.to_string() }
    pub(crate) fn get_flash(&self) -> bool { return self.flash_light }
    pub(crate) fn get_food(&self) -> bool { return self.food }
    pub(crate) fn get_sword(&self) -> bool { return self.sword }
    pub(crate) fn get_time(&self) -> i32 { return self.time }
    pub(crate) fn get_key(&self) -> bool { return self.key }
    pub(crate) fn get_room(&self) -> i32 { return self.room }
    pub(crate) fn get_health(&self) -> i32 {return self.health}

    // Setters
    pub(crate) fn set_name(& mut self, name: String) { self.name = name.to_string()}
    pub(crate) fn set_flash(&mut self, flash: bool) { self.flash_light = flash }
    pub(crate) fn set_food(& mut self, food: bool) {  self.food = food }
    pub(crate) fn set_sword(& mut self, sword: bool) { self.sword = sword }
    pub(crate) fn set_time(& mut self, time: i32) { self.time = time }
    pub(crate) fn set_key(& mut self, key: bool) { self.key = key }
    pub(crate) fn set_room(& mut self, room: i32) { self.room = room }
    pub(crate) fn set_health(& mut self, health: i32) { self.health = health}

    // Get help document
    pub(crate) fn help(& self) {
        let data = fs::read_to_string("/Users/ryancox/Desktop/Applied Programming/TextGameEngine/rooms/help")
            .expect("Something went wrong reading the file");
        println!("{}", data)
    }

    // Character actions
    pub(crate) fn character_action(&mut self, action: String, directions: (bool, bool, bool, bool)) {
        if action.trim().to_lowercase() == "north" && directions.0 { self.room_number(100); println!("Going north") }
        else if action.trim().to_lowercase() == "south" && directions.1 { self.room_number(-100); println!("Going south") }
        else if action.trim().to_lowercase() == "east" && directions.2 { self.room_number(1); println!("Going east") }
        else if action.trim().to_lowercase() == "west" && directions.3 { self.room_number(-1); println!("Going west") }
        else if action.trim().to_lowercase() == "help" { self.help() }
        else if action.trim().to_lowercase() == "inv" { self.print_inventory() }
        else if action.trim().to_lowercase() == "time" {}
        else if action.trim().to_lowercase() == "quit" { std::process::exit(0) }
        else if action.trim().to_lowercase() == "save" { self.save().expect("Save failed"); }
        else { println!("I can't do that!") }
    }

    // Save character data
    pub(crate) fn save(& self) -> std::io::Result<()> {
        println!("saving");
        let new_save = format!("{} {flash} {food} {sword} {time} {key} {room} {health}",
                              self.get_name().trim(),
                              flash = self.get_flash(),
                              food = self.get_food(),
                              sword = self.get_sword(),
                              time = self.get_time(),
                              key = self.get_key(),
                              room = self.get_room(),
                              health = self.get_health());

        fs::write("/Users/ryancox/Desktop/Applied Programming/TextGameEngine/rooms/save",
                  new_save)
    }

    // Change the room the character is in.
    pub(crate)  fn room_number(&mut self, change: i32) {
        self.room += change;
    }
}