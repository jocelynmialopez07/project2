import javax.swing.Painter;

import edu.cymbal.graphics.CanvasAPI;
import edu.cymbal.graphics.Graphics;
import edu.cymbal.graphics.PainterAPI;
import java.awt.Color;

public class Aquarium {
    public static void main(String[] args) {
        CanvasAPI canvas = Graphics.createCanvas(800, 600, "My First Drawing");

        PainterAPI painter = canvas.getPainter();
        painter.setSpeed(10); // Lower number means faster, zero means as fast as possible.
        painter.forward(100);

    }
    // Scene

    /** 
     * Draws the whole aquarium scene
     * 
     * @param painter the painter used to draw
     */

    public static void drawScene(PainterAPI painter) {
        // Calls drawBackground
        // Calls drawJellyfish
        // Calls drawFish
        // Calls drawBubbles
        // Calls drawFlower
        // Calls drawSponge
        // Calls drawStarfish
        
    }

    /**
     * Draws water in bands from light blue to dark blue, two slanted light rays, and the sandy floor with green hills
     * 
     * @param painter the painter used to draw
     */
    public static void drawBackground(PainterAPI painter) {
        // Calls drawRectangle
        // Calls drawCircle
        // Calls drawTriangle
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

    }

    /**
     * Draws a straight line between two points
     * 
     * @param painter the painter used to draw
     * @param x1 x-coordinate of the start point
     * @param y1 y-coordinate of the start point
     * @param x2 x-coordinate of the end point
     * @param y2 y-coordinate of the end end point
     * @param color the line color
     */
    public static void drawLine(PainterAPI painter, int x1, int y1, int x2, int y2, Color color) {

    }

    // Sea creatures

    /** 
     * Draws one jellyfish: a half circle with wavy tentacles hanging below. Tentacle numbers depend on it's size
     * 
     * @param painter the painter used to draw
     * @param x x-coordinate of the center of the bell's flat edge
     * @param y y-coordinate of the center of the bell's flat edge
     * @param size radius of the bell
     * @param color the color of the jellyfish
     */
    public static void drawJellyfish(PainterAPI painter, int x, int y, int size, Color color) {
        // Calls drawCircle
        // Calls drawLine (in loop once per tentacle)
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
        // Calls drawCircle
        // Calls drawTriangle
    }

    /**
     * Draws a square sponge character with pants, eyes, a smile, legs, and an arm holding a net.
     * 
     * @param painter the painter used to draw
     * @param x x-coordinate of the center of the body
     * @param y y-coordinate of the center of the body
     * @param size width of the body
     */
    public static void drawSponge(PainterAPI painter, int x, int y, int size) {
        // Calls drawRectangle
        // Calls drawCircle
        // Calls drawLine
        // Calls drawNet
    }

    /**
     * Draws a five pointed starfish character with shorts, eyes, and an arm holding a net.
     * 
     * @param painter the painter used to draw
     * @param x x-coordinate of the center of the star
     * @param y y-coordinate of the center of the star
     * @param size distance from the center to each point
     * @param color the color of the starfish
     */
    public static void drawStarfish(PainterAPI painter, int x, int y, int size, Color color) {
        // Calls drawLine (in a loop once per point of the star)
        // Calls draw rectangle
        // Calls drawCircle
        // Calls drawNet
    }

    // Decorations

    /**
     * Draws a net: a pole with a circular loop and crossed lines for mesh
     * 
     * @param painter
     * @param x x-coordinate of bottom of the pole
     * @param y y-coordinate of bottom of pole
     * @param size length of the pole
     */
    public static void drawNet(PainterAPI painter, int x, int y, int size) {
        // Calls drawLine
        // Calls drawCircle
    }

    /**
     * Draws a column of bubbles of different sizes rising up
     * 
     * @param painter
     * @param x x-coordinate of bottom bubble
     * @param y y-coordinate of bottom bubble
     * @param count how many bubbles
     */
    public static void drawBubbles(PainterAPI painter, int x, int y, int count) {
        // Calls drawCircle in a loop once per bubble
    }

    /**
     * Draws a flower with petaks around a center circle.
     * 
     * @param painter
     * @param x x-coordinate of center of flower
     * @param y y-coordinate of center of flower
     * @param size radius of center circle
     */
    public static void drawFlower(PainterAPI painter, int x, int y, int size) {
        // Calls drawCircle in loop once per petal
        // Calls drawCircle for center
    }

}