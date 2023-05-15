package Trainingstuff;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private Pokemon activatePokemons;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public Trainer(String name, Pokemon... pokemons) {
        int m = 0, h = 0,z;
        for (int x = 0; x <= pokemons.length - 2; x++) {
            z = 1 + x;
            for (; z <= pokemons.length - 1; z++) {
                if (pokemons[x].getName() == pokemons[z].getName()) {
                    for (; h <= pokemons.length - z - 2; h++) {
                        pokemons[z + h] = pokemons[z + h + 1];
                    }
                    m++;
                    h = 0;
                }
            }


        }
        Pokemon[] poke = new Pokemon[pokemons.length - m];
        for (int x = 0; x <= poke.length - 1; x++) {
            poke[x] = pokemons[x];
        }
        this.name = name;
        if (poke.length <= 6) {
            for (int x=0; x <= poke.length - 1; x++) {
                this.pokemons.add(x,poke[x]);
            }
        } else {
            for (int x=0; x <= 5; x++) {
                this.pokemons.add(x,poke[x]);
            }
        }
        activatePokemons=this.pokemons.get(0);
    }

    public void addPokemon(Pokemon... pokemons) {
        int x = 0, b = 0;
        for (Pokemon a : pokemons) {
            for (; x <= this.pokemons.size() - 1; x++) {
                if (a.getName() == this.pokemons.get(x).getName()) {
                    b = 1;
                }
            }
            x = 0;
            if (b == 0) {
                if (this.pokemons.size() < 6) {
                    this.pokemons.add(a);
                }
            }
        }

    }

    public void removePokemon(String... name) {
        int y = 0;
        for (int x = 0; x <= this.pokemons.size() - 1; x++) {
            for (; y <= name.length - 1; y++) {
                if (this.pokemons.get(x).getName().equals(name[y])) {
                    this.pokemons.remove(x);
                    break;
                }
            }
            y=0;
        }
    }

    public boolean isAlive(Pokemon poke) {
        return poke.getHP() > 0;
    }

    public boolean isAlive(String name) {
        boolean b = false;
        for (Pokemon a : pokemons) {
            if (a.getName() == name) {
                b = a.isAlive();
            }
        }
        return b;
    }

    public Pokemon getPokemon(String name) {
        Pokemon a = null;
        for (int x = 0; x <= this.pokemons.size() - 1; x++) {
            if (name == this.pokemons.get(x).getName()) {
                a = this.pokemons.get(x);
                break;
            }
        }
        return a;
    }

    public Pokemon summon() {
        Pokemon b = null;
        for (Pokemon a : this.pokemons) {
            if (a.getHP() > 0) {
                b = a;
                break;
            }
        }
        if(b!=null){
            activatePokemons = b;

        }
            this.pokemons.set(0,activatePokemons);
            return b;


    }

    public Pokemon summon(String name) {
        Pokemon b = null;
        int c=0;
        for (int x = 0; x <= this.pokemons.size() - 1; x++) {
            if (name == this.pokemons.get(x).getName()) {
                if (this.pokemons.get(x).getHP() > 0) {
                    b = this.pokemons.get(x);
                    c=x;
                }
            }
        }
        if(b!=null){
            activatePokemons = b;
        }
        this.pokemons.set(c,this.pokemons.get(0));
            this.pokemons.set(0, activatePokemons);
            return b;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pokemon getActivatePokemon() {
        return activatePokemons;
    }

    public void setActivatePokemons(Pokemon activatePokemons) {
        this.activatePokemons = activatePokemons;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
