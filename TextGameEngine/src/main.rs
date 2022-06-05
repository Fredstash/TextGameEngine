mod character;
mod room;

use std::io::stdin;
// use std::fs;

fn main() {

    // Declare the character
    let mut character = character::Character { name: "Ryan".to_string(), flash_light: false,
        sword: false, food: false, time: 330, key: false, room: 500, health: 100 };

    let new_room = room::Room {};

    // Get player data
    println!("What is your name? ");
    let mut name = "".to_string();
    stdin().read_line(&mut name).expect("Name input failed");
    character.set_name(name);

    let mut action = "".to_string();

    // Play the game
    while action != "exit" {
        let directions = new_room.room_info(&character.get_room());
        println!("What will you do?");
        action = "".to_string();
        stdin().read_line(&mut action).expect("Input failed");
        character.character_action(action.to_string(), directions);
    }
}