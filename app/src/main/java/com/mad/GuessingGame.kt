package com.mad

import kotlin.random.Random

fun main() {
    displayGreeting()
    var playAgain: String
    do {
        play()
        println("Do you want to play again? [y/n]")
        playAgain = readln()
    } while (playAgain == "Y" || playAgain == "y")
}

/**
 * Game loop that initializes a random number and then lets the user guess
 */
fun play() {
    val number = generateRandomNumber()
    var input: String
    var guesses = 0

    println("Your number has been generated. Start guessing!")

    do {
        guesses++
        print("Your guess: ")
        input = readln()
    } while (!check(input, number))

    println("Great - you won! It took you $guesses guesses in total!")
}

/**
 * Checks if the game was won and also gives feedback upon incorrect guesses and reminds the user
 * to only enter four digit numbers if they fail to do so
 * @return True if the game was won, false if the input is incorrect or not 4 digits in length
 */
fun check(input: String, number: String): Boolean {
    if (input == number) {
        return true
    } else if (input.length != 4) {
        println("The guessed number should be four digits in length!")
        return false
    }

    var digitsCorrect = ""
    var amountCorrect = 0
    var correctPosition = 0
    for (i in input.indices) {
        if (number.contains(input[i]) && !digitsCorrect.contains(input[i])) {
            digitsCorrect += input[i]
            amountCorrect++
        }
        if (input[i] == number[i]) {
            correctPosition++
        }
    }
    println("$amountCorrect:$correctPosition")
    return false
}

/**
 * Generate a random four digit number with each digit being unique
 */
fun generateRandomNumber(): String {
    var number = ""
    while (number.length < 4) {
        val digit = Random.nextInt(0, 9).toString()
        if (!number.contains(digit)) {
            number += digit
        }
    }
    return number
}

/**
 * Greet the user upon starting the application
 */
fun displayGreeting() {
    println("I want to play a game...\n")
    println(
        "⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "⠄⠄⠄⠄⠄⠄⠄⠄⣀⣤⣴⣶⣶⣿⣿⣿⣿⣶⣶⡄⠄⠄⠄\n" +
                "⠄⠄⠄⠄⠄⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠄⠄\n" +
                "⠄⠄⠄⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠄\n" +
                "⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦\n" +
                "⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠋⠄⠄⠉⠿\n" +
                "⠄⠄⢸⣿⣿⡿⠟⠛⠛⠿⣿⣿⣿⣿⣿⣿⣿⡇⠄⣶⠒⣦⠄\n" +
                "⠄⠄⠘⣿⣿⠁⠄⣠⠒⡄⢹⣿⣿⣿⣿⣿⣿⣷⡀⠉⠉⣁⣴\n" +
                "⠄⠄⠄⣿⣿⣦⡀⠉⠊⠁⠸⣿⣿⣿⣿⣿⣿⣿⣟⣭⣿⣿⣿\n" +
                "⠄⠄⠄⣿⣿⣿⣿⣶⣶⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠄⠄⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⠄⠄⠄⠘⣿⣿⣿⡟⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉\n" +
                "⠄⠄⠄⠄⠈⢿⣿⣿⣄⠄⠉⠻⠿⠿⣛⣛⣫⣭⣿⣯⠴⠄⠄\n" +
                "⠄⠄⠄⠄⠄⠄⠙⠿⣿⣆⠄⠄⠐⣯⣿⣿⣿⣿⣿⠉⡀⠄⠄\n" +
                "⠄⠄⠄⠄⠄⠄⠄⢄⠉⢻⣷⣄⠄⠐⢄⣨⣥⣤⡷⠖⠁⠄⠄\n" +
                "⠄⠄⠄⠄⢠⠄⠄⢸⣷⣤⡀⠈⠂⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n"
    )
    println("There will appear a four digit number that has been randomly generated.")
    println(
        "It is important to know that all four digits in this numbers are unique - " +
                "so no digit will appear more than once!"
    )
    println(
        "It is your task to guess the correct number. Each wrong guess gives you helpful " +
                "information about how many digits have been guessed correctly."
    )
    println(
        "Upon guessing a number incorrectly a feedback in the form of n:m appears, where n " +
                "stands for the digits guessed correctly,\nand m represents the digits not only " +
                "guessed correctly but also with a correctly guessed position."
    )
    println("Now it's time to play the game...\n")
}