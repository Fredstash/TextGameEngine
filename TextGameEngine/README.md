# Overview

I used this project as an opportunity to learn how to code in Rust. After getting into classes I realized that this probably isn't the best coding language for the project I made

My project is a text based game engine. I built it on the premise of allowing game makers an easy way to populate a world and story without having to know code.
The game engine is built using a numbering system for each of the rooms, North and South move the rooms up/down 100, and East and West move the rooms up/down 1,
as displayed in the rooms' folder of this project. The game engine is built to replicate the Zork games.

The reason I wrote this code was to get a general understanding of the syntax of Rust. I built a program I had made in the past in python so that I could primarily focus on learning.


[Software Demo Video](http://youtube.link.goes.here)

# Development Environment

* I used IntelliJ as my IDE by downloading a rust extension (Don't forget to install Rust directly to your computer)

* I used the Rust language I used the std::fs, and the std::io::stdin libraries. The fs one was for reading files, and the stdin was for retrieving user input

# Useful Websites

* [Tuples in Rust documentation](https://doc.rust-lang.org/rust-by-example/primitives/tuples.html)
* [str vs String StackOverflow](https://stackoverflow.com/questions/23975391/how-to-convert-a-string-into-a-static-str)
* [Reading files in Rust documentation](https://doc.rust-lang.org/book/ch12-02-reading-a-file.html)
* [Jimmco explanation of classes (structs)](https://jimmco.medium.com/classes-in-rust-c5b72c0f0a4c)

# Future Work

* I want a function that is built to populate the text files in the correct format for the game engine to read.
* I need to make classes for enemies and objects.
* Print out the data in a better format for the user.