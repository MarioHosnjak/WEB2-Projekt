package com.WEB2.backend.Service;

import com.WEB2.backend.Model.Game;
import com.WEB2.backend.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Iterable<Game> getGamesByTournamentId(Integer id){
        return gameRepository.findByTournamentidIdOrderById(id);
    }

    public Optional<Game> getGameById(Integer id){
        return gameRepository.findById(id);
    }

    public Game editGame(Game game){
        return gameRepository.save(game);
    }

    public void addGames(Game[] games) {
        for(int i = 0; i < games.length; i++){
            gameRepository.save(games[i]);
        }
        return;
    }
}
