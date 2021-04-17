# Jetbrains Academy - Minesweeper

My solutions for the Jetbrains Academy Problem Minesweeper

https://hyperskill.org/projects/8

The solution is build up step by step over several stages. 
Stage 1 is the first and simple one. The following stages 
build up on the previous stages and get more and more advanced.
There are five stages in total.

Because each stage is completely independent of the previous one,
IntelliJ might show some warnings about duplicated code between 
the stages.

## Stage 1

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/8/stages/46/implement)

We just print the field with some mines set.

just execute this:

    gradle -PmainClass=stage1.MainKt run --console=plain

## Stage 2

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/8/stages/47/implement)

We ask the user for a number of mines and create a field with mines placed randomly.

just execute this:

    gradle -PmainClass=stage2.MainKt run --console=plain

    How many mines do you want on the field? 20
    ....X.XX.
    .....X...
    .X.......
    ....XX..X
    .X.....X.
    .XX...X..
    ..X..X..X
    .X...X.X.
    ........X

## Stage 3

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/8/stages/48/implement)

We create a field with randomly placed mines and set counters in all adjacent cells.

just execute this:

    gradle -PmainClass=stage3.MainKt run --console=plain

    How many mines do you want on the field? 15
    .......1X
    1211...11
    X3X1.....
    3X31.1121
    3X2..1X3X
    X21..113X
    342211.11
    XXX3X2...
    3X33X2...

## Stage 4

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/8/stages/49/implement)

We create a field with randomly placed mines, set the counters, hide the mines and let the user place markers.

just execute this:

    gradle -PmainClass=stage4.MainKt run --console=plain
    
    How many mines do you want on the field? 15
     |123456789|
    -|---------|
    1|..12.211.|
    2|..1.33.1.|
    3|11335.42.|
    4|1.3....1.|
    5|113.43321|
    6|..111.1.2|
    7|......13.|
    8|111..113.|
    9|1.1..1.21|
    -|---------|
    Set/delete mines marks (x and y coordinates): 5 1
     |123456789|
    -|---------|
    1|..12*211.|
    2|..1.33.1.|
    3|11335.42.|
    4|1.3....1.|
    5|113.43321|
    6|..111.1.2|
    7|......13.|
    8|111..113.|
    9|1.1..1.21|
    -|---------|

## Stage 5

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/8/stages/469/implement)

"We're in the endgame now"

just execute this:

    gradle -PmainClass=stage5.MainKt run --console=plain
    
    How many mines do you want on the field? 15
     |123456789|
    -|---------|
    1|#########|
    2|#########|
    3|#########|
    4|#########|
    5|#########|
    6|#########|
    7|#########|
    8|#########|
    9|#########|
    -|---------|
    Set/unset mines marks or claim a cell as free: 1 1 free
     |123456789|
    -|---------|
    1|1#1      |
    2|221      |
    3|#1 111122|
    4|2211#22##|
    5|2#4433#32|
    6|2####2221|
    7|1233322#1|
    8|11  1#322|
    9|#1  112#1|
    -|---------|
