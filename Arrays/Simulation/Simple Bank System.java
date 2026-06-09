// T.C: O(1)
// S.C: O(n)
class Bank {
    long[] accountBalance;
    int n;
    public Bank(long[] balance) {
        n = balance.length;
        accountBalance = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 - 1 < 0 || account2 - 1 < 0 || 
            account1 - 1 >= n || account2 - 1 >= n || 
            accountBalance[account1 - 1] < money){
            return false;
        }

        accountBalance[account2 - 1] += money;
        accountBalance[account1 - 1] -= money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account - 1 < 0 || account - 1>= n){
            return false;
        }

        accountBalance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account - 1 < 0 || account - 1>= n || 
            accountBalance[account - 1] < money){
            return false;
        }

        accountBalance[account - 1] -= money;
        return true;
    }
}
