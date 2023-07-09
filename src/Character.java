// Class character
class Character extends Entity{
    
    public Character(String charName, int health, int cblock) {
        setCharName(charName);
        setHealth(health);
        setCblock(cblock);
    }

    // Memperlihatkan deskripsi character
    @Override
    public void showDesc(){
        System.out.println("Player\t: "+this.getCharName());
        System.out.println("HP  \t: "+this.getHealth());
        System.out.println("Block\t: "+this.getCblock());
    }
}