package my.apps.resttester.controller;

import my.apps.resttester.model.BlackjackTable;
import my.apps.resttester.model.iGameSurface;
import my.apps.resttester.model.iTurnManager;

public class BlackjackController implements iGameController{
    private iGameSurface table;

@Override
    public iGameSurface initializeGame(){
        table = new BlackjackTable();
        return table;
    }
    @Override
    public iGameSurface initializeTurn(iGameSurface table) {
        this.table = table;
        return table;
    }

@Override
    public iGameSurface takeTurns(iTurnManager turnManager, iGameSurface table) {
        this.table = table;
        return table;
    }

    @Override
    public iGameSurface evaluateWinCondition(iGameSurface table) {
        this.table = table;
        return table;
    }

    @Override
    public iGameSurface endGame(iGameSurface table) {
        this.table = table;
        return table;
    }
}