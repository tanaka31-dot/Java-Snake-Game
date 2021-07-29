=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: tanakamu
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. Incorporate the feedback you got after
  submitting your proposal.

  1. Java Collections
  Initially I wanted to use an arraylist to store my snake but I got feedback that it might be 
  easier to use a LinkeList and indeed it was.
  I used a LinkedList<SnakeBody> to store my snake and represent the snake in my game. The head and the tail 
  were accessible through the getFirst() and getLast() methods which made it easier to move the snake and also
  check for collisions using the head. It also made it easier to grow or shrink the snake buy adding a new tail
  or removing the current tail.

  2. Testable component
  I tested Snake.java to make sure that the different methods in snake were having the desired effects on the snake
  for example move() which moves the snake.

  3. 2D Array
  I used the 2D array to represent the game state. The 2D array is also responsible for creating all the power ups. 
   My 2D array is made up of cells. Every cell on the array is either empty, contains a power up, or has a snake part.
  The positions of the snake and power ups are updated throughout the game.

  4. Inheritance and sub typing.
  Initially I wanted to use File I/O to write scores to file and read in the high scores but I got feedback that this
  would be too simple and I would need to store the whole game state so I ended up switching to inheritance and sub typing.
  I have the power up classes. The shrink snake, reverse and food classes all extend the power up class. 

=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
CellType - has cell type for empty power up or snake part.
Cell - creates empty cells for board class
Board - stores the game state as a 2D array.
Directions- Has the direction of the snake.
Food - draws the food and also affects the snake by growing it.
Game - runs the game.
GameObj - makes the game objects in the game.
PowerUp- makes the power ups in the game.
ReverseDrxn - draws the reverse power up and affects the snake by reversing direction.
RunSnake - displays the game state.
ShrinkSnake - draws the shrink component and affects the snake though shrinking.
Snake - creates and stores the snake and most methods that affect the snake for example move.
SnakeBody - creates the snake parts.
SnakeCourt - has all the logic of the game combined in it.

- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
I had issues with collisions between the snake and the power ups and the snake with itself.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  I think there is a good seperation of functionality. The private states are not accessible from outside the classes and 
  they can only be accessed using getters and they can only be changed using the setters. If give a chance to refactor I would 
  maybe combine the snake class and the board class just so that it's easier to update the board directly.


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  images:
  https://www.stickpng.com/img/miscellaneous/shapes.
