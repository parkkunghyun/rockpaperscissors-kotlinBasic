package org.techtown.mybasics

import kotlin.random.Random

/**
 * 유저 정보
 * 사용자 : 박경현
 * 나이 : 26
 * 대학교: 조선대학교
 * 참가 게임: 가위바위보
 *
 * 게임 정보
 * 총 게임 횟수: 10판
 * 박경현이 이긴 횟수: 8판
 * 박경현이 진 횟수: 2판
 *
 * 사용자와 컴퓨터 변수를 만들기
 *
 *
 * 그래서 나는 입력하고 컴퓨터는 랜덤으로 셋중에 하나를 골라서 내기
 * 만약 내가 rock paper scissors 가 아닌 단어를 치면 그러면 바로 종료
 * 0 1 2
 * rock > scissors
 * scissors > paper
 * paper > rock
 *
 * 해서 마지막에 총 몇판 중 몇번 이겼고 졌습니다 알려주기
 *
 * 비긴거 따로 체크하기
 */

class User{
    var name = ""
    var age = 0
    var university = ""
    var game = "가위바위보"
    var userInput : Int? = null
    var gameWins : Int = 0
}

class Game {
    var computerInput = 0
    var gameCounts = 0;
    var sameInput = 0
}

fun main() {
    println("사용자 정보를 입력해주세요")
    print("사용자 이름: ")
    var user = User()
    user.name = readln()
    print("사용자 나이: ")
    user.age = readln().toInt()
    print("사용자 대학: ")
    user.university = readln()

    println()
    println("****************************")
    println()

    var game = Game()
    while(true) {
        if (game.gameCounts == 0) {
            println("게임을 시작하겠습니다")
        }
       else {
            println("게임을 진행하겠습니다")
        }
        print("사용자 입력해주세요: ")

        user.userInput = readln().toInt()
        if (user.userInput != 0 &&
            user.userInput != 1 &&
            user.userInput != 2) {
            break
        }
        else {
            game.computerInput = Random.nextInt(0,3)
            when(user.userInput) {
                0 -> {
                    when (game.computerInput) {
                        0 -> {
                            println("비겼습니다")
                            game.sameInput++
                        }
                        1 -> {
                            println("${user.name.toString()}님께서 졌습니다")
                        }
                        2 -> {
                            println("${user.name.toString()}님께서 이겼습니다")
                            user.gameWins++
                        }
                    }
                    game.gameCounts++
                }

                1 -> {
                    when(game.computerInput) {
                        1 -> {
                            println("비겼습니다")
                            game.sameInput++
                        }
                        2 -> {
                            println("${user.name.toString()}님께서 졌습니다")
                        }
                        0 -> {
                            println("${user.name.toString()}님께서 이겼습니다")
                            user.gameWins++
                        }
                    }
                    game.gameCounts++
                }

                2 -> {
                    when(game.computerInput) {
                        2 -> {
                            println("비겼습니다")
                            game.sameInput++
                        }
                        0 -> {
                            println("${user.name.toString()}님께서 졌습니다")
                        }
                        1 -> {
                            println("${user.name.toString()}님께서 이겼습니다")
                            user.gameWins++
                        }
                    }
                    game.gameCounts++
                }
            }
        }
        println()
    }

    println()
    printResult(user,game)
}

fun printResult(user: User, game: Game) {
    println("****************************")
    println("게임 정보")
    println("총 게임 횟수: ${game.gameCounts}")
    println("${user.name.toString()}님께서 이긴 횟수: ${user.gameWins}")
    println("${user.name.toString()}님께서 비긴 횟수: ${game.sameInput}")
    println("${user.name.toString()}님께서 진 횟수: ${game.gameCounts - user.gameWins - game.sameInput}")

    val lose = game.gameCounts - user.gameWins - game.sameInput

    if (user.gameWins > (lose + game.sameInput)) {
        println("${user.name.toString()}님께서 더 많이 이겼습니다!")
    } else {
        println("${user.name.toString()}님께서 더 많이 졌습니다...")
    }
    println("****************************")
}