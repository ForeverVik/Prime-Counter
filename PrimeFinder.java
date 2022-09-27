import java.util.List;
import java.util.ArrayList;

/*
 * The class PrimeFinder is a class that lets you determine whether a number is prime or not.
 * It also lets you determine all of the prime numbers between two intervals.
 * 
 * To run the program, run the program with the following arguments:
 * java PrimeFinder [lower bound] [upper bound]
 * 
 * Where lower and upper bound are numbers between 0 and 1,000,000
 */
class PrimeFinder{
    /*
     * The isPrime() method takes one whole number as an input and returns true if it is a prime number, and false otherwise.
     * Arguments: [num]
     * Accepted Input Types: int
     * Return Type: boolean
     * Conditions: Input must be an integer
     */
    public static boolean isPrime(int num){
        for(int i=2; i<=Math.floor(Math.sqrt(Math.abs(num))); i++){
            if(num % i == 0){return false;}
        }
        return true;
    }

    /*
     * The findPrimes() method takes two whole number as an input and returns an integer array of all of the primes in between those numbers.
     * Arguments: [lower] [upper]
     * Accepted Input Types: int
     * Return Type: Integer[]
     * Conditions: Inputs must be integers, [lower] must be less than or equal to [upper], [lower] and [upper] must be numbers between 0 and 1,000,000
     */
    private static Integer[] findPrimes(int lower, int upper){
        List<Integer> primesList = new ArrayList<Integer>();
        
        for(int i=lower; i<=upper; i++){
            if(isPrime(i)){primesList.add(i);}
        }

        Integer[] primes = new Integer[primesList.size()];
        primesList.toArray(primes);
        return primes;
    }   
    
    /*
     * The main() method is called whenever the program is run. The method accepts two arguments that get stored in args, the lower bound and the upper bound. After making sure these
     * arguments are able to be accepted by the isPrime() and findPrimes() methods, the main() method prints out all of the primes between the lower bound and upper bound.
     * Arguments: String[] args
     * Accepted Input Types: String
     * Return Type: void
     * Conditions: Number of arguments must be 2
     */
    public static void main(String[] args){
        try{
            boolean error = false;
            if(args.length != 2){
                System.out.println("ERROR: Incorrect amount of arguments.");
                System.out.println("USAGE: PrimeFinder [lower] [upper]");
                error = true;
            } else{
                int lower = (int) Float.parseFloat(args[0]);
                int upper = (int) Float.parseFloat(args[1]);

                if(lower < 1 || upper < 1 || lower > 1000000 || upper > 1000000){
                    System.out.println("ERROR: Lower and Upper bounds must be numbers between 1 and 1,000,000.");
                    error = true;
                } else if(upper < lower){
                    System.out.println("ERROR: Upper bound cannot be smaller than the Lower bound.");
                    error = true;
                }

                if(!error){
                    long startTime = System.nanoTime();
                    Integer[] primes = findPrimes(lower, upper);
                    for(int prime : primes){
                        if(prime == primes[primes.length-1]){
                            System.out.println(prime);
                        } else{ 
                            System.out.print(prime + ", ");
                        }
                    }
                    System.out.println("Executed in " + (System.nanoTime() - startTime)/1000000 + " ms");
                }
            }
        } catch(Exception e){
            System.out.println("ERROR: Lower and Upper bounds must be integers.");
        }
    }
}