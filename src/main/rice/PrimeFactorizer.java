package main.rice;
/**
 * This class implements a relatively simple algorithm for computing (and printing) the
 * prime factors of a number.  At initialization, a list of primes is computed. Given a
 * number, this list is used to efficiently compute the prime factors of that number.
 */
public class PrimeFactorizer {
    //declare a private array allPrimes, represents an array contains only primes
    private int [] allPrimes;
    //declare a private integer maxNum, represents maxNumToFactorize
    private int maxNum;
    /**
     * @param maxNumToFactorize, which is a single integer representing the maximum value that this PrimeFactorizer
     * will be capable of factorizing
     * @return an array that contains only prime numbers, which are prime factorization of maxNumToFactorize
     */
    public PrimeFactorizer(int maxNumToFactorize) {
        maxNum = maxNumToFactorize;
        allPrimes = calPrimeArray(maxNumToFactorize);
    }

    private int[] calPrimeArray(int maxNumToFactorize){
        //initialize maximum prime number
        int maxPrime = (int) Math.ceil(Math.sqrt(maxNumToFactorize));
        //initialize prime candidates array
        int [] primeCandidates = new int[maxPrime - 1];
        for (int i = 2; i <= maxPrime; i++){
            primeCandidates[i - 2] = i;
        }
        int num_primes = 0;
        for(int i = 0; i < maxPrime - 1; i++){
            int candidate = primeCandidates[i];
            //as the candidate is not crossed out, it is a prime number
            if(candidate != -1){
                //count number of primes
                num_primes += 1;
                for(int j = i + 1; j < maxPrime - 1; j++){
                    //if the non-prime is crossed out, continue the loop
                    if(primeCandidates[j] == -1){
                        continue;
                    }
                    //if the number in primeCandidate is a non-prime, cross it out
                    if(primeCandidates[j] % candidate == 0){
                        primeCandidates[j] = -1;
                    }
                }
            }
        }
        // initialize primeArray that stores all the prime numbers
        int [] primeArray = new int [num_primes];
        int num_primes_updated = 0;
        //put all prime numbers into primeArray
        for(int number:primeCandidates){
            if(number != -1 &&  num_primes_updated < num_primes){
                primeArray[num_primes_updated] = number;
                num_primes_updated += 1;
            }
        }
        return primeArray;
    }

    /**
     * @param numToFactorize, number to be factorized
     * @return prime factorization of the input number, in the form of an array of prime integers
     */
    public int[] computePrimeFactorization(int numToFactorize) {
        //If the input number is less than 2 or greater than maxNumToFactorize, return null.
        if((numToFactorize < 2) || (numToFactorize > maxNum)){
            return null;
        }
        // initialize primeFactorizer
        PrimeFactorizer primeFactorizer = new PrimeFactorizer(this.maxNum);
        //initialize size of the total number of factors
        int numFactorUpperBound = (int)(Math.log(numToFactorize)/Math.log(2)) + 1;
        //initialize factorsArray
        int [] factorsArray = new int[numFactorUpperBound];
        int num_factors = 0;
        //loop through allPrimes and put prime factors of numToFactorize into factorsArray
        for(int prime:primeFactorizer.allPrimes){
            while(numToFactorize % prime == 0){
                factorsArray[num_factors] = prime;
                numToFactorize = numToFactorize / prime;
                num_factors = num_factors + 1;
            }
        }
        //every number is its own factor
        if(numToFactorize != 1){
            factorsArray[num_factors] = numToFactorize;
            num_factors = num_factors + 1;
        }
        // initialize a new array, factors
        int[] factors = new int[num_factors];
        //put every factor in factorsArray into factors
        for(int i = 0; i < num_factors; i++){
            factors[i] = factorsArray[i];
        }
        return factors;
    }
}