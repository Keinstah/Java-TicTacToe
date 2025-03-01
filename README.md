# Tic Tac Toe

## Overview
This is a simple Tic Tac Toe game implemented in Java using Swing. The game allows two players to play Tic Tac Toe on a 3x3 board. Players take turns clicking on empty tiles to place their symbol ("O" or "X"). The game automatically checks for winning conditions (horizontal, vertical, or diagonal) and notifies the players when someone wins or if the game results in a draw.

## Features
- **3x3 Game Board**: A grid of 3x3 buttons represents the game board.
- **Two-Player Game**: Alternating turns between two players.
- **Win Condition Checking**: Automatically checks for a win horizontally, vertically, and diagonally.
- **Draw Detection**: Notifies players if the game ends in a draw.
- **Restart Option**: Prompts players to play again after a win or a draw.

## Requirements
- Java Development Kit (JDK) 8 or later.
- A system capable of running Swing-based Java applications.

## How to Run
1. **Compile the Code**:
   ```bash
   javac TicTacToe.java
   ```
2. **Run the Program**:
   ```bash
   java TicTacToe
   ```
3. The game window will appear. Click on the tiles to start playing.

## How to Play
- **Making a Move**: Click on an empty tile to place your symbol ("O" or "X").
- **Game Flow**: The game alternates turns between players. After each move, the game checks for a win or a draw.
- **Game Over**: When a player wins or the board is full (draw), a message will be displayed and you will be asked if you want to play again.
- **Restarting the Game**: Choose to restart the game after a win or a draw, or exit the application.

## Code Structure
- **Main Class**: `TicTacToe` extends `JFrame` and implements `ActionListener` to handle button clicks.
- **Game Logic**:
  - The board is a 3x3 grid of `JButton` components.
  - The `actionPerformed` method handles tile clicks.
  - The `check` method verifies if the current move results in a win by checking horizontal, vertical, and diagonal lines.
  - If a win is detected, a dialog is displayed to announce the winner.
  - If the game ends in a draw, a dialog notifies the players.
  - Players are prompted to play again after the game concludes.

## Author
- [Your Name] (replace with your name)

## License
This project is open-source and available under the MIT License.
