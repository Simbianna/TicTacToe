# JetBrains Academy. Project: Tic-Tac-Toe
 
## Description
Tic-tac-toe is a game played by two players on a 3x3 field.
- One of the players plays as 'X', and the other player is 'O'. 'X' plays first, then the 'O' side plays, and so on.
- The players write 'X' and 'O' on a 3x3 field.
- The first player that writes 3 'X' or 3 'O' in a straight line (including diagonals) wins.

Suppose the bottom left cell has the coordinates (1, 1) and the top right cell has the coordinates (3, 3) like in this table:
 (1, 3) (2, 3) (3, 3)
 (1, 2) (2, 2) (3, 2)
 (1, 1) (2, 1) (3, 1)
 
 ## Example

```text

---------
|       |
|       |
|       |
---------
Enter the coordinates: 2 2
---------
|       |
|   X   |
|       |
---------
Enter the coordinates: 2 2
This cell is occupied! Choose another one!
Enter the coordinates: two two
You should enter numbers!
Enter the coordinates: 1 4
Coordinates should be from 1 to 3!
Enter the coordinates: 1 3
---------
| O     |
|   X   |
|       |
---------
Enter the coordinates: 3 1
---------
| O     |
|   X   |
|     X |
---------
Enter the coordinates: 1 2
---------
| O     |
| O X   |
|     X |
---------
Enter the coordinates: 1 1
---------
| O     |
| O X   |
| X   X |
---------
Enter the coordinates: 3 2
---------
| O     |
| O X O |
| X   X |
---------
Enter the coordinates: 2 1
---------
| O     |
| O X O |
| X X X |
---------
X wins
```
