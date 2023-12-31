package com.WEB2.backend.Controller;

import com.WEB2.backend.Model.Game;
import com.WEB2.backend.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/api/games")
    Iterable<Game> getTournament(@RequestParam("id") Integer tournamentId) {

        return gameService.getGamesByTournamentId(tournamentId);
    }

    @PostMapping("/api/editGameResult")
    RedirectView editGameResult(@RequestParam("newRes") String newRes, @RequestParam("gameId") Integer gameId) {

        Optional<Game> gameOpt = gameService.getGameById(gameId);
        if (!gameOpt.isPresent()){
            System.out.println("ERROR!");
            return new RedirectView("/mytournaments");
        }
        Game game = gameOpt.get();
        game.setResult(newRes);

        Game newGame = gameService.editGame(game);
        String hash = newGame.getTournamentid().getTournamenthash();

        return new RedirectView("/tournament?hash=" + hash);
    }
}
