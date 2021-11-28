# Spawn Placement

**Program Purpose**: Generate a "C" compliant header file

**Usage**: SpawnPlacement.exe SpawnLocations.csv 32 (Row Height)

**Output**: SpawnPlacements.h

## Problem Description

Sample Files Provided

SpawnLocations.csv - This file contains 32 rows x 256 columns

Program Spec -

Note: Every video game screen is represented by 20 columns by an undetermined row height.

The program looks at the first 20 columns by the total rows EX: 32
The rows are scanned top to bottom.

The program catalogs all items that are not equal 0 in a c compliant array
  
EX: Generated File

```
const short SpawnPlacement[2][3] =
{
    {1,64,128}, //First value represnts the number it finds EX: ID of the sprite it will spawn
    {4,496,144}  //Second Values are X,Y values EX: Spawn ID 4 ia at X (496) = 31x16 :Y (144) = (9x16) 
}; 
```

Math Explanations for X, Y co-ordinates

Spawn ID 4 is found 31 columns to the right of the array therefore it's X location is = 31x16 (where 16 is column width) 
Spawn ID 4 is found  9 rows from the top of the array therefore it's Y location is = 9x16 (where 16 is row height)

Important Note:
-We are aiming to catalog spawn placements on a per screen basis. 
This means the first entries in the array should be every ID found in columns 0-19 within a row range of EX: 32
-20 columns is a constant
-rows is a variable perhaps passed to the program by the user.
-One array is all that is required.