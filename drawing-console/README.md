# The Problem

## Description

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit

|Command 		|Description|
|----|----|
|C w h          | Create a new canvas of width w and height h.|
|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|
|               | horizontal or vertical lines are supported. Horizontal and vertical lines|
|               | will be drawn using the 'x' character.|
|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|
|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|
|               | using the 'x' character.|
|B x y c        | Fill the entire area connected to (x,y) with "colour" c. The|
|               | behaviour of this is the same as that of the "bucket fill" tool in paint|
|               | programs.|
|Q              | Quit|

## Sample I/O

Below is a sample run of the program. User input is prefixed with enter command:


```
enter command: C 20 4
--------------------
|                  |
|                  |
|                  |
|                  |
--------------------
```
```
enter command: L 1 2 6 2
--------------------
|                  |
|xxxxxx            |
|                  |
|                  |
--------------------
```

```
enter command: L 6 3 6 4
--------------------
|                  |
|xxxxxx            |
|     x            |
|     x            |
--------------------
```

```
enter command: R 14 1 18 3
--------------------
|             xxxxx|
|xxxxxx       x   x|
|     x       xxxxx|
|     x            |
--------------------
```

```
enter command: B 10 3 o
--------------------
|oooooooooooooxxxxx|
|xxxxxxooooooox   x|
|     xoooooooxxxxx|
|     xoooooooooooo|
--------------------

enter command: Q
```

## Build

To build the executable jar, unzip the project and the run the following maven command in the project root directory:

```
$ mvn clean install
```

This will create a jar ** drawing-console.jar ** in <project root>/target/ directory.


## Run

To run the program:

```
$ java -jar drawing-console.jar
```


## Coverage

Code coverage ~ 80% by unit tests.


## Assumption

if we have passed more params than required for a particular command, program will assume it valid and process accordingly taking into first appearing valid params and if we pass less params, then it will throw exception and will be unable to process. for instance canvas command requires 2 params, if we enter like C 20 4 6, then it will be a valid and process this as C 20 4 ignoring 6.

