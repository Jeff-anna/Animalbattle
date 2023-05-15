package Trainingstuff;

public class BattleField {
    private Trainer trainerA;
    private Trainer trainerB;
    private int turn = 1;

    public BattleField(Trainer trainerA, Trainer trainerB) {
        this.trainerA = trainerA;
        this.trainerA.summon();
        this.trainerB = trainerB;
        this.trainerB.summon();

    }

    public void battle(String skillofa, String skillofb) {
        Skill skillofA = new Skill("d", Skill.Type.Heal, 0, 0);
        Skill skillofB = new Skill("c", Skill.Type.Heal, 0, 0);
        for (int x = 0; x <= trainerA.getActivatePokemon().getSkills().size() - 1; x++) {
            if (skillofa == trainerA.getActivatePokemon().getSkills().get(x).getName()) {
                skillofA = trainerA.getActivatePokemon().getSkills().get(x);
            }
        }
        for (int x = 0; x <= trainerB.getActivatePokemon().getSkills().size() - 1; x++) {
            if (skillofb == trainerB.getActivatePokemon().getSkills().get(x).getName()) {
                skillofB = trainerB.getActivatePokemon().getSkills().get(x);
            }
        }
        if (trainerA.getActivatePokemon().getSpeed() > trainerB.getActivatePokemon().getSpeed()) {
            if (skillofA.getPP() > 0&&trainerA.getActivatePokemon().isAlive()) {
                if (skillofA.getType() == Skill.Type.Attack) {
                    trainerA.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofA);
                    skillofA.setPP(skillofA.getPP() - 1);
                    if (trainerB.isAlive(trainerB.getActivatePokemon())) {
                        if (skillofB.getPP() > 0) {
                            if(skillofB.getType()== Skill.Type.Attack) {
                                trainerB.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                                if(!trainerA.isAlive(trainerA.getActivatePokemon())){
                                    trainerA.summon();
                                }
                            }else if(skillofB.getType()== Skill.Type.Heal){
                                trainerB.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                            }
                        }
                    } else {

                        trainerB.summon();
                    }
                }else if(skillofA.getType()== Skill.Type.Heal){
                    trainerA.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofA);
                    skillofA.setPP(skillofA.getPP() - 1);
                    if (trainerB.isAlive(trainerB.getActivatePokemon())) {
                        if (skillofB.getPP() > 0) {
                            if(skillofB.getType()== Skill.Type.Attack) {
                                trainerB.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                                if(!trainerA.isAlive(trainerA.getActivatePokemon())){
                                    trainerA.summon();
                                }
                            }else if(skillofB.getType()== Skill.Type.Heal){
                                trainerB.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                            }
                        }
                    } else {

                        trainerB.summon();
                    }
                }

            }else{
                if (trainerB.isAlive(trainerB.getActivatePokemon())) {
                    if (skillofB.getPP() > 0) {
                        if(skillofB.getType()== Skill.Type.Attack) {
                            trainerB.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofB);
                            skillofB.setPP(skillofB.getPP() - 1);
                            if(!trainerA.isAlive(trainerA.getActivatePokemon())){
                                trainerA.summon();
                            }
                        }else if(skillofB.getType()== Skill.Type.Heal){
                            trainerB.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofB);
                            skillofB.setPP(skillofB.getPP() - 1);
                        }
                    }
                } else {

                    trainerB.summon();
                }
            }
        } else if (trainerA.getActivatePokemon().getSpeed() < trainerB.getActivatePokemon().getSpeed()) {
            if (skillofB.getPP() > 0&& trainerB.getActivatePokemon().isAlive()) {
                if (skillofB.getType() == Skill.Type.Attack) {
                    trainerB.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofB);
                    skillofB.setPP(skillofB.getPP() - 1);
                    if (trainerA.isAlive(trainerA.getActivatePokemon())) {
                        if (skillofA.getPP() > 0) {
                            if(skillofA.getType()== Skill.Type.Attack) {
                                trainerA.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofA);
                                skillofA.setPP(skillofA.getPP() - 1);
                                if(!trainerB.isAlive(trainerB.getActivatePokemon())){
                                    trainerB.summon();
                                }
                            }else if(skillofA.getType()== Skill.Type.Heal){
                                trainerA.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofA);
                                skillofA.setPP(skillofA.getPP() - 1);
                            }
                        }
                    } else {
                        trainerA.summon();
                    }
                }else if(skillofB.getType()== Skill.Type.Heal){
                    trainerB.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofB);
                    skillofB.setPP(skillofB.getPP() - 1);
                    if (trainerA.isAlive(trainerA.getActivatePokemon())) {
                        if (skillofA.getPP() > 0) {
                            if(skillofA.getType()== Skill.Type.Attack) {
                                trainerA.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofA);
                                skillofA.setPP(skillofA.getPP() - 1);
                                if(!trainerB.isAlive(trainerB.getActivatePokemon())){
                                    trainerB.summon();
                                }
                            }else if(skillofA.getType()== Skill.Type.Heal){
                                trainerA.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofA);
                                skillofA.setPP(skillofA.getPP() - 1);
                            }
                        }
                    } else {

                        trainerA.summon();
                    }
                }

            }else{
                if (trainerA.isAlive(trainerA.getActivatePokemon())) {
                    if (skillofA.getPP() > 0) {
                        if(skillofA.getType()== Skill.Type.Attack) {
                            trainerA.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofA);
                            skillofA.setPP(skillofA.getPP() - 1);
                            if(!trainerB.isAlive(trainerB.getActivatePokemon())){
                                trainerB.summon();
                            }
                        }else if(skillofA.getType()== Skill.Type.Heal){
                            trainerA.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofA);
                            skillofA.setPP(skillofA.getPP() - 1);
                        }
                    }
                } else {
                    trainerA.summon();
                }
            }
        } else if (trainerA.getActivatePokemon().getSpeed() == trainerB.getActivatePokemon().getSpeed()) {
            if (skillofA.getPP() > 0&& trainerA.getActivatePokemon().isAlive()) {
                if (skillofA.getType() == Skill.Type.Attack) {
                    trainerA.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofA);
                    skillofA.setPP(skillofA.getPP() - 1);
                    if (trainerB.isAlive(trainerB.getActivatePokemon())) {
                        if (skillofB.getPP() > 0) {
                            if(skillofB.getType()== Skill.Type.Attack) {
                                trainerB.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                                if(!trainerA.isAlive(trainerA.getActivatePokemon())){
                                    trainerA.summon();
                                }
                            }else if(skillofB.getType()== Skill.Type.Heal){
                                trainerB.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                            }
                        }
                    } else {

                        trainerB.summon();
                    }
                }else if(skillofA.getType()== Skill.Type.Heal){
                    trainerA.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofA);
                    skillofA.setPP(skillofA.getPP() - 1);
                    if (trainerB.isAlive(trainerB.getActivatePokemon())) {
                        if (skillofB.getPP() > 0) {
                            if(skillofB.getType()== Skill.Type.Attack) {
                                trainerB.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                                if(!trainerA.isAlive(trainerA.getActivatePokemon())){
                                    trainerA.summon();
                                }
                            }else if(skillofB.getType()== Skill.Type.Heal){
                                trainerB.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofB);
                                skillofB.setPP(skillofB.getPP() - 1);
                            }
                        }
                    } else {

                        trainerB.summon();
                    }
                }

            }else{
                if (trainerB.isAlive(trainerB.getActivatePokemon())) {
                    if (skillofB.getPP() > 0) {
                        if(skillofB.getType()== Skill.Type.Attack) {
                            trainerB.getActivatePokemon().useSkillTo(trainerA.getActivatePokemon(), skillofB);
                            skillofB.setPP(skillofB.getPP() - 1);
                            if(!trainerA.isAlive(trainerA.getActivatePokemon())){
                                trainerA.summon();
                            }
                        }else if(skillofB.getType()== Skill.Type.Heal){
                            trainerB.getActivatePokemon().useSkillTo(trainerB.getActivatePokemon(), skillofB);
                            skillofB.setPP(skillofB.getPP() - 1);
                        }
                    }
                } else {

                    trainerB.summon();
                }
            }
        }
    turn++;
}

    public int checkWin() {
        int a = 0;
        if (trainerA.isAlive(trainerA.getActivatePokemon()) && !trainerB.isAlive(trainerB.getActivatePokemon())) {
            a = 1;
        } else if (trainerB.isAlive(trainerB.getActivatePokemon()) && !trainerA.isAlive(trainerA.getActivatePokemon())) {
            a = 2;
        }
        return a;
    }

    public String toString() {
        String b = "a";
        if (checkWin() == 1) {
            b = ("Turn " + (turn - 1) + ":\n"
                    + "Trainingstuff.Trainer " + trainerA.getName() + "'s Trainingstuff.Pokemon " + trainerA.getActivatePokemon().getName() + ": " + trainerA.getActivatePokemon().getHP() + "/" + trainerA.getActivatePokemon().getMaxHP() + "\n"
                    + "Trainingstuff.Trainer " + trainerB.getName() + "'s Trainingstuff.Pokemon " + trainerB.getActivatePokemon().getName() + ": " + trainerB.getActivatePokemon().getHP() + "/" + trainerB.getActivatePokemon().getMaxHP() + "\n"
                    + "Winner:" + trainerA.getName());
        } else if (checkWin() == 2) {
            b = ("Turn " + (turn - 1) + ":\n"
                    + "Trainingstuff.Trainer " + trainerA.getName() + "'s Trainingstuff.Pokemon " + trainerA.getActivatePokemon().getName() + ": " + trainerA.getActivatePokemon().getHP() + "/" + trainerA.getActivatePokemon().getMaxHP() + "\n"
                    + "Trainingstuff.Trainer " + trainerB.getName() + "'s Trainingstuff.Pokemon " + trainerB.getActivatePokemon().getName() + ": " + trainerB.getActivatePokemon().getHP() + "/" + trainerB.getActivatePokemon().getMaxHP() + "\n"
                    + "Winner:" + trainerB.getName());
        } else if (checkWin() == 0) {
            b = ("Turn " + (turn - 1) + ":\n"
                    + "Trainingstuff.Trainer " + trainerA.getName() + "'s Trainingstuff.Pokemon " + trainerA.getActivatePokemon().getName() + ": " + trainerA.getActivatePokemon().getHP() + "/" + trainerA.getActivatePokemon().getMaxHP() + "\n"
                    + "Trainingstuff.Trainer " + trainerB.getName() + "'s Trainingstuff.Pokemon " + trainerB.getActivatePokemon().getName() + ": " + trainerB.getActivatePokemon().getHP() + "/" + trainerB.getActivatePokemon().getMaxHP() + "\n");
        }
        return b;
    }

    public Trainer getTrainerA() {
        return trainerA;
    }

    public void setTrainerA(Trainer trainerA) {
        this.trainerA = trainerA;
    }

    public Trainer getTrainerB() {
        return trainerB;
    }

    public void setTrainerB(Trainer trainerB) {
        this.trainerB = trainerB;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
