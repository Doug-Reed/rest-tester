package my.apps.resttester.controller;

import my.apps.resttester.model.iGameSurface;
import my.apps.resttester.model.iTurnManager;

public interface iGameController {
    public iGameSurface initializeGame();

    public iGameSurface initializeTurn(iGameSurface gameSurface);

    public iGameSurface takeTurns(iTurnManager turnManager, iGameSurface gameSurface);

    public iGameSurface evaluateWinCondition(iGameSurface gameSurface);

    public iGameSurface endGame(iGameSurface gameSurface);

}