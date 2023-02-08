package com.example.assign.util;

import com.example.assign.entity.Match;
import com.example.assign.entity.MatchPlayer;
import lombok.Getter;
import lombok.Setter;

public class RatingCalculator {
    @Getter
    @Setter
    class VisonGoldKDA{
        int KDAScore;
        int VisionScore;
        int GoldScore;
        float totalScore;
    }

    public VisonGoldKDA rating(Match match, MatchPlayer matchPlayer){
        int team = matchPlayer.getTeamId();
        VisonGoldKDA visonGoldKDA = new VisonGoldKDA();
        visonGoldKDA.setKDAScore(KDAScore(match,matchPlayer,team));
        visonGoldKDA.setVisionScore();
        visonGoldKDA.setGoldScore();
        visonGoldKDA.setTotalScore();
        return visonGoldKDA;
    }

    public int KDAScore(Match match, MatchPlayer matchPlayer, int team){
        if(team==100){
            float teamKDA=(match.getAveKill()+match.getAveAssist())/(float)match.getAveDeath();
            float hisKDA=(matchPlayer.getKill()+matchPlayer.getAssist())/(float)matchPlayer.getAssist();

        }
    }
}
