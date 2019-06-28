package my.apps.resttester.model;

public class Player {
    private String name;
    private double startingBankroll;
    private double currentBankroll;
    private boolean dealer = false;

    public String getName(){
        return this.name;
    }

    public double getStartingBankroll(){
        return this.startingBankroll;
    }

    public double getCurrentBankroll(){
        return this.currentBankroll;
    }

    public boolean isDealer(){
        return this.dealer;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStartingBankroll(double bankroll){
        this.startingBankroll = bankroll;
    }

    public void setCurrentBankroll(double bankroll) {
        this.currentBankroll = bankroll;
    }

    public void setDealer(boolean isDealer) {
        this.dealer = isDealer;
    }
}