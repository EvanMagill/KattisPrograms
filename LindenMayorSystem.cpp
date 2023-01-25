/*
  Filename   : LindenMayorSystem.cpp
  Author     : Evan Magill
  Course     : Kattis
  Date       : 2023-1-25
  Assignment : https://open.kattis.com/problems/lindenmayorsystem
  Description: Performs a given ruleset on a provided string.
*/


/************************************************************/
// System includes

#include <iostream>
#include <map>
#include <string>

/************************************************************/
// Using declarations

using std::cout;
using std::cin;
using std::map;
using std::string;

/************************************************************/

int
main () {
    map<char, string> rules;
    int numRules, numIterations;
    cin >> numRules >> numIterations;
    
    for (int rule = 0; rule < numRules; ++rule) {
        char curChar;
        string arrow, curResult;
        cin >> curChar >> arrow >> curResult;
        rules[curChar] = curResult;
    }

    string curString;
    cin >> curString;
    for (size_t iteration = 0; iteration < numIterations; ++iteration) {
        string newString = "";
        for (size_t charPosition = 0; charPosition < curString.length (); ++charPosition) {
            char curChar = curString.at (charPosition);
            if (rules.find (curChar) == rules.end ()) {
                newString += curChar;
            }else {
                newString += rules[curChar];
            }
        }
        curString = newString;
    }
    cout << curString;
    return 0;
}