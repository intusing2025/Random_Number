# Falling Numbers Animation

A simple Java Swing application that animates falling numbers.

## Overview

This program creates a visual effect where 14 randomly-generated single digits (0-9) fall continuously from the top to the bottom of a window. Each time a number reaches the bottom, it repositions to a random horizontal location at the top and generates a new random digit.

## Requirements

- Java 8 or higher
- Java Swing library (included in standard Java installation)

## How to Run

1. Compile the program:
   ```bash
   javac number.java
   ```

2. Run the program:
   ```bash
   java number
   ```

3. A window will appear showing animated falling numbers. Close the window to exit.

## Features

- **14 Falling Numbers**: Multiple digits animate independently
- **Gradient Background**: Smooth color transition from dark purple to teal
- **Random Positioning**: Each number resets to a random horizontal position
- **Smooth Animation**: 1ms timer interval ensures fluid motion
- **Continuous Loop**: Numbers cycle infinitely

## Program Structure

### Main Components

- **Arrays**: `x`, `y` store positions; `dy` stores vertical velocities; `randomNum` stores displayed digits
- **Timer**: Runs at 1ms intervals to update positions and trigger repaints
- **Initialization**: Lazy initialization in `paintComponent()` ensures proper window dimensions
- **Animation Loop**: `actionPerformed()` updates positions and handles bouncing logic

## Technical Details

- **Window Size**: 600×600 pixels
- **Ball Diameter**: 40 pixels
- **Animation Speed**: 2 pixels per frame (configurable via `dy[i]`)
- **Rendering**: Custom `paintComponent()` with Graphics2D for gradient effects

## Customization

You can modify these values to change the animation:

```java
private int numBalls = 14;           // Change number of falling digits
private int diameter = 40;            // Change digit size
dy[i] = 2;                            // Change falling speed
r.nextInt(600);                       // Change horizontal spawn range
```

## Notes

- Class name should follow Java naming conventions (capitalize: `Number` instead of `number`)
- Random numbers are generated fresh for each bounce
- The gradient background updates dynamically based on window size
