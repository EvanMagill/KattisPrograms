/*
  Filename   : ForestForTheTrees.cpp
  Author     : Evan Magill
  Course     : KATTISSSSS
  Date       : 2023-1-24
  Assignment : KAAAAATIIIIIISS https://open.kattis.com/problems/forestforthetrees
  Description: Determines visibility to belleX given point with trees at all positive integer lattice points with belleX given rectangle cut down.
*/

/************************************************************/
// System includes

#include <iostream>
#include <cmath>
#include <vector>

/************************************************************/
// Using declarations

using std::cout;
using std::cin;
using std::vector;

/************************************************************/
// Function prototypes

long
greatestCommonDivisor (long a, long b);

bool
isPointInRect (long x, long y, long rectX1, long rectY1, long rectX2, long rectY2);

/************************************************************/

int
main () {
    long belleX, belleY;
    cin >> belleX >> belleY;
    const long GCD = greatestCommonDivisor (belleX, belleY);

    // If true, no trees could be in the way. No need to check for which are cut.
    if (GCD == 1) {
        cout << "Yes";
        return 0;
    }

    long minimalX = belleX / GCD;
    long minimalY = belleY / GCD;
    long rectX1, rectY1, rectX2, rectY2;
    cin >> rectX1 >> rectY1 >> rectX2 >> rectY2;

    // If true, the first potential tree in the way has not been cut down.
    if (!isPointInRect (minimalX, minimalY, rectX1, rectY1, rectX2, rectY2)) {
        cout << "No\n" << minimalX << " " << minimalY;
        return 0;
    }

    // Both the first and last trees in the way are cut down, so all intermediate trees are also cut.
    if (isPointInRect ((GCD - 1) * minimalX, (GCD - 1) * minimalY, rectX1, rectY1, rectX2, rectY2)) {
        cout << "Yes";
        return 0;
    }

    // Now we search for the first tree in the way.
    long lowerBound = 1;
    long upperBound = GCD - 1;
    while (upperBound - lowerBound > 1) {
        long middle = (lowerBound + upperBound) / 2;
        if (isPointInRect (middle * minimalX, middle * minimalY, rectX1, rectY1, rectX2, rectY2)) {
            lowerBound = middle;
        }else {
            upperBound = middle;
        }
    }
    //upperBound now represents the first tree obstructing the view.
    cout << "No\n" << upperBound * minimalX << " " << upperBound * minimalY;
    return 0;
}

/************************************************************/

long
greatestCommonDivisor (long a, long b) {
    if (b == 0) {
        return a;
    }
    return greatestCommonDivisor (b, a % b);
}

/************************************************************/

bool
isPointInRect (long x, long y, long rectX1, long rectY1, long rectX2, long rectY2) {
    return x >= rectX1 && x <= rectX2 && y >= rectY1 && y <= rectY2;
}