import javax.swing.Painter;
import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class Aquarium {

    // Assumes (0, 0) is the center of the 800 x 600 canvas and y goes up,
    // so x runs from -400 to 400 and y runs from -300 to 300.
    // Also assumes the painter starts out facing right.

    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "My Aquarium");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(0);

        drawScene(painter);

        canvas.awaitClose();
    }

    // Scene

    /**
     * Draws the whole aquarium scene
     *
     * @param painter the painter used to draw
     */
    public static void drawScene(PainterAPI painter) {
        drawBackground(painter);
        drawJellyfish(painter, -250, 150, 30, new Color(200, 120, 220));
        drawJellyfish(painter, 200, 200, 20, new Color(255, 150, 180));
        drawFish(painter, 100, -20, 25, Color.ORANGE, true);
        drawFish(painter, -180, -100, 20, Color.RED, false);
        drawBubbles(painter, -330, -200, 6);
        drawFlower(painter, -100, -190, 10);
    }

    /**
     * Draws water in bands from light blue to dark blue, two slanted light rays, and the sandy floor with green hills
     *
     * @param painter the painter used to draw
     */
    public static void drawBackground(PainterAPI painter) {
        // Water: three bands, light to dark
        drawRectangle(painter, -400, 100, 800, 200, new Color(173, 216, 230));
        drawRectangle(painter, -400, -100, 800, 200, new Color(70, 130, 180));
        drawRectangle(painter, -400, -300, 800, 200, new Color(20, 70, 140));

        // Light rays hanging from the top
        drawTriangle(painter, -300, 300, 300, new Color(150, 200, 240));
        drawTriangle(painter, 100, 300, 250, new Color(150, 200, 240));

        // Hills, then sand on top to cover the bottom half of each hill
        drawCircle(painter, -250, -220, 80, new Color(40, 140, 60));
        drawCircle(painter, 0, -220, 100, new Color(30, 110, 50));
        drawCircle(painter, 250, -220, 70, new Color(50, 160, 70));
        drawRectangle(painter, -400, -300, 800, 80, new Color(237, 201, 140));
    }

    // Shapes

    /**
     * Draws a filled circle
     *
     * @param painter the painter used to draw
     * @param x x-coordinate of the center
     * @param y y-coordinate of the center
     * @param radius radius of the circle
     * @param color the fill color
     */
    public static void drawCircle(PainterAPI painter, int x, int y, int radius, Color color) {
        painter.liftPen();
        painter.moveTo(x, y + radius); // start at the top of the circle
        painter.lowerPen();
        painter.setPenColor(color);
        painter.startFill(color);
        for (int i = 0; i < 36; i++) {
            painter.forward(radius * 0.175); // small step
            painter.turnRight(10);           // 36 turns of 10 degrees = 360
        }
        painter.finishFill();
    }

    /**
     * Draws a filled triangle with three equal sides.
     *
     * @param painter the painter used to draw
     * @param x x-coordinate of the starting corner
     * @param y y-coordinate of the starting corner
     * @param size length of each side
     * @param color the fill color
     */
    public static void drawTriangle(PainterAPI painter, int x, int y, int size, Color color) {
        painter.liftPen();
        painter.moveTo(x, y);
        painter.lowerPen();
        painter.setPenColor(color);
        painter.startFill(color);
        for (int i = 0; i < 3; i++) {
            painter.forward(size);
            painter.turnRight(120);
        }
        painter.finishFill();
    }

    /**
     * Draws a filled rectangle
     *
     * @param painter the painter used to draw
     * @param x x-coordinate of the lower left corner
     * @param y y-coordinate of the lower left corner
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @param color the fill color
     */
    public static void drawRectangle(PainterAPI painter, int x, int y, int width, int height, Color color) {
        painter.liftPen();
        painter.moveTo(x, y);
        painter.lowerPen();
        painter.setPenColor(color);
        painter.startFill(color);
        painter.moveTo(x + width, y);
        painter.moveTo(x + width, y + height);
        painter.moveTo(x, y + height);
        painter.moveTo(x, y);
        painter.finishFill();
    }

    /**
     * Draws a straight line between two points
     *
     * @param painter the painter used to draw
     * @param x1 x-coordinate of the start point
     * @param y1 y-coordinate of the start point
     * @param x2 x-coordinate of the end point
     * @param y2 y-coordinate of the end point
     * @param color the line color
     */
    public static void drawLine(PainterAPI painter, int x1, int y1, int x2, int y2, Color color) {
        painter.liftPen();
        painter.moveTo(x1, y1);
        painter.setPenColor(color);
        painter.lowerPen();
        painter.moveTo(x2, y2);
        painter.liftPen();
    }

    // Sea creatures

    /**
     * Draws one jellyfish: a round bell with straight tentacles hanging below. Tentacle numbers depend on its size
     *
     * @param painter the painter used to draw
     * @param x x-coordinate of the center of the bell
     * @param y y-coordinate of the center of the bell
     * @param size radius of the bell
     * @param color the color of the jellyfish
     */
    public static void drawJellyfish(PainterAPI painter, int x, int y, int size, Color color) {
        drawCircle(painter, x, y, size, color);

        // One tentacle every 10 pixels across the bell, so bigger jellyfish get more
        for (int tentacleX = x - size; tentacleX <= x + size; tentacleX += 10) {
            drawLine(painter, tentacleX, y, tentacleX, y - 2 * size, color);
        }
    }

    /**
     * Draws one fish with a circle body, triangle tail, and an eye
     * It faces left or right
     *
     * @param painter the painter used to draw
     * @param x x-coordinate of the center of the body
     * @param y y-coordinate of the center of the body
     * @param size radius of the body
     * @param color the color of the fish
     * @param facingRight true if the fish faces right, false if it faces left
     */
    public static void drawFish(PainterAPI painter, int x, int y, int size, Color color, boolean facingRight) {
        if (facingRight) {
            drawTriangle(painter, x - 2 * size, y, size, color); // tail on the left
            drawCircle(painter, x, y, size, color);
            drawCircle(painter, x + 10, y + 5, 3, Color.BLACK);  // eye
        } else {
            drawTriangle(painter, x + size, y, size, color);     // tail on the right
            drawCircle(painter, x, y, size, color);
            drawCircle(painter, x - 10, y + 5, 3, Color.BLACK);  // eye
        }
    }

    // Decorations

    /**
     * Draws a column of bubbles of different sizes rising up
     *
     * @param painter the painter used to draw
     * @param x x-coordinate of bottom bubble
     * @param y y-coordinate of bottom bubble
     * @param count how many bubbles
     */
    public static void drawBubbles(PainterAPI painter, int x, int y, int count) {
        for (int i = 0; i < count; i++) {
            // Each bubble is a little higher and a little bigger than the last
            drawCircle(painter, x, y + i * 40, 5 + i * 2, new Color(220, 245, 255));
        }
    }

    /**
     * Draws a flower with petals around a center circle.
     *
     * @param painter the painter used to draw
     * @param x x-coordinate of center of flower
     * @param y y-coordinate of center of flower
     * @param size radius of center circle
     */
    public static void drawFlower(PainterAPI painter, int x, int y, int size) {
        Color pink = new Color(255, 120, 180);
        drawCircle(painter, x, y + 2 * size, size, pink); // top petal
        drawCircle(painter, x, y - 2 * size, size, pink); // bottom petal
        drawCircle(painter, x - 2 * size, y, size, pink); // left petal
        drawCircle(painter, x + 2 * size, y, size, pink); // right petal
        drawCircle(painter, x, y, size, Color.YELLOW);    // center
    }

}