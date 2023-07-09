// Class enemy inherit class character
class Enemy extends Entity{

    public Enemy(String charName, int health, int cblock) {
        setCharName(charName);
        setHealth(health);
        setCblock(cblock);
    }

    // Memperlihatkan deskripsi enemy
    @Override
    public void showDesc(){
        System.out.println("Enemy\t: "+this.getCharName());
        System.out.println("HP  \t: "+this.getHealth());
        System.out.println("Block\t: "+this.getCblock());
    }
}