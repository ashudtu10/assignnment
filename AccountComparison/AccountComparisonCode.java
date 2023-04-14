

interface OnlineAccount {
    //initializing with random values
    int basePrice = 100;
    int regularMoviePrice = 25;
    int exclusiveMoviePrice = 50;
}

class Account implements OnlineAccount, Comparable<Account> {
    int noOfRegularMovies;
    int noOfExclusiveMovies;
    String ownerName;

    //parameterized constructor that initializing attributes.
    public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.ownerName = ownerName;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.noOfRegularMovies = noOfRegularMovies;
    }

    // monthly cost method
    public int monthlyCost() {
        return basePrice + noOfRegularMovies * regularMoviePrice + noOfExclusiveMovies * exclusiveMoviePrice;
    }

    // overridden compareTo to compare accounts based on monthly cost
    @Override
    public int compareTo(Account account) {
        if(this.monthlyCost() > account.monthlyCost()){
            return 1;
        }
        else
            return -1;
    }

    // statement to tell monthly cost of the owner
    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
    }
}