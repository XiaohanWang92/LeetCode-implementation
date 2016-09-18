public class SnakeGame {
    
    private Deque<int[]> snake;
    private int width;
    private int height;
    private int[][] food;
    private int currentFoodPos;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.food = food;
        currentFoodPos = 0;
        snake.add(new int[2]);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] currentSnakeHead = moveSnake(direction, snake.peekFirst());
        if(currentSnakeHead[0] < 0 || currentSnakeHead[0] > height - 1 ||
           currentSnakeHead[1] < 0 || currentSnakeHead[1] > width -1) {
            return -1;
        }

        // Checks if snake collides with its body, no need to check tail (last) because snake is moving
        if(snake.size() > 1) {
            int bodyNum = 1;
            for(int[] snakeBody : snake) {
                if(bodyNum < snake.size() && 
                   currentSnakeHead[0] == snakeBody[0] && currentSnakeHead[1] == snakeBody[1]) {
                    return -1;
                }
                bodyNum++;
            }
        }

        // Checks if food has been reached
        if(currentFoodPos < food.length && currentSnakeHead[0] == food[currentFoodPos][0] &&
           currentSnakeHead[1] == food[currentFoodPos][1]) {
            currentFoodPos++;
        } else {
            snake.removeLast();
        }
        snake.offerFirst(currentSnakeHead);
        return currentFoodPos;
    }
    
    private int[] moveSnake(String direction, final int[] previousSnakeHead) {
        
        // Must instantiate new int array otherwise will directly change previous snake head (object reference)
        int[] currentSnakeHead = new int[2];
        currentSnakeHead[0] = previousSnakeHead[0];
        currentSnakeHead[1] = previousSnakeHead[1];
        switch (direction) {
            case "U":
                currentSnakeHead[0] -= 1;
                break;
            case "D":
                currentSnakeHead[0] += 1;
                break;
            case "L":
                currentSnakeHead[1] -= 1;
                break;
            case "R":
                currentSnakeHead[1] += 1;
                break;
        }
        return currentSnakeHead;
    } 
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
