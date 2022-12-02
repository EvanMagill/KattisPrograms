#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <memory>

int
lowestPrimeFactor(int n, int i, std::vector<int> &orderedPrimes) {
    int result = n;
    int checkUpTo = (int)std::sqrt(n);
    for (; orderedPrimes[i] <= checkUpTo; ++i) {
		if (n % orderedPrimes[i] == 0) {
			result = orderedPrimes[i];
			return result;
		}
		if (i + 1 == orderedPrimes.size()) {
			int nextPrime = std::max(3, orderedPrimes[i]) + 2;// Don't want even numbers (2 + 2).
			while (lowestPrimeFactor(nextPrime, i, orderedPrimes) != nextPrime) {
				nextPrime += 2;
			}
			orderedPrimes.push_back(nextPrime);
		}
	}
    return result;
}

void
populateNNPF(std::unique_ptr<int[]> &numNonPrimeFactors, std::unique_ptr<int[]> &numUniquePrimeFactors, int storedQuantity, std::vector<int> &orderedPrimes) {
    numNonPrimeFactors[1] = 1;
    numUniquePrimeFactors[1] = 0;
    for(int i = 2; i < storedQuantity; i ++) {
        int n = i;
        int numOccurrences = 0;
		int lowestPF = lowestPrimeFactor(n, 0, orderedPrimes);
		do {
			n /= lowestPF;
			++numOccurrences;
		}
		while(n % lowestPF == 0);
		numUniquePrimeFactors[i] = numUniquePrimeFactors[n] + 1;
		numNonPrimeFactors[i] = (numNonPrimeFactors[n] + numUniquePrimeFactors[n]) * (numOccurrences + 1) - numUniquePrimeFactors[i];
    }
}

int
main()
{
    std::ios::sync_with_stdio(0);
    std::cin.tie(0);
    std::vector<int> orderedPrimes;
    orderedPrimes.reserve(708);
    orderedPrimes.push_back(2);
    orderedPrimes.push_back(3);
    int storedQuantity = 2000000;
    auto NNPF = std::make_unique<int[]>(storedQuantity);
    auto NUPF = std::make_unique<int[]>(storedQuantity);
    populateNNPF(NNPF, NUPF, storedQuantity, orderedPrimes);
    int cases;
    std::cin >> cases;
    for(int i = 0; i < cases; ++i) {
        int currentNumber;
        std::cin >> currentNumber;
        std::cout << NNPF[currentNumber] << "\n";
    }
}